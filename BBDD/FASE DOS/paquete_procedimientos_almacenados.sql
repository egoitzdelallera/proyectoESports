set serveroutput on;

CREATE OR REPLACE PACKAGE paquete_esports as
        
    procedure insertar_equipo(
        p_nombre_equipo in equipos.nombre%type,
        p_fecha_fundacion in equipos.fecha_fundacion%type
    );
    
    procedure insertar_jugador(
        p_nombre_jugador in jugadores.nombre%type,
        p_nacionalidad in jugadores.nacionalidad%type,
        p_fecha_nacimiento in jugadores.fecha_nacimiento%type,
        p_nickname in jugadores.nickname%type,
        p_rol in jugadores.rol%type,
        p_sueldo in jugadores.sueldo%type,
        p_id_equipo in jugadores.id_equipo%type);
        
end paquete_esports;
/

CREATE OR REPLACE PACKAGE BODY paquete_esports as
    
    PROCEDURE insertar_equipo(
        p_nombre_equipo in equipos.nombre%type,
        p_fecha_fundacion in equipos.fecha_fundacion%type
    ) as
        v_id_equipo equipos.id_equipo%type;
    begin
        select nvl(max(id_equipo), 0) + 1 into v_id_equipo from equipos;
        
        insert into equipos(id_equipo, nombre, fecha_fundacion)
        values (v_id_equipo, p_nombre_equipo, p_fecha_fundacion);
        
        commit;
        dbms_output.put_line('Equipo insertado correctamente.');
    exception
        when others then
        rollback;
        dbms_output.put_line('Error: ' || SQLERRM);
    end insertar_equipo;
    
    PROCEDURE insertar_jugador(
        p_nombre_jugador in jugadores.nombre%type,
        p_nacionalidad in jugadores.nacionalidad%type,
        p_fecha_nacimiento in jugadores.fecha_nacimiento%type,
        p_nickname in jugadores.nickname%type,
        p_rol in jugadores.rol%type,
        p_sueldo in jugadores.sueldo%type,
        p_id_equipo in jugadores.id_equipo%type
    ) as
        v_id_jugador jugadores.id_jugador%type;
    begin
        --Sacar el id del jugador
        select nvl(max(id_jugador), 0) + 1 into v_id_jugador from jugadores;
        
        -- Insertar el jugador
        insert into jugadores(id_jugador, nombre, nacionalidad, fecha_nacimiento, nickname, rol, sueldo, id_equipo)
        values (v_id_jugador, p_nombre_jugador, p_nacionalidad, p_fecha_nacimiento, p_nickname, p_rol, p_sueldo, p_id_equipo);
        
        commit;
        dbms_output.put_line('Jugador insertado');
    exception
        when others then
        rollback;
        dbms_output.put_line('Error: ' || SQLERRM);
    end insertar_jugador;
end paquete_esports;
/

CREATE OR REPLACE PROCEDURE informe_competicion 
        (p_id_competicion in competiciones.id_competicion%type)
    AS
        CURSOR c_informe IS
            SELECT c.nombre as nombre_competicion,
                   j.nombre as nombre_juego,
                   c.fecha_inicio,
                   c.fecha_fin,
                   e.nombre as nombre_equipo,
                   s.nombre as nombre_staff,
                   s.puesto as puesto_staff,
                   count(jug.id_jugador) as cantidad_jugadores
            from competiciones c
            inner join juegos j on c.id_juego = j.id_juego
            inner join jornadas jor on c.id_competicion = jor.id_competicion
            inner join enfrentamientos ef on jor.id_jornada = ef.id_jornada
            inner join equipos e on ef.id_equipo_local = e.id_equipo 
                       or ef.id_equipo_visitante = e.id_equipo
            left join staff s on e.id_equipo = s.id_equipo
            left join jugadores jug on e.id_equipo = jug.id_equipo
            where c.id_competicion = p_id_competicion
            group by c.nombre, j.nombre, c.fecha_inicio, c.fecha_fin, e.nombre, 
            s.nombre, s.puesto;
        
    begin
        FOR informe IN c_informe LOOP
            DBMS_OUTPUT.PUT_LINE('Nombre de la competición: ' || informe.nombre_competicion);
            DBMS_OUTPUT.PUT_LINE('Nombre del juego: ' || informe.nombre_juego);
            DBMS_OUTPUT.PUT_LINE('Fecha de inicio: ' || TO_CHAR(informe.fecha_inicio, 'DD-MM-YYYY'));
            DBMS_OUTPUT.PUT_LINE('Fecha de fin: ' || TO_CHAR(informe.fecha_fin, 'DD-MM-YYYY'));
            DBMS_OUTPUT.PUT_LINE('Nombre del equipo: ' || informe.nombre_equipo);
            DBMS_OUTPUT.PUT_LINE('Nombre del staff: ' || informe.nombre_staff);
            DBMS_OUTPUT.PUT_LINE('Puesto del staff: ' || informe.puesto_staff);
            DBMS_OUTPUT.PUT_LINE('Cantidad de jugadores: ' || informe.cantidad_jugadores);
            DBMS_OUTPUT.PUT_LINE('------------------------------------');
        end loop;
    exception
        when no_data_found then
            raise_application_error('-20020', 'No se ha encontrado el id de la competicion');
		when others then
            raise_application_error('-20099', 'Error: ' || SQLERRM);
end informe_competicion;
/

create or replace procedure jugadores_equipo(
    p_id_equipo in equipos.id_equipo%type
)
is
begin
    for jugador_info in (
        SELECT
            j.id_jugador,
            j.nombre,
            j.nacionalidad,
            j.fecha_nacimiento,
            j.nickname,
            j.rol,
            j.sueldo
        from
            jugadores j
        where
            j.id_equipo = p_id_equipo
    ) 
    loop
        DBMS_OUTPUT.PUT_LINE('ID: ' || jugador_info.ID_JUGADOR || 
                             ', Nombre: ' || jugador_info.NOMBRE || 
                             ', Nacionalidad: ' || jugador_info.NACIONALIDAD || 
                             ', Fecha de nacimiento: ' || TO_CHAR(jugador_info.FECHA_NACIMIENTO, 'DD/MM/YYYY') || 
                             ', Nickname: ' || jugador_info.NICKNAME || 
                             ', Rol: ' || jugador_info.ROL || 
                             ', Sueldo: ' || jugador_info.SUELDO);
    end loop;
exception
  when no_data_found then
    dbms_output.put_line('No se encontraron jugadores para el equipo');
  when others then
    dbms_output.put_line('Error: ' || SQLERRM);
end;    
/

create or replace procedure enfrentamientos_por_fecha(
    p_fecha_jornada IN DATE
)
IS
    v_id_jornada enfrentamientos.id_jornada%type;
BEGIN
    SELECT id_jornada into v_id_jornada
    FROM jornadas
    WHERE fecha_jornada = p_fecha_jornada;
    
    FOR enfrentamiento_info IN (
        SELECT
            e.id_enfrentamiento,
            e.hora,
            e.id_jornada,
            e.id_equipo_local,
            e.id_equipo_visitante,
            e.id_ganador
        FROM
            enfrentamientos e
        WHERE
            e.id_jornada = v_id_jornada
    )
    LOOP
        DBMS_OUTPUT.PUT_LINE('ID Enfrentamiento: ' || enfrentamiento_info.ID_ENFRENTAMIENTO || 
                             ', Hora: ' || TO_CHAR(enfrentamiento_info.HORA, 'DD/MM/YYYY HH24:MI:SS') || 
                             ', ID Jornada: ' || enfrentamiento_info.ID_JORNADA || 
                             ', ID Equipo Local: ' || enfrentamiento_info.ID_EQUIPO_LOCAL || 
                             ', ID Equipo Visitante: ' || enfrentamiento_info.ID_EQUIPO_VISITANTE || 
                             ', ID Ganador: ' || enfrentamiento_info.ID_GANADOR);
    END LOOP;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('No se han encontrado enfrentamientos con la fecha');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END enfrentamientos_por_fecha;
/
