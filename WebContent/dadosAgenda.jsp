

<div id="myModal" class="modal" role="dialog">
  <div class="modal-dialog myModal">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-body">
      
      
      
      <div class="conteudo">
				<form id="form-cliente" role="form" action="SaveServlet" method="post">
					<div class="row">
						<div class="col-lg-12">

							

							<div class="panel panel-default">
	
	<a data-target="#item-telefones">
		<div class="panel-heading">Informa&ccedil;&otilde;es Pessoais</div>
	</a>
	<div id="item-info" class="panel-body panel-branco collapse in">
	
          
          
          
		 <input id="id" name="id" type="hidden"
							class="form-control" value="${id}" readonly>
				

		<div class="col-lg-12 col-xs-12">
			<div class="row">
				<div class="col-lg-9 col-xs-9">
					<div class="form-group">
						<label>Nome Completo</label> <input id="nome_completo" name="nome_completo"
							type="text" class="form-control">
					</div>
				</div>

				<div class="col-lg-3 col-xs-3">
					<div class="form-group">
						<label>CPF/CNPJ</label> <input id="cpfcnpj" name="cpfcnpj" type="text"
							class="cpf form-control hibridCpf cpfcnpj"  onkeypress='mascaraMutuario(this,cpfCnpj)' onblur='clearTimeout()'>
					</div>
				</div>
				
			
				
				</div>

			</div>
		

		<div class="col-lg-12 col-xs-12">
			<div class="row">
				
				
				
			<div class="col-lg-6 col-xs-6">
					<div class="form-group">
						<label>Email</label> <input id="email" name="email" type="email"
							class="form-control" placeholder="cliente@gmail.com">
					</div>
				</div>
				
				
 
				
				
		
		
	
	
		<div class="col-lg-3 col-xs-3">
			
			
						<div class="form-group">
							<label>Telefone</label>
							<div class="input-group">
								<input id="telefone" name="telefone" type="text"
									class="telefone form-control">
							</div>
					
			</div>
		</div>

		<div class="col-lg-3 col-xs-3">
			
			
						<div class="form-group">
							<label>Celular</label>
							<div class="input-group">
								<input id="celular" name="celular" type="text"
									class="celular form-control">
							</div>
						
				
			</div>
		</div>
			</div>

</div>
		
	</div>
</div>
</div>



							<div class="col-lg-12">
							<div class="panel panel-default">
	<a data-target="#item-endereco">
		<div class="panel-heading"> Endere&ccedil;o </div>
	</a>
	<div id="item-endereco" class="panel-body panel-branco collapse in">
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
	</div>
</div>
</div>
<div class="col-lg-12 col-xs-12">
							<div class="panel panel-default">
	<a data-target="#item-telefones">
		<div class="panel-heading"> Anotações </div>
	</a>
	<div id="item-obs" class="panel-body panel-branco collapse in">
		

			<div class="col-lg-12 col-xs-12">
					<div class="form-group">
						<textarea id="anotacao" name="anotacao"
							type="textarea" class="form-control" rows="2"></textarea>
					</div>
				</div>
		

	</div>
</div>
</div>


							

							

						</div>
						</form>
					</div>
      
      
      
        

      </div>
      <div class="modal-footer">

        <div class="row">
        
        <div class="col-lg-12 col-xs-12">
        			<div class="col-lg-2 col-xs-2 ">
					<div class="form-group">
        <button type="button" id="btnPrint" class="btn btn-default disabled">Imprimir</button>
        </div>
			</div>
			
					<div class="col-lg-2 col-xs-2">
					<div class="form-group">
        <button type="submit" id="btnSalvar" class="btn btn-primary">Salvar</button>
        </div>
			</div>
			<div class="col-lg-2 col-xs-2">
					<div class="form-group">
        <button type="reset" id="btnLimpar" class="btn btn-primary">Limpar</button>
                </div>
			</div>
			<div class="col-lg-2 col-xs-2">
					<div class="form-group">
        <button type="button" id="btnDeletar" class="btn btn-danger disabled">Deletar</button>
                </div>
			</div>
			<div class="col-lg-2 col-xs-2">
					<div class="form-group">
        <button type="button" id="btnClose" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
     </div>
			</div>
				
			</div>
			</div>
      </div>
      </div>
  </div>
  <div class="modal" id="myModal3" data-backdrop="static">
	<div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
          <h4 class="modal-title">Confirmar Exclusão</h4>
        </div><div class="container"></div>
        <div class="modal-body">
          Tem certeza que deseja deletar o cadastro ?
        </div>
        <div class="modal-footer">
          <a href="#" data-dismiss="modal" class="btn">Não</a>
          <a href="#" data-dismiss="modal" class="btn btn-primary" id=btnDeletarModal>Sim</a>
        </div>
      </div>
    </div>
</div>
</div>