$(document).ready(function(){
	var userId=null;
	
	
	$("#userlist").jqGrid({
		url: "../User/getPage.mvc",
        datatype: "json",
        width:800,
        height:500,
        mtype: "GET",
        colNames: ["用户编号", "用户名称", "联系方式", "用户类型", "取暖方式", "小区","楼号", "房屋地址"],
        colModel: [
            { name: "uno", width: 30 },
            { name: "uname", width: 50 },
            { name: "tel", width: 50 },
            { name: "type.tname", width: 20 },
            { name: "qunuan.qufangshi", width: 50 },
            { name: "build.district.dname", width: 30, align: "right" },
            { name: "build.bno", width: 20 },
            { name: "room.roomaddr", width: 50, align: "left" }
        ],
        jsonReader:{
        	id: "uno",
        },
        pager: "#userpager",
        rowNum: 4,
        rowList: [10, 20, 30],
        sortname: "name",
        sortorder: "asc",
        viewrecords: true,
        gridview: true,
        autoencode: true,
        caption: "用户列表",
        multiselect:false,
        onSelectRow:function(id){
        	userId=id;
        }
	});
	
	//增加员工处理
	$("a#useradd").on("click",function(){
		$("div#userdialog").load("../xq_user/add.html",function(){
			
			$("div#userdialog").dialog({
				title: "增加用户",
				width:500,
				height:650
			});
			//取得部门列表，填充部门下拉框选项
			$.getJSON("../Type/getList.mvc",function(data){
				if(data.length>0){
					var options="";
					for(var i=0;i<data.length;i++){
						options=options+"<option value='"+data[i].tno+"'>"+data[i].tname+"</option>"
					}
					$("select[name='type.tno']").html(options);
				}
			});
			$.getJSON("../Room/getList.mvc",function(data){
				if(data.length>0){
					var options="";
					for(var i=0;i<data.length;i++){
						options=options+"<option value='"+data[i].roomno+"'>"+data[i].roomaddr+"</option>"
					}
					$("select[name='room.roomno']").html(options);
				}
			});
			$.getJSON("../qunuan/get/all.mvc",function(data){
				if(data.length>0){
					var options="";
					for(var i=0;i<data.length;i++){
						options=options+"<option value='"+data[i].quid+"'>"+data[i].qufangshi+"</option>"
					}
					$("select[name='qunuan.quid']").html(options);
				}
			});
			$.getJSON("../Build/get/all.mvc",function(data){
				if(data.length>0){
					var options="";
					for(var i=0;i<data.length;i++){
						options=options+"<option value='"+data[i].bno+"'>"+data[i].bno+"</option>"
					}
					$("select[name='build.bno']").html(options);
				}
			});
			
			//验证员工增加表单
			$("form#userAddForm").validate({
				rules:{
					"uno":{
						required: true,
						digits:true
					},
					"uname":{
						required: true
					},					
					"tel":{
						required: true,
						digits:true
					}
				}
			});
			//拦截表单为AJAX提交
			$("form#userAddForm").ajaxForm(function(data){
				if(data.result=="Y"){
					alert("增加用户成功");
				}
				else{
					alert("增加用户失败");
				}
				$("div#userdialog").dialog("close"); //关闭弹出框
				$("div#userdialog").html(""); //清空载入区
				$("table#userlist").jqGrid().trigger("reloadGrid");
				
				
			});
			//取消按钮点击处理
			$("#employeeAddCancelButton").on("click",function(){
				$("div#employeedialog").dialog("close");
				$("div#employeedialog").html("");
				
			});
			
			
			
			
		});
	});
	
	//修改员工处理
	$("a#usermodify").on("click",function(){
		if(userId==null){
			alert("请选择要修改的用户");
		}
		else{
			$("div#userdialog").load("../xq_user/modify.html",function(){
				
				$("div#userdialog").dialog({
					title: "修改用户",
					width:700,
					height:650
				});
				//取得部门列表，填充部门下拉框选项
				$.getJSON("../Type/getList.mvc",function(data){
					if(data.length>0){
						var options="";
						for(var i=0;i<data.length;i++){
							options=options+"<option value='"+data[i].tno+"'>"+data[i].tname+"</option>"
						}
						$("select[name='type.tno']").html(options);
					}
				});
				$.getJSON("../Room/getList.mvc",function(data){
					if(data.length>0){
						var options="";
						for(var i=0;i<data.length;i++){
							options=options+"<option value='"+data[i].roomno+"'>"+data[i].roomaddr+"</option>"
						}
						$("select[name='room.roomno']").html(options);
					}
				});
				$.getJSON("../qunuan/get/all.mvc",function(data){
					if(data.length>0){
						var options="";
						for(var i=0;i<data.length;i++){
							options=options+"<option value='"+data[i].quid+"'>"+data[i].qufangshi+"</option>"
						}
						$("select[name='qunuan.quid']").html(options);
					}
				});
				$.getJSON("../Build/get/all.mvc",function(data){
					if(data.length>0){
						var options="";
						for(var i=0;i<data.length;i++){
							options=options+"<option value='"+data[i].bno+"'>"+data[i].bno+"</option>"
						}
						$("select[name='build.bno']").html(options);
					}
				});
				
				//取得指定的员工信息，并回填修改表单
				$.getJSON("../User/get.mvc",{uno:userId},function(edata){
					
					if(edata!=null){
						$("input[name='uno']").val(edata.uno);
						$("input[name='uname']").val(edata.uname);
						$("input[name='tel']").val(edata.tel);
						$("select[name='room.roomno']").val(edata.room.roomno);
						$("select[name='type.tno']").val(edata.type.tno);
						$("select[name='build.bno']").val(edata.build.bno);
						$("select[name='qunuan.quid']").val(edata.qunuan.quid);
					}
				});
				
				//验证员工增加表单
				$("form#userModifyForm").validate({
					rules:{
						"uno":{
							required: true,
							digits:true
						},
						"uname":{
							required: true
						},					
						"tel":{
							required: true,
							digits:true
						}
					}
				});
				//拦截表单为AJAX提交
				$("form#userModifyForm").ajaxForm(function(data){
					if(data.result=="Y"){
						alert("修改用户成功");
					}
					else{
						alert("修改用户失败");
					}
					$("div#userdialog").dialog("close"); //关闭弹出框
					$("div#userdialog").html(""); //清空载入区
					$("table#userlist").jqGrid().trigger("reloadGrid");
					
					
				});
				$("#employeeModifyCancelButton").on("click",function(){
					$("div#employeedialog").dialog("close");
					$("div#employeedialog").html("");
					
				});
				
				
				
				
			});
		}
	});
	
	//删除员工处理
	$("a#userdelete").on("click",function(){
		if(userId==0){
			alert("请选择");
		}else{
			
				var confirmresult=confirm("确认要删除此用户吗");
				if(confirmresult){
					
					$.getJSON("../User/delete.mvc",{uno:userId},function(data){
						
						if(data.result=="Y"){
						alert("删除成功");
						userId=0;
					}else{
						alert("删除失败");
					}
					
						$("table#userlist").jqGrid().trigger("reloadGrid");
					});
					
				}
			
		}

		
		
	});
	
	//查看员工处理
	$("a#userlist1").on("click",function(){
		if(userId==null){
			alert("请选择要查看的用户");
		}
		else{
			$("div#userdialog").load("../xq_user/view.html",function(){
				
				$("div#userdialog").dialog({
					title: "查看用户",
					width:700,
					height:650
				});
				
				$.getJSON("../User/get.mvc",{uno:userId},function(edata){
					
					if(edata!=null){
						$("span[name='uno']").html(edata.uno);
						$("span[name='uname']").html(edata.uname);
						$("span[name='tel']").html(edata.tel);
						$("span[name='room.roomno']").html(edata.room.roomno);
						$("span[name='type.tno']").html(edata.type.tno);
						$("span[name='build.bno']").html(edata.build.bno);
						$("span[name='qunuan.quid']").html(edata.qunuan.quid);
					}
				});
				
				
				
				
				
				
			});
		}
	});
	
	
	
	
});