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
      <a class="logo" href="${pageContext.request.contextPath}/home"><b><span>L</span>ivraria<span>S</span>enac</b></a>
      <!--logo end-->
      <div class="nav notify-row" id="top_menu">
        <!--  notification start -->
        <ul class="nav top-menu">
          <!-- notification dropdown start-->
         
          <!-- notification dropdown end -->
        </ul>
        <!--  notification end -->
      </div>
      <div class="top-menu">
        <ul class="nav pull-right top-menu">
          <li><a class="logout" href="${pageContext.request.contextPath}/logout">Logout</a></li>  <!-- Botao de Logout -->
        </ul>
      </div>
    </header>
    <aside>
      <div id="sidebar" class="nav-collapse ">
        <!-- sidebar menu start-->
        <ul class="sidebar-menu" id="nav-accordion">
          <h5 class="centered">Nome Usuario</h5> <!-- Nome do Usuario -->
          <!-- Item sem SubMenu -->
          <li>
            <a href="${pageContext.request.contextPath}/funcionario">
              <i class="fa fa-user"></i>
              <span>Funcionario</span>  <!-- Item Principal (Resumo Geral) -->
              </a>
          </li> 
          <li>
            <a href="${pageContext.request.contextPath}/produto">
              <i class="fa fa-archive"></i>
              <span>Produtos</span>  <!-- Item Principal (Resumo Geral) -->
              </a>
          </li>  
          <li>
            <a href="${pageContext.request.contextPath}/venda/efetuar">
              <i class="fa fa-shopping-cart"></i>
              <span>Venda</span>  <!-- Item Principal (Resumo Geral) -->
              </a>
          </li>
          <li>
            <a href="${pageContext.request.contextPath}/filiais">
              <i class="fa fa-building-o"></i>
              <span>Filiais</span>  <!-- Item Principal (Resumo Geral) -->
              </a>
          </li> 
          <li>
            <a href="${pageContext.request.contextPath}/cliente">
              <i class="fa fa-users"></i>
              <span>Clientes</span>  <!-- Item Principal (Resumo Geral) -->
              </a>
          </li> 
          <li>
            <a href="${pageContext.request.contextPath}/relatorio">
              <i class="fa fa-bar-chart-o"></i>
              <span>Relatórios</span>  <!-- Item Principal (Resumo Geral) -->
              </a>
          </li> 
          <li>
            <a href="${pageContext.request.contextPath}/suporte">
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
        <div class="row mt">
          <div class="col-lg-12">