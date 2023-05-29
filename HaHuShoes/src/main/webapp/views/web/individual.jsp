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
					<c:forEach items="${cate3List}" var="cate">
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
							href="shop" class="nav-item nav-link ">Shop</a>
						<a href="cart" class="nav-item nav-link">Shopping Cart</a>
						<a href="contact" class="nav-item nav-link">Contact</a>
						<a href="order" class="nav-item nav-link">Order</a>
					</div>
					<div class="navbar-nav ml-auto py-0">
						<c:if test="${sessionScope.account != null}">
							<a class="nav-item nav-link active " href="individual?username=${sessionScope.account.userName} ">Hello
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
            <h1 class="font-weight-semi-bold text-uppercase mb-3">Individual Information</h1>
            <div class="d-inline-flex">
                <p class="m-0"><a href="">Home</a></p>
                <p class="m-0 px-2">-</p>
                <p class="m-0">Individual</p>
            </div>
        </div>
    </div>
    <!-- Page Header End -->


    <!-- Individual Start -->
    <div class="container-fluid pt-5">
        <div class="text-center mb-4">
            <h2 class="section-title px-5"><span class="px-2">Individual Information</span></h2>
        </div>
        <div class="row px-xl-5">
            <div class="col-lg-7 mb-5">
                <div class="contact-form">
                    <div id="success"></div>
                    <form name="individual" action="individual?username=${userModel.userName}" method="post"
								enctype="multipart/form-data">
                        <div class="control-group">
                            <input type="text" class="form-control" id="username" name="username" value="${userModel.userName}" placeholder="User Name" readonly />
                            <p class="help-block text-danger"></p>
                        </div>
                        <div class="control-group">
                            <input type="text" class="form-control" id="fullName" name="fullName" value="${userModel.fullName}" placeholder="Full Name"
                                required="required" data-validation-required-message="Please enter your name" />
                            <p class="help-block text-danger"></p>
                        </div>
                        <div class="control-group">
                            <input type="email" class="form-control" id="email" name="email" value="${userModel.email}" placeholder="Your Email"
                                required="required" data-validation-required-message="Please enter your email" />
                            <p class="help-block text-danger"></p>
                        </div>
                        <div class="control-group">
                            <input type="text" class="form-control" id="password" name="password" value="${userModel.password}" placeholder="Password"
                                required="required" data-validation-required-message="Please enter a subject" />
                            <p class="help-block text-danger"></p>
                        </div>
                        <div>
                            <button class="btn btn-primary py-2 px-4" type="submit" id="updateButton">Update</button>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-lg-5 mb-5">
                <h5 class="font-weight-semi-bold mb-3">Get In Touch</h5>
                <p>If you have an urgent problem, you can visit our store at the following address.</p>
                <div class="d-flex flex-column mb-3">
                    <h5 class="font-weight-semi-bold mb-3">Store</h5>
                    <p class="mb-2"><i class="fa fa-map-marker-alt text-primary mr-3"></i>No.1, Vo Van Ngan Street, Linh Chieu Ward, Thu Duc City</p>
                    <p class="mb-2"><i class="fa fa-envelope text-primary mr-3"></i>hangn3569@gmail.com or dangmaihuong1108@gmail.com</p>
                    <p class="mb-2"><i class="fa fa-phone-alt text-primary mr-3"></i>0387229936</p>
                </div>
            </div>
        </div>
    </div>
    <!-- Individual End -->
