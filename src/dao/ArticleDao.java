package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import util.util_log;
import model.Article;
import model.Photo;

public class ArticleDao {

	static util_log LOG = new util_log();
	static String msg = "";
	static String msg_head = "[dao Article] ";
	static int opt = 1;

	public static boolean save(Article article) throws Exception {
		boolean ret = false;

		if (article.getId() > 0) {
			ret = update(article);
		} else {
			ret = create(article);
		}

		return ret;
	}

	public static boolean create(Article article) throws Exception {
		msg = msg_head + "[create] " + article;
		LOG.DEBUG_LOG(msg, opt);

		boolean ret = false;
		String sql = "INSERT INTO article (title, content, date, pic) "
				+ "VALUES (?, ?, ?, ?)";

		DBConnectionManager manager;
		try {
			manager = new DBConnectionManager();
			Connection conn = manager.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql,
					new String[] { "id" });
			ps.setString(1, article.getTitle());
			ps.setString(2, article.getContent());
			ps.setString(3, article.getDate());
			ps.setString(4, article.getPic());
			ps.executeUpdate();

			LOG.DEBUG_LOG(msg_head + ps.toString(), opt);

			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			// Update the id in the returned object. This is important as this
			// value must be returned to the client.
			int id = rs.getInt(1);
			article.setId(id);
			if (id > 0) {
				ret = true;
				msg = msg_head + "id=" + id;
			} else {
				msg = msg_head + "fail";
			}
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		msg += ", result=" + ret;
		LOG.DEBUG_LOG(msg, opt);

		return ret;
	}

	public static boolean update(Article article) throws Exception {
		msg = msg_head + "[update] " + article;
		LOG.DEBUG_LOG(msg, opt);
		String sql = "UPDATE article SET title=?, content=?, date=? WHERE id=?";
		boolean ret = false;

		DBConnectionManager manager;
		try {
			manager = new DBConnectionManager();
			Connection conn = manager.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, article.getTitle());
			ps.setString(2, article.getContent());
			// ps.setString(3, article.getPic());
			ps.setString(3, article.getDate());
			ps.setInt(4, article.getId());
			LOG.DEBUG_LOG(msg_head + ps, opt);

			if (ps.executeUpdate() > 0) {
				ret = true;
			}
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		msg = msg_head + "result=" + ret;
		LOG.DEBUG_LOG(msg, opt);
		return ret;
	}

	public static boolean updatePic(String fileName, String id)
			throws Exception {
		msg = msg_head + "[updatePic] " + id + ", fileName=" + fileName;
		LOG.DEBUG_LOG(msg, opt);

		String sql = "UPDATE article SET pic=? WHERE id=?";
		boolean ret = false;
		int blogId = Integer.parseInt(id);

		// if picture exist, then rm it
		Article article = getById(blogId);
		String pic = "" + article.getPic();
		if (pic.isEmpty() || pic.equals("")) {

		} else {
			Photo photo = PhotoDao.getBlogPhoto(id);
			PhotoDao.remove(photo.getId());
			photo.setFile(fileName);
			PhotoDao.update(photo);
		}

		DBConnectionManager manager = new DBConnectionManager();
		try {
			Connection conn = manager.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, fileName);
			ps.setInt(2, blogId);
			ps.executeUpdate();

			conn.close();
			ret = true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ret;
	}

	public static boolean remove(int sid) throws Exception {
		DBConnectionManager manager;
		try {
			manager = new DBConnectionManager();
			Connection conn = manager.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("DELETE FROM article WHERE id=?");
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

	public static ArrayList<Article> getAll() throws Exception {
		System.out.println("dao.Article: getAll...");

		ArrayList<Article> arrList = new ArrayList<Article>();

		DBConnectionManager manager;

		try {
			manager = new DBConnectionManager();
			Connection conn = manager.getConnection();

			PreparedStatement pstmt = null;
			ResultSet rs = null;

			StringBuilder sqlCmd = new StringBuilder();
			sqlCmd.append("SELECT * FROM article");
			sqlCmd.append(" ORDER BY date DESC");

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

	public static ArrayList<Article> search(String keyWord, int Page, int num)
			throws Exception {
		System.out.println("dao.Article: search keyWord => " + keyWord);
		ArrayList<Article> arrayList = new ArrayList<Article>();
		DBConnectionManager manager;

		try {
			manager = new DBConnectionManager();
			Connection conn = manager.getConnection();

			PreparedStatement pstmt = null;
			ResultSet rs = null;

			int id = 1 + (Page - 1) * num;

			StringBuilder sqlCmd = new StringBuilder();

			Page = 1;
			num = 100;
			sqlCmd.append(
					"SELECT id,title, SUBSTRING(content,1,80) AS content,pic,date FROM article")
					.append(" WHERE title like '%" + keyWord + "%'")
					.append(" OR content like '%" + keyWord + "%'")
					.append(" ORDER BY date DESC, id DESC");
			if (Page > 1) {
				sqlCmd.append(" LIMIT ").append(id - 1).append(",").append(num);
			}
			// } else if (Page == 1) {
			// sqlCmd.append(" LIMIT 0, ").append(num);
			// }

			String qSQL = sqlCmd.toString();
			System.out.println(qSQL);

			pstmt = conn.prepareStatement(qSQL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				arrayList.add(processRow(rs));
			} // rs.next()

			rs.close();
			pstmt.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return arrayList;
	}

	public static Article getById(int id) throws Exception {
		System.out.println("dao.Article: getById...");

		Article ret = new Article();

		DBConnectionManager manager;

		try {
			manager = new DBConnectionManager();
			Connection conn = manager.getConnection();

			PreparedStatement pstmt = null;
			ResultSet rs = null;

			StringBuilder sqlCmd = new StringBuilder();
			sqlCmd.append("SELECT * FROM article");
			sqlCmd.append(" WHERE id=").append(id);
			sqlCmd.append(" ORDER BY date ");

			String qSQL = sqlCmd.toString();

			pstmt = conn.prepareStatement(qSQL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ret = processRow(rs);
			} // rs.next()

			rs.close();
			pstmt.close();

			conn.close();

			System.out.println(ret);

			return ret;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ret;
	}

	public static ArrayList<Article> getArticles(int Page, int num)
			throws Exception {
		System.out.println("getArticles Page: " + Page);
		DBConnectionManager manager;

		try {
			manager = new DBConnectionManager();
			Connection conn = manager.getConnection();

			PreparedStatement pstmt = null;
			ResultSet rs = null;

			int id;

			StringBuilder sqlCmd = new StringBuilder();
			if (Page > 0) {
				id = 1 + (Page - 1) * num;
				sqlCmd.append(
						"SELECT id,title, SUBSTRING(content,1,80) AS content,pic,date FROM article ORDER BY date DESC LIMIT ")
						.append(id - 1).append(",").append(num);
			} else {
				id = 1;
				sqlCmd.append(
						"SELECT * FROM article ORDER BY date DESC LIMIT 0, ")
						.append(num);
			}

			String qSQL = sqlCmd.toString();
			System.out.println(qSQL);
			pstmt = conn.prepareStatement(qSQL);
			rs = pstmt.executeQuery();

			ArrayList<Article> list = new ArrayList<Article>();

			while (rs.next()) {

				Article tmp = processRow(rs);

				list.add(tmp);
				// System.out.println(tmp.toString());
			} // rs.next()

			rs.close();
			pstmt.close();

			conn.close();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public static int getTotalNum(String keyWord) throws Exception {
		System.out.println("getArticles: TotalNum");
		DBConnectionManager manager;

		try {
			manager = new DBConnectionManager();
			Connection conn = manager.getConnection();

			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String qSQL = "SELECT COUNT(*)AS num FROM article";
			if (keyWord != "") {
				qSQL = "SELECT COUNT(*)AS num FROM article WHERE title Like %"
						+ keyWord + "% OR content Like %" + keyWord + "%";
			}
			int total = -1;
			pstmt = conn.prepareStatement(qSQL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				total = rs.getInt("num");
			} // rs.next()

			rs.close();
			pstmt.close();

			conn.close();
			return total;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;

	}

	protected static Article processRow(ResultSet rs) throws SQLException {
		Article article = new Article();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date tranDate = rs.getDate("date");
		article.setDate(sdf.format(tranDate));

		article.setTitle(rs.getString("title"));
		article.setContent(rs.getString("content"));
		article.setPic(rs.getString("pic"));// ;
		article.setId(rs.getInt("id"));
		// System.out.println(article);
		return article;
	}

}
