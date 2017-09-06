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

import util.util_log;
import model.Article;

import com.google.gson.Gson;

import dao.ArticleDao;

@Path("/articles")
public class ArticleService {
	static util_log LOG = new util_log();
	static String msg = "Articles::";
	static int opt = 1;

	Gson gson = new Gson();

	// getArticles
	@GET
	@Path("/page={Page}&show={Size}")
	@Produces("application/json")
	public Response getByPage(@DefaultValue("0") @PathParam("Page") int Page,
			@DefaultValue("5") @PathParam("Size") int Size) throws Exception {
		String msg_head = "[getByPage Article] ";
		boolean ret = false;

		msg = msg_head + "Page=" + Page + ", Size=" + Size;
		LOG.DEBUG_LOG(msg, opt);

		String str;

		if (Page > 0) {
			str = gson.toJson(ArticleDao.getArticles(Page, Size));
		} else {
			str = String.valueOf(ArticleDao.getTotalNum(""));
		}

		if (str.equals("[]")) {
			msg = msg_head + ret + " - empty";
		} else {
			ret = true;
			msg = msg_head + ret + " - data" + str;
		}

		LOG.DEBUG_LOG(msg, opt);

		return Response.status(200).entity(str).build();
	}

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Response getById(@DefaultValue("0") @PathParam("id") int id)
			throws Exception {
		String msg_head = "[getById Article] ";
		boolean ret = false;
		String str;

		msg = msg_head + "id=" + id;

		if (id > 0) {
			str = gson.toJson(ArticleDao.getById(id));
		} else {
			msg = msg_head + "ALL";
			str = gson.toJson(ArticleDao.getAll());
		}
		LOG.DEBUG_LOG(msg, opt);

		if (str.equals("[]")) {
			msg = msg_head + ret + " - empty";
		} else {
			ret = true;
			msg = msg_head + ret + " - data" + str;
		}
		LOG.DEBUG_LOG(msg, opt);

		return Response.status(200).entity(str).build();
	}

	@POST
	@Path("/search")
	@Consumes("application/json")
	@Produces("application/json")
	public Response search(String _keyWord) throws Exception {
		String msg_head = "[search Article] ";
		boolean ret = false;

		msg = msg_head + "keyword=" + _keyWord;
		LOG.DEBUG_LOG(msg, opt);

		String str = gson.toJson(ArticleDao.search(_keyWord, 1, 100));
		int size = ArticleDao.search(_keyWord, 1, 100).size();

		if (str.equals("[]")) {
			msg = msg_head + ret + " - empty";
		} else {
			ret = true;
			msg = msg_head + ret + " - data=" + size;
		}
		LOG.DEBUG_LOG(msg, opt);

		return Response.status(200).entity(str).build();
	}

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response create(String article) throws Exception {
		String msg_head = "[Create Article] ";
		boolean ret = false;

		Article obj = gson.fromJson(article, Article.class);
		msg = msg_head + obj;
		LOG.DEBUG_LOG(msg, opt);

		// ret = gson.toJson(ArticleDao.save(obj));
		ret = ArticleDao.save(obj);

		msg = msg_head + "result=" + ret;
		LOG.DEBUG_LOG(msg, opt);

		return Response.status(200).entity(obj.toString()).build();
	}

	@DELETE
	@Path("/{id}")
	@Produces("application/json")
	public void delete(@PathParam("id") int id) throws Exception {
		String msg_head = "[delete Article] ";
		boolean ret = false;

		msg = msg_head + id;
		ret = ArticleDao.remove(id);

		msg += ", result=" + ret;
		LOG.DEBUG_LOG(msg, opt);

		return;
	}

}