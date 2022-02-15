

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
	     
    	$("#nome_completo").val(row.nome_completo);
    	$("#email").val(row.email);
    	
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
	
	
		$("#submit-all").click(function() {
		
		
		var form = $( "#my-awesome-dropzone1" );
    		form.validate();    		
    		if(form.valid()){
    			$("#my-awesome-dropzone1").ajaxSubmit({url: 'enviarExame', type: 'post',success: 
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


//"myAwesomeDropzone" is the camelized version of the HTML element's ID
Dropzone.options.myAwesomeDropzone = {
		//autoProcessQueue: false,

		//maxFiles: 1,
	
		timeout:6000
  };


Dropzone.options.myDropzone= {
    url: 'enviarExame',
    autoProcessQueue: false,
    uploadMultiple: false,
    parallelUploads: 1,
    maxFiles: 1,
    addRemoveLinks: true,
    init: function() {
        dzClosure = this; // Makes sure that 'this' is understood inside the functions below.

        // for Dropzone to process the queue (instead of default form behavior):
        document.getElementById("submit-all").addEventListener("click", function(e) {
            // Make sure that the form isn't actually being sent.
            e.preventDefault();
            e.stopPropagation();
            dzClosure.processQueue();
        });

        //send all the form data along with the files:
        this.on("sendingmultiple", function(data, xhr, formData) {
            formData.append("firstname", jQuery("#firstname").val());
            formData.append("lastname", jQuery("#lastname").val());
        });
    }
}




