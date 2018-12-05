<%-- 
    Document   : cadastraCliente1
    Created on : 25/10/2018, 17:33:52
    Author     : Jeferson Nolasco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/jsp/home/header.jsp" />
        <div id="modelLista" role="dialog" >
            <div class="modal-dialog modal-lg modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Alterar OS</h5>
                        </a>
                    </div>

        <div class="modal-body">

            <form items="${suporte}" var="suporte" action="${pageContext.request.contextPath}/protegido/suporte/alterar" method="post" class="form-group" readonly>

                <label>Codigo OS:</label> <input type="text" value="${suporte.getId()}" class="form-control" id="id" name="id" readonly>

                <label>Codigo Funcionario:</label> <input type="text" value="1" class="form-control" id="codfuncionario" name="codfuncionario" readonly>

                <label>Nome do Chamado:</label><input type="text" value="${suporte.getNomeChamado()}" class="form-control" id="nomechamado"  name="nomechamado">

                <label>Detalhe:</label><input type="text" value="${suporte.getDetalhe()}" class="form-control" id="detalhe" name="detalhe">
                
                <label>Data de abertura:</label><input type="text" value="${suporte.getDataAbertura()}" class="form-control" id="dataabertura" name="dataabertura" readonly>

                <div class="modal-footer">
                    <a href="${pageContext.request.contextPath}/protegido/home">   
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                    </a>

                    <button type="submit" class="btn btn-primary" >Alterar</button>

                </div>
            </form>

        </div>


<c:import url="/WEB-INF/jsp/home/footer.jsp" />