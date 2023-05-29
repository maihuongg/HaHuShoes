<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Navbar Start -->
<div class="container-fluid">
	<div class="row border-top px-xl-5">
		<div class="col-lg-3 d-none d-lg-block">
			<a
				class="btn shadow-none d-flex align-items-center justify-content-between bg-primary text-white w-100"
				data-toggle="collapse" href="#navbar-vertical"
				style="height: 65px; margin-top: -1px; padding: 0 30px;">
				<h6 class="m-0">Categories</h6> <i
				class="fa fa-angle-down text-dark"></i>
			</a>
			<nav
				class="collapse position-absolute navbar navbar-vertical navbar-light align-items-start p-0 border border-top-0 border-bottom-0 bg-light"
				id="navbar-vertical" style="width: calc(100% - 30px); z-index: 1;">
				<div class="navbar-nav w-100 overflow-hidden" style="height: 410px">
					<c:forEach items="${cateList}" var="cate">
						<a
							href="<c:url value='/shopprobycate?cateId=${cate.categoryId}'/>"
							class="nav-item nav-link">${cate.categoryName }</a>
					</c:forEach>
				</div>
			</nav>
		</div>
		<div class="col-lg-9">
			<nav
				class="navbar navbar-expand-lg bg-light navbar-light py-3 py-lg-0 px-0">
				<a href="" class="text-decoration-none d-block d-lg-none">
					<h1 class="m-0 display-5 font-weight-semi-bold">
						<span class="text-primary font-weight-bold border px-3 mr-1">H</span>aHuShoes
					</h1>
				</a>
				<button type="button" class="navbar-toggler" data-toggle="collapse"
					data-target="#navbarCollapse">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse justify-content-between"
					id="navbarCollapse">
					<div class="navbar-nav mr-auto py-0">
						<a href="home" class="nav-item nav-link">Home</a> <a
							href="shop" class="nav-item nav-link">Shop</a>
						<a href="cart" class="nav-item nav-link">Shopping Cart</a>
						<a href="contact" class="nav-item nav-link">Contact</a>
						<a href="order" class="nav-item nav-link active">Order</a>
					</div>
					<div class="navbar-nav ml-auto py-0">
						<c:if test="${sessionScope.account != null}">
							<a class="nav-item nav-link" href="individual?username=${sessionScope.account.userName}">Hello
								${sessionScope.account.userName}</a>
							<a class="nav-item nav-link"
								href="${pageContext.request.contextPath}/logout">Logout</a>
						</c:if>
						<c:if test="${sessionScope.account == null}">
							<a href="${pageContext.request.contextPath}/login"
								class="nav-item nav-link">Login</a>
							<a href="" class="nav-item nav-link">Register</a>
						</c:if>

					</div>
				</div>
			</nav>
		</div>
	</div>
</div>
<!-- Navbar End -->
<!-- Page Header Start -->
<div class="container-fluid bg-secondary mb-5">
	<div
		class="d-flex flex-column align-items-center justify-content-center"
		style="min-height: 300px">
		<h1 class="font-weight-semi-bold text-uppercase mb-3">Order History</h1>
		<div class="d-inline-flex">
			<p class="m-0">
				<a href="home">Home</a>
			</p>
			<p class="m-0 px-2">-</p>
			<p class="m-0">Order History</p>
		</div>
	</div>
</div>
<!-- Page Header End -->


<!-- Cart Start -->
<div class="container-fluid pt-5">
	<div class="row px-xl-5">
		<div class="col-lg-8 table-responsive mb-5">
			<table class="table table-bordered text-center mb-5">
				<thead class="bg-secondary text-dark">
					<tr>
						<th>OrderId</th>
						<th>Date</th>
						<th>Total Money</th>
						<th>Status</th>
						<th> </th>
					</tr>
				</thead>
				<tbody class="align-middle">
					<c:forEach items="${orderList}" var="i">
						<tr>
							<td class="align-middle">${i.orderId }</td>
							<td class="align-middle">${i.datetime}</td>
							<td class="align-middle">${i.totalMoney}VNĐ</td>
							<td class="align-middle">Đã hoàn thành</td>
							<td><a class="btn btn-sm btn-primary"
										href="<c:url value='/orderdetail?orderId=${i.orderId}'/>">Detail</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="col-lg-4">
			<div class="card border-secondary mb-5">
				<div class="card-footer border-secondary bg-transparent">
					<div class="card-header bg-secondary text-center border-0">
						<a type="button" class="btn btn-block btn-default font-weight-semi-bold" href="shop">CLICK ME TO CONTINUE SHOPPING</a>
					</div>
				</div>
			</div>
		</div>
		<div class="col-lg-4">
		</div>
	</div>
</div>
<!-- Cart End -->


