<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="element/Header.jsp" />

<div class="col-md-10 col-lg-8 p-b-30">
					<div class="p-r-10 p-r-0-sr991">
						<!-- Blog Detail -->
						<c:set value="${Detail}" var="g" />
						<div class="p-b-70">
							<a href="#" class="f1-s-10 cl2 hov-cl10 trans-03 text-uppercase">
								Technology
							</a>

							<h3 class="f1-l-3 cl2 p-b-16 p-t-33 respon2">
								${g.newstitle}
							</h3>
							
							<div class="flex-wr-s-s p-b-40">
								<span class="f1-s-3 cl8 m-r-15">
									<a href="#" class="f1-s-4 cl8 hov-cl10 trans-03">
										${g.authorid}
									</a>

									<span class="m-rl-3">-</span>

									<span>
										${g.menuid}
									</span>
								</span>

								<span class="f1-s-3 cl8 m-r-15">
									5239 Views
								</span>

								<a href="#" class="f1-s-3 cl8 hov-cl10 trans-03 m-r-15">
									0 Comment
								</a>
							</div>
			

							<div class="wrap-pic-max-w p-b-30">
								  <img src="${pageContext.request.contextPath}/asset${g.image}" alt="IMG">
							</div>
							
							<p class="f1-s-11 cl6 p-b-25">
								${g.newscontent}
							</p>

							

							<!-- Tag -->
							<div class="flex-s-s p-t-12 p-b-15">
								<span class="f1-s-12 cl5 m-r-8">
									Tags:
								</span>
								
								<div class="flex-wr-s-s size-w-0">
									<a href="#" class="f1-s-12 cl8 hov-link1 m-r-15">
										Streetstyle
									</a>

									<a href="#" class="f1-s-12 cl8 hov-link1 m-r-15">
										Crafts
									</a>
								</div>
							</div>

							<!-- Share -->
							<div class="flex-s-s">
								<span class="f1-s-12 cl5 p-t-1 m-r-15">
									Share:
								</span>
								
								<div class="flex-wr-s-s size-w-0">
									<a href="#" class="dis-block f1-s-13 cl0 bg-facebook borad-3 p-tb-4 p-rl-18 hov-btn1 m-r-3 m-b-3 trans-03">
										<i class="fab fa-facebook-f m-r-7"></i>
										Facebook
									</a>

									<a href="#" class="dis-block f1-s-13 cl0 bg-twitter borad-3 p-tb-4 p-rl-18 hov-btn1 m-r-3 m-b-3 trans-03">
										<i class="fab fa-twitter m-r-7"></i>
										Twitter
									</a>

									<a href="#" class="dis-block f1-s-13 cl0 bg-google borad-3 p-tb-4 p-rl-18 hov-btn1 m-r-3 m-b-3 trans-03">
										<i class="fab fa-google-plus-g m-r-7"></i>
										Google+
									</a>

									<a href="#" class="dis-block f1-s-13 cl0 bg-pinterest borad-3 p-tb-4 p-rl-18 hov-btn1 m-r-3 m-b-3 trans-03">
										<i class="fab fa-pinterest-p m-r-7"></i>
										Pinterest
									</a>
								</div>
							</div>
						</div>

						<!-- Leave a comment -->
						<div>
							<h4 class="f1-l-4 cl3 p-b-12">
								Leave a Comment
							</h4>

							<p class="f1-s-13 cl8 p-b-40">
								Your email address will not be published. Required fields are marked *
							</p>

							<form>
								<textarea class="bo-1-rad-3 bocl13 size-a-15 f1-s-13 cl5 plh6 p-rl-18 p-tb-14 m-b-20" name="msg" placeholder="Comment..."></textarea>

							
								<button class="size-a-17 bg2 borad-3 f1-s-12 cl0 hov-btn1 trans-03 p-rl-15 m-t-10">
									Post Comment
								</button>
							</form>
						</div>
					</div>
				</div>

<jsp:include page="element/Footer.jsp" />