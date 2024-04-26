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
/

