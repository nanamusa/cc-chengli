package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import model.Praise;
import dao.DBConnectionManager;

public class PraiseInfoDao {

	public static Praise save(Praise item) throws Exception {
		return item.getId() > 0 ? update(item) : create(item);
	}

	public static Praise create(Praise item) throws Exception {
		System.out.println("dao.Praise: create...");

		DBConnectionManager manager;

		try {
			manager = new DBConnectionManager();
			Connection conn = manager.getConnection();
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO photo (name, file, title, ppl) "
							+ "VALUES (?, ?, ?, ?)", new String[] { "id" });

			ps.setString(1, item.getName());
			ps.setString(2, item.getFile());
			ps.setString(3, item.getTitle());
			ps.setString(4, item.getPpl());
			// ps.setBoolean(1, item.isHide());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			// Update the id in the returned object. This is important as this
			// value must be returned to the client.
			int sid = rs.getInt(1);
			item.setId(sid);
			System.out.print(sid);

			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return item;
	}

	public static Praise update(Praise item) throws Exception {
		System.out.println("dao.Praise: update...");

		DBConnectionManager manager;
		try {
			manager = new DBConnectionManager();
			Connection conn = manager.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("UPDATE praise SET name=?, file=?, title=?, ppl=? WHERE id=?");
			ps.setString(1, item.getName());
			ps.setString(2, item.getFile());
			ps.setString(3, item.getTitle());
			ps.setString(4, item.getPpl());
			// ps.setBoolean(1, item.isHide());
			ps.setInt(5, item.getId());
			ps.executeUpdate();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return item;
	}

	public static boolean remove(int sid) throws Exception {
		DBConnectionManager manager;
		try {
			manager = new DBConnectionManager();
			Connection conn = manager.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("DELETE FROM praise WHERE id=?");
			ps.setInt(1, sid);
			int count = ps.executeUpdate();
			conn.close();

			return count == 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static ArrayList<Praise> getById(int sid) {
		System.out.println("dao.Praise: getById...");

		ArrayList<Praise> arrList = new ArrayList<Praise>();

		DBConnectionManager manager;

		try {
			manager = new DBConnectionManager();
			Connection conn = manager.getConnection();

			PreparedStatement pstmt = null;
			ResultSet rs = null;

			StringBuilder sqlCmd = new StringBuilder();
			sqlCmd.append("SELECT * FROM praise");
			sqlCmd.append(" WHERE id = " + sid);
			sqlCmd.append(" ORDER BY id DESC");

			String qSQL = sqlCmd.toString();
			System.out.println(qSQL);

			pstmt = conn.prepareStatement(qSQL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				arrList.add(processRow(rs));
			} // rs.next()

			rs.close();
			pstmt.close();

			conn.close();

			return arrList;
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		return arrList;

	}

	public static ArrayList<Praise> getAll() throws Exception {
		System.out.println("dao.Praise: getAll...");

		ArrayList<Praise> arrList = new ArrayList<Praise>();

		DBConnectionManager manager;

		try {
			manager = new DBConnectionManager();
			Connection conn = manager.getConnection();

			PreparedStatement pstmt = null;
			ResultSet rs = null;

			StringBuilder sqlCmd = new StringBuilder();
			sqlCmd.append("SELECT * FROM praise");
			sqlCmd.append(" ORDER BY id DESC");

			String qSQL = sqlCmd.toString();
			System.out.println(qSQL);

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
	}// end getAll()
	/*
	 * public static ArrayList<CLNews> getById(int id) throws Exception {
	 * System.out.println("dao.CLNews: getById...");
	 * 
	 * ArrayList<CLNews> ret = new ArrayList<CLNews>();
	 * 
	 * DBConnectionManager manager;
	 * 
	 * try { manager = new DBConnectionManager(); Connection conn =
	 * manager.getConnection();
	 * 
	 * PreparedStatement pstmt = null; ResultSet rs = null;
	 * 
	 * StringBuilder sqlCmd = new StringBuilder();
	 * sqlCmd.append("SELECT * FROM news");
	 * sqlCmd.append(" WHERE news_id=").append(id);
	 * sqlCmd.append(" ORDER BY news_date DESC");
	 * 
	 * String qSQL = sqlCmd.toString();
	 * 
	 * pstmt = conn.prepareStatement(qSQL); rs = pstmt.executeQuery();
	 * 
	 * while (rs.next()) { ret.add(processRow(rs)); } // rs.next()
	 * 
	 * rs.close(); pstmt.close();
	 * 
	 * conn.close();
	 * 
	 * return ret; } catch (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * return ret; }
	 * 
	 * public static ArrayList<CLNews> getCLNews() throws Exception {
	 * 
	 * DBConnectionManager manager;
	 * 
	 * try { manager = new DBConnectionManager(); Connection conn =
	 * manager.getConnection();
	 * 
	 * PreparedStatement pstmt = null; ResultSet rs = null; StringBuilder sqlCmd
	 * = new StringBuilder(); sqlCmd.append("SELECT * FROM news");
	 * sqlCmd.append(" ORDER BY news_date DESC, news_id DESC");
	 * 
	 * String qSQL = sqlCmd.toString(); pstmt = conn.prepareStatement(qSQL); rs
	 * = pstmt.executeQuery();
	 * 
	 * ArrayList<CLNews> newsList = new ArrayList<CLNews>();
	 * 
	 * while (rs.next()) {
	 * 
	 * CLNews tmp = processRow(rs);
	 * 
	 * newsList.add(tmp); } // rs.next()
	 * 
	 * rs.close(); pstmt.close();
	 * 
	 * conn.close(); return newsList; } catch (SQLException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } return null;
	 * 
	 * }
	 * 
	 * public static CLNews getCLNewsById(String id) throws Exception {
	 * 
	 * DBConnectionManager manager;
	 * 
	 * try { manager = new DBConnectionManager(); Connection conn =
	 * manager.getConnection();
	 * 
	 * PreparedStatement pstmt = null; ResultSet rs = null; StringBuilder sqlCmd
	 * = new StringBuilder();
	 * sqlCmd.append("SELECT * FROM news").append(" WHERE news_id = ")
	 * .append(id);
	 * 
	 * String qSQL = sqlCmd.toString(); pstmt = conn.prepareStatement(qSQL); rs
	 * = pstmt.executeQuery();
	 * 
	 * CLNews news = new CLNews();
	 * 
	 * while (rs.next()) { news = processRow(rs); } // rs.next()
	 * 
	 * rs.close(); pstmt.close();
	 * 
	 * conn.close(); return news; } catch (SQLException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } return null;
	 * 
	 * }
	 */

	protected static Praise processRow(ResultSet rs) throws SQLException {
		Praise item = new Praise();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		//Date tranDate = rs.getDate("date");
		// item.setDate(sdf.format(tranDate));

		item.setName(rs.getString("name"));
		item.setFile(rs.getString("file"));
		item.setTitle(rs.getString("title"));
		item.setPpl(rs.getString("ppl"));
		item.setId(rs.getInt("id"));

		return item;
	}

}
