<div id="myModal2" class="modal" role="dialog">
  <div class="modal-dialog myModal2">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Dados</h4>
      </div>
      <div class="modal-body">
      
      
      <div class="account-container">
	
	<div class="content clearfix">
		
		
		<div class="conteudo">
				
		
		<form action="Update" method="post" id="login">
		
					<div class="row">
						<div class="col-lg-12">

							

							<div class="panel panel-default">

	
	<div id="item-info" class="panel-body panel-branco collapse in">
	
          
          
       
				

		<div class="col-lg-12 col-xs-12 col-sm-12">
			<div class="row">
		
			<div class="login-fields">
				<input type="hidden" id="idUser" name="idUser" value="<%=request.getSession().getAttribute("id")%>" />
			<div class="col-lg-12 col-xs-12 col-sm-12">
				<div class="field form-group">
					<label for="username">Usuário</label>
					<input type="text" id="userId" name="userId" value="<%=request.getSession().getAttribute("userId")%>" required="required" placeholder="Usuário" class="login username-field" autocomplete="off"/>
				</div> <!-- /field -->
				</div>
				<div class="col-lg-12 col-xs-12 col-sm-12">
				<div class="field form-group">
					<label for="password">Senha Antiga:</label>
					<input type="password" id="oldpassword" name="oldpassword" value="" placeholder="Senha antiga" required="required" class="login password-field"/>
				</div> <!-- /password -->
				</div>
				<div class="col-lg-12 col-xs-12 col-sm-12">
				<div class="field form-group">
					<label for="password">Nova Senha:</label>
					<input type="password" id="newpassword" name="newpassword" value="" placeholder="Nova Senha" required="required" class="login password-field"/>
				</div> <!-- /password -->
				</div>
			</div> <!-- /login-fields -->
			</div> 
			</div> 
			</div> 
			</div> 
			</div> 
			</div> 
		
			
			
			
		</form>
		</div> 
		
	</div> <!-- /content -->
	
</div> <!-- /account-container -->
      
      
      
      
        

      </div>
      <div class="modal-footer">

        
						<div class="login-actions">
				
				
									
				<button id="salvarbtn" class="button btn btn-success btn-large" type="button">Salvar</button>
			</div> <!-- .actions -->
			
				
			</div>
      </div>
  </div>
</div>