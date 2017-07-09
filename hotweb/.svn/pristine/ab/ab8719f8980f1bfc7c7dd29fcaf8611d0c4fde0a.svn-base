$(document).ready(function(){
	var wxxxId=null;
	
	
	$("#wxxxlist").jqGrid({
		url: "../Wxxx/getPage.mvc",
        datatype: "json",
        width:800,
        height:500,
        mtype: "GET",
        colNames: ["维修编号", "问题描述", "提交时间", "维修人员人数","维修地点"],
        colModel: [
            { name: "wno", width: 50 },
            { name: "wtms", width: 20 },
            { name: "tdate", width: 50 },
            { name: "wnumber", width: 80, align: "left" },
            { name: "waddr", width: 50 }
           
        ],
        jsonReader:{
        	id: "wno",
        },
        pager: "#wxxxpager",
        rowNum: 5,
        rowList: [10, 20, 30],
        sortname: "name",
        sortorder: "asc",
        viewrecords: true,
        gridview: true,
        autoencode: true,
        caption: "维修信息列表",
        multiselect:false,
        onSelectRow:function(id){
        	wxxxId=id;
        }
	});
	
	//增加维修信息处理
	$("a#wxxxadd").on("click",function(){
		$("div#wxxxdialog").load("../dx_wxxx/add.html",function(){
			
			$("div#wxxxdialog").dialog({
				title: "增加维修信息",
				width:700,
				height:500
			});
		
						//验证员工增加表单
			$("form#wxxxAddForm").validate({
				rules:{
					"wno":{
						required: true
					},
					"wtms":{
						required: true
					},
					"tdate":{
						required: true
					},
					"wnumber":{
						required: true
					},
					"waddr":{
						required: true
					}
					
				}
			});
			
			//拦截表单为AJAX提交
			$("form#wxxxAddForm").ajaxForm(function(data){
				if(data.result=="Y"){
					alert("增加维修信息成功");
				}
				else{
					alert("增加维修信息失败");
				}
				$("div#wxxxdialog").dialog("close"); //关闭弹出框
				$("div#wxxxdialog").html(""); //清空载入区
				$("table#wxxxlist").jqGrid().trigger("reloadGrid");
				
				
			});
			//取消按钮点击处理
			$("#wxxxAddCancelButton").on("click",function(){
				$("div#wxxxdialog").dialog("close");
				$("div#wxxxdialog").html("");
				
			});
			
			
			
			
		});
	});
	
	//修改员工处理
	$("a#wxxxmodify").on("click",function(){
		if(wxxxId==null){
			alert("请选择要修改的维修信息");
		}
		else{
			$("div#wxxxdialog").load("../dx_wxxx/modify.html",function(){
				
				$("div#wxxxdialog").dialog({
					title: "修改维修信息",
					width:700,
					height:500
				});
				

				//取得指定的员工信息，并回填修改表单
				$.getJSON("../Wxxx/get.mvc",{wno:wxxxId},function(edata){
					
					if(edata!=null){
						$("input[name='wno']").val(edata.wno);
						$("input[name='wtms']").val(edata.wtms);
						$("input[name='tdate']").val(edata.tdate);
						$("input[name='wnumber']").val(edata.wnumber);
						$("input[name='waddr']").val(edata.waddr);
					}
				});
				//验证员工增加表单
				$("form#wxxxModifyForm").validate({
					rules:{
						"wno":{
							required: true
						},
						"wtms":{
							required: true
						},	
						"tdate":{
							required: true
						},	
						"wnumber":{
							required: true
						},
						"waddr":{
							required: true
						}
					}
				});
				//拦截表单为AJAX提交
				$("form#wxxxModifyForm").ajaxForm(function(data){
					if(data.result=="Y"){
						alert("修改维修信息成功");
					}
					else{
						alert("修改维修信息失败");
					}
					$("div#wxxxdialog").dialog("close"); //关闭弹出框
					$("div#wxxxdialog").html(""); //清空载入区
					$("table#wxxxlist").jqGrid().trigger("reloadGrid");
					
					
				});
				$("#wxxxModifyCancelButton").on("click",function(){
					$("div#wxxxdialog").dialog("close");
					$("div#wxxxdialog").html("");
					
				});
				
				
				
				
			});
		}
	});
	
	//删除员工处理
	$("a#wxxxdelete").on("click",function(){
		if(wxxxId==0){
			alert("请选择");
		}else{
			
				var confirmresult=confirm("确认要删除此维修信息吗");
				if(confirmresult){
					
					$.getJSON("../Wxxx/delete.mvc",{wno:wxxxId},function(data){
						
						if(data.result=="Y"){
						alert("删除成功");
						wxxxId=0;
					}else{
						alert("删除失败");
					}
					
						$("table#wxxxlist").jqGrid().trigger("reloadGrid");
					});
					
				}
			
		}

		
		
	});
	
	//查看员工处理
	$("a#wxxxlist1").on("click",function(){
		if(wxxxId==null){
			alert("请选择要查看的维修信息");
		}
		else{
			$("div#wxxxdialog").load("../dx_wxxx/view.html",function(){
				
				$("div#wxxxdialog").dialog({
					title: "查看维修信息",
					width:700,
					height:650
				});
				
				$.getJSON("../Wxxx/get.mvc",{wno:wxxxId},function(edata){
					
					if(edata!=null){
						$("span[name='wno']").html(edata.wno);
						$("span[name='wtms']").html(edata.wtms);
						$("span[name='tdate']").html(edata.tdate);
						$("span[name='wnumber']").html(edata.wnumber);
						$("span[name='waddr']").html(edata.waddr);
					}
				});
				
				
			
				
			});
		}
	});
	
	showlist();
	
});