<label style = "color: red">*</label><%-- 
    Document   : cadastraCliente1
    Created on : 25/10/2018, 17:33:52
    Author     : Jeferson Nolasco
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/jsp/home/header.jsp" />
        <div id="modelLista" role="dialog" >
            <div class="modal-dialog modal-lg modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Cliente</h5>
                        </a>
                    </div>
                    <div class="modal-body">

                        <form class="form-group" items="${cliente}" var="cliente" action="${pageContext.request.contextPath}/protegido/cliente/alterar" method="post">

                            <label>Nome:<label style = "color: red">*</label></label><input value="${cliente.getNome()}" type="text" class="form-control" id="nome" name="nome">

                            <label>Sobrenome:<label style = "color: red">*</label></label><input value="${cliente.getSobrenome()}" type="text" class="form-control" id="sobrenome" name="sobrenome">

                            <label>CPF:<label style = "color: red">*</label></label><input value="${cliente.getCpf()}" type="text" pattern="[0-9]+$"  class="form-control" id="cpf"  placeholder="000.000.000-00" name="cpf">

                            <label>Nasc:<label style = "color: red">*</label></label><input type="date" value="${cliente.getDataNascimento()}" pattern="[0-9]{2}\/[0-9]{2}\/[0-9]{4}$" min="1900-01-01" class="form-control" id="nasc" name="nasc">

                            <label>E-mail:<label style = "color: red">*</label></label><input value="${cliente.getContato().getEmail()}" type="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" class="form-control" id="email" placeholder="email@email.com" name="email">

                            <label>Telefone:<label style = "color: red">*</label></label><input value="${cliente.getContato().getTelefone()}" type="tel" maxlength="15" pattern="[0-9]+$"  class="form-control" id="tel" placeholder="(xx) 9999-9999" name="tel">

                            <label>Celular:</label><input value="${cliente.getContato().getCelular()}" type="cel" maxlength="15" pattern="[0-9]+$"  class="form-control" id="cel"  placeholder="(xx) 9999-9999" name="cel">

                            <label>Rua:<label style = "color: red">*</label></label><input value="${cliente.getEndereco().getRua()}" type="text" class="form-control" id="rua" name="rua">

                            <label>N�:<label style = "color: red">*</label></label><input value="${cliente.getEndereco().getNumero()}" type="text" class="form-control"  id="numero" name="numero">

                            <label>Bairro:<label style = "color: red">*</label></label><input value="${cliente.getEndereco().getBairro()}" type="text" class="form-control"  id="bairro" name="bairro">

                            <label>CEP:<label style = "color: red">*</label></label><input value="${cliente.getEndereco().getCep()}" type="text" class="form-control"  id="cep" name="cep">

                            <label>Complemento:</label><input value="${cliente.getEndereco().getComplemento()}" type="text" class="form-control"  id="complemento" name="complemento">

                            <div class="modal-footer">
                                <button type="submit" class="btn btn-primary" onclick="">Alterar</button>
                                <a href="${pageContext.request.contextPath}/protegido/cliente/listar">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Sair</button>
                                </a>
                            </div>
                        </form>

                    </div>

                </div>
            </div>
        </div>

<c:import url="/WEB-INF/jsp/home/footer.jsp" />