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
			PreparedStatement ps = conn
					.prepareStatement(
							"INSERT INTO article (title, content, date, pic) "
									+ "VALUES (?, ?, ?, ?)",
							new String[] { "id" });
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
				ret= processRow(rs);
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

	public static ArrayList<Article> getArticles(int id,int num) throws Exception {
		System.out.println("getArticles: " + id);
		DBConnectionManager manager;

		try {
			manager = new DBConnectionManager();
			Connection conn = manager.getConnection();

			PreparedStatement pstmt = null;
			ResultSet rs = null;
			StringBuilder sqlCmd = new StringBuilder();

			sqlCmd.append("SELECT * FROM article");
			sqlCmd.append(" ORDER BY date DESC LIMIT ").append(id - 1)
					.append(",").append(num);

			String qSQL = sqlCmd.toString();
			System.out.println(qSQL);
			pstmt = conn.prepareStatement(qSQL);
			rs = pstmt.executeQuery();

			ArrayList<Article> list = new ArrayList<Article>();

			while (rs.next()) {

				Article tmp = processRow(rs);

				list.add(tmp);
				//System.out.println(tmp.toString());
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

	public static int getTotalNum() throws Exception {
		System.out.println("getArticles: TotalNum");
		DBConnectionManager manager;

		try {
			manager = new DBConnectionManager();
			Connection conn = manager.getConnection();

			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String qSQL= "SELECT COUNT(*)AS num FROM article";
			int total=-1;
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
		article.setPic("0.jpg");//rs.getString("pic"));
		article.setId(rs.getInt("id"));
		//System.out.println(article);
		return article;
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
