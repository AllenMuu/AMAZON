<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>亚马逊 - 产品显示</title>
<link href="${pageContext.request.contextPath}/css/index.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/adv.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/scripts/jquery-2.1.0.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/adv.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/scripts/function.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/scripts/index.js"></script>
<script type="text/javascript" src="scripts/product_view.js"></script>
</head>
<body>
	<%@ include file="index_top.jsp"%>
	<div id="position" class="wrap">
		您现在的位置：<a href="index.jsp">亚马逊</a> &gt; <a href=""></a> &gt; <a
			href=""></a>
	</div>
	<div id="main" class="wrap">
		<div class="lefter">
			<%@ include file="index_product_sort.jsp"%>
		</div>
		<div id="product" class="main">
			<h1>商品名称:</h1>
			<div class="infos">
				<div class="thumb">
					<img style="width: 100px; height: 100px;" src="" />
				</div>
				<div class="buy">
					<p>
						商城价：<span class="price">￥</span>
					</p>
					<p>
						库 存：<span id="stock"></span>(有货)
					</p>
					<p>
						库 存：无货 <input type="button" id="minus" value=" - " width="3px">
						<input type="text" id="count" name="count" value="1" maxlength="5"
							size="1" style="text-align: center; vertical-align: middle">
						<input type="button" id="add" value=" + " width="2px">
					<div class="button">
						<input type="button" name="button" value=""
							style="background: url(images/buyNow.png)" /> <input
							type="image" name="imageField" src="images/cartbutton.png" />
					</div>

						<div class="button">
							<input type="button" name="button" value=""
								style="background: url(images/buyNow.png)" /> <input
								type="image" name="imageField" src="images/cartbutton.png"/>
						</div>
				</div>
				<div class="clear"></div>
			</div>
			<div class="introduce">
				<h2>
					<strong>商品详情</strong>
				</h2>
				<div class="text">
					商品名字：<br /> 商品描述：<br />
					商品价格：￥<br /> 商品库存：<br />
				</div>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div id="footer">Copyright &copy; 2018 上海海文 All Rights Reserved.
	</div>
</body>
</html>

