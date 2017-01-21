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
			<section id="content" class="blog">
			<div class="container-fluid">
				<div class="row-fluid">
					<div class="span12">
						<div class="wrap">
							<div class="content_main row-fluid span12">
								<div class="content_center alignleft ">
									<%
										/* 分頁 */
										String start = request.getParameter("start");
										if (start == null) {
											start = "1";
										}
										int MINI_ARTICLE = 90;
										int total = ArticleDao.getTotalNum();
										int currentPage = Integer.parseInt(start); //current page
										ArrayList<Article> articles = new ArrayList<Article>();
										int begin = 5 * currentPage - 4;
										articles = ArticleDao.getArticles(begin, 5);
										int end = begin + articles.size() - 1;//5 * count;
									%>
									<%
										System.out.println(articles.size());
										for (int offset = 0; offset < articles.size(); offset++) {
											String URL_SINGLE_POST = "4-2.jsp?id="
													+ articles.get(offset).getId();
									%>
									<div class="content_post <%=offset > 0 ? "" : "first"%>">
										<h2 class="sub_title">
											<a href="<%=URL_SINGLE_POST%>"><%=articles.get(offset).getTitle()%></a>
										</h2>
										<img class="span1"
											src="img/<%=articles.get(offset).getPic()%>" width="215" height="145" alt="//" />
										<%
											int contentLen = articles.get(offset).getContent().length();
												if (contentLen > MINI_ARTICLE)
													contentLen = MINI_ARTICLE;
										%>
										<p><%=articles.get(offset).getContent().substring(0, contentLen)+ "..."%></p>
										<a class="btn-sample" href="<%=URL_SINGLE_POST%>">&rsaquo;
											閱讀更多</a>
										<ul class="info_post">
											<li><a href="#"><i class="icon-calendar"></i><%=articles.get(offset).getDate()%></a></li>
										</ul>
									</div>
									<%
										} // for begin~end
											//system.out.println("第 " + begin + " 篇 到 第 " + end + " 篇");
									%>

									<div class="pagination pagination-small pagination-right">
										<ul>
											<%
												if (currentPage > 1) {
													out.println("<li><a href=\"4-1.jsp?start=" + (currentPage - 1)
															+ "\">&lsaquo;</a></li>");
												}
											%>
											<%
												for (int i = 1; i <= (total + 4) / 5; i++) {
													if (i == currentPage) {
														out.println("<li>" + i + "</li>");
														continue;
													}
													out.println("<li><a href=\"4-1.jsp?start=" + i + "\">" + i
															+ "</a></li>");
												}
											%>
											<%
												if (currentPage < (total + 4) / 5) {
													out.println("<li><a href=\"4-1.jsp?start=" + (currentPage + 1)
															+ "\">&rsaquo;</a></li>");
												}
											%>
										</ul>
									</div>
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
															alt="news photo" />
													</div>
													<p>
														<a class="video-link" href="4-2.jsp?id=<%=tmp.getId()%>"><%=TITLE%></a>
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