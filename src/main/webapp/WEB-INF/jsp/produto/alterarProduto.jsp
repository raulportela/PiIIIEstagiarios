<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="style.css">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </head>
    <body>
        <c:import url="/WEB-INF/jsp/home/cabecalho.jsp" />

        <div>

            <h5 class="modal-title" id="exampleModalLabel">Aleterar Produto</h5>

            <button type="button" class="close" data-dismiss="modal" aria-label="Close">

                <span aria-hidden="true">&times;</span>

            </button>

        </div>

        <div class="modal-body">

            <form items="${produto}" var="produto" action="${pageContext.request.contextPath}/produto/alterar?idautor=${produto.getIdEditora()}&ideditora=${produto.getIdAutor()}" method="post" class="form-group">
                
                <label>Cod:</label><input value="${produto.getId()}" type="text" class="form-control" id="cod" name="cod" readonly>
                
                <label>Editora:</label><input value="${produto.getEditora()}" type="text" class="form-control" id="editora" name="editora">

                <label>Autor:</label><input value="${produto.getAutor()}" type="text"  class="form-control" id="autor" name="autor">

                <label>Titulo:</label><input value="${produto.getTitulo()}" type="text" class="form-control" id="titulo" name="titulo" >

                Descrição<br>
                <textarea  value="${produto.getDescricao()}" cols="100" rows="10" class="form-control" id="descricao" name="descricao"></textarea><br>

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

    </body>
</html>
