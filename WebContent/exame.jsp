<%@ page language="java" contentType="text/html; charset=utf-8"    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="utf-8">
<title>Sistema - LaudeiTelemedicina</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<jsp:include page="imports.jsp" />
<link rel="stylesheet" href="css/promissoria.css">
<script src="js/promissoria.js"></script>
<script>

</script>
       
    
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
<!-- /subnavbar -->
<div class="main">
  <div class="main-inner">
    <div class="container">
      <div class="row">
        <div class="span12">
          
<div class=" col-xs-12  col-lg-12  col-md-12">

		<div class="conteudo">
					<div class="row">
						<div class="col-lg-12">


							<div class="panel panel-default">
		<div id="item-info" class="panel-body panel-branco collapse in">
	<a data-target="#item-telefones">
		<div class="panel-heading">Enviar exames</div>
	</a>
	
	
	
         
				<div class="col-lg-9 col-xs-9">
					<div class="form-group">
						<label>Tipo Exame</label> 	<select class="selection-1" name="tpexame1" id="tpexame1" onchange="showDiv('hidden_div', this)">						
						<option value="0" selected>Selecione um tipo</option>
											<option value="MAPA">MAPA</option>
											<option value="Eletrocardiograma">Eletrocardiograma</option>
											<option value="Teste ergométrico">Teste ergométrico</option>
											<option value="Holter 24h">Holter 24h</option>
											
										</select>
					</div>
				</div>
				
			

		
		
		
		
	
	
	
					
		<div id="hidden_div">
		
			<div class=" col-xs-12  col-lg-5  col-md-5">
					<div class="form-group" style="margin-top: 14px;">
<a href="#myModal" id="btnAdicionar" role="button" class="btn" data-toggle="modal" data-backdrop="static" data-keyboard="false"> <i class='icon-large icon-plus-sign'></i> Adicionar PF</a>
</div></div>

<div class="panel panel-default">
   													 <table id="table_representantes"
           data-toggle="table"
           data-search="true"
           data-locale="pt-BR"
           data-show-toggle="true"
             data-click-to-select="true"
               data-show-columns="true"
  data-show-columns-toggle-all="true"
           data-url="AgendaServlet"
           data-mobile-responsive="true"
           data-check-on-init="true"
           data-sortable="false"
           data-sort-name="nome_completo">
        <thead>
        <tr>
            <th data-field="state" data-checkbox="true" ></th>
											<th data-field="nome_completo" data-halign="center" data-width="200"
												data-align="center" >Nome</th>
											<th data-field="email" data-halign="center" data-width="160"
												data-align="center" >Email</th>
											<th data-field="cpf" data-halign="center" data-align="center"
												data-width="80" >CPF</th>
											<th data-field="celular" data-halign="center"
												data-align="center" data-width="80" >Celular</th>
											
											
        </tr>
        </thead>
    </table>
    </div>

<form action="enviarExame" class="dropzone" id="my-awesome-dropzone" method="post" enctype="multipart/form-data;charset=UTF-8" >
					<div class="row">
						<div class="col-lg-12">


							
	<input type="hidden" name="tpexame" id="tpexame">

				




						</div>
						</div>
						</form>


</div>
		
		</div>

					</div>
    </div>
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


	
</body>
</html>
