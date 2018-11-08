<%-- 
    Document   : home
    Created on : 25/10/2018, 13:46:35
    Author     : Jeferson Nolasco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
    <head>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="css/style.css">

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>    
    </head>
    <body>       

        <div class="row">
            <div class="col-12 top-menu">
                <div><h6>Bem Vindo!</h6></div>
            </div>
        </div>       
        <div class="row">
            <div class="col-2 offset-md-2 card-item list-group list-group-flush">
                <center><h6><a href="${pageContext.request.contextPath}/cliente/cadastrar">+</a></h6></center>
                <center><a href="${pageContext.request.contextPath}/cliente/listar"><img src="img/cliente.png" width="100" height="100"></a></center>
                <center><h1>Cliente</h1></center>

            </div>
            <div class="col-2 offset-md-1 card-item list-group list-group-flush">
                <center><h6><a href="${pageContext.request.contextPath}/funcionario/cadastrar">+</a></h6></center>
                <center><a href="${pageContext.request.contextPath}/funcionario/listar"><img src="img/Funcionario.png" width="100" height="100"></a></center>
                <center><h1>Funcionario</h1></center>

            </div>
            <div class="col-2 offset-md-1 card-item list-group list-group-flush">
                <center><h6><a href="${pageContext.request.contextPath}/produto/cadastrar">+</a></h6></center>
                <center><a href="${pageContext.request.contextPath}/produto/listar"><img src="img/Produto.png" width="100" height="100"></a></center>
                <center><h1>Produtos</h1></center>

            </div>

        </div>
        <div class="row">
            <div class="col-2 offset-md-2 card-item list-group list-group-flush">
                <center><h6><a  href="${pageContext.request.contextPath}/venda/efetuar">+</a></h6></center>
                <center><a href="listaProdutos.jsp"><img src="img/Venda.png" width="100" height="100"></a></center>
                <center><h1>Venda</h1></center>
            </div>

            <div class="col-2 offset-md-1 card-item list-group list-group-flush">
                <center><h6><a href="abrirChamado.jsp">+</a></h6></center>
                <center><a href=""><img src="img/Suporte.png" width="100" height="100"></a></center>
                <center><h1>Suporte</h1></center>
            </div>
            <div class="col-2 offset-md-1 card-item list-group list-group-flush">
                <center><a href=""><img src="img/Relatorio.png" width="100" height="100"></a></center>
                <center><h1>Relatorio</h1></center>

            </div>

        </div>

    </body>
</html>