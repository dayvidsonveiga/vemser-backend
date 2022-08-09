DROP TABLE USUARIO;

CREATE TABLE USUARIO(
                        ID_USUARIO NUMBER NOT NULL,
                        LOGIN varchar2(512) UNIQUE NOT NULL,
                        SENHA varchar2(512) NOT NULL,
                        PRIMARY KEY(ID_USUARIO)
);

DROP SEQUENCE seq_usuario;

CREATE SEQUENCE seq_usuario
    START WITH     1
    INCREMENT BY   1
    NOCACHE
 NOCYCLE;

insert into usuario (id_usuario, login, senha)
values (seq_usuario.nextval, 'user', '$2a$10$OSdKzw0K0LaLPyj1EqOWte8U.cpTftzycrK5eQ/Wgu2GfB4wgpWu6');