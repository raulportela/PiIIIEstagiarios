CREATE DATABASE LivrariaSenacultural;

USE LivrariaSenacultural;

CREATE TABLE Pessoa(
id INT AUTO_INCREMENT,
nome VARCHAR (20) NOT NULL,
sobrenome VARCHAR (60) NOT NULL,
cpf VARCHAR(11) NOT NULL UNIQUE,
dataNascimento DATE NOT NULL,
PRIMARY KEY (id)); 	

CREATE TABLE Cliente (
id INT AUTO_INCREMENT,
idPessoa INT,
codCliente INT,
disponivel boolean,
totalCompras INT,
PRIMARY KEY (id),
FOREIGN KEY (idPessoa) REFERENCES Pessoa (id));

CREATE TABLE Funcionario (
id INT AUTO_INCREMENT,
idPessoa INT,
codFuncionario INT,
disponivel boolean,
nomeUsuario VARCHAR (20),
senha INT,
nivelFuncao INT NOT NULL,
rg VARCHAR (18),
PRIMARY KEY (id),
FOREIGN KEY (idPessoa) REFERENCES Pessoa (id));

CREATE TABLE Contato(
id INT AUTO_INCREMENT,
idPessoa INT,
email VARCHAR (60),
telefone LONG,
celular LONG,
PRIMARY KEY (id),
FOREIGN KEY (idPessoa) REFERENCES Pessoa (id));

CREATE TABLE Endereco(
id INT NOT NULL AUTO_INCREMENT,
idPessoa int,
rua VARCHAR (60) NOT NULL,
numero INT NOT NULL,
bairro VARCHAR (30) NOT NULL,
cep INT NOT NULL,
complemento VARCHAR (100),
PRIMARY KEY (id),
FOREIGN KEY (idPessoa) REFERENCES Pessoa (id));

CREATE TABLE Editora(
id INT AUTO_INCREMENT,
nome VARCHAR (50) NOT NULL,
PRIMARY KEY(id));

CREATE TABLE Autor(
id INT AUTO_INCREMENT,
nomeCompleto VARCHAR (70),
PRIMARY KEY (id));

CREATE TABLE Livro(
id INT AUTO_INCREMENT,
idEditora INT,
idAutor INT,
disponivel boolean,
titulo VARCHAR (60) NOT NULL,
descricao VARCHAR (300) NOT NULL,
quantidade INT NOT NULL,
valor FLOAT NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY(idAutor) REFERENCES Autor(id),
FOREIGN KEY(idEditora) REFERENCES Editora(id));

CREATE TABLE Venda(
id INT AUTO_INCREMENT,
idPessoa INT,
notaFiscal VARCHAR(10) NOT NULL,
dtCompra DATE NOT NULL,
valorTotal FLOAT NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY(idPessoa) REFERENCES Pessoa(id));

CREATE TABLE ItemVenda(
id INT AUTO_INCREMENT,
idVenda INT,
idLivro INT,
quantidade INT,
valorProduto FLOAT,
PRIMARY KEY (id),
FOREIGN KEY (idLivro) REFERENCES Livro (id),
FOREIGN KEY (idVenda) REFERENCES Venda (id));

CREATE TABLE Suporte(
id INT AUTO_INCREMENT,
codFuncionario INT,
statusChamado boolean,
nomeChamado VARCHAR (50),
dataAbertura DATE,
dataFechamento DATE,
detalhe VARCHAR(300),
PRIMARY KEY (id),
FOREIGN KEY (codFuncionario) REFERENCES Funcionario(id));

-- Selecionar Livro
SELECT * FROM LIVRO L 
JOIN EDITORA E
ON L.IDEDITORA = E.ID
JOIN AUTOR A
ON L.IDAUTOR = A.ID;

-- Selecionar Cliente
SELECT * FROM PESSOA P
JOIN CLIENTE C
ON P.ID = C.IDPESSOA
JOIN CONTATO CT
ON P.ID = CT.IDPESSOA
JOIN ENDERECO E
ON P.ID = E.IDPESSOA;

-- Selecionar funcionario
SELECT * FROM PESSOA P
JOIN FUNCIONARIO F
ON P.ID = F.IDPESSOA
JOIN CONTATO CT
ON P.ID = CT.IDPESSOA
JOIN ENDERECO E
ON P.ID = E.IDPESSOA;

INSERT INTO PESSOA VALUES (3, 'Jeferson', 'nolasco', 43507576864, '1996-08-19');
INSERT INTO CLIENTE VALUES (3, 3, 1, 1, 0);
INSERT INTO CONTATO VALUES (3, 3, 'jefersonnls@hotmail.com', 1156116839, 11977544550);
insert into endereco values (3,3, 'mora depois do leo', 15,'uma bairro p cima', 04430250, '');
INSERT INTO FUNCIONARIO VALUES(1, 1, 0, 1, 'raul_portela', 558889, 1,'397524122');

UPDATE LIVRO SET DISPONIVEL=1, TITULO='Trepeça do jeh e luana', DESCRICAO='Casal maluco', QUANTIDADE=9, VALOR=28.90 
WHERE ID = 6;

INSERT INTO LIVRO VALUES (2, 1, 4, 1, 'JEZAO', 'MLK DAHORA MSM', 10, 2.50);

-- drop database livrariasenacultural;