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

import model.Photo;

import com.google.gson.Gson;

import dao.PhotoDao;

@Path("/photo")
public class PhotoService {
	
	/* * To Get specific photo set by type * */
	/* * Default: type = 0; // get all photos * */
	@GET
	@Path("/{typeId}")
	@Produces("application/json")
	public Response getPhotoSetByAlbum(
			@DefaultValue("0") @PathParam("typeId") int typeId)
			throws Exception {
		Gson gson = new Gson();
		String str = ""; //result string

		if (typeId > 0) { //specific photo set
			System.out.println("1. get Photo Set : " + typeId);
			str = gson.toJson(PhotoDao.getByAlbum(typeId));
			System.out.println(str);

		} else { //All photos
			System.out.println("1. get Album ALL : " + typeId);
			str = gson.toJson(PhotoDao.getAll(0));
			System.out.println(str);
		}

		return Response.status(200).entity(str).build();
	}

	/* * To Get specific photo by photo id * */
	/* * Default: type = 0; // get all photos * */
	@GET
	@Path("/id:{photoId}")
	@Produces("application/json")
	public Response getPhotoById(
			@DefaultValue("0") @PathParam("photoId") int photoId) throws Exception {
		Gson gson = new Gson();
		String str = "";

		if (photoId > 0) { //specific photo
			System.out.println("1. get Photo By : " + photoId);
			str = gson.toJson(PhotoDao.getAll(photoId));
			System.out.println(str);
		} else { //All photos
			System.out.println("1. get Photo ALL : " + photoId);
			str = gson.toJson(PhotoDao.getAll(0));
			System.out.println(str);
		}

		return Response.status(200).entity(str).build();
	}

	@GET
	@Path("/Blog:{sid}")
	@Produces("application/json")
	public Response getBlogBySid(
			@DefaultValue("0") @PathParam("sid") int sid) throws Exception {
		Gson gson = new Gson();
		String str = "";

		System.out.println("get Photo By sid : " + sid);
		str = gson.toJson(PhotoDao.getBlogPhoto(sid));
		System.out.println(str);

		return Response.status(200).entity(str).build();
	}

	//
	// @GET
	// @Path("/dnt/exist/{id}")//@Produces("application/json")
	// @Produces("application/json")
	// public Response getDontationById(
	// @DefaultValue("0") @PathParam("id") int id) throws Exception {
	// System.out.println("get Donation By id : " + id);
	// Gson gson = new Gson();
	// String str = gson.toJson(DonationDAO.getById(id));
	// System.out.println(str);
	//
	// return Response.status(200).entity(str).build();
	// }
	//
	// create or update
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response createPhoto(String news) throws Exception {
		System.out.println("creating CLNews");

		Gson gson = new Gson();
		Photo obj = gson.fromJson(news, Photo.class);
		System.out.println(obj);
		String strDnts = gson.toJson(PhotoDao.save(obj));

		System.out.println(strDnts);

		return Response.status(200).entity(strDnts).build();
	}
	@POST
	@Path("/{photoId}/")
	@Consumes("application/json")
	@Produces("application/json")
	public Response updateDescPhoto(String photo) throws Exception {
		System.out.println("update photo desc");

		Gson gson = new Gson();
		Photo obj = gson.fromJson(photo, Photo.class);
		//System.out.println(obj.toString());
		String ret = gson.toJson(PhotoDao.saveDesc(obj.getId(),obj.getDesc()));

		System.out.println("result : " + ret);

		return Response.status(200).entity(ret).build();
	}

	@DELETE
	@Path("/{id}")
	@Produces("application/json")
	public void removeDnt(@PathParam("id") int id) throws Exception {
		System.out.println("Delete removePhoto: " + id);
		PhotoDao.remove(id);
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
