CREATE OR REPLACE PROCEDURE generar_jornadas_xml AS
    v_xml CLOB;
BEGIN
    -- Generar el documento XML
    SELECT XMLELEMENT("competiciones",
             XMLAGG(
                 XMLELEMENT("competicion",
                     XMLATTRIBUTES(c.id_competicion AS "id"),
                     XMLFOREST(c.nombre AS "nombre",
                               j.nombre AS "juego"),
                     XMLELEMENT("jornadas",
                         (SELECT XMLAGG(
                             XMLELEMENT("jornada",
                                 XMLATTRIBUTES(jr.id_jornada AS "id"),
                                 XMLFOREST(jr.n_jornada AS "n_jornada",
                                           TO_CHAR(jr.fecha_jornada, 'DD/MM/YYYY') AS "fecha_jornada"),
                                 XMLELEMENT("enfrentamientos",
                                     (SELECT XMLAGG(
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
                                     FROM enfrentamientos e
                                     LEFT JOIN equipos el ON e.id_equipo_local = el.id_equipo
                                     LEFT JOIN equipos ev ON e.id_equipo_visitante = ev.id_equipo
                                     WHERE e.id_jornada = jr.id_jornada)
                                 )
                             )
                         )
                         FROM jornadas jr
                         WHERE jr.id_competicion = c.id_competicion)
                     )
                 )
             )
           ).getClobVal() INTO v_xml
    FROM competiciones c
    JOIN juegos j ON c.id_juego = j.id_juego;

    -- Insertar el XML generado en la tabla result_jornadas
    INSERT INTO result_jornadas (resultado) VALUES (v_xml);

    -- Confirmar la transacción
    COMMIT;

    -- Mostrar el XML generado
    DBMS_OUTPUT.put_line(v_xml);
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.put_line('Error: ' || SQLERRM);
        ROLLBACK;
END generar_jornadas_xml;
/






