<%-- 
    Document   : home
    Created on : 25/10/2018, 13:46:35
    Author     : Jeferson Nolasco
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="pt">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
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
  <section id="container">
    <!-- **********************************************************************************************************************************************************
        TOP BAR CONTENT & NOTIFICATIONS
        *********************************************************************************************************************************************************** -->
    <!--header start-->
       <header class="header black-bg">
      <!--logo start-->
      <a class="logo"><b><span>L</span>ivraria<span>S</span>enac</b></a>
      <!--logo end-->
      <div class="nav notify-row" id="top_menu">
        <!--  notification start -->
        <!--  notification end -->
      </div>
      <div class="top-menu">
        <ul class="nav pull-right top-menu">
          <li><a class="logout" href="${pageContext.request.contextPath}/logout">Logout</a></li>  <!-- Botao de Logout -->
        </ul>
      </div>
    </header>

    <!--sidebar end-->
    <!-- **********************************************************************************************************************************************************
        MAIN CONTENT
        *********************************************************************************************************************************************************** -->
    <!--main content start-->
    <section id="">
      <section class="wrapper site-min-height">
        <div class="row mt">
            <div class="col-lg-12">
                <div class="row">
                    <div class="col-md-2"></div>
                    <div class="col-md-2 card-item list-group list-group-flush">
                        <center><a href="${pageContext.request.contextPath}/cliente"><img src="img/Cliente.png" width="100" height="100"></a></center>
                        <center><h1>Cliente</h1></center>

                    </div>
                    <div class="col-md-1"></div>
                    <div class="col-md-2 card-item list-group list-group-flush">
                        <center><a href="${pageContext.request.contextPath}/funcionario"><img src="img/Funcionario.png" width="100" height="100"></a></center>
                        <center><h1>Funcionario</h1></center>

                    </div>
                    <div class="col-md-1"></div>

                    <div class="col-md-2 card-item list-group list-group-flush">
                        <center><a href="${pageContext.request.contextPath}/produto"><img src="img/Produto.png" width="100" height="100"></a></center>
                        <center><h1>Produtos</h1></center>

                    </div>

                </div>
                <div class="row">
                        <div class="col-md-2"></div>
                    <div class="col-md-2 card-item list-group list-group-flush" >
                        <center><a href="${pageContext.request.contextPath}/venda/efetuar"><img src="img/Venda.png" width="100" height="100"></a></center>
                        <center><h1>Venda</h1></center>
                    </div>
                        <div class="col-md-1"></div>

                    <div class="col-md-2 card-item list-group list-group-flush">
                        <center><a href="${pageContext.request.contextPath}/suporte/"><img src="img/Suporte.png" width="100" height="100"></a></center>
                        <center><h1>Suporte</h1></center>
                    </div>
                        <div class="col-md-1"></div>
                    <div class="col-md-2 card-item list-group list-group-flush" readonly>
                        <center><a href="${pageContext.request.contextPath}/relatorio"><img src="img/Relatorio.png" width="100" height="100"></a></center>
                        <center><h1>Relatorio</h1></center>

                    </div>
                </div>  
            </div>
        </div>
      </section>
      <!-- /wrapper -->
    </section>
    <!-- /MAIN CONTENT -->
    <!--main content end-->
    <!--footer start-->
    <footer class="site-footer">
      <div class="text-center"> 
      </div>
    </footer>
    <!--footer end-->
  </section>
  <!-- js placed at the end of the document so the pages load faster -->
  <script src="../externo/lib/jquery/jquery.min.js"></script>
  <script src="../externo/lib/bootstrap/js/bootstrap.min.js"></script>
  <script src="../externo/lib/jquery-ui-1.9.2.custom.min.js"></script>
  <script src="../externo/lib/jquery.ui.touch-punch.min.js"></script>
  <script class="include" type="text/javascript" src="../externo/lib/jquery.dcjqaccordion.2.7.js"></script>
  <script src="../externo/lib/jquery.scrollTo.min.js"></script>
  <script src="../externo/lib/jquery.nicescroll.js" type="text/javascript"></script>
  <!--common script for all pages-->
  <script src="../externo/lib/common-scripts.js"></script>
  <!--script for this page-->

</body>

</html>
