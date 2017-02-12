package dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {

	private Connection conn;
	private static java.util.Properties prop = new java.util.Properties();

	private static String uid = "root";
	private static String upwd = "C0ncept!23";
	private static String dburl = "jdbc:mysql://10.0.0.8:3306/chengli?characterEncoding=utf8";

	public DBConnectionManager() throws SQLException, FileNotFoundException,
			IOException {
		// System.out.println("getting DB properties.....");89
		// uid = "root";
		// upwd = "momo1203";
		// dburl = "jdbc:mysql://localhost/chengli?characterEncoding=utf8";

		/* load prop */
		loadProperties();

		conn = DriverManager.getConnection(dburl, uid, upwd);

		// System.out.println("getting DB properties: done!");

	}

	private static void loadProperties() {
		// get class loader
		ClassLoader loader = DBConnectionManager.class.getClassLoader();
		if (loader == null)
			loader = ClassLoader.getSystemClassLoader();

		// application.properties located in WEB-INF/classes/conf/
		String propFile = "conf/db.properties";
		java.net.URL url = loader.getResource(propFile);
		try {
			prop.load(url.openStream());
			// System.out.println("get properties: " + prop.toString());
			dburl = prop.getProperty("dburl");
			uid = prop.getProperty("user");
			upwd = prop.getProperty("password");

		} catch (Exception e) {
			System.err
					.println("Could not load configuration file: " + propFile);
		}
	}

	public Connection getConnection() {
		return this.conn;
	}

}
