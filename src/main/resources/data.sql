INSERT INTO tb_autor (nome,email,descricao,created_At) VALUES ('Pedro','pedro@email.com','descricao de Pedro',NOW());
INSERT INTO tb_autor (nome,email,descricao,created_At) VALUES ('Maria','maria@email.com','descricao de Maria',NOW());
INSERT INTO tb_autor (nome,email,descricao,created_At) VALUES ('Artur','Artur@email.com','descricao de Artur',NOW());
INSERT INTO tb_autor (nome,email,descricao,created_At) VALUES ('Claudio','Claudio@email.com','descricao Claudio',NOW());
INSERT INTO tb_autor (nome,email,descricao,created_At) VALUES ('Telo','Telo@email.com','descricao de Telo',NOW());

INSERT INTO tb_categoria (nome_categoria) VALUES ('comédia');
INSERT INTO tb_categoria (nome_categoria) VALUES ('ação');
INSERT INTO tb_categoria (nome_categoria) VALUES ('suspense');
INSERT INTO tb_categoria (nome_categoria) VALUES ('terror');
INSERT INTO tb_categoria (nome_categoria) VALUES ('policial');
INSERT INTO tb_categoria (nome_categoria) VALUES ('drama');
INSERT INTO tb_categoria (nome_categoria) VALUES ('romance');

INSERT INTO tb_livro (titulo,resumo,sumario,preco,numero_Paginas,isbn,data_Publicacao,autor_id,categoria_id) VALUES ('titulo2','resumo2','sumario2',100,250,12354,'2022-07-13T20:50:07.12345Z',2,2);
INSERT INTO tb_livro (titulo,resumo,sumario,preco,numero_Paginas,isbn,data_Publicacao,autor_id,categoria_id) VALUES ('titulo1','resumo1','sumario1',125,500,12345,'2022-08-13T20:50:07.12345Z',1,1);
INSERT INTO tb_livro (titulo,resumo,sumario,preco,numero_Paginas,isbn,data_Publicacao,autor_id,categoria_id) VALUES ('titulo3','resumo3','sumario3',125,500,123543,'2022-09-13T20:50:07.12345Z',2,3);
