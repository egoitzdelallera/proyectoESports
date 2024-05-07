CREATE OR REPLACE PROCEDURE crear_jornadas_competicion 
    (p_id_competicion IN COMPETICIONES.ID_COMPETICION%TYPE)
AS
    v_total_equipos INTEGER;
    v_total_jornadas INTEGER;
    v_total_enfrentamientos INTEGER;
    v_existe_enfrentamiento INTEGER;
BEGIN
    -- Contar el total de equipos inscritos en la competición
    SELECT COUNT(*) INTO v_total_equipos
    FROM PARTICIPACIONES
    WHERE ID_COMPETICION = p_id_competicion;

    -- Calcular el total de jornadas necesarias
    v_total_jornadas := v_total_equipos - 1;

    -- Contar el total de enfrentamientos ya registrados
    SELECT COUNT(*) INTO v_total_enfrentamientos
    FROM ENFRENTAMIENTOS
    WHERE ID_JORNADA IN 
        (SELECT ID_JORNADA
         FROM JORNADAS
         WHERE ID_COMPETICION = p_id_competicion);

    -- Si no se han registrado enfrentamientos
    IF v_total_enfrentamientos = 0 THEN
        FOR i IN 1..v_total_jornadas LOOP
            -- Crear una nueva jornada
            INSERT INTO JORNADAS (ID_JORNADA, N_JORNADA, FECHA_JORNADA, ID_COMPETICION)
            VALUES (JORNADAS_SEQ.NEXTVAL, i, SYSDATE + i, p_id_competicion);
        
            -- Obtener los equipos para esta jornada
            FOR e1 IN (SELECT ID_EQUIPO
                       FROM PARTICIPACIONES
                       WHERE ID_COMPETICION = p_id_competicion) LOOP
                FOR e2 IN (SELECT ID_EQUIPO
                           FROM PARTICIPACIONES
                           WHERE ID_COMPETICION = p_id_competicion
                             AND ID_EQUIPO > e1.ID_EQUIPO) LOOP
                    -- Verificar que no se repitan los enfrentamientos
                    SELECT COUNT(*) INTO v_existe_enfrentamiento
                    FROM ENFRENTAMIENTOS
                    WHERE (ID_EQUIPO_LOCAL = e1.ID_EQUIPO AND ID_EQUIPO_VISITANTE = e2.ID_EQUIPO)
                       OR (ID_EQUIPO_LOCAL = e2.ID_EQUIPO AND ID_EQUIPO_VISITANTE = e1.ID_EQUIPO);
                    
                    IF v_existe_enfrentamiento = 0 THEN
                        -- Insertar el enfrentamiento
                        INSERT INTO ENFRENTAMIENTOS (ID_ENFRENTAMIENTO, HORA, ID_JORNADA, ID_EQUIPO_LOCAL, ID_EQUIPO_VISITANTE)
                        VALUES (ENFRENTAMIENTOS_SEQ.NEXTVAL, SYSTIMESTAMP, i, e1.ID_EQUIPO, e2.ID_EQUIPO);
                    END IF;
                END LOOP;
            END LOOP;
        END LOOP;
    END IF;
    
    COMMIT;
    
    DBMS_OUTPUT.PUT_LINE('Jornadas creadas para la competición ' || p_id_competicion || '.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error al crear las jornadas: ' || SQLERRM);
END;
/

CREATE OR REPLACE TRIGGER cambiar_estado_competicion
AFTER UPDATE OF ESTADO ON COMPETICIONES
FOR EACH ROW
BEGIN
    IF :NEW.ESTADO = 1 AND :OLD.ESTADO = 0 THEN
        crear_jornadas_competicion(:NEW.ID_COMPETICION);
    END IF;
END;
/
