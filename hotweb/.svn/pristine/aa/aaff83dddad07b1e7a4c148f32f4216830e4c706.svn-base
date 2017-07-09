

$(document).ready(function(){
	var quid=null;

	$("table#qunuanlist").jqGrid({
		url: "../qunuan/get/all/pages.mvc",
        datatype: "json",
        width:800,
        height:500,
        mtype: "GET",
        colNames: ["取暖编号", "收费编号", "取暖方式"],
        colModel: [
            { name: "quid", width: 50 },
            { name: "shoufei.shouid", width: 20 },
            { name: "qufangshi", width: 50, align: "right" },

           
        ],
        jsonReader:{
        	id: "quid",
        },
        pager: "#qunuanpager",
        rowNum: 10,
        rowList: [10, 20, 30],
        sortname: "name",
        sortorder: "asc",
        viewrecords: true,
        gridview: true,
        autoencode: true,
        caption: "取暖列表",
        multiselect:false,
        onSelectRow:function(id){
        	quid=id;
        }
	});



	//增加按钮点击
	$("#qunuanadd").on("click",function(){
		$("div#addqunuan").load("../zmm_qunuan/addqunuan.html",function(){
			$("div#addqunuan").dialog({
				
				title:"增加取暖",
				width:500,
				
			});
			//取得部门列表，填充部门下拉框选项
			$.getJSON("../shoufei/get/all.mvc",function(data){
				if(data.length>0){
					var options="";
					
					for(var i=0;i<data.length;i++){
						options=options+"<option value='"+data[i].shouid+"'>"+data[i].shouid+"</option>"
						
					}
					$("select[name='shoufei.shouid']").html(options);
					
				}
			});
			
			
			$("form#qunuanAddFrom").validate({
				rules:{
					"qufangshi":{
						required: true
					}
					
				}
			});
			
			$("#qunuanAddFrom").ajaxForm(function(data){
				if(data.result=="Y"){
					alert("增加成功");
				}
				else{
					alert("失败");
				}
				$("div#addqunuan").dialog("close"); //关闭弹出框
				$("div#addqunuan").html(""); //清空载入区
				$("table#qunuanlist").jqGrid().trigger("reloadGrid");
				
				
				
			});
		});
		
		
		
	});
	
	
	
	
	//修改按钮点击
	$("a#qunuanmodify").on("click",function(){
		if(quid==null){
			alert("选择类型");
		}
		else{
			
		$("div#addqunuan").load("../zmm_qunuan/modifyqunuan.html",function(){
			$("div#addqunuan").dialog({
				
				title:"修改取暖",
				width:500,
				
			});
			//取得部门列表，填充部门下拉框选项
			$.getJSON("../shoufei/get/all.mvc",function(data){
				if(data.length>0){
					var options="";
					
					for(var i=0;i<data.length;i++){
						options=options+"<option value='"+data[i].shouid+"'>"+data[i].shouid+"</option>"
						
					}
					$("select[name='shoufei.shouid']").html(options);
					
				}
			});
			
			$.getJSON("../qunuan/get.mvc",{quid:quid},function(data){
				$("input[name='quid']").val(data.quid);
				$("input[name='qufangshi']").val(data.qufangshi);
				$("select[name='shoufei.shouid']").val(data.shoufei.shouid);
	
				
			});
			$("form#qunuanmodifyFrom").validate({
				rules:{
					
					"qufangshi":{
						required:true
					},
					"youcost":{
						digits: true
					}
				}
			});
			
			$("#qunuanmodifyFrom").ajaxForm(function(data){
				if(data.result=="Y"){
					alert("修改成功");
				}
				else{
					alert("修改失败");
				}
				$("div#addqunuan").dialog("close"); //关闭弹出框
				$("div#addqunuan").html(""); //清空载入区
				$("table#qunuanlist").jqGrid().trigger("reloadGrid");
			
				
				
			});
		});
		
		
		}
		
		
	});
	//删除按钮点击
	$("a#qunuandel").on("click",function(){
		if(quid==null){
			alert("选择类型");
		}
		else{
			var confirmresult=confirm("确认删除么？");
			if(confirmresult){
				
				$.getJSON("../qunuan/delete.mvc",{quid:quid},function(data){
					if(data.result=="Y"){
						alert("成功");
						quid=0;
						
					}
					else{
						alert("失败");
					}
					$("div#addqunuan").dialog("close"); //关闭弹出框
					$("div#addqunuan").html(""); //清空载入区
					$("table#qunuanlist").jqGrid().trigger("reloadGrid");
				
				});
				
			}
		}
		
	});

	//查看
	$("a#qunuanlook").on("click",function(){
		if(quid==null){
			alert("请选择类型");
		}
		else{
			$("div#addqunuan").load("../zmm_qunuan/viewqunuan.html",function(){
				$("div#addqunuan").dialog({
					
					title:"查看取暖",
					width:500,
					
				});
				
				$.getJSON("../qunuan/get.mvc",{quid:quid},function(data){
					
					if(data!=null){
						$("span[name='quid']").html(data.quid);
						$("span[name='shoufei.shouid']").html(data.shoufei.shouid);
						$("span[name='qufangshi']").html(data.qufangshi);
						
					}
				});
				
				
				
				
				
				
			});
		}
	});
	
	
	
	
});