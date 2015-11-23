<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript" src="../js/jquery-1.11.3.min.js"></script>
		<script type="text/javascript" src="../self/finSecondInAdmin.js"></script>
	</head>
	<body>
		<div>
			<table id="showtable" border = "1">
				
			
			</table>
		
		</div>
		<div id="pageSize">
		
		</div>
		
		<div id="showDetial" align="center">
			
			<table id="carDetail" border="1"><tr><td>车辆详情</td></tr></table>
			<table id="imageShow"><tr><td>图片显示</td></tr></table>
			<table id="merchantsStoreDetail" border="1"> <tr><td>商家详情</td></tr></table>
			<table id="procedureDetail" border="1"> <tr><td>过户详情</td></tr></table>
			<table id="checkerDetail" border="1"> <tr><td>检测情况</td></tr></table>
		</div>
		
		 
		<script type="text/javascript">
		$(function(){
			//$("#" + pdid + "")
		//var page = $('#pageSize').children('#1').attr('name');
			//alert(page);
	var url = "../demo/findAllsaleCarsAction.action";
	var page = 1;
	function doAjax(page,url){
		//alert(page);
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
	    		$('#showtable').append("<tr><td>车牌</td><td>车名</td><td>个人卖家</td>"+
	    						"<td>商铺公司</td><td>过户次数</td>"+
	    						"<td>验车地址</td><td>电话</td><td>卖出价格</td><td>查看详情</td><td>操作</td></tr>");	
	    		for (var i = count;i < rows.length;i ++) {
	   					//alert(i);
	   					$('#showtable').append("<tr><td>"+rows[i].carPlate+"</td>"+
	   							"<td>"+rows[i].carInfo.carName+"</td><td>"+
	   							rows[i].seller.sellerName+"</td><td>"+
	   							rows[i].merchantsStore.companyName+"</td><td>"+
	   							rows[i].procedureInfo.transferNumber+"</td><td>"+
	   							rows[i].address+"</td><td>"+rows[i].tel+"</td><td>"+
	   							rows[i].secondPrice.secondPrice+"</td>"+
	   							"<td><input type='button' id='checkDetail' name='"+
	   							rows[i].sellerCarId+"' value='查看'/></td><td>"+
	   							"<input type='button' name='"+
	   							rows[i].sellerCarId+"' id='update' value='修改'></a></td></tr>");
	   			
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
	
	$('#showtable').delegate('#checkDetail','click',function(){
		//点击完后完成操作后将这条记录消失
		var sellerCarId = $(this).attr('name');
		//alert($(this).attr('name'))
		//var applyState = $(this).attr('value');
		//alert(applyState);
		var detailurl ="../demo/findSalCarDetailAction.action"; 
		$.ajax({
			type:'POST',
			url:detailurl,
			data:{
					"sellerCarId":sellerCarId
					
	    		},
	    	success:function(data) {
	    		//alert(data);
	    		var obj = eval('(' + data + ')');
	    		//带list的就要get（0）
	    		$("#carDetail").text("");
	    		$('#merchantsStoreDetail').text("");
	    		$('#procedureDetail').text("");
	    		$('#checkerDetail').text("");
	    		var carList = obj.carList;
	    		var image = obj.image;
	    		var merchantsStore = obj.merchantsStore;
	    		var seller = obj.seller;
	    		//商家或个人可能为空的
	    		var procedureInfo = obj.procedureInfo;
	    		var secondPrice = obj.secondPrice;
	    		var checkerInfo = obj.checkerInfo;
	    		var sellerCarList = obj.sellerCarList;
	    		//alert(carList[0].carName);
	    		$('#carDetail').append("<tr><td rowspan='3'>"+image.imageSrc+"</td><td colspan='4'>"+
	    				carList[0].carName+"</td><td rowspan='3'>二手售价："+secondPrice.secondPrice+"</td></tr><tr><td>车牌："+
	    				sellerCarList[0].carPlate+"</td><td>表里程："+secondPrice.km+"km</td><td>购车时间:"
	    				+secondPrice.buyTime+"</td></tr><tr><td>变速箱："+carList[0].parametersConfig.transmission+
	    				"<td colspan='2'>地点:"+sellerCarList[0].address+"</td></tr>");
	    		//alert(seller.sellerName);
	    		if("非个人"==seller.sellerName){
	    		$('#merchantsStoreDetail').append("<tr><td>商家法人："+merchantsStore.businessName+"</td><td>联系方式："+
	    				merchantsStore.tel+"</td><td>公司名称:"+merchantsStore.companyName+"</td></tr>"+
	    				"<tr><td>经销商类型："+merchantsStore.dealerType+"</td><td colspan='2'>店铺地址："+
	    				merchantsStore.dealerAddress+"</td></tr>");
	    			//alert("添加商家信息");
	    		}else{
	    		$('#merchantsStoreDetail').append("<tr><td>卖家姓名:"+seller.sellerName+"</td><td>联系电话："+
	    				seller.tel+"</td><td></td></tr>");	
	    			//alert("添加个人信息");
	    		}
	    		$('#procedureDetail').append("<tr><td>过户次数："+procedureInfo.transferNumber+"</td><td>使用性质:"+
	    				procedureInfo.useProperties+"</td><td>过户手续："+
	    				procedureInfo.transferProcedures+"</td></tr><tr><td>保险到期时间："+
	    				procedureInfo.lastDate+"</td><td>年检有效期："+procedureInfo.validityPeriod+
	    				"</td><td>保养情况："+procedureInfo.maintenance+"</td></tr>");
	    		if(checkerInfo!=null){
	    			$('#checkerDetail').append("<tr><td>检测时间："+checkerInfo.checkTime+"</td><td>检测师："+checkerInfo.checkerName+"</td><td>"+
	    					"级别："+checkerInfo.checkerLevel+"</td><td>检测经验："+checkerInfo.checkCar+
	    					"辆</td></tr>");
	    		
	    		//alert("有检测员");
	    		} else {
	    			$('#checkerDetail').append("<tr><td>这辆车并没有检测</td></tr>");
	    		}
	    		
	    	
	    	}
		});
	});
	$('#showtable').delegate('#update','click',function(){
		//点击完后完成操作后将这条记录消失
		var sellerCarId = $(this).attr('name');
		//alert($(this).attr('name'))
		//var applyState = $(this).attr('value');
		//alert(applyState);
		//var updateurl ="updateSellerCarAC.action"; 
		//$.ajax({
		//	type:'POST',
		//	url:updateurl,
		//	data:{
		//			"sellerCar.sellerCarId":sellerCarId
					
	  //  		},
	  //  	complete:function(data) {
	    location.href="../admin/updateSellerCarAC.action?sellerCar.sellerCarId="+sellerCarId;  		
	  //  	}
	//	});
	});
});
	
		</script>
	
	</body>
</html>