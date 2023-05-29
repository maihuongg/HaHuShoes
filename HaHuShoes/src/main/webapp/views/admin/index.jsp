<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/darkpan-1.0.0/" var="URL"></c:url>
<div class="container-fluid position-relative d-flex p-0">
	<!-- Spinner Start -->
	<div id="spinner"
		class="show bg-dark position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
		<div class="spinner-border text-primary"
			style="width: 3rem; height: 3rem;" role="status">
			<span class="sr-only">Loading...</span>
		</div>
	</div>
	<!-- Spinner End -->


	<!-- Sidebar Start -->
	<div class="sidebar pe-4 pb-3">
		<nav class="navbar bg-secondary navbar-dark">
			<a href="dashboard?username=${sessionScope.account.userName}"
				class="navbar-brand mx-4 mb-3">
				<h3 class="text-primary">
					<i class="fa fa-user-edit me-2"></i>HaHuShoes
				</h3>
			</a>
			<div class="d-flex align-items-center ms-4 mb-4">
				<div class="position-relative">
					<img class="rounded-circle"
						src="https://image.shutterstock.com/image-vector/social-member-vector-icon-person-260nw-1139787308.jpg"
						alt="" style="width: 40px; height: 40px;">
					<div
						class="bg-success rounded-circle border border-2 border-white position-absolute end-0 bottom-0 p-1"></div>
				</div>
				<div class="ms-3">
					<h6 class="mb-0">${sessionScope.account.userName}</h6>
					<span>Admin</span>
				</div>
			</div>
			<div class="navbar-nav w-100">
				<a
					href="${pageContext.request.contextPath }/admin/dashboard?username=${sessionScope.account.userName}"
					class="nav-item nav-link active"><i
					class="fa fa-tachometer-alt me-2 "></i>Dashboard</a>
				<div class="nav-item dropdown">
					<a href="#" class="nav-link dropdown-toggle"
						data-bs-toggle="dropdown"><i class="fa fa-laptop me-2"></i>
						Management </a>
					<div class="dropdown-menu bg-transparent border-0">
						<a href="user-management" class="dropdown-item ">Users</a> <a
							href="category-management" class="dropdown-item">Categories</a> <a
							href="product-management" class="dropdown-item">Products</a>
						<a href="order-management" class="dropdown-item">Order</a>
					</div>
				</div>

			</div>
		</nav>
	</div>
	<!-- Sidebar End -->

	<!-- Content Start -->
	<div class="content">
		<!-- Navbar Start -->
		<nav
			class="navbar navbar-expand bg-secondary navbar-dark sticky-top px-4 py-0">
			<a href="index.html" class="navbar-brand d-flex d-lg-none me-4">
				<h2 class="text-primary mb-0">
					<i class="fa fa-user-edit"></i>
				</h2>
			</a> <a href="#" class="sidebar-toggler flex-shrink-0"> <i
				class="fa fa-bars"></i>
			</a>
			<div class="navbar-nav align-items-center ms-auto">
				<div class="nav-item dropdown">
					<a href="#" class="nav-link dropdown-toggle"
						data-bs-toggle="dropdown"> <img class="rounded-circle me-lg-2"
						src="https://image.shutterstock.com/image-vector/social-member-vector-icon-person-260nw-1139787308.jpg"
						alt="" style="width: 40px; height: 40px;"> <span
						class="d-none d-lg-inline-flex">${sessionScope.account.userName}</span>
					</a>
					<div
						class="dropdown-menu dropdown-menu-end bg-secondary border-0 rounded-0 rounded-bottom m-0">
						<a
							href="${pageContext.request.contextPath}/admin/individual?username=${sessionScope.account.userName}"
							class="dropdown-item">My Profile</a> <a
							href="${pageContext.request.contextPath}/logout"
							class="dropdown-item">Log Out</a>
					</div>
				</div>
			</div>
		</nav>
		<!-- Navbar End -->


		<!-- Sale & Revenue Start -->
		<div class="container-fluid pt-4 px-4">
			<div class="row g-4">
				<div class="col-sm-6 col-xl-3">
					<div
						class="bg-secondary rounded d-flex align-items-center justify-content-between p-4">
						<i class="fa fa-chart-line fa-3x text-primary"></i>
						<div class="ms-3">
							<p class="mb-2">Today Sale</p>
							<h6 class="mb-0">${totalMoney }VNĐ</h6>
						</div>
					</div>
				</div>
				<div class="col-sm-6 col-xl-3">
					<div
						class="bg-secondary rounded d-flex align-items-center justify-content-between p-4">
						<i class="fa fa-chart-bar fa-3x text-primary"></i>
						<div class="ms-3">
							<p class="mb-2">Total Product</p>
							<h6 class="mb-0">${totalProduct}</h6>
						</div>
					</div>
				</div>
				<div class="col-sm-6 col-xl-3">
					<div
						class="bg-secondary rounded d-flex align-items-center justify-content-between p-4">
						<i class="fa fa-chart-area fa-3x text-primary"></i>
						<div class="ms-3">
							<p class="mb-2">Total Category</p>
							<h6 class="mb-0">${totalCategory}</h6>
						</div>
					</div>
				</div>
				<div class="col-sm-6 col-xl-3">
					<div
						class="bg-secondary rounded d-flex align-items-center justify-content-between p-4">
						<i class="fa fa-chart-pie fa-3x text-primary"></i>
						<div class="ms-3">
							<p class="mb-2">Total User</p>
							<h6 class="mb-0">${totalUsers}</h6>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="container-fluid pt-4 px-4">
			<div class="bg-secondary text-center rounded p-4">
				<div class="table-responsive">
					<table
						class="table text-start align-middle table-bordered table-hover mb-0">
						<thead>
							<tr class="text-white">
								<th>OrderId</th>
								<th>Date</th>
								<th>Total Money</th>
								<th> </th>
							</tr>
						</thead>
						<tbody class="align-middle">
							<c:forEach items="${orderList}" var="i">
								<tr>
									<td class="align-middle">${i.orderId }</td>
									<td class="align-middle">${i.datetime }</td>
									<td class="align-middle">${i.totalMoney}VNĐ</td>
									<td>
										<a class="btn btn-sm btn-primary"
										href="<c:url value='/admin/confirm?orderId=${i.orderId}'/>">Confirm</a>
										<a class="btn btn-sm btn-light"
										href="<c:url value='/admin/orderdetail?orderId=${i.orderId}'/>">Detail</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<br>
					<div class="col-12 pb-1">
						<ul class="pagination pull-right">
							<c:if test="${tag>1}">
								<li class="page-item active"><a class="page-link"
									href="<c:url value="/admin/dashboard?index=${tag-1}"/>">Previous</a></li>
							</c:if>
							<c:forEach begin="1" end="${endP }" var="i">
								<li class='page-item ${tag == i ? "active":"" }'><a
									class="page-link"
									href="<c:url value="/admin/dashboard?index=${i}"/>">${i }</a>
								</li>
							</c:forEach>
							<c:if test="${tag<endP}">
								<li class="page-item active"><a class="page-link"
									href="<c:url value="/admin/dashboard?index=${tag+1}"/>">Next</a></li>
							</c:if>
						</ul>
					</div>
				</div>
			</div>
		</div>

		<!-- Footer Start -->
		<div class="container-fluid pt-4 px-4">
			<div class="bg-secondary rounded-top p-4">
				<div class="row">
					<div class="col-12 col-sm-6 text-center text-sm-start">
						&copy; <a href="#">HaHuShoes</a>, All Right Reserved.
					</div>
					<div class="col-12 col-sm-6 text-center text-sm-end">
						<!--/*** This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
						ĐẶNG MAI HƯƠNG <br>NGUYỄN THỊ THU HẰNG
					</div>
				</div>
			</div>
		</div>
		<!-- Footer End -->
	</div>

</div>

