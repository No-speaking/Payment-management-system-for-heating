

$(document).ready(function(){
	var shouid=null;
	$("table#shoufeilist").jqGrid({
		url: "../shoufei/get/all/pages.mvc",
        datatype: "json",
        width:800,
        height:500,
        mtype: "GET",
        colNames: ["收费编号", "费用"],
        colModel: [
            { name: "shouid", width: 50 },
            { name: "feiyong", width: 20 },
           
           
        ],
        jsonReader:{
        	id: "shouid",
        },
        pager: "#shoufeipager",
        rowNum: 10,
        rowList: [10, 20, 30],
        sortname: "name",
        sortorder: "asc",
        viewrecords: true,
        gridview: true,
        autoencode: true,
        caption: "收费列表",
        multiselect:false,
        onSelectRow:function(id){
        	shouid=id;
        }
	});



	//增加按钮点击
	$("#shoufeiadd").on("click",function(){
		$("div#addshoufei").load("../zmm_shoufei/addshoufei.html",function(){
			$("div#addshoufei").dialog({
				
				title:"增加收费",
				width:500,
				
			});
			
			
			
			$("form#shoufeiAddFrom").validate({
				rules:{
					"shouid":{
						required: true
					},
					"feiyong":{
						digits:true
					}
					
				}
			});
			
			$("#shoufeiAddFrom").ajaxForm(function(data){
				if(data.result=="Y"){
					alert("增加成功");
				}
				else{
					alert("失败");
				}
				$("div#addshoufei").dialog("close"); //关闭弹出框
				$("div#addshoufei").html(""); //清空载入区
				$("table#shoufeilist").jqGrid().trigger("reloadGrid");
				
				
				
			});
		});
		
		
		
	});
	
	
	
	
	//修改按钮点击
	$("a#shoufeimodify").on("click",function(){
		if(shouid==null){
			alert("选择类型");
		}
		else{
			
		$("div#addshoufei").load("../zmm_shoufei/modifyshoufei.html",function(){
			$("div#addshoufei").dialog({
				
				title:"修改收费",
				width:500,
				
			});
			
			
			$.getJSON("../shoufei/get.mvc",{shouid:shouid},function(data){
				$("input[name='shouid']").val(data.shouid);
				$("input[name='feiyong']").val(data.feiyong);
				
				
			});
			$("form#shoufeimodifyFrom").validate({
				rules:{
					
					"totalcost":{
						digits:true
					},
					"youcost":{
						required: true
					}
				}
			});
			
			$("#shoufeimodifyFrom").ajaxForm(function(data){
				if(data.result=="Y"){
					alert("修改成功");
				}
				else{
					alert("修改失败");
				}
				$("div#addshoufei").dialog("close"); //关闭弹出框
				$("div#addshoufei").html(""); //清空载入区
				$("table#shoufeilist").jqGrid().trigger("reloadGrid");
			
				
				
			});
		});
		
		
		}
		
		
	});
	//删除按钮点击
	$("a#shoufeidel").on("click",function(){
		if(shouid==null){
			alert("选择类型");
		}
		else{
			var confirmresult=confirm("确认删除么？");
			if(confirmresult){
				
				$.getJSON("../shoufei/delete.mvc",{shouid:shouid},function(data){
					if(data.result=="Y"){
						alert("成功");
						shouid=null;
						
					}
					else{
						alert("失败");
					}
					$("div#addshoufei").dialog("close"); //关闭弹出框
					$("div#addshoufei").html(""); //清空载入区
					$("table#shoufeilist").jqGrid().trigger("reloadGrid");
				
				});
				
			}
		}
		
	});
	//查看
	$("a#shoufeilook").on("click",function(){
		if(shouid==null){
			alert("请选择类型");
		}
		else{
			$("div#addshoufei").load("../zmm_shoufei/viewshoufei.html",function(){
				$("div#addshoufei").dialog({
					
					title:"查看取暖",
					width:500,
					
				});
				
				$.getJSON("../shoufei/get.mvc",{shouid:shouid},function(data){
					
					if(data!=null){
						$("span[name='shouid']").html(data.shouid);
						$("span[name='feiyong']").html(data.feiyong);
						
					}
				});
			
				//取得员工的爱好列表，并选中对应的复选框
				$.getJSON("../shoufei/get/qunuans.mvc",{shouid:shouid},function(bdata){
					
					if(bdata!=null&&bdata.length>0){
						var qunuanlist="";
						for(var i=0;i<bdata.length;i++){
							qunuanlist=qunuanlist+" "+bdata[i].qufangshi
						}
						$("#qunuancheckbox").html(qunuanlist);
					}
				});
				
				
				
				
				
			});
		}
	});
	
	
	
	
	
});