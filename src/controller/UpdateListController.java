package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ListsDao;
import model.Lists;

@WebServlet(urlPatterns = { "/update" })
public class UpdateListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Entering Update Blog");
		System.out.println("Entering do post");
		int listId = Integer.parseInt(request.getParameter("listid"));
		System.out.println(listId);
		String listType = request.getParameter("type");
		String listDescription = request.getParameter("message");
		System.out.println(listType);
		Lists list = new Lists();
		list.setListId(listId);
		list.setListType(listType);
		list.setListDescription(listDescription);

		ListsDao listDao = new ListsDao();
		try {
			listDao.updateBlog(list);
		} catch (Exception e) {

			e.printStackTrace();
		}
		response.sendRedirect("alllists");
	}

}
