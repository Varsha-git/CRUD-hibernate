package dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.Lists;
import utility.HibernateConnectionManager;

public class ListsDao implements ListsDaoInterface {
	private SessionFactory sessionFactory = HibernateConnectionManager.getSessionFactory();

	@Override
	public void insertBlog(Lists list) throws SQLException {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(list);
		transaction.commit();
		session.close();
	}

	@Override
	public Lists selectBlog(int listid) {
		Session session = this.sessionFactory.openSession();
		Lists list = session.get(Lists.class, listid);
		session.close();
		return list;

	}

	@Override
	public List<Lists> selectAllBlogs() {
		Session session = this.sessionFactory.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Lists> query = builder.createQuery(Lists.class);
		Root<Lists> root = query.from(Lists.class);
		query.select(root);
		Query<Lists> q = session.createQuery(query);
		// Criteria cr = session.createCriteria(Blog.class);
		List<Lists> listBlog = q.getResultList();
		return listBlog;
	}

	@Override
	public void deleteBlog(int id) throws SQLException {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Lists list = session.get(Lists.class, id);
		session.delete(list);
		transaction.commit();
		session.close();
	}

	@Override
	public void updateBlog(Lists list) throws SQLException, Exception {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(list);
		transaction.commit();
		session.close();
	}
}
