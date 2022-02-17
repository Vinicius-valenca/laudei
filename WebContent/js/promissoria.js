

$(document).ready(function(){
	
	
	var groups_array = [];

	$.getJSON('SolicitanteServlet', function (data) {
	//console.log(data);
	    $.each(data, function (index) {
	    var newOption = new Option(data[index].nome_completo, data[index].crm, false, false);
	     $('#solicitante').append(newOption).trigger('change');
	       
	    });
	    
	});
	
	$(document).on('keyup', '.select2-search__field', function(e){
	
    e.target.value = e.target.value.toUpperCase()
    $(".select2-results__option--highlighte").val(e.target.value.toUpperCase());
});



	
	$(".js-example-tags").select2({
		  tags: true
		});

	$('.js-example-tags').on('select2:select', function (e) {
		  if(/^\d+$/.test($('#solicitante').select2('data')[0]['id'])){
		   $("#crm").val($('#solicitante').select2('data')[0]['id'])
		  }else{
		   $("#crm").val('')
		   $("#crm").attr("readonly", false); 
		  }
		  
		 
		  
		});

	$('.date').datepicker({
		startDate : "01/01/1900",
		language : "pt-BR"
	});
	


    $('#table_pacientes').on('check.bs.table', function (e, row) {
    	$("#pacid").val(row.id);
    	 
    	$("#nome_completo").val(row.nome_completo);
    	$("#email").val(row.email);
    	$("#cpf").val(row.cpf);
    	$("input[name=sexo][value=" + row.sexo + "]").attr('checked', 'checked');
    	$("#celular").val(row.celular);
    	$("#dtnascimento").val(row.dtnascimento);
    	$("#peso").val(row.peso);
    	$("#altura").val(row.altura);
    	$("#dtexame").val(row.dtexame);
	        	console.log (row);
	        
	     
	   });
    
    function stateFormatter(value, row, index) {
        if (value == 1) {
          return {
            checked: true
          };
        } else {
          return {
            checked: false
          };
        }
        return value;
      }
    
    
   
	
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
	
	
});

function showDiv(divId, element)
{
	
	if($("#tpperfil").val()==4){
		document.getElementById("hidden_div1").style.display = element.value != 0 ? 'block' : 'none';
	    $("#tpexame").val(element.value);
	}else{
		document.getElementById("hidden_div").style.display = element.value != 0 ? 'block' : 'none';
	    $("#tpexame").val(element.value);
	}
    
   
}



Dropzone.options.myAwesomeDropzone = {
		
		timeout:6000
  };


Dropzone.options.myDropzone= {
    url: 'enviarExame',
    autoProcessQueue: false,
    uploadMultiple: true,
    parallelUploads: 1,
    maxFiles: 1,
    addRemoveLinks: true,
    init: function() {
        dzClosure = this; 

        

        //send all the form data along with the files:
        this.on("sendingmultiple", function(data, xhr, formData) {

            formData.append("solicitante", jQuery("#solicitante").val());
            
            formData.append("pacid", jQuery("#pacid").val());
            
            formData.append("nome_completo", jQuery("#nome_completo").val());
            formData.append("email", jQuery("#email").val());
            formData.append("cpf", jQuery("#cpf").val());
            formData.append("sexo", jQuery("#sexo").val());
            formData.append("celular", jQuery("#celular").val());
            formData.append("dtnascimento", jQuery("#dtnascimento").val());
            formData.append("peso", jQuery("#peso").val());
            formData.append("altura", jQuery("#altura").val());
            formData.append("dtexame", jQuery("#dtexame").val());
            formData.append("solicitante", jQuery("#solicitante").val());
            formData.append("empresa", jQuery("#empresa").val());
            formData.append("indicacao", jQuery("#indicacao").val());

        
        });
        

        document.getElementById("submit-all").addEventListener("click", function(e) {
            e.preventDefault();
            e.stopPropagation();
            dzClosure.processQueue();
        });
    }
}




