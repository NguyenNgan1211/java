package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.user;

import java.io.IOException;

import org.apache.catalina.User;

import dal.PasswordUtils;
import dal.RegisterDAO;
import dal.UserDAO;
import dal.loginDAO;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
//		 String username = request.getParameter("username");
//	        String password = request.getParameter("password");
//	        String phone = request.getParameter("phone");
//	        String address = request.getParameter("address");
//	        String role = request.getParameter("role");
//	        String passwordmd5 = PasswordUtils.hashPassword(password);
//	        RegisterDAO dao = new RegisterDAO();
//	       boolean u = dao.register(username,passwordmd5,phone,address,role);
//	        if(!u) {
//				request.setAttribute("error", "Thông tin đăng ký sai");
//				request.getRequestDispatcher("login").forward(request, response);
//
//}else {
//	HttpSession session = request.getSession();
//	session.setAttribute("user", u);
//	response.sendRedirect("login");
//}
//	}
		UserDAO cd = new UserDAO();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String role = request.getParameter("role");
	
		cd.insert(username, password, phone, address, role);
		System.out.println("da them moi " );
		request.getRequestDispatcher("/login").forward(request, response);
}
}
