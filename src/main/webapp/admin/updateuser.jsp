<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/admin/adheader.jsp" />

<div style="max-width: 600px; margin: 50px auto; padding: 20px; border: 1px solid #ccc; border-radius: 10px; background-color: #f9f9f9; box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);">
	<h2 style="text-align: center; color: #333; margin-bottom: 20px;">Cập nhật thông tin người dùng</h2>
	
	<c:set value="${user}" var="c" />
	<form action="${pageContext.request.contextPath}/admin/UpdateuserServlet" method="post" style="display: flex; flex-direction: column; gap: 15px;">
		<!-- Hidden User ID -->
		<input type="hidden" name="userid" value="${c.userid}" />

		<!-- Username -->
		<div>
			<label for="username" style="font-weight: bold; margin-bottom: 5px; display: block;">Tên người dùng</label>
			<input type="text" id="username" name="username" value="${c.username}" class="form-control" style="width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 5px;" />
		</div>

		<!-- Password -->
		<div>
			<label for="password" style="font-weight: bold; margin-bottom: 5px; display: block;">Mật khẩu</label>
			<input type="text" id="password" name="password" value="${c.password}" class="form-control" style="width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 5px;" />
		</div>

		<!-- Phone -->
		<div>
			<label for="phone" style="font-weight: bold; margin-bottom: 5px; display: block;">Số điện thoại</label>
			<input type="text" id="phone" name="phone" value="${c.phone}" class="form-control" style="width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 5px;" />
		</div>

		<!-- Address -->
		<div>
			<label for="address" style="font-weight: bold; margin-bottom: 5px; display: block;">Địa chỉ</label>
			<input type="text" id="address" name="address" value="${c.address}" class="form-control" style="width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 5px;" />
		</div>

		<!-- Role Selection -->
		<div>
			<label for="role" style="font-weight: bold; margin-bottom: 5px; display: block;">Phân quyền</label>
			<select id="role" name="role" class="form-control" style="width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 5px;">
				<option value="1" <c:if test="${c.role == 1}">selected</c:if>>Người dùng</option>
				<option value="0" <c:if test="${c.role == 0}">selected</c:if>>Admin</option>
			</select>
		</div>

		<!-- Submit Button -->
		<div style="text-align: center; margin-top: 20px;">
			<input type="submit" value="Cập nhật" style="background-color: #007bff; color: #fff; border: none; padding: 10px 20px; border-radius: 5px; cursor: pointer; font-size: 16px;" />
		</div>
	</form>
</div>
