package md.eavertizare.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import md.eavertizare.dao.UserRoleDao;
import md.eavertizare.model.User;
import md.eavertizare.model.UserRole;

@Repository
public class UserRoleDaoImpl implements UserRoleDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public UserRole findById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		// Get Employee with id
		Query query = session.createQuery("from UserRole where id=:id");
		query.setLong("id", id);
		UserRole userRole = (UserRole) query.uniqueResult();
		return userRole;
	}

	@Override
	public UserRole findByName(String username) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from UserRole where username=:username");
		query.setParameter("username", username);
		UserRole userRole = (UserRole) query.uniqueResult();
		return userRole;
	}

	@Override
	public void save(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		UserRole userRole = new UserRole();
		userRole.setUsername(user.getUsername());
		userRole.setRole("ROLE_USER");

		session.save(userRole);

	}

	@Override
	public void update(User user, String name) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("update UserRole set  username = :username1 where username = :username2");

		query.setParameter("username1", name);

		query.setParameter("username2", user.getUsername());

		query.executeUpdate();

	}

}
