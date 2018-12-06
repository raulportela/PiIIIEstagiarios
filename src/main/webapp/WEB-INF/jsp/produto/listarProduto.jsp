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
                            <th scope="col"><a href="${pageContext.request.contextPath}/protegido/produto/listar?ordem=L.id ASC">Cod <i class="fa fa-angle-down"></i></a></th>
                            <th scope="col"><a href="${pageContext.request.contextPath}/protegido/produto/listar?ordem=L.titulo ASC">Titulo <i class="fa fa-angle-down"></i></a></th>
                            <th scope="col" style="color: #449DD5">Vender</th>
                            <th scope="col"><a href="${pageContext.request.contextPath}/protegido/produto/listar?ordem=A.nome ASC">Autor <i class="fa fa-angle-down"></i></a></th>
                            <th scope="col"><a href="${pageContext.request.contextPath}/protegido/produto/listar?ordem=FT.quantidade DESC">Qtd <i class="fa fa-angle-down"></i></a></th>
                            <th scope="col"><a href="${pageContext.request.contextPath}/protegido/produto/listar?ordem=FT.valor ASC">Valor <i class="fa fa-angle-down"></i></a></th>
                            <th scope="col"><a href="${pageContext.request.contextPath}/protegido/produto/listar?ordem=L.disponivel DESC">Status <i class="fa fa-angle-down"></i></a></th>

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${produtos}" var="produto"> 
                            <tr data-toggle="modal" data-target="#modelProduto">
                                <th><c:out value="${produto.getId()}" /></th>
                                <td><c:out value="${produto.getTitulo()}" /></td>
                                <td><center><a href="${pageContext.request.contextPath}/protegido/venda/efetuar?opcao=1&produtovenda=${produto.getId()}"><i class="fa fa-shopping-cart"></i></a></center></td>
                        <td><c:out value="${produto.getAutor()}" /></td>
                        <c:if test="${produto.getQuantidade() >= 10}">
                            <td style="color: #0AC740"><c:out value="${produto.getQuantidade()}" /></td>
                        </c:if> 
                        <c:if test="${produto.getQuantidade() < 10}">
                            <td style="color: red"><c:out value="${produto.getQuantidade()}" /></td>
                        </c:if>
                        <td><c:out value="${produto.getValor()}" /></td>
                        <c:if test="${produto.isDisponivel() == true }">
                            <td style="color: #0AC740"><c:out value="Ativo" /></td>
                        </c:if> 
                        <c:if test="${produto.isDisponivel() == false}">
                            <td style="color: red"><c:out value="Desativo" /></td>
                        </c:if>
                        <td>
                            <a href="${pageContext.request.contextPath}/protegido/produto/alterar?opcao=1&id=${produto.getId()}">
                                <button type="button" class="btn btn-primary" data-dismiss="modal" >Detalhes</button>
                            </a>
                        </td>
                        </tr>
                    </c:forEach>
                    <div class="modal-footer">
                        <a href="${pageContext.request.contextPath}/protegido/produto/cadastrar">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Novo produto</button>
                        </a>
                        <a href="${pageContext.request.contextPath}/protegido/home">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Sair</button>
                        </a>
                    </div>
                    </tbody>
                </table>
            </div>
            <c:import url="/WEB-INF/jsp/home/footer.jsp" />
