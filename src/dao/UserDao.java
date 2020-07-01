package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.User;
import utility.HibernateConnectionManager;

public class UserDao implements UserDaoInterface {

	private SessionFactory sessionFactory = HibernateConnectionManager.getSessionFactory();

	public boolean loginUser(User user) {

		Session session = this.sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery(
					"from User where email='" + user.getEmail() + "'" + "and password ='" + user.getPassword() + "'");
			user = (User) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return true;
	}

	@Override
	public int signUp(User user) {

		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		if (session.save(user) != null) {
			transaction.commit();
			session.close();
			return 1;
		} else {
			return 0;
		}

	}

}
