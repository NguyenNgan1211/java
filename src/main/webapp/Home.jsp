<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpServlet"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page isELIgnored="false"%>

<jsp:include page="element/Header.jsp" />

<!-- Headline -->
<div class="container">
	<div class="bg0 flex-wr-sb-c p-rl-20 p-tb-8"
		style="padding-left: 180px">
		<form action="search" method="post">
			<div
				class="pos-relative size-a-2 bo-1-rad-22 of-hidden bocl11 m-tb-6">
				<input class="f1-s-1 cl6 plh9 s-full p-l-25 p-r-45" type="text"
					name="search" placeholder="Search">
				<button type="submit"
					class="flex-c-c size-a-1 ab-t-r fs-20 cl2 hov-cl10 trans-03">
					<i class="zmdi zmdi-search"></i>
				</button>
			</div>
		</form>
	</div>
</div>

<!-- Feature post -->
<!-- 	<section class="bg0">
		<div class="container">
			<div class="row m-rl--1">
				<div class="col-md-6 p-rl-1 p-b-2">
					<div class="bg-img1 size-a-3 how1 pos-relative" style="background-image: url(asset/images/post-01.jpg);">
						<a href="blog-detail-01.html" class="dis-block how1-child1 trans-03"></a>

						<div class="flex-col-e-s s-full p-rl-25 p-tb-20">
							<a href="#" class="dis-block how1-child2 f1-s-2 cl0 bo-all-1 bocl0 hov-btn1 trans-03 p-rl-5 p-t-2">
								Business
							</a>

							<h3 class="how1-child2 m-t-14 m-b-10">
								<a href="blog-detail-01.html" class="how-txt1 size-a-6 f1-l-1 cl0 hov-cl10 trans-03">
									Microsoft quisque at ipsum vel orci eleifend ultrices
								</a>
							</h3>

							<span class="how1-child2">
								<span class="f1-s-4 cl11">
									Jack Sims
								</span>

								<span class="f1-s-3 cl11 m-rl-3">
									-
								</span>

								<span class="f1-s-3 cl11">
									Feb 16
								</span>
							</span>
						</div>
					</div>
				</div>

				<div class="col-md-6 p-rl-1">
					<div class="row m-rl--1">
						<div class="col-12 p-rl-1 p-b-2">
							<div class="bg-img1 size-a-4 how1 pos-relative" style="background-image: url(asset/images/post-02.jpg);">
								<a href="blog-detail-01.html" class="dis-block how1-child1 trans-03"></a>

								<div class="flex-col-e-s s-full p-rl-25 p-tb-24">
									<a href="#" class="dis-block how1-child2 f1-s-2 cl0 bo-all-1 bocl0 hov-btn1 trans-03 p-rl-5 p-t-2">
										Culture
									</a>

									<h3 class="how1-child2 m-t-14">
										<a href="blog-detail-01.html" class="how-txt1 size-a-7 f1-l-2 cl0 hov-cl10 trans-03">
											London ipsum dolor sit amet, consectetur adipiscing elit.
										</a>
									</h3>
								</div>
							</div>
						</div>

						<div class="col-sm-6 p-rl-1 p-b-2">
							<div class="bg-img1 size-a-5 how1 pos-relative" style="background-image: url(asset/images/post-03.jpg);">
								<a href="blog-detail-01.html" class="dis-block how1-child1 trans-03"></a>

								<div class="flex-col-e-s s-full p-rl-25 p-tb-20">
									<a href="#" class="dis-block how1-child2 f1-s-2 cl0 bo-all-1 bocl0 hov-btn1 trans-03 p-rl-5 p-t-2">
										Life Style
									</a>

									<h3 class="how1-child2 m-t-14">
										<a href="blog-detail-01.html" class="how-txt1 size-h-1 f1-m-1 cl0 hov-cl10 trans-03">
											Pellentesque dui nibh, pellen-tesque ut dapibus ut
										</a>
									</h3>
								</div>
							</div>
						</div>

						<div class="col-sm-6 p-rl-1 p-b-2">
							<div class="bg-img1 size-a-5 how1 pos-relative" style="background-image: url(asset/images/post-04.jpg);">
								<a href="blog-detail-01.html" class="dis-block how1-child1 trans-03"></a>

								<div class="flex-col-e-s s-full p-rl-25 p-tb-20">
									<a href="#" class="dis-block how1-child2 f1-s-2 cl0 bo-all-1 bocl0 hov-btn1 trans-03 p-rl-5 p-t-2">
										Sport
									</a>

									<h3 class="how1-child2 m-t-14">
										<a href="blog-detail-01.html" class="how-txt1 size-h-1 f1-m-1 cl0 hov-cl10 trans-03">
											Motobike Vestibulum vene-natis purus nec nibh volutpat
										</a>
									</h3>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section> -->

<!-- Post -->
<section class="bg0 p-t-70">
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-10 col-lg-8">
				<div class="p-b-20">
					<!-- Entertainment -->
					<div class="tab01 p-b-20">
						<c:forEach items="${menus}" var="item">
							<!-- Tab Header -->
							<div
								class="tab01-head how2 how2-cl1 bocl12 flex-s-c m-r-10 m-r-0-sr991">
								<h3 class="f1-m-2 cl12 tab01-title">
									<li class="main-menu-active"><a href="index.html">${item.menuname}</a>
									</li>
								</h3>
							</div>

							<!-- Tab Content -->
							<div class="tab-content p-t-35">
								<div class="tab-pane fade show active" id="tab1-1"
									role="tabpanel">
									<div class="row">
										<c:if test="${not empty newss}">
											<c:forEach items="${newss}" var="news">
												<div class="col-sm-6 p-r-25 p-r-15-sr991">
													<div class="m-b-30">
														<a href="blog-detail-01.html"
															class="wrap-pic-w hov1 trans-03"> <img
															src="asset${news.image}" alt="IMG">
														</a>
														<div class="p-t-20">
															<h5 class="p-b-5">
																<a href="blog-detail-01.html"
																	class="f1-m-3 cl2 hov-cl10 trans-03">
																	${news.newstitle} </a>
															</h5>
															<span class="cl8"> <span class="f1-s-3">Feb
																	18</span>
															</span>
														</div>
													</div>
												</div>
											</c:forEach>
										</c:if>
										<c:if test="${empty newss}">
											<p>Không có bài viết nào phù hợp với từ khóa tìm kiếm.</p>
										</c:if>

									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>






<jsp:include page="element/Footer.jsp" />
