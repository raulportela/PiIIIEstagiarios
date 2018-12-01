<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/jsp/home/header.jsp" />
        <div id="modelLista" role="dialog" >
            <div class="modal-dialog modal-lg modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Lista de Produtos</h5><input class="form-control pesquisa"type="text" placeholder="Pesquisar" name="">
                        
                    </div>
                    <div class="modal-body">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th scope="col">Cod</th>
                                    <th scope="col">Titulo</th>
                                    <th scope="col">Autor</th>
                                    <th scope="col">Quantidade</th>
                                    <th scope="col">Valor</th>
                                    <th scope="col">Detalhes</th>
                                    <th scope="col">Excluir</th>

                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${produtos}" var="produto"> 
                                    <tr data-toggle="modal" data-target="#modelProduto">
                                        <th><c:out value="${produto.getId()}" /></th>
                                        <td><c:out value="${produto.getTitulo()}" /></td>
                                        <td><c:out value="${produto.getAutor()}" /></td>
                                        <td><c:out value="${produto.getQuantidade()}" /></td>
                                        <td><c:out value="${produto.getValor()}" /></td>
                                        <td>
                                            <a href="${pageContext.request.contextPath}/produto/alterar?opcao=1&id=${produto.getId()}">
                                                <button type="button" class="btn btn-primary" data-dismiss="modal" >Detalhes</button>
                                            </a>
                                        </td>
                                        <td>
                                            <a href="${pageContext.request.contextPath}/produto/alterar?opcao=2&id=${produto.getId()}">
                                                <button type="button" class="btn btn-primary" data-dismiss="modal" >Excluir</button>
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
<c:import url="/WEB-INF/jsp/home/footer.jsp" />
