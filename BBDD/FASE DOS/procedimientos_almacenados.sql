set serveroutput on;

CREATE OR REPLACE PACKAGE paquete_esports as
        
    procedure insertar_equipo(
        p_nombre_equipo in equipo.nombre%type,
        p_fecha_fundacion in equipo.fecha_fundacion%type
    );
    
    procedure insertar_jugador(
        p_nombre_jugador in jugador.nombre%type,
        p_nacionalidad in jugador.nacionalidad%type,
        p_fecha_nacimiento in jugador.fecha_nacimiento%type,
        p_nickname in jugador.nickname%type,
        p_rol in jugador.rol%type,
        p_sueldo in jugador.sueldo%type,
        p_id_equipo in jugador.id_equipo%type);
        
end paquete_esports;


CREATE OR REPLACE PACKAGE BODY paquete_esports as
    
    PROCEDURE insertar_equipo(
        p_nombre_equipo in equipo.nombre%type,
        p_fecha_fundacion in equipo.fecha_fundacion%type
    ) as
        v_id_equipo equipo.id_equipo%type;
    begin
        select nvl(max(id_equipo), 0) + 1 into v_id_equipo from equipo;
        
        insert into equipo(id_equipo, nombre, fecha_fundacion)
        values (v_id_equipo, p_nombre_equipo, p_fecha_fundacion);
        
        commit;
        dbms_output.put_line('Equipo insertado correctamente.');
    exception
        when others then
        rollback;
        dbms_output.put_line('Error: ' || SQLERRM);
    end insertar_equipo;
    
    PROCEDURE insertar_jugador(
        p_nombre_jugador in jugador.nombre%type,
        p_nacionalidad in jugador.nacionalidad%type,
        p_fecha_nacimiento in jugador.fecha_nacimiento%type,
        p_nickname in jugador.nickname%type,
        p_rol in jugador.rol%type,
        p_sueldo in jugador.sueldo%type,
        p_id_equipo in jugador.id_equipo%type
    ) as
        v_id_jugador jugador.id_jugador%type;
    begin
        --Sacar el id del jugador
        select nvl(max(id_jugador), 0) + 1 into v_id_jugador from jugador;
        
        -- Insertar el jugador
        insert into jugador(id_jugador, nombre, nacionalidad, fecha_nacimiento, nickname, rol, sueldo, id_equipo)
        values (v_id_jugador, p_nombre_jugador, p_nacionalidad, p_fecha_nacimiento, p_nickname, p_rol, p_sueldo, p_id_equipo);
        
        commit;
        dbms_output.put_line('Jugador insertado');
    exception
        when others then
        rollback;
        dbms_output.put_line('Error: ' || SQLERRM);
    end insertar_jugador;
end paquete_esports;

CREATE OR REPLACE PROCEDURE informe_competicion 
        (p_id_competicion in competicion.id_competicion%type)
    AS
        CURSOR c_informe IS
            SELECT c.nombre as nombre_competicion,
                   j.nombre as nombre_juego,
                   c.fecha_inicio,
                   c.fecha_fin,
                   e.nombre as nombre_equipo,
                   s.nombre as nombre_staff,
                   s.puesto as puesto_staff,
                   count(j.id_jugador) as cantidad_jugadores
            from competicion c
            inner join juego j on c.id_juego = j.id_juego
            inner join jornada jor on c.id_competicion = jor.id_competicion
            inner join enfrentamiento ef on jor.id_jornada = ef.id_jornada
            inner join equipo e on ef.id_equipo_local = e.id_equipo 
                       or ef.id_equipo_visitante = e.id_equipo
            left join staff s on e.id_equipo = s.id_equipo
            left join jugador j on e.id_equipo = j.id_equipo
            where c.id_competicion = p.id_competicion
            group by c.nombre, j.nombre, c.fecha_inicio, c.fecha_fin, e.nombre, 
            s.nombre, s.puesto;
        
    begin
        for informe in c.informe loop
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
    end informe_competicion;

create or replace procedure jugadores_equipo(
    p_id_equipo in equipo.id_equipo%type
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
            jugador j
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
    end loop
exception
  when no_data_found then
    dbms_output.put_line('No se encontraron jugadores para el equipo');
  when others then
    dbms_output.put_line('Error: ' || SQLERRM)
end;    
/