$(function(){
	
///// PAGINATION /////
	jQuery('.pagination').each(function(){
										
		var pa = jQuery(this);
		
		pa.find('a').click(function(){
			var p = jQuery(this).parent();
			if(!p.hasClass('previous') && !p.hasClass('first') && !p.hasClass('next') && !p.hasClass('last')) {
				pa.find('a').each(function(){
					jQuery(this).removeClass('current');
				});
				jQuery(this).addClass('current');
				
				//disable next and last button when active page is the last page
				if(jQuery(this).parent().next().hasClass('next')) {
					pa.find('.next a').addClass('disable');
					pa.find('.last a').addClass('disable');
				} else {
					pa.find('.next a').removeClass('disable');
					pa.find('.last a').removeClass('disable');
				}
				
				//disable first and previous button when active page is the first page
				if(jQuery(this).parent().prev().hasClass('previous')) {
					pa.find('.previous a').addClass('disable');
					pa.find('.first a').addClass('disable');
				} else {
					pa.find('.previous a').removeClass('disable');
					pa.find('.first a').removeClass('disable');
				}
				
			}
			return false;
		});
		
		
		///// CLICKING NEXT BUTTON /////
		pa.find('li.next a').click(function(){
			if(!jQuery(this).hasClass('disable')) {
				if(!jQuery(this).parent().prev().find('a').hasClass('current')) {
					pa.find('a.current').removeClass('current').parent().next().find('a').addClass('current');
				}
			}
			if(pa.find('a.current').parent().next().hasClass('next')) {
				pa.find('.next a').addClass('disable');
				pa.find('.last a').addClass('disable');
			}
			if(!pa.find('a.current').parent().prev().hasClass('previous')) {
				pa.find('.previous a').removeClass('disable');
				pa.find('.first a').removeClass('disable');
			}
	
		});
		
		
		///// CLICKING PREVIOUS BUTTON /////
		pa.find('li.previous a').click(function(){
			if(!jQuery(this).hasClass('disable')) {
				if(!jQuery(this).parent().next().find('a').hasClass('current')) {
					pa.find('a.current').removeClass('current').parent().prev().find('a').addClass('current');
				}
			}
			if(pa.find('a.current').parent().prev().hasClass('previous')) {
				pa.find('.first a').addClass('disable');
				pa.find('.previous a').addClass('disable');	
			}
			if(!pa.find('a.current').parent().next().hasClass('next')) {
				pa.find('.next a').removeClass('disable');
				pa.find('.last a').removeClass('disable');
			}
	
		});
		
		
		//// CLICKING LAST BUTTON /////
		pa.find('.last a').click(function(){
			jQuery(this).addClass('disable');
			pa.find('.next a').addClass('disable');
			pa.find('.current').removeClass('current');
			pa.find('.next a').parent().prev().find('a').addClass('current');
			pa.find('.first a, .previous a').removeClass('disable');
		});
		
		///// CLICKING FIRST BUTTON /////
		pa.find('.first a').click(function(){
			jQuery(this).addClass('disable');
			pa.find('.previous a').addClass('disable');
			pa.find('.current').removeClass('current');
			pa.find('.previous a').parent().next().find('a').addClass('current');
			pa.find('.last a, .next a').removeClass('disable');
		});

		
		
});