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
@WebServlet("/UpdatecommentServlet")
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
		String userid = request.getParameter("userid");
		String newid = request.getParameter("newid");
		String content = request.getParameter("content");
		String status = request.getParameter("status");
		Date created_at = Date.valueOf("created_at"); 
		
		int cmtid;
		
		cmtid = Integer.parseInt(cmtid_S);
		 
		
		Comments c = new Comments(cmtid,userid,newid,content,status,created_at);
		System.out.println("Received userid: " + cmtid);
		cd.update(c);
		response.sendRedirect(request.getContextPath()+"/admin/comment");
	}

}
