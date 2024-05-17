--Procedimiento para generar el XML de las clasificaciones de las competiciones

CREATE OR REPLACE PROCEDURE generar_xml_clasificaciones AS
  xml CLOB;
BEGIN
  SELECT XMLELEMENT("competiciones",
           XMLAGG(
             XMLELEMENT("competicion",
               XMLATTRIBUTES(c.ID_COMPETICION AS "id"),
               XMLELEMENT("nombre_comp", c.NOMBRE),
               XMLELEMENT("juego",
                 XMLATTRIBUTES(c.ID_JUEGO AS "id"),
                 XMLELEMENT("nombre_juego", (SELECT j.NOMBRE FROM JUEGOS j 
                                             WHERE j.ID_JUEGO = c.ID_JUEGO))
                            ),
               XMLELEMENT("equipos",
                 (SELECT XMLAGG(
                   XMLELEMENT("equipo",
                     XMLATTRIBUTES(e.ID_EQUIPO AS "id"),
                     XMLELEMENT("nombre_eq", e.NOMBRE),
                     XMLELEMENT("puntos_totales", p.PUNTUACION)
                   )
                 )
                 FROM PARTICIPACIONES p
                 JOIN EQUIPOS e ON p.ID_EQUIPO = e.ID_EQUIPO
                 WHERE p.ID_COMPETICION = c.ID_COMPETICION)
               ),
               XMLELEMENT("fecha", c.FECHA_INICIO)
             )
           )
         ).getClobVal()
  INTO xml
  FROM COMPETICIONES c;
  
  
  --Insertar el resultado en la tabla clasificacion
  INSERT INTO clasificacion (resultado) VALUES (xml);
      
END;


/*
Ejecución del procedimiento y SELECT para comprobar el resultado de la inserción

BEGIN
  generar_xml_clasificaciones;
END;

SELECT * FROM clasificacion;
*/