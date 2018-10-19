CREATE DATABASE bdProjIntegrador;
USE bdProjIntegrador;

CREATE TABLE Cliente (
  CodCliente INT NOT NULL AUTO_INCREMENT,
  NomeCliente VARCHAR(255) NOT NULL,
  Cpf INT NOT NULL,
  DataNasc DATE,
  Email VARCHAR(255),
  Telefone1 INT,
  Telefone2 INT,
  Endereco VARCHAR(255),
  PRIMARY KEY (CodCliente)
);

