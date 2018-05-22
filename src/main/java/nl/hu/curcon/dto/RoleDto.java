package nl.hu.curcon.dto;

import java.util.List;
import java.util.Set;

import nl.hu.curcon.domain.Role;

public class RoleDto extends HRefDto {
	private int id;
	private String name;
	private Set<ModuleDto> modules;

	public RoleDto() {
		super();
	}

	public RoleDto(int id, String name, Set<ModuleDto> modules) {
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

	public Set<ModuleDto> getModules() {
		return modules;
	}

	public void setModules(Set<ModuleDto> set) {
		this.modules = set;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
