<%-- 
    Document   : cadastrarCLiente
    Created on : 17/10/2018, 22:57:40
    Author     : Maia
--%>


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/jsp/home/header.jsp" />
<div id="modelLista" role="dialog" >
    <div class="modal-dialog modal-lg modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <a>
                    <h5 class="modal-title" id="exampleModalLabel">Lista de Clientes</h5>
                </a>
            </div>
            <div class="modal-body">
                <table class="table table-hover">
                    <thead>
                                                <tr>
                            <th scope="col"><a href="${pageContext.request.contextPath}/cliente/listar?ordem=P.cpf ASC">CPF <i class="fa fa-angle-down"></i></a></th>
                            <th scope="col"><a href="${pageContext.request.contextPath}/cliente/listar?ordem=P.nome ASC">Nome <i class="fa fa-angle-down"></i></a></th>
                            <th scope="col"><a href="${pageContext.request.contextPath}/cliente/listar?ordem=CT.telefone ASC">Telefone <i class="fa fa-angle-down"></i></a></th>
                            <th scope="col"><a href="${pageContext.request.contextPath}/cliente/listar?ordem=CT.email ASC">E-mail <i class="fa fa-angle-down"></i></a></th>
                            <th scope="col"><a href="${pageContext.request.contextPath}/cliente/listar?ordem=C.disponivel DESC">Status <i class="fa fa-angle-down"></i></a></th>
                        </tr>

                    </thead>
                    <tbody>
                        <c:forEach items="${clientes}" var="cliente"> 
                            <tr data-toggle="modal" data-target="#modelClient">
                                <th><c:out value="${cliente.getCpf()}" /></th>
                                <td><c:out value="${cliente.getNome()} ${cliente.getSobrenome()}"/> <a href="${pageContext.request.contextPath}/venda/efetuar?vender=1&cpf=${cliente.getCpf()}" <i class="fa fa-shopping-cart"></a></i></td>
                                <td><c:out value="${cliente.getContato().getTelefone()}" /></td>
                                <td><c:out value="${cliente.getContato().getEmail()}" /></td>

                                <c:if test="${cliente.isDisponivel() == true }">
                                    <td style="color: #0AC740"><c:out value="Ativo" /></td>
                                </c:if> 
                                <c:if test="${cliente.isDisponivel() == false}">
                                    <td style="color: red"><c:out value="Desativo" /></td>
                                </c:if>
                                <td>
                                    <a href="${pageContext.request.contextPath}/cliente/alterar?opcao=1&cpf=${cliente.getCpf()}">
                                        <button type="button" class="btn btn-primary" data-dismiss="modal" >Detalhes</button>
                                    </a>
                                </td>
                                <c:if test="${cliente.isDisponivel() == true }">
                                    <td>
                                        <a href="${pageContext.request.contextPath}/cliente/alterar?opcao=2&cpf=${cliente.getCpf()}">
                                            <button type="button" class="btn btn-primary" data-dismiss="modal">Desativar</button>
                                        </a>
                                    </td>
                                </c:if>
                                <c:if test="${cliente.isDisponivel() == false }">
                                    <td>
                                        <a href="${pageContext.request.contextPath}/cliente/alterar?opcao=3&cpf=${cliente.getCpf()}">
                                            <button type="button" class="btn btn-primary" data-dismiss="modal">Reativar</button>
                                        </a>
                                    </td>
                                </c:if>
                                
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="modal-footer">
                <a href="${pageContext.request.contextPath}/cliente/cadastrar">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Novo cliente</button>
                </a>
                <a href="${pageContext.request.contextPath}/home">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Sair</button>
                </a>
            </div>
        </div>
    </div>
</div>
<c:import url="/WEB-INF/jsp/home/footer.jsp" />
