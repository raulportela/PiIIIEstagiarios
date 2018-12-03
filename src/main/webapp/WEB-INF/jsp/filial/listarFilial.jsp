<%-- 
    Document   : listarFilial
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
                    <h5 class="modal-title" id="exampleModalLabel">Lista de Filial</h5>
                </a>
            </div>
            <div class="modal-body">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th scope="col"><a href="${pageContext.request.contextPath}/filial/listar?ordem=F.id ASC">Cod<i class="fa fa-angle-down"></i></a></th>
                            <th scope="col"><a href="${pageContext.request.contextPath}/filial/listar?ordem=F.nomeFilial ASC">Nome -Filial<i class="fa fa-angle-down"></i></a></th>
                        </tr>

                    </thead>
                    <tbody>
                        <c:forEach items="${filiais}" var="filial"> 
                            <tr data-toggle="modal" data-target="#modelClient">
                                <th><c:out value="${filial.getId()}" /></th>
                                <td><c:out value="${filial.getNome()}" /></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="modal-footer">
                <a href="${pageContext.request.contextPath}/filial/cadastrar">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Nova Filial</button>
                </a>
                <a href="${pageContext.request.contextPath}/home">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Sair</button>
                </a>
            </div>
        </div>
    </div>
</div>
<c:import url="/WEB-INF/jsp/home/footer.jsp" />
