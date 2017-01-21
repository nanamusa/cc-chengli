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

import model.Album;

import com.google.gson.Gson;

import dao.AlbumDao;

@Path("/album")
public class AlbumService {

	@GET
	@Path("/{typeId}")
	@Produces("application/json")
	public Response getAlbumByType(
			@DefaultValue("0") @PathParam("typeId") int typeId)
			throws Exception {
		Gson gson = new Gson();
		String str = "";

		if (typeId > 3) {
			System.out.println("1-1-4 get Album : ERROR");

		} else if (typeId > 2) {// Champion
			System.out.println("1-1-3 get Album Champion : " + typeId);
			str = gson.toJson(AlbumDao.getAll("Champion"));
			System.out.println(str);

		} else if (typeId > 1) {// Activity
			System.out.println("1-1-2 get Album Activity : " + typeId);
			str = gson.toJson(AlbumDao.getAll("Activity"));
			System.out.println(str);

		} else if (typeId > 0) {// Blog
			System.out.println("1-1-1 get Album Blog : " + typeId);
			str = gson.toJson(AlbumDao.getAll("Blog"));
			System.out.println(str);

		} else {// ALL
			System.out.println("1-1-0 get Album ALL : " + typeId);
			str = gson.toJson(AlbumDao.getAll("ALL"));
			System.out.println(str);
		}

		return Response.status(200).entity(str).build();
	}

	@GET
	@Path("/id:{typeId}")
	@Produces("application/json")
	public Response getAlbumById(
			@DefaultValue("0") @PathParam("typeId") int typeId)
			throws Exception {
		Gson gson = new Gson();
		String str = "";

		if (typeId < 1) {
			System.out.println("1-2-4 get Album : ERROR");

		} else {// ALL
			System.out.println("1-2-0 get Album Id : " + typeId);
			str = gson.toJson(AlbumDao.getById(typeId));
			System.out.println(str);
		}

		return Response.status(200).entity(str).build();
	}

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response createCLAlbum(String album) throws Exception {
		System.out.println("creating Album");

		Gson gson = new Gson();
		Album obj = gson.fromJson(album, Album.class);
		System.out.println(obj);
		String strDnts = gson.toJson(AlbumDao.save(obj));

		System.out.println("gson : " + strDnts);

		return Response.status(200).entity(strDnts).build();
	}

	@POST
	@Path("/{albumId}/")
	@Consumes("application/json")
	@Produces("application/json")
	public Response updateCoverPhoto(String album) throws Exception {
		System.out.println("update photo cover");

		Gson gson = new Gson();
		Album obj = gson.fromJson(album, Album.class);
		//System.out.println(obj.toString());
		String strDnts = gson.toJson(AlbumDao.saveCover(obj.getId(),obj.getPic()));

		System.out.println("result : " + strDnts);

		return Response.status(200).entity(strDnts).build();
	}
//	@POST
//	@Path("/{albumId}/")
//	@Consumes("text/plain")
//	public Response updateCoverPhoto(
//			@DefaultValue("0") @PathParam("albumId") String albumId,
//			String CoverId) throws Exception {
//		System.out.println("update photo cover");
//
//		System.out.println(albumId);
//		System.out.println(CoverId);
//
//		AlbumDao.saveCover(Integer.parseInt(albumId), CoverId);
//
//		return Response.status(200).build();
//	}

	@DELETE
	@Path("/{id}")
	@Produces("application/json")
	public void removeDnt(@PathParam("id") int id) throws Exception {
		System.out.println("Delete Album: " + id);
		AlbumDao.remove(id);
	}
	//
	// /* ----------- donation end ----------- */

}