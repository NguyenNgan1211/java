<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
           <%@ page import="jakarta.servlet.http.HttpServlet"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
function doDelete(menuid){
	if(confirm("are you sure to delete user with id = " + menuid)){
		window.location = "DeleteMenuServlet?menuid="+ menuid;
	}
}
</script>
	<jsp:include page="adheader.jsp" />
	<main id="main" class="main">
	<div class="pagetitle">
		<h2>Danh sách các danh mục</h2>
	</div>
	<p>
		<a href="${pageContext.request.contextPath}/admin/addMenu.jsp" type="button" class="btn btn-success">
			<i class="bi bi-file-earmark-text me-1"></i>Thêm danh mục
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
									<th class="col-1 text-center">#</th>
									<th class="col-1 text-center">Menuname</th>
									<td class="col-1 text-center fw-bold">Menudescription</td>
									<th class="col-2 text-center">Chức năng</th>
								</tr>
							</thead>
							<tbody>
									<c:forEach items="${menu1}" var = "items" >
									<tr>
										<th class="text-center" scope="row">${items.menuid}</th>
										<td>
											<a  class="text-primary">${items.menuname}</a>
										</td>
										<td class="text-center">${items.menudescription}</td>
										
									
										<td class="text-center">
											<a href="UpdateMenuServlet?menuid=${items.menuid }" class="btn btn-primary btn-sm"
										   title="Sửa danh mục"><i class="bi bi-pencil"></i></a>
											<a href="#" onclick="doDelete('${items.menuid}')" class="btn btn-danger btn-sm"
										   title="Xóa danh mục"><i class="bi bi-trash"></i></a>
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
