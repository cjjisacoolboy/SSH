<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript" src="../js/jquery-1.11.3.min.js"></script>
	</head>
	<body>
		
		<div>
			<table id="showtable">
				
			
			</table>
		
		</div>
		<div id="pageSize">
		</div>
		<script type="text/javascript">
			$(document).ready(function(){
						//$("#" + pdid + "")
					//var page = $('#pageSize').children('#1').attr('name');
						//alert(page);
						
				var page = 1;
				alert(page);
				function doAjax(page){
					
					$.ajax({
						type:'POST',
						url:'../demo/findMerStoreAction.action',
						data:{
								"page":page,
				    			"size":"5"
				    		},
				    	success:function(data) {
				    		var obj = eval('(' + data + ')');
				    		alert("dsdsd");
				    		var count =  obj.count;
				    		var rows = obj.list;
				    		var pageSize = obj.pageSize;
				    		var size = 0;
				    		$('#pageSize').text("");
				    		$('#showtable').text("");
				    		$('#showtable').append("<tr><td>商家姓名</td><td>商家手机</td>"+
				    						"<td>公司名</td><td>经销商类型</td>"+
				    						"<td>地址</td><td>操作</td></tr>");	
				    		for (var i = count; i < rows.length;i ++) {
				   				$('#showtable').append("<tr><td>"+rows[i].businessName+"</td>"+
				   						"<td>"+rows[i].tel+"</td><td>"+rows[i].companyName+"</td>"+
				   						"<td>"+rows[i].dealerType+"</td><td>"+rows[i].dealerAddress+"</td>"+
				   						"</tr>");
				   				size++;
				   				if(size>=5){
				   					break;
				   				}
				    		}
				    			
				    		for (var j = 0; j < pageSize; j++) {		
				    			$('#pageSize').append("<a id='1' name='"+(j+1)+"'>["+(j+1)+"]</a>");
				    		}
				    	}
					});	
							
				}
				doAjax(page);
				$('#pageSize').delegate('#1','click',function(){
					page = $(this).attr('name');
					doAjax(page);
				});
		});			
		</script>
	</body>
</html>