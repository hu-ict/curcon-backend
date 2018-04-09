package nl.hu.curcon.dao.impl;

import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import nl.hu.curcon.dao.UserDao;
import nl.hu.curcon.domain.User;

public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {
	
	@Override
	public User findRoleForUsernameAndPassword(String username, String password, String role) {
		String query = "SELECT " + role + " FROM user WHERE username = " + username + " AND password = " + password;
		return (User) this.em.createQuery(query).getSingleResult();
	}
}
