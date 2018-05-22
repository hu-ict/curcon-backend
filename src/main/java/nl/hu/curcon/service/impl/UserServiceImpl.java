package nl.hu.curcon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.hu.curcon.dao.UserDao;
import nl.hu.curcon.domain.User;
import nl.hu.curcon.dto.UserDto;
import nl.hu.curcon.dtomapper.Domain2DtoMapper;
import nl.hu.curcon.service.UserService;

@Service
public class UserServiceImpl extends GenericService implements UserService {
	@Autowired
	private UserDao userDao; 
	
	@Override
	public UserDto find(String username) {
		User user = userDao.find(username);
		return Domain2DtoMapper.map(user);
	}
}