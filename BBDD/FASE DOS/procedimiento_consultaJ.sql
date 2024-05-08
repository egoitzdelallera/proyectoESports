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
        JOIN equipos e1 ON f.id_equipo_local = e1.id_equipo
        JOIN equipos e2 ON f.id_equipo_visitante = e2.id_equipo
        JOIN jornadas j ON f.id_jornada = j.id_jornada
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
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END consultar_jornada;
/

CREATE OR REPLACE PROCEDURE verificar_competicion (
    p_id_equipo equipos.id_equipo%TYPE,
    p_estado OUT competiciones.estado%TYPE
)
IS
BEGIN
    -- Obtener el estado de la competición
    SELECT estado INTO p_estado
    FROM competiciones
    WHERE id_competicion IN (
        SELECT id_competicion
        FROM participaciones 
        WHERE id_equipo = p_id_equipo
    );
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        p_estado := NULL; -- No hacemos nada si no se encuentra la competición
END verificar_competicion;
/