package nl.hu.curcon.dto;

import java.util.List;
import java.util.Set;

import nl.hu.curcon.domain.Role;

public class RoleDto extends HRefDto {
	private int id;
	private String name;
	private HRefDto modules;

	public RoleDto() {
		super();
	}

	public RoleDto(int id, String name, HRefDto modules) {
		this.setId(id);
		this.setName(name);
		this.setModules(modules);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HRefDto getModules() {
		return modules;
	}

	public void setModules(HRefDto set) {
		this.modules = set;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
