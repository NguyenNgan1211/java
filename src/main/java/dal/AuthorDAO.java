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
	
		String sql = "SELECT `author`.`authorid`, `author`.`authorname`, `author`.`Email`, `author`.`Phone` "
		           + "FROM `qlsv`.`author` "
		           + "WHERE 1 ";
		try (Connection connection = DBContext.getConnection();
        		PreparedStatement ps = connection.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			int id;
			String authorname,email,phone;
			while(rs.next()) {
				id = rs.getInt("authorid");
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
	public Author getAuthorById(int authorid) {
		String sql = "SELECT * FROM `author` WHERE `authorid` = ?";
		try (Connection connection = DBContext.getConnection();
	    		PreparedStatement ps = connection.prepareStatement(sql)){
			ps.setInt(1, authorid);
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				String authorname  = rs.getString("authorname");
				
				Author c = new Author(authorid, authorname,email,phone);
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
				+ "set `authorname`=?,`email`= ?,`phone`=? WHERE `authorid`=?";
				
		try  (Connection connection = DBContext.getConnection();
	    		PreparedStatement ps = connection.prepareStatement(sql)){
			ps.setString(1, c.getAuthorname());
			ps.setString(2, c.getEmail());
			ps.setString(3, c.getPhone());
	        ps.setInt(4, c.getAuthorid());
			ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	
	}
	public void delete (int authorid) {
		String sql = "DELETE FROM `author` WHERE `authorid`= ?";
		try  (Connection connection = DBContext.getConnection();
	    		PreparedStatement ps = connection.prepareStatement(sql)){
			ps.setInt(1, authorid);
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		AuthorDAO dao = new AuthorDAO();
		Author a = dao.getAuthorById(0);
		
			System.out.println(a);

		
	}
}
