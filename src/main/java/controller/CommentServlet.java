package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Comments;
import model.News;
import model.user;

import java.io.IOException;
import java.util.List;

import dal.CommentDAO;
import dal.UserDAO;
import dal.newsDAO;

/**
 * Servlet implementation class CommentServlet
 */
@WebServlet("/CommentServlet")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDAO a= new UserDAO();
		newsDAO b = new newsDAO();
		CommentDAO cd = new CommentDAO();
		List<Comments> list = cd.getCommentAll();
		List<user> userlist = a.getUserAll();
		List<News> newlist  = b.getNewsAll();
		request.setAttribute("data", list);
		request.setAttribute("userlist", userlist);
		request.setAttribute("newlist", newlist);
		request.getRequestDispatcher("admin/commentlist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
