DROP TABLE EQUIPO CASCADE CONSTRAINTS;

CREATE TABLE EQUIPO(
    ID_EQUIPO NUMBER(2),
    NOMBRE VARCHAR2(25),
    FECHA_FUNDACION DATE,
    CONSTRAINT ID_EQUIPO_PK PRIMARY KEY (ID_EQUIPO)
);

/* JUGADORES */

DROP TABLE JUGADOR CASCADE CONSTRAINTS;

CREATE TABLE JUGADOR(
    ID_JUGADOR NUMBER(2),
    NOMBRE VARCHAR2(50),
    NACIONALIDAD VARCHAR2(50),
    FECHA_NACIMIENTO DATE,
    NICKNAME VARCHAR2(50),
    ROL VARCHAR2(50),
    SUELDO NUMBER(10),
    ID_EQUIPO NUMBER(2),
    CONSTRAINT ID_JUGADOR_PK PRIMARY KEY (ID_JUGADOR),
    CONSTRAINT ID_EQUIPO_J_FK FOREIGN KEY (ID_EQUIPO)
        REFERENCES EQUIPO(ID_EQUIPO)
);

DROP TABLE USUARIO CASCADE CONSTRAINTS;

CREATE TABLE USUARIO(
    ID_USUARIO NUMBER(2),
    NOMBRE VARCHAR2(50),
    CONTRASENA VARCHAR2(50),
    ROL VARCHAR2(50),
    CONSTRAINT ID_USUARIO_PK PRIMARY KEY (ID_USUARIO),
    CONSTRAINT CHK_ROL CHECK(ROL IN('ADMINISTRADOR', 'USUARIO'))
);

DROP TABLE JUEGO CASCADE CONSTRAINTS;

CREATE TABLE JUEGO(
    ID_JUEGO NUMBER(2),
    NOMBRE VARCHAR2(50),
    EMPRESA VARCHAR2(50),
    FECHA_LANZAMIENTO DATE,
    CONSTRAINT ID_JUEGO_PK PRIMARY KEY (ID_JUEGO)
);

DROP TABLE ENFRENTAMIENTO CASCADE CONSTRAINTS;

CREATE TABLE ENFRENTAMIENTO(
    ID_ENFRENTAMIENTO NUMBER(2),
    HORA TIMESTAMP,
    ID_JORNADA NUMBER(2),
    ID_EQUIPO_LOCAL NUMBER(2),
    ID_EQUIPO_VISITANTE NUMBER(2),
    ID_GANADOR NUMBER(2),
    CONSTRAINT ID_ENFRENTAMIENTO_PK PRIMARY KEY (ID_ENFRENTAMIENTO),
    CONSTRAINT ID_JORNADA_ENFRENTAMIENTO_FK FOREIGN KEY (ID_JORNADA)
        REFERENCES JORNADA(ID_JORNADA),
    CONSTRAINT ID_EQUIPO_LOCAL_FK FOREIGN KEY (ID_EQUIPO_LOCAL)
        REFERENCES EQUIPO(ID_EQUIPO),
    CONSTRAINT ID_EQUIPO_VISITANTE_FK FOREIGN KEY (ID_EQUIPO_VISITANTE)
        REFERENCES EQUIPO(ID_EQUIPO),
    CONSTRAINT ID_GANADOR_FK FOREIGN KEY (ID_GANADOR)
        REFERENCES EQUIPO(ID_EQUIPO)
);

DROP TABLE JORNADA CASCADE CONSTRAINTS;

CREATE TABLE JORNADA(
    ID_JORNADA NUMBER(2),
    FECHA_JORNADA DATE,
    ID_COMPETICION NUMBER(2),
    CONSTRAINT ID_JORNADA_PK PRIMARY KEY (ID_JORNADA),
    CONSTRAINT ID_COMPETICION_JORNADA_FK FOREIGN KEY (ID_COMPETICION)
        REFERENCES COMPETICION(ID_COMPETICION)
);

DROP TABLE COMPETICION CASCADE CONSTRAINTS;

CREATE TABLE COMPETICION(
    ID_COMPETICION NUMBER(2),
    NOMBRE VARCHAR2(50),
    FECHA_INICIO DATE,
    FECHA_FIN DATE,
    ESTADO NUMBER(1) CONSTRAINT estado_check CHECK (ESTADO IN (0, 1)),
    ID_JUEGO NUMBER(2),
    CONSTRAINT ID_COMPETICION_PK PRIMARY KEY (ID_COMPETICION),
    CONSTRAINT ID_JUEGO_C_FK FOREIGN KEY (ID_JUEGO)
        REFERENCES JUEGO(ID_JUEGO)
);

/* RELACION ENTRE EQUIPO Y COMPETICION */

DROP TABLE PARTICIPACION CASCADE CONSTRAINTS;

CREATE TABLE PARTICIPACION(
    ID_EQUIPO NUMBER(2),
    ID_COMPETICION NUMBER(2),
    PUNTUACION VARCHAR2(10),
    CONSTRAINT ID_EQUIPO_PARTICIPACION_FK FOREIGN KEY (ID_EQUIPO)
        REFERENCES EQUIPO(ID_EQUIPO),
    CONSTRAINT ID_COMPETICION_FK FOREIGN KEY (ID_COMPETICION)
        REFERENCES COMPETICION(ID_COMPETICION)
);


DROP TABLE STAFF CASCADE CONSTRAINTS;

CREATE TABLE STAFF(
    ID_STAFF NUMBER(2),
    PUESTO VARCHAR2(50),
    NOMBRE VARCHAR2(50),
    SUELDO NUMBER(10),
    ID_EQUIPO NUMBER(2),
    CONSTRAINT ID_STAFF_PK PRIMARY KEY (ID_STAFF),
    CONSTRAINT CHK_PUESTO CHECK(PUESTO IN('ENTRENADOR', 'ASISTENTE')),
    CONSTRAINT ID_EQUIPO_S_FK FOREIGN KEY (ID_EQUIPO)
        REFERENCES EQUIPO(ID_EQUIPO)
);

DROP TABLE PATROCINADOR CASCADE CONSTRAINTS;

CREATE TABLE PATROCINADOR(
    ID_PATROCINADOR NUMBER(2),
    NOMBRE VARCHAR2(50),
    CONSTRAINT ID_PATROCINADOR_PK PRIMARY KEY (ID_PATROCINADOR)
);

DROP TABLE PATROCINIO CASCADE CONSTRAINTS;

CREATE TABLE PATROCINIO(
    ID_PATROCINADOR NUMBER(2),
    ID_EQUIPO NUMBER(2),
    CONSTRAINT ID_PATRONCINADOR_PATROCINIO_FK FOREIGN KEY (ID_PATROCINADOR)
        REFERENCES PATROCINADOR(ID_PATROCINADOR),
    CONSTRAINT ID_EQUIPO_PATROCINIO_FK FOREIGN KEY (ID_EQUIPO)
        REFERENCES EQUIPO(ID_EQUIPO)
);