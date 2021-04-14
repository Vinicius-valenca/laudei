<div class="subnavbar">
  <div class="subnavbar-inner">
    <div class="container">
      <ul class="mainnav">
        <li class="nav-links"><a href="agenda.jsp" class="menu"><i class="icon-list-alt"></i><span>Lista</span> </a> </li>
        
         <li class="nav-links"><a href="exame.jsp" class="menu"><i class="icon-money"></i><span>Exame</span> </a> </li>
        
      </ul>
    </div>
    <!-- /container --> 
  </div>
  <!-- /subnavbar-inner --> 
</div>

<script>

$(window).load(function(){
    page=window.location.pathname.split("/").pop();
    menuChildren = $('a[href="' + page + '"]');  
    $(menuChildren).parent('li').addClass('active');
});
</script>