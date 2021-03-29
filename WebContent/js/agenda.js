 
    
    function actionFormatter(value, row, index) {
    	return "<a href='#'><i class='icon-large icon-edit edit'></i></a>"
    	
    }
    
    window.actionEvents = {
    		'click .edit' : function(e, value, row, index) {
    			//alert(JSON.stringify(row));
					$('#form-cliente').each (function(){
									  this.reset();
									});
					$('#myModal').modal('show');
    			 popularCampos(row)
    			 $("#btnDeletar" ).removeClass( "disabled" );
    			 $("#btnPrint").removeClass( "disabled" );
    		}
    	};
    
	
	
    
    $(document).ready(function(){
    	
    	
   function Salvo(){
	   new Noty({
           type: 'success',
           layout: 'topRight',
           timeout: '600',
           text: 'Salvo com sucesso',
       }).show();
	   $("#btnDeletar" ).addClass( "disabled" );
	   $("#btnPrint" ).addClass( "disabled" );
	   $("#table").bootstrapTable('refresh');
   } 
   
   function Erro(){
	   new Noty({
           type: 'error',
           layout: 'topRight',
           timeout: '600',
           text: 'Algo deu errado',
       }).show();
	   $("#btnDeletar" ).addClass( "disabled" );
	   $("#btnPrint" ).addClass( "disabled" );
	   $("#table").bootstrapTable('refresh');
   } 
   
   
   $("#btnPrint").click(function() {
	   if (!$(this).hasClass('disabled')) {
	   elem = document.getElementById("printThis");
   
       var domClone = elem.cloneNode(true);
       
       var $printSection = document.getElementById("printSection");
       
       if (!$printSection) {
           var $printSection = document.createElement("div");
           $printSection.id = "printSection";
           document.body.appendChild($printSection);
       }
       
       $printSection.innerHTML = "";
       $printSection.appendChild(domClone);
       window.print();
	   }

	});
   
    	$("#btnSalvar").click(function() {    		
    		var form = $( "#form-cliente" );
    		form.validate();    		
    		if(form.valid()){
    			$("#form-cliente").ajaxSubmit({url: 'SaveServlet', type: 'post',success: 
       			 function(data){
       			if(data == "true"){
                       Salvo();
                   }else{
                       Erro();
                   }
       			 $('#myModal').modal('hide');
       		
       			}} )
    		}else{
    			   Erro();
    		}
    	});
    	
    	$("#btnDeletar").click(function() {
    		if (!$(this).hasClass('disabled')) {
    			$('#myModal3').modal('toggle');
    		}
    	});
    	
    	$("#btnDeletarModal").click(function() {
    		if (!$(this).hasClass('disabled')) {
    		$("#form-cliente").ajaxSubmit({url: 'DeleteServlet', type: 'post',success: 
   			 function(data){
   			if(data == "true"){
                   Salvo();
               }else{
                   Erro();
               }
   		 $('#myModal').modal('hide');
   		
   			}} )
    		}
    	});
    	
    	$("#logout").click(function() {
    		
    		$.ajax({
                url: 'Logout',
                type: 'post',
                success: function(data){
                	if(data == "True"){
           				$(location).attr('href','login.jsp')
                       }else{
                           //Erro();
                       }
                }
            });
    		
    	});
    	
$("#perfil").click(function() {
	$('#myModal2').modal('show');
    	});
    	
    	$("#btnClose").click(function() {
    		$('#myModal').modal('hide');
    		$("#btnDeletar" ).addClass( "disabled" );
    		$("#btnPrint" ).addClass( "disabled" );
    		$("#table").bootstrapTable('refresh');
    		$("#form-cliente").find('.has-error').css('border-color', '').removeClass('has-error');
    		$("#form-cliente").validate().resetForm();
    		
    	});
    	
    	$("#btnAdicionar").click(function() {
    		$('#id').val('');
    		$('#form-cliente').each (function(){
				  this.reset();
				});
    		

    		var ta = document.querySelector('textarea');
    		autosize.destroy(ta);
    		ta.style.display = 'none';
    		autosize(ta);
    		ta.style.display = '';

    		// Call the update method to recalculate the size:
    		autosize.update(ta);

    	});
    		
    	});
    
 
    function popularCampos(pessoa) {
    	$("#id").val(pessoa.id);
    	$("#nome_completo").val(pessoa.nome_completo);
    	$("#email").val(pessoa.email);
    	$("#dt_nascimento").val(pessoa.dt_nascimentoFormat);
    	$("#identidade").val(pessoa.identidade);
    	$("#cpfcnpj").val(pessoa.cpf);
    	$("#telefone").val(pessoa.telefone);
    	$("#celular").val(pessoa.celular);
    	$("#anotacao").val(pessoa.anotacao);
    	
    	$("#dt_emissao").val( pessoa.dt_emissaoFormat);
    	$("#emissor").val(pessoa.emissor);
    	$("#estado_civil").val(pessoa.estado_civil);
    	$("#nacionalidade").val(pessoa.nacionalidade);
    	$("#naturalidade").val(pessoa.naturalidade);
    	$("#profissao").val(pessoa.profissao);

    	$("#cep").val(pessoa.cep);
    	$("#numero").val(pessoa.numero);
    	$("#endereco").val(pessoa.endereco);
    	$("#estado").val(pessoa.estado);
    	$("#cidade").val(pessoa.cidade);
    	$("#bairro").val(pessoa.bairro);
    	$("#complemento").val(pessoa.complemento);

    	var ta = document.querySelector('textarea');
    	ta.style.display = 'none';
    	autosize(ta);
    	ta.style.display = '';

    	autosize.update(ta);
    }
    
    $(document).ready(function(){
       $('#salvarbtn').click(function()
       {
          $("#login").ajaxSubmit({url: 'Update', type: 'post',success: 
 			 function(data){
 			if(data == "True"){
 				$(location).attr('href','agenda.jsp')
             }else{
            	 Erro()
             } 
          }
           });
         });
       
       
       
       function Erro(){
     	   new Noty({
                type: 'error',
                layout: 'topRight',
                timeout: '600',
                text: 'Os dados não conferem',
            }).show();
        } 
       
       
    });
    