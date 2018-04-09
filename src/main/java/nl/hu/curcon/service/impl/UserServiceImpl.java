package nl.hu.curcon.service.impl;

import nl.hu.curcon.dao.UserDao;
import nl.hu.curcon.domain.User;
import nl.hu.curcon.dto.UserDto;
import nl.hu.curcon.dtomapper.Domain2DtoMapper;
import nl.hu.curcon.service.UserService;

public class UserServiceImpl extends GenericService implements UserService {
	private UserDao userDao; 
	
	@Override
	public UserDto find(String username, String password) {
		User user = userDao.findRoleForUsernameAndPassword(username, password);
		return Domain2DtoMapper.map(user);
	}
}
