<%-- 
    Document   : cadastraFilial
    Created on : 25/10/2018, 17:33:52
    Author     : Jeferson Nolasco
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/jsp/home/header.jsp" />
        <div id="modelLista" role="dialog" >
            <div class="modal-dialog modal-lg modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Filial</h5>
                        </a>
                    </div>

        <div class="modal-body">

            <form action="${pageContext.request.contextPath}/filial/cadastrar" method="post" class="form-group">
                
                
                <label>Nome:<label style = "color: red">*</label></label><input type="text" class="form-control" id="nome" name="nome">

                <div class="modal-footer">
                    <a href="${pageContext.request.contextPath}/home">   
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                    </a>

                    <button type="submit" class="btn btn-primary">Cadastrar</button>

                </div>
            </form>

        </div>

<c:import url="/WEB-INF/jsp/home/footer.jsp" />