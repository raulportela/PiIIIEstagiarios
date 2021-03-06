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
                <h5 class="modal-title" id="exampleModalLabel">Venda - <script> document.write(dataFinal)</script></h5>
                </a>
            </div>
            <div>

                <div class="modal-body">

                    <form class="form-group">
                        <c:if test="${sessionScope.clienteVenda != null}">
                            <label>CPF: <a href="${pageContext.request.contextPath}/protegido/venda/efetuar?opcao=4"><i style="color: red" class="fa fa-remove"><b>remover</b></i></a></label> <input type="text" readonly="" value="${sessionScope.clienteVenda.getCpf()}" class="form-control" id="cpf" size="10">
                            <label>Cliente:</label><input type="text" value="${sessionScope.clienteVenda.getNome()} ${clienteVenda.getSobrenome()}" class="form-control" id="cliente" readonly="">

                        </c:if>
                        <c:if test="${sessionScope.clienteVenda == null}">
                            <a href="${pageContext.request.contextPath}/protegido/cliente/listar" >
                                <input type="button" value="Selecionar cliente" class="btn btn-primary" data-dismiss="modal"><br><br>
                            </a>

                        </c:if>
                        <hr>
                        <table class="table table-hover">

                            <thead>

                                <tr>
                                    <th scope="col">Cod</th>
                                    <th scope="col">Titulo</th>
                                    <th scope="col">Estoque</th>
                                    <th scope="col">Qtd</th>
                                    <th scope="col">Valor Uni</th>

                                </tr>

                            </thead>
                            <tbody>
                                <c:forEach items="${sessionScope.listaVenda}" var="itemVenda">

                                    <tr data-toggle="modal">
                                        <th><c:out value="${itemVenda.getProduto().getId()}" /></th>
                                        <td><c:out value="${itemVenda.getProduto().getTitulo()}" /></td>
                                        <td><c:out value="${itemVenda.getProduto().getQuantidade()}" /></td>
                                        <td><a href="${pageContext.request.contextPath}/protegido/venda/efetuar?opcao=5&produtovenda=${itemVenda.getProduto().getId()}"><i class="fa fa-arrow-circle-down"></i></a> <c:out value="${itemVenda.getQuantidade()}" /> <a href="${pageContext.request.contextPath}/protegido/venda/efetuar?opcao=6&produtovenda=${itemVenda.getProduto().getId()}"><i class="fa fa-arrow-circle-up"></i></a></td>
                                        <td><c:out value="${itemVenda.getProduto().getValor()}" /></td>
                                        <td>
                                            <a href="${pageContext.request.contextPath}/protegido/venda/efetuar?opcao=3&produtovenda=${itemVenda.getProduto().getId()}">
                                                <button type="button" class="btn btn-primary" data-dismiss="modal" >Excluir</button>
                                            </a>
                                        </td>

                                    </tr>
                                </c:forEach>

                            </tbody>
                        </table>
                        <div class="modal-footer">
                            <a href="${pageContext.request.contextPath}/protegido/produto/listar">
                                <button type="button" class="btn btn-primary" data-dismiss="modal" >Selecionar produtos</button>
                            </a>
                        </div>

                        <div class="modal-footer">
                            <label style="color: red">Total R$: ${sessionScope.valorTotal}</label>
                        </div>
                    </form>

                    <div class="modal-footer" >
                        <form action="${pageContext.request.contextPath}/protegido/venda/efetuar" method="post">
                            <a href="${pageContext.request.contextPath}/protegido/home">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar Venda</button>
                            </a>
                            <button type="submit" class="btn btn-primary" onclick="">Concluir Venda</button>
                        </form>
                    </div>
                </div>


            </div>

        </div>
    </div>	
    <c:import url="/WEB-INF/jsp/home/footer.jsp" />