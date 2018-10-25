<%-- 
    Document   : alterarExcluirCliente
    Created on : 25/10/2018, 17:34:48
    Author     : Jeferson Nolasco
--%>

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

	<!--<div class="modal fade" id="modelClient" tabindex="-2" role="dialog" aria-hidden="true"> -->
		<div>

		<div class="modal-dialog modal-lg modal-dialog-centered" role="document">

			<div class="modal-content">

				<div class="modal-header">

					<h5 class="modal-title" id="exampleModalLabel">Cliente</h5>

					<button type="button" class="close" data-dismiss="modal" aria-label="Close">

					<span aria-hidden="true">&times;</span>

					</button>
				</div>
				<div class="modal-body">

					<form class="form-group">

						<label>Nome:</label><input type="text" class="form-control" id="nome" placeholder="">
						
						<label>Sobrenome:</label><input type="text" class="form-control" id="sobrenome" placeholder="">
						
						<label>CPF:</label><input type="text" pattern="[0-9]+$"  class="form-control" id="cpf" placeholder="">
						
						<label>Nasc:</label><input type="date" pattern="[0-9]{2}\/[0-9]{2}\/[0-9]{4}$" min="1900-01-01" class="form-control" id="nasc" placeholder="">

						<label>E-mail:</label><input type="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" class="form-control" id="email" placeholder="">
						
						<label>Telefone:</label><input type="tel" maxlength="15" pattern="[0-9]+$"  class="form-control" id="tel" placeholder="">
						
						<label>Celular:</label><input type="tel" maxlength="15" pattern="[0-9]+$"  class="form-control" id="cel" placeholder="">

						<label>Endereço:</label><input type="text" class="form-control" id="end" placeholder="">

					</form>
					<div class="modal-footer">
					<button type="button" class="btn btn-primary" onclick="">Excluir</button>
					<button type="button" class="btn btn-primary" onclick="">Alterar</button>
					<button type="button" class="btn btn-secondary" data-dismiss="modal">Sair</button>
				</div>

				</div>
				
			</div>
		</div>
	</div>
	
</body>
</html>