package nl.hu.curcon.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.hu.curcon.dao.UserDao;
import nl.hu.curcon.domain.Function;
import nl.hu.curcon.domain.Module;
import nl.hu.curcon.domain.User;
import nl.hu.curcon.dto.FunctionDto;
import nl.hu.curcon.dto.ModuleDto;
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

	//@Transactional
	@Override
	public List<UserDto> findAll() {
		List<UserDto> dtos = new ArrayList<UserDto>();
        List<User> docenten = userDao.findAll();
        for (User d: docenten){
            dtos.add(Domain2DtoMapper.map(d));
        }
        return dtos;}
}