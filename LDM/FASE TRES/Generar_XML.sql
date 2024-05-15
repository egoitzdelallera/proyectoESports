DROP TABLE clasificacion;

CREATE TABLE clasificacion(
    resultado CLOB
);

CREATE OR REPLACE PROCEDURE generar_clasif(
    id_competicion IN COMPETICIONES.ID_COMPETICION%TYPE
) 
AS
  qryCtx DBMS_XMLGEN.ctxHandle;
  result CLOB;
BEGIN
    EXECUTE IMMEDIATE 'TRUNCATE TABLE CLASIFICACION';
  -- Crea un nuevo contexto de generación de XML
  qryCtx := DBMS_XMLGEN.newContext(
    'SELECT e.nombre, p.puntuacion 
     FROM equipos e 
     JOIN participaciones p ON e.id_equipo = p.id_equipo 
     WHERE p.id_competicion = :id_competicion
     ORDER BY p.puntuacion DESC'
  );

  -- Establece el nombre del elemento raíz del documento
  DBMS_XMLGEN.setRowSetTag(qryCtx, 'equipos');

  -- Establece el encabezado de fila
  DBMS_XMLGEN.setRowTag(qryCtx, 'equipo');

  -- Enlaza el valor del parámetro id_competicion
  DBMS_XMLGEN.setBindValue(qryCtx, 'id_competicion', id_competicion);

  -- Genera el documento XML
  result := DBMS_XMLGEN.getXML(qryCtx);

  -- Almacena el documento XML en una tabla temporal
  INSERT INTO clasificacion VALUES (result);

  -- Cierra el contexto de generación de XML
  DBMS_XMLGEN.closeContext(qryCtx);
END;
/

BEGIN
    generar_clasif(1); -- Suponiendo que el ID de la competición deseada es 1
END;
/

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

