package org.mileng.sample.MavenHerokuWebappPr3.user.entity;

public class User {
	private int id;
	private String email;
	private String fullName;
	private RoleList roles;

	public User(int id, String email, String fullName, RoleList roles) {
		super();
		this.id = id;
		this.email = email;
		this.fullName = fullName;
		this.roles = roles;
	}

	public int getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getFullName() {
		return fullName;
	}

	public RoleList getRoles() {
		return roles;
	}
}
