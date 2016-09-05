<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	/* response.setIntHeader("refresh", 1); */
	/* String date = new Date().toLocaleString(); */
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>乐玩线上商城后台管理系统 | header</title>
	
	<link rel="stylesheet" type="text/css" href="css/style2.css" />
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript">
		function doRefer() {
			window.top.location.href = "./login.jsp";
		}
		
		function refresh() {
			var weekDay = new Array("星期日","星期一","星期二","星期三","星期四","星期五","星期六");
			var datetime = new Date();
			var date = datetime.toLocaleString();
			var week = weekDay[datetime.getDay()];
			document.getElementById("time").innerHTML = "" + date + " " + week;
			setTimeout("refresh()",1000);
		}
	</script>
  </head>
  
<body onload="refresh()">
	<div class="header">
        <div class="logo" align="center"><a href="index.html"><img src="images/logo1.png" alt="" title="" border="0" /></a></div>
        <div class="header_menu">
            <div class="header_left">管理员&nbsp; | <a href="pages/userUpate.jsp" target="mainFrame">修改个人资料</a></div>
            <div class="header_center" id="time"></div>
			<div class="header_right">
				<a href="welcome.html" target="mainFrame" class="home">首页</a> | 
				<!--
				<a href="#" class="prev">前进</a> | 
				<a href="#" class="next">后退</a> | 
				-->
				<a href="javascript:void(0)" onclick="doRefer()" target="_top" class="logout">退出</a>
			</div>
        </div>
    </div>
</body>
</html>
