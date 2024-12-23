package dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Comments;
import model.News;
import model.user;

public class CommentDAO extends DBContext {
	public List<Comments> getCommentAll(){
		List<Comments> list = new ArrayList<>();
	CommentDAO cd = new CommentDAO();
		String sql = "SELECT `comments`.`cmtid`, `comments`.`userid`, `comments`.`newid`, `comments`.`content`, `comments`.`status`, `comments`.`created_at` "
	            + "FROM `qlsv`.`comments` "
	            + "WHERE 1 = 1";

		
		try (Connection connection = DBContext.getConnection();
        		PreparedStatement ps = connection.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();
            String content,status;
            Date created_at;
            int cmtid,userid,newid;
            while(rs.next()) {
            	cmtid = rs.getInt("cmtid");
            	userid = rs.getInt("userid");
            	newid = rs.getInt("newid");
            	content = rs.getString("content");
            	status = rs.getString("status");
            	created_at = rs.getDate("created_at");
            	UserDAO userDAO = new UserDAO();
            	newsDAO newsDAO = new newsDAO();
            	user user = userDAO.getUserById(userid);  // Giả sử có phương thức này
            	News news = newsDAO.getNewsById(newid); 
            	Comments c= new Comments(cmtid,userid,newid,content,status,created_at);
            	list.add(c);
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}
		return list;
}
	public Comments getCommentById(int cmtid) {
		String sql = "SELECT * FROM `comments` WHERE `cmtid` = ?";
		try (Connection connection = DBContext.getConnection();
    		PreparedStatement ps = connection.prepareStatement(sql)){
    			ps.setInt(1, cmtid);
    			ResultSet rs = ps.executeQuery();
    			if(rs.next()) {
    				int userid = rs.getInt("userid");
    	            int newid = rs.getInt("newid");
    	            String content = rs.getString("content");
    	            String status = rs.getString("status");
    	            Date created_at = rs.getDate("created_at");
    				
    				Comments c = new Comments(cmtid,userid,newid,content,status,created_at);
    				return c;
    			}
		
    		}catch(SQLException e) {
    			e.printStackTrace();
    		}
    		return null;
		}
		public void insert(Comments c) {
			String sql = "insert into`comments`(`cmtid`,`userid`,`newid`,`content`,`status`,`created_at`)values \r\n"
					+"(?,?,?,?,?,?)";
			try  (Connection connection = DBContext.getConnection();
		    		PreparedStatement ps = connection.prepareStatement(sql)){
				ps.setInt(1, c.getCmtid());
				ps.setInt(2, c.getUserid());
				ps.setInt(3, c.getNewid());
				ps.setString(4, c.getContent());
				ps.setString(5, c.getStatus());
				ps.setDate(6, c.getCreated_at());
				ps.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		public void update (Comments c) {
			String sql = "update `comments` \r\n"
					+ "set `userid` = ?, `newid`= ?, `content`=?,`status`=?,`created_at`=?\r\n"
					+ "where cmtid=?";
			try  (Connection connection = DBContext.getConnection();
		    		PreparedStatement ps = connection.prepareStatement(sql)){
				ps.setInt(1, c.getUserid());
				ps.setInt(2, c.getNewid());
				ps.setString(3, c.getContent());
				ps.setString(4, c.getStatus());
				ps.setDate(5, c.getCreated_at());
				ps.setInt(6, c.getCmtid());
				ps.executeUpdate();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}		
		}
		public void delete(int cmtid) {
			  String sql = "DELETE FROM `comments` WHERE `cmtid` = ?";
			try  (Connection connection = DBContext.getConnection();
		    		PreparedStatement ps = connection.prepareStatement(sql)){
				ps.setInt(1, cmtid);
				ps.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

