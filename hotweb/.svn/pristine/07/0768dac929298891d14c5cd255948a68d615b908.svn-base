

$(document).ready(function(){
	var tongid=null;
	$("table#tongzhilist").jqGrid({
		url: "../tongzhi/get/all/pages.mvc",
        datatype: "json",
        width:800,
        height:500,
        mtype: "GET",
        colNames: ["通知编号", "内容", "类型"],
        colModel: [
            { name: "tongid", width: 50 },
            { name: "tongcontext", width: 50 },
            { name: "tongtype", width: 20 }
           
        ],
        jsonReader:{
        	id: "tongid",
        },
        pager: "#tongzhipager",
        rowNum: 10,
        rowList: [10, 20, 30],
        sortname: "name",
        sortorder: "asc",
        viewrecords: true,
        gridview: true,
        autoencode: true,
        caption: "通知列表",
        multiselect:false,
        onSelectRow:function(id){
        	tongid=id;
        }
	});



	//增加按钮点击
	$("#tongzhiadd").on("click",function(){
		$("div#addtongzhi").load("../zmm_tongzhi/addtongzhi.html",function(){
			$("div#addtongzhi").dialog({
				
				title:"增加通知",
				width:500,
				
			});
			
			
			
			$("form#tongzhiAddFrom").validate({
				rules:{
					"tongid":{
						required: true
					},
					"tongcontext":{
						required:true
					},
					"tongtype":{
						required:true
					}
				}
			});
			
			$("#tongzhiAddFrom").ajaxForm(function(data){
				if(data.result=="Y"){
					alert("增加成功");
				}
				else{
					alert("失败");
				}
				$("div#addtongzhi").dialog("close"); //关闭弹出框
				$("div#addtongzhi").html(""); //清空载入区
				$("table#tongzhilist").jqGrid().trigger("reloadGrid");
				
				
				
			});
		});
		
		
		
	});
	
	
	
	
	//修改按钮点击
	$("a#tongzhimodify").on("click",function(){
		if(tongid==null){
			alert("选择类型");
		}
		else{
			
		$("div#addtongzhi").load("../zmm_tongzhi/modifytongzhi.html",function(){
			$("div#addtongzhi").dialog({
				
				title:"修改通知",
				width:500,
				
			});
			
			
			$.getJSON("../tongzhi/get.mvc",{tongid:tongid},function(data){
				$("input[name='tongid']").val(data.tongid);
				$("input[name='tongcontext']").val(data.tongcontext);
				$("input[name='tongtype']").val(data.tongtype);
				
			});
			$("form#tongzhimodifyFrom").validate({
				rules:{
					
					"tongcontext":{
						required:true
					},
					"tongtype":{
						required: true
					}
				}
			});
			
			$("#tongzhimodifyFrom").ajaxForm(function(data){
				if(data.result=="Y"){
					alert("修改成功");
				}
				else{
					alert("修改失败");
				}
				$("div#addtongzhi").dialog("close"); //关闭弹出框
				$("div#addtongzhi").html(""); //清空载入区
				$("table#tongzhilist").jqGrid().trigger("reloadGrid");
			
				
				
			});
		});
		
		
		}
		
		
	});
	//删除按钮点击
	$("a#tongzhidel").on("click",function(){
		if(tongid==null){
			alert("选择类型");
		}
		else{
			var confirmresult=confirm("确认删除么？");
			if(confirmresult){
				
				$.getJSON("../tongzhi/delete.mvc",{tongid:tongid},function(data){
					if(data.result=="Y"){
						alert("成功");
						tongid=null;
						
					}
					else{
						alert("失败");
					}
					$("div#addtongzhi").dialog("close"); //关闭弹出框
					$("div#addtongzhi").html(""); //清空载入区
					$("table#tongzhilist").jqGrid().trigger("reloadGrid");
				
				});
				
			}
		}
		
	});
	//查看
	$("a#tongzhilook").on("click",function(){
		if(tongid==null){
			alert("请选择类型");
		}
		else{
			$("div#addtongzhi").load("../zmm_tongzhi/viewtongzhi.html",function(){
				$("div#addtongzhi").dialog({
					
					title:"查看通知",
					width:500,
					
				});
				
				$.getJSON("../tongzhi/get.mvc",{tongid:tongid},function(data){
					
					if(data!=null){
						$("span[name='tongid']").html(data.tongid);
						$("span[name='tongcontext']").html(data.tongcontext);
						$("span[name='tongtype']").html(data.tongtype);
					}
				});
				
				
				
				
				
				
			});
		}
	});
	
	
	
	
	
	
	
	
});