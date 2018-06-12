package nl.hu.curcon.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.hu.curcon.dao.UserDao;
import nl.hu.curcon.domain.Function;
import nl.hu.curcon.domain.Module;
import nl.hu.curcon.domain.Organisatie;
import nl.hu.curcon.domain.Role;
import nl.hu.curcon.domain.User;
import nl.hu.curcon.dto.FunctionDto;
import nl.hu.curcon.dto.ModuleDto;
import nl.hu.curcon.dto.UserDto;
import nl.hu.curcon.dto.post.ModulePostDto;
import nl.hu.curcon.dto.post.OrganisatiePostDto;
import nl.hu.curcon.dto.post.RolePutDto;
import nl.hu.curcon.dto.post.UserPutDto;
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

	@Transactional
	@Override
	public List<FunctionDto> findFunctionsByUsername(String username) {
		// TODO testen of dit werkt.
		List<FunctionDto> functions = new ArrayList<>();
		List<Module> modules = userDao.find(username).getRole().getModules();
		for (Module m : modules) {
			for (Function f : m.getFunctions()) {
				// if (!functions.contains(f)) {
				functions.add(Domain2DtoMapper.map(f));
				// }
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
	public String create(UserDto userDto) {
		User user = dto2DomainMapper.map(userDto);
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
	public boolean update(String username, UserPutDto userDto) {
		User user = userDao.find(username);
		if (user == null) { return false; }
		user.setPassword(userDto.getPassword());
		user = userDao.update(user);
		return true;
	}
	@Override
	public int updateRoleByUser(String username, RolePutDto dto) {
		User user = userDao.find(username);
		if (user == null) return 0;
		Role role = dto2DomainMapper.map(dto);
		user.setRole(role);
		userDao.save(user);
		return role.getId();
	}
}