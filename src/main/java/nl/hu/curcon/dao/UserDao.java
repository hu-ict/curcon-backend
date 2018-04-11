package nl.hu.curcon.dao;

import nl.hu.curcon.domain.User;

public interface UserDao {
	User findRoleForUsernameAndPassword(String username, String password);
}
