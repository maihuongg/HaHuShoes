<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Sign Up Start -->
<div class="container-fluid">
	<div class="row h-100 align-items-center justify-content-center"
		style="min-height: 100vh;">
		<div class="col-12 col-sm-8 col-md-6 col-lg-5 col-xl-4">
			<div class="bg-secondary rounded p-4 p-sm-5 my-4 mx-3">
				<div class="d-flex align-items-center justify-content-between mb-3">
					<a href="" class="">
						<h3 class="text-primary">
							<i class="fa fa-user-edit me-2"></i>HaHuShoes
						</h3>
					</a>
					<h3>Sign Up</h3>
				</div>

				<form action="register" method="post">
					<div class="form-floating mb-3">
						<label for="floatingText">Username</label> <input type="text"
							name="username" class="form-control" placeholder="jhondoe">

					</div>
					<div class="form-floating mb-3">
						<label>Email address</label> <input type="email" name="email"
							class="form-control" placeholder="name@example.com">
					</div>
					<div class="form-floating mb-3">
						<label>Password</label> <input type="password" name="password"
							class="form-control" placeholder="Password">
					</div>
					<div class="form-floating mb-3">
						<label>Confirm Password</label> <input type="password"
							name="repeatpw" class="form-control" placeholder="Password">
					</div>

					<a href="">Forgot Password</a>
			</div>
			<br>
			<c:if test="${alert != null }">
					<h3 class="alert alert-info">${alert}</h3>
				</c:if>
			<button type="submit" class="btn btn-primary py-3 w-100 mb-4">Register</button>
			<p class="text-center mb-0">
				Already have an Account? <a
					href="${pageContext.request.contextPath }/login">Sign In</a>
			</p>
			</form>
		</div>
	</div>
</div>
</div>
<!-- Sign Up End -->
</div>