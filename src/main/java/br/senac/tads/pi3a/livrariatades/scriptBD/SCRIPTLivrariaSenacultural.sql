CREATE DATABASE LivrariaSenacultural;

USE LivrariaSenacultural;

CREATE TABLE Filial(
id INT AUTO_INCREMENT,
nomeFilial VARCHAR (60),
PRIMARY KEY (id));

INSERT INTO Filial VALUES (default, 'São Paulo');
INSERT INTO Filial VALUES (default, 'Brasília');
INSERT INTO Filial VALUES (default, 'Campina Grande');
INSERT INTO Filial VALUES (default, 'Joinville');

CREATE TABLE Pessoa(
id INT AUTO_INCREMENT,
nome VARCHAR (20) NOT NULL,
sobrenome VARCHAR (60) NOT NULL,
cpf VARCHAR(11) NOT NULL UNIQUE,
dataNascimento DATE NOT NULL,
codFilial INT,
PRIMARY KEY (id),
FOREIGN KEY (codFilial) REFERENCES Filial (id)); 	

INSERT INTO Pessoa VALUES (default, 'Administrador', 'São Paulo', 11111111111, '2000-1-1', 1);
INSERT INTO Pessoa VALUES (default, 'Administrador', 'Brasília', 22222222222, '2000-1-1', 2);
INSERT INTO Pessoa VALUES (default, 'Administrador', 'Campina Grande', 33333333333, '2000-1-1', 3);
INSERT INTO Pessoa VALUES (default, 'Administrador', 'Joinville', 44444444444, '2000-1-1', 4);

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
senha VARCHAR (500),
nivelFuncao INT NOT NULL,
rg VARCHAR (18),
PRIMARY KEY (id),
FOREIGN KEY (idPessoa) REFERENCES Pessoa (id));

INSERT INTO Funcionario VALUES (1, 1, 1, 1, 'adminsp', '$2a$10$96I1zNKS57CYDRMIUhsk1ehuVwHUwq9IOUT5/yCOHztiuaquEnrNa', 4, '1111111111' );  
INSERT INTO Funcionario VALUES (2, 2, 2, 1, 'adminbr', '$2a$10$96I1zNKS57CYDRMIUhsk1ehuVwHUwq9IOUT5/yCOHztiuaquEnrNa', 4, '2222222222' );   
INSERT INTO Funcionario VALUES (3, 3, 3, 1, 'admincg', '$2a$10$96I1zNKS57CYDRMIUhsk1ehuVwHUwq9IOUT5/yCOHztiuaquEnrNa', 4, '3333333333' );   
INSERT INTO Funcionario VALUES (4, 4, 4, 1, 'adminjv', '$2a$10$96I1zNKS57CYDRMIUhsk1ehuVwHUwq9IOUT5/yCOHztiuaquEnrNa', 4, '4444444444' );   

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
codFilial INT,
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

CREATE TABLE FilialTemLivro(
id INT AUTO_INCREMENT,
idFilial INT,
idLivro INT,
quantidade INT NOT NULL,
valor FLOAT NOT NULL,
PRIMARY KEY(id),
FOREIGN KEY (idFilial) REFERENCES Filial(id),
FOREIGN KEY (idLivro) REFERENCES Livro(id));

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

SELECT * FROM PESSOA;

-- Selecionar funcionario
SELECT * FROM PESSOA P
JOIN FUNCIONARIO F
ON P.ID = F.IDPESSOA
JOIN CONTATO CT
ON P.ID = CT.IDPESSOA
JOIN ENDERECO E
ON P.ID = E.IDPESSOA;

SELECT * FROM Funcionario;

-- drop database livrariasenacultural;