package nl.hu.curcon.dao.impl;

import org.springframework.stereotype.Repository;

import nl.hu.curcon.dao.UserDao;
import nl.hu.curcon.domain.User;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {
	
	@Override
	public User findRoleForUsernameAndPassword(String username, String password) {   
		System.out.println("USERDAOIMPL +"+username);
		String query = "SELECT usr FROM User as usr WHERE usr.username = '"+username+"' AND usr.password = '"+password+"'";          
		return (User) this.em.createQuery(query).getSingleResult();  
	}
}
