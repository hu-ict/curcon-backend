package nl.hu.curcon.service;

import nl.hu.curcon.dto.UserDto;

public interface UserService {
	UserDto find(String username, String password, String role);
}
