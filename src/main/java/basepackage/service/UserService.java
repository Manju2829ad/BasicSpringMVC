package basepackage.service;

import basepackage.model.User;

public interface UserService {

	
	User findByEmail(String email);
	
	User findByPhoneNumber(String  phoneNumber);

	void save(User user);
	
}



