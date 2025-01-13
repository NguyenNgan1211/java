<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/admin/adheader.jsp" />

<!DOCTYPE html>
<html>
<head>
    <title>Update Comment</title>
    <!-- Thêm Bootstrap -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css">
    <style>
        body {
           
            font-family: 'Poppins', Arial, sans-serif; /* Font chữ hiện đại */
            color: #2d3436; /* Màu chữ chính */
            margin: 0;
            padding: 0;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .form-container {
            max-width: 500px;
            width: 100%;
            background: white;
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.2); /* Đổ bóng */
            animation: fadeIn 0.5s ease-in-out; /* Hiệu ứng khi hiển thị */
        }
        @keyframes fadeIn {
            from {
                opacity: 0;
                transform: translateY(-20px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }
        .form-container h2 {
            font-weight: bold;
            color: #0984e3; /* Màu tiêu đề */
            margin-bottom: 20px;
            text-transform: uppercase; /* Chữ in hoa */
            text-align: center;
        }
        .form-container label {
            font-weight: 600;
            margin-top: 10px;
            display: block;
        }
        .form-container input {
            border: 1px solid #dfe6e9;
            border-radius: 10px;
            padding: 10px;
            width: 100%;
            box-sizing: border-box;
            margin-bottom: 15px;
            transition: all 0.3s ease;
        }
        .form-container input:focus {
            border-color: #0984e3;
            box-shadow: 0 0 5px rgba(9, 132, 227, 0.5);
        }
        .btn-submit {
            background: linear-gradient(to right, #0984e3, #74b9ff);
            color: white;
            border: none;
            padding: 10px 20px;
            font-size: 16px;
            border-radius: 50px;
            font-weight: bold;
            margin-top: 15px;
            transition: all 0.3s ease;
            width: 100%;
        }
        .btn-submit:hover {
            background: linear-gradient(to right, #74b9ff, #0984e3);
            transform: scale(1.05);
        }
    </style>
</head>
<body>
    <div class="form-container" style="margin-top:50px;">
        <h2>Update Comment</h2>
        <c:set value="${Comments}" var="c" />
        <form action="${pageContext.request.contextPath}/admin/UpdatecommentServlet" method="post">
            <input type="hidden" name="cmtid" value="${c.cmtid}" />
            <label for="userid">User ID</label>
            <input type="text" id="userid" name="userid" value="${c.userid}" />

            <label for="newid">News ID</label>
            <input type="text" id="newid" name="newid" value="${c.newid}" />

            <label for="content">Content</label>
            <input type="text" id="content" name="content" value="${c.content}" />

            <label for="status">Status</label>
            <input type="text" id="status" name="status" value="${c.status}" />

            <label for="created_at">Created At</label>
            <input type="date" id="created_at" name="created_at" value="<fmt:formatDate value='${c.created_at}' pattern='yyyy-MM-dd'/>" />

            <button type="submit" class="btn btn-submit">Update</button>
        </form>
    </div>
</body>
</html>
