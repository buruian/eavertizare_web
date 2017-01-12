package md.eavertizare.service;

import md.eavertizare.model.User;
import md.eavertizare.model.UserRole;

public interface UserRoleService {

	void save(User user);

	void update(User user, String name);

	UserRole findById(int id);

	UserRole findByName(String username);
}
