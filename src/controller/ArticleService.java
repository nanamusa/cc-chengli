package controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import model.Article;

import com.google.gson.Gson;

import dao.ArticleDao;

@Path("/articles")
public class ArticleService {

	// getArticles
	@GET
	@Path("/page={Page}&show={Size}")
	@Produces("application/json")
	public Response getGroupArticlesByPage(
			@DefaultValue("0") @PathParam("Page") int Page,
			@DefaultValue("5") @PathParam("Size") int Size) throws Exception {
		Gson gson = new Gson();
		String str;

		System.out.println("get Articles Group By Page : " + Page);
		if (Page > 0) {
			str = gson.toJson(ArticleDao.getArticles(Page, Size));
		} else {
			str = String.valueOf(ArticleDao.getTotalNum(""));
		}
		System.out.println(str);

		return Response.status(200).entity(str).build();
	}

	@GET
	@Path("/{sid}")
	@Produces("application/json")
	public Response getArticlesBySid(
			@DefaultValue("0") @PathParam("sid") int sid) throws Exception {
		Gson gson = new Gson();
		String str;

		if (sid > 0) {
			System.out.println("get Articles By sid : " + sid);
			str = gson.toJson(ArticleDao.getById(sid));
			System.out.println(str);
		} else {
			System.out.println("get Articles ALL : " + sid);
			str = gson.toJson(ArticleDao.getAll());
			System.out.println(str);
		}

		return Response.status(200).entity(str).build();
	}

	@POST
	@Path("/search")
	@Consumes("application/json")
	@Produces("application/json")
	public Response searchDonation(String _keyWord) throws Exception {
		System.out.println("article.Searching: " + _keyWord);
		Gson gson = new Gson();
		String ret = gson.toJson(ArticleDao.search(_keyWord,1,100));
		System.out.println(ret);
		return Response.status(200).entity(ret).build();
	}

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response createArticle(String article) throws Exception {
		System.out.println("creating Article");

		Gson gson = new Gson();
		Article obj = gson.fromJson(article, Article.class);
		System.out.println(obj);
		String str = gson.toJson(ArticleDao.save(obj));

		System.out.println(str);

		return Response.status(200).entity(str).build();
	}

	@DELETE
	@Path("/{sid}")
	@Produces("application/json")
	public void removeDnt(@PathParam("sid") int sid) throws Exception {
		System.out.println("Delete Article: " + sid);
		ArticleDao.remove(sid);
	}

}