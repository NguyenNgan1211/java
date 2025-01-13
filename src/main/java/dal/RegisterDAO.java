package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.user;

public class RegisterDAO {
	Connection conn= null;
	PreparedStatement ps = null;
	public void insert(String username,String passwordmd5, String phone,String address, String role) {
		String sql = "insert into `user`(`username`,`password`,`phone`,`address`,`role`) values \r\n"
				+"(?,?,?,?,?)";
		try {Connection connection = DBContext.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		//ps.setInt(1,c.getUserid());
		ps.setString(1,username);
		ps.setString(2,passwordmd5);
		ps.setString(3,phone);
		ps.setString(4,address); 
		ps.setString(5,role);
		ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public class UserDAO extends DBContext {
		public List<user> getUserAll(){
			List<user> list = new ArrayList<>();
			String sql = "SELECT * FROM user";
			try (Connection connection = DBContext.getConnection();
		             PreparedStatement ps = connection.prepareStatement(sql);
		             ResultSet rs = ps.executeQuery()) {
				while(rs.next()) {
					int userid;
					String username,password,phone,address,role;
					userid = rs.getInt("userid");
					username = rs.getString("username");
					password = rs.getString("password");
					phone = rs.getString("phone");
					address = rs.getString("address");
					role = rs.getString("role");
					user c = new user(userid,username,password,phone,address,role);
					list.add(c);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
		public user getUserById(int userid) {
			String sql = " select * from `user`"
					+"where `userid` =?";
			try {Connection connection = DBContext.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1,userid);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				String username,password,phone,address,role;
				username = rs.getString("username");
				password = rs.getString("password");
				phone = rs.getString("phone");
				address = rs.getString("address");
				role = rs.getString("role");
				user c = new user(userid,username,password,phone,address,role);
				return c;
			}
			}catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
		public void insert(String username,String password, String phone,String address, String role) {
			String sql = "insert into `user`(`username`,`password`,`phone`,`address`,`role`) values \r\n"
					+"(?,?,?,?,?)";
			try {Connection connection = DBContext.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			//ps.setInt(1,c.getUserid());
			ps.setString(1,username);
			ps.setString(2,password);
			ps.setString(3,phone);
			ps.setString(4,address); 
			ps.setString(5,role);
			ps.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}
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
}
