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
 * Servlet implementation class AdduserServlet
 */
@WebServlet("/AdduserServlet")
public class AdduserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdduserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDAO cd = new UserDAO();
		String userid_S = request.getParameter("id");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String role = request.getParameter("role");
		int userid;
		userid = Integer.parseInt(userid_S);
		user c = cd.getUserById(userid);
		if(c == null) {
			c = new user(userid,username,password,phone,address,role);
			cd.insert(c);
			request.getRequestDispatcher("UserServlet").forward(request, response);
			
		}else {
			String error = userid + " Đã tồn tại,xin mời chọn ID khác";
			request.setAttribute("error", error);
			request.getRequestDispatcher("admin/adduser.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
