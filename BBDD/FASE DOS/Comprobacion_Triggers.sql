-- Inserciones que deber�an funcionar correctamente
INSERT INTO equipos (nombre, fecha_fundacion) VALUES ('Equipo A', TO_DATE('01-01-2000', 'DD-MM-YYYY'));
INSERT INTO equipos (nombre, fecha_fundacion) VALUES ('Equipo B', TO_DATE('01-01-2005', 'DD-MM-YYYY'));

INSERT INTO jugadores (nombre, nacionalidad, fecha_nacimiento, nickname, rol, sueldo, id_equipo) VALUES ('Jugador 1', 'Nacionalidad 1', TO_DATE('1990-01-01', 'YYYY-MM-DD'), 'Nick1', 'Delantero', 1500, 1);
INSERT INTO jugadores (nombre, nacionalidad, fecha_nacimiento, nickname, rol, sueldo, id_equipo) VALUES ('Jugador 2', 'Nacionalidad 2', TO_DATE('1992-03-15', 'YYYY-MM-DD'), 'Nick2', 'Defensa', 1800, 2);

INSERT INTO usuarios (nombre, contrasena, rol) VALUES ('Usuario 1', 'password1', 'ADMINISTRADOR');
INSERT INTO usuarios (nombre, contrasena, rol) VALUES ('Usuario 2', 'password2', 'USUARIO');

INSERT INTO juegos (nombre, empresa, fecha_lanzamiento) VALUES ('Juego A', 'Empresa A', TO_DATE('01-01-2010', 'DD-MM-YYYY'));
INSERT INTO juegos (nombre, empresa, fecha_lanzamiento) VALUES ('Juego B', 'Empresa B', TO_DATE('01-01-2015', 'DD-MM-YYYY'));

INSERT INTO competiciones (nombre, fecha_inicio, fecha_fin, estado, id_juego) VALUES ('Competici�n 1', TO_DATE('01-01-2022', 'DD-MM-YYYY'), TO_DATE('01-02-2022', 'DD-MM-YYYY'), 0, 1);
INSERT INTO competiciones (nombre, fecha_inicio, fecha_fin, estado, id_juego) VALUES ('Competici�n 2', TO_DATE('01-03-2022', 'DD-MM-YYYY'), TO_DATE('01-04-2022', 'DD-MM-YYYY'), 0, 2);


INSERT INTO patrocinadores (nombre) VALUES ('Patrocinador A');
INSERT INTO patrocinadores (nombre) VALUES ('Patrocinador B');

-- Inserciones que deber�an hacer saltar �nicamente los disparadores y los controles de integridad definidos por restricciones de verificaci�n (checks)
-- Intentar insertar un usuario con un rol inv�lido
INSERT INTO usuarios (nombre, contrasena, rol) VALUES ('Usuario 3', 'password3', 'INVALIDO');

-- Intentar insertar jugadores con un sueldo menor al m�nimo permitido
INSERT INTO jugadores (nombre, nacionalidad, fecha_nacimiento, nickname, rol, sueldo, id_equipo) VALUES ('Jugador 3', 'Nacionalidad 3', TO_DATE('1995-05-05', 'YYYY-MM-DD'), 'Nick3', 'Portero', 1000, 1);
INSERT INTO jugadores (nombre, nacionalidad, fecha_nacimiento, nickname, rol, sueldo, id_equipo) VALUES ('Jugador 4', 'Nacionalidad 4', TO_DATE('1997-07-07', 'YYYY-MM-DD'), 'Nick4', 'Centrocampista', 500, 2);

-- Intentar insertar staff con un puesto inv�lido
INSERT INTO staff (puesto, nombre, sueldo, id_equipo) VALUES ('Puesto Inv�lido', 'Nombre 3', 2000, 1);
INSERT INTO staff (puesto, nombre, sueldo, id_equipo) VALUES ('Entrenador', 'Nombre 4', 2500, 2);

-- Intentar insertar un patrocinio con un patrocinador o equipo que no existe
INSERT INTO patrocinios (id_patrocinador, id_equipo) VALUES (10, 1);
INSERT INTO patrocinios (id_patrocinador, id_equipo) VALUES (1, 20);


-- Intentar insertar un jugador en un equipo que ya tiene 6 jugadores
INSERT INTO jugadores (nombre, nacionalidad, fecha_nacimiento, nickname, rol, sueldo, id_equipo) VALUES ('Jugador 3', 'Nacionalidad 3', TO_DATE('1995-05-05', 'YYYY-MM-DD'), 'Nick3', 'Delantero', 1500, 1);
INSERT INTO jugadores (nombre, nacionalidad, fecha_nacimiento, nickname, rol, sueldo, id_equipo) VALUES ('Jugador 4', 'Nacionalidad 4', TO_DATE('1997-07-07', 'YYYY-MM-DD'), 'Nick4', 'Defensa', 1800, 1);
INSERT INTO jugadores (nombre, nacionalidad, fecha_nacimiento, nickname, rol, sueldo, id_equipo) VALUES ('Jugador 5', 'Nacionalidad 5', TO_DATE('1998-08-08', 'YYYY-MM-DD'), 'Nick5', 'Centrocampista', 1700, 1);
INSERT INTO jugadores (nombre, nacionalidad, fecha_nacimiento, nickname, rol, sueldo, id_equipo) VALUES ('Jugador 6', 'Nacionalidad 6', TO_DATE('1999-09-09', 'YYYY-MM-DD'), 'Nick6', 'Portero', 1600, 1);
INSERT INTO jugadores (nombre, nacionalidad, fecha_nacimiento, nickname, rol, sueldo, id_equipo) VALUES ('Jugador 7', 'Nacionalidad 7', TO_DATE('2000-10-10', 'YYYY-MM-DD'), 'Nick7', 'Defensa', 1800, 1);
INSERT INTO jugadores (nombre, nacionalidad, fecha_nacimiento, nickname, rol, sueldo, id_equipo) VALUES ('Jugador 8', 'Nacionalidad 8', TO_DATE('2001-11-11', 'YYYY-MM-DD'), 'Nick8', 'Portero', 1600, 1);

-- Intentar insertar un enfrentamiento con un equipo local que no tiene al menos dos jugadores
INSERT INTO enfrentamientos (hora, id_jornada, id_equipo_local, id_equipo_visitante) VALUES (TO_TIMESTAMP('2024-05-01 14:00:00', 'YYYY-MM-DD HH24:MI:SS'), 1, 1, 2);

-- Intentar insertar una competici�n con un n�mero impar de equipos
INSERT INTO competiciones (nombre, fecha_inicio, fecha_fin, estado, id_juego) VALUES ('Competici�n 3', TO_DATE('01-01-2022', 'DD-MM-YYYY'), TO_DATE('01-02-2022', 'DD-MM-YYYY'), 0, 1);

INSERT INTO participaciones (id_equipo, id_competicion, puntuacion) VALUES (1, 1, '10');
INSERT INTO participaciones (id_equipo, id_competicion, puntuacion) VALUES (2, 1, '8');

    -- Crear un nuevo equipo
BEGIN
    equipo_pkg.crear_equipo(1, 'Equipo Alpha', 30);
    DBMS_OUTPUT.PUT_LINE('Equipo creado correctamente.');
END;
/

-- Leer información de un equipo
DECLARE
    v_nombre equipos.nombre%TYPE;
    v_puntos_totales equipos.puntos_totales%TYPE;
BEGIN
    equipo_pkg.leer_equipo(1, v_nombre, v_puntos_totales);
    DBMS_OUTPUT.PUT_LINE('Nombre: ' || v_nombre || ', Puntos Totales: ' || v_puntos_totales);
END;
/

-- Actualizar un equipo
BEGIN
    equipo_pkg.actualizar_equipo(1, 'Equipo Beta', 35);
    DBMS_OUTPUT.PUT_LINE('Equipo actualizado correctamente.');
END;
/

-- Eliminar un equipo
BEGIN
    equipo_pkg.eliminar_equipo(1);
    DBMS_OUTPUT.PUT_LINE('Equipo eliminado correctamente.');
END;
/
