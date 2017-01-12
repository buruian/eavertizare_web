package md.eavertizare.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import md.eavertizare.dao.UserDao;
import md.eavertizare.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void save(User user) {

		Session session = this.sessionFactory.getCurrentSession();
		user.setEnable(true);

		session.save(user);

	}

	@Override
	public User findById(int id) {

		Session session = this.sessionFactory.getCurrentSession();
		// Get Employee with id
		Query query = session.createQuery("from User where id=:id");
		query.setLong("id", id);
		User user = (User) query.uniqueResult();
		return user;

	}

	@Override
	public User findByName(String name) {

		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User where username=:name");
		query.setParameter("name", name);
		User user = (User) query.uniqueResult();
		return user;

	}

	@Override
	public void update(User user) {

		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("update User set firstName = :firstName, lastName = :lastName,"
				+ "email = :email, password = :password where id = :id");
		query.setParameter("firstName", user.getFirstName());
		query.setParameter("lastName", user.getLastName());
		query.setParameter("email", user.getEmail());
		query.setParameter("password", user.getPassword());
		query.setParameter("id", user.getId());

		query.executeUpdate();
	}

}
