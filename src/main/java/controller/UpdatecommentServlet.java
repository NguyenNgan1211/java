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
 * Servlet implementation class UpdatecommentServlet
 */
@WebServlet("/admin/UpdatecommentServlet")
public class UpdatecommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatecommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cmtid_S = request.getParameter("cmtid");
		int cmtid = Integer.parseInt(cmtid_S);
		CommentDAO cd = new CommentDAO();
		Comments  c = cd.getCommentById(cmtid);
		request.setAttribute("Comments", c);
		request.getRequestDispatcher("/admin/UpdateComment.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CommentDAO cd = new CommentDAO();
		String cmtid_S = request.getParameter("cmtid");
		String userid_S = request.getParameter("userid");
		String newid_S= request.getParameter("newid");
		String content = request.getParameter("content");
		String status = request.getParameter("status");
		String createdAtStr = request.getParameter("created_at");
		
		int cmtid;
		int userid;
		int newid;
		cmtid = Integer.parseInt(cmtid_S);

		 userid= Integer.parseInt(userid_S);
		 newid = Integer.parseInt(newid_S);
		 if (createdAtStr == null || !createdAtStr.matches("\\d{4}-\\d{2}-\\d{2}")) {
		        throw new IllegalArgumentException("Invalid date format. Expected YYYY-MM-DD.");
		    }
		    Date created_at = Date.valueOf(createdAtStr);
		Comments c = new Comments(cmtid,userid,newid,content,status,created_at);

		 
		
//		Comments c = new Comments(cmtid,userid,newid,content,status,created_at);
		System.out.println("Received userid: " + cmtid);
		cd.update(c);
	

		response.sendRedirect(request.getContextPath()+"/comment");
	}

}
