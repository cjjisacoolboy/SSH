<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="css/jquery-ui.min.css" rel="stylesheet" type="text/css">
		<link href="css/base.css" rel="stylesheet" type="text/css">
		<link href="css/common.css" rel="stylesheet" type="text/css">
		<link href="css/popup.css" rel="stylesheet" type="text/css">
		<link href="css/page.css" rel="stylesheet" type="text/css">
		<script src="js/jquery-2.1.4.min.js" type="text/javascript"></script>
        <link rel="stylesheet" href="css/index.css" type="text/css">
<title>CJJ</title>
</head>
<body>
	  <!--
        	作者：455984146@qq.com
        	时间：2015-11-16
        	描述：导航栏
        -->
        <!--
        -->
	    <div class="fixed-head-wrap">
	        <div class="fixed-head rel">
			    <a href="../index/index.html" class="fixed-logo"></a><!-- logo点击连接 -->          
					<h1>二手车</h1>
					<dl class="select-city fixed-city abs" id="citySelect">
				        <dt id='current_city_id'>长沙</dt>
				        <dd id="cityWrap">
					<!--
                    	添加城市列表
                    -->
			            </dd>
			        </dl>
		        <ul class="nav-list fixed-list abs">       
				    <li><a class="a_buypage " href="../buy/buycar.html">买车</a></li>
					<li><a class="" href="">卖车</a></li>
					<li class="rel" class='php_li_half' id="li_halfprice" style="display:block"><a id='php_half_city_link' href="">付一半</a><b class="ico hot-ico abs"></b></li>				
					<li><a class="" href="">热门活动</a></li>
					<li><a href="" class="" rel="nofollow">服务保障</a></li>
					<li><a href="" target="_blank"><b class="ico app-ico fl" rel="nofollow"></b>下载App</a></li>
					<li><a href="" id="apply_dealer" class="apply" target="_blank">商家申请</a></li>
					<li id="xin_top_userinfo" sname="" >
						<div class="person-wrap" style="top:0px;" >
							<a href="javascript:clear_invalid();show_popup('#popupLogin','#popupLogin .closeJs');" id="loginA">登录</a>/<a href="" id="regA" rel="nofollow">注册</a>
						</div>
					</li>
				</ul>
	  		</div>
		 </div>
		 
		 <!--
         	作者：455984146@qq.com
         	时间：2015-11-19
         	描述：搜索栏
         -->
        <div class="search-bg">
		<div class="bg-img"></div>
		</div>
		<div class="car-sale-wrap">
	<div class="sub-seatch-bar">
		<div class="sub-seatch">
			<div name="nice-select" class="select-tit">
				<script type="text/javascript">
					$(function(){
						$('#chooseNext').click(function(){
							if($('#ulselect').css('display')=='none'){
								$('#b1').addClass('select-on');
								$('#ulselect').css('display','block');
							}else{
								$('#b1').removeClass();
								$('#ulselect').css('display','none');
							}
						});
					});
				</script>
				<input id="chooseNext" type="button" value="车辆" class="Sitem" readonly="">
				<b id="b1" class=""></b>
				<ul id="ulselect" style="display: none;">
					<li class="select-car">车辆</li>
					<li class="select-shop">店铺</li>
				</ul>
			</div>
			<input type="text" data-carcount="1" data-addwidth="12" data-addtop="+6" data-addleft="-12" name="q" class="s-input fl ui-autocomplete-input" id="search_search" data-default="请输入品牌、车系搜索" value="请输入品牌、车系搜索" autocomplete="on">
			<button for="search_search" class="s-btn fl" type="button"><i></i>立即搜索</button>
		</div>
		<form id="searchForm" method="post" action="">
			<input type="hidden" value="" name="b" id="hidden_b">
			<input type="hidden" value="" name="s" id="hidden_s">
			<input type="hidden" value="" name="j" id="hidden_j">
			<input type="hidden" value="" name="p" id="hidden_p">
			<input type="hidden" value="2" name="o" id="hidden_o">
			<input type="hidden" value="10" name="a" id="hidden_a">
			<input type="hidden" value="1" name="i" id="hidden_i">
			<input type="hidden" value="" name="r" id="hidden_r">
			<input type="hidden" value="" name="k" id="hidden_k">
			<input type="hidden" value="" name="l" id="hidden_l">
			<input type="hidden" value="" name="g" id="hidden_g">
			<input type="hidden" value="" name="f" id="hidden_f">
			<input type="hidden" value="" name="c" id="hidden_c">
			<input type="hidden" value="1" name="v" id="hidden_v">
			<input type="hidden" value="" name="u" id="hidden_u">
			<input type="hidden" value="" name="x" id="hidden_x">
			<input type="hidden" value="" name="y" id="hidden_y">
			<div class="sub-brand bt clearfix">
				<ul>
					<li>
						<b class="searched-ico sarw-ico curr"></b>
						<a onclick="hmt_search('brand')" class="searched-ico brand-ico TipBtn TipBtn_hidden_b"> 全部品牌<i class="searched-ico opt"></i></a>
						<div class="frame-bg-one PopBox PopBox_hidden_b" style="display: none;">
							<div class="toptip"></div>
							<ul class="brand-letter clearfix search-brand-letter">
								<li><a data-valueid="0" data-for="hidden_b">全部品牌</a></li>
								<li class="spell spell_A ">A</li>
								<li class="spell spell_B ">B</li>
								<li class="spell spell_C ">C</li>
								<li class="spell spell_D ">D</li>
								<li class="spell spell_F ">F</li>
								<li class="spell spell_G ">G</li>
								<li class="spell spell_H ">H</li>
								<li class="spell spell_J ">J</li>
								<li class="spell spell_K ">K</li>
								<li class="spell spell_L ">L</li>
								<li class="spell spell_M ">M</li>
								<li class="spell spell_N ">N</li>
								<li class="spell spell_O ">O</li>
								<li class="spell spell_P ">P</li>
								<li class="spell spell_Q ">Q</li>
								<li class="spell spell_R ">R</li>
								<li class="spell spell_S ">S</li>
								<li class="spell spell_T ">T</li>
								<li class="spell spell_W ">W</li>
								<li class="spell spell_X ">X</li>
								<li class="spell spell_Y ">Y</li>
								<li class="spell spell_Z ">Z</li>
							</ul>
							<ul class="brand-cars">
								<li style="display: list-item" class="li_spell li_spell_A">
									<a class=" " data-valueid="62" data-spell="A" data-for="hidden_b">奥迪</a>
									<a class=" " data-valueid="68" data-spell="A" data-for="hidden_b">阿斯顿马丁</a>
									<a class=" " data-valueid="5" data-spell="A" data-for="hidden_b">安驰</a>
									<a class=" w120" data-valueid="141" data-spell="A" data-for="hidden_b">AC Schnitzer</a>
									<a class=" " data-valueid="175" data-spell="A" data-for="hidden_b">阿尔法罗密欧</a>
								</li>
								<li style="display: none" class="li_spell li_spell_B">
									<a class=" " data-valueid="59" data-spell="B" data-for="hidden_b">本田</a>
									<a class=" " data-valueid="34" data-spell="B" data-for="hidden_b">别克</a>
									<a class=" " data-valueid="38" data-spell="B" data-for="hidden_b">宝马</a>
									<a class=" " data-valueid="47" data-spell="B" data-for="hidden_b">奔驰</a>
									<a class=" " data-valueid="121" data-spell="B" data-for="hidden_b">比亚迪</a>
									<a class=" " data-valueid="174" data-spell="B" data-for="hidden_b">标致</a>
									<a class=" " data-valueid="93" data-spell="B" data-for="hidden_b">奔腾</a>
									<a class=" " data-valueid="22" data-spell="B" data-for="hidden_b">保时捷</a>
									<a class=" " data-valueid="63" data-spell="B" data-for="hidden_b">北京汽车</a>
									<a class=" " data-valueid="133" data-spell="B" data-for="hidden_b">宝骏</a>
									<a class=" " data-valueid="58" data-spell="B" data-for="hidden_b">北汽制造</a>
									<a class=" " data-valueid="154" data-spell="B" data-for="hidden_b">宾利</a>
									<a class=" " data-valueid="177" data-spell="B" data-for="hidden_b">北汽幻速</a>
									<a class=" " data-valueid="4" data-spell="B" data-for="hidden_b">巴博斯</a>
									<a class=" " data-valueid="6" data-spell="B" data-for="hidden_b">宝龙</a>
									<a class=" " data-valueid="158" data-spell="B" data-for="hidden_b">布加迪</a>
								</li>
								<li style="display: none" class="li_spell li_spell_C">
									<a class=" " data-valueid="115" data-spell="C" data-for="hidden_b">长城</a>
									<a class=" " data-valueid="42" data-spell="C" data-for="hidden_b">长安</a>
									<a class=" " data-valueid="27" data-spell="C" data-for="hidden_b">长丰</a>
									<a class=" " data-valueid="146" data-spell="C" data-for="hidden_b">昌河</a>
								</li>
								<li style="display: none" class="li_spell li_spell_D">
									<a class=" " data-valueid="84" data-spell="D" data-for="hidden_b">大众</a>
									<a class=" " data-valueid="150" data-spell="D" data-for="hidden_b">东风</a>
									<a class=" " data-valueid="80" data-spell="D" data-for="hidden_b">东南</a>
									<a class=" " data-valueid="134" data-spell="D" data-for="hidden_b">帝豪</a>
									<a class=" " data-valueid="7" data-spell="D" data-for="hidden_b">道奇</a>
									<a class=" " data-valueid="45" data-spell="D" data-for="hidden_b">大宇</a>
									<a class=" " data-valueid="72" data-spell="D" data-for="hidden_b">大迪</a>
									<a class=" " data-valueid="108" data-spell="D" data-for="hidden_b">大通</a>
								</li>
								<li style="display: none" class="li_spell li_spell_F">
									<a class=" " data-valueid="89" data-spell="F" data-for="hidden_b">丰田</a>
									<a class=" " data-valueid="98" data-spell="F" data-for="hidden_b">福特</a>
									<a class=" " data-valueid="60" data-spell="F" data-for="hidden_b">菲亚特</a>
									<a class=" " data-valueid="46" data-spell="F" data-for="hidden_b">福田</a>
									<a class=" " data-valueid="85" data-spell="F" data-for="hidden_b">福迪</a>
									<a class=" " data-valueid="123" data-spell="F" data-for="hidden_b">法拉利</a>
									<a class=" " data-valueid="41" data-spell="F" data-for="hidden_b">菲斯克</a>
								</li>
								<li style="display: none" class="li_spell li_spell_G">
									<a class=" " data-valueid="143" data-spell="G" data-for="hidden_b">广汽</a>
									<a class=" " data-valueid="50" data-spell="G" data-for="hidden_b">GMC</a>
									<a class=" " data-valueid="30" data-spell="G" data-for="hidden_b">光冈</a>
									<a class=" " data-valueid="176" data-spell="G" data-for="hidden_b">观致</a>
									<a class=" " data-valueid="189" data-spell="G" data-for="hidden_b">GUMPERT</a>
									<a class=" " data-valueid="226" data-spell="G" data-for="hidden_b">广汽菲克</a>
								</li>
								<li style="display: none" class="li_spell li_spell_H">
									<a class=" " data-valueid="132" data-spell="H" data-for="hidden_b">海马</a>
									<a class=" " data-valueid="54" data-spell="H" data-for="hidden_b">哈飞</a>
									<a class=" " data-valueid="11" data-spell="H" data-for="hidden_b">华泰</a>
									<a class=" " data-valueid="33" data-spell="H" data-for="hidden_b">黄海</a>
									<a class=" " data-valueid="153" data-spell="H" data-for="hidden_b">华普</a>
									<a class=" " data-valueid="3" data-spell="H" data-for="hidden_b">悍马</a>
									<a class=" " data-valueid="66" data-spell="H" data-for="hidden_b">红旗</a>
									<a class=" " data-valueid="179" data-spell="H" data-for="hidden_b">航天</a>
									<a class=" " data-valueid="152" data-spell="H" data-for="hidden_b">汇众</a>
									<a class=" " data-valueid="180" data-spell="H" data-for="hidden_b">海格</a>
									<a class=" " data-valueid="28" data-spell="H" data-for="hidden_b">黑豹</a>
									<a class=" " data-valueid="90" data-spell="H" data-for="hidden_b">华翔</a>
									<a class=" " data-valueid="91" data-spell="H" data-for="hidden_b">华北</a>
									<a class=" " data-valueid="159" data-spell="H" data-for="hidden_b">华阳</a>
									<a class=" " data-valueid="167" data-spell="H" data-for="hidden_b">恒天</a>
									<a class=" " data-valueid="190" data-spell="H" data-for="hidden_b">华颂</a>
								</li>
								<li style="display: none" class="li_spell li_spell_J">
									<a class=" " data-valueid="83" data-spell="J" data-for="hidden_b">吉利</a>
									<a class=" " data-valueid="97" data-spell="J" data-for="hidden_b">江淮</a>
									<a class=" " data-valueid="139" data-spell="J" data-for="hidden_b">Jeep</a>
									<a class=" " data-valueid="87" data-spell="J" data-for="hidden_b">金杯</a>
									<a class=" " data-valueid="137" data-spell="J" data-for="hidden_b">江铃</a>
									<a class=" " data-valueid="173" data-spell="J" data-for="hidden_b">捷豹</a>
									<a class=" " data-valueid="109" data-spell="J" data-for="hidden_b">吉奥</a>
									<a class=" " data-valueid="149" data-spell="J" data-for="hidden_b">江南</a>
									<a class=" " data-valueid="64" data-spell="J" data-for="hidden_b">金龙</a>
									<a class=" " data-valueid="161" data-spell="J" data-for="hidden_b">九龙</a>
									<a class=" " data-valueid="76" data-spell="J" data-for="hidden_b">金程</a>
								</li>
								<li style="display: none" class="li_spell li_spell_K">
									<a class=" " data-valueid="120" data-spell="K" data-for="hidden_b">凯迪拉克</a>
									<a class=" " data-valueid="61" data-spell="K" data-for="hidden_b">克莱斯勒</a>
									<a class=" " data-valueid="14" data-spell="K" data-for="hidden_b">开瑞</a>
									<a class=" " data-valueid="182" data-spell="K" data-for="hidden_b">卡威</a>
									<a class=" " data-valueid="188" data-spell="K" data-for="hidden_b">凯翼</a>
									<a class=" " data-valueid="185" data-spell="K" data-for="hidden_b">凯马汽车</a>
									<a class=" " data-valueid="86" data-spell="K" data-for="hidden_b">卡尔森</a>
									<a class=" " data-valueid="65" data-spell="K" data-for="hidden_b">柯尼赛格</a>
									<a class=" " data-valueid="136" data-spell="K" data-for="hidden_b">凯佰赫</a>
									<a class=" " data-valueid="181" data-spell="K" data-for="hidden_b">KTM</a>
									<a class=" " data-valueid="220" data-spell="K" data-for="hidden_b">康迪</a>
								</li>
								<li style="display: none" class="li_spell li_spell_L">
									<a class=" " data-valueid="94" data-spell="L" data-for="hidden_b">铃木</a>
									<a class=" " data-valueid="112" data-spell="L" data-for="hidden_b">路虎</a>
									<a class=" " data-valueid="31" data-spell="L" data-for="hidden_b">雷克萨斯</a>
									<a class=" " data-valueid="99" data-spell="L" data-for="hidden_b">力帆</a>
									<a class=" " data-valueid="164" data-spell="L" data-for="hidden_b">陆风</a>
									<a class=" " data-valueid="8" data-spell="L" data-for="hidden_b">雷诺</a>
									<a class=" " data-valueid="16" data-spell="L" data-for="hidden_b">莲花</a>
									<a class=" " data-valueid="88" data-spell="L" data-for="hidden_b">林肯</a>
									<a class=" " data-valueid="130" data-spell="L" data-for="hidden_b">劳斯莱斯</a>
									<a class=" " data-valueid="117" data-spell="L" data-for="hidden_b">兰博基尼</a>
									<a class=" " data-valueid="49" data-spell="L" data-for="hidden_b">路特斯</a>
									<a class=" " data-valueid="186" data-spell="L" data-for="hidden_b">陆地方舟</a>
									<a class=" " data-valueid="219" data-spell="L" data-for="hidden_b">罗孚</a>
								</li>
								<li style="display: none" class="li_spell li_spell_M">
									<a class=" " data-valueid="145" data-spell="M" data-for="hidden_b">马自达</a>
									<a class=" " data-valueid="104" data-spell="M" data-for="hidden_b">名爵</a>
									<a class=" " data-valueid="26" data-spell="M" data-for="hidden_b">迷你</a>
									<a class=" " data-valueid="151" data-spell="M" data-for="hidden_b">玛莎拉蒂</a>
									<a class=" " data-valueid="165" data-spell="M" data-for="hidden_b">美亚</a>
									<a class=" " data-valueid="75" data-spell="M" data-for="hidden_b">迈凯伦</a>
									<a class=" " data-valueid="13" data-spell="M" data-for="hidden_b">摩根</a>
									<a class=" " data-valueid="29" data-spell="M" data-for="hidden_b">迈巴赫</a>
								</li>
								<li style="display: none" class="li_spell li_spell_N">
									<a class=" " data-valueid="35" data-spell="N" data-for="hidden_b">纳智捷</a>
									<a class=" " data-valueid="170" data-spell="N" data-for="hidden_b">南汽</a>
								</li>
								<li style="display: none" class="li_spell li_spell_O">
									<a class=" " data-valueid="128" data-spell="O" data-for="hidden_b">欧宝</a>
									<a class=" " data-valueid="118" data-spell="O" data-for="hidden_b">讴歌</a>
								</li>
								<li style="display: none" class="li_spell li_spell_P">
									<a class=" " data-valueid="148" data-spell="P" data-for="hidden_b">帕加尼</a>
								</li>
								<li style="display: none" class="li_spell li_spell_Q">
									<a class=" " data-valueid="129" data-spell="Q" data-for="hidden_b">起亚</a>
									<a class=" " data-valueid="155" data-spell="Q" data-for="hidden_b">奇瑞</a>
									<a class=" " data-valueid="21" data-spell="Q" data-for="hidden_b">庆铃</a>
								</li>
								<li style="display: none" class="li_spell li_spell_R">
									<a class=" " data-valueid="15" data-spell="R" data-for="hidden_b">日产</a>
									<a class=" " data-valueid="23" data-spell="R" data-for="hidden_b">荣威</a>
									<a class=" " data-valueid="56" data-spell="R" data-for="hidden_b">瑞麒</a>
								</li>
								<li style="display: none" class="li_spell li_spell_S">
									<a class=" " data-valueid="92" data-spell="S" data-for="hidden_b">斯柯达</a>
									<a class=" " data-valueid="147" data-spell="S" data-for="hidden_b">三菱</a>
									<a class=" " data-valueid="122" data-spell="S" data-for="hidden_b">Smart</a>
									<a class=" " data-valueid="156" data-spell="S" data-for="hidden_b">斯巴鲁</a>
									<a class=" " data-valueid="82" data-spell="S" data-for="hidden_b">双龙</a>
									<a class=" " data-valueid="74" data-spell="S" data-for="hidden_b">双环</a>
									<a class=" " data-valueid="157" data-spell="S" data-for="hidden_b">萨博</a>
									<a class=" " data-valueid="18" data-spell="S" data-for="hidden_b">陕汽通家</a>
									<a class=" " data-valueid="96" data-spell="S" data-for="hidden_b">赛宝</a>
									<a class=" " data-valueid="125" data-spell="S" data-for="hidden_b">世爵</a>
								</li>
								<li style="display: none" class="li_spell li_spell_T">
									<a class=" " data-valueid="44" data-spell="T" data-for="hidden_b">天津一汽</a>
									<a class=" " data-valueid="184" data-spell="T" data-for="hidden_b">特斯拉</a>
									<a class=" " data-valueid="12" data-spell="T" data-for="hidden_b">天马</a>
									<a class=" " data-valueid="24" data-spell="T" data-for="hidden_b">通宝</a>
									<a class=" " data-valueid="111" data-spell="T" data-for="hidden_b">通田</a>
								</li>
								<li style="display: none" class="li_spell li_spell_W">
									<a class=" " data-valueid="51" data-spell="W" data-for="hidden_b">五菱</a>
									<a class=" " data-valueid="135" data-spell="W" data-for="hidden_b">沃尔沃</a>
									<a class=" " data-valueid="53" data-spell="W" data-for="hidden_b">威麟</a>
									<a class=" " data-valueid="32" data-spell="W" data-for="hidden_b">五十铃</a>
									<a class=" " data-valueid="114" data-spell="W" data-for="hidden_b">威兹曼</a>
									<a class=" " data-valueid="124" data-spell="W" data-for="hidden_b">万丰</a>
								</li>
								<li style="display: none" class="li_spell li_spell_X">
									<a class=" " data-valueid="55" data-spell="X" data-for="hidden_b">现代</a>
									<a class=" " data-valueid="73" data-spell="X" data-for="hidden_b">雪佛兰</a>
									<a class=" " data-valueid="71" data-spell="X" data-for="hidden_b">雪铁龙</a>
									<a class=" " data-valueid="52" data-spell="X" data-for="hidden_b">西雅特</a>
									<a class=" " data-valueid="37" data-spell="X" data-for="hidden_b">新凯</a>
									<a class=" " data-valueid="178" data-spell="X" data-for="hidden_b">新龙马</a>
									<a class=" " data-valueid="171" data-spell="X" data-for="hidden_b">新大地</a>
								</li>
								<li style="display: none" class="li_spell li_spell_Y">
									<a class=" " data-valueid="119" data-spell="Y" data-for="hidden_b">一汽</a>
									<a class=" " data-valueid="160" data-spell="Y" data-for="hidden_b">英菲尼迪</a>
									<a class=" " data-valueid="169" data-spell="Y" data-for="hidden_b">英伦</a>
									<a class=" " data-valueid="102" data-spell="Y" data-for="hidden_b">依维柯</a>
									<a class=" " data-valueid="172" data-spell="Y" data-for="hidden_b">野马</a>
									<a class=" " data-valueid="106" data-spell="Y" data-for="hidden_b">永源</a>
									<a class=" " data-valueid="187" data-spell="Y" data-for="hidden_b">英致</a>
									<a class=" " data-valueid="43" data-spell="Y" data-for="hidden_b">云豹</a>
									<a class=" " data-valueid="110" data-spell="Y" data-for="hidden_b">英格尔</a>
									<a class=" " data-valueid="140" data-spell="Y" data-for="hidden_b">云雀</a>
								</li>
								<li style="display: none" class="li_spell li_spell_Z">
									<a class=" " data-valueid="77" data-spell="Z" data-for="hidden_b">中华</a>
									<a class=" " data-valueid="100" data-spell="Z" data-for="hidden_b">众泰</a>
									<a class=" " data-valueid="70" data-spell="Z" data-for="hidden_b">中兴</a>
									<a class=" " data-valueid="67" data-spell="Z" data-for="hidden_b">中顺</a>
									<a class=" " data-valueid="57" data-spell="Z" data-for="hidden_b">中誉</a>
									<a class=" " data-valueid="103" data-spell="Z" data-for="hidden_b">中欧</a>
								</li>
							</ul>
						</div>
					</li>
					<li>
						<a onclick="hmt_search('serial')" class="carm TipBtn light TipBtn_hidden_s">
							<span>全部车系</span><i class="searched-ico n-opt"></i>
						</a>
						<div class="frame-bg-two PopBox PopBox_hidden_s" id="search_serial" style="display: none;">
							<div class="toptip"></div>
							<a data-valueid="0" data-for="hidden_s" class="h1" href="javascript:;">全部车系</a>
						</div>
					</li>
					<li>
						
					</li>
					<li>
						<a onclick="hmt_search('price')" class="searched-ico price-ico carr TipBtn TipBtn_hidden_p" id="price_tipbtn">全部价格<i class="searched-ico opt"></i></a>
						<div class="frame-bg-four PopBox PopBox_hidden_p" style="display: none;">
							<div class="toptip"></div>
							<h1><a data-valueid="0" data-for="hidden_p">全部价格</a></h1>
							<ul>
								<li>
									<a data-valueid="0-5" data-for="hidden_p" class="">5万以下</a>
									<a data-valueid="5-10" data-for="hidden_p" class="">5-10万</a>
									<a data-valueid="10-15" data-for="hidden_p" class="">10-15万</a>
									<a data-valueid="15-20" data-for="hidden_p" class="">15-20万</a>
									<a data-valueid="20-30" data-for="hidden_p" class="">20-30万</a>
									<a data-valueid="30-50" data-for="hidden_p" class="">30-50万</a>
									<a data-valueid="50-" data-for="hidden_p" class="">50万以上</a>
								</li>
							</ul>
							<div class="other-price clearfix">
								<span>自定义价格</span>
								<input type="text" maxlength="12" class="txt" value="" id="price_s" name="price_s"> 万<span>-</span>
								<input type="text" value="" id="price_e" name="price_e" class="txt"> 万
								<input type="button" maxlength="12" class="confirm-btn" id="customer_price" value="确定"><span style="display:none" class="error" id="other-price-error">请输入正确的价格</span>
							</div>
						</div>
					</li>
					<li>
						
					</li>
				</ul>
			</div>
			
			<div class="car-source">
				<ul>
					<li>
						<input type="checkbox" checked="checked" class="hidden-access" id="sourceCheck_1" value="1" name="v">
						<label class="searched-ico source-default source-active" for="v"><span class="button-text">全部车源</span></label>
					</li>
					<li>
						<input type="checkbox" class="hidden-access" id="sourceCheck_2" value="2" name="v">
						<label class="source-default " for="v">
							<span class="button-text">无事故承诺</span>
						</label>
					</li>
					<li>
						<input type="checkbox" class="hidden-access" id="sourceCheck_3" value="3" name="v">
						<label class="source-default " for="v">
							<span class="button-text">原厂质保</span>
						</label>
					</li>
					<li>
						<input type="checkbox" class="hidden-access" id="sourceCheck_4" value="4" name="v">
						<label class="source-default " for="v">
							<span class="button-text">商家质保</span>
						</label>
					</li>
					<li>
						<input type="checkbox" class="hidden-access" id="sourceCheck_6" value="6" name="v">
						<label class="source-default " for="v">
							<span class="button-text">个人车源</span>
						</label>
					</li>
				</ul>
				<a style="display:none" class="clear-condition" href="javascript:;"><b class="searched-ico"></b>清除全部条件</a>
			</div>
		</form>
	</div>
	<div id="search_container" class="w1100">
		<div class="car-upper mb20">
			<span class="nber s-icon">小要为您找到<em>13161</em>辆车</span>
			<span class="opt ">
            <a class="view_a active down" data-up="10" data-down="10" name="view_a">默认排序</a>
            <a class="view_a s-icon up" data-up="6" data-down="5" name="view_a">车龄</a>
            <a class="view_a s-icon up" data-up="3" data-down="4" name="view_a">价格</a>
            <a class="view_a s-icon up" data-up="7" data-down="8" name="view_a">里程</a>
        </span>
			<span class="cut">
            <a class="view_o s-icon vtc active" data-o="2" name="view_o"></a>
            <a class="view_o s-icon crs " data-o="1" name="view_o"></a>
        </span>
		</div>
		<div class="car-box clearfix">
			<!--
            	作者：455984146@qq.com
            	时间：2015-11-20
            	描述：一共20辆车一页
            	从后台读取数据
            -->
            <s:iterator value="list">
			<div style="" class="car-vtc vtc-border ">
				<div class="vtc-img">
					<a target="_blank" data-position="1" data-seriesid="382" data-brandid="94" data-cityid="1301" href="http://che.xin.com/11291492.html"><img width="264" height="176" class="lazy" alt="铃木 雨燕 2011款 1.5 自动 标准型" data-original="http://img2.xin.com/xin/201511/1316/56459888a4aed150261_18.jpg" src="http://img2.xin.com/xin/201511/1316/56459888a4aed150261_18.jpg" style="display: inline;"></a>
				</div>
				<div class="vtc-info">
					<p><a target="_blank" data-position="1" data-seriesid="382" data-brandid="94" data-cityid="1301" title="铃木 雨燕 2011款 1.5 自动 标准型" href="http://che.xin.com/11291492.html"><s:property value="carName"/></a></p>
					<div class="box">
						<ol>
							<li>上牌</li>
							<li>表显里程</li>
							<li>变速箱</li>
							<li>销售城市</li>
						</ol>
						<ul>
							<li>2010/12</li>
							<li>3.39万公里</li>
							<li>自动</li>
							<li>长沙</li>
						</ul>
					</div>
					<div class="back"><img src="http://imgs.xin.com/xin/images/car-sale/promise_ico09.png">
					</div>
				</div>
				<div class="vtc-money">
					<em>¥6.88万</em>
					<div class="msg-price">
						<p class="price-car">
							新车价格：<del>8.66万</del>(含税0.68万)</p>
					</div>
					<span>便宜：1.78万</span>
				</div>
				<div class="vtc-house">
					<span class="s-icon house">
                <a class="s-icon star" data-carid="11291492" data-css="active" name="carFavorite">加入收藏</a>
                </span>
					<input type="checkbox" class="hidden-access" value="11291492" name="carCheck">
					<label class="carCheck state-default collect-ico" for="carCheck">
						<span class="button-text">加入对比</span>
					</label>
				</div>
			</div>
			</s:iterator>
			
			<div style="border-bottom:1px solid #d9d9d9;" class="car-vtc vtc-border ">
				<div class="vtc-img">
					<a target="_blank" data-position="20" data-seriesid="1176" data-brandid="55" data-cityid="1301" href="http://che.xin.com/11304785.html"><img width="264" height="176" class="lazy" alt="现代 新胜达 2013款 3.0 自动 尊享版7座四驱 欧Ⅴ" data-original="http://img2.xin.com/xin/201511/1811/564bef59bb15a157972_18.jpg" src="http://img2.xin.com/xin/201511/1811/564bef59bb15a157972_18.jpg" style="display: inline;"></a>
				</div>
				<div class="vtc-info">
					<p><a target="_blank" data-position="20" data-seriesid="1176" data-brandid="55" data-cityid="1301" title="现代 新胜达 2013款 3.0 自动 尊享版7座四驱 欧Ⅴ" href="http://che.xin.com/11304785.html">现代 新胜达 2013款 3.0 自动 尊享版7座四驱 欧Ⅴ</a></p>
					<div class="box">
						<ol>
							<li>上牌</li>
							<li>表显里程</li>
							<li>变速箱</li>
							<li>销售城市</li>
						</ol>
						<ul>
							<li>2013/03</li>
							<li>7.34万公里</li>
							<li>自动</li>
							<li>长沙</li>
						</ul>
					</div>
					<div class="back"><img src="http://imgs.xin.com/xin/images/car-sale/promise_ico09.png">
					</div>
				</div>
				<div class="vtc-money">
					<em>¥22.80万</em>
					<div class="msg-price">
						<p class="price-car">
							新车价格：<del>36.67万</del>(含税2.89万)</p>
					</div>
					<span>便宜：13.87万</span>
				</div>
				<div class="vtc-house">
					<span class="s-icon house">
                <a class="s-icon star" data-carid="11304785" data-css="active" name="carFavorite">加入收藏</a>
                </span>
					<input type="checkbox" class="hidden-access" value="11304785" name="carCheck">
					<label class="carCheck state-default collect-ico" for="carCheck">
						<span class="button-text">加入对比</span>
					</label>
				</div>
			</div>
		</div>
		<!-- 搜索列表页分页代码 -->
		<div class="con-page search_page_link">
			<span class="page-current">1</span>
			<a data-page="2" name="view_i">2</a>
			<a data-page="3" name="view_i">3</a>
			<a data-page="4" name="view_i">4</a>
			<a data-page="5" name="view_i">5</a>
			<span>...</span>
			<a data-page="659" name="view_i">659</a>
			<a data-page="2" name="view_i">下一页</a>
		</div>
		<div id="creditYes" class="popup-wrap">
			<div class="inner">
				<div class="tip-con">
					<p>温馨提示
						<a class="close_pop closeJs abs" href="#"></a>
					</p>
					<img src="http://imgs.xin.com/xin/images/popup/people.png">
					<em class="sus-tip">提交成功</em>
					<b class="sh-tip">请保持手机畅通，稍后将接到商家来电。</b>
					<a class="btn_dload closeJs" href="javascript:_smq.push(['custom', '免费电话', '输入号码', '提交成功']);$('#creditYes .closeJs').click();">知道了</a>
				</div>
			</div>
		</div>
		<div id="dhPrice" class="popup-wrap">
			<div class="inner">
				<div class="hpop-new">
					<a class="ico_pop xBtn2 closeJs" href="#">关闭</a>
					<div class="hpop-pic">
						<img src="http://imgs.xin.com/xin/images/half/hpop_pic1.png">
						<div class="hpop-con">
							<h1>付一半 全新的购车方案</h1>
							<p>首付一半，即可把心爱的好车开走。</p>
							<p>“付一半”产品帮助您使用更少的现金，购买到更好的车辆，升级您的汽车生活。</p>
						</div>
						<ul>
							<li>
								<img src="http://imgs.xin.com/xin/images/half/pic_1.png">
								<div class="txt">
									<p>首付一半</p>
									<span>这是一款为期两年的分期购车计划，今天您只需要首付一半，即可把爱车开走</span>
								</div>
							</li>
							<li>
								<img src="http://imgs.xin.com/xin/images/half/pic_2.png">
								<div class="txt">
									<p>0月供</p>
									<span>两年无月供，生活0压力</span>
								</div>
							</li>
							<li>
								<img src="http://imgs.xin.com/xinwap/images/sale/PIC6.png?v=2015111810">
								<div class="txt">
									<p>审批快</p>
									<span>最快60分钟出具审批结果</span>
								</div>
							</li>
							<li>
								<img src="http://imgs.xin.com/xin/images/half/pic_3.png">
								<div class="txt">
									<p>尾款灵活</p>
									<span>两年后合约到期时，您可以选择补齐尾款完成购买；或者，您也可以选择不支付车辆尾款，将车辆退还给优信二手车</span>
								</div>
							</li>
							<li>
								<img src="http://imgs.xin.com/xin/images/half/PIC_4.png">
								<div class="txt">
									<p>无门槛</p>
									<span>无户籍、房产、收入、职业等限制，只需提供本人身份证、借记卡、驾照（限购城市需要本人有购车指标）</span>
								</div>
							</li>
							<li>
								<img src="http://imgs.xin.com/xin/images/half/pic_5.png">
								<div class="txt">
									<p>质量保证</p>
									<span>所有“付一半”车辆均经过387项严格检测，享受“无重大事故承诺”及“15天包退承诺”，可选一年或两年不限里程质保</span>
								</div>
							</li>
						</ul>
						<div class="hpop-con">
							<img src="http://imgs.xin.com/xin/images/half/hpop_003.png?v=2015111810">
						</div>
						<a id="php_lookup_now" class="h-btn" href="javascript:void(0)">马上看看</a>
					</div>

				</div>
			</div>
		</div>
		<!--半价车详情页页面结束-->
	</div>
</div>
	<!--
    	作者：455984146@qq.com
    	时间：2015-11-17
    	描述：页尾
    -->
    <div class="footer-wrap">
		<div class="footer">
			<div class="contact_new">
				<a href="aboutus/"  rel="nofollow">关于我们</a>
				<a href="contactus/"  rel="nofollow">联系我们</a>
				<a href="joinus/" rel="nofollow">加入我们</a>
				<a href="help/"  rel="nofollow">帮助中心</a>
				<a href="feedback/"  rel="nofollow">用户反馈</a>
				<a href="finance/"  rel="nofollow">我要金融</a>
			</div>
			<span>业务合作单位：我估(上海) 信息科技有限公司/我要拍（北京）二手车鉴定评估有限公司</span>
            <div class="footer3">
				<p>copyright@2015 <strong><a href="">我要互联</a></strong> all rights reserved 版权所有 我要互联（北京）信息技术有限公司
				<em>经营许可证编号：京ICP证120819号</em>
                </p>
				<!--可信网站开始-->
				<script src="http://kxlogo.knet.cn/seallogo.dll?sn=e15102111010561082vc83000000&size=0"></script>
				<!--可信网站结束-->
				<!--诚信网站开始-->
				<a id='___szfw_logo___' class="bot-logo" href='https://credit.szfw.org/CX20151104012121580123.html' target='_blank'><img src='http://imgs.xin.com/xin/images/home/bot_logo2.png' border='0' /></a>
               <script type='text/javascript'>(function(){ document.getElementById('___szfw_logo___').oncontextmenu = function(){ return false; } })();</script>
               <!--诚信网站结束-->
            </div>            
			<div class="index-code fr clearfix"> 
				<img src="../images/code.jpg" height="100" width="100">
				<p class="scan-txt fl rel">
					关注我要二手车<br />微信公众号
				</p>
			</div>
			<div class="index-code2 fl clearfix">
				<img src="http://imgs.xin.com/xin/images/common/code_1.jpg" height="100" width="100">
				<p class="scan-txt fr rel">
					扫描我，即可下载<br />我要二手车手机版
				</p>
			</div>
		</div>
	</div>
		
	
</body>
</html>