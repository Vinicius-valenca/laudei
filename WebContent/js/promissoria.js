$(document).ready(function(){
	$('.date').datepicker({
		startDate : "01/01/1900",
		language : "pt-BR"
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
	
	
	
});