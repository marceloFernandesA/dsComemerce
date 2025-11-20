INSERT INTO tb_participante (nome, email) values ('José Silva','jose@gmail.com');
INSERT INTO tb_participante (nome, email) values ('Tiago Faria','tiago@gmail.com');
INSERT INTO tb_participante (nome, email) values ('Maria do Rosário','maria@gmail.com');
INSERT INTO tb_participante (nome, email) values ('Teresa Silva','teresa@gmail.com');

INSERT INTO tb_categoria(descricao) VALUES ('Curso');
INSERT INTO tb_categoria(descricao) VALUES ('Oficina');

INSERT INTO tb_atividade (nome, descricao,preco,categoria_id) values ('Curso de HTML','Aprenda HTML de forma prática',80.00,1);
INSERT INTO tb_atividade (nome, descricao,preco,categoria_id) values ('Oficina de GitHub','Controle versões do seu projeto',50.00,2);

INSERT INTO tb_participante_atividade (participante_id, atividades_id) values (1,1);
INSERT INTO tb_participante_atividade (participante_id, atividades_id) values (1,2);
INSERT INTO tb_participante_atividade (participante_id, atividades_id) values (2,1);
INSERT INTO tb_participante_atividade (participante_id, atividades_id) values (3,1);
INSERT INTO tb_participante_atividade (participante_id, atividades_id) values (3,2);
INSERT INTO tb_participante_atividade (participante_id, atividades_id) values (4,2);

INSERT INTO tb_bloco (inicio, fim, atividades_id) VALUES ( TIMESTAMP '2017-09-25 08:00:00',TIMESTAMP '2017-09-25 11:00:00', 1);

INSERT INTO tb_bloco (inicio, fim, atividades_id)VALUES ( TIMESTAMP '2017-09-25 14:00:00',  TIMESTAMP '2017-09-25 18:00:00',2);

INSERT INTO tb_bloco (inicio, fim, atividades_id)VALUES ( TIMESTAMP '2017-09-26 08:00:00',TIMESTAMP '2017-09-26 11:00:00', 2);









