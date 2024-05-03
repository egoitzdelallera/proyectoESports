CREATE OR REPLACE PROCEDURE consultar_jornada (
    p_n_jornada IN jornadas.n_jornada%TYPE,
    p_id_competicion IN competiciones.id_competicion%TYPE,
    p_resultado OUT VARCHAR2
)
AS
    v_resultado VARCHAR2(4000);
BEGIN
    FOR enfrentamiento IN (
        SELECT e1.nombre AS equipo_local, e2.nombre AS equipo_visitante, f.hora
        FROM enfrentamientos f
        INNER JOIN equipos e1 ON f.id_equipo_local = e1.id_equipo
        INNER JOIN equipos e2 ON f.id_equipo_visitante = e2.id_equipo
        INNER JOIN jornadas j ON f.id_jornada = j.id_jornada
        WHERE j.n_jornada = p_n_jornada AND j.id_competicion = p_id_competicion
    ) LOOP
        v_resultado := v_resultado || 'Equipo Local: ' ||
        enfrentamiento.equipo_local || CHR(10);
        v_resultado := v_resultado || 'Equipo Visitante: ' ||
        enfrentamiento.equipo_visitante || CHR(10);
        v_resultado := v_resultado || 'Hora del Enfrentamiento: ' ||
        enfrentamiento.hora || CHR(10);
        v_resultado := v_resultado || '-------------------------' || CHR(10);
    END LOOP;
     p_resultado := v_resultado;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('No se encontraron datos.');
END consultar_jornada;






--PROCEDIMIENTO ANONIMO

DECLARE
    comprobacion VARCHAR2(4000); 
BEGIN
    
    consultar_jornada(1, 1, comprobacion); 

    DBMS_OUTPUT.PUT_LINE('Resultado de los enfrentamientos:');
    DBMS_OUTPUT.PUT_LINE(v_texto_enfrentamientos);
END;



