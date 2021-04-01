<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html lang="en">
  
<head>
    <meta charset="utf-8">
    <title>Login - Sistema - LaudeiTelemedicina </title>

	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes"> 
    
<link href="css/bootstrap-template.min.css" rel="stylesheet" type="text/css" />
<link href="css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css" />
    <link href="css/noty.css" rel="stylesheet">

<link href="css/font-awesome.css" rel="stylesheet">
    <link href="css/font.css?family=Open+Sans:400italic,600italic,400,600" rel="stylesheet">
    
<link href="css/style.css" rel="stylesheet" type="text/css">
<link href="css/pages/signin.css" rel="stylesheet" type="text/css">
<script src="js/jquery.min.js"></script>
 <script src="js/jquery.form.js"></script>
    
    <script src="js/noty.js" type="text/javascript"></script>


</head>


   
<script>
    $(document).ready(function(){
       $('#loginbtn').click(function()
       {
          $("#login").ajaxSubmit({url: 'Login', type: 'post',success: 
 			 function(data){
 			if(data == "True"){
 				$(location).attr('href','agenda.jsp')
             }else{
            	 Erro()
             } 
          }
           });
         });
       
       var msg =""
        msg = '${msg}';
       
       if(msg!=""){
    	   new Noty({
               type: 'error',
               layout: 'topRight',
               timeout: '1500',
               text: msg,
           }).show();
       }
       
       function Erro(){
     	   new Noty({
                type: 'error',
                layout: 'topRight',
                timeout: '1500',
                text: 'Os dados não conferem',
            }).show();
        } 
       
       
    });
    
    
   </script>
   
   
<body>
	
	<div class="navbar navbar-fixed-top">
	
	<div class="navbar-inner">
		
		<div class="container">
			
			<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</a>
			
			<a class="brand" href="login.jsp">
				Sistema - LaudeiTelemedicina				
			</a>		
			
				
	
		</div> <!-- /container -->
		
	</div> <!-- /navbar-inner -->
	
</div> <!-- /navbar -->



<div class="account-container">
	
	<div class="content clearfix">
		
		<form action="Login" method="post" id="login">
		
			<h1>Login</h1>		
			
			<div class="login-fields">
				
				<p>Prencha os campos abaixo:</p>
				
				<div class="field">
					<label for="username">Usuário</label>
					<input type="text" id="userId" name="userId" value="" placeholder="Usuário" class="login username-field" autocomplete="off"/>
				</div> <!-- /field -->
				
				<div class="field">
					<label for="password">Senha:</label>
					<input type="password" id="password" name="password" value="" placeholder="Senhas" class="login password-field"/>
				</div> <!-- /password -->
				
			</div> <!-- /login-fields -->
			
			<div class="login-actions">
				
				
									
				<button id="loginbtn" class="button btn btn-success btn-large" type="button">Entrar</button>
			</div> <!-- .actions -->
			
			
			
		</form>
		
	</div> <!-- /content -->
	
</div> <!-- /account-container -->
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
