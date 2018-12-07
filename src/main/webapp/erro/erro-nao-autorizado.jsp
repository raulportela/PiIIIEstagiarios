<%-- 
    Document   : erro-nao-autorizado
    Created on : 02/12/2018, 19:44:36
    Author     : Maia's
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ERRO</title>
    </head>
    <body>
        <h1>Usuário não tem permissão para acessar a página.</h1>
        <a href="${pageContext.request.contextPath}/protegido/home">
            <button type="button" class="btn btn-secondary" data-dismiss="modal">Voltar para Home</button>
        </a>
    </body>
</html>

