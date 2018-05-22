package nl.hu.curcon.dto;

import java.util.ArrayList;
import java.util.Set;
import java.util.List;
import java.util.Set;

public class ModuleDto {
	private int id;
	private String name;
	private Set<FunctionDto> functions;

	public ModuleDto() {
		super();
	}

	public ModuleDto(int id, String name, Set<FunctionDto> HRefs) {
		this.setId(id);
		this.setName(name);
		this.setFunctions(HRefs);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFunctions(Set<FunctionDto> Set) {
		this.functions=Set;
		
	}

	public Set<FunctionDto> getFunctions() {
		return functions;
	}
}
