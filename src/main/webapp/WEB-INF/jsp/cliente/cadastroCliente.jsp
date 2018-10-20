<%-- 
    Document   : cadastrarCLiente
    Created on : 17/10/2018, 22:57:40
    Author     : Maia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="../css/style.css">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="row">
            <div class="col-12 top-menu">
                <img src="../img/1.png">
                <div><h6>Bem Vindo!</h6></div>

            </div>
        </div>
        <div class="row">
            <div class="col-2 offset-md-2 card-item list-group list-group-flush">
                <h1>Cliente</h1>			
                <button type="button" class="list-group-item list-group-item-action" data-toggle="modal" data-target="#modalCadastrar"> Cadastrar</button>
                <button class="list-group-item list-group-item-action" data-toggle="modal" data-target="#modelLista"> Lista</button>	



            </div>
            <div class="col-2 offset-md-1 card-item jumbotron"></div>

            <div class="col-2 offset-md-1 card-item jumbotron"></div>

        </div>

        <div class="modal fade" id="modalCadastrar" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">

            <div class="modal-dialog modal-lg modal-dialog-centered" role="document">

                <div class="modal-content">

                    <div class="modal-header">

                        <h5 class="modal-title" id="exampleModalLabel">Cadastrar</h5>

                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">

                            <span aria-hidden="true">&times;</span>

                        </button>

                    </div>

                    <div class="modal-body">

                        <form action="${pageContext.request.contextPath}/cliente/inclusao" method="post" class="form-group">

                            <label>Nome:</label><input type="text" name="nome" class="form-control" id="nome">

                            <label>Sobrenome:</label><input type="text" name="sobrenome" class="form-control" id="sobrenome">

                            <label>CPF:</label><input type="text" name="cpf" pattern="[0-9]+$"  class="form-control" id="cpf"  placeholder="000.000.000-00">

                            <label>Nasc:</label><input type="date" name="nasc" pattern="[0-9]{2}\/[0-9]{2}\/[0-9]{4}$" min="1900-01-01" class="form-control" id="nasc">

                            <label>E-mail:</label><input type="email" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" class="form-control" id="email" placeholder="email@email.com">

                            <label>Telefone:</label><input type="tel" name="tel" maxlength="15" pattern="[0-9]+$"  class="form-control" id="tel" placeholder="(xx) 9999-9999">

                            <label>Celular:</label><input type="tel" name="cel" maxlength="15" pattern="[0-9]+$"  class="form-control" id="cel"  placeholder="(xx) 9 9999-9999">

                            <label>Endereço:</label><input type="text" name="end" class="form-control" id="end">

                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>

                                <button type="submit" class="btn btn-primary">Cadastrar</button>

                            </div>

                        </form>
                    </div>


                </div>

            </div>
        </div>	

        <div class="modal fade" id="modelLista" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">

            <div class="modal-dialog modal-lg modal-dialog-centered" role="document">

                <div class="modal-content">

                    <div class="modal-header">

                        <h5 class="modal-title" id="exampleModalLabel">Lista</h5><input class="form-control pesquisa"type="text" placeholder="Pesquisar" name="">

                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">

                            <span aria-hidden="true">&times;</span>

                        </button>

                    </div>
                    <div class="modal-body">

                        <table class="table table-hover">

                            <thead>

                                <tr>
                                    <th scope="col">CPF</th>
                                    <th scope="col">Nome</th>
                                    <th scope="col">Tel</th>
                                    <th scope="col">E-mail</th>
                                </tr>

                            </thead>
                            <tbody>

                                <tr data-toggle="modal" data-target="#modelClient">
                                    <th scope="row">1</th>
                                    <td>Mark</td>
                                    <td>Otto</td>
                                    <td>@mdo</td>
                                </tr>

                            </tbody>
                        </table>
                    </div>

                    <div class="modal-footer">

                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Sair</button>

                    </div>
                </div>
            </div>
        </div>

        <div class="modal fade" id="modelClient" tabindex="-2" role="dialog" aria-hidden="true">

            <div class="modal-dialog modal-lg modal-dialog-centered" role="document">

                <div class="modal-content">

                    <div class="modal-header">

                        <h5 class="modal-title" id="exampleModalLabel">Cliente</h5>

                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">

                            <span aria-hidden="true">&times;</span>

                        </button>
                    </div>
                    <div class="modal-body">

                        <form  class="form-group" >

                            <label>Nome:</label><input type="text" class="form-control" id="nome" placeholder="">

                            <label>Sobrenome:</label><input type="text" class="form-control" id="sobrenome" placeholder="">

                            <label>CPF:</label><input type="text" pattern="[0-9]+$"  class="form-control" id="cpf" placeholder="">

                            <label>Nasc:</label><input type="date" pattern="[0-9]{2}\/[0-9]{2}\/[0-9]{4}$" min="1900-01-01" class="form-control" id="nasc" placeholder="">

                            <label>E-mail:</label><input type="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" class="form-control" id="email" placeholder="">

                            <label>Telefone:</label><input type="tel" maxlength="15" pattern="[0-9]+$"  class="form-control" id="tel" placeholder="">

                            <label>Celular:</label><input type="tel" maxlength="15" pattern="[0-9]+$"  class="form-control" id="cel" placeholder="">

                            <label>Endereço:</label><input type="text" class="form-control" id="end" placeholder="">

                        </form>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Sair</button>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
