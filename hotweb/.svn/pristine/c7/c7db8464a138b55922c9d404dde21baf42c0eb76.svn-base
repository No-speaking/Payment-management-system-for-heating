
$(document).ready(function(){
	
	var roomno=0;
	
	
	function showlist(){
		
		$.getJSON("../Room/getList.mvc",function(data){
			
			var showinfo="";
			for(var i=0;i<data.length;i++){
				
				showinfo=showinfo+"<tr id='"+data[i].roomno+"'><td>"+data[i].roomno+"</td><td>"+data[i].roomaddr+"</td><td>"+data[i].area+"</td></tr>";
				
				 
			}
			
			$("table#example-2 tbody").html(showinfo);
			$("table#example-2 tbody tr").on("click",function(){
				roomno=$(this).attr("id");
				$("table#example-2 tbody tr").css("background-color","#FFFFFF");
				$(this).css("background-color","#AAA");
				
			});
		});
		
	}
	
	$("#roomadd").on("click",function(){ $("div#roomdialog").load("../xq/addRoom.html",function(){
		
		$("div#roomdialog").dialog({
			title:"增加房屋"
		});
		
		$("#roomAddForm").validate({
			rules:{
				"roomno":{
					required:true
				},
				"roomaddr":{
					required:true
				},
				"area":{
				
					digits:true
				}
			}
		});
		
		$("#roomAddForm").ajaxForm(function(data){
			if(data.result=="Y"){
				alert("添加成功");
			}else{
				alert("添加失败");
			}
			$("div#roomdialog").dialog("close");
			showlist();
		});
		
	}); });
	
	$("#roommodify").on("click",function(){
		
		if(roomno==0){
			alert("请选择");
		}else{
			
				$("div#roomdialog").load("../xq/modifyRoom.html",function(){
			
								$("div#roomdialog").dialog({
									title:"修改房屋"
								});
								$.getJSON("../Room/get.mvc",{roomno:roomno},function(data){
									$("input[name='roomno']").val(data.roomno);
									$("input[name='roomaddr']").val(data.roomaddr);
									$("input[name='area']").val(data.area);
									
								});
								
								$("#roomModifyForm").validate({
									rules:{
										"roomno":{
											required:true
										},
										"roomaddr":{
											required:true
										},
										"area":{
										
											digits:true
										}
									}
								});
								
								$("#roomModifyForm").ajaxForm(function(data){
									if(data.result=="Y"){
										alert("修改成功");
									}else{
										alert("修改失败");
									}
									$("div#roomdialog").dialog("close");
									showlist();
								});
				
		
						});
		
			
		}
		
	});
	$("a#roomdelete").on("click",function(){
		
		if(roomno==0){
			alert("请选择");
		}else{
			
				var confirmresult=confirm("确认要删除此部门吗");
				if(confirmresult){
					
					$.getJSON("../Room/delete.mvc",{roomno:roomno},function(data){
						
						if(data.result=="Y"){
						alert("删除成功");
						roonmo=0;
					}else{
						alert("删除失败");
					}
					
					showlist();
					});
					
				}
			
		}

		
		
	});
$("#roomlist1").on("click",function(){
		
		if(roomno==0){
			alert("请选择");
		}else{
			
				$("div#roomdialog").load("../xq/view.html",function(){
			
								$("div#roomdialog").dialog({
									title:"查看房屋"
								});
								$.getJSON("../Room/get.mvc",{roomno:roomno},function(data){
									$("span[name='roomno']").html(data.roomno);
									$("span[name='roomaddr']").html(data.roomaddr);
									$("span[name='area']").html(data.area);
									
								});
								
				
			
				});}
		
	});
showlist();
	
});