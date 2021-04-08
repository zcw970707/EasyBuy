<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
	<style type="text/css">
		.field {
			width: 75px;
			height: 30px;
			margin: 0 auto;
			font-size: 20px;
			float: left;
			width: 240px;
			height: 24px;
			line-height: 24px;
			vertical-align: middle;
			padding-top: 0px;

		}

		#login {
			margin: 0 auto;
			background-color: #B3F0FB;
			background-repeat: no-repeat;
			text-align: center;
			color: red;
			font-size: 16px;
			font-style: italic;
			width: 80px;
			height: 24px;
			border: 1px solid #F2F2F2;
			line-height: 24px;
			text-decoration: line-through;
			float: left;
		}
	</style>
<script type="text/javascript" src="scripts/function.js"></script>
<script type="text/javascript" src="scripts/jquery-1.12.4.js"></script>
	<script type="text/javascript">
		function numVerification() {
			if ($("#login").text()!=$("#num").val()){
				$("#numSpan").html("验证码不正确")
				$("#numSpan").show();
			}else {
				$("#numSpan").css({"background-image":"none"})
				$("#numSpan").css({"color":"green","background":"'none'"})
				$("#numSpan").html("√")
				$("#numSpan").show();
			}
		}
		function codes(n) {
			var a = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
			var b = "";
			for (var i=0; i<n; i++){
				var index = Math.floor(Math.random()*62);
				b+=a.charAt(index);
			}
			return b;
		}
		function show() {
			document.getElementById("login").innerHTML=codes(4);
		}
		window.onload=show;
	</script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" /></div>
	<div class="help"><a href="#" class="shopping">购物车</a><a href="login.jsp">登录</a><a href="register.jsp">注册</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li class="current"><a href="#">首页</a></li>
			<li><a href="#">图书</a></li>
			<li><a href="#">百货</a></li>
			<li><a href="#">品牌</a></li>
			<li><a href="#">促销</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="wrap">
		<ul class="clearfix">
			<li class="first"><a href="#">音乐</a></li>
			<li><a href="#">影视</a></li>
			<li><a href="#">少儿</a></li>
			<li><a href="#">动漫</a></li>
			<li><a href="#">小说</a></li>
			<li><a href="#">外语</a></li>
			<li><a href="#">数码相机</a></li>
			<li><a href="#">笔记本</a></li>
			<li><a href="#">羽绒服</a></li>
			<li><a href="#">秋冬靴</a></li>
			<li><a href="#">运动鞋</a></li>
			<li><a href="#">美容护肤</a></li>
			<li><a href="#">家纺用品</a></li>
			<li><a href="#">婴幼奶粉</a></li>
			<li><a href="#">饰品</a></li>
			<li class="last"><a href="#">Investor Relations</a></li>
		</ul>
	</div>
</div>
<div id="register" class="wrap">
	<div class="shadow">
		<em class="corner lb"></em>
		<em class="corner rt"></em>
		<div class="box">
			<h1>欢迎回到易买网</h1>
			<form id="loginForm" method="post" action="<%=request.getContextPath()%>/UserServlet?method=loginYX">
				<table>
					<tr>
						<td class="field">用户名：</td>
						<td><input class="text" type="text" name="userName"/><span id="nameSpan"></span></td>
					</tr>
					<tr>
						<td class="field">登录密码：</td>
						<td><input class="text" type="password" id="passWord" name="passWord" /><span id="pwdSpan"></span></td>
					</tr>
					<tr>
						<td class="field">验证码：</td>
						<td><input class="text verycode" type="text" name="veryCode" id="num" required="required" onblur="numVerification()"/><span id="numSpan"></span></td>
						<td>
							<div id="login" onclick="show()" >
							</div>
						</td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-green"><input type="submit" name="submit" value="立即登录"/></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
