package dao;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Album;
import model.Photo;

public class PhotoDao {

	public static String dbPhoto = "photo"; // table name
	public static String sqlSavePhoto = "(path, fileName, album_id)";
	public static String sqlUpdateDesc = "(desc)";

	public static int save(List<Photo> items, String albumId) throws Exception {
		int index = 0;

		while (items.size() > index) {
			items.get(index).setAlbumId(albumId);
			save(items.get(index));
			index++;
		}

		int ret = index;

		return ret;
	}

	public static Photo save(Photo item) throws Exception {
		return item.getId() > 0 ? update(item) : create(item);
	}

	public static Photo create(Photo item) throws Exception {
		System.out.println("dao.Photo: create...");

		DBConnectionManager manager;

		try {
			manager = new DBConnectionManager();
			Connection conn = manager.getConnection();
			PreparedStatement ps = conn
					.prepareStatement(
							"INSERT INTO photo (photo.path, photo.fileName, photo.album_id, photo.date, photo.desc) "
									+ "VALUES (?, ?, ?, ?, ?)",
							new String[] { "id" });

			ps.setString(1, item.getPath());
			ps.setString(2, item.getFile());
			ps.setString(3, item.getAlbumId());
			ps.setString(4, item.getDate());
			// ps.setString(5, item.getTitle());
			ps.setString(5, item.getDesc());
			// ps.setBoolean(1, item.isHide());

			// System.out.println(ps.toString());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			// Update the id in the returned object. This is important as this
			// value must be returned to the client.
			int sid = rs.getInt(1);
			item.setId(sid);
			// System.out.print(sid);

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
					.prepareStatement("UPDATE photo SET date=?, desc=? WHERE id=?");
			ps.setString(1, item.getDate());
			ps.setString(2, item.getDesc());
			// ps.setString(5, item.getDesc());
			// ps.setBoolean(1, item.isHide());
			ps.setInt(3, item.getId());
			ps.executeUpdate();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return item;
	}

	public static boolean saveDesc(int photoId, String desc) throws Exception {
		DBConnectionManager manager;
		try {
			manager = new DBConnectionManager();
			Connection conn = manager.getConnection();
			PreparedStatement ps = conn // UPDATE `chengli`.`photo` SET
										// `desc`='人很多人很多' WHERE `id`='47';
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

	public static boolean removeByAlbum(int albumId) throws Exception {
		boolean ret = false;

		String msg = "removeByAlbum: " + albumId;

		DBConnectionManager manager;
		try {
			manager = new DBConnectionManager();
			Connection conn = manager.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("DELETE FROM photo WHERE album_Id=?");
			ps.setInt(1, albumId);
			int count = ps.executeUpdate();

			if (count > 0) {
				msg = "remove " + count + " photos of album " + albumId;
			} else {
				msg = "empty album " + albumId;
			}
			System.out.println(msg);

			conn.close();

			ret = true;
			// ret = (count > 0);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}

	public static boolean remove(int id) throws Exception {
		boolean ret = false;

		DBConnectionManager manager;
		try {
			List<Photo> photo = getAll(id); // 1
			int aId = Integer.parseInt(photo.get(0).getAlbumId());
			Album album = AlbumDao.getById(aId);
			String filePath = album.getPath() + photo.get(0).getFile();
			File file = new File(filePath);
			System.out.println("path:" + album.getPath() + " : "
					+ file.exists());

			if (file.exists()) {
				file.delete();
			}

			manager = new DBConnectionManager();
			Connection conn = manager.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("DELETE FROM photo WHERE id=?");
			ps.setInt(1, id);
			int count = ps.executeUpdate();
			conn.close();

			ret = (count == 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}

	public static ArrayList<Photo> getAll(int id) throws Exception {
		System.out.println("dao.Photo: getAll...");

		ArrayList<Photo> photos = new ArrayList<Photo>();

		DBConnectionManager manager;

		try {
			manager = new DBConnectionManager();
			Connection conn = manager.getConnection();

			PreparedStatement pstmt = null;
			ResultSet rs = null;

			StringBuilder sqlCmd = new StringBuilder();

			sqlCmd.append("SELECT * FROM photo");

			if (id > 0) {// specific photo by id
				sqlCmd.append(" WHERE id = " + id);
			}

			sqlCmd.append(" ORDER BY id DESC");

			String qSQL = sqlCmd.toString();
			System.out.println(qSQL);

			pstmt = conn.prepareStatement(qSQL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				photos.add(processRow(rs));
			} // rs.next()

			rs.close();
			pstmt.close();
			conn.close();

			return photos;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return photos;

	}// end getAll()

	public static ArrayList<Photo> getByAlbum(int albumId) throws Exception {
		System.out.println("dao.Photo: getPhotoSetByAlbum = " + albumId);

		ArrayList<Photo> photoSet = new ArrayList<Photo>();

		DBConnectionManager manager;

		try {
			manager = new DBConnectionManager();
			Connection conn = manager.getConnection();

			PreparedStatement pstmt = null;
			ResultSet rs = null;

			StringBuilder sqlCmd = new StringBuilder();

			sqlCmd.append("SELECT * FROM photo").append(
					" WHERE album_Id = " + albumId);
			sqlCmd.append(" ORDER BY id DESC");

			String qSQL = sqlCmd.toString();
			System.out.println(qSQL);

			pstmt = conn.prepareStatement(qSQL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				photoSet.add(processRow(rs));
			} // rs.next()

			rs.close();
			pstmt.close();
			conn.close();

			return photoSet;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return photoSet;

	}// end getByAlbum()

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
	}// end getBlogPhoto()

	protected static Photo processRow(ResultSet rs) throws SQLException {
		Photo item = new Photo();
		if (rs.getDate("date") != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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

}
