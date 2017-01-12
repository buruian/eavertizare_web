package md.eavertizare.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import md.eavertizare.dao.CompanyDao;
import md.eavertizare.model.Company;
import md.eavertizare.model.User;
import md.eavertizare.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	private CompanyDao companyDao;

	public void setCompanyDao(CompanyDao companyDao) {
		this.companyDao = companyDao;
	}

	@Override
	@Transactional
	public void save(Company company) {
		companyDao.save(company);

	}

	@Override
	@Transactional
	public void update(Company company) {
		companyDao.update(company);

	}

	@Override
	@Transactional
	public List<Company> findAll() {
		return companyDao.findAll();
	}

	@Override
	@Transactional
	public Company findById(int id) {
		return companyDao.findById(id);
	}

	@Override
	@Transactional
	public Company findByUser(User user) {
		return companyDao.findByUser(user);
	}

	@Override
	@Transactional
	public Company findByCompanyName(String name) {
		return companyDao.findByCompanyName(name);
	}

}
