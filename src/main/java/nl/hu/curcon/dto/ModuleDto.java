package nl.hu.curcon.dto;

import java.util.ArrayList;
import java.util.Set;
import java.util.List;
import java.util.Set;

public class ModuleDto extends HRefDto{
	private int id;
	private String name;
	private HRefDto functions;

	public ModuleDto() {
		super();
	}

	public ModuleDto(int id, String name, HRefDto HRefs) {
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
	public int getId() {
		return id;
	}

	public void setFunctions(HRefDto Set) {
		this.functions=Set;
		
	}

	public HRefDto getFunctions() {
		return functions;
	}
}
