<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- <div class="d-flex flex-column align-items-center justify-content-center" >
            <h1 class="font-weight-semi-bold text-uppercase mb-3" style="text-align: center; padding-top: 20px;color: white;">HAHUSHOES</h1>
            <div class="d-inline-flex">
                <h2 class="m-0" style="text-align: center;"> <a href="home">Back to Home  </a></h2> 
                
                <p class="m-0 px-2">-</p>
                
            </div>
        </div> -->


<!-- Navbar Start -->
<div class="container-fluid mb-5">
	<div class="row border-top px-xl-5">
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
					</div>
					<div class="navbar-nav ml-auto py-0">
						<c:if test="${sessionScope.account == null}">
							<a href="" class="nav-item nav-link">Register</a>
						</c:if>

					</div>
				</div>
			</nav>
		</div>
	</div>
</div>
<!-- Navbar End -->

<div class="container"
	style="position: absolute; top: 50%; left: 50%; transform: translate(-50%, -50%); width: 450px; background: white; border-radius: 10px; box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.05);">


	<body>
	
		<div class="container py-5 h-100" style="padding: 0 40px;">
			<div
				class="row d-flex align-items-center justify-content-center h-100">

				<div class="col-md-7 col-lg-5 col-xl-5 offset-xl-1">
					<form id="sky-form1" class="log-reg-block sky-form" action="login"
						method="post">
						<h2 style="text-align: center; padding-top: 20px;">LOGIN</h2>
						<c:if test="${alert != null }">
							<h3 class="alert alert-danger">${alert}</h3>
						</c:if>
						<div class="form-outline mb-4">
							<input type="text" id="form1Example13" placeholder="User name"
								name="username" value="${sessionScope.account.userName}"  class="form-control form-control-lg"
								style="width: 100%; height: 40px; font-size: 16px; background: none;display:block; border-radius: 10px; border: 1px solid #dce7f1">
						</div>

						<div class="form-outline mb-4" style="padding-bottom: 10px">
							<input type="password" id="form1Example13" placeholder="Password"
								name="password" value="${sessionScope.account.userName}"class="form-control form-control-lg"
								style="width: 100%; height: 40px; font-size: 16px; background: none ;display:block;border-radius: 10px ; border: 1px solid #dce7f1 ">
						</div>

						<div class="d-flex justify-content-around align-items-center mb-4">
							<!-- Checkbox -->
							<div class="form-check">
								<label class="checkbox"><input type="checkbox" 
									name="remember" /><i></i>Remember me </label>
							</div>
							<a href="forgotPassword">Forgot password?</a>
						</div>

						<!-- Submit button -->
						<button type="submit" class="btn btn-primary btn-lg btn-block"
							style="margin-top: 20px; width: 100%; height: 50px; border: 1px solid; background: #2691d9; border-radius: 25px; font-size: 18px; color: #e9f4fb; font-weight: 700; cursor: pointer; outline: none; transition: 0.5s;">Sign
							in</button>
						<p class="mt-4 text-center">
							Don't have an account? <a
								href="${pageContext.request.contextPath }/register">Register</a>
						</p>
					</form>
				</div>
			</div>
		</div>
	</body>
</div>