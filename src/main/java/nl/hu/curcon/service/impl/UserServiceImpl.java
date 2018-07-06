package nl.hu.curcon.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.hu.curcon.dao.RoleDao;
import nl.hu.curcon.dao.UserDao;
import nl.hu.curcon.domain.Function;
import nl.hu.curcon.domain.Module;
import nl.hu.curcon.domain.Role;
import nl.hu.curcon.domain.User;
import nl.hu.curcon.dto.FunctionDto;
import nl.hu.curcon.dto.RoleDto;
import nl.hu.curcon.dto.UserDto;
import nl.hu.curcon.dto.post.UserPostDto;
import nl.hu.curcon.dtomapper.Domain2DtoMapper;
import nl.hu.curcon.service.UserService;

@Service
public class UserServiceImpl extends GenericService implements UserService {
	@Autowired
	private UserDao userDao;
	
	@Autowired RoleDao roleDao;

	@Override
	public UserDto find(String username) {
		User user = userDao.find(username);

		return Domain2DtoMapper.map(user);
	}

	@Transactional
	@Override
	public List<FunctionDto> findFunctionsByUsername(String username) {
		List<FunctionDto> functions = new ArrayList<>();

		if(userDao.find(username)== null || userDao.find(username).getRole()== null  ){
			System.out.println(username+"<-gebruiker staat niet in de database of heeft geen rol");
			return null;
		} 
		
		List<Module> modules = userDao.find(username).getRole().getModules();
		for (Module m : modules) {
			for (Function f : m.getFunctions()) {
				//Needs Equals in dto.FunctionDto
				if (!functions.contains(Domain2DtoMapper.map(f))) {
					functions.add(Domain2DtoMapper.map(f));
				}
			}
		}
		return functions;

	}

	// @Transactional
	@Override
	public List<UserDto> findAll() {
		List<UserDto> dtos = new ArrayList<UserDto>();
		List<User> users = userDao.findAll();
		for (User u : users) {
			dtos.add(Domain2DtoMapper.map(u));
		}
		return dtos;
	}
	@Override
	@Transactional
	public String create(UserPostDto userDto) {
		User user = dto2DomainMapper.map(userDto);
		Role role = roleDao.find(1);	//NOTE User krijgt nu roleid 1 op creatie==Publiek
		user.setRole(role);
		user = userDao.save(user);
		return user.getUsername();
	}
	
	@Override
	@Transactional
	public boolean delete(String username) {
		User user = userDao.find(username);
		if (user == null) { return false; }
		userDao.delete(username);
		return true;
	}
	@Override
	@Transactional
	public boolean updateRoleByUser(String username, int roleId) {
		User user = userDao.find(username);
		if (user == null) return false;
		Role role = roleDao.find(roleId);
		if (role == null) {
		return false;
		}
		user.setRole(role);
		userDao.save(user);
		return true;
	}

	@Override
	public List<RoleDto> findRoleByUser(String username) {
		User user = userDao.find(username);
		if (user == null)
			return null;
		List<RoleDto> roles = new ArrayList<>();
		Role role =user.getRole();
		roles.add(Domain2DtoMapper.map(role));
		
		return roles;
	}
}