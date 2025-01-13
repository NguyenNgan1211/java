<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>



<jsp:include page="adheader.jsp" />
<script type="text/javascript">
    function doDelete(userid) {
        if (confirm("Bạn có chắc muốn xóa không? " + userid)) {
            window.location = "${pageContext.request.contextPath}/admin/DeleteuserServlet?userid=" + userid;
        }
    }
    
</script>

	<main id="main" class="main">
	<div class="pagetitle">
		<h2>Danh sách các người dùng</h2>
	</div>
	<p>
		<a href="${pageContext.request.contextPath}/admin/adduser.jsp" type="button" class="btn btn-success">
    <i class="bi bi-file-earmark-text me-1"></i>Thêm người dùng
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
									<th class="col-1 text-center">Họ và tên</th>
									<td class="col-4 text-center">Password</td>
									<td class="col-1 text-center">Phone</td>
									<td class="col-1 text-center">Địa chỉ</td>
									<td class="col-1 text-center">Phân quyền</td>	
									<th class="col-2 text-center">Chức năng</th>
								</tr>
							</thead>
							<tbody>
									<c:forEach items="${data}" var = "list" >
									<tr>
										<th class="text-center" scope="row">${list.userid}</th>
										<td>
											<a  class="text-primary">${list.username}</a>
										</td>
										<td class="text-center">${list.password}</td>
										<td class="text-center">${list.phone}</td>
									    <td class="text-center">${list.address}</td>
									    <td class="text-center">${list.role}</td>

										<td class="text-center">
											<a href="${pageContext.request.contextPath}/admin/UpdateuserServlet?userid=${list.userid}" class="btn btn-primary btn-sm"
										   title="Sửa người dùng"><i class="bi bi-pencil"></i></a>
											<a href="#" onclick="doDelete('${list.userid}')" class="btn btn-danger btn-sm"
										   title="Xóa người dùng"><i class="bi bi-trash"></i></a>
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