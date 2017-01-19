package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.Photo;

public class PhotoDao {

	public static Photo save(Photo item) throws Exception {
		return item.getId() > 0 ? update(item) : create(item);
	}

	public static Photo create(Photo item) throws Exception {
		System.out.println("dao.Photo: create...");

		DBConnectionManager manager;

		try {
			manager = new DBConnectionManager();
			Connection conn = manager.getConnection();
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO photo (path, fileName, album_id) "
							+ "VALUES (?, ?, ?)", new String[] { "id" });

			ps.setString(1, item.getPath());
			ps.setString(2, item.getFile());
			ps.setString(3, item.getAlbumId());
			// ps.setString(4, item.getDate());
			// ps.setString(5, item.getTitle());
			// ps.setString(6, item.getDesc());
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

	public static Photo update(Photo item) throws Exception {
		System.out.println("dao.Photo: update...");

		DBConnectionManager manager;
		try {
			manager = new DBConnectionManager();
			Connection conn = manager.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("UPDATE photo SET path=?, fileName=?, album_Id=?, date=? WHERE id=?");
			ps.setString(1, item.getPath());
			ps.setString(2, item.getFile());
			ps.setString(3, item.getAlbumId());
			ps.setString(4, item.getDate());
			//ps.setString(5, item.getDesc());
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

	public static boolean saveDesc(int photoId, String desc)
			throws Exception {
		DBConnectionManager manager;
		try {
			manager = new DBConnectionManager();
			Connection conn = manager.getConnection();
			PreparedStatement ps = conn //UPDATE `chengli`.`photo` SET `desc`='人很多人很多' WHERE `id`='47';
					.prepareStatement("UPDATE `photo` SET `desc`=? WHERE `id`=?");// and
																				// type='Champion'");
			ps.setString(1, desc);
			ps.setInt(2, photoId);
			ps.executeUpdate();
			System.out.println("Photo#" + photoId + " desc: " + desc);
			conn.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	public static boolean remove(int sid) throws Exception {
		DBConnectionManager manager;
		try {
			manager = new DBConnectionManager();
			Connection conn = manager.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("DELETE FROM photo WHERE id=?");
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

	public static ArrayList<Photo> getAll(int id) throws Exception {
		System.out.println("dao.Photo: getAll...");

		ArrayList<Photo> arrList = new ArrayList<Photo>();

		DBConnectionManager manager;

		try {
			manager = new DBConnectionManager();
			Connection conn = manager.getConnection();

			PreparedStatement pstmt = null;
			ResultSet rs = null;

			StringBuilder sqlCmd = new StringBuilder();
			sqlCmd.append("SELECT * FROM photo");
			if (id > 0) {
				sqlCmd.append(" WHERE id = " + id);
			}
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

	public static ArrayList<Photo> getByAlbum(int albumId) throws Exception {
		System.out.println("dao.Photo: getAllByAlbum : " + albumId);

		ArrayList<Photo> arrList = new ArrayList<Photo>();

		DBConnectionManager manager;

		try {
			manager = new DBConnectionManager();
			Connection conn = manager.getConnection();

			PreparedStatement pstmt = null;
			ResultSet rs = null;

			StringBuilder sqlCmd = new StringBuilder();
			sqlCmd.append("SELECT * FROM photo").append(" WHERE album_Id = ")
					.append(albumId);
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

	public static ArrayList<Photo> getBlogPhoto(int BlogId) throws Exception {
		System.out.println("dao.Photo: getBlogPhoto : " + BlogId);

		ArrayList<Photo> arrList = new ArrayList<Photo>();

		DBConnectionManager manager;

		try {
			manager = new DBConnectionManager();
			Connection conn = manager.getConnection();

			PreparedStatement pstmt = null;
			ResultSet rs = null;

			StringBuilder sqlCmd = new StringBuilder();
			sqlCmd.append("SELECT * FROM photo");
			sqlCmd.append(" WHERE path LIKE 'Blog%'");
			if (BlogId > 0)
				sqlCmd.append(" AND album_id like '%" + BlogId + "%'");
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

	protected static Photo processRow(ResultSet rs) throws SQLException {
		Photo item = new Photo();
		if (rs.getDate("date") != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date tranDate = rs.getDate("date");
			item.setDate(sdf.format(tranDate));
			// System.out.println(classSet.getDate());
		}

		item.setPath(rs.getString("path"));
		item.setFile(rs.getString("fileName"));
		item.setDesc(rs.getString("desc"));
		item.setAlbumId(rs.getString("album_Id"));
		// item.setHide(rs.getBoolean("hide"));
		item.setId(rs.getInt("id"));

		return item;
	}

	// public static boolean[] SC_emptyCheck(SearchCond sc) {
	// boolean[] flagCheck = new boolean[7];
	//
	// for (int index = 0; index < flagCheck.length; index++)
	// flagCheck[index] = true;
	//
	// // 0:name, 1:iktBranch, 2:organization, 3:amount, 4:id, 5,6:date
	// flagCheck[0] = sc.getSdate().isEmpty();
	// flagCheck[1] = sc.getEdate().isEmpty();
	// flagCheck[2] = sc.getId().isEmpty();
	// flagCheck[3] = sc.getName().isEmpty();
	// flagCheck[4] = sc.getI_ikt().isEmpty();
	// flagCheck[5] = sc.getI_org().isEmpty();
	// flagCheck[6] = sc.get_amount().isEmpty();
	//
	// return flagCheck;
	// }

	// /* useless */
	// public static ArrayList<String> getContent(String sql, String data) {
	//
	// DBConnectionManager manager;
	//
	// try {
	// manager = new DBConnectionManager();
	// Connection conn = manager.getConnection();
	//
	// PreparedStatement pstmt = null;
	// ResultSet rs = null;
	//
	// pstmt = conn.prepareStatement(sql);
	// rs = pstmt.executeQuery();
	//
	// ArrayList<String> list = new ArrayList<String>();
	//
	// while (rs.next()) {
	// list.add(rs.getString(data));
	// } // rs.next()
	//
	// rs.close();
	// pstmt.close();
	//
	// conn.close();
	// return list;
	// } catch (ClassNotFoundException | SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// return null;
	//
	// }

	/*
	 * public static void main(String args[]) {
	 * 
	 * String cond_name="Ｏ", cond_iktBranch="", cond_organization="",
	 * cond_amount="", cond_id="", sDate="", eDate="20170101";
	 * ArrayList<DonationObject> tmp; //tmp = GetDonationList(cond_name,
	 * cond_iktBranch, cond_organization, cond_amount, cond_id, sDate, eDate);
	 * String qSearch =
	 * "SELECT dnt_donor_name, ib_name, dnt_organization, dnt_amount, LPAD(dnt_id, 6, '0') AS dnt_id, dnt_date FROM dnt "
	 * ; String qJoin = "INNER JOIN ikt ON dnt_ikt_branch_id = ib_id  "; String
	 * qOrder = "ORDER BY dnt_date DESC "; System.out.println(qSearch+ qJoin+
	 * qOrder); tmp = searchDnts(qSearch, qJoin, qOrder); if (tmp.isEmpty()) {
	 * System.out.println("no result!"); } else {
	 * System.out.println(tmp.size()); }
	 * 
	 * }
	 */

}
