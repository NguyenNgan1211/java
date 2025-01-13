<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cập nhật bài viết</title>
<!-- Thêm Bootstrap -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css">
<style>
    body {
        background: linear-gradient(to right, #74b9ff, #81ecec);
        font-family: 'Poppins', Arial, sans-serif;
        color: #2d3436;
        margin: 0;
        padding: 0;
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
    }
    .form-container {
        max-width: 600px;
        width: 100%;
        background: white;
        padding: 30px;
        border-radius: 15px;
        box-shadow: 0 10px 20px rgba(0, 0, 0, 0.2);
        animation: fadeIn 0.5s ease-in-out;
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
        color: #0984e3;
        margin-bottom: 20px;
        text-transform: uppercase;
    }
    .form-container label {
        font-weight: 600;
        margin-top: 10px;
        display: block;
    }
    .form-container input[type="text"] {
        border: 1px solid #dfe6e9;
        border-radius: 10px;
        padding: 10px;
        width: 100%;
        box-sizing: border-box;
        transition: all 0.3s ease;
    }
    .form-container input[type="text"]:focus {
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
    }
    .btn-submit:hover {
        background: linear-gradient(to right, #74b9ff, #0984e3);
        transform: scale(1.05);
    }
    .form-container .form-footer {
        margin-top: 20px;
        font-size: 14px;
        color: #636e72;
    }
</style>
</head>
<body>
    <jsp:include page="/admin/adheader.jsp" />
    <div class="form-container">
        <h2>Cập nhật bài viết</h2>
        <c:set value="${news2 }" var="c" />
        <form action="UpdateNewsServlet" method="post">
            <input type="hidden" name="newsid" value="${c.newsid}" />
            <div class="mb-3">
                <label for="newstitle" class="form-label">Tiêu đề bài viết</label>
                <input type="text" id="newstitle" name="newstitle" class="form-control" value="${c.newstitle}" />
            </div>
            <div class="mb-3">
                <label for="newscontent" class="form-label">Nội dung bài viết</label>
                <input type="text" id="newscontent" name="newscontent" class="form-control" value="${c.newscontent}" />
            </div>
            <div class="mb-3">
                <label for="authorid" class="form-label">Mã tác giả</label>
                <input type="text" id="authorid" name="authorid" class="form-control" value="${c.authorid}" />
            </div>
            <div class="mb-3">
                <label for="menuid" class="form-label">Mã menu</label>
                <input type="text" id="menuid" name="menuid" class="form-control" value="${c.menuid}" />
            </div>
            <div class="mb-3">
                <label for="image" class="form-label">Hình ảnh</label>
                <input type="text" id="image" name="image" class="form-control" value="${c.image}" />
            </div>
            <div class="text-center">
                <input type="submit" value="Lưu bài viết" class="btn btn-submit">
            </div>
        </form>
    </div>
</body>
</html>
