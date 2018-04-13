package nl.hu.curcon.dao;
import org.springframework.stereotype.Repository;

import nl.hu.curcon.domain.User;
@Repository
public interface UserDao extends GenericDao<User> {
	User findRoleForUsernameAndPassword(String username, String password);
}
