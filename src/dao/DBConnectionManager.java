package dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {
	static Connection conn = null; // for test

	private Connection connect;

	public DBConnectionManager() throws SQLException, FileNotFoundException,
			IOException {
		// System.out.println("getting DB properties.....");89

		String uid = "root";
		String upwd = "C0ncept!23";
		String dburl = "jdbc:mysql://10.0.0.8:3306/chengli?characterEncoding=utf8";

		// uid = "root";
		upwd = "momo1203";
		dburl = "jdbc:mysql://localhost/chengli?characterEncoding=utf8";

		// String filePath = "../WEB-INF/demo.properties";

		// Properties props = new Properties();
		// if (false) {
		// props.load(new FileInputStream(filePath));
		// //
		// props.load(getServletContext().getResourceAsStream("/WEB-INF/lib/demo.properties"));
		// System.out.println("got .properties ");
		//
		// dburl = props.getProperty("dburl");
		// uid = props.getProperty("user");
		// upwd = props.getProperty("password");
		// }

//		System.out.println("database url: " + dburl);
//		System.out.println("database user: " + uid);
//		System.out.println("database password: " + upwd);

		// try {
		// Class.forName("com.mysql.jdbc.Driver");
		// } catch (ClassNotFoundException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		connect = DriverManager.getConnection(dburl, uid, upwd);

		// System.out.println("getting DB properties: done!");

	}

	public Connection getConnection() {
		return this.connect;
	}

	// public static void getDBProperties() throws SQLException {
	// System.out.println("getting DB properties.....");
	//
	// Properties props = new Properties();
	// try {
	// props.load(new FileInputStream("demo.properties"));
	// String dburl = props.getProperty("dburl");
	// String uid = props.getProperty("user");
	// String upwd = props.getProperty("password");
	//
	// System.out.println("database url: " + dburl);
	// System.out.println("database user: " + uid);
	// System.out.println("database password: " + upwd);
	//
	// conn = DriverManager.getConnection(dburl, uid, upwd);
	//
	// } catch (FileNotFoundException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// System.out.println("getting DB properties: done!");
	// }
	//
	// public static void hi() {
	// System.out.println("world");
	// }
	//
	// public static void main(String[] args) {
	// System.out.println("hello, you're testing for access database");
	// try {
	// getDBProperties();
	// } catch (Exception e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// }

}
