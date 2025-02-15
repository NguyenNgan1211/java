<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"
	rel="stylesheet">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.0.0/mdb.min.css"
	rel="stylesheet">
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.0.0/mdb.min.js"></script>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<style>
.divider:after, .divider:before {
	content: "";
	flex: 1;
	height: 1px;
	background: #eee;
}

.h-custom {
	height: calc(100% - 73px);
}

@media ( max-width : 450px) {
	.h-custom {
		height: 100%;
	}
}
</style>
</head>
<body>
	<section class="vh-100">
		<div class="container-fluid h-custom">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-md-9 col-lg-6 col-xl-5">
					<img
						src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"
						class="img-fluid" alt="Sample image">
				</div>
				<div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
				
						<div
							class="d-flex flex-row align-items-center justify-content-center justify-content-lg-start">
							<p class="lead fw-normal mb-0 me-3">Sign up</p>
							<button type="button" data-mdb-button-init data-mdb-ripple-init
								class="btn btn-primary btn-floating mx-1">
								<i class="fab fa-facebook-f"></i>
							</button>

							<button type="button" data-mdb-button-init data-mdb-ripple-init
								class="btn btn-primary btn-floating mx-1">
								<i class="fab fa-twitter"></i>
							</button>

							<button type="button" data-mdb-button-init data-mdb-ripple-init
								class="btn btn-primary btn-floating mx-1">
								<i class="fab fa-linkedin-in"></i>
							</button>
						</div>

						<div class="divider d-flex align-items-center my-4">
							<p class="text-center fw-bold mx-3 mb-0">Or</p>
						</div>

						<!-- Email input -->
						<!-- Username input -->
			 <form action="RegisterServlet" method="post" style="text-align: left; width: 300px;">
	 		
	        <div style="margin-bottom: 15px;">
	            <label for="username" style="display: block; margin-bottom: 5px;">Họ và tên</label>
	            <input type="text" id="username" name="username" style="width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 5px;" />
	        </div>
	          <div style="margin-bottom: 15px;">
	            <label for="password" style="display: block; margin-bottom: 5px;">Mật khẩu</label>
	            <input type="password" id="password" name="password" style="width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 5px;" />
	        </div>
	          <div style="margin-bottom: 15px;">
	            <label for="phone" style="display: block; margin-bottom: 5px;">Số điện thoại</label>
	            <input type="text" id="phone" name="phone" style="width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 5px;" />
	        </div>
	          <div style="margin-bottom: 15px;">
	            <label for="address" style="display: block; margin-bottom: 5px;">Địa chỉ</label>
	            <input type="text" id="address" name="address" style="width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 5px;" />
	        </div>
	          <div style="margin-bottom: 15px;">
	        
	           <input type="hidden" id="role" name="role" value="1" />

	        </div>
	        <div style="text-align: center;">
	            <button type="submit" style="padding: 12px 20px; background-color: #007BFF; color: white; border: none; border-radius: 5px; font-size: 16px; cursor: pointer; transition: background-color 0.3s ease;">
	                SAVE
	            </button>
	        </div>
	    </form>
							
							<c:if test="${not empty error}">
							<p style="color: red">${error}</p>
						</c:if>
						<div class="d-flex justify-content-between align-items-center">
							<!-- Checkbox -->
							<div class="form-check mb-0">
								<input class="form-check-input me-2" type="checkbox" value=""
									id="form2Example3" /> <label class="form-check-label"
									for="form2Example3"> Remember me </label>
							</div>
						
						</div>

						

					
				</div>
			</div>
		</div>
		<div
			class="d-flex flex-column flex-md-row text-center text-md-start justify-content-between py-4 px-4 px-xl-5 bg-primary">
			<!-- Copyright -->
			<div class="text-white mb-3 mb-md-0">Copyright © 2020. All
				rights reserved.</div>
			<!-- Copyright -->

			<!-- Right -->
			<div>
				<a href="#!" class="text-white me-4"> <i
					class="fab fa-facebook-f"></i>
				</a> <a href="#!" class="text-white me-4"> <i class="fab fa-twitter"></i>
				</a> <a href="#!" class="text-white me-4"> <i class="fab fa-google"></i>
				</a> <a href="#!" class="text-white"> <i class="fab fa-linkedin-in"></i>
				</a>
			</div>
			<!-- Right -->
		</div>
	</section>
</body>
</html>