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
                        <h5 class="modal-title" id="exampleModalLabel">Cliente</h5>
                        </a>
                    </div>

        <div class="modal-body">

            <form action="${pageContext.request.contextPath}/cliente/cadastrar" method="post" class="form-group">
                
                <input type="text" style="display: none" class="form-control" id="filial" name="filial" value="${sessionScope.funcionario.getCodFilial()}">
                
                <label>Nome:<label style = "color: red">*</label></label><input type="text" class="form-control" id="nome" name="nome">

                <label>Sobrenome:<label style = "color: red">*</label></label><input type="text" class="form-control" id="sobrenome" name="sobrenome">

                <label>CPF:<label style = "color: red">*</label></label><input type="text" pattern="[0-9]+$"  class="form-control" id="cpf"  placeholder="000.000.000-00" name="cpf">

                <label>Genero:</label><select class="form-control" id="genero" name="genero">
                    <option value="selecione">Selecione...</option>
                    <option value="masculino">Masculino</option>
                    <option value="feminino">Feminino</option>
                </select>

                <label>Nasc:<label style = "color: red">*</label></label><input type="date" pattern="[0-9]{2}\/[0-9]{2}\/[0-9]{4}$" min="1900-01-01" class="form-control" id="nasc" name="nasc">

                <label>E-mail:<label style = "color: red">*</label></label><input type="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" class="form-control" id="email" placeholder="email@email.com" name="email">

                <label>Telefone:<label style = "color: red">*</label></label><input type="tel" maxlength="15" pattern="[0-9]+$"  class="form-control" id="tel" placeholder="(xx) 9999-9999" name="tel">

                <label>Celular:</label><input type="cel" maxlength="15" pattern="[0-9]+$"  class="form-control" id="cel"  placeholder="(xx) 9999-9999" name="cel">

                <label>Rua:<label style = "color: red">*</label></label><input type="text" class="form-control" id="rua" name="rua">

                <label>Nº:<label style = "color: red">*</label></label><input type="text" value="" class="form-control"  id="numero" name="numero">

                <label>Bairro:<label style = "color: red">*</label></label><input type="text" class="form-control"  id="bairro" name="bairro">

                <label>CEP:<label style = "color: red">*</label></label><input type="text" class="form-control"  id="cep" name="cep">

                <label>Complemento:<label style = "color: red">*</label></label><input type="text" class="form-control"  id="complemento" name="complemento">

                <div class="modal-footer">
                    <a href="${pageContext.request.contextPath}/home">   
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                    </a>

                    <button type="submit" class="btn btn-primary">Cadastrar</button>

                </div>
            </form>

        </div>

<c:import url="/WEB-INF/jsp/home/footer.jsp" />