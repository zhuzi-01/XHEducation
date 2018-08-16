$(function(){
	$(window).scroll(function(){
		if($(this).scrollTop()>=250){
			$(".ql_webnav").addClass("ps-f");

		}else{
			$(".ql_webnav").removeClass("ps-f");

		}
	})
	//alert(123);
	$(".pl_btn_down").click( function () {
		$(this).toggleClass("dsblock dsbnone");
		$(this).siblings(".pl_btn_up").toggleClass("dsbnone dsblock");
		$(this).parent("p").toggleClass("hg-44");
	});
	$(".pl_btn_up").click( function () {
		$(this).toggleClass("dsblock dsbnone");
		$(this).siblings(".pl_btn_down").toggleClass("dsbnone");
		$(this).parent("p").toggleClass("hg-44");
	});
})