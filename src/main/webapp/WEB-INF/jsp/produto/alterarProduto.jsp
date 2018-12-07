<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/jsp/home/header.jsp" />
        <div id="modelLista" role="dialog" >
            <div class="modal-dialog modal-lg modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Alterar Produto</h5>
                        
                    </div>

                    <div class="modal-body">

                        <form items="${produto}" var="produto" action="${pageContext.request.contextPath}/protegido/produto/alterar" method="post" class="form-group">
                            
                            <input type="text" style="display: none" value="${funcionario.getCodFilial()}" class="form-control" id="filial" name="filial" value="${sessionScope.funcionario.getCodFilial()}">
                            <input type="text" style="display: none" value="${produto.getIdAutor()}" class="form-control" id="idAutor" name="idAutor">
                            <input type="text" style="display: none" value="${produto.getIdEditora()}" class="form-control" id="idEditora" name="idEditora">

                            <label>Cod:</label><input value="${produto.getId()}" type="text" class="form-control" id="cod" name="cod" readonly>

                            <label>Editora:</label><input value="${produto.getEditora()}" type="text" class="form-control" id="editora" name="editora">

                            <label>Autor:</label><input value="${produto.getAutor()}" type="text"  class="form-control" id="autor" name="autor">

                            <label>Titulo:</label><input value="${produto.getTitulo()}" type="text" class="form-control" id="titulo" name="titulo" >

                            Descrição<br>

                            <textarea  cols="100" rows="10" class="form-control" id="descricao" name="descricao"> <c:out value="${produto.getDescricao()}" /></textarea><br>

                            <label>Quantidade:</label><input value="${produto.getQuantidade()}" type="text" class="form-control" id="quantidade" name="quantidade">	

                            <label>Valor Unitário:</label><input value="${produto.getValor()}" type="text" class="form-control" id="valorunitario" name="valorunitario" >

                            <div class="modal-footer">
                                <a href="${pageContext.request.contextPath}/protegido/produto/listar">   
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