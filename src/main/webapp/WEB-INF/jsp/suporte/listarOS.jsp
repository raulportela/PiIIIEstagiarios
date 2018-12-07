<%-- 
    Document   : cadastrarOS
    Created on : 17/10/2018, 22:57:40
    Author     : Maia
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/jsp/home/header.jsp" />
        <div id="modelLista" role="dialog" >
            <div class="modal-dialog modal-lg modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Lista de OS</h5>
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
                                            <a href="${pageContext.request.contextPath}/protegido/suporte/alterar?opcao=1&id=${suporte.getId()}">
                                                <button type="button" class="btn btn-primary" data-dismiss="modal" >Detalhes</button>
                                            </a>
                                        </td>
                                        <td>
                                            <a href="${pageContext.request.contextPath}/protegido/suporte/alterar?opcao=2&id=${suporte.getId()}">
                                                <button type="button" class="btn btn-primary" data-dismiss="modal">Finalizar OS</button>
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="modal-footer">
                        <a href="${pageContext.request.contextPath}/protegido/suporte/cadastrar">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Novo suporte</button>
                        </a>
                        <a href="${pageContext.request.contextPath}/protegido/home">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Sair</button>
                        </a>
                    </div>
                </div>
            </div>
        </div>

<c:import url="/WEB-INF/jsp/home/footer.jsp" />
