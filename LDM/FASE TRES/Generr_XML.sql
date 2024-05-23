CREATE OR REPLACE PROCEDURE generar_clasificacion AS
    v_ctx DBMS_XMLGEN.ctxHandle;
    v_xml CLOB;
BEGIN
    -- Crear un nuevo contexto de generación de XML
    v_ctx := DBMS_XMLGEN.newContext(
        'SELECT c.id_competicion,
                c.nombre AS nombre_competicion,
                j.id_juego,
                j.nombre AS nombre_juego,
                e.id_equipo,
                e.nombre AS nombre_equipo,
                COUNT(CASE WHEN f.id_ganador = p.id_equipo THEN 1 END) AS puntos_totales
         FROM competiciones c
         JOIN enfrentamientos f ON c.id_competicion = f.id_competicion
         JOIN equipos e ON f.id_equipo_local = e.id_equipo OR f.id_equipo_visitante = e.id_equipo
         JOIN juegos j ON c.id_juego = j.id_juego
         JOIN participaciones p ON c.id_competicion = p.id_competicion AND e.id_equipo = p.id_equipo
         GROUP BY c.id_competicion, c.nombre, j.id_juego, j.nombre, e.id_equipo, e.nombre'
    );

    -- Establecer el nombre del elemento raíz del documento
    DBMS_XMLGEN.setRowSetTag(v_ctx, 'competiciones');

    -- Establecer el nombre del elemento de fila
    DBMS_XMLGEN.setRowTag(v_ctx, 'competicion');

    -- Generar el documento XML
    v_xml := DBMS_XMLGEN.getXML(v_ctx);

     --Mostrar el XML generado
    DBMS_OUTPUT.put_line(v_xml);

    -- Cerrar el contexto de generación de XML
    DBMS_XMLGEN.closeContext(v_ctx);
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.put_line('Error: ' || SQLERRM);
END generar_clasificacion;
/


BEGIN
generar_clasificacion;
END;
/










DROP PROCEDURE generar_clasificacion;














SELECT * FROM clasificacion;

DROP TABLE result_jornadas;

CREATE TABLE result_jornadas(
    resultado CLOB
);


CREATE OR REPLACE PROCEDURE generar_resultados_jornadas(
    id_competicion IN COMPETICIONES.ID_COMPETICION%TYPE
) AS
    qryCtx DBMS_XMLGEN.ctxHandle;
    result CLOB;
    query VARCHAR2(1000); -- Tamaño de la cadena de consulta
BEGIN
    EXECUTE IMMEDIATE 'TRUNCATE TABLE result_jornadas';
    -- Construir la consulta con el valor del parámetro directamente en la cadena
    query := 'SELECT
              j.n_jornada, e1.nombre AS equipo_local, e2.nombre AS equipo_visitante,
              CASE WHEN en.id_ganador = e1.id_equipo THEN ''Local''
                   WHEN en.id_ganador = e2.id_equipo THEN ''Visitante''
                   ELSE ''Sin Resultado'' END AS resultado
              FROM enfrentamientos en
              JOIN jornadas j ON en.id_jornada = j.id_jornada
              JOIN equipos e1 ON en.id_equipo_local = e1.id_equipo
              JOIN equipos e2 ON en.id_equipo_visitante = e2.id_equipo
              WHERE j.id_competicion = :id_competicion
              ORDER BY  j.fecha_jornada DESC';


    -- Crea un nuevo contexto de generación de XML
    qryCtx := DBMS_XMLGEN.newContext(query);

    -- Establece el nombre del elemento raíz del documento
    DBMS_XMLGEN.setRowSetTag(qryCtx, 'clasificacion');

    -- Establece el encabezado de fila
    DBMS_XMLGEN.setRowTag(qryCtx, 'jornada');
    
      -- Enlaza el valor del parámetro id_competicion
  DBMS_XMLGEN.setBindValue(qryCtx, 'id_competicion', id_competicion);


    -- Genera el documento XML
    result := DBMS_XMLGEN.getXML(qryCtx);

    -- Almacena el documento XML en la tabla result_jornadas
    INSERT INTO result_jornadas (resultado) VALUES (result);

    -- Cierra el contexto de generación de XML
    DBMS_XMLGEN.closeContext(qryCtx);
END;
/
BEGIN
    generar_resultados_jornadas(1); -- Suponiendo que el ID de la competición deseada es 1
END;
/

SELECT * FROM result_jornadas;
/

DROP TABLE ultima_jornada;


CREATE TABLE ultima_jornada(
    resultado CLOB
);

CREATE OR REPLACE PROCEDURE generar_ultima_jornada(
    id_competicion IN COMPETICIONES.ID_COMPETICION%TYPE
) AS
    qryCtx DBMS_XMLGEN.ctxHandle;
    result CLOB;
    query VARCHAR2(1000); -- Tamaño de la cadena de consulta
BEGIN
    EXECUTE IMMEDIATE 'TRUNCATE TABLE ultima_jornada';

    -- Construir la consulta con el valor del parámetro directamente en la cadena
    query := 'SELECT
              j.n_jornada, e1.nombre AS equipo_local, e2.nombre AS equipo_visitante,
              CASE WHEN en.id_ganador = e1.id_equipo THEN ''Local''
                   WHEN en.id_ganador = e2.id_equipo THEN ''Visitante''
                   ELSE ''Sin Resultado'' END AS resultado
              FROM enfrentamientos en
              JOIN jornadas j ON en.id_jornada = j.id_jornada
              JOIN equipos e1 ON en.id_equipo_local = e1.id_equipo
              JOIN equipos e2 ON en.id_equipo_visitante = e2.id_equipo
              WHERE j.id_competicion = :id_competicion
              ORDER BY  j.fecha_jornada DESC
              FETCH FIRST 1 ROW ONLY';

    -- Crea un nuevo contexto de generación de XML
    qryCtx := DBMS_XMLGEN.newContext(query);

    -- Establece el nombre del elemento raíz del documento
    DBMS_XMLGEN.setRowSetTag(qryCtx, 'clasificacion');

    -- Establece el encabezado de fila
    DBMS_XMLGEN.setRowTag(qryCtx, 'jornada');
    
    -- Enlaza el valor del parámetro id_competicion
    DBMS_XMLGEN.setBindValue(qryCtx, 'id_competicion', id_competicion);

    -- Genera el documento XML
    result := DBMS_XMLGEN.getXML(qryCtx);

    -- Almacena el documento XML en la tabla result_ultima_jornada
    INSERT INTO ultima_jornada(resultado) VALUES (result);

    -- Cierra el contexto de generación de XML
    DBMS_XMLGEN.closeContext(qryCtx);
END;
/
BEGIN
    generar_ultima_jornada(1); -- Suponiendo que el ID de la competición deseada es 1
END;
/

SELECT * FROM ultima_jornada;

