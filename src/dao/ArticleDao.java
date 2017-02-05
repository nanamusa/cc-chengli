package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import model.Article;

public class ArticleDao {

	public static Article save(Article article) throws Exception {
		return article.getId() > 0 ? update(article) : create(article);
	}

	public static Article create(Article article) throws Exception {
		System.out.println("dao.Article: create...");

		DBConnectionManager manager;

		try {
			manager = new DBConnectionManager();
			Connection conn = manager.getConnection();
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO article (title, content, date, pic) "
							+ "VALUES (?, ?, ?, ?)", new String[] { "id" });
			ps.setString(1, article.getTitle());
			ps.setString(2, article.getContent());
			ps.setString(3, article.getDate());
			ps.setString(4, article.getPic());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			// Update the id in the returned object. This is important as this
			// value must be returned to the client.
			int sid = rs.getInt(1);
			article.setId(sid);
			System.out.print(sid);

			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return article;
	}

	public static Article update(Article article) throws Exception {
		System.out.println("dao.Article: update...");

		DBConnectionManager manager;
		try {
			manager = new DBConnectionManager();
			Connection conn = manager.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("UPDATE article SET title=?, content=?, pic=?, date=? WHERE id=?");
			ps.setString(1, article.getTitle());
			ps.setString(2, article.getContent());
			ps.setString(3, article.getPic());
			ps.setString(4, article.getDate());
			ps.setInt(5, article.getId());
			ps.executeUpdate();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return article;
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
			} else if (Page == 1) {
				sqlCmd.append(" LIMIT 0, ").append(num);
			}

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
		article.setPic("0.jpg");// rs.getString("pic"));
		article.setId(rs.getInt("id"));
		// System.out.println(article);
		return article;
	}

}
