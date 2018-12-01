<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/jsp/home/header.jsp" />
<div class="row mt">
            <div class="col-lg-12">
                <div class="row">
                    <div class="col-md-2"></div>
                    <div class="col-md-2 card-item list-group list-group-flush">
                        <center><a href="${pageContext.request.contextPath}/suporte/listar"><img src="img/Suporte.png" width="100" height="100"></a></center>
                        <center><h1>Lista</h1></center>

                    </div>
                    <div class="col-md-2"></div>
                    <div class="col-md-2 card-item list-group list-group-flush">
                        <center><a href="${pageContext.request.contextPath}/suporte/cadastrar"><img src="img/Suporte.png" width="100" height="100"></a></center>
                        <center><h1>Cadastrar</h1></center>

                    </div>
                    <div class="col-md-1"></div>
                </div>                
            </div>
        </div>

<c:import url="/WEB-INF/jsp/home/footer.jsp" />