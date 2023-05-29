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
							href="shop" class="nav-item nav-link active">Shop</a>
						<a href="cart" class="nav-item nav-link">Shopping Cart</a>
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
		<h1 class="font-weight-semi-bold text-uppercase mb-3">Our Shop</h1>
		<div class="d-inline-flex">
			<p class="m-0">
				<a href="home">Home</a>
			</p>
			<p class="m-0 px-2">-</p>
			<p class="m-0">Shop</p>
		</div>
	</div>
</div>
<!-- Page Header End -->


<!-- Shop Start -->
<div class="container-fluid pt-5">
	<div class="row px-xl-5">
		<!-- Shop Sidebar Start -->
		<div class="col-lg-3 col-md-12">
			<!-- Price Start -->
			<div class="border-bottom mb-4 pb-4">
				<h5 class="font-weight-semi-bold mb-4">HaHuShoes Says</h5>
				<form>
				
					<div
						class="custom-control align-items-center justify-content-between mb-3">
						<!-- <input type="checkbox" class="custom-control-input" checked
							id="price-all">  -->
							<label class=""
							for="price-all">Giá Khuyến mãi</label> 
					</div>
					<div
						class="custom-control  d-flex align-items-center justify-content-between mb-3">
						<!-- <input type="checkbox" class="custom-control-input" id="price-1"> -->
						<label class="" for="price-1">Ưu đãi giành riêng bạn</label> 
						<!-- <span class="badge border font-weight-normal">150</span> -->
					</div>
					<div
						class="custom-control  d-flex align-items-center justify-content-between mb-3">
						<!-- <input type="checkbox" class="custom-control-input" id="price-2"> -->
						<label class="" for="price-2">Thương hiệu độc quyền</label>
						 <!-- <span class="badge border font-weight-normal">295</span> -->
					</div>
					<div
						class="custom-control  d-flex align-items-center justify-content-between mb-3">
						<!-- <input type="checkbox" class="custom-control-input" id="price-3"> -->
						<label class="" for="price-3">Đặt hàng là có</label>
						<!--  <span class="badge border font-weight-normal">246</span> -->
					</div>
					<div
						class="custom-control d-flex align-items-center justify-content-between mb-3">
					<!-- 	<input type="checkbox" class="custom-control-input" id="price-4"> -->
						<label class="" for="price-4">Ship hàng nhanh</label>
						 <!-- <span class="badge border font-weight-normal">145</span> -->
					</div>
					
				</form>
			</div>
			<!-- Price End -->
		</div>
		<!-- Shop Sidebar End -->

		<!-- Shop Product Start -->
		<div class="col-lg-9 col-md-12">
			<div class="row pb-3">
				<div class="col-12 pb-1">
					<div class="d-flex align-items-center justify-content-between mb-4">
						<form action="searchproduct">
							<div class="input-group">
								<input type="text" class="form-control"
									placeholder="Search by name" name="txtsearch" size="15" required>								
								<input class="searchButton" type="submit" name="btnGo" value = "Go">
							</div>
						</form>
						<!-- <div class="dropdown ml-4">
							<button class="btn border dropdown-toggle" type="button"
								id="triggerId" data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false">Sort by</button>
							<div class="dropdown-menu dropdown-menu-right"
								aria-labelledby="triggerId">
								<a class="dropdown-item" href="#">Latest</a> <a
									class="dropdown-item" href="#">Popularity</a>
							</div>
						</div> -->
					</div>
				</div>
				<form name="f" action="" method="post">
					<div class="row pb-3">
						<c:forEach items="${products}" var="product">
							<c:set var="id" value="${product.productId }"/>
							<div class="col-lg-4 col-md-6 col-sm-12 pb-1">
								<div class="card product-item border-0 mb-4">
									<div
										class="card-header product-img position-relative overflow-hidden bg-transparent border p-0">
										<img class="img-fluid w-100" src="${product.images}" alt="">
									</div>
									<div
										class="card-body border-left border-right text-center p-0 pt-4 pb-3">
										<h6 class="text-truncate mb-3">${product.productName }</h6>
										<div class="d-flex justify-content-center">
											<h6>${product.price } VNĐ</h6>
										</div>
									</div>
									<div
										class="card-footer d-flex justify-content-between bg-light border">
										<a
											href="<c:url value="/shop-detail?productId=${product.productId}"/>"
											class="btn btn-sm text-dark p-0"><i
											class="fas fa-eye text-primary mr-1"></i>View Detail</a>
											<button class="btn btn-sm text-dark p-0" onclick="shop('${product.productId }')">
												<i class="fas fa-shopping-cart text-primary mr-1"></i>Add To Cart
                           					</button>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</form>
				<script type="text/javascript">
					function shop(id){
						document.f.action="shop?id="+id;
						document.f.submit();
					}
				</script>
				<div class="col-12 pb-1">
					<ul class="pagination pull-right">
						<c:if test="${tag>1}">
							<li class="page-item active"><a class="page-link"
								href="<c:url value="/shop?index=${tag-1}"/>">Previous</a></li>
						</c:if>
						<c:forEach begin="1" end="${endP }" var="i">
							<li class='page-item ${tag == i ? "active":"" }'><a
								class="page-link" href="<c:url value="/shop?index=${i}"/>">${i }</a>
							</li>
						</c:forEach>
						<c:if test="${tag<endP}">
							<li class="page-item active"><a class="page-link"
								href="<c:url value="/shop?index=${tag+1}"/>">Next</a></li>
						</c:if>
					</ul>
				</div>
			</div>
		</div>
		<!-- Shop Product End -->
	</div>
</div>
<!-- Shop End -->

