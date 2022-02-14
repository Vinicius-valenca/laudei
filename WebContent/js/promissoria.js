$(document).ready(function(){
	
	
	var groups_array = [];

	$.getJSON('SolicitanteServlet', function (data) {
	    $.each(data, function (index) {
	        groups_array.push({
	            id: data[index].id,
	            text: data[index].email,
	            newOption: false
	        });
	    });
	    // Call val() or select2() method here
	    $(".js-example-tags").select2({data: groups_array});
	});
	
	
	$(".js-example-tags").select2({
		  tags: true
		});

	$('.js-example-tags').on('select2:select', function (e) {
		  alert("entrei")
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
