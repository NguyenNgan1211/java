<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>



<jsp:include page="adheader.jsp" />
<script type="text/javascript">
    function doDelete(id) {
        if (confirm("Bạn có chắc muốn xóa không? " + id)) {
            window.location = "DeleteauthorServlet?id=" + id;
        }
    }
</script>
	<main id="main" class="main">
	<div class="pagetitle">
		<h2>Danh sách các tác giả</h2>
	</div>
	<p>
		<a href="${pageContext.request.contextPath}/admin/addauthor.jsp"  type="button" class="btn btn-success">
    <i class="bi bi-file-earmark-text me-1"></i>Thêm tác giả
</a>
	</p>
	<section class="section-title dashboard">
		<div class="row">
			<div class="col-12">
				<div class="card recent-sales overflow-auto">
					<div class="card-body mt-4">
						<table class="table table-borderless datatable">
							<thead>
								<tr>
									<th class="col-1 text-center">Id</th>
									<th class="col-1 text-center">Họ và tên</th>
									<td class="col-4 text-center">Email</td>
									<td class="col-1 text-center">Số điện thoại</td>
									<th class="col-2 text-center">Chức năng</th>
								</tr>
							</thead>
							<tbody>
									<c:forEach items="${data}" var = "list" >
									<tr>
										<th class="text-center" scope="row">${list.id}</th>
										<td>
											<a  class="text-primary">${list.authorname}</a>
										</td>
										<td class="text-center">${list.email}</td>
										<td class="text-center">${list.phone}</td>
									   

										<td class="text-center">
											<a href="${pageContext.request.contextPath}/admin/UpdateauthorServlet?id=${list.id}" class="btn btn-primary btn-sm"
										   title="Sửa tác giả"><i class="bi bi-pencil"></i></a>
											<a href="#" onclick="doDelete('${list.id}')" class="btn btn-danger btn-sm"
										   title="Xóa tác giả"><i class="bi bi-trash"></i></a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</section>
</main>