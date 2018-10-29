<%-- 
    Document   : cadastraCliente1
    Created on : 25/10/2018, 17:33:52
    Author     : Jeferson Nolasco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="style.css">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </head>
    <body>
        <c:import url="cabecalho.jsp" />


        <div>

            <h5 class="modal-title" id="exampleModalLabel">Cadastrar</h5>

            <button type="button" class="close" data-dismiss="modal" aria-label="Close">

                <span aria-hidden="true">&times;</span>

            </button>

        </div>

        <div class="modal-body">

            <form action="${pageContext.request.contextPath}/cliente/cadastra" method="post" class="form-group">

                <label>Nome:</label><input type="text" class="form-control" id="nome" name="nome">

                <label>Sobrenome:</label><input type="text" class="form-control" id="sobrenome" name="sobrenome">

                <label>CPF:</label><input type="text" pattern="[0-9]+$"  class="form-control" id="cpf"  placeholder="000.000.000-00" name="cpf">

                <label>Nasc:</label><input type="date" pattern="[0-9]{2}\/[0-9]{2}\/[0-9]{4}$" min="1900-01-01" class="form-control" id="nasc" name="nasc">

                <label>E-mail:</label><input type="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" class="form-control" id="email" placeholder="email@email.com" name="email">

                <label>Telefone:</label><input type="tel" maxlength="15" pattern="[0-9]+$"  class="form-control" id="tel" placeholder="(xx) 9999-9999" name="tel">

                <label>Celular:</label><input type="cel" maxlength="15" pattern="[0-9]+$"  class="form-control" id="cel"  placeholder="(xx) 9999-9999" name="cel">

                <label>Rua:</label><input type="text" class="form-control" id="rua" name="rua">

                <label>Nº:</label><input type="text" class="form-control"  id="numero" name="numero">

                <label>Bairro:</label><input type="text" class="form-control"  id="bairro" name="bairro">

                <label>CEP:</label><input type="text" class="form-control"  id="cep" name="cep">

                <label>Complemento:</label><input type="text" class="form-control"  id="complemento" name="complemento">

                <div class="modal-footer">
                    <a href="${pageContext.request.contextPath}/cliente/home">   
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                    </a>

                    <button type="submit" class="btn btn-primary" >Cadastrar</button>

                </div>
            </form>

        </div>





    </body>
</html>