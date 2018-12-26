$(function(){


	///// SELECT WITH SEARCH /////  
//									整合 chosen 跟 change
	jQuery(".chzn-select").chosen().on("change", function (evt, params) {
		console.log($(this).val());
		var id = $(this).val();
		$.ajax({
			type:"get",
			url:"admin/"+id+"/selctAdminRole",
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
					var op = "<option value='"+list[i].rId+"'>"+list[i].rName+"</option>"
					sel1.append(op);
					
				}
				list = data.belongtoBeanList;
				// 管理员 角色
				for ( var i in list) {

					var op = "<option value='"+list[i].rId+"'>"+list[i].rName+"</option>"
					sel2.append(op);
				}
			}
		});
	});

})
/**
 * 进入 Admin 修改
 * @param a
 */
function modAdmin(a){
	
}
/**
 *  修改 Admin
 * @param a
 */
function updateAdmin(a){
	
}


/**
 *  删除
 * @param a
 */
function deleteAdmin(a){
	
}