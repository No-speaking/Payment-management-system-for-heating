$(document).ready(function(){
	var districtId=null;
	
	
	$("#districtlist").jqGrid({
		url: "../District/getPage.mvc",
        datatype: "json",
        width:800,
        height:500,
        mtype: "GET",
        colNames: ["小区编号", "小区名称", "供热点", "小区地址", "物业"],
        colModel: [
            { name: "dno", width: 50 },
            { name: "dname", width: 20 },
            { name: "headport.portname", width: 50, align: "right" },
            { name: "daddr", width: 80, align: "left" },
            { name: "wuye", width: 80, align: "left" }
        ],
        jsonReader:{
        	id: "dno",
        },
        pager: "#districtpager",
        rowNum: 10,
        rowList: [10, 20, 30],
        sortname: "name",
        sortorder: "asc",
        viewrecords: true,
        gridview: true,
        autoencode: true,
        caption: "小区列表",
        multiselect:false,
        onSelectRow:function(id){
        	districtId=id;
        }
	});
	
	//增加员工处理
	$("a#districtadd").on("click",function(){
		$("div#districtdialog").load("../xq_district/add.html",function(){
			
			$("div#districtdialog").dialog({
				title: "增加小区",
				width:700,
				height:500
			});
			//取得部门列表，填充部门下拉框选项
			$.getJSON("../Headport/get/all.mvc",function(data){
				if(data.length>0){
					var options="";
					for(var i=0;i<data.length;i++){
						options=options+"<option value='"+data[i].portno+"'>"+data[i].portname+"</option>"
					}
					$("select[name='headport.portno']").html(options);
				}
			});
			
			//验证员工增加表单
			$("form#districtAddForm").validate({
				rules:{
					"dno":{
						required: true,
						digits:true
					},
					"dname":{
						required: true
					},					
					"daddr":{
						required: true
					},					
					"物业":{
						required: true
					}
				}
			});
			//拦截表单为AJAX提交
			$("form#districtAddForm").ajaxForm(function(data){
				if(data.result=="Y"){
					alert("增加小区成功");
				}
				else{
					alert("增加小区失败");
				}
				$("div#districtdialog").dialog("close"); //关闭弹出框
				$("div#districtdialog").html(""); //清空载入区
				$("table#districtlist").jqGrid().trigger("reloadGrid");
				
				
			});
			//取消按钮点击处理
			$("#employeeAddCancelButton").on("click",function(){
				$("div#employeedialog").dialog("close");
				$("div#employeedialog").html("");
				
			});
			
			
			
			
		});
	});
	
	//修改员工处理
	$("a#districtmodify").on("click",function(){
		if(districtId==null){
			alert("请选择要修改的小区");
		}
		else{
			$("div#districtdialog").load("../xq_district/modify.html",function(){
				
				$("div#districtdialog").dialog({
					title: "修改小区",
					width:700,
					height:500
				});
				//取得部门列表，填充部门下拉框选项
				$.getJSON("../Headport/get/all.mvc",function(data){
					if(data.length>0){
						var options="";
						for(var i=0;i<data.length;i++){
							options=options+"<option value='"+data[i].portno+"'>"+data[i].portname+"</option>"
						}
						$("select[name='headport.portno']").html(options);
					}
				});
				
				//取得指定的员工信息，并回填修改表单
				$.getJSON("../District/get.mvc",{dno:districtId},function(edata){
					
					if(edata!=null){
						$("input[name='dno']").val(edata.dno);
						$("input[name='dname']").val(edata.dname);
						$("input[name='daddr']").val(edata.daddr);
						$("input[name='wuye']").val(edata.daddr);
						$("select[name='headport.portno']").val(edata.headport.portno);
					}
				});
				
				//验证员工增加表单
				$("form#districtModifyForm").validate({
					rules:{
						"dno":{
							required: true,
							digits:true
						},
						"dname":{
							required: true
						},					
						"daddr":{
							required: true
						},					
						"wuye":{
							required: true
						}
					}
				});
				//拦截表单为AJAX提交
				$("form#districtModifyForm").ajaxForm(function(data){
					if(data.result=="Y"){
						alert("修改小区成功");
					}
					else{
						alert("修改小区失败");
					}
					$("div#districtdialog").dialog("close"); //关闭弹出框
					$("div#districtdialog").html(""); //清空载入区
					$("table#districtlist").jqGrid().trigger("reloadGrid");
					
					
				});
				$("#employeeModifyCancelButton").on("click",function(){
					$("div#employeedialog").dialog("close");
					$("div#employeedialog").html("");
					
				});
				
				
				
				
			});
		}
	});
	
	//删除员工处理
	$("a#districtdelete").on("click",function(){
		if(districtId==0){
			alert("请选择");
		}else{
			
				var confirmresult=confirm("确认要删除此小区吗");
				if(confirmresult){
					
					$.getJSON("../District/delete.mvc",{dno:districtId},function(data){
						
						if(data.result=="Y"){
						alert("删除成功");
						districtId=0;
					}else{
						alert("删除失败");
					}
					
						$("table#districtlist").jqGrid().trigger("reloadGrid");
					});
					
				}
			
		}

		
		
	});
	
	//查看员工处理
	$("a#districtlist1").on("click",function(){
		if(districtId==null){
			alert("请选择要查看的小区");
		}
		else{
			$("div#districtdialog").load("../xq_district/view.html",function(){
				
				$("div#districtdialog").dialog({
					title: "查看小区",
					width:700,
					height:500
				});
				
				
				//取得指定的员工信息，并回填修改表单
				$.getJSON("../District/get.mvc",{dno:districtId},function(edata){
					
					if(edata!=null){
						$("span[name='dno']").html(edata.dno);
						$("span[name='dname']").html(edata.dname);
						$("span[name='daddr']").html(edata.daddr);
						$("span[name='wuye']").html(edata.wuye);
						$("span[name='headport.portno']").html(edata.headport.portno);
					}
				});
				
				
				
				
			});
		}
	});
	
	
	
	
});