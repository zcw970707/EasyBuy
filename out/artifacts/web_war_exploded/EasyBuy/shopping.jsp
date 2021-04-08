<%@ page import="com.ymIntnet.service.ShopCarService" %>
<%@ page import="com.ymIntnet.service.impl.ShopCarServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ymIntnet.entity.ShopCar" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/jquery-1.12.4.js"></script>
<script type="text/javascript" src="scripts/function.js"></script>
	<<script type="text/javascript">
		$(function () {
			$("input#count").blur(function () {
				var count = $(this).val()
				var shopId = $(this).parent().siblings("input").val()
				$.post("/web_war_exploded/EasyBuyProductCategoryServlet",{"count":count,"operation":"ss","method":"countAdd","sId":shopId},function (data) {
					if (data="true"){
						window.location.href="<%=request.getContextPath()%>/EasyBuyProductCategoryServlet?method=shopCarFind";
					}else {
						alert("跳转失败")
					}
				})
			})
		})
	</script>
<%--<%
	ShopCarService scs = new ShopCarServiceImpl();
	List<ShopCar> sCarList = scs.shopCarFindAll();
	session.setAttribute("shopCarList",sCarList);
%>--%>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" /></div>
    <div class="help"><a href="<%=request.getContextPath()%>/EasyBuyProductCategoryServlet?method=shopCarFind&sumPrice=${sum}" class="shopping">购物车:${fn:length(shopCarList)}</a><a href="login.jsp">登录</a><a href="register.jsp">注册</a></div>
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
	您现在的位置：<a href="index.jsp">易买网</a> &gt; 购物车
</div>
<div class="wrap">
	<div id="shopping">
		<form action="<%=request.getContextPath()%>/EasyBuyProductCategoryServlet?method=order"method="post">
			<table>
				<tr>
					<th>商品名称</th>
					<th>商品价格</th>
					<th>购买数量</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${shopCarList}" var="sc">
					<tr>
						<td class="thumb"><img src="${sc.ebp.epFileName}"/><a href="product-view.jsp" name="shopName">${sc.ebp.epNam}</a></td>
						<td class="price">
							<span>￥${sc.shopCarTotalPrice}</span>
						</td>
						<td class="number"style="margin-left: 20px">
							<dl>
								<dd style="border: none;width: 15px;height: 30px">
									<a href="<%=request.getContextPath()%>/EasyBuyProductCategoryServlet?
									method=countAdd&&sPrice=${sc.shopCarTotalPrice}&&sId=${sc.shopCarId}&&count=${sc.shopCount}&&operation=reduce">
										<input type="button" value="-" id="reduce"style="margin-top: 10px;">
									</a>
								</dd>
								<input type="hidden" value="${sc.shopCarId}" name="shopId">
								<dt><input type="text" name="number" value="${sc.shopCount}" id="count" style="margin-top: 10px;"/></dt>
								<dd style="width: 15px;height: 50px;border: none">
									<a href="<%=request.getContextPath()%>/EasyBuyProductCategoryServlet?
									method=countAdd&&sPrice=${sc.shopCarTotalPrice}&&sId=${sc.shopCarId}&&count=${sc.shopCount}&&operation=add">
										<input type="button" value="+" id="addd" style="margin-top: 10px;">
									</a>
								</dd>
							</dl>
						</td>
						<td class="delete">
							<a href="<%=request.getContextPath()%>/EasyBuyProductCategoryServlet?
									method=ddl&&sId=${sc.shopCarId}" id="sDel">删除
							</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<div class="button"><input type="submit" value=""/></div>
		</form>
	</div>
</div>
<div id="footer">
	Copyright &copy; 2010 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
