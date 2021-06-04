  <div class="modal" id="myModal3" role="dialog"  >
	<div class="modal-dialog myModal3">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">X</button>
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

<div id="myModal" class="modal" role="dialog">
  <div class="modal-dialog myModal">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-body">
      
        <input id="idPessoa1" name="idPessoa1" type="hidden"
							class="form-control" value="<%=session.getAttribute("id") %>" readonly>
      
      <div class="conteudo">
				<form id="form-cliente" role="form"  method="post">
					<div class="row">
						<div class="col-lg-12">

							

							<div class="panel panel-default">
	
	<a data-target="#item-telefones">
		<div class="panel-heading" ><div id="nomeLaudo"></div></div>
	</a>
	<div id="item-info" class="panel-body panel-branco collapse in">
	
    			
          <input id="idPessoa" name="idPessoa" type="hidden"
							class="form-control" value="<%=session.getAttribute("id") %>" readonly>
							
							<input id="tpperfil" name="tpperfil" type="hidden"
							class="form-control" value="<%=session.getAttribute("tpperfil") %>" readonly>
          
		 <input id="id" name="id" type="hidden"
							class="form-control" value="${id}" readonly>
							
							 <input id="examenome" name="examenome" type="hidden"
							class="form-control" value="${examenome}" readonly>
				 <input id="file" name="file" type="hidden"
							class="form-control" value="${file}" readonly>

		
<div class="col-lg-12 col-xs-12">
							
	<div id="item-obs" class="panel-body panel-branco collapse in">
		

			<div class="col-lg-12 col-xs-12">
					
    <div class="form-group">
        
        <textarea id="editor" class="form-control editor" rows="3"></textarea>
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
        			
			
					<div class="col-lg-4 col-xs-4">
					<div class="form-group">
        <button type="button" id="btnSalvar" class="btn btn-primary">Salvar</button>
        </div>
			</div>
			
			
			<div class="col-lg-6 col-xs-6">
					<div class="form-group">
        <button type="button" id="btnClose" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
     </div>
			</div>
				
			</div>
			</div>
      </div>
      </div>
  </div>

</div>

