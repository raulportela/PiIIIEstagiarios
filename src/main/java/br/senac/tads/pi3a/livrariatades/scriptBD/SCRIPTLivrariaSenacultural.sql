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
CREATE TABLE Frases(
id INT AUTO_INCREMENT,
frase VARCHAR (400) NOT NULL,
autor VARCHAR (70),
PRIMARY KEY (id)); 

INSERT INTO FRASES VALUES (default, 'Se você traçar metas absurdamente altas e falhar, seu fracasso será muito melhor que o sucesso de todos', 'James Cameron, cineasta');
INSERT INTO FRASES VALUES (default, 'O sucesso normalmente vem para quem está ocupado demais para procurar por ele', 'Henry David Thoreau,');
INSERT INTO FRASES VALUES (default, 'A vida é melhor para aqueles que fazem o possível para ter o melhor', 'John Wooden, jogador e treinador de basquete');
INSERT INTO FRASES VALUES (default, 'Os empreendedores falham, em média, 3,8 vezes antes do sucesso final. O que separa os bem-sucedidos dos outros é a persistência', ' Lisa M. Amos, executiva');
INSERT INTO FRASES VALUES (default, 'Se você não está disposto a arriscar, esteja disposto a uma vida comum', ' Jim Rohn, empreendedor');
INSERT INTO FRASES VALUES (default, 'Escolha uma ideia. Faça dessa ideia a sua vida. Pense nela, sonhe com ela, viva pensando nela. Deixe cérebro, músculos, nervos, todas as partes do seu corpo serem preenchidas com essa ideia. Esse é o caminho para o sucesso', 'Swami Vivekananda');
INSERT INTO FRASES VALUES (default, 'Para de perseguir o dinheiro e comece a perseguir o sucesso', 'Tony Hsieh, empreendedor');
INSERT INTO FRASES VALUES (default, 'Todos os seus sonhos podem se tornar realidade se você tem coragem para persegui-los', 'Walt Disney, desenhista e empreendedor');
INSERT INTO FRASES VALUES (default, 'Ter sucesso é falhar repetidamente, mas sem perder o entusiasmo', 'Winston Churchill, político');
INSERT INTO FRASES VALUES (default, 'Sempre que você vir uma pessoa de sucesso, você sempre verá as glórias, nunca os sacrifícios que a levaram até ali', 'Vaibhav Shah, pensador');
INSERT INTO FRASES VALUES (default, 'Sucesso? Eu não sei o que isso significa. Eu sou feliz. A definição de sucesso varia de pessoa para pessoa. Para mim, sucesso é paz anterior', 'Denzel Washington, ator');
INSERT INTO FRASES VALUES (default, 'Oportunidades não surgem. É você que as cria', 'Chris Grosser, fotógrafo');
INSERT INTO FRASES VALUES (default, 'Não tente ser uma pessoa de sucesso. Em vez disso, seja uma pessoa de valor', 'Albert Einstein, físico');
INSERT INTO FRASES VALUES (default, 'Não é o mais forte que sobrevive, nem o mais inteligente. Quem sobrevive é o mais disposto à mudança', 'Charles Darwin, biólogo');
INSERT INTO FRASES VALUES (default, 'Ninguém pode fazer você se sentir inferior sem o seu consentimento"', 'Eleanor Roosevelt, primeira-dama dos EUA');
INSERT INTO FRASES VALUES (default, 'O que nos parece uma provação amarga pode ser uma bênção disfarçada', ' Oscar Wilde, escritor');
INSERT INTO FRASES VALUES (default, 'Há dois tipos de pessoa que vão te dizer que você não pode fazer a diferença neste mundo: as que têm medo de tentar e as que têm medo de que você se dê bem', 'Ray Goforth, executivo');
INSERT INTO FRASES VALUES (default, 'Comece de onde você está. Use o que você tiver. Faça o que você puder', 'Arthur Ashe, tenista');
INSERT INTO FRASES VALUES (default, 'O sucesso é a soma de pequenos esforços repetidos dia após dia', 'Robert Collier, escritor');
INSERT INTO FRASES VALUES (default, 'Sonhar grande e sonhar pequeno dá o mesmo trabalho. Sonhe grande!!', 'Jorge Paulo Lemann, empreendedor');
INSERT INTO FRASES VALUES (default, 'Muitas das falhas da vida ocorrem quando não percebemos o quão próximos estávamos do sucesso na hora em que desistimos', 'Edson August');
INSERT INTO FRASES VALUES (default, 'Ser feliz é encontrar força no perdão, esperanças nas batalhas, segurança no palco do medo, amor nos desencontros. É agradecer a Deus a cada minuto pelo milagre da vida.
', 'Augusto Cury');
INSERT INTO FRASES VALUES (default, 'O bom humor é um dos melhores artigos de vestuário que se deve usar em sociedade.', 'William Makepeace Thackeray');

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
nivelFuncao VARCHAR (20),
rg VARCHAR (18),
PRIMARY KEY (id),
FOREIGN KEY (idPessoa) REFERENCES Pessoa (id));

INSERT INTO Funcionario VALUES (1, 1, 1, 1, 'adminsp', '$2a$10$96I1zNKS57CYDRMIUhsk1ehuVwHUwq9IOUT5/yCOHztiuaquEnrNa', 'root', '1111111111' );  
INSERT INTO Funcionario VALUES (2, 2, 2, 1, 'adminbr', '$2a$10$96I1zNKS57CYDRMIUhsk1ehuVwHUwq9IOUT5/yCOHztiuaquEnrNa', 'root', '2222222222' );   
INSERT INTO Funcionario VALUES (3, 3, 3, 1, 'admincg', '$2a$10$96I1zNKS57CYDRMIUhsk1ehuVwHUwq9IOUT5/yCOHztiuaquEnrNa', 'root', '3333333333' );   
INSERT INTO Funcionario VALUES (4, 4, 4, 1, 'adminjv', '$2a$10$96I1zNKS57CYDRMIUhsk1ehuVwHUwq9IOUT5/yCOHztiuaquEnrNa', 'root', '4444444444' );   

CREATE TABLE Contato(
id INT AUTO_INCREMENT,
idPessoa INT,
email VARCHAR (60),
telefone LONG,
celular LONG,
PRIMARY KEY (id),
FOREIGN KEY (idPessoa) REFERENCES Pessoa (id));

INSERT INTO Contato VALUES (1, 1, 'adminsp@adminsp.com', 11111111, 111111111);  
INSERT INTO Contato VALUES (2, 2, 'adminbr@adminbr.com', 22222222, 222222222);  
INSERT INTO Contato VALUES (3, 3, 'admincg@admincg.com', 33333333, 333333333);  
INSERT INTO Contato VALUES (4, 4, 'adminjv@adminjv.com', 44444444, 444444444);  

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

INSERT INTO Endereco VALUES (1, 1, 'rua admin sp', 1, 'admin sp', 1111111, '');  
INSERT INTO Endereco VALUES (2, 2, 'rua admin brasilia', 2, 'admin br', 2222222, '');  
INSERT INTO Endereco VALUES (3, 3, 'rua admin campo grande', 3, 'admin cg', 3333333, '');  
INSERT INTO Endereco VALUES (4, 4, 'rua admin joinville', 4, 'admin jv', 4444444, '');  

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
PRIMARY KEY (id),
FOREIGN KEY(idAutor) REFERENCES Autor(id),
FOREIGN KEY(idEditora) REFERENCES Editora(id));

CREATE TABLE Venda(
id INT AUTO_INCREMENT,
idPessoa INT,
notaFiscal VARCHAR(10) NOT NULL,
dtCompra DATE NOT NULL,
valorTotal FLOAT NOT NULL,
codFilial INT NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY(idPessoa) REFERENCES Pessoa(id)),
FOREIGN KEY(codFilial) REFERENCES Filial(id);

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

SELECT * FROM Funcionario;

-- Selecionar funcionario
SELECT * FROM PESSOA P
JOIN FUNCIONARIO F
ON P.ID = F.IDPESSOA
JOIN CONTATO CT
ON P.ID = CT.IDPESSOA
JOIN ENDERECO E
ON P.ID = E.IDPESSOA;

update funcionario set senha= 'Dominio55'
where id = 5;

SELECT * FROM Filial;
Select * From Endereco;
-- drop database livrariasenacultural;