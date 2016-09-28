package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Transaction;

public interface TransactionDAO {
	public abstract int createTransaction(Transaction t) throws SQLException;
	public abstract Transaction getOneTransaction(int id)throws SQLException;
	public abstract ArrayList<Transaction> getAlltransactions()throws SQLException;
	
	public abstract boolean numberofRecord(String sid) throws SQLException;
	public abstract ArrayList<Transaction> selectOnloan(String sid) throws SQLException;
	public abstract void returnItem(int transid, java.util.Date actualReturnDate, long fine)throws SQLException;
	public abstract ArrayList<Transaction> TransactionByItem (String item_id) throws SQLException;
}
