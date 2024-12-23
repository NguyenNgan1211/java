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
 * Servlet implementation class AddcommentServlet
 */
@WebServlet("/admin/AddcommentServlet")
public class AddcommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddcommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CommentDAO cd = new CommentDAO();
		String cmtid_S = request.getParameter("cmtid");
		String useridS = request.getParameter("userid");
		String newidS = request.getParameter("newid");
		String content = request.getParameter("content");
		String status = request.getParameter("status");
		String created_atS = request.getParameter("created_at");
		int cmtid;
		int userid;
		int newid;
		Date created_at;
		cmtid = Integer.parseInt(cmtid_S);
		userid = Integer.parseInt(useridS);
		newid = Integer.parseInt(newidS);
		created_at =  Date.valueOf(created_atS);
		Comments c= cd.getCommentById(cmtid);
		if(c == null) {
			c = new Comments(cmtid,userid,newid,content,status,created_at,null,null);
			cd.insert(c);
			request.getRequestDispatcher("/comment").forward(request, response);
		}else {
			String erorr = cmtid +" Đã tồn tại, xin mời chọn ID khác";
			request.setAttribute("erorr", erorr);
			request.getRequestDispatcher("/comment").forward(request, response);
		}
	}

}
