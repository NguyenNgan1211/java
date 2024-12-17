<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Home 01</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
<link rel="icon" type="image/png" href="asset/images/icons/favicon.png" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="asset/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="asset/fonts/fontawesome-5.0.8/css/fontawesome-all.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="asset/fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="asset/vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="asset/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="asset/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="asset/css/util.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="asset/css/main.css">
<!--===============================================================================================-->
</head>
<body class="animsition">

	<header>
		<!-- Header desktop -->
		<div class="container-menu-desktop">
			<div class="topbar">
				<div class="content-topbar container h-100">
					<div class="left-topbar">
						<span class="left-topbar-item flex-wr-s-c"> 
						</span> 
						
						<c:if test="${ sessionScope.user!=null}">

						<a href="admin" class="left-topbar-item"> Admin </a>
						
						<a href="LogoutServlet" class="left-topbar-item"> Đăng xuất </a> 
						</c:if>
						<c:if test="${sessionScope.user==null}">
						<a href="#" class="left-topbar-item"> Đăng ký </a> 
						<a href="login.jsp" class="left-topbar-item"> Đăng nhập </a>
						</c:if>
						
					</div>

					<div class="right-topbar">
						<a href="#"> <span class="fab fa-facebook-f"></span>
						</a> <a href="#"> <span class="fab fa-twitter"></span>
						</a> <a href="#"> <span class="fab fa-pinterest-p"></span>
						</a> <a href="#"> <span class="fab fa-vimeo-v"></span>
						</a> <a href="#"> <span class="fab fa-youtube"></span>
						</a>
					</div>
				</div>
			</div>

			<!-- Header Mobile -->
			<div class="wrap-header-mobile">
				<!-- Logo moblie -->
				<div class="logo-mobile">
					<a href="index.html"><img src="images/icons/logo-01.png"
						alt="IMG-LOGO"></a>
				</div>

				<!-- Button show menu -->
				<div
					class="btn-show-menu-mobile hamburger hamburger--squeeze m-r--8">
					<span class="hamburger-box"> <span class="hamburger-inner"></span>
					</span>
				</div>
			</div>

			<!-- Menu Mobile -->
			<div class="menu-mobile">
				<ul class="topbar-mobile">
					<li class="left-topbar"><span
						class="left-topbar-item flex-wr-s-c"> 
					</span></li>

					<li class="left-topbar"> <a
						href="#" class="left-topbar-item"> Sign up </a> <a href="#"
						class="left-topbar-item"> Log in </a></li>

					<li class="right-topbar"><a href="#"> <span
							class="fab fa-facebook-f"></span>
					</a> <a href="#"> <span class="fab fa-twitter"></span>
					</a> <a href="#"> <span class="fab fa-pinterest-p"></span>
					</a> <a href="#"> <span class="fab fa-vimeo-v"></span>
					</a> <a href="#"> <span class="fab fa-youtube"></span>
					</a></li>
				</ul>


			</div>

			<!--  -->


			<!--  -->
			<div class="wrap-main-nav">
				<div class="main-nav">
					<!-- Menu desktop -->
					<nav class="menu-desktop">
						<a class="logo-stick" href="index.html"> <img
							src="images/icons/logo-01.png" alt="LOGO">
						</a>

						<ul class="main-menu">
							<c:forEach items="${menus}" var="item">
								<li class="main-menu-active"><a href="index.html">${item.menuname }</a></li>
							</c:forEach>


						</ul>
					</nav>
				</div>
			</div>
		</div>
	</header>