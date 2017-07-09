$(document).ready(function(){
	var employeeId=null;
	
	
	$("#employeelist").jqGrid({
		url: "../Employee/getPage.mvc",
        datatype: "json",
        width:800,
        height:500,
        mtype: "GET",
        colNames: ["员工编号", "权限名称", "员工姓名", "员工密码"],
        colModel: [
            { name: "eno", width: 50 },
            { name: "identity.idname", width: 20 },
            { name: "ename", width: 50 },
            { name: "epassword", width: 80, align: "left" }
        ],
        jsonReader:{
        	id: "eno",
        },
        pager: "#employeepager",
        rowNum: 4,
        rowList: [10, 20, 30],
        sortname: "name",
        sortorder: "asc",
        viewrecords: true,
        gridview: true,
        autoencode: true,
        caption: "员工列表",
        multiselect:false,
        onSelectRow:function(id){
        	employeeId=id;
        }
	});
	
	//增加员工处理
	$("a#employeeadd").on("click",function(){
		$("div#employeedialog").load("../dx_employee/add.html",function(){
			
			$("div#employeedialog").dialog({
				title: "增加员工",
				width:700,
				height:500
			});
			//取得权限列表，填充权限下拉框选项
			$.getJSON("../Identity/get/all.mvc",function(data){
				if(data.length>0){
					var options="";
					for(var i=0;i<data.length;i++){
						options=options+"<option value='"+data[i].idname+"'>"+data[i].idname+"</option>"
					}
					$("select[name='identity.idname']").html(options);
				}
			});
			
			//验证员工增加表单
			$("form#employeeAddForm").validate({
				rules:{
					"eno":{
						required: true
					},
					"ename":{
						required: true
					},					
					"epassword":{
						required: true
					}
				}
			});
			//拦截表单为AJAX提交
			$("form#employeeAddForm").ajaxForm(function(data){
				if(data.result=="Y"){
					alert("增加员工成功");
				}
				else{
					alert("增加员工失败");
				}
				$("div#employeedialog").dialog("close"); //关闭弹出框
				$("div#employeedialog").html(""); //清空载入区
				$("table#employeelist").jqGrid().trigger("reloadGrid");
				
				
			});
			//取消按钮点击处理
			$("#employeeAddCancelButton").on("click",function(){
				$("div#employeedialog").dialog("close");
				$("div#employeedialog").html("");
				
			});
			
			
			
			
		});
	});
	
	//修改员工处理
	$("a#employeemodify").on("click",function(){
		if(employeeId==null){
			alert("请选择要修改的员工");
		}
		else{
			$("div#employeedialog").load("../dx_employee/modify.html",function(){
				
				$("div#employeedialog").dialog({
					title: "修改员工",
					width:700,
					height:500
				});
				//取得部门列表，填充部门下拉框选项
				$.getJSON("../Identity/get/all.mvc",function(data){
					if(data.length>0){
						var options="";
						for(var i=0;i<data.length;i++){
							options=options+"<option value='"+data[i].idname+"'>"+data[i].idname+"</option>"
						}
						$("select[name='identity.idname']").html(options);
					}
				});
				//取得指定的员工信息，并回填修改表单
				$.getJSON("../Employee/get.mvc",{eno:employeeId},function(edata){
					
					if(edata!=null){
						$("input[name='eno']").val(edata.eno);
						$("input[name='ename']").val(edata.ename);
						$("input[name='epassword']").val(edata.epassword);
						$("select[name='identity.idname']").val(edata.identity.idname);
					}
				});
				//验证员工增加表单
				$("form#employeeModifyForm").validate({
					rules:{
						"eno":{
							required: true
						},
						"ename":{
							required: true
						},					
						"epassword":{
							required: true
						}
					}
				});
				//拦截表单为AJAX提交
				$("form#employeeModifyForm").ajaxForm(function(data){
					if(data.result=="Y"){
						alert("修改员工成功");
					}
					else{
						alert("修改员工失败");
					}
					$("div#employeedialog").dialog("close"); //关闭弹出框
					$("div#employeedialog").html(""); //清空载入区
					$("table#employeelist").jqGrid().trigger("reloadGrid");
					
					
				});
				$("#employeeModifyCancelButton").on("click",function(){
					$("div#employeedialog").dialog("close");
					$("div#employeedialog").html("");
					
				});
				
				
				
				
			});
		}
	});
	
	//删除员工处理
	$("a#employeedelete").on("click",function(){
		if(employeeId==0){
			alert("请选择");
		}else{
			
				var confirmresult=confirm("确认要删除此员工吗");
				if(confirmresult){
					
					$.getJSON("../Employee/delete.mvc",{eno:employeeId},function(data){
						
						if(data.result=="Y"){
						alert("删除成功");
						employeeId=0;
					}else{
						alert("删除失败");
					}
					
						$("table#employeelist").jqGrid().trigger("reloadGrid");
					});
					
				}
			
		}

		
		
	});
	
	//查看员工处理
	$("a#employeelist1").on("click",function(){
		if(employeeId==null){
			alert("请选择要查看的员工");
		}
		else{
			$("div#employeedialog").load("../dx_employee/view.html",function(){
				
				$("div#employeedialog").dialog({
					title: "查看员工",
					width:700,
					height:650
				});
				
				$.getJSON("../Employee/get.mvc",{eno:employeeId},function(edata){
					
					if(edata!=null){
						$("span[name='eno']").html(edata.eno);
						$("span[name='ename']").html(edata.ename);
						$("span[name='epassword']").html(edata.epassword);
						$("span[name='identity.idname']").html(edata.identity.idname);
					}
				});
				
				
			
				
			});
		}
	});
	
});