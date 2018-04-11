package nl.hu.curcon.dao;

import nl.hu.curcon.domain.User;
@Repository
public interface UserDao {
	User findRoleForUsernameAndPassword(String username, String password);
}
