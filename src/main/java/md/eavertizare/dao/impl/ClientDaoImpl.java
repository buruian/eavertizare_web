package md.eavertizare.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import md.eavertizare.dao.ClientDao;
import md.eavertizare.model.Client;
import md.eavertizare.model.Company;

@Repository
public class ClientDaoImpl implements ClientDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void save(List<Client> listClients) {

		Session session = this.sessionFactory.getCurrentSession();

		for (Client client : listClients) {
			session.save(client);
		}

	}

	@Override
	public void deleteByCompanyId(int idCompany) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete Client where idCompany = :idCompany");
		query.setParameter("idCompany", idCompany);
		query.executeUpdate();

	}

	@Override
	public void updateMessage(String message, int idCompany) {

		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("update Client set message = :message where idCompany = :idCompany");
		query.setParameter("message", message);
		query.setParameter("idCompany", idCompany);

		query.executeUpdate();

	}

	@Override
	public String getMessage(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		// Get Employee with id
		Query query = session.createQuery("from Client where idCompany=:idCompany");
		query.setLong("idCompany", id);
		// List message = query.list();
		return (String) query.list().get(0);
	}

	@Override
	public List<Client> findByCompany(Company company) {
		Session session = this.sessionFactory.getCurrentSession();
		// Get Employee with id
		Query query = session.createQuery("from Client where company=:company");
		query.setParameter("company", company);
		List<Client> listClients = query.list();
		return listClients;
	}

	@Override
	public Client findById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		// Get Employee with id
		Query query = session.createQuery("from Client where id=:id");
		query.setLong("id", id);
		Client client = (Client) query.uniqueResult();
		return client;
	}

}
