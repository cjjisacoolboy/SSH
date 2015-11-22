function oSearchSuggest(){	
	//初始化查询框，为查询输入框绑定keyup和blur事件，注意keyup绑定的sendKeyWord函数在后面有定义
	var keyField = $('#gover_search_key');	//关键字域
	var suggestWrap = $('#gov_search_suggest'); //自动下拉空白框
	var key = "";
	var searchinit = function() {   //初始化
		keyField.bind('keyup', sendKeyWord);
		keyField.bind('blur', function() {
			setTimeout(hideSuggest, 100);
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
			sendKeyWordToBack(valText,obj); //是用ajax从后台查找数据
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
function sendKeyWordToBack(keyword,obj) {  
	$.ajax( {
		type : "post",
		url : "demo/searchTest.action",
		data : {"keyword" : keyword},
		async : true,
		success : function(data) {	
		var object = eval('(' + data + ')');
		//alert(obj.data);
		var carList = object.list;
		var length = 5;
		if(carList.length < 5){
			length = carList.length;
		}
		//alert(carList);
		var aData = []; 
		for (var i = 0;i < length;i ++) {
			var item = {};
			item.id = i + 1;
			item.name = carList[i].carName;
			//alert(item.name);
			aData.push(item);
		}
		//将返回的数据传递给实现搜索输入框的输入提示js类
		obj.dataDisplay(aData);	
		}
	});
}