$(function(){
		///// SELECT WITH SEARCH /////  
//									整合 chosen 跟 change
	jQuery(".chzn-select").chosen().on("change", function (evt, params) {
		console.log($(this).val());
		var id = $(this).val();
		$.ajax({
			type:"get",
			url:"specialty/"+id+"/selectSpecialtyBook",
			success:function(result){
				console.log(result);
				var data = JSON.parse(result);
				// 
				var sel1 = $('#dualselect select:first-child');		//get first select element
				var sel2 = $('#dualselect select:last-child');			//get second select element
				console.log(sel1);
				console.log(sel2);
				sel1.empty();
				sel2.empty();

			
				var list = data.noBelongtoBeanList;
				// 不属于 管理员的角色
				for ( var i in list) {

					console.log(list[i]);
					var op = "<option value='"+list[i].bId+"'>"+list[i].bName+"</option>"
					sel1.append(op);
					
				}
				list = data.belongtoBeanList;
				// 管理员 角色
				for ( var i in list) {

					var op = "<option value='"+list[i].bId+"'>"+list[i].bName+"</option>"
					sel2.append(op);
				}
			}
		});
	});
		/**
		 * 专业对应图书 提交
		 */
	$('#accreditButton').click(function (){
		console.log($("#specialySelect").val());
		console.log($("#belongSelect").map(function(){
		     return $(this).val();
		 }).get().join(","))
	});
	
})
/**
 * 进入 专业信息修改
 * @param id
 */
function modSpecialty(id){
	// 专业名称
	var text = $(id).parent().prev().text();
	// 清除 专业名称 的 标签
	var td1 = $(id).parent().empty();
	var td2 = td1.prev().empty();
	// 准备 需要 增加的心标签
	var input ="<input  value='"+text+"'/>";
	var a = "<a  href='javascript:void(0)' onclick='updateSpecialty(this)' >修改 </a>";
	// 追加元素
	td1.append(a);
	td2.append(input);
	
}
/**
 *  修改 专业信息
 * @param id
 */
function updateSpecialty(a){
	// 专业 id
	var id = $(a).parent().prev().prev().text();
	// 专业 名称
	var name = $(a).parent().prev().children().eq(0).val();
	console.log(name);
	$.ajax({
		type:"POST",
		url:"specialty/"+id+"/updateSpecialty",
		data:"name="+name,
		success:function(result){
			$(a).parent().prev().text(name);
			$(a).parent().empty().append("<a href='javascript:void(0)' onclick='modSpecialty(this)' >修改</a>  <a href='specialty/"+id+"/deleteSpecialty'>删除</a>")
			$("#msg").text("修改成功");
		}
	})	
}
