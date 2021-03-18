$(document).ready(function(){
	
	jQuery.extend(jQuery.validator.messages, {
	    required: "Campo Obrigat&oacute;rio.",
	    remote: "Por favor conserte esse campo.",
	    email: "Por favor digite um email valido.",
	    url: "Por favor digite a valid URL.",
	    date: "Por favor digite uma data valida.",
	    dateBR: "Por favor digite uma data valida",
	    dateISO: "Por favor digite uma data valida (ISO).",
	    number: "Por favor digite um numero valido.",
	    digits: "Por favor digite somente digitos.",
	    creditcard: "Por favor digite um numero de cartao valido.",
	    equalTo: "Por favor digite o mesmo valor do campo anterior.",
	    accept: "Por favor digite a value with a valid extension.",
	    maxlength: jQuery.validator.format("Por favor enter no more than {0} characteres."),
	    minlength: jQuery.validator.format("Por favor digite mais de {0} characteres."),
	    rangelength: jQuery.validator.format("Por favor enter a value between {0} and {1} characters long."),
	    range: jQuery.validator.format("Por favor enter a value between {0} and {1}."),
	    max: jQuery.validator.format("Por favor enter a value less than or equal to {0}."),
	    min: jQuery.validator.format("Por favor enter a value greater than or equal to {0}."),
	    require_from_group:"Um desses campos é origatório (CPF ou CNPJ).",
	});
	
	// override jquery validate plugin defaults
	$.validator.setDefaults({
	    highlight: function(element) {
	        $(element).closest('.form-group').addClass('has-error');
	    },
	    unhighlight: function(element) {
	        $(element).closest('.form-group').removeClass('has-error');
	    },
	    errorElement: 'span',
	    errorClass: 'help-block',
	    errorPlacement: function(error, element) {
	        if(element.parent('.input-group').length) {
	            error.insertAfter(element.parent());
	        } else {
	            error.insertAfter(element);
	        }
	    }
	});
	
	
	 
	 $('#form-cliente').validate({
		onfocusout: function(element) {
		    $(element).valid();
		},		
	    rules : {
	    	nome_completo: { required: true},
	    	cpfcnpj: { 
	    		minlength: 14,	    	
	    		maxlength: 18
	    		},
       },
		messages:{	
			cpfcnpj: { 
				minlength: "CPF/CNPJ inv&aacute;lido",			
				maxlength: "CPF/CNPJ inv&aacute;lido",
					}
			}       
	});
	 
	 $('#form-promissoria').validate({
			onfocusout: function(element) {
				if ( element.name != "dt_1_venc" && element.name != "dt_emissao" )  {
					$(element).valid();
			    }
			    
			},		
		    rules : {
		    	num_parcelas: { required: true},
		    	dt_1_venc: { required: true},
		    	dt_emissao: { required: true},
		    	valor: { required: true},
		    	prazo_parcelas: { required: true},
		    	local: { required: true},
		    	nomeCredor: { required: true},
		    	cpfcnpjCredor: { 
		    		required: true,		    
		    		minlength: 14,	    	
		    		maxlength: 18
		    		},		    	
		    	nomeDevedor: { required: true},
		    	cpfcnpjDevedor: { 
		    		required: true,
		    		minlength: 14, 
		    		maxlength: 18
		    		},
		    	cep: { required: true},
		    	endereco: { required: true},
		    	numero: { required: true},
		    	bairro: { required: true},
		    	cidade: { required: true},
		    	estado: { required: true},
	       },
			messages:{	
				cpfcnpjCredor: { 
					minlength: "CPF/CNPJ inv&aacute;lido",			
					maxlength: "CPF/CNPJ inv&aacute;lido",
						},
				cpfcnpjDevedor: { 
					minlength: "CPF/CNPJ inv&aacute;lido",			
					maxlength: "CPF/CNPJ inv&aacute;lido",
						}
						
				}
				
		});
	
	
	
	
});

