CREATE TABLE USUARIOS 
(
  ID_USER NUMBER NOT NULL 
, NOMBRES VARCHAR2(50) NOT NULL 
, APELLIDOS VARCHAR2(50) NOT NULL 
, EDAD NUMBER NOT NULL 
, USUARIO VARCHAR2(20) NOT NULL 
, PASSWORD VARCHAR2(20) NOT NULL 
, EMAIL VARCHAR2(50) NOT NULL 
, ESTADO VARCHAR2(1) NOT NULL 
, TELEFONO VARCHAR2(10) NOT NULL 
, FECHA_REGISTRO DATE NOT NULL 
, FECHA_SALIDA DATE 
, CONSTRAINT USUARIOS_PK PRIMARY KEY 
  (
    ID_USER 
  )
  ENABLE 
);

COMMENT ON COLUMN USUARIOS.ESTADO IS '(A)Activo, (I) inactivo';