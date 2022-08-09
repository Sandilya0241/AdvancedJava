package userregbean;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RegisterDao {
	public static int register(User obj) {
		int status = 0;
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pst = conn.prepareStatement("INSERT INTO USER432 VALUES(?, ?, ?)");
			pst.setString(1, obj.getStrUserName());
			pst.setString(2, obj.getStrUserEMail());
			pst.setString(3, obj.getStrPasswd());
			status = pst.executeUpdate();
		} catch (Exception e) {
		}
		return status;
	}
}
