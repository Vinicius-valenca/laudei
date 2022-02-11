<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="utf-8">
<title>Sistema - LaudeiTelemedicina</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
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
			<div class="container">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"><span class="icon-bar"></span><span
					class="icon-bar"></span><span class="icon-bar"></span> </a><a
					class="brand" href="agenda.jsp">Sistema - LaudeiTelemedicina</a>
				<div class="nav-collapse">
					<ul class="nav pull-right">

						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"><i class="icon-user"></i> <%=request.getSession().getAttribute("userId")%>
								<b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="javascript:;" id="perfil">Perfil</a></li>
								<li><a href="javascript:;" id="logout">Sair</a></li>
							</ul></li>
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
<input id="tpperfil" name="tpperfil" type="hidden"
							class="form-control" value="<%=session.getAttribute("tpperfil") %>" readonly>

										<div class="panel panel-default">
											<div id="item-info"
												class="panel-body panel-branco collapse in">
												<a data-target="#item-telefones">
													<div class="panel-heading">Enviar exames</div>
												</a>




												<div class="col-lg-9 col-xs-9">
													<div class="form-group">
														<label>Tipo Exame</label> <select class="selection-1"
															name="tpexame1" id="tpexame1"
															onchange="showDiv('hidden_div1', this)">
															<option value="0" selected>Selecione um tipo</option>
															<option value="MAPA">MAPA</option>
															<option value="Eletrocardiograma">Eletrocardiograma</option>
															<option value="Teste ergométrico">Teste
																ergométrico</option>
															<option value="Holter 24h">Holter 24h</option>

														</select>
													</div>
												</div>









	<div id="hidden_div">


													
													

													


													<form action="enviarExame" class="dropzone"
														id="my-awesome-dropzone" method="post"
														enctype="multipart/form-data;charset=UTF-8">
														<div class="row">
															<div class="col-lg-12">



																<input type="hidden" name="tpexame" id="tpexame">






															</div>

														</div>
														
													</form>


												</div>

												<div id="hidden_div1">


													<div class="panel panel-default">
														<table id="table_pacientes" data-toggle="table"
															data-search="true" data-locale="pt-BR"
															data-show-toggle="true" data-click-to-select="true"
															data-show-columns="true" data-url="PacienteServlet"
															data-mobile-responsive="true" data-check-on-init="true"
															data-sortable="false" data-sort-name="nome_completo">
															<thead>
																<tr>
																	<th data-field='selected' data-radio="true"></th>
																	<th data-field="nome_completo" data-halign="center"
																		data-width="200" data-align="center">Nome</th>
																	<th data-field="email" data-halign="center"
																		data-width="160" data-align="center">Email</th>
																	<th data-field="cpf" data-halign="center"
																		data-align="center" data-width="80">CPF</th>
																	<th data-field="celular" data-halign="center"
																		data-align="center" data-width="80">Celular</th>


																</tr>
															</thead>
														</table>

													</div>

<form action="enviarExame" class="dropzone"
														id="my-awesome-dropzone1" method="post"
														enctype="multipart/form-data;charset=UTF-8">
													<div class="panel panel-default">

														<a data-target="#item-telefones">
															<div class="panel-heading">Informa&ccedil;&otilde;es
																Pessoais</div>
														</a>
														<div id="item-info"
															class="panel-body panel-branco collapse in">




															<input id="id" name="id" type="hidden"
																class="form-control" readonly>


															<div class="col-lg-12 col-xs-12">
																<div class="row">
																
																<select id='tags'>
<option value="test">Test</option>
</select>
																	<div class="col-lg-6 col-xs-12">
																		<div class="form-group">
																			<label>Nome Completo</label> <input
																				id="nome_completo" name="nome_completo" type="text"
																				class="form-control">
																		</div>
																	</div>
																	<div class="col-lg-3 col-xs-12">
																		<div class="form-group">
																			<label>Email</label> <input id="email" name="email"
																				type="email" class="form-control"
																				placeholder="cliente@gmail.com">
																		</div>
																	</div>
																	
																	<div class="col-lg-3 col-xs-12">
																		<div class="form-group">
																			<label>CPF</label> <input id="cpf" name="cpf"
																				type="text" class="cpf form-control  cpf">
																		</div>
																	</div>

																</div>

															</div>

															<div class="col-lg-12 col-xs-12">
																<div class="row">


																	<div class="col-lg-3 col-xs-12">
																		<div class="form-group">
																			<label>Sexo</label> <label class="radio-inline">
																				<input type="radio" name="sexo" value="M">Masculino
																			</label> <label class="radio-inline"> <input
																				type="radio" name="sexo" value="F">Feminino
																			</label>

																		</div>
																	</div>


																	<div class="col-lg-2 col-xs-12">


																		<div class="form-group">
																			<label>Celular</label>
																			<div class="input-group">
																				<input id="celular" name="celular" type="text"
																					class="celular form-control">
																			</div>


																		</div>
																	</div>

																	<div class="col-lg-3 col-xs-12">
																		<div class="form-group">
																			<label for="dtnascimento">Data nascimento</label>
																			<!-- Datepicker as text field -->
																			<div class="input-group date"
																				data-date-format="dd/mm/yyyy">
																				<input type="text" class="form-control"
																					name="dtnascimento" id="dtnascimento"
																					placeholder="dd/mm/yyyy">
																				<div class="input-group-addon">
																					<span class="glyphicon glyphicon-th"></span>
																				</div>
																			</div>
																		</div>
																	</div>

<div class="col-lg-2 col-xs-12">
																		<div class="form-group">
																			<label>Peso</label> <input id="peso" name="peso"
																				type="text" class="form-control">
																		</div>
																	</div>


																	<div class="col-lg-2 col-xs-12">
																		<div class="form-group">
																			<label>Altura</label> <input id="
																				altura"
															name="altura" type="text"
																				class="form-control">
																		</div>
																	</div>

																</div>

															</div>



															




















															<div class="col-lg-12 col-xs-12">
																<div class="row">
																	
																	<div class="col-lg-3 col-xs-12">
																		<div class="form-group">
																			<label for="dtexame">Data do exame</label>
																			<!-- Datepicker as text field -->
																			<div class="input-group date"
																				data-date-format="dd/mm/yyyy">
																				<input type="text" class="form-control"
																					name="dtexame" id="dtexame"
																					placeholder="dd/mm/yyyy">
																				<div class="input-group-addon">
																					<span class="glyphicon glyphicon-th"></span>
																				</div>
																			</div>
																		</div>
																	</div>







																	<div class="col-lg-6 col-xs-12">
																		<div class="form-group">
																			<label>Solicitante</label> <input id="solicitante"
																				name="solicitante" type="text" class="form-control">
																		</div>
																	</div>
																	<div class="col-lg-3 col-xs-12">
																		<div class="form-group">
																			<label>CRM Solicitante</label> <input id="crm"
																				name="crm" type="text" class="form-control">
																		</div>
																	</div>
																	<div class="col-lg-7 col-xs-12">
																		<div class="form-group">
																			<label>Indicacao</label> <input id="Indicacao"
																				name="Indicacao" type="text" class="form-control">
																		</div>
																	</div>
																	
																
																	<div class="col-lg-3 col-xs-12">
																		<div class="form-group">
																			<label>Empresa</label> <input id="empresa"
																				name="empresa" type="text" class="form-control">
																		</div>
																	</div>


																</div>

															</div>







														</div>



													</div>







													
														<div class="row">
															<div class="col-lg-12">



																<input type="hidden" name="tpexame" id="tpexame">






															</div>

														</div>
														
													</form>
<div class="row">
															<div class="col-lg-12">
																<br> <input type="button" name="submit"
																	value="Submit" id="submit-all" class="btn" />
															</div>
														</div>

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
								<div class="span12">
									&copy; 2021 <a href="#">Zeitune Informática</a>.
								</div>
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
