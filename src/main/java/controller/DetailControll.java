package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Detail;

import java.io.IOException;

import dal.DetailDAO;

/**
 * Servlet implementation class DetailControll
 */
@WebServlet("/DetailControll")
public class DetailControll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailControll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id_s = request.getParameter("newsid");
		int id = Integer.parseInt(id_s);
		DetailDAO gd = new DetailDAO();
		Detail g = gd.getdetailById(id);
		if (g == null) {
		    response.sendError(HttpServletResponse.SC_NOT_FOUND, "Bài viết không tồn tại.");
		    return;
		}
		request.setAttribute("Detail", g); 
		request.getRequestDispatcher("/Detail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
//			String id_s = request.getParameter("newsid");
//			int newid = Integer.parseInt(id_s);
//			DetailDAO gd = new DetailDAO();
//			Detail g = gd.getdetailById(newid);
//			if (g == null) {
//			    response.sendError(HttpServletResponse.SC_NOT_FOUND, "Bài viết không tồn tại.");
//			    return;
//			}
//			request.setAttribute("Detail", g);
//			request.getRequestDispatcher("/Detail.jsp").forward(request, response);
//		}


