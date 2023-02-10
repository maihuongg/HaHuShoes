<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="d-flex flex-column align-items-center justify-content-center" >
            <h1 class="font-weight-semi-bold text-uppercase mb-3" style="text-align: center; padding-top: 20px;color: white;">HAHUSHOES</h1>
            <div class="d-inline-flex">
                <h2 class="m-0" style="text-align: center;"> <a href="home">Back to Home  </a></h2> 
                
                <p class="m-0 px-2">-</p>
                
            </div>
        </div>
<div class="container"
	style="position: absolute; top: 50%; left: 50%; transform: translate(-50%, -50%); width: 450px; background: white; border-radius: 10px; box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.05);">


	<body style="background: linear-gradient(120deg, #3ca7ee, #9b408f); height: 100vh; overflow: hidden;">
	
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