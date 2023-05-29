<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    </div>
        <!-- Sidebar End -->

<!-- Recent Sales Start -->
<div class="content">
	<div class="container-fluid pt-4 px-4">
		<div class="bg-secondary text-center rounded p-4">
			<div class="d-flex align-items-center justify-content-between mb-4">
				<h2 class="mb-0">PRODUCT MANAGEMENT</h2>
				<div>
					<a type="button" class="btn btn-primary rounded-pill m-4"
						href="${pageContext.request.contextPath }/admin/product-management">Product
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
							<h4 class="mb-4">Information Product Form</h4>
							<div>
								<%-- class="alert alert-danger" role="alert">${alert} --%>
								<%-- <c:if test="${alert != null }">
									<h3 class="alert alert-danger">${alert}</h3>
								</c:if> --%>
							</div>
							<form role="form" action="edit" method="post"
								enctype="multipart/form-data">
								<div class="mb-3">
									<label class="form-label">id</label> <input type="text"
										name="productId" value="${oneUser.productId}"
										class="form-control" readonly>
								</div>
								<div class="mb-3">
									<label class="form-label">Product Name</label> <input
										type="text" name="productName" value="${oneUser.productName}"
										class="form-control">
								</div>
								<div class="mb-3">
									<label class="form-label">Product Code</label> <input
										type="text" name="productCode" value="${oneUser.productCode}"
										class="form-control">
								</div>
								<div class="mb-3">
									<label class="form-label">Description</label> <input
										type="text" name="descriptions" value="${oneUser.description}"
										class="form-control">
								</div>
								<div class="mb-3">
									<label class="form-label">Price</label> <input type="text"
										name="price" value="${oneUser.price}" class="form-control">
								</div>
								<div class="mb-3">
									<label class="form-label">Amount</label> <input type="text"
										name="amount" value="${oneUser.amount}" class="form-control">
								</div>
								<div class="mb-3">
									<label class="form-label">Stock</label> <input type="text"
										name="stock" value="${oneUser.stock}" class="form-control">
								</div>


								<div class="mb-3">
									<label for="formFile" class="form-label">Images</label> <img
										class="rounded-circle" src="${oneUser.images}" alt=""
										style="width: 70px; height: 70px;"> <input
										class="form-control bg-dark" name="images"
										value="${oneUser.images } " type="text" id="formFile">
								</div>
								<div class="mb-3">
									<label for="exampleFormControlSelect1">Category select</label> <select
										class="form-control" id="exampleFormControlSelect1"
										name="categoryId">

										<c:forEach items="${cateList}" var="list">
											<c:if test="${oneUser.categoryId} == ${list.categoryId}">
												<option selected value="${list.categoryId}">${list.categoryName}</option>
											</c:if>
											<option value="${list.categoryId}">${list.categoryName}</option>



										</c:forEach>
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