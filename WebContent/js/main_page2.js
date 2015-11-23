$(document).ready(function(){

    //点击选项
   
    var length = $("#liList").children("li").length - 1;
    $("#chooseNext").on("click",function(){
      var sIndex = $("#liList").children("li.selected").index();
      if(sIndex == length){
          sIndex = -1;
      }
      $("#liList").children().removeClass("select-car");
      $("#liList").children("li:eq(" + (sIndex + 1) + " )").addClass("select-car");
    })

   
//首页--搜索框-搜索按钮点击事件

	$(".search-btn").click(function () {
        var a_for = $(this).attr('for');
        var input = $("#" + a_for);
        var ui_item = input.data("ui-autocomplete").selectedItem;
        var v = input.val();
         _hmt.push(['_trackEvent', 'InternalSearch', 'IS_'+v]);
        v = v.replace(/\s/g, "");
        var query = "/s/";
        var history = '';
        if (ui_item) {
            query = ui_item.query;
            history = '{"label": "' + ui_item.label + '","num": "-1","query": "' + ui_item.query + '","value": "' + ui_item.value + '"}';
        }
        if (v != "" && v != input.data('default')) {
            query += '?q=' + v;
            if (!history) {
                history = '{"label": "' + v + '","num": "-1","query": "' + query + '","value": "' + v + '"}';
            }
        }
        var sl = $('.Sitem').val();
        if (sl == '车辆') {
            search_log();
            window.location.href = '/' + TOP_INFO.location.ename + query;

        } else {
            if (!v || v == '请输入店铺名称搜索') {
                $('.Sitem').attr('value', '车辆');
                $('.Hsearch').attr('value', '请输入品牌、车系搜索');
                window.location.reload();
                return false;
            }
            search_shop_log(history);
            $.post('/apis/apis_suggest/shop', {'w': v, 'type': 'button'}, function (data) {
                if (data == '404') {
                    var hf = '/search/shop_error/' + v;
                } else {
                    var hf = data;
                }
                //alert(hf);return false;
                window.location.href = hf;
            });

        }
        //添加搜索历史

    });
});
    