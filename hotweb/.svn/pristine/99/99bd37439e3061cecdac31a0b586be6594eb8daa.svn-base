$(document).ready(function(){
	var buildId=null;
	
	
	$("#buildlist").jqGrid({
		url: "../Build/get/allwithpage.mvc",
        datatype: "json",
        width:800,
        height:500,
        mtype: "GET",
        colNames: ["楼号", "备注", "小区名"],
        colModel: [
            { name: "bno", width: 50 },
            { name: "bcontent", width: 20 },
            { name: "district.dname", width: 50, align: "right" }
           
        ],
        jsonReader:{
        	id: "bno",
        },
        pager: "#buildpager",
        rowNum: 10,
        rowList: [10, 20, 30],
        sortname: "name",
        sortorder: "asc",
        viewrecords: true,
        gridview: true,
        autoencode: true,
        caption: "楼群列表",
        multiselect:false,
        onSelectRow:function(id){
        	buildId=id;
        }
	});
	
	//增加员工处理
	$("a#buildadd").on("click",function(){
		$("div#builddialog").load("../yg_build/add.html",function(){
			
			$("div#builddialog").dialog({
				title: "增加楼号",
				width:700,
				height:500
			});
			//取得部门列表，填充部门下拉框选项
			$.getJSON("../District/getList.mvc",function(data){
				if(data.length>0){
					var options="";
					for(var i=0;i<data.length;i++){
						options=options+"<option value='"+data[i].dno+"'>"+data[i].dname+"</option>"
					}
					$("select[name='district.dno']").html(options);
				}
			});
			
			//验证员工增加表单
			$("form#buildAddForm").validate({
				rules:{
					"bno":{
						required: true,
						digits:true
					},
					"bcontent":{
						required: true
					}				
					
				}
			});
			//拦截表单为AJAX提交
			$("form#buildAddForm").ajaxForm(function(data){
				if(data.result=="Y"){
					alert("增加成功");
				}
				else{
					alert("增加失败");
				}
				$("div#builddialog").dialog("close"); //关闭弹出框
				$("div#builddialog").html(""); //清空载入区
				$("table#buildlist").jqGrid().trigger("reloadGrid");
				
				
			});
			//取消按钮点击处理
			$("#employeeAddCancelButton").on("click",function(){
				$("div#employeedialog").dialog("close");
				$("div#employeedialog").html("");
				
			});
			
			
			
			
		});
	});
	
	//修改员工处理
	$("a#buildmodify").on("click",function(){
		if(buildId==null){
			alert("请选择");
		}
		else{
			$("div#builddialog").load("../yg_build/modify.html",function(){
				
				$("div#builddialog").dialog({
					title: "修改",
					width:700,
					height:500
				});
				//取得部门列表，填充部门下拉框选项
				$.getJSON("../District/getList.mvc",function(data){
					if(data.length>0){
						var options="";
						for(var i=0;i<data.length;i++){
							options=options+"<option value='"+data[i].dno+"'>"+data[i].dname+"</option>"
						}
						$("select[name='district.dno']").html(options);
					}
				});
				
				//取得指定的员工信息，并回填修改表单
				$.getJSON("../Build/get.mvc",{bno:buildId},function(edata){
					
					if(edata!=null){
						$("input[name='bno']").val(edata.bno);
						$("input[name='bcontent']").val(edata.bcontent);
						
				$("select[name='district.dno']").val(edata.district.dno);
					}
				});
				
				//验证员工增加表单
				$("form#buildModifyForm").validate({
					rules:{
						"bno":{
							required: true,
							digits:true
						},
						"bcontent":{
							required: true
						}				
						
					}
				});
				//拦截表单为AJAX提交
				$("form#buildModifyForm").ajaxForm(function(data){
					if(data.result=="Y"){
						alert("修改成功");
					}
					else{
						alert("修改失败");
					}
					$("div#builddialog").dialog("close"); //关闭弹出框
					$("div#builddialog").html(""); //清空载入区
					$("table#buildlist").jqGrid().trigger("reloadGrid");
					
					
				});
				$("#employeeModifyCancelButton").on("click",function(){
					$("div#employeedialog").dialog("close");
					$("div#employeedialog").html("");
					
				});
				
				
				
				
			});
		}
	});
	
	//删除员工处理
	$("a#builddelete").on("click",function(){
		if(buildId==0){
			alert("请选择");
		}else{
			
				var confirmresult=confirm("确认要删除吗");
				if(confirmresult){
					
					$.getJSON("../Build/delete.mvc",{bno:buildId},function(data){
						
						if(data.result=="Y"){
						alert("删除成功");
						buildId=0;
					}else{
						alert("删除失败");
					}
					
						$("table#buildlist").jqGrid().trigger("reloadGrid");
					});
					
				}
			
		}

		
		
	});
	
	//查看员工处理
	   $("a#buildlist1").on("click",function(){
		if(buildId==null){
			alert("请选择要查看的用户");
		}
		else{
			$("div#builddialog").load("../yg_build/view.html",function(){
				
				$("div#builddialog").dialog({
					title: "查看楼群",
					width:700,
					height:650
		
	});
	
        $.getJSON("../Build/get.mvc",{bno:buildId},function(edata){
					
					if(edata!=null){
						$("span[name='bno']").html(edata.bno);
						$("span[name='bcontent']").html(edata.bcontent);
					    $("span[name='district.dno']").html(edata.district.dname);
					}	
				});
		});
			}
		});
		
		
		
		
	});
	
	
