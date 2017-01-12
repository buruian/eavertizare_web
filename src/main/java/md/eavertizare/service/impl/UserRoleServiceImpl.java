package md.eavertizare.service.impl;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import md.eavertizare.dao.UserRoleDao;
import md.eavertizare.model.User;
import md.eavertizare.model.UserRole;
import md.eavertizare.service.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService{

	private UserRoleDao userRoleDao;

	public void setUserRoleDao(UserRoleDao userRoleDao) {
		this.userRoleDao = userRoleDao;
	}
	
	
	@Override
	@Transactional
	public void save(User user) {
		userRoleDao.save(user);
		
	}

	@Override
	@Transactional
	public void update(User user, String name) {
		userRoleDao.update(user, name);
		
	}

	@Override
	@Transactional
	public UserRole findById(int id) {
		return userRoleDao.findById(id);
	}

	@Override
	@Transactional
	public UserRole findByName(String username) {
		return userRoleDao.findByName(username);
	}

}
