<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="pt">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="Dashboard">
  <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
  <title>Blank</title>

  <!-- Favicons -->
  <link href="./externo/img/favicon.png" rel="icon">

  <!-- Bootstrap core CSS -->
  <link href="./externo/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!--external css-->
  <link href="./externo/lib/font-awesome/css/font-awesome.css" rel="stylesheet" />
  <!-- Custom styles for this template -->
  <link href="./externo/css/style.css" rel="stylesheet">
  <link href="./externo/css/style-responsive.css" rel="stylesheet">
</head>

<body>
  <section id="container">
    <!-- **********************************************************************************************************************************************************
        TOP BAR CONTENT & NOTIFICATIONS
        *********************************************************************************************************************************************************** -->
    <!--header start-->
       <header class="header black-bg">
      <div class="sidebar-toggle-box">
        <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
      </div>
      <!--logo start-->
      <a href="index.html" class="logo"><b>LOG<span>O</span></b></a>
      <!--logo end-->
      <div class="nav notify-row" id="top_menu">
        <!--  notification start -->
        <ul class="nav top-menu">
          <!-- notification dropdown start-->
          <li id="header_notification_bar" class="dropdown">
            <a data-toggle="dropdown" class="dropdown-toggle" href="index.html#">
              <i class="fa fa-bell-o"></i>
              <span class="badge bg-warning">7</span> <!-- Bagde de Notificação-->
              </a>
            <ul class="dropdown-menu extended notification">
              <div class="notify-arrow notify-arrow-yellow"></div>  
            </ul>
          </li>
          <!-- notification dropdown end -->
        </ul>
        <!--  notification end -->
      </div>
      <div class="top-menu">
        <ul class="nav pull-right top-menu">
          <li><a class="logout" href="login.html">Logout</a></li>  <!-- Botao de Logout -->
        </ul>
      </div>
    </header>
    <!--header end-->
    <!-- **********************************************************************************************************************************************************
        MAIN SIDEBAR MENU
        *********************************************************************************************************************************************************** -->
    <!--sidebar start-->
    <aside>
      <div id="sidebar" class="nav-collapse ">
        <!-- sidebar menu start-->
        <ul class="sidebar-menu" id="nav-accordion">
          <h5 class="centered">Nome Usuario</h5> <!-- Nome do Usuario -->
          <!-- Item sem SubMenu -->
          <li class="mt">
            <a href="index.html"><!-- class="active" -->
              <i class="fa fa-dashboard"></i>
              <span>Dashboard</span>  <!-- Item Principal (Resumo Geral) -->
              </a>
          </li> 
          <li>
            <a href="blank.html">
              <i class="fa fa-user"></i>
              <span>Funcionario</span>  <!-- Item Principal (Resumo Geral) -->
              </a>
          </li> 
          <li>
            <a href="blank.html">
              <i class="fa fa-archive"></i>
              <span>Produtos</span>  <!-- Item Principal (Resumo Geral) -->
              </a>
          </li>  
          <li>
            <a href="blank.html">
              <i class="fa fa-shopping-cart"></i>
              <span>Venda</span>  <!-- Item Principal (Resumo Geral) -->
              </a>
          </li>
          <li>
            <a href="blank.html">
              <i class="fa fa-building-o"></i>
              <span>Filiais</span>  <!-- Item Principal (Resumo Geral) -->
              </a>
          </li> 
          <li>
            <a href="blank.html">
              <i class="fa fa-users"></i>
              <span>Clientes</span>  <!-- Item Principal (Resumo Geral) -->
              </a>
          </li> 
          <li>
            <a href="blank.html">
              <i class="fa fa-bar-chart-o"></i>
              <span>Relatórios</span>  <!-- Item Principal (Resumo Geral) -->
              </a>
          </li> 
          <li>
            <a href="blank.html">
              <i class="fa fa-info"></i>
              <span>Suporte</span>  <!-- Item Principal (Resumo Geral) -->
              </a>
          </li> 
        </ul>
        <!-- sidebar menu end-->
      </div>
    </aside>
    <!--sidebar end-->
    <!-- **********************************************************************************************************************************************************
        MAIN CONTENT
        *********************************************************************************************************************************************************** -->
    <!--main content start-->
    <section id="main-content">
      <section class="wrapper site-min-height">
        <h3><i class="fa fa-angle-right"></i> Blank Page</h3>
        <div class="row mt">
          <div class="col-lg-12">
              
              
              
              
              
              
              
              
              
              
              
            
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
  <script src="./externo/lib/jquery/jquery.min.js"></script>
  <script src="./externo/lib/bootstrap/js/bootstrap.min.js"></script>
  <script src="./externo/lib/jquery-ui-1.9.2.custom.min.js"></script>
  <script src="./externo/lib/jquery.ui.touch-punch.min.js"></script>
  <script class="include" type="text/javascript" src="./externo/lib/jquery.dcjqaccordion.2.7.js"></script>
  <script src="./externo/lib/jquery.scrollTo.min.js"></script>
  <script src="./externo/lib/jquery.nicescroll.js" type="text/javascript"></script>
  <!--common script for all pages-->
  <script src="./externo/lib/common-scripts.js"></script>
  <!--script for this page-->

</body>

</html>
