<%-- 
    Document   : login
    Created on : 22/11/2018, 17:14:05
    Author     : Jeferson Nolasco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html >

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="Dashboard">
  <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
  <title>Login</title>

  <link href="http://www.arvore-digital.com/app/rodrigo/html_teste/externo/img/favicon.png" rel="icon">

    <link href="http://www.arvore-digital.com/app/rodrigo/html_teste/externo/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!--external css-->
    <link href="http://www.arvore-digital.com/app/rodrigo/html_teste/externo/lib/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <!-- Custom styles for this template -->
    <link href="http://www.arvore-digital.com/app/rodrigo/html_teste/externo/css/style.css" rel="stylesheet">
    <link href="http://www.arvore-digital.com/app/rodrigo/html_teste/externo/css/style-responsive.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="http://www.arvore-digital.com/app/rodrigo/html_teste/externo/css/style2.css">

</head>

<body>
  <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
  <div id="login-page">
    <div class="container">
      <form class="form-login" action="${pageContext.request.contextPath}/login"method="post">
        <h2 class="form-login-heading">LivrariaSenac</h2>
        <div class="login-wrap">
          <c:if test="${mensagemErro != null}">
              <p style="color: red">
              <c:out value="${mensagemErro}" />
              </p>
          </c:if>
          <input type="text" class="form-control" id="nome" name="nomeUsuario" autofocus>
          <br>
          <input type="password" class="form-control" id="senha" name="senhaAberta">
          <br>
          <button class="btn btn-theme btn-block" type="submit"><i class="fa fa-lock"></i> Acessar </button>
          
        </div>
      </form>
    </div>
  </div>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-backstretch/2.0.4/jquery.backstretch.min.js"></script>

  <script>
    $.backstretch("http://www.arvore-digital.com/app/rodrigo/html_teste/externo/img/log.jpg", {
      speed: 500
    });
  </script>
</body>

</html>
