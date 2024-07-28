package basepackage.service;

import org.springframework.beans.factory.annotation.Autowired;

import basepackage.dao.UserDao;
import basepackage.model.User;



public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserDao userDao;
	
	
	@Override
	public User  findByEmail(String email) {
		
		return userDao.findByEmail(email);
	}


	@Override
	public User findByPhoneNumber(String phoneNumber) {
		return userDao.findByPhoneNumber(phoneNumber);
		
	}


	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		userDao.save(user);
	}
	
	
	
}
