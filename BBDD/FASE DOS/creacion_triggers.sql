/*
Script SQL de borrado y creación de los disparadores. Como minino debemos
tener disparadores para:
     Controlar que no haya más de 6 jugadores en un equipo.

     Controlar que para poder generar el calendario de una competición
    todos los equipos tienen que tener un mínimo de dos jugadores.

     Controlar que una vez generado el calendario de la competición, no se
    pueden modificar, ni los equipos, ni los jugadores de cada equipo.
*/

/*
Errores de los triggers:

    -20001, 
*/

CREATE OR REPLACE TRIGGER t_control_jugadores
BEFORE INSERT OR UPDATE ON jugador
FOR EACH ROW
DECLARE
    v_cantidad_jugadores number;
begin
    -- Hacemos el select para saber cuantos jugadores hay de cada equipo
    SELECT COUNT(*)
    INTO v_cantidad_jugadores
    FROM jugador
    WHERE id_equipo = :new.id_equipo;

    if v_cantidad_jugadores >= 6 then
        raise_application_error(-20011, 'No se pueden agregar mas de 6 jugadores en un equipo');
    end if;
end;
/

CREATE OR REPLACE TRIGGER controlar_minimo
BEFORE INSERT ON ENFRENTAMIENTO
FOR EACH ROW
DECLARE
    v_num_jugadores_local NUMBER;
    v_num_jugadores_visitante NUMBER;
BEGIN
    -- Comprobar el número de jugadores en el equipo local
    SELECT COUNT(*) INTO v_num_jugadores_local FROM JUGADOR WHERE ID_EQUIPO = :NEW.ID_EQUIPO_LOCAL;

    -- Comprobar el número de jugadores en el equipo visitante
    SELECT COUNT(*) INTO v_num_jugadores_visitante FROM JUGADOR WHERE ID_EQUIPO = :NEW.ID_EQUIPO_VISITANTE;

    -- Si algún equipo tiene menos de 2 jugadores, lanzar una excepción
    IF v_num_jugadores_local < 2 OR v_num_jugadores_visitante < 2 THEN
        RAISE_APPLICATION_ERROR(-20012, 'Todos los equipos deben tener al menos 2 jugadores para generar el calendario');
    END IF;
END;
/

CREATE OR REPLACE TRIGGER t_control_cambio_equipos
BEFORE UPDATE OF id_jornada, id_equipo_local, id_equipo_visitante ON enfrentamiento
FOR EACH ROW
DECLARE
    v_estado number;
begin

    SELECT estado 
    INTO v_estado 
    FROM competicion 
    WHERE id_competicion = (
        SELECT id_competicion
        FROM jornada
        WHERE id_jornada = :NEW.id_jornada
    );

  if v_estado = 1 then
    raise_application_error(-20013, 'La inscripcion ya esta completa.');
  end if;
end;