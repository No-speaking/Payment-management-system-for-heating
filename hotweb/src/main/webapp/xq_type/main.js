$(document).ready(function(){
	var typeId=null;
	
	
	$("#typelist").jqGrid({
		url: "../Type/getPage.mvc",
        datatype: "json",
        width:800,
        height:500,
        mtype: "GET",
        colNames: ["类型编号", "类型名称", "等级", "明细", "备注"],
        colModel: [
            { name: "tno", width: 50 },
            { name: "tname", width: 20 },
            { name: "dengji", width: 20 },
            { name: "mingxi", width: 20 },
            { name: "beizhu", width: 20 }
        ],
        jsonReader:{
        	id: "tno",
        },
        pager: "#typepager",
        rowNum: 4,
        rowList: [10, 20, 30],
        sortname: "name",
        sortorder: "asc",
        viewrecords: true,
        gridview: true,
        autoencode: true,
        caption: "客户类型列表",
        multiselect:false,
        onSelectRow:function(id){
        	typeId=id;
        }
	});
	
	//增加员工处理
	$("a#typeadd").on("click",function(){
		$("div#typedialog").load("../xq_type/add.html",function(){
			
			$("div#typedialog").dialog({
				title: "增加类型",
				width:700,
				height:500
			});
			
			
			//验证员工增加表单
			$("form#typeAddForm").validate({
				rules:{
					"tno":{
						required: true,
						digits:true
					},
					"tname":{
						required: true
					},
					"dengji":{
						required: true
					},
					"mingxi":{
						required: true
					},
					"beizhu":{
						required: true
					}
				}
			});
			//拦截表单为AJAX提交
			$("form#typeAddForm").ajaxForm(function(data){
				if(data.result=="Y"){
					alert("增加类型成功");
				}
				else{
					alert("增加类型失败");
				}
				$("div#typedialog").dialog("close"); //关闭弹出框
				$("div#typedialog").html(""); //清空载入区
				$("table#typelist").jqGrid().trigger("reloadGrid");
				
				
			});
			//取消按钮点击处理
			$("#employeeAddCancelButton").on("click",function(){
				$("div#employeedialog").dialog("close");
				$("div#employeedialog").html("");
				
			});
			
			
			
			
		});
	});
	
	//修改员工处理
	$("a#typemodify").on("click",function(){
		if(typeId==null){
			alert("请选择要修改的类型");
		}
		else{
			$("div#typedialog").load("../xq_type/modify.html",function(){
				
				$("div#typedialog").dialog({
					title: "修改类型",
					width:700,
					height:500
				});
				
				
				//取得指定的员工信息，并回填修改表单
				$.getJSON("../Type/get.mvc",{tno:typeId},function(edata){
					
					if(edata!=null){
						$("input[name='tno']").val(edata.tno);
						$("input[name='tname']").val(edata.tname);
						$("input[name='dengji']").val(edata.dengji);
						$("input[name='mingxi']").val(edata.mingxi);
						$("input[name='beizhu']").val(edata.beizhu);
						
					}
				});
				
				//验证员工增加表单
				$("form#typeModifyForm").validate({
					rules:{
						"tno":{
							required: true,
							digits:true
						},
						"tname":{
							required: true
						},
						"dengji":{
							required: true
						},
						"mingxi":{
							required: true
						},
						"beizhu":{
							required: true
						}
					}
				});
				//拦截表单为AJAX提交
				$("form#typeModifyForm").ajaxForm(function(data){
					if(data.result=="Y"){
						alert("修改类型成功");
					}
					else{
						alert("修改类型失败");
					}
					$("div#typedialog").dialog("close"); //关闭弹出框
					$("div#typedialog").html(""); //清空载入区
					$("table#typelist").jqGrid().trigger("reloadGrid");
					
					
				});
				$("#employeeModifyCancelButton").on("click",function(){
					$("div#employeedialog").dialog("close");
					$("div#employeedialog").html("");
					
				});
				
				
				
				
			});
		}
	});
	
	//删除员工处理
	$("a#typedelete").on("click",function(){
		if(typeId==null){
			alert("请选择");
		}else{
			
				var confirmresult=confirm("确认要删除此类型吗");
				if(confirmresult){
					
					$.getJSON("../Type/delete.mvc",{tno:typeId},function(data){
						
						if(data.result=="Y"){
						alert("删除成功");
						typeId=0;
					}else{
						alert("删除失败");
					}
					
						$("table#typelist").jqGrid().trigger("reloadGrid");
					});
					
				}
			
		}

		
		
	});
	
	//查看员工处理
	$("a#typelist1").on("click",function(){
		if(typeId==null){
			alert("请选择要查看的类型");
		}
		else{
			$("div#typedialog").load("../xq_type/view.html",function(){
				
				$("div#typedialog").dialog({
					title: "查看类型",
					width:700,
					height:650
				});
				
				$.getJSON("../Type/get.mvc",{tno:typeId},function(edata){
					
					if(edata!=null){
						$("span[name='tno']").html(edata.tno);
						$("span[name='tname']").html(edata.tname);
						$("span[name='dengji']").html(edata.dengji);
						$("span[name='mingxi']").html(edata.mingxi);
						$("span[name='beizhu']").html(edata.beizhu);
					}
				});
				
				
				
				
				
				
			});
		}
	});
	
	
	
	
});