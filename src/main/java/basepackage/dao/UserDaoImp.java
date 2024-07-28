package basepackage.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import basepackage.model.User;

public class UserDaoImp  implements UserDao {


    @Autowired
    private SessionFactory sessionFactory; // Inject SessionFactor
	
	@Override
	public User findByEmail(String email) {
Session session=sessionFactory.openSession();
		return null;
	}

	@Override
	public User findByPhoneNumber(String phoneNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		
	}

}
