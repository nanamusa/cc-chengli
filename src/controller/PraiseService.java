package controller;

import java.io.File;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import model.Album;
import model.Photo;
import model.Praise;

import com.google.gson.Gson;

import dao.AlbumDao;
import dao.PhotoDao;

@Path("/praise")
public class PraiseService {

	@GET
	@Path("/{sid}")
	@Produces("application/json")
	public Response getPriseInfoById(
			@DefaultValue("0") @PathParam("sid") int sid) throws Exception {
		Gson gson = new Gson();
		String str = "";

		if (sid > 0) {
			System.out.println("get PriseInfo By sid : " + sid);
			str = gson.toJson(PraiseInfoDao.getById(sid));
			System.out.println(str);
		} else {
			System.out.println("get PriseInfo ALL : " + sid);
			str = gson.toJson(PraiseInfoDao.getAll());
			System.out.println(str);
		}

		return Response.status(200).entity(str).build();
	}

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response createPrise(String prise) throws Exception {
		System.out.println("creating Prise");

		Gson gson = new Gson();
		Praise obj = gson.fromJson(prise, Praise.class);
		System.out.println(obj);
		String strDnts = gson.toJson(PraiseInfoDao.save(obj));

		System.out.println(strDnts);

		return Response.status(200).entity(strDnts).build();
	}

	@DELETE
	@Path("/{sid}")
	@Produces("application/json")
	public void removePhoto(@PathParam("sid") int sid) throws Exception {
		System.out.println("Delete Praise: " + sid);
		PhotoDao.remove(sid);
	}
	
	@GET
	@Path("/PsSet/{id}")
	@Produces("application/json")
	public Response getAlbumById(
			@DefaultValue("0") @PathParam("id") int id) throws Exception {
		Gson gson = new Gson();
		String str;

		if (id > 0) {
			System.out.println("get CLAlbum By id : " + id);
			str = gson.toJson(AlbumDao.getById(id));
			System.out.println(str);
		} else {
			System.out.println("get CLAlbum ALL (prise) : " + id);
			str = gson.toJson(AlbumDao.getAll("prise"));
			System.out.println(str);
		}

		return Response.status(200).entity(str).build();
	}

	@POST
	@Path("/PsSet")
	@Consumes("application/json")
	@Produces("application/json")
	public Response createCLAlbum(String album) throws Exception {
		System.out.println("creating Album");

		Gson gson = new Gson();
		Album obj = gson.fromJson(album, Album.class);
		System.out.println(obj);
		obj.setType("prise");
		String strDnts = gson.toJson(AlbumDao.save(obj));

		System.out.println(strDnts);

		return Response.status(200).entity(strDnts).build();
	}

	//
	// /* ----------- donation end ----------- */
	// Delete a file
	public static boolean deleteFile(String filename) {
		File f = new File(filename);
		boolean result = false;
		if (f.exists()) {
			result = f.delete();
			if (result != true) {
				System.out.println("Delete file failed: " + f.getName());
			}
		}
		return result;
	}
}