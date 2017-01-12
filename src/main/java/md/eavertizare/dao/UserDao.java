package md.eavertizare.dao;

import md.eavertizare.model.User;

public interface UserDao {

	void save(User user);
	void update(User user);

	User findById(int id);

	User findByName(String name);

}
