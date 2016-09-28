package dao;

import java.sql.SQLException;
import java.util.ArrayList;


import model.user;

public interface userdao {

	public abstract int createUser(user u) throws SQLException;

	public abstract user getOneuser(String id) throws SQLException;

	public abstract ArrayList<user> getAllUsers() throws SQLException;

	public abstract int updateUser(user u) throws SQLException;

	public abstract boolean deleteUser(user u) throws SQLException;
	
	public abstract ArrayList<user> getSomeUsers(user us) throws SQLException;
	
	public abstract boolean createNewUser(user newUser);

	public abstract String getNewUserID(String userType) throws SQLException;

	public abstract user getByUserId(user id) throws SQLException;		

	public abstract ArrayList <user> getByName(user u3) throws SQLException;

	public abstract int deactivateUserbyUserId(user u1) throws SQLException;

}
