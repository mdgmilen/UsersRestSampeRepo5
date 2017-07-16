package org.mileng.sample.MavenHerokuWebappPr3.bl;

import org.mileng.sample.MavenHerokuWebappPr3.da.DbMediator;
import org.mileng.sample.MavenHerokuWebappPr3.user.entity.Role;
import org.mileng.sample.MavenHerokuWebappPr3.user.entity.RoleList;
import org.mileng.sample.MavenHerokuWebappPr3.user.entity.User;
import org.mileng.sample.MavenHerokuWebappPr3.user.entity.UserList;

public class BlHelper {

	public String getUsersAsString() {
		DbMediator db = new DbMediator();
		
		//the following block is to test the UserList.toString() implementation
		RoleList roles = new RoleList();
		Role roleDev = new Role (1, "Developer");
		Role roleMan = new Role (2, "Manager");
		roles.add(roleDev);
		roles.add(roleMan);
		User user = new User(1, "dimitar.dimitrov@gmail.com", "Dimitar Dimitrov", roles);
		UserList users = new UserList();
		users.add(user);
		users.add(user);
		
//		UserList users = db.getUsers();
		return users.toString();
	}
}
