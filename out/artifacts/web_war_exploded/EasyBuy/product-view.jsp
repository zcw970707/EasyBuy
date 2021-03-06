<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/function.js"></script>
	<script type="text/javascript" src="scripts/jquery-1.12.4.js"></script>
</head>
<body>
<script type="text/javascript">
	$(function () {
		$("#gm").click(function () {
			var id = $("#yc").val()
			$.post("/web_war_exploded/EasyBuyProductCategoryServlet",{"method":"shopCar","id":id},function (data) {
				if (data="true"){
					window.location.href="<%=request.getContextPath()%>/EasyBuyProductCategoryServlet?method=shopCarFind";
				}else {
					alert("跳转失败")
				}
			})
		})
	})
</script>
<div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" /></div>
	<div class="help"><a href="<%=request.getContextPath()%>/EasyBuyProductCategoryServlet?method=shopCarFind" class="shopping">购物车:${fn:length(shopCarList)}</a><a href="login.jsp">登录</a><a href="register.jsp">注册</a></div>
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
<div id="position" class="wrap">
	您现在的位置：<a href="index.jsp">易买网</a> &gt; <a href="product-list.jsp">图书音像</a> &gt; 图书
</div>
<div id="main" class="wrap">
	<div class="lefter">
		<div class="box">
			<h2>商品分类</h2>
			<dl>
				<c:forEach items="${productList}" var="ec">
					<dt>${ec.epcName}</dt>
					<c:forEach items="${ec.list}" var="ecc">
						<dd><a href="<%=request.getContextPath()%>/EasyBuyProductCategoryServlet?id=${ec.epcId}&&method=productFindId">${ecc.epcName}</a></dd>
					</c:forEach>
				</c:forEach>
			</dl>
		</div>
	</div>
	<div id="product" class="main">
		<h1>${ebpList[0].epNam}</h1>
		<div class="infos">
			<div class="thumb"><img src="${ebpList[0].epFileName}" /></div>
			<div class="buy">
				<p>商城价：<span class="price">￥${ebpList[0].epPrice}</span></p>
				<c:if test="${ebpList[0].epStock>0}">
					<p>库　存：有货</p>
					<p>库　存：有货</p>
					<p>库　存：有货</p>
					<p>库　存：有货</p>
				</c:if>
				<c:if test="${ebpList[0].epStock<=0}">
					<p>库　存：无货</p>
					<p>库　存：无货</p>
					<p>库　存：无货</p>
					<p>库　存：无货</p>
				</c:if>
				<input type="hidden" id="yc" value="${ebpList[0].epId}">
				<div class="button"><input type="button" name="button" value="" id="gm"/></div>
			</div>
			<div class="clear"></div>
		</div>
		<div class="introduce">
			<h2><strong>商品详情</strong></h2>
			<div class="text">
				${ebpList[0].epDescription} <br />
				${ebpList[0].epDescription} <br />
			</div>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
