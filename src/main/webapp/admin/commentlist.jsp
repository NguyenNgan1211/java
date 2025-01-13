<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="jakarta.servlet.http.HttpServlet"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="adheader.jsp" />
<script type="text/javascript">
    function doDelete(cmtid) {
        if (confirm("Bạn có chắc muốn xóa không? " +cmtid)) {
            window.location ="${pageContext.request.contextPath}/DeletecommentServlet?cmtid=" + cmtid;
        }
    }
</script>
<main id="main" class="main">
	<div class="pagetitle">
		<h2>Danh sách các bình luận</h2>
	</div>
	<p>
		<a href="${pageContext.request.contextPath}/admin/addcomment.jsp"  type="button" class="btn btn-success">
			<i class="bi bi-file-earmark-text me-1"></i>Thêm bình luận
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
									<th class="col-1 text-center">Người dùng</th>
									<td class="col-4 text-center fw-bold">Bài viết</td>
									<td class="col-1 text-center fw-bold">Bình luận</td>
									<td class="col-1 text-center fw-bold">Trạng thái</td>
									<td class="col-1 text-center fw-bold">Ngày bình luận</td>	
									<th class="col-2 text-center">Chức năng</th>
								</tr>
							</thead>
							<tbody>
									<c:forEach items="${data}" var = "items" >
									<tr>
										<th class="text-center" scope="row">${items.cmtid}</th>
										<td>
											<a  class="text-primary">${items.username}</a>
										</td>
										<td class="text-center">${items.newstitle}</td>
										<td class="text-center">${items.content}</td>
									    <td class="text-center">${items.status}</td>
									    <td class="text-center">${items.created_at}</td>

										<td class="text-center">
											<a href="${pageContext.request.contextPath}/admin/UpdatecommentServlet?cmtid=${items.cmtid}" class="btn btn-primary btn-sm"
										   title="Sửa bình luận"><i class="bi bi-pencil"></i></a>
											<a href="#" onclick="doDelete('${items.cmtid}')" class="btn btn-danger btn-sm"
										   title="Xóa bình luận"><i class="bi bi-trash"></i></a>
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
