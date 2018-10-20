<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clientes cadastrado</title>
    </head>
    <body>
        <h1>Cadastro de Cliente - Resultado</h1>
        <p>Nome: <c:out value="${cli.nome}" /></p> 
        <p>Sobrenome: <c:out value="${cli.sobrenome}" /></p>
        <p>CPF: <c:out value="${cli.cpf}" /></p>
        <p>DATA NASC: <c:out value="${cli.dataNascimento}" /></p>
        <p>EMAIL: <c:out value="${cli.email}" /></p>
        
        <p>ENDERECO: <c:out value="${cli.endereco}" /></p>
        
       
        
    </body>
</html>
