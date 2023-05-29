<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
						<a href="user-management" class="dropdown-item">Users</a> <a
							href="category-management" class="dropdown-item">Categories</a> <a
							href="product-management" class="dropdown-item active">Products</a>
							<a href="order-management" class="dropdown-item">Order</a>
					</div>
				</div>

			</div>
		</nav>
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
						href="product-management/add">Add</a> 
						<a id="statisticButton" type="button" 
						class="btn btn-success rounded-pill m-2" data-toggle="modal" data-target="#chartModal">Statistics</a>


					</div>
				</div>
				<div class="table-responsive">
					<table
						class="table text-start align-middle table-bordered table-hover mb-0">
						<thead>
							<tr class="text-white">
								<th scope="col"><input class="form-check-input"
									type="checkbox"></th>
								<th scope="col">ProductId</th>
								<th scope="col">ProductName</th>
								<th scope="col">Description</th>
								<th scope="col">images</th>
								<th scope="col">Status</th>

							</tr>
						</thead>
						<tbody>
							<c:forEach items="${productList}" var="list">
								<tr>
									<td><input class="form-check-input" type="checkbox"></td>
									<td>${list.productId }</td>
									<td>${list.productName}</td>
									<td>${list.description}</td>
									<td><img class="rounded-circle" src="${list.images}"
										alt="" style="width: 70px; height: 70px;"></td>

									<c:if test="${list.status ==1 }">
										<td>Hoạt động</td>
									</c:if>
									<c:if test="${list.status ==0 }">
										<td>Khóa</td>
									</c:if>
									<td><a class="btn btn-sm btn-primary"
										href="<c:url value='/admin/product-management/edit?productId=${list.productId}'/>">Detail</a>
										<a class="btn btn-sm btn-light"
										href="<c:url value='/admin/product-management/delete?productId=${list.productId}'/>">Delete</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<br>
					<div class="col-12 pb-1">
						<ul class="pagination pull-right">
							<c:if test="${tag>1}">
								<li class="page-item active"><a class="page-link"
									href="<c:url value="/admin/product-management?index=${tag-1}"/>">Previous</a></li>
							</c:if>
							<c:forEach begin="1" end="${endP }" var="i">
								<li class='page-item ${tag == i ? "active":"" }'><a
									class="page-link"
									href="<c:url value="/admin/product-management?index=${i}"/>">${i }</a>
								</li>
							</c:forEach>
							<c:if test="${tag<endP}">
								<li class="page-item active"><a class="page-link"
									href="<c:url value="/admin/product-management?index=${tag+1}"/>">Next</a></li>
							</c:if>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Chart Modal -->
	<div class="modal fade" id="chartModal" tabindex="-1" role="dialog" width="800" height="600"
		aria-labelledby="chartModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="chartModalLabel">Product Category
						Chart</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true"></span>
					</button>
				</div>
				<div class="modal-body">
					<!-- Display the chart image -->
					<img src="${pageContext.request.contextPath}/imageChart/chart.png"
						alt="Product Category Chart" width="470" height="400">
				</div>
				<div class="modal-footer">
					<button type="button" id="closeButton" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Thêm mã JavaScript -->
<script>
	// Lắng nghe sự kiện click vào nút "Statistic"
	document.getElementById('statisticButton').addEventListener('click',
			function() {
				// Lấy đối tượng modal thông qua id
				var modal = document.getElementById('chartModal');

				// Hiển thị modal
				$(modal).modal('show');
			});
</script>
<!-- Thêm mã JavaScript -->
<script>
    // Lắng nghe sự kiện click vào nút "Close"
    document.getElementById('closeButton').addEventListener('click', function() {
        // Lấy đối tượng modal thông qua id
        var modal = document.getElementById('chartModal');

        // Đóng modal
        $(modal).modal('hide');
    });
</script>

<!-- Recent Sales End -->