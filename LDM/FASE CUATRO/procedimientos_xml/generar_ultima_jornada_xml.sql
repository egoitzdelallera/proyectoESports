CREATE OR REPLACE PROCEDURE generar_ultima_jornada_xml AS
    v_xml CLOB;
BEGIN
    -- Generar el documento XML para la última jornada de cada competición
    SELECT XMLELEMENT("competiciones",
             XMLAGG(
                 XMLELEMENT("competicion",
                     XMLATTRIBUTES(c.id_competicion AS "id"),
                     XMLFOREST(c.nombre AS "nombre",
                               j.nombre AS "juego"),
                     XMLELEMENT("jornada",
                         XMLATTRIBUTES(lj.id_jornada AS "id"),
                         XMLFOREST(lj.n_jornada AS "n_jornada",
                                   TO_CHAR(lj.fecha_jornada, 'YYYY-MM-DD') AS "fecha_jornada"),
                         XMLELEMENT("enfrentamientos",
                             XMLAGG(
                                 XMLELEMENT("enfrentamiento",
                                     XMLATTRIBUTES(e.id_enfrentamiento AS "id"),
                                     XMLFOREST(
                                         TO_CHAR(e.hora, 'HH24:MI') AS "hora",
                                         el.nombre AS "equipo_local",
                                         ev.nombre AS "equipo_visitante",
                                         CASE 
                                             WHEN e.id_ganador = e.id_equipo_local THEN 'Gana local'
                                             WHEN e.id_ganador = e.id_equipo_visitante THEN 'Gana visitante'
                                         END AS "resultado"
                                     )
                                 )
                             )
                         )
                     )
                 )
             )
           ).getClobVal() INTO v_xml
    FROM competiciones c
    JOIN juegos j ON c.id_juego = j.id_juego
    JOIN (
        SELECT j.id_jornada, j.n_jornada, j.fecha_jornada, j.id_competicion
        FROM jornadas j
        JOIN (
            SELECT id_competicion, MAX(n_jornada) AS max_n_jornada
            FROM jornadas
            GROUP BY id_competicion
        ) max_j ON j.id_competicion = max_j.id_competicion AND j.n_jornada = max_j.max_n_jornada
    ) lj ON c.id_competicion = lj.id_competicion
    JOIN enfrentamientos e ON lj.id_jornada = e.id_jornada
    LEFT JOIN equipos el ON e.id_equipo_local = el.id_equipo
    LEFT JOIN equipos ev ON e.id_equipo_visitante = ev.id_equipo
    GROUP BY c.id_competicion, c.nombre, j.nombre, lj.id_jornada, lj.n_jornada, lj.fecha_jornada;

    -- Insertar el XML generado en la tabla result_jornadas
    INSERT INTO ultima_jornada (resultado) VALUES (v_xml);

    -- Confirmar la transacción
    COMMIT;

    -- Mostrar el XML generado
    DBMS_OUTPUT.put_line(v_xml);
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.put_line('Error: ' || SQLERRM);
        ROLLBACK;
END generar_ultima_jornada_xml;
/

