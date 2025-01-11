
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<jsp:include page="/admin/adheader.jsp" />
<div style="text-align: center; margin-top: 100px;">
	<h2>Update user</h2>
	<c:set value="${user}" var="c" />
	<form
		action="${pageContext.request.contextPath}/admin/UpdateuserServlet"
		method="post">
		<input type="hidden" name="userid" value="${c.userid}" /> <label>Enter
			Userid</label> <input type="hidden" name="userid" value="${c.userid}" /> <label>Enter
			username</label> <input type="text" name="username" value="${c.username}" /><br />
		<label>Enter password</label> <input type="text" name="password"
			value="${c.password}" /><br /> <label>Enter phone</label> <input
			type="text" name="phone" value="${c.phone}" /><br /> <label>Enter
			address</label> <input type="text" name="address" value="${c.address}" /><br />
		<label>Enter Role</label> <input type="text" name="role"
			value="${c.role}" /><br /> <input type="submit" value="Sửa"><br />
	</form>
</div>

