package org.mileng.sample.MavenHerokuWebappPr3.da;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.mileng.sample.MavenHerokuWebappPr3.user.entity.Role;
import org.mileng.sample.MavenHerokuWebappPr3.user.entity.RoleList;
import org.mileng.sample.MavenHerokuWebappPr3.user.entity.User;
import org.mileng.sample.MavenHerokuWebappPr3.user.entity.UserList;

public class DbMediator {

	private Connection conn;
	private PreparedStatement prepStmt;
	private ResultSet rset;

	public void connect() {
		String url = "jdbc:mysql://localhost:3306/improved_rest_sample1";
		try {
			if (this.getConn() == null) {
				Class.forName("com.mysql.jdbc.Driver");
				java.util.Properties prop = new Properties();
				prop.setProperty("user", "improved_rs1_u1");
				prop.setProperty("password", "123milen");
				// prop.setProperty("useUnicode","true");
				prop.setProperty("characterEncoding", "utf-8");
				this.setConn(DriverManager.getConnection(url, prop));
			}
		} catch (ClassNotFoundException ex) {
			System.out.println(ex.toString());
			System.exit(-1);
		} catch (SQLException ex) {
			System.out.println(ex.toString());
		} catch (java.lang.NullPointerException ex) {
			System.out.println(ex.toString());
			System.out.println("Connection failed");
		}
	}

	private Connection getConn() {
		return this.conn;
	}

	private void setConn(Connection connection) {
		this.conn = connection;
	}

	public UserList getUsers() {
		connect();
		UserList users = new UserList();
		RoleList roles = new RoleList();
		int userId;
		String userEmail = null;
		String userFullName = null;
		int roleId = 0;
		String roleName = null;
		User user = null;
		int prevUserId = 0;
		try {
			this.prepStmt = getConn().prepareStatement("select " + "u.id, u.email, u.full_name, r.id, r.name"
					+ " from user u" + " inner join user_role on ur.user_id = u.id"
					+ " inndr join role r    on ur.role_id = r.id" + " order by u.id");
			this.rset = this.prepStmt.executeQuery();
			Role role;
			while (rset.next()) {
				userId = rset.getInt(1);
				if (prevUserId == 0) {
					prevUserId = userId;
				}
				userEmail = rset.getString(2);
				userFullName = rset.getString(3);
				roleId = rset.getInt(4);
				roleName = rset.getString(5);
				if (userId != prevUserId) {
					user = new User(userId, userEmail, userFullName, roles);
					users.add(user);
					prevUserId = userId;
				}
				role = new Role(roleId, roleName);
				roles.add(role);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
}
