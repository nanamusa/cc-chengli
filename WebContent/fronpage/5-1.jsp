<%@page import="java.util.ArrayList"%>
<%@page import="dao.AlbumDao"%>
<%@page import="model.Album"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="html" tagdir="/WEB-INF/tags"%>

<html>
<html:HEAD headline="精華薈萃" />
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
									<h2 class="sub_title">精華薈萃</h2>
									<ul id="case_content">
										<%
											ArrayList<Album> albums = new ArrayList<Album>();
											albums = AlbumDao.getAll("Champion");
										%>
										<%
											System.out.println("#praise = " + albums.size());
											for (int offset = 0; offset < albums.size(); offset++) {
												request.setAttribute("album", albums.get(offset));
												SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
												request.setAttribute("actYear",
														sdf.format(sdf.parse(albums.get(offset).getDate())));
										%>
										<!--Item with no lightbox, only link to the item page-->

										<li class="champion_box"><a
											href="5-2.jsp?albumId=${album.id}" role="button"
											class="champion_center">
												<div class="champion_box-title">
													<p class="champion_box-year">${actYear}</p>
													<p class="champion_box-name">${album.title}</p>
												</div>
										</a></li>

										<%
											} // for loop
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