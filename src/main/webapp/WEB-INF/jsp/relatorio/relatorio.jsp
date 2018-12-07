<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/jsp/home/header.jsp" />
<div id="modelLista" role="dialog" >
    <script language="javascript">
        var meses = new Array('01', '02', '03', '04', '05', '06', '07', '08', '09', '10', '11', '12');
        var diasSemana = new Array('domingo', 'segunda', 'terça', 'quarta', 'quinta', 'sexta', 'sabado');
        var modificacao = new Date(document.lastModified);
        var dia = modificacao.getDate();
        var mes = meses [modificacao.getMonth()];
        var ano = modificacao.getFullYear();
        var semana = diasSemana[modificacao.getDay()];
        var dataFinal = dia + "/" + mes + "/" + ano;
        var data3 = dia + "/" + (mes-3) + "/" + ano;
    </script>
    <div class="modal-dialog modal-lg modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Relatorio - <script> document.write(data3+ " à "+ dataFinal)</script></h5>
                </a>
            </div>
            <div class="modal-body">
                <table class="table table-hover">
                    
                    <thead>
                        <tr>
                            <th scope="col">Data</th>
                            <th scope="col">Qtd. Prod.</th>
                            <th scope="col">Total R$/Dia</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listaRelatorio}" var="relatorio"> 
                            <tr data-toggle="modal" data-target="#modelClient">
                                <th><c:out value="${relatorio.getDia()}" /></th>
                                <td><c:out value="${relatorio.getQtdProdutos()}" /></td>
                                <td><c:out value="${relatorio.getTotalDia()}" /></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div class="modal-footer">
                    <label style="color: green">Total mensal: </label>
                </div>
            </div>

        </div>
    </div>
</div>

<c:import url="/WEB-INF/jsp/home/footer.jsp" />