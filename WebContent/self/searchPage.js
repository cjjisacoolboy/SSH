var searchSuggest = new oSearchSuggest();

function doSearch() {
	var keyword = $('#gover_search_key').val();	
	//var keyword = $('#gover_search_key').html();//取列表的第一个元素
	
	alert(keyword);
	$.ajax({
		url : "",
		type : "post",
		data : {"keyword" : keyword},
		success : function(data) {
			//获取显示数据的表格
			var table = $("#content");
			//清楚表格中内容
			$("#content tr").remove();
			//向表格中添加内容
			var html = '';
			//每行最多显示几个商品
			var lineNum = 5;
//			var items = [];
//			for (var i = 0;i < 10;i ++){
//				var item = {};
//				item.description = '描述内容' + (i + 1);
//				item.imgurl = '../day/gem' + (i + 1) + '.png';
//				item.price = 888.88;
//				item.name = keyword + (i + 1);
//				items.push(item);
//			}
//			for (var i = 0; i < items.length; i++) {
//				if (i % lineNum == 0) {
//					html += "<tr>";
//				}				
//				html += "<td>";
//				html += "<img alt='";
//				html += items[i].description;
//				html += "' src='";
//				html += items[i].imgurl;
//				html += "' style='width:120px;height:170px' />";
//				html += "<div>￥";
//				html += items[i].price;
//				html += "<br>";
//				html += items[i].name;
//				html += "</div>";
//				html += "</td>";
//				if (i % lineNum == (lineNum - 1)) {
//					html += "</tr>";
//				}									
//			} 
//			table.append($(html));
		}
	});
}