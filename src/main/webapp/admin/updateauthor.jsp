<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cập nhật danh mục</title>
<!-- Thêm Bootstrap -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css">
<style>
    body {
        background: linear-gradient(to right, #74b9ff, #81ecec); /* Gradient nền */
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
        border-radius: 50px; /* Nút bo tròn */
        font-weight: bold;
        margin-top: 15px;
        transition: all 0.3s ease;
    }
    .btn-submit:hover {
        background: linear-gradient(to right, #74b9ff, #0984e3);
        transform: scale(1.05); /* Phóng to khi hover */
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
    <div class="form-container" style="transform: translate(110px, 20px);">
        <h2>Cập nhật tác giả</h2>
        <c:set value="${author}" var="c" />
        <form action="UpdateauthorServlet" method="post">
            <input type="hidden" name="id" value="${c.id}" />
            
            <div class="mb-3">
                <label for="authorname" class="form-label">Tên tác giả</label>
                <input type="text" id="authorname" name="authorname" class="form-control" value="${c.authorname}" />
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="email" id="email" name="email" class="form-control" value="${c.email}" />
            </div>
            <div class="mb-3">
                <label for="phone" class="form-label">Số điện thoại</label>
                <input type="number" id="phone" name="phone" class="form-control" value="${c.phone}" />
            </div>
            <div class="text-center">
                <input type="submit" value="Lưu" class="btn btn-submit">
            </div>
        </form>
        
    </div>
</body>
</html>
