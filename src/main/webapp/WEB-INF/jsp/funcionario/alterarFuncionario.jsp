<%-- 
    Document   : cadastraCliente1
    Created on : 25/10/2018, 17:33:52
    Author     : Jeferson Nolasco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
        <c:import url="cabecalho.jsp" />


        <div class="" id="modelClient" tabindex="-2" role="dialog" aria-hidden="true"> 


            <div class="modal-dialog modal-lg modal-dialog-centered" role="document">

                <div class="modal-content">

                    <div class="modal-header">

                        <h5 class="modal-title" id="exampleModalLabel">Funcionario</h5>

                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">

                            <span aria-hidden="true">&times;</span>

                        </button>
                    </div>
                    <div class="modal-body">

                        <form class="form-group" items="${funcionario}" var="funcionario">

                            <label>Nome:</label><input value="${funcionario.getNome()}" type="text" class="form-control" id="nome" name="nome">

                            <label>Sobrenome:</label><input value="${funcionario.getSobrenome()}" type="text" class="form-control" id="sobrenome" name="sobrenome">

                            <label>CPF:</label><input value="${funcionario.getCpf()}" type="text" pattern="[0-9]+$"  class="form-control" id="cpf"  placeholder="000.000.000-00" name="cpf">

                            <label>RG:</label><input value="${funcionario.getNome()}" type="text" class="form-control" id="rg" name="rg">

                            <label>Nasc:</label><input value="${funcionario.getDataNascimento}" type="date" pattern="[0-9]{2}\/[0-9]{2}\/[0-9]{4}$" min="1900-01-01" class="form-control" id="nasc" name="nasc">

                            <label>E-mail:</label><input value="${funcionario.getContato().getEmail()}" type="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" class="form-control" id="email" placeholder="email@email.com" name="email">

                            <label>Nome de Usuário:</label><input value="${funcionario.getNome()}" type="text" class="form-control" id="nomeusuario" name="nomeUsuario">

                            <label>Senha:</label><input value="${funcionario.getNome()}" type="password" class="form-control" id="senha" name="senha">

                            <label>Nivel de funcao:</label><input value="${funcionario.getNome()}" type="text" class="form-control" id="nivelFuncao" name="nivelFuncao">

                            <label>Telefone:</label><input value="${funcionario.getContato().getTelefone()}" type="tel" maxlength="15" pattern="[0-9]+$"  class="form-control" id="tel" placeholder="(xx) 9999-9999" name="tel">

                            <label>Celular:</label><input value="${funcionario.getContato().getCelular()}" type="cel" maxlength="15" pattern="[0-9]+$"  class="form-control" id="cel"  placeholder="(xx) 9999-9999" name="cel">

                            <label>Rua:</label><input value="${fubcionario.getEndereco().getRua()}" type="text" class="form-control" id="rua" name="rua">

                            <label>Nº:</label><input value="${funcionario.getEndereco().getNumero()}" type="text" class="form-control"  id="numero" name="numero">

                            <label>Bairro:</label><input value="${funcionario.getEndereco().getBairro()}" type="text" class="form-control"  id="bairro" name="bairro">

                            <label>CEP:</label><input value="${funcionario.getEndereco().getCep()}" type="text" class="form-control"  id="cep" name="cep">

                            <label>Complemento:</label><input value="${funcionario.getEndereco().getComplemento()}" type="text" class="form-control"  id="complemento" name="complemento">

                        </form>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-primary" onclick="">Alterar</button>
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Sair</button>
                        </div>

                    </div>

                </div>
            </div>
        </div>




    </body>
</html>