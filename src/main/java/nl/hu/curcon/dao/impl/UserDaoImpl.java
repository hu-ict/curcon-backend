package nl.hu.curcon.dao.impl;

import org.springframework.stereotype.Repository;

import nl.hu.curcon.dao.RoleDao;
import nl.hu.curcon.dao.UserDao;
import nl.hu.curcon.domain.User;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {
	
	@Override
	public User find(String username) {   
		String query = "SELECT usr FROM User as usr WHERE usr.username = '"+username+"'";          
		User result= (User) this.em.createQuery(query).getSingleResult();
		return result;
	}
}
