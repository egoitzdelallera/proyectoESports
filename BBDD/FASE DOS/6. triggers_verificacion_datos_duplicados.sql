-- Trigger para evitar nombres de juegos duplicados
CREATE OR REPLACE TRIGGER juegos_nombre_duplicate
BEFORE INSERT OR UPDATE ON juegos
FOR EACH ROW
DECLARE
    v_count NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_count
    FROM juegos
    WHERE UPPER(nombre) = UPPER(:NEW.nombre);
    
    IF v_count > 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Ya existe un juego con ese nombre.');
    END IF;
END;
/

-- Trigger para evitar nombres de equipos duplicados
CREATE OR REPLACE TRIGGER equipos_nombre_duplicate
BEFORE INSERT OR UPDATE ON equipos
FOR EACH ROW
DECLARE
    v_count NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_count
    FROM equipos
    WHERE UPPER(nombre) = UPPER(:NEW.nombre);
    
    IF v_count > 0 THEN
        RAISE_APPLICATION_ERROR(-20002, 'Ya existe un equipo con ese nombre.');
    END IF;
END;
/

-- Compound Trigger para evitar nombres de competiciones duplicados
CREATE OR REPLACE TRIGGER competiciones_nombre_duplicate
FOR INSERT OR UPDATE ON competiciones
COMPOUND TRIGGER

    -- Variable para almacenar los nombres de las competiciones nuevos o actualizados
    TYPE t_competicion IS RECORD (
        nombre COMPETICIONES.NOMBRE%TYPE,
        id_competicion COMPETICIONES.ID_COMPETICION%TYPE
    );
    v_competiciones t_competicion;

    -- BEFORE EACH ROW: Captura los datos de cada fila nueva o actualizada
    BEFORE EACH ROW IS
    BEGIN
        v_competiciones.nombre := :NEW.NOMBRE;
        v_competiciones.id_competicion := :NEW.ID_COMPETICION;
    END BEFORE EACH ROW;

    -- AFTER STATEMENT: Realiza la verificación después de que todas las filas hayan sido procesadas
    AFTER STATEMENT IS
    BEGIN
        DECLARE
            v_count INTEGER;
        BEGIN
            SELECT COUNT(*)
            INTO v_count
            FROM COMPETICIONES
            WHERE UPPER(nombre) = UPPER(v_competiciones.nombre)
            AND id_competicion != v_competiciones.id_competicion;

            IF v_count > 0 THEN
                RAISE_APPLICATION_ERROR(-20003, 'Ya existe una competición con ese nombre.');
            END IF;
        END;
    END AFTER STATEMENT;

END competiciones_nombre_duplicate;
/


-- Trigger para evitar nombres de jugadores duplicados
CREATE OR REPLACE TRIGGER jugadores_nombre_duplicate
BEFORE INSERT OR UPDATE ON jugadores
FOR EACH ROW
DECLARE
    v_count NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_count
    FROM jugadores
    WHERE UPPER(nombre) = UPPER(:NEW.nombre);
    
    IF v_count > 0 THEN
        RAISE_APPLICATION_ERROR(-20004, 'Ya existe un jugador con ese nombre.');
    END IF;
END;
/

-- Trigger para evitar nombres de staff duplicados
CREATE OR REPLACE TRIGGER staff_nombre_duplicate
BEFORE INSERT OR UPDATE ON staff
FOR EACH ROW
DECLARE
    v_count NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_count
    FROM staff
    WHERE UPPER(nombre) = UPPER(:NEW.nombre);
    
    IF v_count > 0 THEN
        RAISE_APPLICATION_ERROR(-20005, 'Ya existe un miembro del staff con ese nombre.');
    END IF;
END;
/

-- Trigger para evitar nombres de patrocinadores duplicados
CREATE OR REPLACE TRIGGER patrocinadores_duplicado
BEFORE INSERT OR UPDATE ON patrocinadores
FOR EACH ROW
DECLARE
    v_count NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_count
    FROM patrocinadores
    WHERE UPPER(nombre) = UPPER(:NEW.nombre);
    
    IF v_count > 0 THEN
        RAISE_APPLICATION_ERROR(-20006, 'Ya existe un patrocinador con ese nombre.');
    END IF;
END;
/

-- Trigger para evitar nombres de usuarios duplicados
CREATE OR REPLACE TRIGGER usuarios_nombre_duplicate
BEFORE INSERT OR UPDATE ON usuarios
FOR EACH ROW
DECLARE
    v_count NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_count
    FROM usuarios
    WHERE UPPER(nombre) = UPPER(:NEW.nombre);
    
    IF v_count > 0 THEN
        RAISE_APPLICATION_ERROR(-20007, 'Ya existe un usuario con ese nombre.');
    END IF;
END;
/

-- Trigger para evitar patrocinios duplicados
CREATE OR REPLACE TRIGGER patrocinios_duplicate
BEFORE INSERT OR UPDATE ON patrocinios
FOR EACH ROW
DECLARE
    v_count NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_count
    FROM patrocinios
    WHERE id_patrocinador = :NEW.id_patrocinador
    AND id_equipo = :NEW.id_equipo;
    
    IF v_count > 0 THEN
        RAISE_APPLICATION_ERROR(-20008, 'Este patrocinio ya está registrado.');
    END IF;
END;
/
