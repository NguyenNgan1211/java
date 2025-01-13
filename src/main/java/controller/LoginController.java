package controller;
import dal.PasswordUtils;
import dal.loginDAO;
import model.user;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String username = request.getParameter("user");
		String password = request.getParameter("pass");
		String passwordmd5 = PasswordUtils.hashPassword(password);
		
		loginDAO dao = new loginDAO();
		user u = dao.login(username, passwordmd5);
		if(u==null) {
			request.setAttribute("error", "Thông tin đăng nhập sai");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("user", u);
			response.sendRedirect("home");
		}
		

	}

}
