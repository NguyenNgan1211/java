<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
	/* Form container styling */
.form-container {
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    min-height: calc(100vh - 100px);
    margin-top: 50px;
    text-align: center;
}

/* Headings */
h2 {
    margin-bottom: 20px;
}

h3.error-message {
    color: red;
    margin-bottom: 20px;
}

/* Form fields */
form {
    text-align: left;
    width: 300px;
}

form label {
    display: block;
    margin-bottom: 5px;
}

form input[type="text"] {
    width: 100%;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-sizing: border-box;
    margin-bottom: 15px;
}

/* Submit button styling */
form button {
    padding: 12px 20px;
    background-color: #007BFF;
    color: white;
    border: none;
    border-radius: 5px;
    font-size: 16px;
    cursor: pointer;
    transition: background-color 0.3s ease, transform 0.2s ease;
}

form button:hover {
    background-color: #0056b3; /* Darker blue */
    transform: translateY(-2px); /* Slight upward hover effect */
}

form button:active {
    background-color: #003d80; /* Even darker blue */
    transform: translateY(0); /* Reset on click */
}
	
</style>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<jsp:include page="/admin/adheader.jsp" flush="true" />
<div style="display: flex; justify-content: center; align-items: center; min-height: calc(100vh - 100px); flex-direction: column; margin-top: 50px;">
    <h2 style="margin-bottom: 20px;">Thêm tác giả mới</h2>
    <h3 style="color: red; margin-bottom: 20px;">${error }</h3>
    <form action="AddauthorServlet" method="post" style="text-align: left; width: 300px;">
 		
          <div style="margin-bottom: 15px;">
            <label for="authorname" style="display: block; margin-bottom: 5px;">Tên tác giả</label>
            <input type="text" id="authorname" name="authorname" style="width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 5px;" />
        </div>
          <div style="margin-bottom: 15px;">
            <label for="email" style="display: block; margin-bottom: 5px;">Email</label>
            <input type="email" id="email" name="email" style="width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 5px;" />
        </div>
          <div style="margin-bottom: 15px;">
            <label for="phone" style="display: block; margin-bottom: 5px;">Số điện thoại</label>
            <input type="number" id="phone" name="phone" style="width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 5px;" />
        </div>
          
        
        <div style="text-align: center;">
            <button type="submit" style="padding: 12px 20px; background-color: #007BFF; color: white; border: none; border-radius: 5px; font-size: 16px; cursor: pointer; transition: background-color 0.3s ease;">
                SAVE
            </button>
        </div>
    </form>
</div>

</body>
</html>