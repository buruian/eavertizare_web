package md.eavertizare.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import md.eavertizare.dao.UserDao;
import md.eavertizare.model.User;
import md.eavertizare.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	@Transactional
	public void save(User user) {
		userDao.save(user);

	}

	@Override
	@Transactional
	public void update(User user) {
		userDao.update(user);

	}

	@Override
	@Transactional
	public User findById(int id) {
		return userDao.findById(id);
	}

	@Override
	@Transactional
	public User findByName(String name) {
		return userDao.findByName(name);
	}

}
