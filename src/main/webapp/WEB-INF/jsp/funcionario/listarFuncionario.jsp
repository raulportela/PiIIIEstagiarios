<%-- 
    Document   : cadastrarFuncionario
    Created on : 17/10/2018, 22:57:40
    Author     : dePaula
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/jsp/home/header.jsp" />
        <div id="modelLista" role="dialog" >
            <div class="modal-dialog modal-lg modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Lista de Funcionario</h5>
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

                                <c:forEach items="${funcionarios}" var="funcionario"> 
                                    <tr data-toggle="modal" data-target="#modelClient">
                                        <th><c:out value="${funcionario.getCpf()}" /></th>
                                        <td><c:out value="${funcionario.getNome()}" /></td>
                                        <td><c:out value="${funcionario.getContato().getTelefone()}" /></td>
                                        <td><c:out value="${funcionario.getContato().getEmail()}" /></td>
                                        <td>
                                            <a href="${pageContext.request.contextPath}/funcionario/alterar?opcao=1&cpf=${funcionario.getCpf()}">
                                                <button type="button" class="btn btn-primary" data-dismiss="modal" >Detalhes</button>
                                            </a>
                                        </td>
                                        <td>
                                            <a href="${pageContext.request.contextPath}/funcionario/alterar?opcao=2&cpf=${funcionario.getCpf()}">
                                                <button type="button" class="btn btn-primary" data-dismiss="modal">Excluir</button>
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


<c:import url="/WEB-INF/jsp/home/footer.jsp" />
