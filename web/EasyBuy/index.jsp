<%@ page import="com.ymIntnet.service.EasyBuyProductCategoryService" %>
<%@ page import="com.ymIntnet.service.impl.EasyBuyProductCategoryServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ymIntnet.entity.EasyBuyProductCategory" %>
<%@ page import="com.ymIntnet.service.EasyBuyNewsService" %>
<%@ page import="com.ymIntnet.service.impl.EasyBuyNewsServiceImpl" %>
<%@ page import="com.ymIntnet.entity.EasyBuyNews" %>
<%@ page import="com.ymIntnet.entity.EasyBuyProduct" %>
<%@ page import="com.ymIntnet.service.EasyBuyProductService" %>
<%@ page import="com.ymIntnet.service.impl.EasyBuyProductServiceImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css"/>
<link type="text/css" rel="stylesheet" href="css/style.css"/>
<link type="text/css" rel="stylesheet" href="css/site.css"/>
<script type="text/javascript" src="scripts/jquery-1.12.4.js"></script>
<script type="text/javascript" src="scripts/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="scripts/jquery.bootstrap.newsbox.js"></script>
<script type="text/javascript" src="scripts/bootstrap.min.js"></script>
<script type="text/javascript" src="scripts/function.js"></script>
	<style>
		#myCarousel{
			width: 520px;
		}
	</style>
<script type="text/javascript">
	$(function () {
		$(".demo1").bootstrapNews({
			newsPerPage: 5,
			autoplay: true,
			pauseOnHover:true,
			navigation: false,
			direction: 'up',
			newsTickerInterval: 1000,
			onToDo: function () {
				//console.log(this);
			}
		});
		$(".demo2").bootstrapNews({
			newsPerPage: 5,
			autoplay: true,
			pauseOnHover:true,
			navigation: false,
			direction: 'up',
			newsTickerInterval: 1000,
			onToDo: function () {
				//console.log(this);
			}
		});
	});
</script>
</head>
<body>
<%
	EasyBuyProductCategoryService ebs = new EasyBuyProductCategoryServiceImpl();
	List<EasyBuyProductCategory> eList = ebs.findAllParents();
	session.setAttribute("productList",eList);
	EasyBuyNewsService ebn = new EasyBuyNewsServiceImpl();
	List<EasyBuyNews> newsList = ebn.newsFindAll();
	session.setAttribute("nList",newsList);
	EasyBuyProductService eps = new EasyBuyProductServiceImpl();
	List<EasyBuyProduct> epsList = eps.hotSellFind();
	session.setAttribute("hotSellList",epsList);
%>
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
		<div class="spacer"></div>
		<div class="last-view">
			<h2>最近浏览</h2>
		</div>
	</div>
	<div class="main">
		<div class="price-off">
			<h2>今日特价</h2>
			<div id="myCarousel" class="carousel slide" data-interval="1000" data-ride="carousel">
				<!-- 轮播（Carousel）指标 -->
				<ol class="carousel-indicators">
					<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#myCarousel" data-slide-to="1"></li>
					<li data-target="#myCarousel" data-slide-to="2"></li>
					<li data-target="#myCarousel" data-slide-to="3"></li>
					<li data-target="#myCarousel" data-slide-to="4"></li>
				</ol>
				<!-- 轮播（Carousel）项目 -->
				<div class="carousel-inner">
					<div class="item active">
						<img src="<%=request.getContextPath()%>/EasyBuy/111.png" alt="First slide">
					</div>
					<div class="item">
						<img src="<%=request.getContextPath()%>/EasyBuy/222.jpg" alt="Third slide">
					</div>
					<div class="item">
						<img src="<%=request.getContextPath()%>/EasyBuy/555.jpg" alt="Third slide">
					</div>
					<div class="item">
						<img src="<%=request.getContextPath()%>/EasyBuy/666.jpg" alt="Third slide">
					</div>
					<div class="item">
						<img src="<%=request.getContextPath()%>/EasyBuy/777.jpg" alt="Third slide">
					</div>

				</div>
				<!-- 轮播（Carousel）导航 -->
				<a class="carousel-control left" href="#myCarousel"
				   data-slide="prev"> <span _ngcontent-c3="" aria-hidden="true" class="glyphicon glyphicon-chevron-left"></span></a>
				<a class="carousel-control right" href="#myCarousel"
				   data-slide="next"><span _ngcontent-c3="" aria-hidden="true" class="glyphicon glyphicon-chevron-right"></span></a>
			</div>

		</div>
		<div class="side">
			<div class="news-list" style="height: 230px;">
				<h4>最新公告</h4>
				<ul class="demo1">
					<li class="news-item">
						<table cellpadding="4">
							<tr>
								<td><img src="<%=request.getContextPath()%>/EasyBuy/a.png" width="20" class="img-circle" /></td>
								<td><a href="#">Read more...</a></td>
							</tr>
						</table>
					</li>
					<li class="news-item">
						<table cellpadding="4">
							<tr>
								<td><img src="<%=request.getContextPath()%>/EasyBuy/b.png" width="20" class="img-circle" /></td>
								<td><a href="#">Read more...</a></td>
							</tr>
						</table>
					</li>
					<li class="news-item">
						<table cellpadding="4">
							<tr>
								<td><img src="<%=request.getContextPath()%>/EasyBuy/c.png" width="20" class="img-circle" /></td>
								<td><a href="#">Read more...</a></td>
							</tr>
						</table>
					</li>
					<li class="news-item">
						<table cellpadding="4">
							<tr>
								<td><img src="<%=request.getContextPath()%>/EasyBuy/d.png" width="20" class="img-circle" /></td>
								<td><a href="#">Read more...</a></td>
							</tr>
						</table>
					</li>
					<li class="news-item">
						<table cellpadding="4">
							<tr>
								<td><img src="<%=request.getContextPath()%>/EasyBuy/e.png" width="20" class="img-circle" /></td>
								<td><a href="#">Read more...</a></td>
							</tr>
						</table>
					</li>
					<li class="news-item">
						<table cellpadding="4">
							<tr>
								<td><img src="<%=request.getContextPath()%>/EasyBuy/f.png" width="20" class="img-circle" /></td>
								<td><a href="#">Read more...</a></td>
							</tr>
						</table>
					</li>
				</ul>
			</div>
			<div class="spacer"></div>
			<div class="news-list">
				<h4>新闻动态</h4>
				<ul class="demo2">
					<c:forEach items="${nList}" var="news" begin="0" end="3">
						<li class="news-item">
							<table cellpadding="4">
								<tr>
									<td>${news.enTitle}</td>
								</tr>
							</table>
						</li>
					</c:forEach>

				</ul>
			</div>
		</div>
		<div class="spacer clear"></div>
		<div class="hot">
			<h2>热卖推荐</h2>
			<ul class="product clearfix">
				<!--<li>
					<dl>
						<dt><a href="product-view.jsp" target="_blank"><img src="images/product/1.jpg" /></a></dt>
						<dd class="title"><a href="product-view.jsp" target="_blank">法国德菲丝松露精品巧克力500g/盒</a></dd>
						<dd class="price">￥108.0</dd>
					</dl>
				</li>-->
				<c:forEach items="${hotSellList}" var="eps">
				<li>
					<dl>
						<dt><a href="#" target="_blank"><img src="${eps.epFileName}" /></a></dt>
						<dd class="title"><a href="#" target="_blank">${eps.epNam}</a></dd>
						<dd class="price">￥${eps.epPrice}</dd>
					</dl>
				</li>
				</c:forEach>
			</ul>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
