

$(document).ready(function(){
	var costno=null;
	$("table#costinfolist").jqGrid({
		url: "../costinfo/get/all/pages.mvc",
        datatype: "json",
        width:800,
        height:500,
        mtype: "GET",
        colNames: ["缴费编号", "总费用", "优惠后费用", "优惠"],
        colModel: [
            { name: "costno", width: 50 },
            { name: "totalcost", width: 20 },
            { name: "youcost", width: 50, align: "right" },
            { name: "youhui.youid", width: 90, align: "left" },
           
        ],
        jsonReader:{
        	id: "costno",
        },
        pager: "#costinfopager",
        rowNum: 10,
        rowList: [10, 20, 30],
        sortname: "name",
        sortorder: "asc",
        viewrecords: true,
        gridview: true,
        autoencode: true,
        caption: "缴费列表",
        multiselect:false,
        onSelectRow:function(id){
        	costno=id;
        }
	});



	//增加按钮点击
	$("#costinfoadd").on("click",function(){
		$("div#addcostinfo").load("../zmm_cost/addcostinfo.html",function(){
			$("div#addcostinfo").dialog({
				
				title:"增加缴费",
				width:500,
				
			});
			//取得部门列表，填充部门下拉框选项
			$.getJSON("../youhui/get/all.mvc",function(data){
				if(data.length>0){
					var options="";
					
					for(var i=0;i<data.length;i++){
						options=options+"<option value='"+data[i].youid+"'>"+data[i].youid+"</option>"
						
					}
					$("select[name='youhui.youid']").html(options);
					
				}
			});
			
			
			$("form#costinfoAddFrom").validate({
				rules:{
					"totalcost":{
						required: true
					},
					"youcost":{
						digits:true
					}
					
				}
			});
			
			$("#costinfoAddFrom").ajaxForm(function(data){
				if(data.result=="Y"){
					alert("增加成功");
				}
				else{
					alert("失败");
				}
				$("div#addcostinfo").dialog("close"); //关闭弹出框
				$("div#addcostinfo").html(""); //清空载入区
				$("table#costinfolist").jqGrid().trigger("reloadGrid");
				
				
				
			});
		});
		
		
		
	});
	
	
	
	
	//修改按钮点击
	$("a#costinfomodify").on("click",function(){
		if(costno==null){
			alert("选择类型");
		}
		else{
			
		$("div#addcostinfo").load("../zmm_cost/modifycostinfo.html",function(){
			$("div#addcostinfo").dialog({
				
				title:"修改缴费",
				width:500,
				
			});
			//取得部门列表，填充部门下拉框选项
			$.getJSON("../youhui/get/all.mvc",function(data){
				if(data.length>0){
					var options="";
					
					for(var i=0;i<data.length;i++){
						options=options+"<option value='"+data[i].youid+"'>"+data[i].youid+"</option>"
						
					}
					$("select[name='youhui.youid']").html(options);
					
				}
			});
			
			$.getJSON("../costinfo/get.mvc",{costno:costno},function(data){
				$("input[name='totalcost']").val(data.totalcost);
				$("input[name='youcost']").val(data.youcost);
				$("input[name='costno']").val(data.costno);
				$("select[name='youhui.youid']").val(data.youhui.youid);
				
			});
			$("form#costinfomodifyFrom").validate({
				rules:{
					
					"totalcost":{
						digits:true
					},
					"youcost":{
						required: true
					}
				}
			});
			
			$("#costinfomodifyFrom").ajaxForm(function(data){
				if(data.result=="Y"){
					alert("修改成功");
				}
				else{
					alert("修改失败");
				}
				$("div#addcostinfo").dialog("close"); //关闭弹出框
				$("div#addcostinfo").html(""); //清空载入区
				$("table#costinfolist").jqGrid().trigger("reloadGrid");
			
				
				
			});
		});
		
		
		}
		
		
	});
	//删除按钮点击
	$("a#costinfodel").on("click",function(){
		if(costno==null){
			alert("选择类型");
		}
		else{
			var confirmresult=confirm("确认删除么？");
			if(confirmresult){
				
				$.getJSON("../costinfo/delete.mvc",{costno:costno},function(data){
					if(data.result=="Y"){
						alert("成功");
						costno=0;
						
					}
					else{
						alert("失败");
					}
					$("div#addcostinfo").dialog("close"); //关闭弹出框
					$("div#addcostinfo").html(""); //清空载入区
					$("table#costinfolist").jqGrid().trigger("reloadGrid");
				
				});
				
			}
		}
		
	});

	//查看
	$("a#costinfolook").on("click",function(){
		if(costno==null){
			alert("请选择类型");
		}
		else{
			$("div#addcostinfo").load("../zmm_cost/viewcostinfo.html",function(){
				$("div#addcostinfo").dialog({
					
					title:"查看缴费",
					width:500,
					
				});
				
				$.getJSON("../costinfo/get.mvc",{costno:costno},function(data){
					
					if(data!=null){
						$("span[name='costno']").html(data.costno);
						$("span[name='youhui.youid']").html(data.youhui.youid);
						$("span[name='youcost']").html(data.youcost);
						$("span[name='totalcost']").html(data.totalcost);
					}
				});
				
				
				
				
				
				
			});
		}
	});
	
	
	
	
});