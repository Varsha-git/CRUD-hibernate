
package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ListsDao;
import model.Lists;

@WebServlet(urlPatterns = { "/new" })
public class AddNewListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static int i = 0;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Getting into Add New");
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/detailListView.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Entering do post");
		String listType = request.getParameter("type");
		String listDescription = request.getParameter("message");
		System.out.println(listType);
		Lists list = new Lists();
		list.setListType(listType);
		list.setListDescription(listDescription);

		ListsDao listDao = new ListsDao();
		try {
			listDao.insertBlog(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		response.sendRedirect("alllists");
	}
}