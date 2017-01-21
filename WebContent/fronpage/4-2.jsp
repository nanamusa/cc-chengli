<%@page import="java.util.ArrayList"%>
<%@page import="dao.ArticleDao"%>
<%@page import="controller.ArticleService"%>
<%@page import="model.Article"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="html" tagdir="/WEB-INF/tags"%>
<html>
<html:HEAD headline="最新消息" />
<body>
	<div id="main_container">
		<html:header />
		<div class="wen-anchor"></div>
		<!--Begin content main-->
		<body>
			<section id="content" class="blog single_post">
			<div class="container-fluid">
				<div class="row-fluid">
					<div class="span12">
						<div class="wrap">
							<div class="content_main row-fluid span12">
								<div class="content_center alignleft ">
									<%
										String _PostId = request.getParameter("id");
										if (_PostId == null) {
											//location.replace("./4-1.jsp");
										}
										int PostId = Integer.parseInt(_PostId);
										Article article = ArticleDao.getById(PostId);
									%>
									<div class="content_post first">
										<h2 class="sub_title"><%=article.getTitle()%></h2>
										<ul class="info_post">
											<li><a href="#"><i class="icon-calendar"></i><%=article.getDate()%></a></li>
										</ul>
										<div class="clearfix"></div>
										<div id="myCarousel" class="carousel slide">
											<ol class="carousel-indicators">
												<li data-target="#myCarousel" data-slide-to="0"
													class="active"></li>
											</ol>
											<!-- Carousel items -->
											<div class="carousel-inner">
												<div class="active item">
													<img src="img/news01.jpg" alt="//">
												</div>
											</div>
										</div>
										<p class="text_post">
											<%=article.getContent().replaceAll("\n", "<br>")%>
										</p>
									</div>
									<div class="clearfix"></div>
								</div>
								<div class="content_left_bar alignright ">
									<input class="search_input" type="text" placeholder="搜尋…">
									<section class="section_box">
									<h2 class="sub_title">最新消息</h2>
									<div class="tab-content">
										<div class="tab-pane active" id="recent">
											<ul>
												<%
													ArrayList<Article> recentArts = new ArrayList<Article>();
													recentArts = ArticleDao.getArticles(1, 4);
													Article tmp = new Article();
												%>
												<%
													System.out.println(recentArts.size());
													for (int offset = 0; offset < recentArts.size(); offset++) {
														String URL_SINGLE_POST = "single_post.html?id=" + offset;
														tmp = recentArts.get(offset);
														String TITLE = tmp.getTitle().length() > 10 ? tmp.getTitle()
																.substring(0, 10) + "..." : tmp.getTitle();
												%>
												<li class="console <%=offset > 0 ? "" : "first"%>">
													<div class="content_img">
														<img
															src="img/<%=tmp.getPic().equals("0") ? "news01.jpg" : tmp
						.getPic()%>"
															alt="//" />
													</div>
													<p>
														<a class="video-link" href="4-2.jsp?id=<%=tmp.getId()%>"><%=TITLE%><%-- <%=tmp.getTitle().substring(12).isEmpty() ? "" : "..."%> --%></a>
													</p>
													<h6>
														<i class="icon-calendar"></i><%=tmp.getDate()%><!-- 四月 24, 2015 -->
													</h6>
												</li>
												<%
													}//for loop
												%>
											</ul>
										</div>
									</div>
									</section>
								</div>
							</div>
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