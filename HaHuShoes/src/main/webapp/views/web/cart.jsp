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
						<a href="cart" class="nav-item nav-link active">Shopping Cart</a>
						<a href="contact" class="nav-item nav-link">Contact</a>
						<a href="order" class="nav-item nav-link">Order</a>
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
		<h1 class="font-weight-semi-bold text-uppercase mb-3">Shopping
			Cart</h1>
		<div class="d-inline-flex">
			<p class="m-0">
				<a href="home">Home</a>
			</p>
			<p class="m-0 px-2">-</p>
			<p class="m-0">Shopping Cart</p>
		</div>
	</div>
</div>
<!-- Page Header End -->


<!-- Cart Start -->
<div class="container-fluid pt-5">
	<div class="row px-xl-5">
		<div class="col-lg-8 table-responsive mb-5">
			<table class="table table-bordered text-center mb-0">
				<thead class="bg-secondary text-dark">
					<tr>
						<th>Products</th>
						<th>Price</th>
						<th>Quantity</th>
						<th>Total money</th>
						<th>Remove</th>
					</tr>
				</thead>
				<tbody class="align-middle">
					<c:set var="o" value="${requestScope.cart }"/>
					<c:forEach items="${o.items}" var="i">
						<tr>
							<td class="align-middle"><img src="${i.product.images }" alt=""
								style="width: 50px;">${i.product.productName }</td>
							<td class="align-middle">${i.price }VNĐ</td>
							<td class="align-middle">
								<div class="input-group quantity mx-auto" style="width: 150px;">
									<div class="input-group-btn">
										<button class="btn btn-default btn-minus">	
											<a href="process?num=-1&id=${i.product.productId }"><i class="fa fa-minus"></i></a>
										</button>
									</div>
									<div class="form-control text-center">${i.quantity }</div>
									<div class="input-group-btn">
										<button class="btn btn-default btn-plus">
											<a href="process?num=1&id=${i.product.productId }"><i class="fa fa-plus"></i></a>
										</button>
									</div>
								</div>		
							</td>
							<td class="align-middle">${(i.price*i.quantity) }VNĐ</td>
							<td class="align-middle">
								<form action="process" method="post">
									<input type="hidden" name="id" value="${i.product.productId }"/>
									<input type="submit" value="Delete"/>
								</form>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="col-lg-4">
			<div class="card border-secondary mb-5">
				<div class="card-header bg-secondary text-center border-0">
					<h4 class="font-weight-semi-bold m-0">Cart Summary</h4>
				</div>
				<div class="card-body">
					<div class="d-flex justify-content-between mb-3 pt-1">
						<h6 class="font-weight-medium">Subtotal</h6>
						<h6 class="font-weight-medium">${o.totalMoney} VNĐ</h6>
					</div>
					<div class="d-flex justify-content-between">
						<h6 class="font-weight-medium">Shipping</h6>
						<h6 class="font-weight-medium">10000 VNĐ</h6>
					</div>
				</div>
				<div class="card-footer border-secondary bg-transparent">
					<div class="d-flex justify-content-between mt-2">
						<h5 class="font-weight-bold">Total</h5>
						<h5 class="font-weight-bold">${(o.totalMoney + 10000) } VNĐ</h5>
					</div>
					
					<!-- <form action="payment" method="post">
						<input type="submit" value="Payment" class="btn btn-block btn-primary my-3 py-3"/>
					</form> -->
					<div class="card-header bg-secondary text-center border-0">
						<a type="button" class="btn btn-block btn-default my-2 py-2 font-weight-semi-bold" href="information">PROCEED TO ORDER</a>
					</div>
					<hr/>
					<div class="card-header bg-secondary text-center border-0">
						<a type="button" class="btn btn-block btn-default font-weight-semi-bold" href="shop">CLICK ME TO CONTINUE SHOPPING</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Cart End -->


