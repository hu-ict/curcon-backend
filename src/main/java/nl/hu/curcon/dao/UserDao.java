package nl.hu.curcon.dao;

import nl.hu.curcon.domain.User;
//import nl.hu.curcon.dao.BaseDao;

public interface UserDao {
	User findRoleForUsernameAndPassword(String username, String password);
}
