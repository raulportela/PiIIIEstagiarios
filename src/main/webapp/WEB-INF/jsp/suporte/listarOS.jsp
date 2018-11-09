<%-- 
    Document   : cadastrarOS
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
                        <h5 class="modal-title" id="exampleModalLabel">Ordens de Serviço</h5><input class="form-control pesquisa"type="text" placeholder="Pesquisar" name="">
                        <center><h6><a href="${pageContext.request.contextPath}/suporte/cadastrar">+</a></h6></center>
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
                                    <th scope="col">Código OS</th>
                                    <th scope="col">Código Funcionario</th>
                                    <th scope="col">O. Serviço</th>
                                    <th scope="col">Status</th>
                                    <th scope="col">Data Abertura</th>
                                    <th scope="col">Data Fechamento</th>
                                    <th scope="col">Detalhes</th>
                                    <th scope="col">Finalizar OS</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${suportes}" var="suporte"> 
                                    <tr data-toggle="modal" data-target="#modelClient">
                                        <th><c:out value="${suporte.getId()}" /></th>
                                        <th><c:out value="${suporte.getCodFuncionario()}" /></th>
                                        <td><c:out value="${suporte.getNomeChamado()}" /></td>
                                        <td><c:out value="${suporte.isStatusChamado()}" /></td>
                                        <td><c:out value="${suporte.getDataAbertura()}" /></td>
                                        <td><c:out value="${suporte.getDataFechamento()}" /></td>
                                        <td>
                                            <a href="${pageContext.request.contextPath}/suporte/alterar?opcao=1&id=${suporte.getId()}">
                                                <button type="button" class="btn btn-primary" data-dismiss="modal" >Detalhes</button>
                                            </a>
                                        </td>
                                        <td>
                                            <a href="${pageContext.request.contextPath}/suporte/alterar?opcao=2&id=${suporte.getId()}">
                                                <button type="button" class="btn btn-primary" data-dismiss="modal">Finalizar OS</button>
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
