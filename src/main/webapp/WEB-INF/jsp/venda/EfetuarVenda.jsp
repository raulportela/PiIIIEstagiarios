<%-- 
    Document   : EfetuarVenda
    Created on : 08/11/2018, 12:48:39
    Author     : Jeferson Nolasco
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <div>
            <c:import url="/WEB-INF/jsp/home/cabecalho.jsp"  />
        </div>
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

        <div>

            <div class="modal-dialog modal-lg modal-dialog-centered" role="document">

                <div class="modal-content">

                    <div class="modal-header">

                        <h5 class="modal-title" id="exampleModalLabel">Venda - <script> document.write(dataFinal)</script></h5>

                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">

                            <span aria-hidden="true">&times;</span>

                        </button>

                    </div>

                    <div class="modal-body">

                        <form class="form-group">

                            <label>CPF:</label> <a href="${pageContext.request.contextPath}/cliente/listar"><img src="../img/Pesquisa.png" width="20" height="20"></a><input type="text" class="form-control" id="cpf" size="10">
                            <label>Cliente:</label><input type="text" class="form-control" id="cliente" readonly="">
                            <label>Nota Fiscal:</label><input type="text" class="form-control" id="notafiscal" >

                            <table class="table table-hover">

                                <thead>

                                    <tr>
                                        <th scope="col">Cod produto</th>
                                        <th scope="col">Titulo</th>
                                        <th scope="col">Estoque</th>
                                        <th scope="col">Quantidade</th>
                                        <th scope="col">Valor Unitário</th>
                                        <th scope="col">Remover</th>

                                    </tr>

                                </thead>
                                <tbody>

                                    <tr data-toggle="modal">
                                        <th></th>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td>
                                            <a>
                                                <button type="button" class="btn btn-primary" data-dismiss="modal" >Remover</button>
                                            </a>
                                        </td>

                                    </tr>

                                </tbody>
                            </table>

                            <label>ValorTotal:</label><input type="text" class="form-control" id="valor" >

                        </form>

                        <div class="modal-footer" >
                            <a href="${pageContext.request.contextPath}/home">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar Venda</button>
                            </a>

                            <button type="submit" class="btn btn-primary" onclick="">Concluir Venda</button>

                        </div>
                    </div>


                </div>

            </div>
        </div>	
    </body>
</html>