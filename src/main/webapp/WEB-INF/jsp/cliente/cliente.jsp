<%-- 
    Document   : cadastrarCLiente
    Created on : 17/10/2018, 22:57:40
    Author     : Maia
--%>


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/jsp/home/header.jsp" />
<div class="row mt">
            <div class="col-lg-12">
                <div class="row">
                    <div class="col-md-2"></div>
                    <div class="col-md-2 card-item list-group list-group-flush">
                        <center><a href="${pageContext.request.contextPath}/cliente/listar"><img src="img/Cliente.png" width="100" height="100"></a></center>
                        <center><h1>Lista</h1></center>

                    </div>
                    <div class="col-md-2"></div>
                    <div class="col-md-2 card-item list-group list-group-flush">
                        <center><a href="${pageContext.request.contextPath}/cliente/cadastrar"><img src="img/Cliente.png" width="100" height="100"></a></center>
                        <center><h1>Cadastrar</h1></center>

                    </div>
                    <div class="col-md-1"></div>
                </div>                
            </div>
        </div>

<c:import url="/WEB-INF/jsp/home/footer.jsp" />