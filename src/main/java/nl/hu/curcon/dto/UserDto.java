package nl.hu.curcon.dto;

import nl.hu.curcon.domain.Role;

public class UserDto extends LinkDto{
	private String username;
	private String password;
	private LinkDto role;
	
	public UserDto() {
		super();
	}
	
	public UserDto(String username, String password, LinkDto role) {
		this.setUsername(username);
		this.setPassword(password);
		this.setRole(role);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LinkDto getRole() {
		return role;
	}

	public void setRole(LinkDto role) {
		this.role = role;
	}
	
	
}
