<%-- 
    Document   : EfetuarVenda
    Created on : 08/11/2018, 12:48:39
    Author     : Jeferson Nolasco
--%>


<script language="javascript">
    var meses = new Array('01', '02', '03', '04', '05', '06', '07', '08', '09', '10', '11', '12');
    var diasSemana = new Array('domingo', 'segunda', 'terça', 'quarta', 'quinta', 'sexta', 'sabado');
    var modificacao = new Date(document.lastModified);
    var dia = modificacao.getDate();
    var mes = meses [modificacao.getMonth()];
    var ano = modificacao.getFullYear();
    var semana = diasSemana[modificacao.getDay()];
    var dataFinal = dia + "/" + mes + "/" + ano;
</script>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/jsp/home/header.jsp" />
<div id="modelLista" role="dialog" >
    <div class="modal-dialog modal-lg modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Home - <script> document.write(dataFinal)</script></h5>
                </a>
            </div>
            <div>

                <div class="modal-body">

                    <form class="form-group">
                        <center> 
                            <label>Bem vindo </label> <i><label> ${sessionScope.funcionario.getNome()} ${sessionScope.funcionario.getSobrenome()}</label></i>
                        <center>
                            
                        
                    </form>

                    <div class="modal-footer" >
                        <label>Tenha um ótimo dia de trabalho!</label> <br><br><br>
                        <i><label>${sessionScope.frase.getFrase()}</label><br>
                            <label>${sessionScope.frase.getAutor()}</label><br><br><br><br><br><br><br></i>
                    </div>
                    <form style="size: 20px"> 
                        <center>
                            <b> Livraria Senac</b> 
                        </center>
                    </form>
                </div>


            </div>

        </div>
    </div>	
    <c:import url="/WEB-INF/jsp/home/footer.jsp" />