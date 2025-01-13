package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Author;

import java.io.IOException;

import dal.AuthorDAO;

/**
 * Servlet implementation class UpdateauthorServlet
 */
@WebServlet("/admin/UpdateauthorServlet")
public class UpdateauthorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateauthorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id_S = request.getParameter("authorid");
		int id = Integer.parseInt(id_S);
		AuthorDAO cd = new AuthorDAO();
		Author c = cd.getAuthorById(id);
		request.setAttribute("author", c);
		request.getRequestDispatcher("/admin/updateauthor.jsp").forward(request, response);
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AuthorDAO cd = new AuthorDAO();
		String authorname = request.getParameter("authorname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String id_S = request.getParameter("authorid");
		int id = Integer.parseInt(id_S);
		Author c = new Author(id,authorname,email,phone);
		cd.update(c);
		response.sendRedirect("author");
	}

}
