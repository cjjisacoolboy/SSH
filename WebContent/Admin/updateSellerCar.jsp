<%@ page language="java" import="java.util.*,com.icss.pojo.SellerCar" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<%
		SellerCar sellerCar = (SellerCar)request.getAttribute("sellerCar");
	%>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="../css/searchOfCss.css">
		<script type="text/javascript" src="../js/jquery-1.11.3.min.js"></script>
		<script type="text/javascript" src="../self/searchCarId.js"></script>
		<title>Insert title here</title>
	</head>
	<body>
		<div class="gover_search" align="center">
			<table border="1">
				<tr>
				<div class="gover_search_form clearfix">
					<td>品牌：<input type="text" class="input_search_brandkey"
						id="gover_search_brandkey" placeholder="这里搜索品牌"
						name="carInfo.carBrand" value="" /> </td>
					<td>车系：<input type="text" class="input_search_serieskey" id="gover_search_serieskey"
						placeholder="这里搜索车系" name="carInfo.carseries" value="" /> </td>
					<td>车款：<select name="carInfo.carName" id="seachCarName">
							<option value="0">选择款式</option>
						</select></td>
					<!--  下拉的拓展空白框，搜索预提示框-->
					<div class="search_suggest" id="gov_search_suggest">
						<ul id="search_content">
							<!--可在这是用append添加在后台查询到的数据-->
	
						</ul>
					</div>
					<div class="search_suggest" id="gov_search_suggest1">
						<ul id="search_content1">
							<!--可在这是用append添加在后台查询到的数据-->
	
						</ul>
					</div>
				</div>
				</tr>
				<tr>
					<td>车牌：<input type="text" name="sellerCar.carPlate" id="carPlate"
						value="" /> </td>
					<td>验车地点：<input type="text" name="sellerCar.address"
						id="address" value="" /> </td>
					<td>二手价格：<input type="text" name="secondPrice.secondPrice" id="secondPrice" value="" />
					</td> 
					<tr>
						<td>联系电话：<input type="text" name="sellerCar.tel" id="tel" value="" /></td>
						<td><input type="hidden" name="sellerCar.sellerCarId"></td>
					</tr>
				</tr>
			</table>
			<input type="submit" name="submit" id="updateinfo" value="修改" />
		</div>
		进入了修改页面
			<%=sellerCar.getSellerCarId()%>
		<script>
		$(function(){
			
			function oSearchBrandSuggest(){	
				//alert("sdsd");
				//初始化查询框，为查询输入框绑定keyup和blur事件，注意keyup绑定的sendKeyWord函数在后面有定义
				var keyField = $('#gover_search_brandkey');	//关键字域
				var suggestWrap = $('#gov_search_suggest'); //自动下拉空白框
				var key = "";
				var searchinit = function() {   //初始化
					keyField.bind('keyup', sendKeyWord);
					keyField.bind('blur', function() {
						setTimeout(hideSuggest, 100);
						//alert("sdsd");
					});
				}
				var hideSuggest = function() {
					suggestWrap.hide();
				}
				var obj = this; //这里的this指的是html的dom对象
				//定义sendKeyWord，发送请求，根据关键字到后台查询
				var sendKeyWord = function(event) {
					//键盘选择下拉项
					if (suggestWrap.css('display') == 'block' && event.keyCode == 38
							|| event.keyCode == 40) {
						var current = suggestWrap.find('li.hover');
						if (event.keyCode == 38) {
							if (current.length > 0) {
								var prevLi = current.removeClass('hover').prev();
								if (prevLi.length > 0) {
									prevLi.addClass('hover');
									keyField.val(prevLi.html());
								}
							} else {
								var last = suggestWrap.find('li:last');
								last.addClass('hover');
								keyField.val(last.html());
							}
		
						} else if (event.keyCode == 40) {
							if (current.length > 0) {
								var nextLi = current.removeClass('hover').next();
								if (nextLi.length > 0) {
									nextLi.addClass('hover');
									keyField.val(nextLi.html());
								}
							} else {
								var first = suggestWrap.find('li:first');
								first.addClass('hover');
								keyField.val(first.html());
							}
						}
					} else {//下面的代码执行搜索   $.trim(keyField.val())获取文本框的内容
						var valText = $.trim(keyField.val());
						//if (valText == '' || valText == key) { //如果内容空或是就是数据库内面的内容是就隐藏提示框
						//	hideSuggest();
						//	return;
					//	}
						var type = "品牌";
						sendKeyWordToBack(valText,obj,type); //是用ajax从后台查找数据
						key = valText;
					}
		
				}
				//请求返回后，在搜索框下面显示提示数据下拉列表
				this.dataDisplay = function(data) {
					//alert("keyi");
					if (data.length <= 0) {
						
						suggestWrap.hide();
						return;
					}
					//往搜索框下拉建议显示栏中添加条目并显示
					var tmpFrag = document.createDocumentFragment();
					suggestWrap.find('#search_content').html('');
					for ( var i = 0; i < data.length; i++) {
						var li = document.createElement('LI');
						li.innerHTML = data[i].name;
						//alert(data[i].name);
						li.id = data[i].id;
						tmpFrag.appendChild(li);
					}
					suggestWrap.find('#search_content').append(tmpFrag);
					suggestWrap.show();
		
					//为下拉选项绑定鼠标事件
					suggestWrap.find('#search_content li').hover(function() {
						suggestWrap.find('#search_content li').removeClass('hover');
						$(this).addClass('hover');
						keyField.val(this.innerHTML);
					}, function() {
						$(this).removeClass('hover');
					})
				}
				searchinit();
			};
		
			//参数为一个字符串，是搜索输入框中当前的内容
			function sendKeyWordToBack(keyword,obj,type) {  
				//alert("sssss");
				$.ajax({
					type : "post",
					url : "../demo/searchCarInAdminAction.action",
					data : {
						"keyword" : keyword,
						"type" : type,
					},	
					async : false,
					success : function(data) {	
						var object = eval('(' + data + ')');
						//alert(obj.data);
						var carList = object.list;
						
						length = carList.length;
						
						//alert(carList);
						var aData = []; 
						for (var i = 0;i < length;i ++) {
							var item = {};
							item.id = i + 1;
							item.name = carList[i].carName;
							//item.name = 222;
							//alert(item.name);
							aData.push(item);
						}
					
					//将返回的数据传递给实现搜索输入框的输入提示js类
						obj.dataDisplay(aData);	
					}
				});
			}
			
			var searchBrandSuggest = new oSearchBrandSuggest();
			var searchSeriesSuggest = new  oSearchSeriesSuggest();
			function oSearchSeriesSuggest(){	
				//alert("sdsd");
				//初始化查询框，为查询输入框绑定keyup和blur事件，注意keyup绑定的sendKeyWord函数在后面有定义
				var keyField = $('#gover_search_serieskey');	//关键字域
				var suggestWrap = $('#gov_search_suggest1'); //自动下拉空白框
				var key = "";
				var searchinit = function() {   //初始化
					keyField.bind('keyup', sendKeyWord);
					keyField.bind('blur', function() {
						setTimeout(hideSuggest, 100);
						//alert("44444")
					});
				}
				var hideSuggest = function() {
					suggestWrap.hide();
				}
				var obj = this; //这里的this指的是html的dom对象
				//定义sendKeyWord，发送请求，根据关键字到后台查询
				var sendKeyWord = function(event) {
					//键盘选择下拉项
					if (suggestWrap.css('display') == 'block' && event.keyCode == 38
							|| event.keyCode == 40) {
						var current = suggestWrap.find('li.hover');
						if (event.keyCode == 38) {
							if (current.length > 0) {
								var prevLi = current.removeClass('hover').prev();
								if (prevLi.length > 0) {
									prevLi.addClass('hover');
									keyField.val(prevLi.html());
								}
							} else {
								var last = suggestWrap.find('li:last');
								last.addClass('hover');
								keyField.val(last.html());
							}
		
						} else if (event.keyCode == 40) {
							if (current.length > 0) {
								var nextLi = current.removeClass('hover').next();
								if (nextLi.length > 0) {
									nextLi.addClass('hover');
									keyField.val(nextLi.html());
								}
							} else {
								var first = suggestWrap.find('li:first');
								first.addClass('hover');
								keyField.val(first.html());
							}
						}
					} else {//下面的代码执行搜索   $.trim(keyField.val())获取文本框的内容
						var valText = $.trim(keyField.val());
						if (valText == '' || valText == key) { //如果内容空或是就是数据库内面的内容是就隐藏提示框
							hideSuggest();
							return;
						}
						var type="车系";
						sendKeyWordToBack(valText,obj,type); //是用ajax从后台查找数据
						key = valText;
					}
		
				}
				//请求返回后，在搜索框下面显示提示数据下拉列表
				this.dataDisplay = function(data) {
					//alert("keyi");
					if (data.length <= 0) {
						
						suggestWrap.hide();
						return;
					}
					//往搜索框下拉建议显示栏中添加条目并显示
					var tmpFrag = document.createDocumentFragment();
					suggestWrap.find('#search_content1').html('');
					for ( var i = 0; i < data.length; i++) {
						var li = document.createElement('LI');
						li.innerHTML = data[i].name;
						//alert(data[i].name);
						li.id = data[i].id;
						tmpFrag.appendChild(li);
					}
					suggestWrap.find('#search_content1').append(tmpFrag);
					suggestWrap.show();
		
					//为下拉选项绑定鼠标事件
					suggestWrap.find('#search_content1 li').hover(function() {
						suggestWrap.find('#search_content1 li').removeClass('hover');
						$(this).addClass('hover');
						keyField.val(this.innerHTML);
					}, function() {
						$(this).removeClass('hover');
					})
				}
				searchinit();
			};
			
			$('.gover_search').delegate('#gover_search_serieskey','blur',function(){
				var carName = $('#gover_search_serieskey').val();
			//	alert(carName);
				$('#seachCarName').empty();
				$('#seachCarName').append("<option value=''>sdsadasd</option> ");
				//doAjax("course_info_demo",id);
				doAjax(carName);
			});
//			$('#gover_search_serieskey').change(function(){
				
	//		})
			function doAjax(carName){
				var type ="款式";
				//alert(carName);
				$.ajax({
					type:'POST',
					url:'../demo/searchCarInAdminAction.action',
					data:{
						"keyword":carName,
						"type":type
					},
					async : true,
					success:function(data) {
					//	alert("ddddddd");
					//	alert(data);
						var obj = eval( '(' + data + ')' );
						var carList = obj.list;
						
						for ( var i=0; i<carList.length; i++ ) {	
							var carId = carList[i].carId;
							var carName = carList[i].carName;
							$('#seachCarName').append(" <option value='"+carId+"'>"+carName+"</option>");
							}
					//	}else{
						//	for ( var i=0; i<academe.length; i++ ) {	
					//			var id = academe[i].academe_id;
					//			var name = academe[i].academe_name;
					//			$('#'+type).append(" <option value='"+id+"'>"+name+"</option>");
				//			}
						//}
					},
					error : function(){
						alert("找不到");
					}
				})
			}
			
	
})
</script>
	</body>
</html>