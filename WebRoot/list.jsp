<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>乐玩线上商城后台管理系统 | 所有商家信息界面</title>	
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link rel="stylesheet" type="text/css" href="css/style2.css" />
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jconfirmaction.jquery.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('.ask').jConfirmAction();
		});
	</script>
	<script type="text/javascript">
		function doDelete(sid){
			if(confirm("是否删除所选商家信息?")){
				location.href = "./AccountService?sid=" + sid + "&action=deleteSeller";
			}
		}
	</script>
	<script type="text/javascript">
		function doUpdate(sid){
			location.href = "./AccountService?sid=" + sid + "&action=getSeller";
		}
	</script>
	<script type="text/javascript">
	function goPage(pageNo){
		location.href="./AccountService?action=showAllSeller&pageNo="+pageNo;
	}
	</script>
 	<!-- 会员样式-->
	<style>
	#popupcontent{   position: absolute;   visibility: hidden;   overflow: hidden;   border:1px solid #CCC;   background-color:#F9F9F9;   border:1px solid #333;   padding:5px;}
	</style>
	
	<script>
	var baseText = null; function showPopup(w,h){   var popUp = document.getElementById("popupcontent");    popUp.style.top = "350px";   popUp.style.left = "250px";   popUp.style.width = w + "px";   popUp.style.height = h + "px";    if (baseText == null) baseText = popUp.innerHTML;   popUp.innerHTML = baseText +       "<div id=\"statusbar\"></div>";    var sbar = document.getElementById("statusbar");   sbar.style.marginTop = (parseInt(h)-60) + "px";   popUp.style.visibility = "visible";}
	function hidePopup(){   var popUp = document.getElementById("popupcontent");   popUp.style.visibility = "hidden";}
	</script>

<!-- 取单样式-->
<style>
#popupcontent1{   position: absolute;   visibility: hidden;   overflow: hidden;   border:1px solid #CCC;   background-color:#F9F9F9;   border:1px solid #333;   padding:5px;}
</style>
<script>
var baseText1 = null; function showPopup1(w,h){   var popUp1 = document.getElementById("popupcontent1");    popUp1.style.top = "350px";   popUp1.style.left = "250px";   popUp1.style.width = w + "px";   popUp1.style.height = h + "px";    if (baseText1 == null) baseText1 = popUp1.innerHTML;   popUp1.innerHTML = baseText1 +       "<div id=\"statusbar1\"></div>";    var sbar1 = document.getElementById("statusbar1");   sbar1.style.marginTop = (parseInt(h)-60) + "px";   popUp1.style.visibility = "visible";}
function hidePopup1(){   var popUp1 = document.getElementById("popupcontent1");   popUp1.style.visibility = "hidden";}
</script>
<META content="MSHTML 6.00.2900.2838" name=GENERATOR>
	
	
</head>
	<body>
		
		<div class="right_content" style="overflow:hidden;">
			<h2>商家信息</h2>
			<table id="rounded-corner">
				<thead>
					<tr>
						<th scope="col" class="rounded">商家ID</th>
						<th scope="col" class="rounded">商家名称</th>
						<th scope="col" class="rounded">商家地址</th>
						<th scope="col" class="rounded-q4">商家电话</th>
						<th scope="col" class="rounded-q4">操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${page.list}" var="seller">
						<tr>
							<td>${seller.sId }</td>
							<td>${seller.sName }</td>
							<td>${seller.sAddress }</td>
							<td>${seller.sPhone }</td>
							<td>
								<a href="javascript:doUpdate('${seller.sId }')">修改</a>
								<a href="javascript:doDelete(${seller.sId })">删除</a>
							</td>
						</tr>
					</c:forEach>
					</tbody>
			</table><br>
		</div>
		<div style="width: 600px; float: left;">
				当前第${page.pageNo }页  
				<a href="javascript:goPage(1);">首页</a>
				<a href="javascript:goPage(${page.pageNo-1 });">上一页</a> 
				<a href="javascript:goPage(${page.pageNo+1 });">下一页</a>  
				<a href="javascript:goPage(${page.pageCount });">末页</a>
			</div>
			<div align="right" style="float: right; margin-right: 55px" >
				一共${page.totalCount }条，共${page.pageCount }页   跳转到第
				<select style="width: 60px"  onchange="goPage(this.value)">
					<c:forEach var="i" begin="1" end="${page.pageCount }">
						<%-- <option value="${i }" onclick="javascript:goPage(${page.pageNo})">${i }</option> --%>
						<c:choose>
							<c:when test="${i==page.pageNo }">
								<option value="${i }" selected="selected">${i }</option>
							</c:when>
							<c:otherwise>
								<option value="${i }" >${i }</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>页
			</div>
			
		<div class="clear"></div>
	</body>
</html>
