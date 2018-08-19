package nl.hu.curcon.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "useraccount")
public class User {
	@Id
	@Column(name = "username", unique = true, nullable = false)
	private String username;
	@ManyToOne//(cascade = CascadeType.ALL)
	private Role role;

	public User() {
	}

	public User(String username, Role role) {
		this.username = username;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
