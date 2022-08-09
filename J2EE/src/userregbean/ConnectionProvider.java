package userregbean;
import static userregbean.Provider.*;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	private static Connection conn = null;
	static {
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(CONNECTION_URL, USER_NAME, PASSWORD);
		} catch (Exception e) {
		}
	}
	public static Connection getConnection() {
		return conn;
	}	
}
