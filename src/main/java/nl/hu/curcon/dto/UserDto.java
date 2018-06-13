package nl.hu.curcon.dto;

import nl.hu.curcon.domain.Role;

public class UserDto extends HRefDto{
	private String username;
	private HRefDto role;
	
	public UserDto() {
		super();
	}
	
	public UserDto(String username, HRefDto role) {
		this.setUsername(username);
		this.setRole(role);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public HRefDto getRole() {
		return role;
	}

	public void setRole(HRefDto hRefDtoOP) {
		this.role = hRefDtoOP;
	}
	
	
}
