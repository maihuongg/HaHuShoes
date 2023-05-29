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
        <div class="d-flex flex-column align-items-center justify-content-center" style="min-height: 300px">
            <h1 class="font-weight-semi-bold text-uppercase mb-3">Shop Detail</h1>
            <div class="d-inline-flex">
                <p class="m-0"><a href="<c:url value='/home'/>">Home</a></p>
                <p class="m-0 px-2">-</p>
                <p class="m-0">Shop Detail</p>
            </div>
        </div>
    </div>
    <!-- Page Header End -->


    <!-- Shop Detail Start -->
    <div class="container-fluid py-5">
	        <div class="row px-xl-5">
		        <div class="col-lg-5 pb-5">
					<div id="product-carousel" class="carousel slide"
						data-ride="carousel">
						<div class="carousel-item active">
							<img class="w-100 h-100" src='${productoneId.images}'/>
						</div>
						<!-- <a class="carousel-control-prev" href="#product-carousel"
							data-slide="prev"> <i class="fa fa-2x fa-angle-left text-dark"></i>
						</a> <a class="carousel-control-next" href="#product-carousel"
							data-slide="next"> <i class="fa fa-2x fa-angle-right text-dark"></i>
						</a> -->
					</div>
				</div>
	
	            <div class="col-lg-7 pb-5">
	                <h3 class="font-weight-semi-bold">${productoneId.productName}</h3>
	                <!-- <div class="d-flex mb-3">
	                    <div class="text-primary mr-2">
	                        <small class="fas fa-star"></small>
	                        <small class="fas fa-star"></small>
	                        <small class="fas fa-star"></small>
	                        <small class="fas fa-star-half-alt"></small>
	                        <small class="far fa-star"></small>
	                    </div>
	                    <small class="pt-1">(50 Reviews)</small>
	                </div> -->
	                <h3 class="font-weight-semi-bold mb-4">${productoneId.price} VNĐ</h3>
	                <h4 class="mb-3">Product Description</h4>
	                <p class="card-text">${productoneId.description}</p> 
	                <!-- <div class="d-flex mb-3">
	                    <p class="text-dark font-weight-medium mb-0 mr-3">Sizes:</p>
	                </div> -->          
	                <div class="d-flex align-items-center mb-4 pt-2">
		                    <div class="input-group quantity mr-3" style="width: 130px;">
		                        <div class="input-group-btn">
		                            <button class="btn btn-primary btn-minus" onclick="handleMinus()">
		                            <i class="fa fa-minus"></i>
		                            </button>
		                        </div>
		                        <input type="text" name="amount" id="amount" class="form-control bg-secondary text-center" value="1">
		                        <div class="input-group-btn">
		                            <button class="btn btn-primary btn-plus" onclick="handlePlus()">
		                                <i class="fa fa-plus"></i>
		                            </button>
								</div>
		                    </div>
	                    <script>
	                    	var amountElement = document.getElementById('amount')
	                    	var amount = amountElement.value
	                    	
	                    	function render(amount){
	                    		amountElement.value = amount
	                    	}
	                    	
	                    	function handlePlus(){
	                    		if(amount<${productoneId.amount})
	                    			amount++
	                    		render(amount)
	                    	}
	                    	
	                    	function handleMinus(){
	                    		if(amount>1)
	                    			amount--
	                    		render(amount)
	                    	}
	                    	
	                    	amountElement.addEventListener('input', () => {
	                    		amount = amountElement.value
	                    		amount = parseInt(amount)
	                    		amount = (isNaN(amount) || (amount==0) || (amount>${productoneId.amount}))?1:amount
	                    		render(amount)
	                    	})
	                    </script>
						<form name="f" action="" method="post">
							<c:set var="id" value="${productoneId.productId }"/>
							<button class="btn btn-sm text-dark p-0"
								onclick="shop('${productoneId.productId }')">
								<i class="fas fa-shopping-cart text-primary mr-1"></i>Add To Cart
							</button>
						</form>
						<script type="text/javascript">
							var Element = document.getElementById('amount')
	                    	var amount = Element.value
							function shop(id){
								document.f.action="shop-detail?id="+id+"&amount="+amount;
								document.f.submit();
							}
						</script>
					</div>
	        	</div>
	       </div>
		</div>
		<div class="row px-xl-5">
            <div class="col">
                <div class="nav nav-tabs justify-content-center border-secondary mb-4">
                    <a class="nav-item nav-link" data-toggle="tab" href="#tab-pane-1">Reviews (${count })</a>
                </div>
                <div class="tab-content">
                    <div class="tab-pane fade" id="tab-pane-1">
                        <div class="row">
                            <div class="col-md-6">
                                <h4 class="mb-4">Top 3 review for ${productoneId.productName}</h4>
                                <div class="media mb-4">
                                	<c:forEach items="${commentList }" var="c">
	                                    <div class="media-body">
	                                        <h5>${c.name }</h5>
	                                        <p>${c.review }</p>
	                                    </div>
	                                </c:forEach>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <h4 class="mb-4">Send a review</h4>
                                <small>Your email address will not be published. Required fields are marked *</small>
                                <form action="comment?id=${productoneId.productId }" method="post" enctype="multipart/form-data">
                                    <div class="form-group">
                                        <label for="message">Your Review *</label>
                                        <input type="text" class="form-control" id="review" name="review">
                                    </div>
                                    <div class="form-group">
                                        <label for="name">Your Name *</label>
                                        <input type="text" class="form-control" id="name" name="name">
                                    </div>
                                    <div class="form-group">
                                        <label for="email">Your Email *</label>
                                        <input type="email" class="form-control" id="email" name="email">
                                    </div>
                                    <div class="form-group mb-0">
                                        <input type="submit" value="Send Your Review" class="btn btn-primary px-3">
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Shop Detail End -->


<!-- Products Start -->
<div class="container-fluid py-5">
	<div class="text-center mb-4">
		<h2 class="section-title px-5">
			<span class="px-2">You May Also Like</span>
		</h2>
	</div>
	<div class="row px-xl-5">
		<div class="col">
			<div class="owl-carousel related-carousel owl-loaded owl-drag">
				<div class="row px-xl-5 pb-3">
					<c:forEach items="${productTop4ByCateId}" var="product">
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
									class="card-footer justify-content-between text-center bg-light border">
									<a
										href="<c:url value="/shop-detail?productId=${product.productId}"/>"
										class="btn btn-sm text-dark"><i
										class="fas fa-eye text-primary mr-1"></i>View Detail</a>
								</div>

							</div>
						</div>
					</c:forEach>
				</div>
				<!-- <div class="card product-item border-0">
                        <div class="card-header product-img position-relative overflow-hidden bg-transparent border p-0">
                            <img class="img-fluid w-100" src="img/product-1.jpg" alt="">
                        </div>
                        <div class="card-body border-left border-right text-center p-0 pt-4 pb-3">
                            <h6 class="text-truncate mb-3">Colorful Stylish Shirt</h6>
                            <div class="d-flex justify-content-center">
                                <h6>$123.00</h6><h6 class="text-muted ml-2"><del>$123.00</del></h6>
                            </div>
                        </div>
                        <div class="card-footer d-flex justify-content-between bg-light border">
                            <a href="" class="btn btn-sm text-dark p-0"><i class="fas fa-eye text-primary mr-1"></i>View Detail</a>
                            <a href="" class="btn btn-sm text-dark p-0"><i class="fas fa-shopping-cart text-primary mr-1"></i>Add To Cart</a>
                        </div>
                    </div> -->
			</div>
		</div>
	</div>
</div>
<!-- Products End -->
