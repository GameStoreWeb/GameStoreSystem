<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" type="text/css" href="css/style2.css" />
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="keywords"
	content="Sport Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
	
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 



</script>
<script type="text/javascript">
		function doDelete(){
			if(confirm("是否取消该订单?")){
				location.href = "./WarehouseService?oid=&action=cancelOrder";
			}
		}
		function doShowOrder(oid) {
			location.href = "./WarehouseService?oid=" + oid + "&action=showUnitOrder";
		}
</script>
<!--fonts-->
<link
	href='http://fonts.useso.com/css?family=Open+Sans:400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<!--//fonts-->

<link href="css/stylecart.css" rel='stylesheet' type='text/css' />
</head>
<body>
	<!--header-->
	<div class="line"></div>
	<div class="header">
		<div class="logo">
			<a href="index.jsp"><img src="images/logo.png" alt=""></a>
		</div>
		<div class="header-top">
			<div class="header-grid">
				<ul class="header-in">
					<li><a href="./sellerInfo.jsp">${seller.sName } </a></li>
				</ul>
				<div class="search-box">
					<div id="sb-search" class="sb-search">
						<form>
							<input class="sb-search-input"
								placeholder="Enter your search term..." type="search"
								name="search" id="search"> <input
								class="sb-search-submit" type="submit" value=""> <span
								class="sb-icon-search"> </span>
						</form>
					</div>
				</div>
				<!-- search-scripts -->
				<script src="js/classie.js"></script>
				<script src="js/uisearch.js"></script>
				<script>
					new UISearch(document.getElementById('sb-search'));
				</script>
				<!-- //search-scripts -->
				<div class="online">
					<a href="single.html">在线商城</a>
				</div>

				<div class="clearfix"></div>
			</div>

			<div class="header-bottom">
				<div class="h_menu4">
					<!-- start h_menu4 -->
					<a class="toggleMenu" href="#">Menu</a>
					<ul class="nav">
						<li class="active"><a href="product.html">休闲</a></li>
						<li><a href="product.html">体育</a></li>
						<li><a href="product.html">冒险</a></li>
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
							</ul></li>
					</ul>
					<script type="text/javascript" src="js/nav.js"></script>
				</div>
				<!-- end h_menu4 -->

				<div class="clearfix"></div>
			</div>
		</div>
		<div class="clearfix"></div>
	</div>
	<!---->

	<div class="main">
		<div class="container">
			<div class="check_box">
				<div class="col-md-9 cart-items">
					<h1 style="color: red;">我的订单</h1>
					<div class="right_content" style="overflow:hidden;">
						<table id="rounded-corner">
							<tbody>
								<tr>
									<td style="font-weight: bold;">订单号</td>
									<td style="font-weight: bold;">买家名称</td>
									<td style="font-weight: bold;">收货地址</td>
									<td style="font-weight: bold;">订单日期</td>
									<td style="font-weight: bold;">订单状态</td>
									<td style="font-weight: bold;">操作</td>
								</tr>
								<c:forEach items="${sellerOrders }" var="order">
									<tr>
										<td><a href="javascript:doShowOrder('${order.oId}')" >${order.oId }</a></td>
										<td>${order.sId }</td>
										<td>${order.oAddress }</td>
										<td>${order.startDate }</td>
										<c:choose>
											<c:when test="${order.oIsDeliver == true }">
												<td>已发货</td>
											</c:when>
											<c:otherwise>
												<td>待发货</td>
											</c:otherwise>
										</c:choose>
										<td>
											<a href="javascript:doUpdate(${order.oId})">修改</a>
											<a href="javascript:void(0)" onclick="doDelete()">&nbsp;取消订单</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<br>
					</div>
					<%-- <script>
						$(document).ready(function(c) {
							$('.close1').on('click', function(c) {
								$('.cart-header').fadeOut('slow', function(c) {
									$('.cart-header').remove();
								});
							});
						});
					</script>
					<c:forEach items="${sellerOrders }" var="order">
						<div class="cart-header" style="float: left;">
							<div class="close1"></div>
							<div class="cart-sec simpleCart_shelfItem">
								<div style="text-align: center; float: left;">
									<a href="./WarehouseService?action=showUnitOrder">${order.oId }&nbsp;&nbsp;&nbsp;</a>
								</div>
								<div style="float:right;">
									<h3>
										<a href="#">${good.gName }</a>
									</h3>
									<ul class="qty">
										<li><p>规格：${good.gStandard }</p></li>
										<li><p>优惠：${good.gDiscount }</p></li>
									</ul>
									<h5>${good.gDetail }</h5><br>
									<p>单价 : ￥${good.gPrice }</p>
								</div>
								<div class="clearfix"></div>
							</div>
						</div>
					</c:forEach> --%>



				</div>
				<div class="col-md-3 cart-total">
					<a class="continue">订单管理</a>
					<div class="price-details" style="text-align: center;">
						<h3><a href="./WarehouseService?action=showSellerOrders">我的订单</a></h3>
						<div class="clearfix"></div>
					</div>

					<a class="order" href="#">商品管理</a>
					<div class="price-details" style="text-align: center;">
						<h3>
							<a href="./WarehouseService?action=showSellerProducts">我的商品</a>
						</h3>
						<div class="clearfix"></div>
						<h3>
							<a href="./addProducts.jsp">添加商品</a>
						</h3>
						<div class="clearfix"></div>
					</div>
				</div>
				<div class="clearfix"></div>
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
				<div class="clearfix"></div>
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
				<div class="clearfix"></div>
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
		<div class="clearfix"></div>
	</div>
</body>
</html>