package org.mileng.sample.MavenHerokuWebappPr3.user.entity;

import java.util.ArrayList;


public class UserList extends ArrayList<User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		String result = "";
		User user = null;
		RoleList roles = null;
		for (int i=0; i< this.size(); i++ ) {
			user = this.get(i);
			result = result + String.format("User '%d' id '%d' email '%s' fullName '%s' \n", 
					i+1, user.getId(), user.getEmail(), user.getFullName());
			roles = user.getRoles();
			Role role = null;
			for (int j=0; j< roles.size(); j++ ) {
				role = roles.get(j);
				result = result + String.format("  Role '%d' id '%d' name '%s' \n", 
						j+1, role.getId(), role.getName());
			}
		}
		return result;
	}
	
}
