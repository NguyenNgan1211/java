
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Menu;
import model.News;

public class newsDAO {

    public List<News> getNewsAll() {
        List<News> list = new ArrayList<>();
        String sql = "SELECT * FROM news";
        
        // Use try-with-resources to manage resources
        try (Connection connection = DBContext.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int newsid = rs.getInt("newsid");
                String newstitle = rs.getString("newstitle");
                String newscontent = rs.getString("newscontent");
                int authorid = rs.getInt("authorid");
                int menuid = rs.getInt("menuid");
                String image = rs.getString("image");
                News m = new News(newsid, newstitle, newscontent,authorid,menuid,image);
                list.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public News  getNewsById(int newsid) {
    	String sql = "select * from `news`"+
    "where `newsid` = ?";
    	try {Connection connection = DBContext.getConnection();
    		PreparedStatement ps = connection.prepareStatement(sql);
    		ps.setInt(1,newsid);
    		ResultSet rs = ps.executeQuery();
    		if(rs.next()) {
    			String newstitle, newscontent, image;
    			int authorid, menuid;
    			newstitle = rs.getString("newstitle");
    			newscontent = rs.getString("newscontent");
    			 image = rs.getString("image");
    			 authorid = rs.getInt("authorid");
    			 menuid = rs.getInt("menuid");
    			News m = new News(newsid,newstitle,newscontent,authorid,menuid,image);
    			return m; 
    		}
    		
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return null;
    }
    public void insert(String newstitle,String newscontent,int authorid, int menuid, String image) {
    	String sql ="INSERT INTO `news`( `newstitle`, `newscontent`,`authorid`,`menuid`,`image`) VALUES (?,?,?,?,?)";
    	try {Connection connection = DBContext.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1,newstitle);
		ps.setString(2,newscontent);
		ps.setInt(3, authorid);
		ps.setInt(4, menuid);
		ps.setString(5,image);

		ps.executeUpdate();
		

    		
    	}catch(SQLException e) {
    		e.printStackTrace();

    	}
    }
    
    public void update(News m) {
    	String sql ="update  `news`  \r\n"+
    		    "set `newstitle` = ?, `newscontent` = ? ,`authorid` =? , `menuid`=?,`image`=? \r\n"
    			+"where newsid = ?;";
    		    	try {Connection connection = DBContext.getConnection();
    				PreparedStatement ps = connection.prepareStatement(sql);
    				ps.setString(1,m.getNewstitle());
    				ps.setString(2,m.getNewscontent());
    				ps.setInt(3,m.getAuthorid());
    				ps.setInt(4,m.getMenuid());
    				ps.setString(5,m.getImage());
    				ps.setInt(6,m.getNewsid());

    				ps.executeUpdate();
    				
    		    	}catch(SQLException e) {
    		    		e.printStackTrace();

    		    	}
    }
    public void delete(int newsid) {
    	String  sql = "delete from `news`\r\n"
    			+"where `newsid`=?;";
    	try {
    		Connection connection = DBContext.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1,newsid);
			ps.executeUpdate();
    	}catch(SQLException e) {
    		e.printStackTrace();

    	}
    }
    public News getNewsByName(String newstitle) {
        String sql = "SELECT * FROM News WHERE newstitle = ?";
        try (Connection connection = DBContext.getConnection();
        		PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, newstitle);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new News(rs.getInt("newsid"), rs.getString("newstitle"), rs.getString("newscontent"),rs.getInt("authorid"),rs.getInt("menuid"),rs.getString("image"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<News> searchByNewstitle(String txtSearch) {
        List<News> list = new ArrayList<>();
        String sql = "SELECT * FROM news WHERE newstitle LIKE ?";
        try (Connection connection = DBContext.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, "%" + txtSearch + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new News(rs.getInt(1),
                                  rs.getString(2),
                                  rs.getString(3),
                                  rs.getInt(4),
                                  rs.getInt(5),
                                  rs.getString(6)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
    	newsDAO dao = new newsDAO();
		List<News> cate = dao.getNewsAll();
		for (News news : cate) {
			System.out.println(news);
		}

	}
    
}