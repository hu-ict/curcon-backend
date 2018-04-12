package nl.hu.curcon.dao.impl;

import org.springframework.stereotype.Repository;

import nl.hu.curcon.dao.UserDao;
import nl.hu.curcon.domain.User;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {
	
	@Override
	public User findRoleForUsernameAndPassword(String username, String password) {   
		String query = "SELECT role FROM useraccount WHERE username = ? AND password = ?";          
		return (User) this.em.createQuery(query).getSingleResult();  
	}
}
