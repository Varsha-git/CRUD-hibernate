package dao;

import java.sql.SQLException;
import java.util.List;

import model.Lists;

public interface ListsDaoInterface {

	void insertBlog(Lists list) throws SQLException;

	Lists selectBlog(int listid);

	List<Lists> selectAllBlogs();

	void deleteBlog(int id) throws SQLException;

	void updateBlog(Lists list) throws SQLException, Exception;

}
