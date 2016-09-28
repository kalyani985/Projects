package biz;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAOFactory;
import dao.onloanitemsDAO;
import dao.studtranhistDAO;
import model.onloanitems;
import model.studtranhist;
//import model.user;

public class hTranManager {
	
	public ArrayList<onloanitems> getOnLoanItems(String aUserID) throws SQLException {
		onloanitemsDAO dao = DAOFactory.getonloanitemsDAO();
		return dao.getOnLoanItems(aUserID);	
	}

	public ArrayList<studtranhist> getStudTranHist(String aUserID) throws SQLException {
		studtranhistDAO dao = DAOFactory.getstudtranhistDAO();
		return dao.getStudTranHist(aUserID);	
	}
}
