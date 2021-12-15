<%@ page language="java" contentType="text/html; charset=utf-8"    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Sistema - LaudeiTelemedicina</title>
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
                    class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span> </a><a class="brand" href="agenda.jsp">Sistema - LaudeiTelemedicina</a>
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
          
<div class="col-lg-12">
										<div class="row">
											<div class="col-xs-12 col-lg-4">
												<div class="form-group">
													<label>Mês de Referência</label>
													<div class="input-group date" data-provide="datepicker"
													data-date-format="mm/yyyy" data-date-start-view="months"
														data-date-min-view-mode="months" data-date-autoclose="true">
														<input id="mes_referencia" name="mes_referencia" 
															type="text" class="form-control format_data_mes_ref">
														<div class="input-group-addon">
															<span class="glyphicon glyphicon-th"></span>
														</div>
													</div>
												</div>
											</div>

											<div class="col-xs-12 col-lg-2">
												<div class="form-group">
													<label class=""></label>
													<button type="button" id="btnBuscar"
														class="btn btn-primary btn-sm btn-block">Buscar</button>
												</div>
											</div>
										</div>
									</div>
    
<div class=" col-xs-12  col-lg-5  col-md-5">
					<div class="form-group" style="margin-top: 14px;">
<p style="text-decoration: underline; font-weight:bold;">Exames com laudo</p>
</div></div>

<div class="panel panel-default">
    <table id="table"
           data-toggle="table"
           data-search="true"
           data-locale="pt-BR"
           data-mobile-responsive="true"
           data-sortable="true"
           data-toggle="table"
											data-classes="table table-condensed"
											data-sort-name="stargazers_count" data-sort-order="desc"
											data-pagination="true" data-search="true"
											data-show-columns="true" data-page-size="7"
											data-page-list="[5, 10, 20, 50, 100, 200]"
											data-pagination-first-text="Primeiro"
											data-pagination-pre-text="<i class='glyphicon glyphicon glyphicon-chevron-left'></i>"
											data-pagination-next-text="<i class='glyphicon glyphicon glyphicon-chevron-right'></i>"
											data-pagination-last-text="Último" data-locale="pt-BR">
        <thead>
        <tr>
            
											
											<th data-field="nomePaciente" data-halign="center" data-width="150"
												data-align="left" data-formatter="nomeFormat" data-sortable="true">Nome Paciente</th>
											<th data-field="tpExame" data-halign="center" data-align="center"
												data-width="110" data-sortable="true">Tipo Exame</th>
											<th data-field="dtEntrada" data-halign="center"
												data-align="center" data-width="90" data-sortable="true" data-formatter="dateFormat">Data entrada</th>
												<th data-field="dtLaudo" data-halign="center"
												data-align="center" data-width="90" data-sortable="true" data-formatter="dateFormat">Data laudo</th>
											<th data-field="nomeMedico.nome_completo" data-width="120" data-halign="center"
												data-align="center" data-sortable="true">Medico</th>
												<th data-field="nomeClinica.nome_completo" data-width="120" data-halign="center"
												data-align="center" data-sortable="true">Clinica</th>
												<th data-halign="center" data-align="center"
												data-width="60" data-formatter="vistoFormat">LaudoVisto</th>
												<th data-halign="center" data-align="center"
												data-width="60" data-formatter="actionFormatter1"
												data-events="actionEvents1">Exame</th>
											<th data-halign="center" data-align="center"
												data-width="60" data-formatter="actionFormatter"
												data-events="actionEvents">Laudo</th>
												<th data-halign="center" data-align="center"
												data-width="60" data-formatter="actionFormatter2"
												data-events="actionEvents2">Deletar</th>
        </tr>
        </thead>
    </table>
    </div>
    
    <div class=" col-xs-12  col-lg-5  col-md-5">
					<div class="form-group" style="margin-top: 14px;">
<p style="text-decoration: underline; font-weight:bold;">Exames sem laudo</p>
</div></div>
    
    <div class="panel panel-default">
    <table id="table2"
           data-toggle="table"
           data-search="true"
           data-locale="pt-BR"
           data-mobile-responsive="true"
           data-sortable="true"
           data-toggle="table"
											data-classes="table table-condensed"
											data-sort-name="stargazers_count" data-sort-order="desc"
											data-pagination="true" data-search="true"
											data-show-columns="true" data-page-size="7"
											data-page-list="[5, 10, 20, 50, 100, 200]"
											data-pagination-first-text="Primeiro"
											data-pagination-pre-text="<i class='glyphicon glyphicon glyphicon-chevron-left'></i>"
											data-pagination-next-text="<i class='glyphicon glyphicon glyphicon-chevron-right'></i>"
											data-pagination-last-text="Último" data-locale="pt-BR">
        <thead>
        <tr>
            
											
											<th data-field="nomePaciente" data-halign="center" data-width="150"
												data-align="left" data-formatter="nomeFormat" data-sortable="true">Nome Paciente</th>
											<th data-field="tpExame" data-halign="center" data-align="center"
												data-width="110" data-sortable="true">Tipo Exame</th>
											<th data-field="dtEntrada" data-halign="center"
												data-align="center" data-width="90" data-sortable="true" data-formatter="dateFormat">Data entrada</th>
												
											
												<th data-field="nomeClinica.nome_completo" data-width="120" data-halign="center"
												data-align="center" data-sortable="true">Clinica</th>
												<th data-halign="center" data-align="center"
												data-width="60" data-formatter="actionFormatter1"
												data-events="actionEvents1">Exame</th>
											<th data-halign="center" data-align="center"
												data-width="60" data-formatter="actionFormatter"
												data-events="actionEvents">Laudo</th>
												<th data-halign="center" data-align="center"
												data-width="60" data-formatter="actionFormatter2"
												data-events="actionEvents2">Deletar</th>
        </tr>
        </thead>
    </table>
    </div>
    
    	<jsp:include page="dadosUsuario.jsp" />
    <jsp:include page="dadosAgenda.jsp" />


	


    
    
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
        <div class="span12"> &copy; 2021 <a href="#">Zeitune Informática</a>. </div>
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
