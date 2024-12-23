package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.User;

import model.News;
import model.user;

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
	public void update(user c) {
		String sql = "update `user` \r\n"
				+ "set `username` =? ,`password` =?,`phone` =?,`address`=?,`role`=? "
				+"where `userid` = ?;";
		try (Connection connection = DBContext.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql))
		{
			ps.setString(1, c.getUsername());
			ps.setString(2, c.getPassword());
			ps.setString(3, c.getPhone());
			ps.setString(4, c.getAddress());
			ps.setString(5, c.getRole());
			ps.setInt(6,c.getUserid());
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void delete (int userid) {
		String sql = "delete from `user` \r\n"
				+ "where `userid` = ?;";
		try {
    		Connection connection = DBContext.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, userid);
			ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	 public static void main(String[] args) {
	    	UserDAO dao = new UserDAO();
			List<user> list = dao.getUserAll();
			for (user o : list) {
			    System.out.println(o);
			}
	 }
}

	

