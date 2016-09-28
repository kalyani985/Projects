package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.user;

public class userdataaccess implements userdao {

	private static Connection connection;
	private static Statement statement;
	private ResultSet rs;

	private static void openConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alas", "root", "password");
			statement = connection.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void closeConnection() {
		try {
			statement.close();

			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int createUser(user u) throws SQLException {
		openConnection();
		String ins = "INSERT INTO alas.user(user_id, user_name, user_password, user_gender, user_address, user_contact, user_status, user_type) VALUES ("
				+ u.getUser_id() + ", \"" + u.getUser_name() + "\",\"" + u.getUser_password() + "\","
				+ u.getUser_gender() + ",\"" + u.getUser_address() + "\");" + u.getUser_contact() + ",\""
				+ u.getUser_status() + ",\"" + u.getUser_type() + ",\""

		;
		int result = statement.executeUpdate(ins);
		closeConnection();
		return result;

	}

	public user getOneuser(String user_id) throws SQLException {
		user u = new user();
		openConnection();
		rs = statement.executeQuery("SELECT * FROM alas.user as u WHERE u.user_id = '" + user_id + "\';");
		while (rs.next()) {
			u = new user(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getInt(6), rs.getString(7), rs.getString(8));
		}
		closeConnection();
		return u;

	}

	public ArrayList<user> getSomeUsers(user us) throws SQLException {
		user u = new user();
		openConnection();
		rs = statement.executeQuery("SELECT * FROM alas.user WHERE " + " User_id = \"" + u.getUser_id() + "\""
				+ " OR User_name = \"" + u.getUser_name() + "\"" + " OR User_address = \"" + u.getUser_address() + "\""
				+ " OR User_contact = " + u.getUser_contact() + " OR User_gender = \"" + u.getUser_gender() + "\""
				+ " OR User_status = \"" + u.getUser_status() + "\"");
		while (rs.next()) {
			u = new user(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
					rs.getString(6));
		}

		closeConnection();
		return null;

	}

	public ArrayList<user> getAllUsers() throws SQLException {
		openConnection();
		ArrayList<user> result = new ArrayList<user>();
		rs = statement.executeQuery("SELECT * FROM alas.user;");
		while (rs.next()) {
			user u = new user(rs.getString("user_id"), rs.getString("user_name"), rs.getString("user_password"),
					rs.getString("user_gender"), rs.getString("user_address"), rs.getInt("user_contact"),
					rs.getString("user_status"), rs.getString("user_type"));
			result.add(u);
		}
		closeConnection();
		return result;
	}

	// UPDATE alas.user
	// SET
	// user_password = '4321'
	// WHERE user_id = 'L1';

	public int updateUser(user u) throws SQLException {
		openConnection();
		String upd = "UPDATE alas.user SET "

				+ " User_name = \"" + u.getUser_name() + "\"" + " , User_address = \"" + u.getUser_address() + "\""
				+ " , User_contact = " + u.getUser_contact() + " , User_gender = \"" + u.getUser_gender() + "\""
				+ " , User_status = \"" + u.getUser_status() + "\"" + " WHERE user_id = \"" + u.getUser_id() + "\";";

		System.out.println(upd);

		int result = statement.executeUpdate(upd);
		closeConnection();
		return result;
	}

	public boolean deleteUser(user u) throws SQLException {
		openConnection();
		String del = "DELETE FROM alas.user WHERE id = " + u.getUser_id() + ";";
		boolean result = statement.execute(del);
		closeConnection();
		return result;

	}

	@Override
	public boolean createNewUser(user newUser) {
		boolean boolResult = false;
		openConnection();
		try {
			// INSERT INTO `ALAS`.`user`
			// (
			// `user_id`
			// , `user_name`
			// , `user_password`
			// , `user_gender`
			// , `user_address`
			// , `user_contact`
			// , `user_status`
			// , `user_type`
			// )
			// VALUES ('S4'
			// , 'Sryn'
			// , '1234'
			// , 'M'
			// , 'PGPR'
			// , '12345678'
			// , 'Active'
			// , 'student'
			// );

			String ins = "INSERT INTO alas.user(user_id, user_name, user_password, user_gender"
					+ ", user_address, user_contact, user_status, user_type) VALUES (" + "\"" + newUser.getUser_id()
					+ "\"" + ", \"" + newUser.getUser_name() + "\"" + ", \"" + newUser.getUser_password() + "\""
					+ ", \"" + newUser.getUser_gender() + "\"" + ", \"" + newUser.getUser_address() + "\"" + ", "
					+ newUser.getUser_contact() + ", \"" + newUser.getUser_status() + "\"" + ", \""
					+ newUser.getUser_type() + "\"" + ");";
			int result = statement.executeUpdate(ins);
			System.out.println("statement.executeUpdate(ins) = " + result);
			boolResult = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection();
		}

		return boolResult;
	} // public boolean createNewUser(user newUser)

	@Override
	public String getNewUserID(String userType) throws SQLException {
		openConnection();

		int userCount = 0;
		String prefix;

		if (userType.matches("Librarian")) {
			prefix = "L";
		} else {
			prefix = "S";
		}

		try {

			rs = statement.executeQuery("select count(*) from alas.user where user_id LIKE '" + prefix + "%'");

			System.out.println(rs);

			while (rs.next()) {
				userCount = rs.getInt(1);
				System.out.println(userCount);
			}

			String strReturn = prefix.concat(String.valueOf(userCount + 1));
			System.out.println(strReturn);
			return strReturn;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

		return null;
	} // public String getNewUserID(String userType) throws SQLException

	@Override
	public user getByUserId(user id) throws SQLException {
		user u = new user();
		openConnection();
		System.out.println("SELECT * FROM alas.user WHERE user_id=\"" + id.getUser_id() + "\";");
		rs = statement.executeQuery("SELECT * FROM alas.user WHERE user_id=\"" + id.getUser_id() + "\";");
		while (rs.next()) {
			u.setUser_address(rs.getString("user_address"));
			u.setUser_contact(rs.getInt("user_contact"));
			u.setUser_gender(rs.getString("user_gender"));
			u.setUser_id(rs.getString("user_id"));
			u.setUser_name(rs.getString("user_name"));
			u.setUser_status(rs.getString("user_status"));
			u.setUser_type(rs.getString("user_type"));
		}
		closeConnection();
		return u;
	}

	@Override
	public ArrayList<user> getByName(user u3) throws SQLException {
		openConnection();
		ArrayList<user> userList = new ArrayList<user>();

		rs = statement.executeQuery("SELECT * FROM alas.user WHERE user_name LIKE 	'%" + u3.getUser_name() + "%'");

		while (rs.next()) {
			user u = new user();
			u.setUser_address(rs.getString("user_address"));
			u.setUser_contact(rs.getInt("user_contact"));
			u.setUser_gender(rs.getString("user_gender"));
			u.setUser_id(rs.getString("user_id"));
			u.setUser_name(rs.getString("user_name"));
			u.setUser_status(rs.getString("user_status"));
			u.setUser_type(rs.getString("user_type"));
			userList.add(u);
			System.out.println(u);
		}
		closeConnection();
		return userList;
	} // public ArrayList<user> getByName(user u3) throws SQLException

	@Override
	public int deactivateUserbyUserId(user u1) throws SQLException {
		openConnection();

		System.out.println(
				"UPDATE alas.user as u SET u.user_status = 'Inactive' WHERE u.user_id  = \"" + u1.getUser_id() + "\";");
		String del = "UPDATE alas.user as u SET u.user_status = 'Inactive' WHERE u.user_id  = \"" + u1.getUser_id()
				+ "\";";
		int result = statement.executeUpdate(del);
		closeConnection();
		return result;
	} // public int deactivateUserbyUserId(user u1) throws SQLException

}
