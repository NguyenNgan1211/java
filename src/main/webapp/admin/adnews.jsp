<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpServlet"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.text-limit {
	display: -webkit-box;
	-webkit-line-clamp: 4; /* Giới hạn số dòng */
	-webkit-box-orient: vertical;
	overflow: hidden;
	text-overflow: ellipsis; /* Hiển thị dấu ba chấm khi cắt ngắn */
	height: 5.6em;
	/* Điều chỉnh chiều cao cho 4 dòng (tùy vào font-size) */
}
</style>
<script>
	function doDelete(newsid) {
		if (confirm("are you sure to delete news with id = " + newsid)) {
			window.location = "DeleteNewsServlet?newsid=" + newsid;
		}
	}
</script>
<jsp:include page="adheader.jsp" />
<main id="main" class="main">
	<div class="pagetitle">
		<h2>Danh sách các bài viết</h2>
	</div>
	<p>
		<a href="${pageContext.request.contextPath}/admin/addNews.jsp"
			type="button" class="btn btn-success"> <i
			class="bi bi-file-earmark-text me-1"></i>Thêm bài viết
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
									<th class="col-2 text-center">Tiêu đề</th>
									<td class="col-3 text-center fw-bold">Nội dung</td>
									<td class="col-1 text-center fw-bold">Tên tác giả</td> 
									<td class="col-1 text-center fw-bold">Tên danh mục</td>
									<td class="col-1 text-center fw-bold">Ảnh</td>
									<th class="col-2 text-center">Chức năng</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${news1}" var="items">
									<tr>
										<th class="text-center" scope="row">${items.newsid}</th>
										<td><a class="text-primary">${items.newstitle}</a></td>
										<td class="text-center">
											<div class="text-limit">
												<p>${items.newscontent}</p>
												<!-- Ví dụ hiển thị nội dung bài viết -->
											</div>
										</td>

										<td class="text-center">${items.authorname}</td>
										<td class="text-center">${items.menuname}</td>
										<td class="text-center"><img
											src="${pageContext.request.contextPath}/asset${items.image}"
											alt="" style="max-width: 100px; max-height: 100px;" /></td>

										<td class="text-center"><a
											href="UpdateNewsServlet?newsid=${items.newsid }"
											class="btn btn-primary btn-sm" title="Sửa danh mục"><i
												class="bi bi-pencil"></i></a> <a href="#"
											onclick="doDelete('${items.newsid}')"
											class="btn btn-danger btn-sm" title="Xóa danh mục"><i
												class="bi bi-trash"></i></a></td>
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
