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
/

