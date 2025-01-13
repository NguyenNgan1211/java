package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Author;

import java.io.IOException;

import dal.AuthorDAO;
import dal.menuDAO;

/**
 * Servlet implementation class AddauthorServlet
 */
@WebServlet("/admin/AddauthorServlet")
public class AddauthorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddauthorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
	    String authorname = request.getParameter("authorname");
	    String email = request.getParameter("email");
	    String phone = request.getParameter("phone");
	   
	    Author author = new Author(0, authorname, email, phone);
	    AuthorDAO cd = new AuthorDAO();
	    cd.insert(author);  
	    request.getRequestDispatcher("/admin/author").forward(request, response);
	 
	}


}
