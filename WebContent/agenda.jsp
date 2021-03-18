<%@ page language="java" contentType="text/html; charset=utf-8"    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Sistema - Cart&oacute;rio</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<jsp:include page="imports.jsp" />
<link href="css/agenda.css" rel="stylesheet">       
<script src="js/agenda.js"></script>
    
</head>
<body>
<div class="navbar navbar-fixed-top">
  <div class="navbar-inner">
    <div class="container"> <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"><span
                    class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span> </a><a class="brand" href="agenda.jsp">Sistema - Cart&oacute;rio</a>
      <div class="nav-collapse">
        <ul class="nav pull-right">
          
          <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><i
                            class="icon-user"></i> <%=request.getSession().getAttribute("userId")%> <b class="caret"></b></a>
            <ul class="dropdown-menu">
              <li><a href="javascript:;" id="perfil">Perfil</a></li>
              <li><a href="javascript:;" id="logout">Sair</a></li>
            </ul>
          </li>
        </ul>
        
      </div>
      <!--/.nav-collapse --> 
    </div>
    <!-- /container --> 
  </div>
  <!-- /navbar-inner --> 
</div>
<!-- /navbar -->

<jsp:include page="menu.jsp" />


<div class="main">
  <div class="main-inner">
    <div class="container">
      <div class="row">
        <div class="span12">
          

    
<div class=" col-xs-12  col-lg-5  col-md-5">
					<div class="form-group" style="margin-top: 14px;">
<a href="#myModal" id="btnAdicionar" role="button" class="btn" data-toggle="modal" data-backdrop="static" data-keyboard="false"> <i class='icon-large icon-plus-sign'></i> Adicionar</a>
</div></div>

<div class="panel panel-default">
    <table id="table"
           data-toggle="table"
           data-search="true"
           data-locale="pt-BR"
           data-url="AgendaServlet"
           data-mobile-responsive="true"
           data-check-on-init="true"
           data-sortable="false"
           data-sort-name="nome_completo">
        <thead>
        <tr>
            
											<th data-field="nome_completo" data-halign="center" data-width="200"
												data-align="center" >Nome</th>
											<th data-field="email" data-halign="center" data-width="160"
												data-align="center" >Email</th>
											<th data-field="telefone" data-halign="center" data-align="center"
												data-width="80" >Telefone</th>
											<th data-field="celular" data-halign="center"
												data-align="center" data-width="80" >Celular</th>
											<th data-field="anotacao" data-width="180" data-halign="center"
												data-align="center" >Anotação</th>
											<th data-halign="center" data-align="center"
												data-width="40" data-formatter="actionFormatter"
												data-events="actionEvents">Editar</th>
        </tr>
        </thead>
    </table>
    </div>
    
    <jsp:include page="dadosAgenda.jsp" />

	<jsp:include page="dadosUsuario.jsp" />
	


    
    
        </div>
        <!-- /span6 -->
        
      </div>
      <!-- /row --> 
    </div>
    <!-- /container --> 
  </div>
  <!-- /main-inner --> 
</div>
<!-- /main -->


<div class="footer" id="footer">
  <div class="footer-inner">
    <div class="container">
      <div class="row">
        <div class="span12"> &copy; 2018 <a href="#">Zeitune Informática</a>. </div>
        <!-- /span12 --> 
      </div>
      <!-- /row --> 
    </div>
    <!-- /container --> 
  </div>
  <!-- /footer-inner --> 
</div>
<!-- /footer --> 


    <script>
    
    
   
   
    
    
    
    </script>

	
</body>
</html>
