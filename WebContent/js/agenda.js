 var wysihtml5ParserRules = {
					 "classes": {
			  "wysiwyg-clear-both": 1,
			  "wysiwyg-clear-left": 1,
			  "wysiwyg-clear-right": 1,
			  "wysiwyg-color-aqua": 1,
			  "wysiwyg-color-black": 1,
			  "wysiwyg-color-blue": 1,
			  "wysiwyg-color-fuchsia": 1,
			  "wysiwyg-color-gray": 1,
			  "wysiwyg-color-green": 1,
			  "wysiwyg-color-lime": 1,
			  "wysiwyg-color-maroon": 1,
			  "wysiwyg-color-navy": 1,
			  "wysiwyg-color-olive": 1,
			  "wysiwyg-color-purple": 1,
			  "wysiwyg-color-red": 1,
			  "wysiwyg-color-silver": 1,
			  "wysiwyg-color-teal": 1,
			  "wysiwyg-color-white": 1,
			  "wysiwyg-color-yellow": 1,
			  "wysiwyg-float-left": 1,
			  "wysiwyg-float-right": 1,
			  "wysiwyg-font-size-large": 1,
			  "wysiwyg-font-size-larger": 1,
			  "wysiwyg-font-size-medium": 1,
			  "wysiwyg-font-size-small": 1,
			  "wysiwyg-font-size-smaller": 1,
			  "wysiwyg-font-size-x-large": 1,
			  "wysiwyg-font-size-x-small": 1,
			  "wysiwyg-font-size-xx-large": 1,
			  "wysiwyg-font-size-xx-small": 1,
			  "wysiwyg-text-align-center": 1,
			  "wysiwyg-text-align-justify": 1,
			  "wysiwyg-text-align-left": 1,
			  "wysiwyg-text-align-right": 1
			 },
			 "tags": {
			  "a": {
			   "check_attributes": {
			    "href": "url",
			    "target": "any"
			   },
			   "set_attributes": {
			    "rel": "nofollow"
			   }
			  },
			  "abbr": {
			   "rename_tag": "span"
			  },
			  "acronym": {
			   "rename_tag": "span"
			  },
			  "address": {
			   "rename_tag": "div"
			  },
			  "applet": {
			   "remove": 1
			  },
			  "area": {
			   "remove": 1
			  },
			  "article": {
			   "rename_tag": "div"
			  },
			  "aside": {
			   "rename_tag": "div"
			  },
			  "audio": {
			   "remove": 1
			  },
			  "b": {},
			  "base": {
			   "remove": 1
			  },
			  "basefont": {
			   "remove": 1
			  },
			  "bdi": {
			   "rename_tag": "span"
			  },
			  "bdo": {
			   "rename_tag": "span"
			  },
			  "bgsound": {
			   "remove": 1
			  },
			  "big": {
			   "rename_tag": "span",
			   "set_class": "wysiwyg-font-size-larger"
			  },
			  "blink": {
			   "rename_tag": "span"
			  },
			  "blockquote": {
			   "check_attributes": {
			    "cite": "url"
			   }
			  },
			  "body": {
			   "rename_tag": "div"
			  },
			  "br": {
			   "add_class": {
			    "clear": "clear_br"
			   }
			  },
			  "button": {
			   "rename_tag": "span"
			  },
			  "canvas": {
			   "remove": 1
			  },
			  "caption": {
			   "add_class": {
			    "align": "align_text"
			   }
			  },
			  "center": {
			   "rename_tag": "div",
			   "set_class": "wysiwyg-text-align-center"
			  },
			  "cite": {},
			  "code": {},
			  "col": {
			   "remove": 1
			  },
			  "colgroup": {
			   "remove": 1
			  },
			  "command": {
			   "remove": 1
			  },
			  "comment": {
			   "remove": 1
			  },
			  "datalist": {
			   "rename_tag": "span"
			  },
			  "dd": {
			   "rename_tag": "div"
			  },
			  "del": {
			   "remove": 1
			  },
			  "details": {
			   "rename_tag": "div"
			  },
			  "device": {
			   "remove": 1
			  },
			  "dfn": {
			   "rename_tag": "span"
			  },
			  "dir": {
			   "rename_tag": "ul"
			  },
			  "div": {
			   "add_class": {
			    "align": "align_text"
			   }
			  },
			  "dl": {
			   "rename_tag": "div"
			  },
			  "dt": {
			   "rename_tag": "span"
			  },
			  "em": {},
			  "embed": {
			   "remove": 1
			  },
			  "fieldset": {
			   "rename_tag": "div"
			  },
			  "figcaption": {
			   "rename_tag": "div"
			  },
			  "figure": {
			   "rename_tag": "div"
			  },
			  "font": {
			   "add_class": {
			    "size": "size_font"
			   },
			   "rename_tag": "span"
			  },
			  "footer": {
			   "rename_tag": "div"
			  },
			  "form": {
			   "rename_tag": "div"
			  },
			  "frame": {
			   "remove": 1
			  },
			  "frameset": {
			   "remove": 1
			  },
			  "h1": {
			   "add_class": {
			    "align": "align_text"
			   }
			  },
			  "h2": {
			   "add_class": {
			    "align": "align_text"
			   }
			  },
			  "h3": {
			   "add_class": {
			    "align": "align_text"
			   }
			  },
			  "h4": {
			   "add_class": {
			    "align": "align_text"
			   }
			  },
			  "h5": {
			   "add_class": {
			    "align": "align_text"
			   }
			  },
			  "h6": {
			   "add_class": {
			    "align": "align_text"
			   }
			  },
			  "head": {
			   "remove": 1
			  },
			  "header": {
			   "rename_tag": "div"
			  },
			  "hgroup": {
			   "rename_tag": "div"
			  },
			  "hr": {},
			  "html": {
			   "rename_tag": "div"
			  },
			  "i": {},
			  "iframe": {
			   "remove": 1
			  },
			  "img": {
			   "add_class": {
			    "align": "align_img"
			   },
			   "check_attributes": {
			    "alt": "alt",
			    "height": "numbers",
			    "src": "url",
			    "width": "numbers"
			   }
			  },
			  "input": {
			   "remove": 1
			  },
			  "ins": {
			   "rename_tag": "span"
			  },
			  "isindex": {
			   "remove": 1
			  },
			  "kbd": {
			   "rename_tag": "span"
			  },
			  "keygen": {
			   "remove": 1
			  },
			  "label": {
			   "rename_tag": "span"
			  },
			  "legend": {
			   "rename_tag": "span"
			  },
			  "li": {},
			  "link": {
			   "remove": 1
			  },
			  "listing": {
			   "rename_tag": "div"
			  },
			  "map": {
			   "rename_tag": "div"
			  },
			  "mark": {
			   "rename_tag": "span"
			  },
			  "marquee": {
			   "rename_tag": "span"
			  },
			  "menu": {
			   "rename_tag": "ul"
			  },
			  "meta": {
			   "remove": 1
			  },
			  "meter": {
			   "rename_tag": "span"
			  },
			  "multicol": {
			   "rename_tag": "div"
			  },
			  "nav": {
			   "rename_tag": "div"
			  },
			  "nextid": {
			   "remove": 1
			  },
			  "nobr": {
			   "rename_tag": "span"
			  },
			  "noembed": {
			   "remove": 1
			  },
			  "noframes": {
			   "remove": 1
			  },
			  "noscript": {
			   "remove": 1
			  },
			  "object": {
			   "remove": 1
			  },
			  "ol": {},
			  "optgroup": {
			   "rename_tag": "span"
			  },
			  "option": {
			   "rename_tag": "span"
			  },
			  "output": {
			   "rename_tag": "span"
			  },
			  "p": {
			   "add_class": {
			    "align": "align_text"
			   }
			  },
			  "param": {
			   "remove": 1
			  },
			  "plaintext": {
			   "rename_tag": "span"
			  },
			  "pre": {},
			  "progress": {
			   "rename_tag": "span"
			  },
			  "q": {
			   "check_attributes": {
			    "cite": "url"
			   }
			  },
			  "rb": {
			   "rename_tag": "span"
			  },
			  "rp": {
			   "rename_tag": "span"
			  },
			  "rt": {
			   "rename_tag": "span"
			  },
			  "ruby": {
			   "rename_tag": "span"
			  },
			  "s": {
			   "rename_tag": "span"
			  },
			  "samp": {
			   "rename_tag": "span"
			  },
			  "script": {
			   "remove": 1
			  },
			  "section": {
			   "rename_tag": "div"
			  },
			  "select": {
			   "rename_tag": "span"
			  },
			  "small": {
			   "rename_tag": "span",
			   "set_class": "wysiwyg-font-size-smaller"
			  },
			  "source": {
			   "remove": 1
			  },
			  "spacer": {
			   "remove": 1
			  },
			  "span": {},
			  "strike": {
			   "remove": 1
			  },
			  "strong": {},
			  "style": {
			   "remove": 1
			  },
			  "sub": {
			   "rename_tag": "span"
			  },
			  "summary": {
			   "rename_tag": "span"
			  },
			  "sup": {
			   "rename_tag": "span"
			  },
			  "svg": {
			   "remove": 1
			  },
			  "table": {},
			  "tbody": {
			   "add_class": {
			    "align": "align_text"
			   }
			  },
			  "td": {
			   "add_class": {
			    "align": "align_text"
			   },
			   "check_attributes": {
			    "colspan": "numbers",
			    "rowspan": "numbers"
			   }
			  },
			  "textarea": {
			   "rename_tag": "span"
			  },
			  "tfoot": {
			   "add_class": {
			    "align": "align_text"
			   }
			  },
			  "th": {
			   "add_class": {
			    "align": "align_text"
			   },
			   "check_attributes": {
			    "colspan": "numbers",
			    "rowspan": "numbers"
			   }
			  },
			  "thead": {
			   "add_class": {
			    "align": "align_text"
			   }
			  },
			  "time": {
			   "rename_tag": "span"
			  },
			  "title": {
			   "remove": 1
			  },
			  "tr": {
			   "add_class": {
			    "align": "align_text"
			   }
			  },
			  "track": {
			   "remove": 1
			  },
			  "tt": {
			   "rename_tag": "span"
			  },
			  "u": {},
			  "ul": {},
			  "var": {
			   "rename_tag": "span"
			  },
			  "video": {
			   "remove": 1
			  },
			  "wbr": {
			   "remove": 1
			  },
			  "xml": {
			   "remove": 1
			  },
			  "xmp": {
			   "rename_tag": "span"
			  }
			 }			};
			 
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
    	
    	 
    function vistoFormat(value, row, index) {
    	if(value){
    	return "<a href='#'><i class='icon-large icon-check'></i></a>"
    	}else{
    	return "<a href='#'><i class='icon-large icon-check-empty'></i></a>"}
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
						$("#obs").val("");
					}else{
				        $("#obs").val( row.obs);
						
					
					}
					
				
						 					
						 				
					
					if(row.laudo===undefined){
						
						$("#editor").val("");
					}else{
				        
						$("#editor").val(row.laudo + validar);
						
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
       
    });
    