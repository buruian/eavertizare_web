package md.eavertizare.service;

import java.util.List;

import md.eavertizare.model.Company;
import md.eavertizare.model.User;

public interface CompanyService {

	void save(Company company);

	void update(Company company);

	List<Company> findAll();

	Company findById(int id);

	Company findByUser(User user);

	Company findByCompanyName(String name);
}
