package nl.hu.curcon.service;

import java.util.List;

import nl.hu.curcon.dto.FunctionDto;
import nl.hu.curcon.dto.RoleDto;
import nl.hu.curcon.dto.UserDto;
import nl.hu.curcon.dto.post.UserPostDto;

public interface UserService {

	List <UserDto> findAll();
	UserDto find(String username);

	List<FunctionDto> findFunctionsByUsername(String username);
	List<RoleDto> findRoleByUser(String username);
	String create(UserPostDto dto);
	boolean delete(String username);
	boolean updateRoleByUser(String username, int roleId);
	
}
