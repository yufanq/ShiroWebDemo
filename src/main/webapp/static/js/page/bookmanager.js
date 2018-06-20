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
						"</span><span class='arrowdrop' onclick='addE(this)'></span><span onclick='modChapter(this)' >"+data[i].cName+
						"</span></div><div class='details'><ul class='recent_list'>";
					var k = data[i].kldpoints; // 章节所对应的知识点
					for(var j in k) {
						if(k[j].pId != null){
						var e = "<li class='settings'><div class='msg'><a href='javascript:void(0)'>"+k[j].pName+
						"</a>"+ k[j].pContent+"</div></li>";
						element += e;
						} else{
							var e = "<li class='settings'><div class='msg'><a href='javascript:void(0)'>无</a>知识点</div></li>";
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
/**
 * 显示知识点
 * @param id
 */
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
/**
 *  进入章节信息修改
 * @param id
 */
function modChapter(id){
	var span = $(id);
	var d = span.prev();
	var v = span[0].innerText;
	span.remove();
	var text = "<input  value='"+v+"'/><br ><a  href='javascript:void(0)' onclick='updateChapter(this)' >修改 </a>";
	d.after(text);
	
}
/**
 * 更新 章节
 * @param b
 */
function updateChapter(b){
	var btn = $(b);
	var text = btn.prev().prev().val(); // 修改后的文本
	var cNumber = btn.prev().prev().prev().prev()[0].innerText; // id
	var cId = btn.prev().prev().prev().prev().prev().val(); // id
	console.log(cId);	console.log(cNumber);
	var chapter = {
			"cId":cId,
			"cNumber":cNumber,
			"cName":text
		}
	console.log(chapter);
	$.ajax({
		type:"post",
		url:"chapter/"+cId+"/updateChapter",
		dataType:"json",
		data:"chapterString="+JSON.stringify(chapter),
		success:function(result){
			if(result == 1){
				var span = btn.prev().prev().prev(); // 下拉列表
				btn.prev().prev().remove();
				btn.prev().remove();
				btn.remove();
				var s = "<span onclick='modChapter(this)' >"+text+"</span>";
				span.after(s); // 追加

				alert("修改成功");
			} else{
				alert("修改失败");
			}
		}
	});
}
/**
 * 进入图书信息修改
 * @param a
 */
function modBook(a){
	var tr = $(a).parent().parent().children();  // 点击的 超链接 所在的行
	var td1 = tr.eq(1);  //  td 书名 
	var td2 = tr.eq(2); //  td 操作
	var input = "<input  value='"+td1.text()+"'/>" 
	var btn = "<a  href='javascript:void(0)' onclick='updateBook(this)' >提交 </a>"
	// 清空原来的 ，追加新的	 
	td1.empty();
	td2.empty();
	td1.append(input);
	td2.append(btn);
	
}
/**
 * 修改图书信息
 * @param a
 */
function updateBook(a){
	// 点击的 超链接 所在的行 
	var tr = $(a).parent().parent().children();  
	var id = tr.eq(0).text();
	var name = tr.eq(1).children().eq(0).val();
	console.log(name);
	// 图书对象
	var book = {
			bId:id,
			bName:name
	}
	$.ajax({
		type:"post",
		url:"book/"+id+"/updateBook",
		dataType:"json",
		data:"bookJson="+JSON.stringify(book),
		success:function(result){
			if(result == 1){
				tr.eq(1).empty().append(name);
				var q = "<a href='javascript:void(0)' onclick='modBook(this)'>修改</a>"+
					"  <a href='javascript:void(0)' onclick='deleteBook(this)'>  删除</a>";
				tr.eq(2).empty().append(q);
			}
		}
	})
}
/**
 * 删除图书信息
 * @param a
 */
function deleteBook(a){
	var tr = $(a).parent().parent().children();  
	var id = tr.eq(0).text();
	console.log(id);
	$.ajax({
		type:"get",
		url:"book/"+id+"/deleteBook",
		success:function(result){
			if(result == 1){
				tr.remove();
			}
		}
	})
}
/**
 * 进入知识点 修改
 * @param a
 */
function modKnowledge(a){
	
}


