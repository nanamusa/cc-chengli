package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Admin;

public class AdminDAO {

	public static ArrayList<Admin> getAll() throws Exception {
		System.out.println("dao.Admin: getAll...");

		ArrayList<Admin> arrList = new ArrayList<Admin>();

		DBConnectionManager manager;

		try {
			manager = new DBConnectionManager();
			Connection conn = manager.getConnection();

			PreparedStatement pstmt = null;
			ResultSet rs = null;

			StringBuilder sqlCmd = new StringBuilder();
			sqlCmd.append("SELECT * FROM user");
			// if (id > 0) {
			// sqlCmd.append(" WHERE ad_id=").append(id);
			// } else { // All
			sqlCmd.append(" ORDER BY admin_id ASC");
			// }
			String qSQL = sqlCmd.toString();

			pstmt = conn.prepareStatement(qSQL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				arrList.add(processRow(rs));
			} // rs.next()

			rs.close();
			pstmt.close();

			conn.close();

			return arrList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return arrList;
	}// end getiKTs

	public static ArrayList<Admin> getById(int id) throws Exception {
		System.out.println("dao.Admin: getById...");

		ArrayList<Admin> arrList = new ArrayList<Admin>();

		DBConnectionManager manager;

		try {
			manager = new DBConnectionManager();
			Connection conn = manager.getConnection();

			PreparedStatement pstmt = null;
			ResultSet rs = null;

			StringBuilder sqlCmd = new StringBuilder();
			sqlCmd.append("SELECT * FROM user");
			if (id > 0) {
				sqlCmd.append(" WHERE admin_id=").append(id);
			} else { // All
				sqlCmd.append(" ORDER BY admin_id ASC");
			}
			String qSQL = sqlCmd.toString();

			pstmt = conn.prepareStatement(qSQL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				arrList.add(processRow(rs));
			} // rs.next()

			rs.close();
			pstmt.close();

			conn.close();

			return arrList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return arrList;
	}

	public static Admin getByUid(String uid) throws Exception {
		System.out.println("dao.Admin: getByUid...");

		Admin admin = new Admin();

		DBConnectionManager manager;

		try {
			manager = new DBConnectionManager();
			Connection conn = manager.getConnection();

			PreparedStatement pstmt = null;
			ResultSet rs = null;

			StringBuilder sqlCmd = new StringBuilder();
			sqlCmd.append("SELECT * FROM user");
			sqlCmd.append(" WHERE admin_uid LIKE '").append(uid).append("'");

			String qSQL = sqlCmd.toString();
			System.out.println(qSQL);

			pstmt = conn.prepareStatement(qSQL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				admin = processRow(rs);
			} // rs.next()

			rs.close();
			pstmt.close();

			conn.close();

			return admin;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return admin;
	}

	public static Admin save(Admin admin) throws Exception {
		return admin.getId() > 0 ? update(admin) : create(admin);
	}

	public static Admin create(Admin admin) throws Exception {
		System.out.println("dao.admin: create...");

		DBConnectionManager manager;
		try {
			manager = new DBConnectionManager();
			Connection conn = manager.getConnection();
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO user (admin_name, admin_upwd, admin_uid, admin_email)"
							+ "VALUES (?, ?, ?, ?)",
					new String[] { "admin_id" });
			ps.setString(1, admin.getName());
			ps.setString(2, admin.getUpwd());
			ps.setString(3, admin.getUid());
			ps.setString(4, admin.getEmail());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			// Update the id in the returned object. This is important as this
			// value must be returned to the client.
			int id = rs.getInt(1);
			admin.setId(id);
			System.out.print(id);

			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return admin;
	}

	public static Admin update(Admin admin) throws Exception {
		System.out.println("dao.admin: update...");

		DBConnectionManager manager;
		try {
			manager = new DBConnectionManager();
			Connection conn = manager.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("UPDATE user SET admin_name=?,admin_uid=?,admin_upwd=?,admin_email=? WHERE admin_id=?");
			ps.setString(1, admin.getName());
			ps.setString(2, admin.getUid());
			ps.setString(3, admin.getUpwd());
			ps.setString(4, admin.getEmail());
			ps.setString(5, admin.getUpwd());
			ps.setInt(6, admin.getId());
			ps.executeUpdate();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return admin;
	}

	public static boolean remove(int id) throws Exception {
		System.out.println("dao.admin: remove...");

		DBConnectionManager manager;

		try {
			manager = new DBConnectionManager();
			Connection conn = manager.getConnection();

			PreparedStatement ps = conn
					.prepareStatement("DELETE FROM user WHERE admin_id=?");
			ps.setInt(1, id);
			int count = ps.executeUpdate();

			ps.close();
			conn.close();

			return count == 1;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	protected static Admin processRow(ResultSet rs) throws SQLException {
		Admin admin = new Admin();
		String pre = "admin_";

		admin.setName(rs.getString(pre + "name"));
		admin.setUid(rs.getString(pre + "uid"));
		admin.setUpwd(rs.getString(pre + "upwd"));
		admin.setEmail(rs.getString(pre + "email"));
		admin.setId(rs.getInt(pre + "id"));

		return admin;
	}

}
