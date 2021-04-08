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
<script type="text/javascript" src="scripts/jquery-1.12.4.js"></script>
<script type="text/javascript" src="scripts/function.js"></script>
<script type="text/javascript">
		function nameVerification() {
		    var name = $("#userName").val();
			if ($("#userName").val()==null||$("#userName").val()==""){
				$("#nameSpan").html("用户名不能为空")
				$("#nameSpan").show();
			}else {
			    $.post("<%=request.getContextPath()%>/UserServlet",{"method":"loginFind","name":name},function (data) {
			    	if (data=="true"){
                            $("#nameSpan").css({"background-image":"none"})
                            $("#nameSpan").css({"color":"green","background":"'none'"})
                            $("#nameSpan").html("用户名可用")
                            $("#nameSpan").show();
                        }else {
						$("#nameSpan").html("用户名已使用")
						$("#nameSpan").show();
					}
                })
            }
		}
		function pwdVerification() {
            if ($("#passWord").val()==null||$("#passWord").val()==""){
                $("#pwdSpan").html("密码不能为空")
                $("#pwdSpan").show();
            }else {
                $("#pwdSpan").css({"background-image":"none"})
                $("#pwdSpan").css({"color":"green","background":"'none'"})
                $("#pwdSpan").html("密码可用")
                $("#pwdSpan").show();
            }
        }
        function rePwdVerification() {
            if ($("#pwd").val()!=$("#passWord").val()){
                $("#pwdSpan2").html("两次密码输入不一致")
                $("#pwdSpan2").show();
            }else {
                $("#pwdSpan2").css({"background-image":"none"})
                $("#pwdSpan2").css({"color":"green","background":"'none'"})
                $("#pwdSpan2").html("两次密码输入正确")
                $("#pwdSpan2").show();
            }
        }
        function sexVerification() {
            if($(":radio[name='sex']:checked").val()==null){
                $("#sexSpan").html("请选择性别")
                $("#sexSpan").show();
            }
        }
        function birthVerification() {
            var time = /^(\d{4})-(0\d{1}|1[0-2])-(0\d{1}|[12]\d{1}|3[01])$/;
            if (!time.test($("#birth").val())){
                $("#birthSpan").html("时间格式错误")
                $("#birthSpan").show();
            }else {
                $("#birthSpan").css({"background-image":"none"})
                $("#birthSpan").css({"color":"green","background":"'none'"})
                $("#birthSpan").html("√")
                $("#birthSpan").show();
            }
        }
        function phoneVerification() {
            var phone = /^([1]\d{10}|([\(（]?0[0-9]{2,3}[）\)]?[-]?)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?)$/;
            var iPhone = $("#phone").val();
            if (!(phone.test(iPhone))){
                $("#phoneSpan").html("电话号码格式不对")
                $("#phoneSpan").show();
            }else {
                $("#phoneSpan").css({"background-image":"none"})
                $("#phoneSpan").css({"color":"green","background":"'none'"})
                $("#phoneSpan").html("电话号码可用")
                $("#phoneSpan").show();
            }
        }
        function addressVerification() {
            if ($("#address").val()==null||$("#phone").val()==""){
                $("#addressSpan").html("请填写地址")
                $("#addressSpan").show();
            }else {
                $("#addressSpan").css({"background-image":"none"})
                $("#addressSpan").css({"color":"green","background":"'none'"})
                $("#addressSpan").html("√")
                $("#addressSpan").show();
            }
        }
        function idCardVerification() {
            var card = /^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$|^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;
            if (!card.test($("#idCard").val())){
                $("#idCardSpan").html("身份证格式错误")
                $("#idCardSpan").show();
            }else {
                $("#idCardSpan").css({"background-image":"none"})
                $("#idCardSpan").css({"color":"green","background":"'none'"})
                $("#idCardSpan").html("√")
                $("#idCardSpan").show();
            }
        }
        function emailVerification() {
            var eemail = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
            if (!eemail.test($("#email").val())){
                $("#emailSpan").html("邮箱格式不对")
                $("#emailSpan").show();
            }else {
                $("#emailSpan").css({"background-image":"none"})
                $("#emailSpan").css({"color":"green","background":"'none'"})
                $("#emailSpan").html("√")
                $("#emailSpan").show();
            }
        }
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
		$.onload=show();
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
			<h1>欢迎注册易买网</h1>
			<ul class="steps clearfix">
				<li class="current"><em></em>填写注册信息</li>
				<li class="last"><em></em>注册成功</li>
			</ul>
			<form id="regForm" method="post" action="<%=request.getContextPath()%>/UserServlet?method=insert" >
				<table>
					<tr>
						<td class="field">用户名：</td>
						<td><input class="text" type="text" id="userName" name="userName" required="required" onblur="nameVerification()"/><span id="nameSpan"></span></td>
					</tr>
					<tr>
						<td class="field">登录密码：</td>
						<td><input class="text" type="password" id="passWord" name="passWord" required="required" onblur="pwdVerification()"/><span id="pwdSpan"></span></td>
					</tr>
					<tr>
						<td class="field">确认密码：</td>
						<td><input class="text" type="password" id="pwd" name="rePassWord" required="required" onblur="rePwdVerification()"/><span id="pwdSpan2"></span></td>
					</tr>
					<tr>
						<td class="field">选择性别：</td>
						<td>
							<input  type="radio" name="sex" value="T" onblur="sexVerification()"/>男
							<input  type="radio" name="sex" value="F" onblur="sexVerification()"/>女
							<span id="sexSpan"></span>
						</td>
					</tr>
					<tr>
						<td class="field">出生日期：</td>
						<td><input  type="date" name="time" id="birth" required="required" onblur="birthVerification()"/><span id="birthSpan"></span></td>
					</tr>
					<tr>
						<td class="field">手机号码：</td>
						<td><input class="text" type="text" name="iPhone" id="phone" required="required" onblur="phoneVerification()"/><span id="phoneSpan"></span></td>
					</tr>
					<tr>
						<td class="field">家庭住址：</td>
						<td><input class="text" type="text" name="address" id="address" required="required" onblur="addressVerification()"/><span id="addressSpan"></span></td>
					</tr>
					<tr>
						<td class="field">身份证：</td>
						<td><input class="text" type="text" name="idCard" id="idCard" required="required" onblur="idCardVerification()"/><span id="idCardSpan"></span></td>
					</tr>
					<tr>
						<td class="field">邮箱：</td>
						<td><input class="text" type="email" name="email" id="email" required="required" onblur="emailVerification()"/><span id="emailSpan"></span></td>
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
						<td><label class="ui-green"><input type="submit" name="submit" value="提交注册" /></label></td>
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
