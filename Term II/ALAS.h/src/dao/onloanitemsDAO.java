package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import model.onloanitems;
//import model.user;

public interface onloanitemsDAO {
	public abstract ArrayList<onloanitems> getOnLoanItems(String aUserID) throws SQLException;
}
