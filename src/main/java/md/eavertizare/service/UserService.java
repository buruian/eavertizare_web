package md.eavertizare.service;

import md.eavertizare.model.User;

public interface UserService {

	void save(User user);

	void update(User user);

	User findById(int id);

	User findByName(String name);
}
