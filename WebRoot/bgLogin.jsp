<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<meta name="keywords"
	content="Flat Dark Web Login Form Responsive Templates, Iphone Widget Template, Smartphone login forms,Login form, Widget Template, Responsive Templates, a Ipad 404 Templates, Flat Responsive Templates" />
<link href="css/style1.css" rel='stylesheet' type='text/css' />
<!--webfonts-->
<link
	href='http://fonts.useso.com/css?family=PT+Sans:400,700,400italic,700italic|Oswald:400,300,700'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.useso.com/css?family=Exo+2' rel='stylesheet'
	type='text/css'>
<!--//webfonts-->
<script
	src="http://ajax.useso.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
</head>
<body>
	<script>
		$(document).ready(function(c) {
			$('.close').on('click', function(c) {
				$('.login-form').fadeOut('slow', function(c) {
					$('.login-form').remove();
				});
			});
		});
	</script>
	<script type="text/javascript">
		function checkLogin() {
		//做用户名和密码的判断 
		if(checkUserName() && checkUserPwd()){
			if(document.getElementById("username").value == "admin" && document.getElementById("password").value == "admin"){
				return true;
			}else{
				alert("用户名密码错误，请重新输入！")
			}
		}
		return false;
	}
	function checkUserName() {
		if (document.getElementById("username").value == "") {
			alert("请输入用户名");
			return false;
		}
		return true;
	}
	function checkUserPwd() {
		if (document.getElementById("password").value == "") {
			alert("请输入密码");
			return false;
		}
		return true;
	}
	</script>
	<!--SIGN UP-->
	<h1>乐玩线上商城后台管理系统</h1>
	<div class="login-form">
		<div class="close"></div>
		<div class="head-info">
			<label class="lbl-1"> </label> <label class="lbl-2"> </label> <label
				class="lbl-3"> </label>
		</div>
		<div class="clear"></div>
		<div class="avtar">
			<img src="images/avtar.png" />
		</div>
		<form action="./bgIndex.jsp" name="bgLogin_form" method="post" onsubmit="return checkLogin()">
			<input name="username" id="username" type="text" class="text" value="Username"
				onfocus="this.value = '';"
				onblur="if (this.value == '') {this.value = 'Username';}">
			<div class="key">
				<input name="password" id="password" type="password" value="Password" onfocus="this.value = '';"
					onblur="if (this.value == '') {this.value = 'Password';}">
			</div>
			<div class="signin">
				<input type="submit" value="Login">
			</div>
		</form>

	</div>
	<div class="copy-rights"></div>

</body>
</html>