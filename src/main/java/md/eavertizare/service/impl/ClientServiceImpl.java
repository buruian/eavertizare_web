package md.eavertizare.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import md.eavertizare.dao.ClientDao;
import md.eavertizare.model.Client;
import md.eavertizare.model.Company;
import md.eavertizare.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	private ClientDao clientDao;

	public void setClientDao(ClientDao clientDao) {
		this.clientDao = clientDao;
	}

	@Override
	@Transactional
	public void save(List<Client> listClients) {
		this.clientDao.save(listClients);

	}

	@Override
	@Transactional
	public void updateMessage(String message, int idCompany) {
		this.clientDao.updateMessage(message, idCompany);

	}

	@Override
	@Transactional
	public Client findById(int id) {
		return this.clientDao.findById(id);
	}

	@Override
	@Transactional
	public void deleteByCompanyId(int idCompany) {
		this.clientDao.deleteByCompanyId(idCompany);

	}

	@Override
	@Transactional
	public String getMessage(int id) {
		return this.clientDao.getMessage(id);
	}

	@Override
	@Transactional
	public List<Client> findByCompany(Company company) {
		return this.clientDao.findByCompany(company);
	}

}
