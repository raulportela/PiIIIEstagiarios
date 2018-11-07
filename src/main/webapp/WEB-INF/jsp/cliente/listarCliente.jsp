<%-- 
    Document   : cadastrarCLiente
    Created on : 17/10/2018, 22:57:40
    Author     : Maia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="../css/style.css">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </head>
    <body>
        <c:import url="/WEB-INF/jsp/home/cabecalho.jsp" />

        <div id="modelLista" role="dialog" >

            <div class="modal-dialog modal-lg modal-dialog-centered" role="document">

                <div class="modal-content">

                    <div class="modal-header">

                        <h5 class="modal-title" id="exampleModalLabel">Lista de Clientes</h5><input class="form-control pesquisa"type="text" placeholder="Pesquisar" name="">

                        <center><h6><a href="${pageContext.request.contextPath}/cliente/cadastrar">+</a></h6></center>
                        <a href="${pageContext.request.contextPath}/home">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </a>

                    </div>
                    <div class="modal-body">

                        <table class="table table-hover">

                            <thead>

                                <tr>
                                    <th scope="col">CPF</th>
                                    <th scope="col">Nome</th>
                                    <th scope="col">Tel</th>
                                    <th scope="col">E-mail</th>
                                    <th scope="col">Detalhes</th>
                                    <th scope="col">Excluir</th>
                                    
                                </tr>

                            </thead>
                            <tbody>

                                <c:forEach items="${clientes}" var="cliente"> 
                                    <tr data-toggle="modal" data-target="#modelClient">
                                        <th><c:out value="${cliente.getCpf()}" /></th>
                                        <td><c:out value="${cliente.getNome()}" /></td>
                                        <td><c:out value="${cliente.getContato().getTelefone()}" /></td>
                                        <td><c:out value="${cliente.getContato().getEmail()}" /></td>
                                        <td>
                                            <a href="${pageContext.request.contextPath}/cliente/alterar?opcao=1&cpf=${cliente.getCpf()}">
                                                <button type="button" class="btn btn-primary" data-dismiss="modal" >Detalhes</button>
                                            </a>
                                        </td>
                                        <td>
                                            <a href="${pageContext.request.contextPath}/cliente/listar?opcao=2&cpf=${cliente.getCpf()}">
                                                <button type="button" class="btn btn-primary" data-dismiss="modal" alert="Desa realmente excluir ${cliente.getNome()}">Excluir</button>
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>

                            </tbody>
                        </table>
                    </div>

                    <div class="modal-footer">
                        <a href="${pageContext.request.contextPath}/home">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Sair</button>
                        </a>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>

