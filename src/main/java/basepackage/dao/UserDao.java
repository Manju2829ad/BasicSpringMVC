package basepackage.dao;

import basepackage.model.User;

public interface UserDao {

	User findByEmail(String email);
	User findByPhoneNumber(String phoneNumber);
	void save(User user);
	
	
}
