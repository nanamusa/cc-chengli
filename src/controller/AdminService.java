package controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import model.Admin;
import dao.AdminDAO;

@Path("/admin")
public class AdminService {
	/* ----------- admin start ----------- */
	@POST
	@Path("/verify")
	@Produces("application/json")
	public Response searchDonation(String userId) throws Exception {
		System.out.println("verify uid...");

		Gson gson = new Gson();
		// SearchCond obj = gson.fromJson(sc, SearchCond.class);
		// System.out.println(obj);
		String rs = gson.toJson(AdminDAO.getByUid(userId));
		System.out.println(rs);
		return Response.status(200).entity(rs).build();
	}

	@GET
	@Produces("application/json")
	public Response getAdmin() throws Exception {
		System.out.println("get Admin...");
		Gson gson = new Gson();
		String str = gson.toJson(AdminDAO.getAll());

		return Response.status(200).entity(str).build();
	}

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Response getAdminById(@DefaultValue("0") @PathParam("id") int id)
			throws Exception {
		System.out.println("get admin By Id : " + id);
		Gson gson = new Gson();
		String str = gson.toJson(AdminDAO.getById(id));
		System.out.println(str);
		return Response.status(200).entity(str).build();
	}

	@POST
	// create or update
	@Consumes("application/json")
	@Produces("application/json")
	public Response saveAdmin(String _admin) throws Exception {

		Gson gson = new Gson();
		Admin obj = gson.fromJson(_admin, Admin.class);
		System.out.println("Saving Admin: " + obj.getName());

		String retStr = gson.toJson(AdminDAO.save(obj));
		System.out.println(retStr);

		return Response.status(200).entity(retStr).build();
	}

	@PUT
	@Consumes("application/json")
	@Produces("application/json")
	public Response updateAdmin(String _admin) throws Exception {
		Gson gson = new Gson();
		Admin obj = gson.fromJson(_admin, Admin.class);
		System.out.println("Updating Admin: " + obj.getName());

		String retStr = gson.toJson(AdminDAO.save(obj));
		System.out.println(retStr);

		return Response.status(200).entity(retStr).build();
	}

	@DELETE
	@Path("/{id}")
	@Produces("application/json")
	public void removeAdmin(@PathParam("id") int id) throws Exception {
		System.out.println("Delete Admin: " + id);
		AdminDAO.remove(id);
	}
}
