CREATE DATABASE bdProj; 

USE  bdProj; 
 
 
  CREATE TABLE Cliente ( 
    CodCliente INT NOT NULL AUTO_INCREMENT, 
    NomeCliente VARCHAR(255) , 
	Sobrenome VARCHAR(255),
    Cpf INT,
    PRIMARY KEY (CodCliente)
	); 

SELECT * FROM CLIENTE;