function doAjax(page,url){
					
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
				   				$('#showtable').append("<tr><td>"+rows[i].businessName+"</td>"+
				   						"<td>"+rows[i].tel+"</td><td>"+rows[i].companyName+"</td>"+
				   						"<td>"+rows[i].dealerType+"</td><td>"+rows[i].dealerAddress+"</td>"+
				   						"<td>"+rows[i].applyState+"</td><td>"+
				   						+"<input type='button' id='commit' value='审核通过' /><a href='../admin/doMer_auditAC.action'>审核通过</a></td></tr>");
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