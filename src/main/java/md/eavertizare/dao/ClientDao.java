package md.eavertizare.dao;

import java.util.List;

import md.eavertizare.model.Client;
import md.eavertizare.model.Company;

public interface ClientDao {

	void save(List<Client> listClients);

	void updateMessage(String message, int idCompany);
	
	Client findById(int id);

	void deleteByCompanyId(int idCompany);

	String getMessage(int id);
	
	List<Client> findByCompany(Company company);

}
