 
			 
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
    	   return moment(value).format('DD/MM/YYYY HH:mm');
    	}
    
    function nomeFormat(value, row, index) {
    	
    	  return value.split('.')[0]
    	}
    
    function datesSorter(a, b) {
    	  if (new Date(a) < new Date(b)) return 1;
    	  if (new Date(a) > new Date(b)) return -1;
    	  return 0;
    	}
    	
    	 
    function vistoFormat(value, row, index) {
    	if(value){
    	return "<i class='icon-large icon-check'></i>"
    	}else{
    	return "<i class='icon-large icon-check-empty'></i>"}
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
    					
var validar = "\n\nAcesso ao laudo na plataforma pelo link www.laudeitelemedicina.com.br/validar digitando o seguinte código: "+row.code  
    			
					$('#form-cliente').each (function(){
									  this.reset();
									});
					$("#id").val(row.id);
					 $('#nomeLaudo').empty();
					 $('#nomeLaudo').append("Laudo - "+row.tpExame+" - "+row.nomePaciente.split('.')[0]);
					$("#idPessoa").val($("#idPessoa1").val());
					
					$("#examenome").val(row.examenome);
					
					
					
					if(row.obs===undefined){
						$('#obs').val("").trigger('change');
					}else{
				        $('#obs').val(row.obs).trigger('change');
						
					
					}
					
				
						 					
					
					
					if(row.laudo===undefined){
						
						$('#editor').val("").trigger('change');
					}else{
				        
						$('#editor').val(row.laudo + validar).trigger('change');
						
						//copyClipboard(row.laudo)

						
					}
					
					

					
					
					if($("#tpperfil").val()==="2"){	
						 //$('#editor').data("wysihtml5").disable();
						
						//$('#editor').data('wysihtml5').editor.composer.disable();
						//$('#editor').attr('contenteditable', false);
						$('textarea[name="laudoobs"]').prop('disabled', false); // disable
						
						$("#form-cliente").ajaxSubmit({url: 'vistoLaudo', type: 'post',data : {
                id : row.id
            },success: 
       			 function(data){
       			if(data == "true"){       				
                       //Salvo();
                       	    		
                   }else{
                       //Erro();
                   }}});
					}else{
						
						//$('#editor').data('wysihtml5').editor.composer.enable();
						$('textarea[name="laudoobs"]').prop('disabled', true); // disable
					}
					
					$('#myModal').modal('show');
					var ta = document.querySelector('textarea');
					
					autosize(ta);
    			 
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
    
    function copyClipboard(text) {
    	
    	var $temp = $("<input>");
    	  $("body").append($temp);
    	  $temp.val($($('#editor').wysihtml5()).text()).select();
    	  document.execCommand("copy");
    	  $temp.remove();

    }
    
   
	
    
    $(document).ready(function(){
    	
    	 // For init plugin use:
      
        
    
        
       
        
    	
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
    	
    
    			
       			
    	
    	
    	
    	
    	$("#btnValidar").click(function() {    		
    		var form = $( "#form-externo" );
    		form.validate();    		
    		if(form.valid()){
    			$("#form-externo").ajaxSubmit({url: 'validarLaudo', type: 'post',success: 
       			 function(data){
       			 var teste = JSON.parse(data)
    			
    					
       			 
       			if(data != "null"){       				
                       $('#codigo').hide();
                       	    				
					 $('#nomeLaudo').empty();
					 $('#nomeLaudo').append("Laudo - "+JSON.stringify(teste.tpExame)+" - "+JSON.stringify(teste.nomePaciente).split('.')[0]);
					
					 var newline = String.fromCharCode(13, 10);
					 
					 
					$("#laudo").val(JSON.stringify(teste.laudo).replaceAll('\\n', newline));
                       	    					
                       $('#exame').show();
                       var ta = document.querySelector('textarea');
       				
   					autosize(ta);
                   }else{
                        new Noty({
                type: 'error',
                layout: 'topRight',
                timeout: '600',
                text: 'Verifique o codigo digitado.',
            }).show();
                   }
       			 
       		
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
       
       
       $('#btncformatacao').click(function()
    	       {
    	   copyRichText($("#editor").val());    	   
    	         });
       
       
       
       $('#btnsformatacao').click(function()
    	       {
    	   copyToClipboard($("#editor").val())
    	         });
       
       
       
       
       function copyToClipboard(text) {
    	   
    	   const listener = function(ev) {
    	     ev.preventDefault();
    	     ev.clipboardData.setData('text/plain', remove_tags(text));
    	   };
    	   document.addEventListener('copy', listener);
    	   document.execCommand('copy');
    	   document.removeEventListener('copy', listener);
    	 }
       
       function copyRichText(text) {
    	   const listener = function(ev) {
    	     ev.preventDefault();
    	     ev.clipboardData.setData('text/html', text);
    	     ev.clipboardData.setData('text/plain', text);
    	   };
    	   document.addEventListener('copy', listener);
    	   document.execCommand('copy');
    	   document.removeEventListener('copy', listener);
    	 }
       
       function remove_tags(html) {
           html = html.replace(/<br>/g, "");
           html = html.replace(/(?:\r\n|\r|\n)/g, '');
           var tmp = document.createElement("DIV");
           tmp.innerHTML = html;
           html = tmp.textContent || tmp.innerText;
           html = html.replace(/\$br\$/g, "");
           return html;
       }

    	 
       
       
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
       
       $('#myModal').on('hidden.bs.modal', function () {
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
  
})


$('.contentRich').richText({
		  adaptiveHeight: true,
});
       
       $('.contentRich1').richText({
 		  adaptiveHeight: true,
 });

       
    });
    
    
  
    
  
    