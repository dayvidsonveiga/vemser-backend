CREATE TABLE VEMSER_DAYVIDSON.ESTUDANTE(
	id_estudante NUMBER NOT NULL,
	nome VARCHAR(255) NOT NULL,
	data_nascimento DATE NOT NULL,
	nr_matricula NUMBER(10) UNIQUE NOT NULL,
	ativo CHAR(1),
	PRIMARY KEY(id_estudante)
);

CREATE SEQUENCE VEMSER_DAYVIDSON.SEQ_ESTUDANTE
START WITH 1
INCREMENT BY 1;

INSERT INTO VEMSER_DAYVIDSON.ESTUDANTE 
(ID_ESTUDANTE, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO)
VALUES(SEQ_ESTUDANTE.NEXTVAL, 'Joao Joa', TO_DATE('03-04-1990', 'dd-mm-yyyy'), 1001, 'S' );

INSERT INTO VEMSER_DAYVIDSON.ESTUDANTE 
(ID_ESTUDANTE, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO)
VALUES(SEQ_ESTUDANTE.NEXTVAL, 'Dayvidson', TO_DATE('03-04-1990', 'dd-mm-yyyy'), 1002, 'S' )

INSERT INTO VEMSER_DAYVIDSON.ESTUDANTE 
(ID_ESTUDANTE, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO)
VALUES(SEQ_ESTUDANTE.NEXTVAL, 'Fernanda', TO_DATE('03-04-1990', 'dd-mm-yyyy'), 1003, 'S' )

INSERT INTO VEMSER_DAYVIDSON.ESTUDANTE 
(ID_ESTUDANTE, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO)
VALUES(SEQ_ESTUDANTE.NEXTVAL, 'Alfe', TO_DATE('03-04-1990', 'dd-mm-yyyy'), 1004, 'N' )

INSERT INTO VEMSER_DAYVIDSON.ESTUDANTE 
(ID_ESTUDANTE, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO)
VALUES(SEQ_ESTUDANTE.NEXTVAL, 'Gilberto', TO_DATE('03-04-1990', 'dd-mm-yyyy'), 1005, 'S' )

INSERT INTO VEMSER_DAYVIDSON.ESTUDANTE 
(ID_ESTUDANTE, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO)
VALUES(SEQ_ESTUDANTE.NEXTVAL, 'Ralph', TO_DATE('03-04-1990', 'dd-mm-yyyy'), 1006, 'N' )

INSERT INTO VEMSER_DAYVIDSON.ESTUDANTE 
(ID_ESTUDANTE, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO)
VALUES(SEQ_ESTUDANTE.NEXTVAL, 'Bob', TO_DATE('03-04-1990', 'dd-mm-yyyy'), 1007, 'S' )

INSERT INTO VEMSER_DAYVIDSON.ESTUDANTE 
(ID_ESTUDANTE, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO)
VALUES(SEQ_ESTUDANTE.NEXTVAL, 'Silva', TO_DATE('03-04-1990', 'dd-mm-yyyy'), 1008, 'N' )

INSERT INTO VEMSER_DAYVIDSON.ESTUDANTE 
(ID_ESTUDANTE, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO)
VALUES(SEQ_ESTUDANTE.NEXTVAL, 'Anakim', TO_DATE('03-04-1990', 'dd-mm-yyyy'), 1009, 'S' )

INSERT INTO VEMSER_DAYVIDSON.ESTUDANTE 
(ID_ESTUDANTE, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO)
VALUES(SEQ_ESTUDANTE.NEXTVAL, 'Luke', TO_DATE('03-04-1990', 'dd-mm-yyyy'), 1010, 'N' );

INSERT INTO VEMSER_DAYVIDSON.ESTUDANTE 
(ID_ESTUDANTE, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO)
VALUES(SEQ_ESTUDANTE.NEXTVAL, 'Rodolfo', TO_DATE('03-04-1990', 'dd-mm-yyyy'), 1011, 'N' );

SELECT * FROM VEMSER_DAYVIDSON.ESTUDANTE;
