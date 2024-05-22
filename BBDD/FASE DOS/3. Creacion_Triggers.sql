-- CONTROLAR QUE EL NUMERO DE JUGADORES EST� ENTRE 2 Y 6

CREATE OR REPLACE TRIGGER controlar_max_jugadores
FOR INSERT OR UPDATE ON JUGADORES
COMPOUND TRIGGER
    v_cantidad_jugadores NUMBER;
    v_id_equipo number(2);

    BEFORE EACH ROW IS
    begin
      v_id_equipo := :new.id_equipo;
    end before each row;
    
    after statement is
    begin
        SELECT COUNT(*)
        INTO v_cantidad_jugadores
        FROM jugadores
        WHERE id_equipo = v_id_equipo;

        IF v_cantidad_jugadores >= 6 THEN
            RAISE_APPLICATION_ERROR(-20011, 'No se pueden agregar m�s de 6 jugadores en un equipo');
        END IF;
    end after statement;
    
END controlar_max_jugadores;
/

-- CONTROLAR QUE HAYA POR LO MENOS UN ENTRENADOR POR EQUIPO

CREATE OR REPLACE TRIGGER controlar_entrenador
    FOR INSERT OR UPDATE ON participaciones
    COMPOUND TRIGGER
    v_num_entrenadores NUMBER;
    v_new_equipo NUMBER;
BEFORE EACH ROW IS
BEGIN
    v_new_equipo := :new.id_equipo;
END BEFORE EACH ROW;

    AFTER STATEMENT IS
    BEGIN
        SELECT COUNT(*)
        INTO v_num_entrenadores
        FROM staff
        WHERE id_equipo = v_new_equipo
          AND puesto = 'Entrenador';

        -- Excepci�n en caso de que el n�mero de entrenadores sea 0
        IF v_num_entrenadores = 0 THEN
            RAISE_APPLICATION_ERROR(-20014, 'Debe haber al menos un entrenador en cada equipo');
        END IF;
    END AFTER STATEMENT;
    END controlar_entrenador;
/

-- CONTROLAR QUE EL NUMERO DE EQUIPOS EN LA COMPETICION ES PAR

CREATE OR REPLACE TRIGGER controlar_numero_equipos
BEFORE INSERT OR UPDATE ON competiciones
FOR EACH ROW
DECLARE
    v_num_equipos NUMBER;
BEGIN
    -- Contar el n�mero de equipos participantes en la competici�n
    SELECT COUNT(*)
    INTO v_num_equipos
    FROM participaciones
    WHERE id_competicion = :NEW.id_competicion;

    -- Excepci�n en caso de que el n�mero de equipos sea impar
    IF MOD(v_num_equipos, 2) <> 0 THEN
        RAISE_APPLICATION_ERROR(-20016, 'El n�mero de equipos en una competici�n
        debe ser par');
    END IF;
END;
/

-- CONTROLAR QUE LA SUMA DE SUELDOS DE UN EQUIPO NO SUPERE LOS 20000�

CREATE OR REPLACE TRIGGER CONTROLAR_SUELDO_EQUIPO
FOR INSERT OR UPDATE ON JUGADORES
COMPOUND TRIGGER
    v_sueldo_total NUMBER;
	v_new_equipo number(2);

    BEFORE EACH ROW IS
    BEGIN
        v_new_equipo := :new.id_equipo;
    END BEFORE EACH ROW;

    AFTER STATEMENT IS
    BEGIN
        SELECT SUM(sueldo)
        INTO v_sueldo_total
        FROM JUGADORES
        WHERE ID_EQUIPO = v_new_equipo;

        IF v_sueldo_total > 200000 THEN
            RAISE_APPLICATION_ERROR(-20002, 'El sueldo total del equipo no puede superar los 200000');
        END IF;
    END AFTER STATEMENT;
END CONTROLAR_SUELDO_EQUIPO;
/



-- CONTROLAR CAMBIOS CUANDO LA COMPETICION ESTE CERRADA

CREATE OR REPLACE TRIGGER competicion_cerrada_insert_eq
BEFORE INSERT OR UPDATE ON equipos
FOR EACH ROW
DECLARE
    v_estado competiciones.estado%TYPE;
BEGIN
    -- Verificar si la competición está abierta o cerrada
    verificar_competicion(:NEW.id_equipo, v_estado);
    
    -- Excepción en caso de que la competición esté cerrada
    IF v_estado = 1 THEN
        RAISE_APPLICATION_ERROR(-20001, 'No se puede realizar esta operación porque la competición está cerrada.');
    END IF;
END;
/

CREATE OR REPLACE TRIGGER competicion_cerrada_delete_eq
BEFORE DELETE ON equipos
FOR EACH ROW
DECLARE
    v_estado competiciones.estado%TYPE;
BEGIN
    -- Obtener el estado de la competición
    verificar_competicion(:OLD.id_equipo, v_estado);

    -- Excepción en caso de que la competición esté cerrada
    IF v_estado = 1 THEN
        RAISE_APPLICATION_ERROR(-20002, 'No se puede eliminar este registro porque la competición está cerrada.');
    END IF;
END;
/

CREATE OR REPLACE TRIGGER competicion_cerrada_insert_ju
BEFORE INSERT OR UPDATE ON jugadores
FOR EACH ROW
DECLARE
    v_estado competiciones.estado%TYPE;
BEGIN
    -- Obtener el estado de la competición
    verificar_competicion(:NEW.id_equipo, v_estado);
    
    -- Excepción en caso de que la competición esté cerrada
    IF v_estado = 1 THEN
        RAISE_APPLICATION_ERROR(-20003, 'No se puede realizar esta operación porque la competición está cerrada.');
    END IF;
END;
/

CREATE OR REPLACE TRIGGER competicion_cerrada_delete_ju
BEFORE DELETE ON jugadores
FOR EACH ROW
DECLARE
    v_estado competiciones.estado%TYPE;
BEGIN
    -- Obtener el estado de la competición
    verificar_competicion(:OLD.id_equipo, v_estado);

    -- Excepción en caso de que la competición esté cerrada
    IF v_estado = 1 THEN
        RAISE_APPLICATION_ERROR(-20004, 'No se puede eliminar este registro porque la competición está cerrada.');
    END IF;
END;
/

CREATE OR REPLACE PROCEDURE crear_jornadas_competicion 
    (p_id_competicion IN COMPETICIONES.ID_COMPETICION%TYPE)
AS
    v_total_equipos INTEGER;
    v_total_jornadas INTEGER;
    v_enfrentamientos_por_jornada INTEGER;
    v_jornada INTEGER;
    v_enfrentamiento_existe INTEGER;
    v_fecha_jornada DATE;
    v_hora_enfrentamiento TIMESTAMP;
BEGIN
    -- Contar los equipos
    SELECT COUNT(*) INTO v_total_equipos
    FROM PARTICIPACIONES
    WHERE ID_COMPETICION = p_id_competicion;

    -- Calcular el total de jornadas necesarias
    v_total_jornadas := v_total_equipos - 1;

    -- Calcular el total de enfrentamientos por jornada
    v_enfrentamientos_por_jornada := CEIL(v_total_equipos / 2);

    -- Crear jornadas
    FOR i IN 1..v_total_jornadas LOOP
        -- Crear una nueva jornada
        v_fecha_jornada := SYSDATE + (i * 7);  -- Incrementa la fecha de la jornada en semanas
        INSERT INTO JORNADAS (ID_JORNADA, N_JORNADA, FECHA_JORNADA, ID_COMPETICION)
        VALUES (JORNADAS_SEQ.NEXTVAL, i, v_fecha_jornada, p_id_competicion);
        
        v_jornada := JORNADAS_SEQ.CURRVAL;
        v_hora_enfrentamiento := TO_TIMESTAMP(v_fecha_jornada || ' 09:00:00', 'DD-MON-YYYY HH24:MI:SS');  -- Inicio a las 9 AM

        -- Inicializar el contador de enfrentamientos para la jornada actual
        DECLARE
            v_enfrentamientos_insertados INTEGER := 0;
        BEGIN
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
                    WHERE ID_JORNADA IN (
                        SELECT ID_JORNADA
                        FROM JORNADAS
                        WHERE ID_COMPETICION = p_id_competicion
                    )
                    AND ((ID_EQUIPO_LOCAL = e1.ID_EQUIPO AND ID_EQUIPO_VISITANTE = e2.ID_EQUIPO)
                        OR (ID_EQUIPO_LOCAL = e2.ID_EQUIPO AND ID_EQUIPO_VISITANTE = e1.ID_EQUIPO));

                    -- Insertar el enfrentamiento si no se ha jugado antes
                    IF v_enfrentamiento_existe = 0 THEN
                        INSERT INTO ENFRENTAMIENTOS (ID_ENFRENTAMIENTO, HORA, ID_JORNADA, ID_EQUIPO_LOCAL, ID_EQUIPO_VISITANTE)
                        VALUES (ENFRENTAMIENTOS_SEQ.NEXTVAL, v_hora_enfrentamiento, v_jornada, e1.ID_EQUIPO, e2.ID_EQUIPO);
                        
                        -- Incrementar la hora del enfrentamiento en 1 hora
                        v_hora_enfrentamiento := v_hora_enfrentamiento + INTERVAL '1' HOUR;
                        
                        -- Incrementar el contador de enfrentamientos insertados
                        v_enfrentamientos_insertados := v_enfrentamientos_insertados + 1;
                        
                        -- Salir del bucle si se alcanza el número de enfrentamientos por jornada
                        IF v_enfrentamientos_insertados = v_enfrentamientos_por_jornada THEN
                            EXIT;
                        END IF;
                    END IF;
                END LOOP;
                -- Salir del bucle externo si se alcanza el número de enfrentamientos por jornada
                EXIT WHEN v_enfrentamientos_insertados = v_enfrentamientos_por_jornada;
            END LOOP;
        END;
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
