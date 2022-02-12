$(document).ready(function(){
	
	
	var lastResults = [];

	
	$('#tags').select2({
	    width: '100%',
	    allowClear: true,
	    multiple: true,
	    maximumSelectionSize: 1,
	    placeholder: "Start typing",
	    data: [
	            { id: 1, text: "Nikhilesh"},
	            { id: 2, text: "Raju"    }
	          ]    
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

//"myAwesomeDropzone" is the camelized version of the HTML element's ID
Dropzone.options.myAwesomeDropzone1 = {
		autoProcessQueue: false,

		maxFiles: 1,
	
		timeout:6000
  };
