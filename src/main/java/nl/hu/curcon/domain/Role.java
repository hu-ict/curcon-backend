package nl.hu.curcon.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@SuppressWarnings("serial")
@Entity
@Table(name = "role")
public class Role implements Serializable{
	@Id
	@Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="name", unique = true)
	private String name;
	@ManyToMany//(cascade = CascadeType.ALL)
	@JoinTable(name = "module_role",uniqueConstraints = {  @UniqueConstraint(columnNames={"role_id", "module_id"})}, joinColumns = 
	@JoinColumn(name = "role_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "module_id", referencedColumnName = "id"))
	private List<Module> modules;

	public Role() {

	}

	public Role(int id, String name) {
		this.id=id;
		this.name = name;
	}

	public Role(int id, String name, List<Module> modules) {
		this.id=id;
		this.name = name;
		this.modules = modules;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}
}