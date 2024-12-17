package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		HttpSession session = request.getSession();
//		session.invalidate();
//		response.sendRedirect("login.jsp");
//		response.setContentType("text/html");  
//		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		 if (session != null) {
	            session.invalidate(); // Hủy session
	        }
		 Cookie cookie = new Cookie("JSESSIONID", null);
		 cookie.setMaxAge(0); // Đặt thời gian sống của cookie bằng 0 để xóa nó
		 cookie.setPath("/");  // Đảm bảo cookie được xóa ở phạm vi toàn bộ ứng dụng
		 response.addCookie(cookie);
		 response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		 response.setHeader("Pragma", "no-cache");
		 response.setDateHeader("Expires", 0);
		 response.sendRedirect("login.jsp"); // Chuyển hướng về trang đăng nhập
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
