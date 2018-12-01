<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/jsp/home/header.jsp" />
        <div id="modelLista" role="dialog" >
            <div class="modal-dialog modal-lg modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Cadastrar Produtos</h5>
                        </a>
                    </div>
                    <div class="modal-body">

                        <form action="${pageContext.request.contextPath}/produto/cadastrar" method="post" class="form-group">

                            <label>Editora:</label><input type="text" class="form-control" id="editora" name="editora">

                            <label>Autor:</label><input type="text" class="form-control" id="autor" name="autor">

                            <label>Titulo:</label><input type="text" class="form-control" id="titulo" name="titulo" >

                            Descrição<br>
                            <textarea cols="100" rows="10"class="form-control" id="descricao" name="descricao"></textarea><br>


                            <label>Quantidade:</label><input type="text" class="form-control" id="quantidade" name="quantidade">	

                            <label>Valor Unitário:</label><input type="text" class="form-control" id="valorunitario" name="valorunitario" >


                            <div class="modal-footer">
                                <a href="${pageContext.request.contextPath}/home">   
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                                </a>

                                <button type="submit" class="btn btn-primary" >Cadastrar</button>

                            </div>
                        </form>

                    </div>
                </div>
            </div>
        </div>

<c:import url="/WEB-INF/jsp/home/footer.jsp" />