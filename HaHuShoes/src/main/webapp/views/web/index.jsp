<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!-- Navbar Start -->
<div class="container-fluid mb-5">
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
				class="collapse show navbar navbar-vertical navbar-light align-items-start p-0 border border-top-0 border-bottom-0"
				id="navbar-vertical">
				<div class="navbar-nav w-100 overflow-hidden" style="height: 410px">
					<c:forEach items="${cate3List}" var="cate">
						<a href="<c:url value='/shopprobycate?cateId=${cate.categoryId}'/>"
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
						<a href="home" class="nav-item nav-link active">Home</a> <a
							href="shop" class="nav-item nav-link">Shop</a>
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
							<a href="${pageContext.request.contextPath}/register" class="nav-item nav-link">Register</a>
						</c:if>
					</div>
				</div>
			</nav>
			<div id="header-carousel" class="carousel slide" data-ride="carousel">
				<div class="carousel-inner">
					<div class="carousel-item active" style="height: 410px;">
						<img class="img-fluid" src="https://thumbs.dreamstime.com/b/white-female-fashion-sneakers-pink-background-flat-lay-top-view-copy-space-women-s-shoes-stylish-blog-magazine-concept-169515889.jpg" alt="Image">
						<div
							class="carousel-caption d-flex flex-column align-items-center justify-content-center">
							<div class="p-3" style="max-width: 700px;">
								<a href="shop" class="btn btn-light py-2 px-3">Shop Now</a>
							</div>
						</div>
					</div>
					<div class="carousel-item" style="height: 410px;">
						<img class="img-fluid" src="https://previews.123rf.com/images/windnight/windnight2001/windnight200100483/138882008-cute-blue-baby-boy-sneakers-with-small-white-flowers-on-blue-background-copy-space-top-view-.jpg" alt="Image">
						<div
							class="carousel-caption d-flex flex-column align-items-center justify-content-center">
							<div class="p-3" style="max-width: 700px;">
								<a href="shop" class="btn btn-light py-2 px-3">Shop Now</a>
							</div>
						</div>
					</div>
				</div>
				<a class="carousel-control-prev" href="#header-carousel"
					data-slide="prev">
					<div class="btn btn-dark" style="width: 45px; height: 45px;">
						<span class="carousel-control-prev-icon mb-n2"></span>
					</div>
				</a> <a class="carousel-control-next" href="#header-carousel"
					data-slide="next">
					<div class="btn btn-dark" style="width: 45px; height: 45px;">
						<span class="carousel-control-next-icon mb-n2"></span>
					</div>
				</a>
			</div>
		</div>
	</div>
</div>
<!-- Navbar End -->
 <!-- Featured Start -->
    <div class="container-fluid pt-5">
        <div class="row px-xl-5 pb-3">
            <div class="col-lg-3 col-md-6 col-sm-12 pb-1">
                <div class="d-flex align-items-center border mb-4" style="padding: 30px;">
                    <h1 class="fa fa-check text-primary m-0 mr-3"></h1>
                    <h5 class="font-weight-semi-bold m-0">Quality Product</h5>
                </div>
            </div>
            <div class="col-lg-3 col-md-6 col-sm-12 pb-1">
                <div class="d-flex align-items-center border mb-4" style="padding: 30px;">
                    <h1 class="fa fa-shipping-fast text-primary m-0 mr-2"></h1>
                    <h5 class="font-weight-semi-bold m-0">Free Shipping</h5>
                </div>
            </div>
            <div class="col-lg-3 col-md-6 col-sm-12 pb-1">
                <div class="d-flex align-items-center border mb-4" style="padding: 30px;">
                    <h1 class="fas fa-exchange-alt text-primary m-0 mr-3"></h1>
                    <h5 class="font-weight-semi-bold m-0">14-Day Return</h5>
                </div>
            </div>
            <div class="col-lg-3 col-md-6 col-sm-12 pb-1">
                <div class="d-flex align-items-center border mb-4" style="padding: 30px;">
                    <h1 class="fa fa-phone-volume text-primary m-0 mr-3"></h1>
                    <h5 class="font-weight-semi-bold m-0">24/7 Support</h5>
                </div>
            </div>
        </div>
    </div>
    <!-- Featured End -->


<!-- Featured End -->


<!-- Categories Start -->

<div class="container-fluid pt-5">
	<div class="row px-xl-5 pb-3">
		<c:forEach items="${cate3List}" var="cate">
			<div class="col-lg-4 col-md-6 pb-1">

				<div class="cat-item d-flex flex-column border mb-4"
					style="padding: 30px;">

					<a href="<c:url value='/shopprobycate?cateId=${cate.categoryId}'/>" class="cat-img position-relative overflow-hidden mb-3">
						<img class="img-fluid" src="${cate.images }" alt="">
					</a>
					<h5 class="font-weight-semi-bold m-0">${cate.categoryName }</h5>
				</div>
			</div>
		</c:forEach>



	</div>
</div>


<!-- Categories End -->

<!-- Products Start -->

	<div class="container-fluid pt-5">
		<div class="text-center mb-4">
			<h2 class="section-title px-5">
				<span class="px-2">Trandy Products</span>
			</h2>
		</div>
		<div class="row px-xl-5 pb-3">
			
			<c:forEach items="${productTrend}" var="producttrend">
				<c:set var="productId" value="${producttrend.productId }"/>
				<div class="col-lg-3 col-md-6 col-sm-12 pb-1">
	
					<div class="card product-item border-0 mb-4">
						<div
							class="card-header product-img position-relative overflow-hidden bg-transparent border p-0">
							<img class="img-fluid" src="${producttrend.images}" alt="">
						</div>
						<div
							class="card-body border-left border-right text-center p-0 pt-4 pb-3">
							<h6 class="text-truncate mb-3">${producttrend.productName }</h6>
							<div class="d-flex justify-content-center">
								<h6 class="text-muted ml-2"></h6>
								<h5>${producttrend.price} VNĐ</h5>
							</div>
						</div>
						<div
							class="card-footer d-flex justify-content-between bg-light border">
							<a
								href="<c:url value="/shop-detail?productId=${producttrend.productId}"/>"
								class="btn btn-sm text-dark p-0"><i
								class="fas fa-eye text-primary mr-1"></i>View Detail</a> 
								<button class="btn btn-sm text-dark p-0" onclick="home('${producttrend.productId }')">
									<i class="fas fa-shopping-cart text-primary mr-1"></i>Add To Cart
	                           	</button>
						</div>
	
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
<!-- Products End -->

<!-- Products Start -->
<form name="fa" action="" method="post">
	<div class="container-fluid pt-5">
		<div class="text-center mb-4">
			<h2 class="section-title px-5">
				<span class="px-2">Just Arrived</span>
			</h2>
		</div>
		<div class="row px-xl-5 pb-3">
			<c:forEach items="${productArrived}" var="product">
				<c:set var="productId" value="${product.productId }"/>
				<div class="col-lg-3 col-md-6 col-sm-12 pb-1">
	
					<div class="card product-item border-0 mb-4">
						<div
							class="card-header product-img position-relative overflow-hidden bg-transparent border p-0">
							<img class="img-fluid" src="${product.images}" alt="">
						</div>
						<div
							class="card-body border-left border-right text-center p-0 pt-4 pb-3">
							<h6 class="text-truncate mb-3">${product.productName }</h6>
							<div class="d-flex justify-content-center">
								<h6 class="text-muted ml-2"></h6>
								<h5>${product.price} VNĐ</h5>
							</div>
						</div>
						<div
							class="card-footer d-flex justify-content-between bg-light border">
							<a
								href="<c:url value="/shop-detail?productId=${product.productId}"/>"
								class="btn btn-sm text-dark p-0"><i
								class="fas fa-eye text-primary mr-1"></i>View Detail</a> 
								<button class="btn btn-sm text-dark p-0" onclick="home('${product.productId}')">
									<i class="fas fa-shopping-cart text-primary mr-1"></i>Add To Cart
                           		</button>
						</div>
	
					</div>
	
	
				</div>
			</c:forEach>
		</div>
	</div>
</form>
<script type="text/javascript">
	function home(id) {
		document.fa.action = "home?productId=" + id;
		document.fa.submit();
	}
</script>
<!-- Products End -->




