package dao;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.Album;

public class AlbumDao {

	
	public static Boolean mkdir(int id, String path) throws Exception {

		Album album = getById(id);

		album.setPath(path);

		boolean ret = updatePath(album);
		System.out.println("mkdir album = " + id + " result:" + ret);
		return ret;
	}

	public static Album save(Album album) throws Exception {
		return album.getId() > 0 ? update(album) : create(album);
	}

	public static Album create(Album album) throws Exception {
		System.out.println("dao.Album: create...");

		DBConnectionManager manager;

		try {
			manager = new DBConnectionManager();
			Connection conn = manager.getConnection();
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO album (title,type,date,tag_id) "
							+ "VALUES (?,?,?,?)", new String[] { "id" });
			ps.setString(1, album.getTitle());
			ps.setString(2, album.getType());
			ps.setString(3, album.getDate());
			ps.setInt(4, album.getTag());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			// Update the id in the returned object. This is important as this
			// value must be returned to the client.
			int sid = rs.getInt(1);
			album.setId(sid);
			System.out.print(sid);

			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return album;
	}

	public static boolean updatePath(Album album) throws Exception {
		System.out.println("dao.Album: update...");
		boolean ret = false;
		if (album.getPath().isEmpty()) {
			return ret;
		}

		DBConnectionManager manager;
		try {
			manager = new DBConnectionManager();
			Connection conn = manager.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("UPDATE album SET album.path=? WHERE id=?");
			ps.setString(1, album.getPath());
			ps.setInt(2, album.getId());
			ps.executeUpdate();
			conn.close();
			ret = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ret;
	}

	public static Album update(Album album) throws Exception {
		System.out.println("dao.Album: update...");

		DBConnectionManager manager;
		try {
			manager = new DBConnectionManager();
			Connection conn = manager.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("UPDATE album SET album.title=?, album.date=?, album.tag_id=? WHERE id=?");
			ps.setString(1, album.getTitle());
			ps.setString(2, album.getDate());
			ps.setInt(3, album.getTag());
			//ps.setString(4, album.getPath());
			ps.setInt(4, album.getId());
			ps.executeUpdate();
			conn.close();
			System.out.println("dao.Album: update..." + album.getTag());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return album;
	}

	public static boolean remove(int albumId) throws Exception {
		Album album = getById(albumId);
		String path = album.getPath();
		File file = new File(path);
		if (file.exists() && deleteDirectory(path)) {
			PhotoDao.removeByAlbum(albumId);
			DBConnectionManager manager;
			try {
				manager = new DBConnectionManager();
				Connection conn = manager.getConnection();
				PreparedStatement ps = conn
						.prepareStatement("DELETE FROM album WHERE id=?");
				ps.setInt(1, albumId);
				int count = ps.executeUpdate();
				conn.close();

				return count == 1;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}
		return false;

	}

	public static boolean deleteFile(String sPath) {
		boolean flag = false;
		File file = new File(sPath);
		// 路径为文件且不为空则进行删除
		if (file.isFile() && file.exists()) {
			file.delete();
			flag = true;
		}
		return flag;
	}

	public static boolean deleteDirectory(String sPath) {
		boolean flag = false;
		// 如果sPath不以文件分隔符结尾，自动添加文件分隔符
		if (!sPath.endsWith(File.separator)) {
			sPath = sPath + File.separator;
		}
		File dirFile = new File(sPath);
		// 如果dir对应的文件不存在，或者不是一个目录，则退出
		if (!dirFile.exists() || !dirFile.isDirectory()) {
			return false;
		}
		flag = true;
		// 删除文件夹下的所有文件(包括子目录)
		File[] files = dirFile.listFiles();
		for (int i = 0; i < files.length; i++) {
			// 删除子文件
			if (files[i].isFile()) {
				flag = deleteFile(files[i].getAbsolutePath());
				if (!flag)
					break;
			} // 删除子目录
			else {
				flag = deleteDirectory(files[i].getAbsolutePath());
				if (!flag)
					break;
			}
		}
		if (!flag)
			return false;
		// 删除当前目录
		if (dirFile.delete()) {
			return true;
		} else {
			return false;
		}
	}

	public static ArrayList<Album> getAll(String type) throws Exception {
		System.out.println("dao.Album: getAll by :" + type);

		ArrayList<Album> arrList = new ArrayList<Album>();

		DBConnectionManager manager;

		try {
			manager = new DBConnectionManager();
			Connection conn = manager.getConnection();

			PreparedStatement pstmt = null;
			ResultSet rs = null;

			StringBuilder sqlCmd = new StringBuilder();
			sqlCmd.append("SELECT * FROM album");
			if (type.equals("Champion") || type.equals("Activity")) {
				sqlCmd.append(" WHERE type LIKE '").append(type);
				sqlCmd.append("' ORDER BY date DESC");

			} else if (type.equals("Blog")) {
				sqlCmd.append(" WHERE type LIKE '").append(type);
				sqlCmd.append("' ORDER BY id DESC");

			} else { // Activity, Champion

				sqlCmd.append(" ORDER BY id DESC");
			}

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
			System.out.println("dao.Album: EXIT getAll by :" + type);
			return arrList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return arrList;
	}// end getAll()

	public static Album getById(int id) throws Exception {
		System.out.println("dao.Album: getById..." + id);

		Album ret = new Album();

		DBConnectionManager manager;

		try {
			manager = new DBConnectionManager();
			Connection conn = manager.getConnection();

			PreparedStatement pstmt = null;
			ResultSet rs = null;

			StringBuilder sqlCmd = new StringBuilder();
			sqlCmd.append("SELECT * FROM album");
			sqlCmd.append(" WHERE id=").append(id);

			String qSQL = sqlCmd.toString();

			pstmt = conn.prepareStatement(qSQL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ret = processRow(rs);
				System.out.println("dao.Album: getById -> " + ret.getTitle());
			} // rs.next()

			rs.close();
			pstmt.close();

			conn.close();

			return ret;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ret;
	}

	public static ArrayList<Album> getClassSets() throws Exception {

		DBConnectionManager manager;

		try {
			manager = new DBConnectionManager();
			Connection conn = manager.getConnection();

			PreparedStatement pstmt = null;
			ResultSet rs = null;
			StringBuilder sqlCmd = new StringBuilder();
			sqlCmd.append("SELECT * FROM album");
			sqlCmd.append(" ORDER BY album_id DESC");

			String qSQL = sqlCmd.toString();
			pstmt = conn.prepareStatement(qSQL);
			rs = pstmt.executeQuery();

			ArrayList<Album> setList = new ArrayList<Album>();

			while (rs.next()) {

				Album tmp = processRow(rs);

				setList.add(tmp);
			} // rs.next()

			rs.close();
			pstmt.close();

			conn.close();
			return setList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public static Album getClassSetById(String id) throws Exception {

		DBConnectionManager manager;

		try {
			manager = new DBConnectionManager();
			Connection conn = manager.getConnection();

			PreparedStatement pstmt = null;
			ResultSet rs = null;
			StringBuilder sqlCmd = new StringBuilder();
			sqlCmd.append("SELECT * FROM album").append(" WHERE album_id = ")
					.append(id);

			String qSQL = sqlCmd.toString();
			pstmt = conn.prepareStatement(qSQL);
			rs = pstmt.executeQuery();

			Album classSet = new Album();

			while (rs.next()) {
				classSet = processRow(rs);
			} // rs.next()

			rs.close();
			pstmt.close();

			conn.close();
			return classSet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	protected static Album processRow(ResultSet rs) throws SQLException {
		Album classSet = new Album();

		classSet.setPath(rs.getString("path"));
		String anObject = rs.getString("type");

		if (rs.getDate("date") != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date tranDate = rs.getDate("date");
			classSet.setDate(sdf.format(tranDate));
			// System.out.println(classSet.getDate());
		}/*
		 * else { classSet.setDate(classSet.getTitle().substring(0, 4)); //
		 * classSet.setTitle(classSet.getTitle().substring(4)); }
		 */
		classSet.setType(anObject);
		if ("Blog".equals(anObject)) {
			classSet.setId(rs.getInt("id"));
			classSet.setTitle("Blog pic");

		} else if ("Activity".equals(anObject)) {
			classSet.setId(rs.getInt("id"));
			classSet.setTitle(rs.getString("title"));
			classSet.setPic(rs.getString("cover_id"));
			classSet.setTag(rs.getInt("tag_id"));

		} else if ("Champion".equals(anObject)) {
			classSet.setId(rs.getInt("id"));
			classSet.setTitle(rs.getString("title"));
			classSet.setTag(rs.getInt("tag_id"));
		}
		System.out.println(classSet.toString());
		return classSet;
	}

	public static boolean saveCover(int albumId, String coverId)
			throws Exception {
		// TODO Auto-generated method stub
		// System.out.println("dao.Album: saveCover...");
		DBConnectionManager manager;
		try {
			manager = new DBConnectionManager();
			Connection conn = manager.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("UPDATE album SET cover_id=? WHERE id=?");// and
																				// type='Champion'");
			ps.setString(1, coverId);
			ps.setInt(2, albumId);
			ps.executeUpdate();
			System.out.println("Album#" + albumId + " Cover => Photo#"
					+ coverId);
			conn.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

}
