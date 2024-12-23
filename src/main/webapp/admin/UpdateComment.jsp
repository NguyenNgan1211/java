
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<jsp:include page="/admin/adheader.jsp" />
<div style="text-align: center; margin-top: 100px;">
	<h2>Update Comment</h2>
	<c:set value="${Comments}" var="c" />
	<form action="${pageContext.request.contextPath}/admin/UpdatecommentServlet" method="post">
	
		<input type="hidden" name="cmtid" value="${c.cmtid}" />
		 <label>Enter Cmtid</label> <input type="text" name="cmtid" value="${c.cmtid}" />
		<label>Enter Userid</label>  <input type="text" name="userid" value="${c.userid}" /><br />
	   <label>Enter newid</label> <input type="text" name="newid" value="${c.newid}" /><br />
        <label>Enter content</label> <input type="text" name="content" value="${c.content}" /><br /> 
        <label>Enter status</label> <input type="text" name="status" value="${c.status}" /><br /> 
		<input type="date" name="created_at" value="<fmt:formatDate value='${c.created_at}' pattern='yyyy-MM-dd'/>" />

	
	<input type="submit" value="Sửa"><br />
	</form>
</div>

