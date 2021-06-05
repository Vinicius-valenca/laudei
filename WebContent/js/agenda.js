 
      $.fn.datepicker.defaults.language = 'pt-BR';
      
      
    function actionFormatter(value, row, index) {
    	return "<a href='#'><i class='icon-large icon-edit edit'></i></a>"
    	
    }
    
    function actionFormatter1(value, row, index) {
    	return "<a href='#'><i class='icon-large icon-search search'></i></a>"
    	
    }
    
    function actionFormatter2(value, row, index) {
    	return "<a href='#'><i class='icon-large icon-trash trash'></i></a>"
    	
    }
    
    
    function dateFormat(value, row, index) {
    	   return moment(value).format('DD/MM/YYYY hh:mm');
    	}
    
    function nomeFormat(value, row, index) {
    	
    	  return value.split('.')[0]
    	}
    startDateFormat = moment(moment().utc().valueOf()).format('MM/YYYY');
	$('#mes_referencia').datepicker({
		format: "mm/yyyy",
	    startView: 1,
	    minViewMode: 1,
	    startDate: startDateFormat,
		language : "pt-BR"
	});
	
	$('.date').datepicker({
		language : "pt-BR"
	 });
    
    window.actionEvents = {
    		'click .edit' : function(e, value, row, index) {
    			
    			console.log(JSON.stringify(row))
    					

    			
					$('#form-cliente').each (function(){
									  this.reset();
									});
					$("#id").val(row.id);
					 $('#nomeLaudo').empty();
					 $('#nomeLaudo').append("Laudo - "+row.tpExame+" - "+row.nomePaciente.split('.')[0]);
					$("#idPessoa").val($("#idPessoa1").val());
					
					$("#examenome").val(row.examenome);
					
					
					
					if(row.laudo===undefined){
						$("#editor").html("");
						
					}else{
						$("#editor").html( row.laudo);
					}
					
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
    			$("#examenome").val(row.examenome);
    			$('#myModal3').modal('show');
    			
    							
    		}
    	};
    
    window.actionEvents1 = {
    		'click .search' : function(e, value, row, index) {
    			console.log(row)
    			
    			let a= document.createElement('a');
    			a.target= '_blank';
    			a.href= 'http://sys.laudeitelemedicina.com.br/'+row.examenome;
    			a.click();
					
    		}
    	};
    
	
	
    
    $(document).ready(function(){
    	
    	 // For init plugin use:
       // $('.editor').wysihtml5({locale: "pt-BR",  toolbar: {
           
         //   "color": true
          //},stylesheets: ["css/bootstrap3-wysiwyg5-color.css"]});
    	
   function Salvo(){
	   new Noty({
           type: 'success',
           layout: 'topRight',
           timeout: '600',
           text: 'Salvo com sucesso',
       }).show();
	   $("#btnDeletar" ).addClass( "disabled" );
	   //$("#btnPrint" ).addClass( "disabled" );
	   //$("#table").bootstrapTable('refresh');
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
    		//$("#table").bootstrapTable('refresh');
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
       
       
       $("#btnBuscar").click(function() {
   		mes_ref = $('#mes_referencia').val();  
   		
   		$.ajax({
   			type : 'GET',
   			url : 'listarExamesComLaudo',
   			data: { mes_ref : $('#mes_referencia').val() } ,
   			contentType : 'application/json; charset=utf-8',
   			dataType : 'json',
   			success : function(retornoJson) {
   				$('#table').bootstrapTable('load', retornoJson);
   				
   			
   					console.log("retornoJson", retornoJson);
   					//var lista= JSON.parse(retornoJson);	
   					//console.log("lista", lista);
   					//popularCampos(lista);
   					
   				
   			}
   		});
   		
   		$.ajax({
   			type : 'GET',
   			url : 'listarExamesSemLaudo',
   			data: { mes_ref : mes_ref } ,
   			contentType : 'application/json; charset=utf-8',
   			dataType : 'json',
   			success : function(retornoJson) {
   				$('#table2').bootstrapTable('load', retornoJson);
   				
   					console.log("retornoJson", retornoJson);
   					//var lista= JSON.parse(retornoJson);	
   					//console.log("lista", lista);
   					//popularCampos(lista);
   					
   				
   			}
   		});
       });
       
    });
    