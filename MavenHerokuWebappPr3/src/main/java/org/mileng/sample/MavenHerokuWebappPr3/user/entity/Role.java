package org.mileng.sample.MavenHerokuWebappPr3.user.entity;

public class Role {
	private int id;
	private String name;

	public Role(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}
}
