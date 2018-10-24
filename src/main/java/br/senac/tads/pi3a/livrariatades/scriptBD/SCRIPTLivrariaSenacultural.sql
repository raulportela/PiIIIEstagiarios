CREATE DATABASE LivrariaSenacultural;

USE LivrariaSenacultural;

CREATE TABLE Pessoa(
id INT AUTO_INCREMENT,
nome VARCHAR (20) NOT NULL,
sobrenome VARCHAR (60) NOT NULL,
cpf LONG NOT NULL,
dataNascimento DATE NOT NULL,
PRIMARY KEY (id)); 	

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

CREATE TABLE Venda(
id INT AUTO_INCREMENT,
idCliente INT,
valorTotal FLOAT,
PRIMARY KEY (id));

CREATE TABLE ItemVenda(
id INT AUTO_INCREMENT,
idVenda INT,
nomeProduto VARCHAR(60),
valorProduto FLOAT,
PRIMARY KEY (id),
FOREIGN KEY (idVenda) REFERENCES Venda (id));

CREATE TABLE Cliente (
id INT AUTO_INCREMENT,
idPessoa INT,
CodCliente INT,
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

-- drop database livrariasenacultural;