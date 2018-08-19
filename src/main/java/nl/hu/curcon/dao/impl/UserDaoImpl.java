package nl.hu.curcon.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import nl.hu.curcon.dao.RoleDao;
import nl.hu.curcon.dao.UserDao;
import nl.hu.curcon.domain.User;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {
	//Dit staat allebij in GenericDaoimpl
//	@Override
//	public User find(String username) {   
//		String query = "SELECT usr FROM User as usr WHERE usr.username = '"+username+"'";          
//		User result= (User) this.em.createQuery(query).getSingleResult();
//		return result;
//	}
//	public List<User>findAll(){
//		String query = "SELECT usr FROM User as usr WHERE usr.username = 'Martin'";          
//		User result= (User) this.em.createQuery(query).getSingleResult();
//		return result;
//	}
}
