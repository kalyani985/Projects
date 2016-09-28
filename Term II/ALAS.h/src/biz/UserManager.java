package biz;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAOFactory;

//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;

import dao.userdao;
import model.user;

public class UserManager {

	public ArrayList<user> listAll() {
		userdao dao = DAOFactory.getUserDAO();
		try {
			return dao.getAllUsers();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public user retrieveOneUser(String id) {
		userdao dao = DAOFactory.getUserDAO();

		try {
			return dao.getOneuser(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int updateUser(user u) {
		userdao dao = DAOFactory.getUserDAO();
		try {
			return dao.updateUser(u);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;

	}

	public ArrayList<user> retrieveUsers(user u) {
		userdao dao = DAOFactory.getUserDAO();
		try {
			return dao.getSomeUsers(u);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public boolean deleteUser(user u) {
		userdao dao = DAOFactory.getUserDAO();
		try {
			return dao.deleteUser(u);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	public boolean createNewUser(user newUser) throws SQLException {
		userdao dao = DAOFactory.createNewUserDAO();
		return dao.createNewUser(newUser);
	}

	public String getNewUserId(String userType) {
		userdao dao = DAOFactory.getNewUserIDDAO();
		try {
			return dao.getNewUserID(userType);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public user retrieveByUserID(user id) {
		userdao dao = DAOFactory.getUserDAO();

		try {
			return dao.getByUserId(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<user> retrieveByName(user u3) {
		userdao dao = DAOFactory.getUserDAO();

		try {
			return dao.getByName(u3);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int deactivateUser(user u1) {
		userdao dao = DAOFactory.getUserDAO();

		try {
			return dao.deactivateUserbyUserId(u1);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
}
