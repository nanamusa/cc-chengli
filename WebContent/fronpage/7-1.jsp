<%@page import="model.Album"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.AlbumDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="html" tagdir="/WEB-INF/tags"%>
<html>
<html:HEAD headline="活動櫥窗" />
<body>
	<div id="main_container">
		<html:header />
		<div class="wen-anchor"></div>
		<!--Begin content main-->
		<body>
			<section id="content" class="portfolio">
			<div class="container-fluid">
				<div class="row-fluid">
					<div class="span12">
						<div class="wrap">
							<!--slider-->
							<div class="content_slider span5">
								<div id="myCarousel" class="carousel slide">
									<!-- Carousel items -->
									<div class="carousel-inner">
										<div class="active item">
											<img src="img/pic/index01.jpg" alt="slider image">
										</div>
										<div class="item">
											<img src="img/pic/IMG_4833.jpg" alt="slider image">
										</div>
										<div class="item">
											<img src="img/pic/index01.jpg" alt="slider image">
										</div>
										<div class="item">
											<img src="img/pic/IMG_4833.jpg" alt="slider image">
										</div>
									</div>
									<!-- Carousel nav -->
									<a class="carousel-control left" href="#myCarousel"
										data-slide="prev">‹</a> <a class="carousel-control right"
										href="#myCarousel" data-slide="next">›</a>
								</div>
							</div>
							<!--end slider-->
							<!-content-->
							<div class="content_main span12">
								<div class="services_content first_service row-fluid">
									<h2 class="sub_title">活動櫥窗</h2>
									<!---filter portfolio-->
									<ul id="menu_content" class="nav nav-pills">
										<li class="active"><a class="all" href="#">全部分類</a></li>
										<li><a class="photo1" href="#">頒獎典禮</a></li>
										<li><a class="photo2" href="#">活動花絮 </a></li>
										<li><a class="photo3" href="#">環遊世界</a></li>
									</ul>
									<!---end filter portfolio-->
									<ul id="case_content">
										<%
											ArrayList<Album> albums = new ArrayList<Album>();
											albums = AlbumDao.getAll("Activity");
										 	request.setAttribute("albums", albums);
											Album tmp = new Album();
										%>
										<%
											System.out.println("#albums = " + albums.size());
											for (int offset = 0; offset < albums.size(); offset++) {
												request.setAttribute("album", albums.get(offset));
												//String URL_SINGLE_POST = "7.2.jsp?albumId";
												tmp = albums.get(offset);
												String URL_SINGLE_POST = "7-2.jsp?albumId="+tmp.getId()+"&tag="+tmp.getTag();
										%>
										<!--Item with no lightbox, only link to the item page-->
										<li class="case" data-type="photo${album.tag}"
											data-id="id-${album.id}">
											<!-- Button to trigger modal --> <a class="portfolio_box "
											href="7-2.jsp?albumId=${album.id}&tag=${album.tag}" role="button"> <img
												src="img/pic/index01.jpg" alt="portfolio single item image">
												<div class="portfolio_box_text">
													<h6>${album.title}</h6>
												</div>
										</a>
										</li>
										<%
											} //for loop < albums.size()
										%>
									</ul>
								</div>
							</div>
							<!--end content-->
						</div>
					</div>
				</div>
			</div>
			</section>
			<!--Begin footer-->
			<html:FOOT />
			<!--End begin footer-->
	</div>
	<!-- ======================= JQuery libs =========================== -->
	<!-- Always latest version of jQuery-->
	<script src="js/jquery-1.7.1.js"></script>
	<script src="js/filter/jquery.easing.min.js"></script>
	<!--<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.7.1/jquery-ui.min.js"></script>-->
	<!-- Bootstrap.js-->
	<script src="js/bootstrap.js"></script>
	<!--fUNCTIONS-->
	<script src="js/js.js" type="text/javascript"></script>
	<script type="text/javascript" src="js/twitter/jquery.jtwt.js"></script>
	<script src="js/filter/quiksand.js" type="text/javascript"></script>
	<script type="text/javascript" src="js/jquery-func.js"></script>
	<!-- ======================= End JQuery libs =========================== -->
</body>

</html>