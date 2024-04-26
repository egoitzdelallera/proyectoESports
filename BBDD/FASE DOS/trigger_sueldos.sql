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
