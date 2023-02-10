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
                            <a href="user-management" class="dropdown-item active" >Users</a>
                            <a href="category-management" class="dropdown-item">Categories</a>
                            <a href="product-management" class="dropdown-item">Products</a>
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
				<h2 class="mb-0">USER MANAGEMENT</h2>
				<div>
					<a type="button" class="btn btn-primary rounded-pill m-4"
						href="user-management/add">Add</a> <a type="button"
						class="btn btn-success rounded-pill m-2">Export to Excel</a>
				</div>
			</div>
		</div>
		<!-- <div class="container-fluid pt-4 px-4">
			<div class="bg-secondary rounded p-4">

				<div class="row g-4">
					<div class="col-sm-12 col-xl-6">
						<div class="bg-secondary rounded h-100 p-4">
							<h4 class="mb-4">Add User Form</h4>
							<form>
								<div class="mb-3">
									<label class="form-label">Fullname</label> <input type="text"
										class="form-control">
								</div>
								<div class="mb-3">
									<label for="exampleInputEmail1" class="form-label">Email
										address</label> <input type="email" class="form-control"
										id="exampleInputEmail1" aria-describedby="emailHelp">
								</div>
								<div class="mb-3">
									<label class="form-label">Password</label> <input
										type="password" class="form-control">
								</div>
								<div class="mb-3">
                                <label for="formFile" class="form-label">Images</label>
                                <input class="form-control bg-dark" type="file" id="formFile">
                            </div>
								<div class="mb-3">
									<label for="exampleFormControlSelect1">RoleID select</label> <select
										class="form-control" id="exampleFormControlSelect1">
										<option>Admin</option>
										<option>Seller</option>
										<option>Khách</option>										
									</select>
								</div>
								<button type="submit" class="btn btn-primary"> Add </button>
							</form>
						</div>
					</div>
				</div></div></div> -->
		<div class="container-fluid pt-4 px-4">
			<div class="bg-secondary text-center rounded p-4">
				<div class="table-responsive">
					<table
						class="table text-start align-middle table-bordered table-hover mb-0">
						<thead>
							<tr class="text-white">
								<th scope="col"><input class="form-check-input"
									type="checkbox"></th>
								<th scope="col">Họ tên</th>
								<th scope="col">Email</th>
								<th scope="col">Username</th>
								<th scope="col">Role</th>
								<th scope="col">Status</th>


							</tr>
						</thead>
						<tbody>
							<c:forEach items="${userList}" var="list">
								<tr>
									<td><input class="form-check-input" type="checkbox"></td>
									<td>${list.fullName }</td>
									<td>${list.email}</td>
									<td>${list.userName}</td>
									<%-- <td> ${}=3 </td> --%>
									<c:if test="${list.roleId ==3 }">
										<td>Khách hàng</td>
									</c:if>
									<c:if test="${list.roleId ==2 }">
										<td>Seller</td>
									</c:if>
									<c:if test="${list.roleId ==1 }">
										<td>Admin</td>
									</c:if>

									<c:if test="${list.status ==1 }">
										<td>Hoạt động</td>
									</c:if>
									<c:if test="${list.status ==0 }">
										<td>Khóa</td>
									</c:if>
									<td><a class="btn btn-sm btn-primary"
										href="<c:url value='/admin/user-management/edit?userName=${list.userName}'/>">Detail</a>
										<a class="btn btn-sm btn-light"
										href="<c:url value='/admin/user-management/delete?userName=${list.userName}'/>">Delete</a></td>

								</tr>
							</c:forEach>
						</tbody>
					</table>
					<br>
					<div class="col-12 pb-1">
						<ul class="pagination pull-right">
							<c:if test="${tag>1}">
								<li class="page-item active"><a class="page-link"
									href="<c:url value="/admin/user-management?index=${tag-1}"/>">Previous</a></li>
							</c:if>
							<c:forEach begin="1" end="${endP }" var="i">
								<li class='page-item ${tag == i ? "active":"" }'><a
									class="page-link"
									href="<c:url value="/admin/user-management?index=${i}"/>">${i }</a>
								</li>
							</c:forEach>
							<c:if test="${tag<endP}">
								<li class="page-item active"><a class="page-link"
									href="<c:url value="/admin/user-management?index=${tag+1}"/>">Next</a></li>
							</c:if>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<!-- Recent Sales End -->