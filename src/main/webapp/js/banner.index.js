﻿/**

 * jQuery jslides 1.1.0
 */

$(function(){
	var numpic = $("#slides li").size()-1;
	var nownow = 0;
	var inout = 0;
	var TT = 0;
	var SPEED = 5000;
	$('#slides li').eq(0).siblings('li').css({'display':'none'});
	var ulstart = '<ul id="pagination">',
		ulcontent = '',
		ulend = '</ul>';
	ADDLI();
	var pagination = $('#pagination li');
	var paginationwidth = $('#pagination').width();
	$('#pagination').css('margin-left',(0-paginationwidth/2))
	pagination.eq(0).addClass('current')
	function ADDLI(){
		//var lilicount = numpic + 1;
		for(var i = 0; i <= numpic; i++){
			ulcontent += '<li class="bg_icon">' + '<a href="javascript:void(0)">' + (i+1) + '</a>' + '</li>';
		}
		$('#slides').after(ulstart + ulcontent + ulend);	
	}
	pagination.on('click',DOTCHANGE)
	function DOTCHANGE(){
		var changenow = $(this).index();
		$('#slides li').eq(nownow).css('z-index','900');

		$('#slides li').eq(changenow).css({'z-index':'800'}).show();
		pagination.eq(changenow).addClass('current').siblings('li').removeClass('current');
		$('#slides li').eq(nownow).fadeOut(400,function(){$('#slides li').eq(changenow).fadeIn(500);});
		nownow = changenow;
	}
	pagination.mouseenter(function(){
		inout = 1;
	})
	pagination.mouseleave(function(){
		inout = 0;
	})
	function GOGO(){
		var NN = nownow+1;
		if( inout == 1 ){
			} else {
			if(nownow < numpic){
			$('#slides li').eq(nownow).css('z-index','900');
			$('#slides li').eq(NN).css({'z-index':'800'}).show();
			pagination.eq(NN).addClass('current').siblings('li').removeClass('current');
			$('#slides li').eq(nownow).fadeOut(400,function(){$('#slides li').eq(NN).fadeIn(500);});
			nownow += 1;
		}else{
			NN = 0;
			$('#slides li').eq(nownow).css('z-index','900');
			$('#slides li').eq(NN).stop(true,true).css({'z-index':'800'}).show();
			$('#slides li').eq(nownow).fadeOut(400,function(){$('#slides li').eq(0).fadeIn(500);});
			pagination.eq(NN).addClass('current').siblings('li').removeClass('current');
			nownow=0;
			}
		}
		TT = setTimeout(GOGO, SPEED);
	}
	TT = setTimeout(GOGO, SPEED); 
})