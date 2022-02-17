package idv.kwl.handle.connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {

	public static java.sql.Connection getMysqlConnection() {
		String username = "root";
		String password = "1234";
		String url = "jdbc:mysql://localhost:3306/flashcardv2?"
				+ "useSSL=false&serverTimezone=UTC&characterEncoding=UTF-8";
		java.sql.Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}
}
