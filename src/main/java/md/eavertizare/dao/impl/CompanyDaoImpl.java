package md.eavertizare.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import md.eavertizare.dao.CompanyDao;
import md.eavertizare.model.Company;
import md.eavertizare.model.User;

@Repository
public class CompanyDaoImpl implements CompanyDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void save(Company company) {

		Session session = this.sessionFactory.getCurrentSession();
		session.save(company);

	}

	@Override
	public Company findById(int id) {

		Session session = this.sessionFactory.getCurrentSession();
		// Get Employee with id
		Query query = session.createQuery("from Company where id=:id");
		query.setLong("id", id);
		Company company = (Company) query.uniqueResult();
		return company;

	}

	@Override
	public Company findByUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		// Get Employee with id
		Query query = session.createQuery("from Company where user=:user");
		query.setParameter("user", user);
		Company company = (Company) query.uniqueResult();
		return company;

	}

	@Override
	public void update(Company company) {

		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("update Company set name = :name, address = :address,"
				+ "description = :description where idUser = :idUser");
		query.setParameter("name", company.getName());
		query.setParameter("address", company.getAddress());
		query.setParameter("description", company.getDescription());
		query.setParameter("idUser", company.getUser().getId());
		query.executeUpdate();
	}

	@Override
	public List<Company> findAll() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Company> allCompany = session.createQuery("from Company").list();

		return allCompany;
	}

	@Override
	public Company findByCompanyName(String name) {
		Session session = this.sessionFactory.getCurrentSession();
		// Get Employee with id
		Query query = session.createQuery("from Company where name=:name");
		query.setParameter("name", name);
		Company company = (Company) query.uniqueResult();
		return company;

	}

}
