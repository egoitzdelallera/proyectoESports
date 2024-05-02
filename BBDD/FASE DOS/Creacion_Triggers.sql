
/*CONTROLAR QUE EL NUMERO DE JUGADORES ESTÁ ENTE 2 Y 6*/

CREATE OR REPLACE TRIGGER controlar_max_jugadores
BEFORE INSERT OR UPDATE ON jugador
FOR EACH ROW
DECLARE
    v_cantidad_jugadores number;
BEGIN
    -- Hacemos el select para saber cuantos jugadores hay de cada equipo
    SELECT COUNT(*)
    INTO v_cantidad_jugadores
    FROM jugador
    WHERE id_equipo = :new.id_equipo;

    IF v_cantidad_jugadores >= 6 THEN
        raise_application_error(-20011, 'No se pueden agregar mas de 6 jugadores
        en un equipo');
    END IF;
END;


CREATE OR REPLACE TRIGGER controlar_min_jugadores
BEFORE INSERT ON ENFRENTAMIENTO
FOR EACH ROW
DECLARE
    v_num_jugadores_local NUMBER;
    v_num_jugadores_visitante NUMBER;
BEGIN
    -- Comprobar el número de jugadores en el equipo local
    SELECT COUNT(*) INTO v_num_jugadores_local 
    FROM JUGADOR WHERE ID_EQUIPO = :NEW.ID_EQUIPO_LOCAL;

    -- Comprobar el número de jugadores en el equipo visitante
    SELECT COUNT(*) INTO v_num_jugadores_visitante 
    FROM JUGADOR WHERE ID_EQUIPO = :NEW.ID_EQUIPO_VISITANTE;

    -- Si algún equipo tiene menos de 2 jugadores, lanzar una excepción
    IF v_num_jugadores_local < 2 OR v_num_jugadores_visitante < 2 THEN
        RAISE_APPLICATION_ERROR(-20012, 'Todos los equipos deben tener al menos 
        2 jugadores para generar el calendario');
    END IF;
END;

/*CONTROLAR QUE HAYA POR LO MENOS UN ENTRENADOR POR EQUIPO*/

CREATE OR REPLACE TRIGGER controlar_entrenador
BEFORE INSERT OR UPDATE ON Participaciones
DECLARE
    v_num_entrenadores NUMBER;
BEGIN
    -- Contar el numero de entrenadores del equipo
    SELECT COUNT(*) INTO v_num_entrenadores
    FROM Staff
    WHERE id_equipo = :NEW.id_equipo
    AND puesto = 'Entrenador';

    -- Excepcion en caso de que el numero de entrenadores sea 0
    IF v_num_entrenadores = 0 THEN
        RAISE_APPLICATION_ERROR(-20014, 'Debe haber al menos un entrenador en 
        cada equipo');
    END IF;
END;

/*CONTROLAR QUE EL NUMERO DE EQUIPOS EN LA COMPETICION ES PAR*/

CREATE OR REPLACE TRIGGER controlar_numero_equipos
BEFORE INSERT OR UPDATE ON Competiciones
FOR EACH ROW
DECLARE
    v_num_equipos NUMBER;
BEGIN
    -- Contar el número de equipos participantes en la competicion
    SELECT COUNT(*) INTO v_num_equipos
    FROM Participaciones
    WHERE id_competicion = :NEW.id_competicion;

    -- Excepcion en caso de que el numero de equipos sea impar
    IF MOD(v_num_equipos, 2) <> 0 THEN
        RAISE_APPLICATION_ERROR(-20016, 'El numero de equipos en una competicion
        debe ser par');
    END IF;
END;

/*CONTROLAR QUE LA SUMA DE SUELDOS DE UN EQUIPO NO SUPERE LOS 20000€*/

CREATE OR REPLACE TRIGGER controlar_sueldo_equipo
BEFORE INSERT OR UPDATE ON Jugadores
FOR EACH ROW
DECLARE
    v_sueldo_total NUMBER;
BEGIN
    -- Calculo de la suma de sueldos de los jugadores del equipo
    SELECT SUM(sueldo) INTO v_sueldo_total
    FROM Jugadores
    WHERE id_equipo = :NEW.id_equipo;

    -- Excepcion en caso de que la suma de sueldos supere los 200000
    IF v_sueldo_total + NVL(:NEW.sueldo, 0) > 200000 THEN
        RAISE_APPLICATION_ERROR(-20015, 'La suma de los sueldos de los jugadores
        no puede superar los 200.000 euros');
    END IF;
END;


/*CONTROLAR CAMBIOS CUANDO LA COMPETICION ESTE CERRADA*/


CREATE OR REPLACE TRIGGER competicion_cerrada_insert
BEFORE INSERT OR UPDATE ON EQUIPOS
FOR EACH ROW
DECLARE
    v_estado COMPETICIONES.ESTADO%TYPE;
BEGIN

    SELECT ESTADO INTO v_estado
    FROM COMPETICIONES
    WHERE ID_COMPETICION = :NEW.ID_COMPETICION;


    IF v_estado = 1 THEN
        RAISE_APPLICATION_ERROR(-20001, 'No se puede realizar esta operación 
        porque la competición está cerrada.');
    END IF;
END;

CREATE OR REPLACE TRIGGER competicion_cerrada_delete
BEFORE DELETE ON EQUIPOS
FOR EACH ROW
DECLARE
    v_estado COMPETICIONES.ESTADO%TYPE;
BEGIN

    SELECT ESTADO INTO v_estado
    FROM COMPETICIONES
    WHERE ID_COMPETICION = :OLD.ID_COMPETICION;


    IF v_estado = 1 THEN
        RAISE_APPLICATION_ERROR(-20002, 'No se puede eliminar este registro 
        porque la competición está cerrada.');
    END IF;
END;




    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    