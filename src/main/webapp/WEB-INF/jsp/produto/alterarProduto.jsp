<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/jsp/home/header.jsp" />
        <div id="modelLista" role="dialog" >
            <div class="modal-dialog modal-lg modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Alterar Produto</h5><input class="form-control pesquisa"type="text" placeholder="Pesquisar" name="">
                        
                    </div>

                    <div class="modal-body">

                        <form items="${produto}" var="produto" action="${pageContext.request.contextPath}/produto/alterar" method="post" class="form-group">

                            <label>Cod:</label><input value="${produto.getId()}" type="text" class="form-control" id="cod" name="cod" readonly>

                            <label>Editora:</label><input value="${produto.getEditora()}" type="text" class="form-control" id="editora" name="editora">

                            <label>Autor:</label><input value="${produto.getAutor()}" type="text"  class="form-control" id="autor" name="autor">

                            <label>Titulo:</label><input value="${produto.getTitulo()}" type="text" class="form-control" id="titulo" name="titulo" >

                            Descrição<br>

                            <textarea  cols="100" rows="10" class="form-control" id="descricao" name="descricao"> <c:out value="${produto.getDescricao()}" /></textarea><br>

                            <label>Quantidade:</label><input value="${produto.getQuantidade()}" type="text" class="form-control" id="quantidade" name="quantidade">	

                            <label>Valor Unitário:</label><input value="${produto.getValor()}" type="text" class="form-control" id="valorunitario" name="valorunitario" >

                            <div class="modal-footer">
                                <a href="${pageContext.request.contextPath}/home">   
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                                </a>
                                <button type="submit" class="btn btn-primary" >Alterar</button>
                            </div>
                        </form>

                    </div>
                </div>
            </div>
        </div>

<c:import url="/WEB-INF/jsp/home/footer.jsp" />