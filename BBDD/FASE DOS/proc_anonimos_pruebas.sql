--Procedimiento que inserta un equipo
BEGIN
    PAQUETE_ESPORTS.INSERTAR_EQUIPO('EQUIPO A', TO_DATE('2023-01-01', 'YYYY-MM-DD'));
END;


--Procedimiento que inserta un jugador
BEGIN
    PAQUETE_ESPORTS.INSERTAR_JUGADOR('JUGADOR 1', 'ESPAÑA', TO_DATE('1995-05-15', 'YYYY-MM-DD'), 'JUGADOR1', 'TOP', 2000, 1);
END;


--Procedimiento que crea un equipo
BEGIN
    EQUIPO_PKG.CREAR_EQUIPO(EQUIPOS_SEQ.NEXTVAL, 'EQUIPO B', TO_DATE('2022-02-02', 'YYYY-MM-DD'));
END;


--Procedimiento que consulta una jornada
DECLARE
    v_resultado VARCHAR2(4000);
BEGIN
    CONSULTAR_JORNADA(1, 1, v_resultado);
    DBMS_OUTPUT.PUT_LINE(v_resultado);
END;


--Procedimiento que verifica el estado de la competición de un equipo
DECLARE
    v_estado COMPETICIONES.ESTADO%TYPE;
BEGIN
    VERIFICAR_COMPETICION(1, v_estado);
    DBMS_OUTPUT.PUT_LINE('Estado de la competición: ' || v_estado);
END;


--Procedimiento para generar un informe de competición
DECLARE
    p_id_competicion competiciones.id_competicion%TYPE := 1;
BEGIN
    INFORME_COMPETICION(p_id_competicion);
END;


--Procedimiento para obtener los jugadores de un equipo
BEGIN
    JUGADORES_EQUIPO(1);
END;


--Procedimiento para obtener los enfrentamientos por fecha
BEGIN
    ENFRENTAMIENTOS_POR_FECHA(TO_DATE('2024-05-24', 'YYYY-MM-DD'));
END;    