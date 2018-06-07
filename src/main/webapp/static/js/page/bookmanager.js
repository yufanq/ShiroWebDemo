$(function(){


	///// SELECT WITH SEARCH /////  
//									整合 chosen 跟 change
	jQuery(".chzn-select").chosen().on("change", function (evt, params) {
		var ul = $('#sortable2');
		var id = $(this).val(); // 选中图书id
		
		$.ajax({
			type:"get",
			url:"chapter/"+id+"/selectBookChapter",
			success:function(result){
				console.log(result);
				// 列表数据
				var data = JSON.parse(result);
				
				ul.empty();
				for ( var i in data) {
					
					var element = "<li><div class='label'><span class='moveicon'>"+data[i].cNumber+
						"</span><span class='arrowdrop' onclick='addE(this)'></span>"+data[i].cName+
						"</div><div class='details'><ul class='recent_list'>";
					var k = data[i].kldpoints; // 章节所对应的知识点
					for(var j in k) {
						if(k[j].pId != null){
						var e = "<li class='settings'><div class='msg'><a href=''>"+k[j].pName+
						"</a>"+ k[j].pContent+"</div></li>";
						element += e;
						} else{
							var e = "<li class='settings'><div class='msg'><a href=''>无</a>知识点</div></li>";
							element += e;
						}
					}
					element += "</ul></div></li>";
					ul.append(element);
				}
				
				

			}
		});
	});

})
function addE(id){
	var t = jQuery(id);
	var det = t.parents('li').find('.details');
	if(!det.is(':visible')) {
		det.slideDown();
		t.addClass('arrowup');
	} else {
		det.slideUp();
		t.removeClass('arrowup');
	}
}

function modChapter(id){
	var span = $(id);
	var d = span.prev();
	var v = span[0].innerText;
	span.remove();
	var text = "<input  value='"+v+"'/><br ><a  href='javascript:void(0)' onclick='updateChapter(this)' >修改 </a>";
	d.after(text);
	
}
function updateChapter(b){
	var btn = $(b);
	var text = btn.prev().prev().val(); // 修改后的文本
	var cNumber = btn.prev().prev().prev().prev()[0].innerText; // id
	var cId = btn.prev().prev().prev().prev().prev().val(); // id
	console.log(cId);	console.log(cNumber);
	var chapter = {
			cId:cId,
			bId:null,
			cNumber:cNumber,
			cName:text,
			kldpoints:null
		}
	console.log(chapter);
	$.ajax({
		type:"post",
		url:"chapter/"+cId+"/updateChapter",
		data:"chapterJson="+chapter,
		success:function(result){
			
		}
	});

}