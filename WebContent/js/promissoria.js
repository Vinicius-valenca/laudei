$(document).ready(function(){
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
    
   if (representantes.indexOf(row.id) !== -1) {
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
    document.getElementById(divId).style.display = element.value != 0 ? 'block' : 'none';
    $("#tpexame").val(element.value);
   
}


//"myAwesomeDropzone" is the camelized version of the HTML element's ID
Dropzone.options.myAwesomeDropzone = {
		timeout:6000
  };
