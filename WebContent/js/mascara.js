	$(document).ready(function() {
		$('.cep').mask('00000-000');
		$('.telefone').mask('(00) 0000-0000');
		$('.celular').mask('(00) 00000-0000');
		$('.cpf').mask('000.000.000-00');
		
		$('.format_data').mask('00/00/0000');
		
        $("#valor").maskMoney({thousands:'.', decimal:',', allowZero:true});
       
	});
	
	
	 
	
	