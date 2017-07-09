

$(document).ready(function(){
	
	var idname=null;
	function showlist(){
		$.getJSON("../Identity/get/all.mvc",function(data){
			
			var showinfo="";
			
			for(var i=0;i<data.length;i++){
				
				showinfo=showinfo+"<tr id='"+data[i].idname+"'><td>"+data[i].idname+"</td><td>"+data[i].detail+"</td></tr>";
			}
			
			$("table#example-2 tbody").html(showinfo);
			$("table#example-2 tbody tr").on("click",function(){
				idname=$(this).attr("id");
				$("table#example-2 tbody tr").css("background-color","#FFFFFF");
				$(this).css("background-color","#AAA");
			});
			
			
		});
	}
	
	$("#identityadd").on("click",function(){
	
		$("div#identitydialog").load("../dx/addidentity.html",function(){
			$("div#identitydialog").dialog({title:"增加权限"});
			$("#identityAddForm").validate({
				rules:{
					"idname":{
						required:true
					},
					"detail":{
						required:true
					}
				}
			});
			
			
			$("#identityAddForm").ajaxForm(function(data){
				if(data.result=="Y"){
					alert("添加成功");
					}
				else{
					alert("添加失败");
				}
				$("div#identitydialog").dialog("close");
				showlist();
			});
		});
	});
	
	
	//修改按钮点击
	$("a#identitymodify").on("click",function(){
		if(idname==null){
			alert("选择权限");
		}
		else{
			
		$("div#identitydialog").load("../dx/modifyidentity.html",function(){
			$("div#identitydialog").dialog({
				
				title:"修改权限",
				width:500,
				
			});
			
			$.getJSON("../Identity/get.mvc",{idname:idname},function(data){
				$("input[name='idname']").val(data.idname);
				$("input[name='detail']").val(data.detail);

				
			});
			
			$("#identitymodifyFrom").validate({
				rules:{
					"idname":{
						required:true
					},
					"detail":{
						required:true
					}
				}
			});
			
			$("#identitymodifyFrom").ajaxForm(function(data){
				if(data.result=="Y"){
					alert("修改成功");
				}
				else{
					alert("修改失败");
				}
				$("div#identitydialog").dialog("close");
				showlist();
				
				
			});
		});
		
		
		}
		
		
	});
	$("a#identitydelete").on("click",function(){
		if(idname==null){
			alert("请选择");
		}
		else{
			
			var confirmresult=confirm("确认要删除此权限吗");
			if(confirmresult){
					$.getJSON("../Identity/delete.mvc",{idname:idname},function(data){
										if(data.result=="Y"){
											alert("删除成功");
											idname=null;
										}else{
											alert("删除失败");
										}
										showlist();
										}
					);
			
		}

			
		
		}
		
	});
	//查看权限处理
	$("a#identitylist1").on("click",function(){
		if(idname==null){
			alert("请选择要查看的用户");
		}
		else{
			$("div#identitydialog").load("../dx/view.html",function(){
				
				$("div#identitydialog").dialog({
					title: "查看权限",
					width:700,
					height:650
				});
				
				$.getJSON("../Identity/get.mvc",{idname:idname},function(edata){
					
					if(edata!=null){
						$("span[name='idname']").html(edata.idname);
						$("span[name='detail']").html(edata.detail);
					}
				});
				
				
				
				
				
				
			});
		}
	});
	
	
	showlist();
	
	
	
});