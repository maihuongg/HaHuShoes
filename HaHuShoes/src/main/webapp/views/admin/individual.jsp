<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Recent Sales Start -->
<div class="container-fluid position-relative d-flex p-0">
        <!-- Spinner Start -->
        <div id="spinner" class="show bg-dark position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
            <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
                <span class="sr-only">Loading...</span>
            </div>
        </div>
        <!-- Spinner End -->


        <!-- Sidebar Start -->
        <div class="sidebar pe-4 pb-3">
            <nav class="navbar bg-secondary navbar-dark">
                <a href="dashboard?username=${sessionScope.account.userName}" class="navbar-brand mx-4 mb-3">
                    <h3 class="text-primary"><i class="fa fa-user-edit me-2"></i>HaHuShoes</h3>
                </a>
                <div class="d-flex align-items-center ms-4 mb-4">
                    <div class="position-relative">
                        <img class="rounded-circle" src="https://image.shutterstock.com/image-vector/social-member-vector-icon-person-260nw-1139787308.jpg" alt="" style="width: 40px; height: 40px;">
                        <div class="bg-success rounded-circle border border-2 border-white position-absolute end-0 bottom-0 p-1"></div>
                    </div>
                    <div class="ms-3">
                        <h6 class="mb-0">${sessionScope.account.userName}</h6>
                        <span>Admin</span>
                    </div>
                </div>
                <div class="navbar-nav w-100">
                    <a href="${pageContext.request.contextPath }/admin/dashboard?username=${sessionScope.account.userName}" class="nav-item nav-link active"><i class="fa fa-tachometer-alt me-2 "></i>Dashboard</a>
                    <div class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown"><i class="fa fa-laptop me-2"></i> Management </a>
                        <div class="dropdown-menu bg-transparent border-0">
                            <a href="user-management" class="dropdown-item">Users</a>
                            <a href="category-management" class="dropdown-item">Categories</a>
                            <a href="product-management" class="dropdown-item">Products</a>
                            <a href="order-management" class="dropdown-item">Order</a>
                        </div>
                    </div>
                   
                </div>
            </nav>
        </div>
    </div>
        <!-- Sidebar End -->

<div class="content">
	<div class="container-fluid pt-4 px-4">
		<div class="bg-secondary text-center rounded p-4">
			<div class="d-flex align-items-center justify-content-between mb-4">
				<h2 class="mb-0">USER MANAGEMENT</h2>
				<div>
					<a type="button" class="btn btn-primary rounded-pill m-4"
						href="${pageContext.request.contextPath }/admin/user-management">User
						Management</a> <a type="button"
						class="btn btn-success rounded-pill m-2">Export to Excel</a>
				</div>
			</div>
		</div>
		<div class="container-fluid pt-4 px-4">
			<div class="bg-secondary rounded p-4">

				<div class="row g-4">
					<div class="col-sm-12 col-xl-6">
						<div class="bg-secondary rounded h-100 p-4">
							<h4 class="mb-4">Individual Information Form</h4>
							<div class="alert alert-danger" role="alert">${alert}
								<%-- <c:if test="${alert != null }">
									<h3 class="alert alert-danger">${alert}</h3>
								</c:if> --%>
							</div>
							<form role="form" action="${pageContext.request.contextPath}/admin/individual?username=${sessionScope.account.userName}" method="post"
								enctype="multipart/form-data">
								
								<div class="mb-3">
									<label class="form-label">Username</label> <input type="text"
										name="username" value="${userModel.userName}"
										class="form-control">
								</div>
								<div class="mb-3">
									<label class="form-label">Fullname</label> <input type="text"
										name="fullName" value="${userModel.fullName}"
										class="form-control">
								</div>
								<div class="mb-3">
									<label for="exampleInputEmail1" class="form-label">Email
										address</label> <input type="email" name="email" class="form-control"
										id="exampleInputEmail1" aria-describedby="emailHelp"
										value="${userModel.email }">
								</div>
								<div class="mb-3">
									<label class="form-label">Password</label> <input
										type="password" name="password" value="${userModel.password}"
										class="form-control">
								</div>
								<div class="mb-3">
									<label for="exampleFormControlSelect1">RoleID</label> <select
										class="form-control" id="exampleFormControlSelect1"
										name="roleId">
										<c:if test="${userModel.roleId == 1 }">
											<option selected value="1">Admin</option>

										</c:if>

										<c:if test="${userModel.roleId == 2 }">
											<option selected value="2">Seller</option>
											<option value="2">Seller</option>
										</c:if>
										<c:if test="${userModel.roleId == 3 }">
											<option selected value="3">User</option>
										</c:if>
										<!-- <option value="1">Admin</option>
										<option value="2">Seller</option>
										<option value="3">User</option> -->



									</select>
								</div>
								<button type="submit" class="btn btn-primary">Edit</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
</div>
<!-- Recent Sales End -->