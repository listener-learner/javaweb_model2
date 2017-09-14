<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>会员登录</title>
			<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
			<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
			<script src="js/bootstrap.min.js" type="text/javascript"></script>
		<!-- 引入自定义css文件 style.css -->
		<link rel="stylesheet" href="css/style.css" type="text/css" />
		
			<style>
				body {
					margin-top: 20px;
					margin: 0 auto;
					width: 100%;
				}
				
				.carousel-inner .item img {
					width: 100%;
					height: 300px;
				}
			</style>
	</head>

<body>


	<!-- 引入header.jsp -->
	<jsp:include page="/header.jsp"></jsp:include>


	<div class="row" style="width: 1210px; margin: 0 auto;">
		<div class="col-md-12">
			<ol class="breadcrumb">
				<li><a href="#">首页</a></li>
			</ol>
		</div>
		<!-- 循环遍历显示当前页所有商品信息 -->
		<c:forEach items="${pageBean.currentList }" var="product">
			<div class="col-md-2" style="height: 250px">
				<a href="${pageContext.request.contextPath }/productInfo?pid=${product.pid}"> <img src="${pageContext.request.contextPath }/${product.pimage}"
					width="170" height="170" style="display: inline-block;">
				</a>
				<p>
					<%--a标签的提交方式是get提交，要想向服务器端传递信息，采用拼接参数的方式 --%>
					<a href="${pageContext.request.contextPath }/productInfo?pid=${product.pid}" style='color: green'>${product.pname }</a>
				</p>
				<p>
					<font color="#FF0000">商城价：&yen;${product.market_price }</font>
				</p>
			</div>
		</c:forEach>



	</div>

	<!--分页 -->
	<div style="width: 380px; margin: 0 auto; margin-top: 50px;">
		<ul class="pagination" style="text-align: center; margin-top: 10px;">
			<!--上一页-->
			<!--判断当前页面是否是第一页-->
			<c:if test="${pageBean.currentPage==1 }">
				<!-- 是第一页，上一页按钮不能点击，href事件不执行 -->
				<li class="disabled">
					<a href="javascript:void(0);" aria-label="Previous">
						<span aria-hidden="true">&laquo;</span>
					</a>
				</li>
			</c:if>
			<c:if test="${pageBean.currentPage!=1 }">
				<!-- 不是第一页，上一页按钮能点击，href事件执行 跳转到上一页-->
				<li>
					<a href="${pageContext.request.contextPath }/currentPageProductList?currentPage=${pageBean.currentPage-1}" aria-label="Previous">
						<span aria-hidden="true">&laquo;</span>
					</a>
				</li>
			</c:if>
			
			
			
			<!-- 分页显示，显示有多少页 -->
			<c:forEach begin="1" end="${pageBean.totalPage }" var="page">
				<!--判断当前页-->
				<c:if test="${pageBean.currentPage==page }">
					<!--是当前页，不能点击，a标签href事件不执行-->
					<li class="active"><a href="javascript:void(0);">${page }</a></li>
				</c:if>
				<c:if test="${pageBean.currentPage!=page }">
					<!--不是当前页，能点击，a标签href事件执行跳转操作-->
					<li><a href="${pageContext.request.contextPath }/currentPageProductList?currentPage=${page}">${page }</a></li>
				</c:if>
			</c:forEach>
			
			
			<!--最后一页-->
			<!--判断当前页面是否是最后一页-->
			<c:if test="${pageBean.currentPage==pageBean.totalPage }">
				<!-- 是最后一页 按钮不能点击 href事件不执行 -->
				<li class="disabled">
					<a href="javascript:void(0);" aria-label="Next"> 
						<span aria-hidden="true">&raquo;</span>
					</a>
				</li>
			</c:if>
			<c:if test="${pageBean.currentPage!=pageBean.totalPage }">
				<!-- 不是最后一页 按钮能点击 href事件执行 跳转到下一页 -->
				<li>
					<a href="${pageContext.request.contextPath }/currentPageProductList?currentPage=${pageBean.currentPage+1}" aria-label="Next"> 
						<span aria-hidden="true">&raquo;</span>
					</a>
				</li>
			</c:if>
			
			
			
			<!-- <li class="disabled"><a href="#" aria-label="Previous"><span
					aria-hidden="true">&laquo;</span></a></li>
			<li class="active"><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
			<li><a href="#">6</a></li>
			<li><a href="#">7</a></li>
			<li><a href="#">8</a></li>
			<li><a href="#">9</a></li>
			<li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
			</a></li> -->
		</ul>
	</div>
	<!-- 分页结束 -->

	<!--商品浏览记录-->
	<div
		style="width: 1210px; margin: 0 auto; padding: 0 9px; border: 1px solid #ddd; border-top: 2px solid #999; height: 246px;">

		<h4 style="width: 50%; float: left; font: 14px/30px 微软雅黑">浏览记录</h4>
		<div style="width: 50%; float: right; text-align: right;">
			<a href="">more</a>
		</div>
		<div style="clear: both;"></div>

		<div style="overflow: hidden;">

			<ul style="list-style: none;">
				<li
					style="width: 150px; height: 216; float: left; margin: 0 8px 0 0; padding: 0 18px 15px; text-align: center;"><img
					src="products/1/cs10001.jpg" width="130px" height="130px" />
				</li>
			</ul>

		</div>
	</div>


	<!-- 引入footer.jsp -->
	<jsp:include page="/footer.jsp"></jsp:include>

</body>

</html>