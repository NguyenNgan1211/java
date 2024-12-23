package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.user;

import java.io.IOException;

import dal.UserDAO;

/**
 * Servlet implementation class UpdateuserSeervlet
 */
@WebServlet("/admin/UpdateuserServlet")
public class UpdateuserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateuserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userid_S = request.getParameter("userid");
		int userid = Integer.parseInt(userid_S);
		UserDAO cd = new UserDAO();
		user c = cd.getUserById(userid);
		request.setAttribute("user", c);
		request.getRequestDispatcher("/admin/updateuser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDAO cd = new UserDAO();
		String userid_S = request.getParameter("userid");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String role = request.getParameter("role");

		int userid;
		userid = Integer.parseInt(userid_S);
		user c= new user(userid, username,password,phone,address,role);
		System.out.println("Received userid: " + userid);

		cd.update(c);
		response.sendRedirect(request.getContextPath() + "/admin/user");
		
	}

}
