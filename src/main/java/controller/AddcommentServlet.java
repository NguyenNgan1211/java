package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Comments;

import java.io.IOException;
import java.sql.Date;

import dal.CommentDAO;

/**
 * Servlet implementation class AddcommentServlet
 */
@WebServlet("/admin/AddcommentServlet")
public class AddcommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddcommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Tạo DAO để thao tác với bình luận
	    CommentDAO cd = new CommentDAO();

	    // Lấy tham số từ request
	    String useridS = request.getParameter("userid");
	    String newidS = request.getParameter("newid");
	    String content = request.getParameter("content");
	    String status = request.getParameter("status");
	    String created_atS = request.getParameter("created_at");

	    try {
	        // In ra console để kiểm tra giá trị đã lấy được
	        System.out.println("User ID: " + useridS);
	        System.out.println("News ID: " + newidS);
	        System.out.println("Content: " + content);
	        System.out.println("Status: " + status);
	        System.out.println("Created At: " + created_atS);

	        // Chuyển đổi kiểu dữ liệu
	        int userid = Integer.parseInt(useridS);
	        int newid = Integer.parseInt(newidS);
	        Date created_at = Date.valueOf(created_atS);

	        // Tạo đối tượng bình luận
	        Comments c = new Comments(userid, newid, content, status, created_at);

	        // Chèn vào cơ sở dữ liệu
	        cd.insert(c);

	        // Forward về trang comment
	        request.setAttribute("message", "Bình luận đã được thêm thành công!");
	        request.getRequestDispatcher("/comment").forward(request, response);
	    } catch (NumberFormatException e) {
	        // Xử lý nếu dữ liệu không hợp lệ
	        System.err.println("Dữ liệu không hợp lệ: " + e.getMessage());
	        request.setAttribute("error", "Dữ liệu không hợp lệ. Vui lòng kiểm tra lại!");
	        request.getRequestDispatcher("/comment").forward(request, response);
	    } catch (Exception e) {
	        // Xử lý lỗi khác
	        e.printStackTrace();
	        request.setAttribute("error", "Đã xảy ra lỗi: " + e.getMessage());
	        request.getRequestDispatcher("/comment").forward(request, response);
	    }
	}

}
