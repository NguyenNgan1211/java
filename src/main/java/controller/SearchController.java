package controller;
import model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.News;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dal.menuDAO;
import dal.newsDAO;

/**
 * Servlet implementation class SearchController
 */
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		 String txtSearch = request.getParameter("search");
		    System.out.println("Search term: " + txtSearch); // Debug
		    
		    newsDAO dao = new newsDAO();
		    menuDAO dao1 = new menuDAO();
		    List<News> list = dao.searchByNewstitle(txtSearch);
		    List<Menu> listm = dao1.getMenuAll();
		    System.out.println("Search result size: " + list.size()); // Debug
		    for (News news : list) {
		        System.out.println(news.getNewstitle()); // Debug
		    }
		    
		    request.setAttribute("newss", list);
		    request.setAttribute("menus", listm);

		    request.getRequestDispatcher("Home.jsp").forward(request, response);
    	
	}

}
