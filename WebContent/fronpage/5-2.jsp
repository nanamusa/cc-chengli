<%@page import="dao.AlbumDao"%>
<%@page import="model.Album"%>
<%@page import="dao.PhotoDao"%>
<%@page import="model.Photo"%>
<%@page import="java.util.ArrayList"%>
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
							<%
								int albumId = Integer.parseInt(request.getParameter("albumId"));
								request.setAttribute("album", AlbumDao.getById(albumId));
							%>
							<%
								ArrayList<Photo> photos = new ArrayList<Photo>();
								photos = PhotoDao.getByAlbum(albumId);

								System.out.println("#photo = " + photos.size());
							%>
							<div class="content_main span12">
								<div class="services_content first_service row-fluid">
									<h2 class="sub_title">
										<span class="little_title">精華薈萃 ></span> ${album.title}
									</h2>
									<ul id="case_content">
										<%
											//Photo tmp = new Photo();
											String IMG_PATH = "img/pic/DPP_1609.jpg";
											for (int offset = 0; offset < photos.size(); offset++) {
												request.setAttribute("photo", photos.get(offset));
												IMG_PATH = "http://im2.book.com.tw/image/getImage?i=http://www.books.com.tw/img/001/070/38/0010703870.jpg&v=569778d2&w=140&h=140";//tmp.getDir() + "/" + tmp.getFile();
												System.out.println(IMG_PATH);
										%>
										<li class="case">
											<!-- portfolio item to trigger modal --> <a href="#myModal1"
											role="button" data-toggle="modal"> <img
												src="../album/${photo.path}${photo.file}" alt="portfolio single item image">
										</a> <!-- Lightbox modal -->
											<div id="myModal1" class="modal hide fade" tabindex="-1"
												role="dialog" aria-labelledby="myModalLabel"
												aria-hidden="true">
												<div class="modal-body">
													<button type="button" class="close" data-dismiss="modal"
														aria-hidden="true">
														<i class="icon-cancel-circle"></i>
													</button>
													<div class="content_modal">
														<img src="../album/${photo.path}${photo.file}" alt="image">
													</div>
												</div>
											</div>
											<p class="champion_name">${photo.desc }</p> <!--  請載後台輸入區 限制字數17字內  -->
											<!-- End Lightbox modal -->
										</li>
										<%
											} //loop end
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