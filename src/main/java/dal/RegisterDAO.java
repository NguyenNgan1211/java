package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterDAO {
	Connection conn= null;
	PreparedStatement ps = null;
	public boolean register(String username,String passwordmd5,String phone,String address, String role) {
	    String query = "INSERT INTO user (username, password, phone, address, role) VALUES (?, ?, ?, ?, ?)";
	    try {
	    	conn = new DBContext().getConnection();
	    	ps = conn.prepareStatement(query);
	    	ps.setString(1, username);
	    	ps.setString(2, passwordmd5);
	    	ps.setString(3, phone);
	    	ps.setString(4, address);
	    	ps.setString(5, role);
	    	
	    	ps.executeUpdate();
	    	
	    }catch(SQLException e) {
	    	e.printStackTrace();
	    }
	    return false;
	}
	public boolean PhoneExist(String phone) {
		 String query = "SELECT * FROM user WHERE phone= ?";
		 try {
			 conn = new DBContext().getConnection();
			 ps = conn.prepareStatement(query);
			 ps.setString(1, phone);
			 ResultSet rs = ps.executeQuery();
			 return rs.next();
		 }catch (SQLException e) {
			 e.printStackTrace();
		 }
		 return false;
	}
}
