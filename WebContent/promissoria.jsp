<%@ page language="java" contentType="text/html; charset=utf-8"    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="utf-8">
<title>Sistema - Cart&oacute;rio</title>
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
<!-- /subnavbar -->
<div class="main">
  <div class="main-inner">
    <div class="container">
      <div class="row">
        <div class="span12">
          
<div class=" col-xs-12  col-lg-12  col-md-12">

		<div class="conteudo">
				<form id="form-promissoria" role="form" action="emitirPromissoria" method="post" target="_blank">
					<div class="row">
						<div class="col-lg-12">


							<div class="panel panel-default">
	
	<a data-target="#item-telefones">
		<div class="panel-heading">Dados da promiss&oacute;ria</div>
	</a>
	<div id="item-info" class="panel-body panel-branco collapse in">
	
         

		<div class="col-lg-12 col-xs-12">
			<div class="row">
			<div class="col-lg-2 col-xs-2">
						<div class="form-group">
							<label>Nº Parcelas</label>
							<div class="input-group">
								<input id="num_parcelas" name="num_parcelas" type="text"
									class="num_parcelas form-control">
							</div>
			</div>
		</div>
		<div class="col-lg-2">
					<div class="form-group">
												<label>Dt. 1º Vencimento</label>
												<div class="input-group date" 
													data-provide="datepicker" 
													data-date-format="dd/mm/yyyy" 
													data-date-start-view="days"
													data-date-min-view-mode=""days"" 
													data-date-autoclose="true">
													<input id="dt_1_venc" name="dt_1_venc"
														type="text" class="form-control">
													<div class="input-group-addon">
														<span class="glyphicon glyphicon-th"></span>
													</div>
												</div>
											</div>
					</div>
					<div class="col-lg-2">
					<div class="form-group">
												<label>Dt. Emissão</label>
												<div class="input-group date" 
													data-provide="datepicker" 
													data-date-format="dd/mm/yyyy" 
													data-date-start-view="days"
													data-date-min-view-mode=""days"" 
													data-date-autoclose="true">
													<input id="dt_emissao" name="dt_emissao"
														type="text" class="form-control">
													<div class="input-group-addon">
														<span class="glyphicon glyphicon-th"></span>
													</div>
												</div>
											</div>
					</div>
					<div class="col-lg-3 col-xs-3">
						<div class="form-group">
							<label>Valor</label>
							<div class="input-group">
							<div class="input-group-addon">
																	R$
																</div>
								<input id="valor" name="valor" type="text"
									class="num_parcelas form-control valor">
							</div>
			</div>
		</div>
		
		<div class="col-lg-3 col-xs-3">
						<div class="form-group">
							<label>Pag&aacute;vel em</label>
							
								<input id="local" name="local" type="text" class="form-control">
						
			</div>
		</div>
		</div>
		</div>
		<div class="col-lg-12 col-xs-12">
			<div class="row">
				<div class="col-lg-9 col-xs-9">
					<div class="form-group">
						<label>Nome Credor</label> <input id="nomeCredor" name="nomeCredor"
							type="text" class="form-control">
					</div>
				</div>

				<div class="col-lg-3 col-xs-3">
					<div class="form-group">
						<label>CPF/CNPJ Credor</label> <input id="cpfcnpjCredor" name="cpfcnpjCredor" type="text"
							class="cpf form-control hibridCpf" onkeypress='mascaraMutuario(this,cpfCnpj)' onblur='clearTimeout()'>
					</div>
				</div>
				</div>
		</div>
		<div class="col-lg-12 col-xs-12">
			<div class="row">
				<div class="col-lg-9 col-xs-9">
					<div class="form-group">
						<label>Nome Devedor</label> <input id="nomeDevedor" name="nomeDevedor"
							type="text" class="form-control">
					</div>
				</div>

				<div class="col-lg-3 col-xs-3">
					<div class="form-group">
						<label>CPF/CNPJ Devedor</label> <input id="cpfcnpjDevedor" name="cpfcnpjDevedor" type="text"
							class="cpf form-control hibridCpf" onkeypress='mascaraMutuario(this,cpfCnpj)' onblur='clearTimeout()'>
					</div>
				</div>
			
				
				</div>

			</div>
		
		
		<div class="col-lg-12 col-xs-12">
			<div class="row">
				<div class="col-lg-3 col-xs-3">
					<div class="form-group">
						<label>CEP</label>
						<div class="input-group">
							<input type="text" id="cep" name="cep" class="cep form-control"
								placeholder="Entre com o CEP"> <span class="input-group-btn">
								<button class="btn btn-default" id="bcep" name="bcep"
									type="button">
									<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
								</button>
							</span>
						</div>
					</div>
				</div>
				<div class="col-lg-9 col-xs-12">
					<div class="form-group">
						<label>Endere&ccedil;o</label> <input id="endereco" name="endereco"
							type="text" class="form-control">
					</div>
				</div>
			</div>
		</div>

		<div class="col-lg-12 col-xs-12">
			<div class="row">
				

				<div class="col-lg-2 col-xs-2">
					<div class="form-group">
						<label>N&uacute;mero</label> <input id="numero" name="numero" type="text"
							class="form-control">
					</div>
				</div>
				
				<div class="col-lg-3 col-xs-6">
					<div class="form-group">
						<label>Complemento</label> <input id="complemento" name="complemento" type="text"
							class="form-control">
					</div>
				</div>
				
				<div class="col-lg-3 col-xs-4">
					<div class="form-group">
						<label>Bairro</label> <input id="bairro" name="bairro" type="text"
							class="form-control">
					</div>
				</div>
		
				<div class="col-lg-3 col-xs-4">
					<div class="form-group">
						<label>Cidade</label> <input name="cidade" id="cidade" type="text"
							class="form-control">
					</div>
				</div>
		
				<div class="col-lg-1 col-xs-1 col-xs-2">
					<div class="form-group">
						<label>Estado</label> <input name="estado" id="estado" type="text"
							class="form-control">
					</div>
				</div>
				
				
				
				
				
				
				

			</div>
		</div>
		<div class="col-lg-12 col-xs-12">
			<div class="row">
				<div class="col-lg-9 col-xs-9">
					<div class="form-group">
						<label>Nome Avalista 1</label> <input id="nomeAval1" name="nomeAval1"
							type="text" class="form-control">
					</div>
				</div>

				<div class="col-lg-3 col-xs-3">
					<div class="form-group">
						<label>CPF/CNPJ Avalista 1</label> <input id="cpfcnpjAval1" name="cpfcnpjAval1" type="text"
							class="cpf form-control hibridCpf" onkeypress='mascaraMutuario(this,cpfCnpj)' onblur='clearTimeout()'>
					</div>
				</div>
			<div class="col-lg-9 col-xs-9">
					<div class="form-group">
						<label>Nome Avalista 2</label> <input id="nomeAval2" name="nomeAval2"
							type="text" class="form-control">
					</div>
				</div>

				<div class="col-lg-3 col-xs-3">
					<div class="form-group">
						<label>CPF/CNPJ Avalista 2</label> <input id="cpfcnpjAval2" name="cpfcnpjAval2" type="text"
							class="cpf form-control hibridCpf" onkeypress='mascaraMutuario(this,cpfCnpj)' onblur='clearTimeout()'>
					</div>
				</div>
				
				</div>
				

				</div>
		
	
	<div id="col-lg-12">
								
									
										<div class="col-lg-6">
											<button type="reset" id="btnLimpar"
												class="btn btn-primary btn-block">Limpar</button>
										</div>
										<div class="col-lg-6">
											<button type="submit" id="btnEmitir"
												class="btn btn-primary btn-block">Emitir</button>
										</div>
									
								
	</div>
	
	</div>
</div>
							
</div>




						</div>
						
						</form>
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


	
</body>
</html>
