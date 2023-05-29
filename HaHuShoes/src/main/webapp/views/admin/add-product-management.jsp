
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/darkpan-1.0.0/" var="URL"></c:url>
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
                            <a href="/Lecture03/admin/user-management" class="dropdown-item" >Users</a>
                            <a href="/Lecture03/admin/category-management" class="dropdown-item">Categories</a>
                            <a href="/Lecture03/admin/product-management" class="dropdown-item active">Products</a>
                            <a href="/Lecture03/admin/order-management" class="dropdown-item">Orders</a>
                        </div>
                    </div>
                   
                </div>
            </nav>
        </div>
        <!-- Sidebar End -->

<div class="content">

	<div class="container-fluid pt-4 px-4">
		<div class="bg-secondary text-center rounded p-4">
			<div class="d-flex align-items-center justify-content-between mb-4">
				<h2 class="mb-0">PRODUCT MANAGEMENT</h2>
				<div>
					<a
						href="${pageContext.request.contextPath }/admin/product-management"
						type="button" class="btn btn-success rounded-pill m-2">Exit</a>
				</div>
			</div>
		</div>
		<!-- Form Start -->
		<div class="container-fluid pt-4 px-4">
			<div class="bg-secondary rounded p-4">

				<div class="row g-4">
					<div class="col-sm-12 col-xl-6">
						<div class="bg-secondary rounded h-100 p-4">
							<h4 class="mb-4">Add Product Form</h4>

							<form role="form" action="add" method="post"
								enctype="multipart/form-data">

								<div class="mb-3">

									<label class="form-label">Product Name</label> <input
										type="text" class="form-control" name="productName">
								</div>

								<div class="mb-3">
									<label class="form-label">ProductCode</label> <input
										type="text" class="form-control" name="productCode">
								</div>

								<div class="mb-3">
									<label class="form-label">Description</label> <input
										type="text" class="form-control" name="descriptions">
								</div>
								<div class="mb-3">
									<label class="form-label">Price</label> <input type="text"
										class="form-control" name="price">
								</div>
								<div class="mb-3">
									<label class="form-label">Amount</label> <input type="text"
										class="form-control" name="amount">
								</div>
								<div class="mb-3">
									<label class="form-label">Stock</label> <input type="text"
										class="form-control" name="stock">
								</div>
								<!-- <div class="mb-3">
									<label class="form-label">CreateDate</label> <input type="text"
										class="form-control" name="createDate">
								</div> -->
								<div class="mb-3">
									<label for="formFile" class="form-label">Images</label> <input
										class="form-control bg-dark" type="text" id="formFile"
										name="images">
								</div>
								<div class="mb-3">
									<label for="exampleFormControlSelect1">Category Select</label>
									<select class="form-control" id="roleId" name="categoryId">
										<c:forEach items="${cateList}" var="list">
											<option value="${list.categoryId}">${list.categoryName}</option>
										</c:forEach>
									</select>
								</div>
								<div class="mb-3">
									<label for="exampleFormControlSelect1">Status</label> <select
										class="form-control" id="roleId" name="status">
										<option value="1">Active</option>
										<option value="0">Closed</option>
										
									</select>
								</div>

								<button type="submit" class="btn btn-primary">Add</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>