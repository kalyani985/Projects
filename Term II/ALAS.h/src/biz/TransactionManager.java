package biz;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAOFactory;
import dao.TransactionDAO;
//import dao.itemsDAO;
import model.Transaction;

public class TransactionManager {
	// private TransactionDAO tdao;

	public ArrayList<Transaction> TransactionByItem(String item_id) throws SQLException {
		TransactionDAO tdao = DAOFactory.gettransactonDAO();
		return tdao.TransactionByItem(item_id);
	}

	public int createTransaction(Transaction t) throws SQLException {
		TransactionDAO tdao = DAOFactory.gettransactonDAO();
		return tdao.createTransaction(t);
	}

	public boolean numberofRecord(String sid) throws SQLException {
		TransactionDAO tdao = DAOFactory.gettransactonDAO();
		// boolean result= tdao.numberofRecord(sid);

		return tdao.numberofRecord(sid);
	}

	public ArrayList<Transaction> selectOnloan(String sid) throws SQLException	{
		TransactionDAO tdao = DAOFactory.gettransactonDAO();
		return tdao.selectOnloan(sid);
	}

	public void returnItem(int transid, java.util.Date actualReturnDate, long fine) throws SQLException {
		TransactionDAO tdao = DAOFactory.gettransactonDAO();
		tdao.returnItem(transid, actualReturnDate, fine);
	}

}