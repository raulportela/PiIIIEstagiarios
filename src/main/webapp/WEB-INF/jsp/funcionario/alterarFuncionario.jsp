<%-- 
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
                        <h5 class="modal-title" id="exampleModalLabel">Funcionario</h5>
                        </a>
                    </div>
                    <div class="modal-body">

                        <form class="form-group" items="${funcionario}" var="funcionario" action="${pageContext.request.contextPath}/protegido/funcionario/alterar" method="post">
                            
                            <input type="text" style="display: none" value="${funcionario.getCodFilial()}" class="form-control" id="filial" name="filial" value="${sessionScope.funcionario.getCodFilial()}">
                            
                            <label>Nome:<label style="color: red">*</label></label><input value="${funcionario.getNome()}" type="text" class="form-control" id="nome" name="nome">

                            <label>Sobrenome:<label style="color: red">*</label></label><input value="${funcionario.getSobrenome()}" type="text" class="form-control" id="sobrenome" name="sobrenome">

                            <label>CPF:<label style="color: red">*</label></label><input value="${funcionario.getCpf()}" readonly="" type="text" pattern="[0-9]+$"  class="form-control" id="cpf"  placeholder="000.000.000-00" name="cpf">

                            <label>RG:<label style="color: red">*</label></label><input value="${funcionario.getRg()}" type="text" class="form-control" id="rg" name="rg">

                            <label>Nasc:<label style="color: red">*</label></label><input value="${funcionario.getDataNascimento()}" type="text" class="form-control" id="nasc" name="nasc">

                            <label>E-mail:<label style="color: red">*</label></label><input value="${funcionario.getContato().getEmail()}" type="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" class="form-control" id="email" placeholder="email@email.com" name="email">

                            <label>Nome de Usuário:<label style="color: red">*</label></label><input value="${funcionario.getNome()}" type="text" class="form-control" id="nomeusuario" name="nomeusuario">

                            <label>Senha:<label style="color: red">*</label><label style="color: red"><i> Só insira caso queira altarar a ultima senha.</i></label></label><input value="1234" type="password" class="form-control" id="senha" name="senha">

                            <label>Nivel de funcao:<label style="color: red">*</label></label><input value="${funcionario.getNivelFuncao()}" type="text" class="form-control" id="nivelFuncao" name="nivelfuncao">

                            <label>Telefone:<label style="color: red">*</label></label><input value="${funcionario.getContato().getTelefone()}" type="tel" maxlength="15" pattern="[0-9]+$"  class="form-control" id="tel" placeholder="(xx) 9999-9999" name="tel">

                            <label>Celular:</label><input value="${funcionario.getContato().getCelular()}" type="cel" maxlength="15" pattern="[0-9]+$"  class="form-control" id="cel"  placeholder="(xx) 9999-9999" name="cel">

                            <label>Rua:<label style="color: red">*</label></label><input value="${funcionario.getEndereco().getRua()}" type="text" class="form-control" id="rua" name="rua">

                            <label>Nº:<label style="color: red">*</label></label><input value="${funcionario.getEndereco().getNumero()}" type="text" class="form-control"  id="numero" name="numero">

                            <label>Bairro:<label style="color: red">*</label></label><input value="${funcionario.getEndereco().getBairro()}" type="text" class="form-control"  id="bairro" name="bairro">

                            <label>CEP:<label style="color: red">*</label></label><input value="${funcionario.getEndereco().getCep()}" type="text" class="form-control"  id="cep" name="cep">

                            <label>Complemento:</label><input value="${funcionario.getEndereco().getComplemento()}" type="text" class="form-control"  id="complemento" name="complemento">

                            <div class="modal-footer">
                                <button type="submit" class="btn btn-primary" onclick="">Alterar</button>
                                <a href="${pageContext.request.contextPath}/protegido/home">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Sair</button>
                                </a>
                            </div>
                        </form>


                    </div>

                </div>
            </div>
        </div>


<c:import url="/WEB-INF/jsp/home/footer.jsp" />