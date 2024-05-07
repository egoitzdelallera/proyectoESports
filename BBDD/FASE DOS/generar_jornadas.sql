CREATE OR REPLACE PROCEDURE crear_jornadas_competicion 
    (p_id_competicion IN COMPETICIONES.ID_COMPETICION%TYPE)
AS
    v_total_equipos INTEGER;
    v_total_jornadas INTEGER;
    v_enfrentamientos_por_jornada INTEGER;
    v_jornada INTEGER := 1;
    v_enfrentamiento_existe INTEGER;
BEGIN
    -- Contar el total de equipos inscritos en la competición
    SELECT COUNT(*) INTO v_total_equipos
    FROM PARTICIPACIONES
    WHERE ID_COMPETICION = p_id_competicion;

    -- Calcular el total de jornadas necesarias
    v_total_jornadas := v_total_equipos - 1;

    -- Calcular el total de enfrentamientos por jornada
    v_enfrentamientos_por_jornada := CEIL(v_total_equipos / 2);

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
                -- Verificar si el enfrentamiento ya existe
                SELECT COUNT(*) INTO v_enfrentamiento_existe
                FROM ENFRENTAMIENTOS
                WHERE (ID_EQUIPO_LOCAL = e1.ID_EQUIPO AND ID_EQUIPO_VISITANTE = e2.ID_EQUIPO)
                   OR (ID_EQUIPO_LOCAL = e2.ID_EQUIPO AND ID_EQUIPO_VISITANTE = e1.ID_EQUIPO);

                -- Insertar el enfrentamiento si no se ha jugado antes
                IF v_enfrentamiento_existe = 0 THEN
                    INSERT INTO ENFRENTAMIENTOS (ID_ENFRENTAMIENTO, HORA, ID_JORNADA, ID_EQUIPO_LOCAL, ID_EQUIPO_VISITANTE)
                    VALUES (ENFRENTAMIENTOS_SEQ.NEXTVAL, SYSTIMESTAMP, v_jornada, e1.ID_EQUIPO, e2.ID_EQUIPO);
                END IF;
            END LOOP;
        END LOOP;
        v_jornada := v_jornada + 1;
    END LOOP;
    
    DBMS_OUTPUT.PUT_LINE('Jornadas creadas para la competición ' || p_id_competicion || '.');
EXCEPTION
    WHEN OTHERS THEN
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
