
$(document).ready(function(){
    
	var portno=0;
	
	function showlist(){
		$.getJSON("../Headport/get/all.mvc",function(data){
			
			var showinfo="";
			
			for(var i=0;i<data.length;i++){
				
				showinfo=showinfo+"<tr id='"+data[i].portno+"'><td>"+data[i].portno+"</td><td>"+data[i].portname+"</td><td>"+data[i].scope+"</td><td>"+data[i].portaddr+"</td><td>"+data[i].porttel+"</td></tr>";
			}
			
			$("table#example-2 tbody").html(showinfo);
			
			$("table#example-2 tbody tr").on("click",function(){
				portno=$(this).attr("id");
				$("table#example-2 tbody tr").css("background-color","#FFFFFF");
				$(this).css("background-color","#AAA");
			});
			
		});
	}
	
	$("#headportadd").on("click",function(){ 
		
		$("div#headportdialog").load("../yg/addheadport.html",function(){
			$("div#headportdialog").dialog({title:"增加供热点"});
			
			$("#headportAddForm").validate({
				rules:{
					"portno":{
						digits:true
					},
					"portname":{
						required:true
					},
					"scope":{
						required:true
					},
					"portaddr":{
						required:true
					},
					"porttel":{
					
						digits:true
					}
				}
			});
			
			$("#headportAddForm").ajaxForm(function(data){
				if(data.result=="Y"){
					alert("添加成功");
				}
				else{
					alert("添加失败");
				}
				$("div#headportdialog").dialog("close");
				showlist();
			});
		});
		
	});	
	
	
	
	
	
	$("#headportmo").on("click",function(){
		if(portno==0){
			alert("请选择");
		}
		else{
			
		$("div#headportdialog").load("../yg/modifyheadport.html",function(){
			$("div#headportdialog").dialog({
				
				title:"修改供热点",
				width:500,
				
			});
			
			$.getJSON("../Headport/get.mvc",{portno:portno},function(data){
				$("input[name='portno']").val(data.portno);
				$("input[name='portname']").val(data.portname);
				$("input[name='scope']").val(data.scope);
				$("input[name='portaddr']").val(data.portaddr);
				$("input[name='porttel']").val(data.porttel);
				
				
			});
			
			$("#headportmodifyFrom").ajaxForm(function(data){
				if(data.result=="Y"){
					alert("修改成功");
				}
				else{
					alert("修改失败");
				}
				$("div#headportdialog").dialog("close");
				showlist();
				
			});
		});
		
		
		}
		
		
	});
	$("#headportdelete").on("click",function(){
		if(portno==0){
		alert("请选择");
	}else{
		
			var confirmresult=confirm("确认要删除此部门吗");
			if(confirmresult){
				
				$.getJSON("../Headport/delete.mvc",{portno:portno},function(data){
					
					if(data.result=="Y"){
					alert("删除成功");
					portno=0;
				}else{
					alert("删除失败");
				}
				
				showlist();
				});
				
			}
		
	}

	});	
	
	
	
	 $("a#headportlist1").on("click",function(){
			if(portno==0){
				alert("请选择要查看的供热点");
			}
			else{
				$("div#headportdialog").load("../yg/view.html",function(){
					
					$("div#headportdialog").dialog({
						title: "查看供热点",
						width:700,
						height:650
			
		});
		
	        $.getJSON("../Headport/get.mvc",{portno:portno},function(edata){
						
						if(edata!=null){
							$("span[name='portno']").html(edata.portno);
							$("span[name='portname']").html(edata.portname);
							$("span[name='scope']").html(edata.scope);
							$("span[name='portaddr']").html(edata.portaddr);
						    $("span[name='porttel']").html(edata.porttel);
						}	
					});
			});
				}
	 });
	 showlist();
});