<%@page import="com.gss.entity.Goods"%>
<%@page import="com.gss.dao.impl.WarehouseManageImpl"%>
<%@page import="com.gss.dao.WarehouseManage"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Sport Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--fonts-->
<link href='http://fonts.useso.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
<!--//fonts-->
	
</head>
<body> 
<!--header-->
		<div class="line">
	
	</div>
	<div class="header">
		<div class="logo">
			<a href="index.html"><img src="images/logo.png" alt="" ></a>
		</div>
		<div  class="header-top">
			<div class="header-grid">
				<ul class="header-in">
				
						<li ><a href="account.html">我的账号   </a> </li>				
					</ul>
					<div class="search-box">
					    <div id="sb-search" class="sb-search">
							<form>
								<input class="sb-search-input" placeholder="Enter your search term..." type="search" name="search" id="search">
								<input class="sb-search-submit" type="submit" value="">
								<span class="sb-icon-search"> </span>
							</form>
						</div>
				    </div>
					<!-- search-scripts -->
					<script src="js/classie.js"></script>
					<script src="js/uisearch.js"></script>
						<script>
							new UISearch( document.getElementById( 'sb-search' ) );
						</script>
					<!-- //search-scripts -->
					<div class="online">
					<a href="./CartService?action=showallcartgoods" >购物车</a>
					</div>
					
					<div class="clearfix"> </div>
			</div>
			
			<div class="header-bottom">
				<div class="h_menu4"><!-- start h_menu4 -->
				<a class="toggleMenu" href="#">Menu</a>
				<ul class="nav">
					<li class="active"><a href="./GoodsService?action=showAllGoods">所有商品</a></li>
					<li class="active"><a href="product.html">休闲</a></li>
					<li><a href="product.html">体育</a></li>		
					<li><a href="product.html">冒险</a>	
					</li>
					<li><a href="product.html">竞技</a></li>
					<li><a href="product.html">动作</a></li>
					<li><a href="product.html">模拟</a></li>
					<li><a href="product.html">竞速</a></li>
					<li><a href="product.html">角色扮演</a></li>
					<li><a href="product.html">更多<i> </i></a>
						<ul>
							<li><a href="contact.html">联系我们</a></li>
							<li><a href="account.html">账号</a></li>
							<li><a href="register.html">注册</a></li>
						</ul>
					</li>
				</ul>
				<script type="text/javascript" src="js/nav.js"></script>
			</div><!-- end h_menu4 -->
					
			<div class="clearfix"> </div>
		</div>
		</div>
		<div class="clearfix"> </div>
	</div>
	<!---->	
<div class="product-grids">
	<div class="container">
	<div class="product-top">
	<c:forEach items = "${allgoods}" var = "good">
	<div class="col-md-4 grid-product-in">	
		<div class=" product-grid"  >	
			<a href="./GoodsService?action=showUnitGoods&goodid=${good.gId}"><img  class="img-responsive "  src ="${good.gPicture[0]}"  style="width:320px;height:180px;" alt=""></a>		
			<div class="shoe-in">
				<h6><a href="single.html">${good.gName}</a></h6>
				<label>￥${good.gPrice}</label>
				<a href="./GoodsService?action=addGoods&goodid=${good.gId}" class="store">加入购物车</a>
			</div>
			
			<b class="plus-on">+</b>
		</div>	
		</div>
	</c:forEach>
		
	<div class="clearfix"> </div>
	</div>	


	</div>
</div>
	<!---->
<!--footer-->
	<div class="footer">
		<div class="col-md-3 footer-left">
			<h4>游戏</h4>
			<div class="run-top">
				<ul class="run-grid">
					<li><a href="product.html">休闲</a></li>
					<li><a href="product.html">体育</a></li>
					<li><a href="product.html">冒险</a></li>
					<li><a href="product.html">竞技</a></li>
					<li><a href="product.html">动作</a></li>
					<li><a href="product.html">竞技</a></li>
					<li><a href="product.html">策略</a></li>
					<li><a href="product.html">角色扮演</a></li>
					<li><a href="product.html">更多游戏</a></li>
				</ul>
				<ul class="run-grid">
					<li><a href="product.html">风格</a></li>
					<li><a href="product.html">侧记</a></li>
					<li><a href="product.html">大事件</a></li>
				</ul>
			<div class="clearfix"> </div>
			</div>
		</div>
		<div class="col-md-3 footer-left left-footer">
			<h4>最新</h4>
			<div class="run-top top-run">
				<ul class="run-grid">
					<li><a href="#">新闻资讯</a></li>
					<li><a href="#">社区</a></li>
					<li><a href="#">视频</a></li>
					<li><a href="single.html">购物</a></li>
					<li><a href="#">资助企业</a></li>
					<li><a href="#">社会责任</a></li>
				</ul>
				<ul class="run-grid">
					<li><a href="#">线下俱乐部</a></li>
					<li><a href="contact.html">门店地图</a></li>
					<li><a href="#">竞技比赛</a></li>
				</ul>
			<div class="clearfix"> </div>
			</div>
		</div>
		<div class="col-md-2 footer-left left-footer">
			<h4>你的账号</h4>
				<ul class="run-grid-in">
					<li><a href="account.html">注册</a></li>
					<li><a href="#">我的游戏</a></li>
					<li><a href="#">我的通知</a></li>
				</ul>
		</div>
		<div class="col-md-4 footer-left left-footer">
			<ul class="social-in">
				<li><a href="#"><i> </i></a></li>
				<li><a href="#"><i class="youtube"> </i></a></li>
				<li><a href="#"><i class="facebook"> </i></a></li>
				<li><a href="#"><i class="twitter"> </i></a></li>
			</ul>
			<div class="letter">
				<h5>通知</h5>
				<span>in the next article</span>
				<h6>NRL: five things we learned this weekend</h6>
				<p>In support of suburban games; Warriors rip</p>
				<a href="register.html" class="sign">SIGN UP AND GET MORE</a>
				
			</div>
			
		</div>
		<div class="clearfix"> </div>
	</div>
</body>
</html>