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
    <div class="container"> <a class="brand" href="#">Sistema - LaudeiTelemedicina</a>
      <!--/.nav-collapse --> 
    </div>
    <!-- /container --> 
  </div>
  <!-- /navbar-inner --> 
</div>
<!-- /navbar -->



<div class="main">
  <div class="main-inner">
    <div class="container">
      <div class="row">
        <div class="span12">
          

    
<div class=" col-xs-12  col-lg-12  col-md-12" id="codigo">

    
<div class="conteudo">

					<form id="form-externo" role="form" action="validarLaudo"
						method="post">

						<div class="row">
							<div class="col-lg-12">



							<div class="col-lg-12">
								<div class="panel panel-default">
									<a data-target="#item-arquivos">
										<div class="panel-heading">Codigo de validacao</div>
									</a>
									<div id="#item-obs" class="panel-body panel-branco collapse in">
										<div class="form-group">

											<input type="text" id="code" name="code" class="form-control" >


										</div>


									</div>
								</div>
							</div>
						</div>
					</form>
				</div>





			</div>
			




				<div class="row">

					<div class="col-lg-12 col-xs-12">
						

						<div class="col-lg-2 col-xs-6">
							<div class="form-group">
								<button type="submit" id="btnValidar" class="btn btn-primary">Enviar</button>
							</div>
						</div>
						<div class="col-lg-2 col-xs-6">
							<div class="form-group">
								<button type="reset" id="btnLimpar" class="btn btn-primary">Limpar</button>
							</div>
						</div>
						
						

					</div>
				</div>
			
	

	


	


    
    
        </div>
        <!-- /span6 -->
        
      </div>
      <!-- /row --> 
    </div>
    <!-- /container --> 
  </div>
  <!-- /main-inner --> 
</div>


<div class="main">
  <div class="main-inner">
    <div class="container">
      <div class="row">
        <div class="span12">
          

    
<div class=" col-xs-12  col-lg-12  col-md-12" id="exame" style="display:none">

    
<div class="conteudo">

					

						<div class="row">
							<div class="col-lg-12">



							<div class="col-lg-12">
								<div class="panel panel-default">
									<a data-target="#item-arquivos">
										<div class="panel-heading" id="nomeLaudo"></div>
									</a>
									<div id="#item-obs" class="panel-body panel-branco collapse in">
										<div class="form-group">

											 <textarea id="laudo"  disabled name="laudo" class="form-control editor" rows="10" style="overflow: hidden" onkeyup="this.style.height='24px'; this.style.height = this.scrollHeight + 12 + 'px';"></textarea>
    


										</div>


									</div>
								</div>
							</div>
						</div>
					</form>
				</div>





			</div>
			




					

	


	


    
    
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
