<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/jsp/home/header.jsp" />
<div id="modelLista" role="dialog" >
    <div class="modal-dialog modal-lg modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel" >Nome da Filial</h5>
                </a>
            </div>
            <div class="modal-body">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th scope="col">Data da venda</th>
                            <th scope="col">Preço da venda</th>
                            <th scope="col">Valor total</th>
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
                                    <a href="${pageContext.request.contextPath}/cliente/alterar?opcao=2&cpf=${cliente.getCpf()}">
                                        <button type="button" class="btn btn-primary" data-dismiss="modal" alert="Desa realmente excluir ${cliente.getNome()}">Excluir</button>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                    <tfoot>
                        <th scope="col">Total mensal: </th>
                    </tfoot>
                </table>
            </div>
            
        </div>
    </div>
</div>

<c:import url="/WEB-INF/jsp/home/footer.jsp" />