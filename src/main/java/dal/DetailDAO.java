package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Detail;

public class DetailDAO extends DBContext {

   
    public List<Detail> getdetailAll() {
        List<Detail> list = new ArrayList<>();
        String sql = "SELECT * FROM news";

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

                Detail m = new Detail(newsid, newstitle, newscontent, authorid, menuid, image);
                list.add(m);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

   
    public Detail getdetailById(int newsid) {
        String sql = "SELECT * FROM news WHERE newsid = ?";
        try (Connection connection = DBContext.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, newsid);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String newstitle = rs.getString("newstitle");
                String newscontent = rs.getString("newscontent");
                String image = rs.getString("image");
                int authorid = rs.getInt("authorid");
                int menuid = rs.getInt("menuid");

                return new Detail(newsid, newstitle, newscontent, authorid, menuid, image);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
  

}
