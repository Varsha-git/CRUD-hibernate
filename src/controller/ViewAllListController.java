package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ListsDao;
import model.Lists;

// View Blog Servlet controller 
@WebServlet(urlPatterns = { "/alllists" })
public class ViewAllListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("View All ");
		System.out.println("Getting all post");
		ListsDao listDAO = new ListsDao();
		List<Lists> listslip = listDAO.selectAllBlogs();
		for (Lists list : listslip) {
			System.out.println(list.getListId());
			System.out.println(list.getListType());
			System.out.println(list.getListDescription());
		}
		request.setAttribute("listslip", listslip);
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/listView.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
