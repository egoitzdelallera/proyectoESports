-- CONTROLAR QUE EL NUMERO DE JUGADORES EST� ENTRE 2 Y 6

CREATE OR REPLACE TRIGGER controlar_max_jugadores
BEFORE INSERT OR UPDATE ON jugadores
FOR EACH ROW
DECLARE
    v_cantidad_jugadores NUMBER;
BEGIN
    -- Hacemos el select para saber cu�ntos jugadores hay de cada equipo
    SELECT COUNT(*)
    INTO v_cantidad_jugadores
    FROM jugadores
    WHERE id_equipo = :new.id_equipo;

    -- Verificar si la cantidad de jugadores supera el l�mite
    IF v_cantidad_jugadores >= 6 THEN
        RAISE_APPLICATION_ERROR(-20011, 'No se pueden agregar m�s de 6 jugadores
        en un equipo');
    END IF;
END;
/

-- CONTROLAR QUE HAYA POR LO MENOS UN ENTRENADOR POR EQUIPO

CREATE OR REPLACE TRIGGER controlar_entrenador
BEFORE INSERT OR UPDATE ON participaciones
FOR EACH ROW
DECLARE
    v_num_entrenadores NUMBER;
BEGIN
    -- Contar el n�mero de entrenadores del equipo en la competici�n
    SELECT COUNT(*)
    INTO v_num_entrenadores
    FROM staff
    WHERE id_equipo = :NEW.id_equipo
    AND puesto = 'Entrenador';

    -- Excepci�n en caso de que el n�mero de entrenadores sea 0
    IF v_num_entrenadores = 0 THEN
        RAISE_APPLICATION_ERROR(-20014, 'Debe haber al menos un entrenador en 
        cada equipo');
    END IF;
END;
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

CREATE OR REPLACE TRIGGER controlar_sueldo_equipo
BEFORE INSERT OR UPDATE ON jugadores
FOR EACH ROW
DECLARE
    v_sueldo_total NUMBER;
BEGIN
    -- Calculo de la suma de sueldos de los jugadores del equipo
    SELECT SUM(sueldo)
    INTO v_sueldo_total
    FROM jugadores
    WHERE id_equipo = :NEW.id_equipo;

    -- Excepci�n en caso de que la suma de sueldos supere los 20000�
    IF v_sueldo_total + NVL(:NEW.sueldo, 0) > 200000 THEN
        RAISE_APPLICATION_ERROR(-20015, 'La suma de los sueldos de los jugadores
        no puede superar los 20.000 euros');
    END IF;
END;
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