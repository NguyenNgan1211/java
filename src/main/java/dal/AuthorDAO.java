package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Author;

public class AuthorDAO {
	public List<Author> getAuthorAll(){
		List<Author> list = new ArrayList<>();
	
		String sql = "SELECT `author`.`id`, `author`.`authorname`, `author`.`Email`, `author`.`Phone` "
		           + "FROM `qlsv`.`author` "
		           + "WHERE 1 = 1";
		try (Connection connection = DBContext.getConnection();
        		PreparedStatement ps = connection.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			int id;
			String authorname,email,phone;
			while(rs.next()) {
				id = rs.getInt("id");
				authorname = rs.getString("authorname");
				email = rs.getString("email");
				phone = rs.getString("phone");
				Author c = new Author(id,authorname,email,phone);
				list.add(c);
				
				} 
			}catch(SQLException e) {
				e.printStackTrace();
		}
			return list;
	}
	public Author getAuthorById(int id) {
		String sql = "SELECT * FROM `author` WHERE `id` = ?";
		try (Connection connection = DBContext.getConnection();
	    		PreparedStatement ps = connection.prepareStatement(sql)){
			ps.setInt(1, id);
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				String authorname  = rs.getString("authorname");
				
				Author c = new Author(id, authorname,email,phone);
				return c;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public void insert (Author c) {
		String sql = "insert into `author`(`authorname`,`email`,`phone`)values \r\n"
				+"(?,?,?)";
		try  (Connection connection = DBContext.getConnection();
	    		PreparedStatement ps = connection.prepareStatement(sql)){
		
			ps.setString(1, c.getAuthorname());
			ps.setString(2, c.getEmail());
			ps.setString(3, c.getPhone());
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void update (Author c) {
		String sql = "update `author`\r\n"
				+ "set `authorname`=?,`email`= ?,`phone`=? WHERE `id`=?";
				
		try  (Connection connection = DBContext.getConnection();
	    		PreparedStatement ps = connection.prepareStatement(sql)){
			ps.setString(1, c.getAuthorname());
			ps.setString(2, c.getEmail());
			ps.setString(3, c.getPhone());
	        ps.setInt(4, c.getId());
			ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	
	}
	public void delete (int id) {
		String sql = "DELETE FROM `author` WHERE `id`= ?";
		try  (Connection connection = DBContext.getConnection();
	    		PreparedStatement ps = connection.prepareStatement(sql)){
			ps.setInt(1, id);
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
