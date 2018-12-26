
function modQuestionType(a){
	// 超链接所在 td
	var aTd = $(a).parent();
	// 分值所在 td
	var vTd = aTd.prev();
	// 类型名称所在 td
	var nTd = vTd.prev();
	
	var value = vTd.text();
	var name = nTd.text();
	var nameInput = "<input  value='"+name+"'/>";
	var valueInput = "<input value='"+value+"'/>";
	var aBtn = "<a href='javascript:void(0)' onclick='updateQUestionTYpe(this)'>更新</a>"
	vTd.empty().append(valueInput);
	nTd.empty().append(nameInput);
	aTd.empty().append(aBtn);
	
}
function updateQUestionTYpe(a){
	// 超链接所在 td
	var aTd = $(a).parent();
	// 分值所在 td
	var vTd = aTd.prev();
	// 类型名称所在 td
	var nTd = vTd.prev();
	// id 所在 td
	var iTd = nTd.prev();
	// 取得 参数
	var value = vTd.children().eq(0).val();
	var name = nTd.children().eq(0).val();
	var id =  iTd.text();
	var Questype = {
			tId:id,
			tName:name,
			tValue:value
	}
	$.ajax({
		type:"post",
		url:"questiontype/"+id+"/updateQuestionType",
		dataType:"json",
		data:"questionTypeJson="+JSON.stringify(Questype),
		success:function(result){
			if(result == 1){
				vTd.empty().text(value);
				nTd.empty().text(name);
				aTd.empty().append("<a href='javascript:void(0)' onclick='modQuestionType(this)'>修改</a>  <a href='questiontype/"+id+"/deleteQuestionType'>删除</a>");
			} else {
				
			}
		}
		
	})

}