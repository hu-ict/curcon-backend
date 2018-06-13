package nl.hu.curcon.service;

import java.util.List;

import nl.hu.curcon.domain.Leerlijn;
import nl.hu.curcon.dto.FunctionDto;
import nl.hu.curcon.dto.ModuleDto;
import nl.hu.curcon.dto.UserDto;
import nl.hu.curcon.dto.competence.TrefwoordDto;
import nl.hu.curcon.dto.post.RolePutDto;
import nl.hu.curcon.dto.post.TrefwoordPostDto;
import nl.hu.curcon.dto.post.UserPutDto;

public interface UserService {

	List <UserDto> findAll();
	UserDto find(String username);

	List<FunctionDto> findFunctionsByUsername(String username);
	String create(UserDto dto);
	boolean update(String username, UserPutDto userDto);
	boolean delete(String username);
	boolean updateRoleByUser(String username, int roleId);
}
