package nl.hu.curcon.dao;
import java.util.List;

import org.springframework.stereotype.Repository;

import nl.hu.curcon.domain.Trefwoord;
import nl.hu.curcon.domain.User;
import nl.hu.curcon.dto.UserDto;
@Repository
public interface UserDao extends GenericDao<User>  {
	//Dit staat allebij in GenericDao
//	User find(String username);
//	List<User> findAll();
}