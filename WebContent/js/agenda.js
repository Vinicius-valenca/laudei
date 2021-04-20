 
    
    function actionFormatter(value, row, index) {
    	return "<a href='#'><i class='icon-large icon-edit edit'></i></a>"
    	
    }
    
    function actionFormatter1(value, row, index) {
    	return "<a href='#'><i class='icon-large icon-search search'></i></a>"
    	
    }
    
    function actionFormatter2(value, row, index) {
    	return "<a href='#'><i class='icon-large icon-trash trash'></i></a>"
    	
    }
    
    window.actionEvents = {
    		'click .edit' : function(e, value, row, index) {
    			//alert(JSON.stringify(row));
    			

    			
					$('#form-cliente').each (function(){
									  this.reset();
									});
					$("#id").val(row.id);
					$("#idPessoa").val($("#idPessoa1").val());
					$("#laudo").val(row.laudo);
					var ta = document.querySelector('textarea');
			    	ta.style.display = 'none';
			    	autosize(ta);
			    	ta.style.display = '';

			    	autosize.update(ta);
					if($("#tpperfil").val()==="2"){
						$("#btnSalvar" ).addClass( "disabled" );
						$("#btnSalvar").prop("disabled",true);
					}else{
						$("#btnSalvar" ).removeClass( "disabled" );
						$("#btnSalvar" ).prop("disabled",false);
					}
					
					$('#myModal').modal('show');
    			 
    		}
    	};
    
    window.actionEvents2 = {
    		'click .trash' : function(e, value, row, index) {
    			$("#id").val(row.id);
    			$('#myModal3').modal('show');
    							
    		}
    	};
    
    window.actionEvents1 = {
    		'click .search' : function(e, value, row, index) {
    			console.log(JSON.stringify(row.exameArquivo));
    			//$("#id").val(row.id);
    			//$("#file").val(row.exameArquivo.exame);
    			//alert(row.exameArquivo.nomeExame)
    			var n = row.exameArquivo.nomeExame.lastIndexOf(".");
    			//alert(n)
    			//alert(row.exameArquivo.nomeExame.substring(n, row.exameArquivo.nomeExame.length))    // retorna "zil"
    			var bytes = new Uint8Array(row.exameArquivo.exame); // pass your byte response to this constructor

    			var blob=new Blob([bytes], {type: "application/"+row.exameArquivo.nomeExame.substring(row.exameArquivo.nomeExame.length - 3)});// change resultByte to bytes

    			var link=document.createElement('a');
    			link.href=window.URL.createObjectURL(blob);
    			link.download=row.exameArquivo.nomeExame;
    			//link.click();
    			window.open(link, '_blank').focus();
					
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
   
   

   
    	$("#btnSalvar").click(function() {    		
    		var form = $( "#form-cliente" );
    		form.validate();    		
    		if(form.valid()){
    			$("#form-cliente").ajaxSubmit({url: 'salvarLaudo', type: 'post',success: 
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
    			
    			$('#myModal3').modal('toogle');
    		}
    	});
    	
    	$("#btnDeletarModal").click(function() {    		
    		$("#form-cliente").ajaxSubmit({url: 'deletarExame', type: 'post',success: 
   			 function(data){
   			if(data == "true"){
                   Salvo();
               }else{
                   Erro();
               }
   		 $('#myModal').modal('hide');
   		
   			}} )
    		
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
    	
    
    		
    	});
    
 
    
    
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
    