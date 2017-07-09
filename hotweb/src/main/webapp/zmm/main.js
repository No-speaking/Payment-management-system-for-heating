
$(document).ready(function(){
	var youid=null;
	function showlist(){
		$.getJSON("../youhui/get/all.mvc",function(data){
			
			var showinfo="";
			
			for(var i=0;i<data.length;i++){
				
				showinfo=showinfo+"<tr id='"+data[i].youid+"'><td>"+data[i].youid+"</td><td>"+data[i].zhekou+"</td><td>"+data[i].descrip+"</td></tr>";
			}
			
			$("table#example-2 tbody").html(showinfo);
			
			$("table#example-2 tbody tr").on("click",function(){
				youid=$(this).attr("id");
				$("table#example-2 tbody tr").css("background-color","#FFFFFF");
				$(this).css("background-color","#AAA");
			});
			
		});
	}
	//增加按钮点击
	$("#youhuiadd").on("click",function(){
		$("div#addyouhui").load("../zmm/addyouhui.html",function(){
			$("div#addyouhui").dialog({
				
				title:"增加优惠",
				width:500,
				
			});
			
			$("form#youhuiAddFrom").validate({
				rules:{
					"youid":{
						required: true
					},
					"zhekou":{
						digits:true
					},
					"descrip":{
						required: true
					}
				}
			});
			
			$("#youhuiAddFrom").ajaxForm(function(data){
				if(data.result=="Y"){
					alert("增加成功");
				}
				else{
					alert("失败");
				}
				$("div#addyouhui").dialog("close");
				showlist();
				
			});
		});
		
		
		
	});
	
	
	
	
	//修改按钮点击
	$("a#youhuimodify").on("click",function(){
		if(youid==null){
			alert("选择类型");
		}
		else{
			
		$("div#addyouhui").load("../zmm/modifyyouhui.html",function(){
			$("div#addyouhui").dialog({
				
				title:"修改优惠",
				width:500,
				
			});
			
			$.getJSON("../youhui/get.mvc",{youid:youid},function(data){
				$("input[name='zhekou']").val(data.zhekou);
				$("input[name='descrip']").val(data.descrip);
				$("input[name='youid']").val(data.youid);
				
			});
			$("form#youhuimodifyFrom").validate({
				rules:{
					
					"zhekou":{
						digits:true
					},
					"descrip":{
						required: true
					}
				}
			});
			
			$("#youhuimodifyFrom").ajaxForm(function(data){
				if(data.result=="Y"){
					alert("修改成功");
				}
				else{
					alert("修改失败");
				}
				$("div#addyouhui").dialog("close");
				showlist();
				
			});
		});
		
		
		}
		
		
	});
	//删除按钮点击
	$("a#youhuidel").on("click",function(){
		if(youid==null){
			alert("选择类型");
		}
		else{
			var confirmresult=confirm("确认删除么？");
			if(confirmresult){
				$.getJSON("../youhui/delete.mvc",{youid:youid},function(data){
					if(data.result=="Y"){
						alert("成功");
						youid=0;
						
					}
					else{
						alert("失败");
					}
					showlist();
				});
			}
		}
		
	});
	//查看按钮点击
	$("a#youhuilook").on("click",function(){
		if(youid==null){
			alert("请选择类型");
		}
		else{
			$("div#addyouhui").load("../zmm/view.html",function(){
				$("div#addyouhui").dialog({
					
					title:"查看通知",
					width:500,
					
				});
				
				$.getJSON("../youhui/get.mvc",{youid:youid},function(data){
					
					if(data!=null){
						$("span[name='youid']").html(data.youid);
						$("span[name='zhekou']").html(data.zhekou);
						$("span[name='descrip']").html(data.descrip);
					}
				});
				
				//取得优惠的缴费列表，并选中对应的复选框
				$.getJSON("../youhui/get/costs.mvc",{youid:youid},function(bdata){
					
					if(bdata!=null&&bdata.length>0){
						var costlist="";
						for(var i=0;i<bdata.length;i++){
							costlist=costlist+" "+bdata[i].costno
						}
						$("#costcheckbox").html(costlist);
					}
				});
				
				
				
				
			});
		}
	});
	
	
	
	
	
	
	
	
	showlist();
	
	
	
	
	
});