$(document).ready(function(){
				$(".menu_city li").click(function(){
					$(".menu_city li").removeClass("current");
					$(this).addClass("current");
					$("#content div").hide();
					var name=$(this).attr("id");
					$("#"+name+"_con").show();
				})

    var length = $("#liList").children("li").length - 1;
    $("#chooseNext").on("click",function(){
      var sIndex = $("#liList").children("li.selected").index();
      if(sIndex == length){
          sIndex = -1;
      }
      $("#liList").children().removeClass("selected");
      $("#liList").children("li:eq(" + (sIndex + 1) + " )").addClass("selected");
    })

});