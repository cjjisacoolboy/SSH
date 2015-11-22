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
			<table id="showtable" border = "1">
				
			
			</table>
		
		</div>
		<div id="pageSize">
		
		</div>
		
		<script type="text/javascript">
			$(function(){
						//$("#" + pdid + "")
					//var page = $('#pageSize').children('#1').attr('name');
						//alert(page);
				var url = "../demo/findMerStore_auditAction.action";
				var page = 1;
				function doAjax(page,size){
					
					$.ajax({
						type:'POST',
						url:url,
						data:{
								"page":page,
				    			"size":"5"
				    		},
				    	success:function(data) {
				    		var obj = eval('(' + data + ')');
				    		var count =  obj.count;
				    		var rows = obj.list;
				    		var pageSize = obj.pageSize;
				    		var size = 0;
				    		$('#pageSize').text("");
				    		$('#showtable').text("");
				    		$('#showtable').append("<tr><td>商家姓名</td><td>商家手机</td>"+
				    						"<td>公司名</td><td>经销商类型</td>"+
				    						"<td>地址</td><td>审核状态</td><td>审核操作</td></tr>");	
				    		for (var i = count;i < rows.length;i ++) {
				   				
				   				if('待审核' == rows[i].applyState){
				   					$('#showtable').append("<tr><td>"+rows[i].businessName+"</td>"+
				   						"<td>"+rows[i].tel+"</td><td>"+rows[i].companyName+"</td>"+
				   						"<td>"+rows[i].dealerType+"</td><td>"+rows[i].dealerAddress+"</td>"+
				   						"<td>"+rows[i].applyState+"</td><td><input type='button' id='pass' name='"+rows[i].audit_id+"' value='通过'  />"+
				   						"<input type='button' id='fail' name='"+rows[i].audit_id+"' value='不通过' /></td></tr>");
				   				} else {
				   					$('#showtable').append("<tr><td>"+rows[i].businessName+"</td>"+
					   						"<td>"+rows[i].tel+"</td><td>"+rows[i].companyName+"</td>"+
					   						"<td>"+rows[i].dealerType+"</td><td>"+rows[i].dealerAddress+"</td>"+
					   						"<td>"+rows[i].applyState+"</td><td>已审核</td></tr>");
				   				}
				   				//<a href='../admin/doMer_auditAC.action'>审核通过</a>
				   				size++;
				   				if(size>=5){
				   					break;
				   				}
				    		}
				    		//$('#showtable').append("</table>");	
				    		for (var j = 0; j < pageSize; j++) {		
				    			$('#pageSize').append("<a id='1' name='"+(j+1)+"'>["+(j+1)+"]</a>");
				    		}
				    	}
					});	
							
				}
				doAjax(page,url);
				$('#pageSize').delegate('#1','click',function(){
					page = $(this).attr('name');
					doAjax(page,url);
				});
				
				//审核按钮
				$('#showtable').delegate('#pass','click',function(){
					//点击完后完成操作后将这条记录消失
					var audit_id = $(this).attr('name');
					alert($(this).attr('name'))
					var applyState = $(this).attr('value');
					//alert(applyState);
					var updateurl ="../demo/doMer_auditAC.action"; 
					$.ajax({
						type:'POST',
						url:updateurl,
						data:{
								"audit_id":audit_id,
								"applyState":applyState
				    		},
				    	success:function(data) {
				    		doAjax(page,url);
				    	}
					});
				});
				$('#showtable').delegate('#fail','click',function(){
					var audit_id = $(this).attr('name');
					alert($(this).attr('name'))
					var applyState = $(this).attr('value');
					//alert(applyState);
					var updateurl ="../demo/doMer_auditAC.action"; 
					$.ajax({
						type:'POST',
						url:updateurl,
						data:{
								"audit_id":audit_id,
								"applyState":applyState
				    		},
				    	success:function(data) {
				    		doAjax(page,url);
				    	}
					});
				});
				
		});			
		</script>
	</body>
</html>