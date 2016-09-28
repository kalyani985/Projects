package dao;

import java.sql.Connection;
//import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Items;
import model.Transaction;

public class TransactionDataAccess implements TransactionDAO {

	String selectAllTrans = "SELECT *FROM " + MYSQLConst.TRANS_TABLE_NAME;

	String checkRecno = " SELECT * FROM " + MYSQLConst.TRANS_TABLE_NAME + " WHERE " + MYSQLConst.TRANS_DETAILS
			+ "='OnLoan'" + "AND" + MYSQLConst.TRANS_USERID + "=?";

	String insertTRANSSQL = "INSERT INTO " + MYSQLConst.TRANS_TABLE_NAME + "(" + MYSQLConst.TRANS_ID + ","
			+ MYSQLConst.TRANS_USERID + "," + MYSQLConst.TRANS_TITEM_ID + "," + MYSQLConst.TRANS_DETAILS + ","
			+ MYSQLConst.TRANS_ISSUE_DATE + "," + MYSQLConst.TRANS_DUE_DATE + ")VALUES(?,?,?,?,?,?)";

	String selectOneTrans = "SELECT *FROM " + MYSQLConst.TRANS_TABLE_NAME + " WHERE " + MYSQLConst.TRANS_ID + "=?";

	String updateTransStatus = " UPDATE " + MYSQLConst.TRANS_TABLE_NAME + " SET " + MYSQLConst.TRANS_DETAILS
			+ "='Returned' , " + MYSQLConst.TRANS_RETURN_DATE + "=?" + " , " + MYSQLConst.TRANS_FINE_AMT + "=?"
			+ " WHERE " + MYSQLConst.TRANS_ID + "=?";

	String updateBStatus = " UPDATE " + MYSQLConst.ITEM_TABLE_NAME + " SET" + MYSQLConst.ITEM_STATUS + "='OnLoan'"
			+ " WHERE " + MYSQLConst.ITEM_ID + "=?";

	private static Connection connection;
	private static PreparedStatement ps;
	private ResultSet rs;
	Items t = new Items();
	Transaction trans = new Transaction();
	int result;

	private static void openConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alas", "root", "password");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void closeConnection() {
		try {
			ps.close();

			connection.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	// CREATE TRANSACTION
	public int createTransaction(Transaction t) throws SQLException {
		openConnection();
		try {

			connection.setAutoCommit(false);

			// updateBStatus(boritemid);
			System.out.println("Item id" + t.getItem_id()); // boritemid
			ps = connection.prepareStatement(updateBStatus);
			System.out.println(updateBStatus);
			ps.setString(1, t.getItem_id()); // item_id or boritemid
			ps.executeUpdate();
			System.out.println("result =" + result);

			// Insert Transaction record
			ps = connection.prepareStatement(insertTRANSSQL);
			System.out.println(insertTRANSSQL);
			t.setTrans_details("OnLoan");
			ps.setInt(1, t.getTrans_id());
			ps.setString(2, t.getUser_id());
			ps.setString(3, t.getItem_id());
			// ps.setString(3,"fdsfdd");
			// boritemid = t.getItem_id();
			// boritemid = "fdsfdd";
			ps.setString(4, t.getTrans_details());
			ps.setDate(5, new java.sql.Date(t.getItem_issue_date().getTime()));
			ps.setDate(6, new java.sql.Date(t.getItem_due_date().getTime()));

			// ps.setDate(7,(java.sql.Date)t.getItem_return_date());
			// ps.setDouble(8,t.getTrans_fine_amount());
			// System.out.println(t.getUser_id());
			int result = ps.executeUpdate();
			System.out.println(result);

			// Insert record Transaction

			connection.commit();

			closeConnection();
		} catch (SQLException e) {

			connection.rollback();

			e.printStackTrace();

		}
		return result;
	}

	@Override
	public Transaction getOneTransaction(int id) throws SQLException {
		openConnection();
		ps = connection.prepareStatement(selectOneTrans);
		ps.setInt(1, id);
		rs = ps.executeQuery(); // Error Here
		while (rs.next()) {
			trans = new Transaction(rs.getInt("trans_id"), rs.getString("user_id"), rs.getString("item_id"),
					rs.getString("trans_details"), rs.getDate("item_issue_date"), rs.getDate("item_due_date"),
					rs.getDate("item_return_date"), rs.getInt("trans_fine_amount"));

		}
		closeConnection();
		return trans;

	}

	@Override
	public ArrayList<Transaction> getAlltransactions() throws SQLException {

		openConnection();
		ArrayList<Transaction> result = new ArrayList<Transaction>();
		ps = connection.prepareStatement(selectAllTrans);
		rs = ps.executeQuery();
		while (rs.next()) {
			trans = new Transaction(rs.getInt("trans_id"), rs.getString("user_id"), rs.getString("item_id"),
					rs.getString("trans_details"), rs.getDate("item_issue_date"), rs.getDate("item_due_date"),
					rs.getDate("item_return_date"), rs.getInt("trans_fine_amount"));

			result.add(trans);

		}
		closeConnection();
		return result;
	}

	@Override
	public boolean numberofRecord(String sid) throws SQLException {
		openConnection();
		// boolean bool=false;
		ps = connection.prepareStatement(checkRecno);
		ps.setString(1, sid);
		int count = 0;
		rs = ps.executeQuery();
		while (rs.next()) {
			count++;

		}
		System.out.println(count);
		if (count < 10)
			return true;
		else

			return false;
	}

	public void returnItem(int transid, java.util.Date actualReturnDate, long fine) throws SQLException {
		openConnection();
		try {
			System.out.println("Trans id ->" + transid);
			System.out.println("Date ->" + actualReturnDate);
			System.out.println("Fine ->" + fine);

			// connection.setAutoCommit(false);
			ps = connection.prepareStatement(updateTransStatus);
			System.out.println(updateTransStatus);
			ps.setDate(1, new java.sql.Date(actualReturnDate.getTime()));
			ps.setLong(2, fine);
			ps.setInt(3, transid);
			result = ps.executeUpdate();
			System.out.println("Return item " + result);
		} catch (SQLException e) {
			// try
			// {
			// //connection.rollback();
			// }catch(SQLException e1)
			// {
			e.printStackTrace();
			// }
		}
		// closeConnection();
		// return result;
	}

	@Override
	public ArrayList<Transaction> selectOnloan(String sid) throws SQLException {
		openConnection();
		ArrayList<Transaction> result = new ArrayList<Transaction>();
		ps = connection.prepareStatement(checkRecno);
		ps.setString(1, sid);
		rs = ps.executeQuery();
		while (rs.next()) {
			trans = new Transaction(rs.getInt("trans_id"), rs.getString("user_id"), rs.getString("item_id"),
					rs.getString("trans_details"), rs.getDate("item_issue_date"), rs.getDate("item_due_date"),
					rs.getDate("item_return_date"), rs.getInt("trans_fine_amount"));

			result.add(trans);

		}
		closeConnection();
		return result;
	}

	public ArrayList<Transaction> TransactionByItem(String item_id) throws SQLException {

		// String searchbyCategory = "SELECT * FROM " +
		// MYSQLConst.ITEM_TABLE_NAME + " WHERE " + MYSQLConst.ITEM_CATEGORY +
		// "=?";
		// ArrayList<Items> plist = new ArrayList<Items>();
		// System.out.println(searchbyCategory);
		// System.out.println(item_category);
		// ps = connection.prepareStatement(searchbyCategory);
		// ps.setString(1,item_category);
		// rs = ps.executeQuery(); // Error Here

		openConnection();

		try {
			int i = 0;
			System.out.println(item_id);

			String transQuery = "SELECT * FROM " + MYSQLConst.TRANS_TABLE_NAME + " WHERE " + MYSQLConst.TRANS_TITEM_ID
					+ "=?";
			ArrayList<Transaction> result = new ArrayList<Transaction>();
			ps = connection.prepareStatement(transQuery);
			ps.setString(1, item_id);
			rs = ps.executeQuery();

			System.out.println(transQuery);
			// rs = stmt.executeQuery(transQuery);
			System.out.println("after rs =");
			System.out.println(rs);
			System.out.println("before while");

			// while (rs.next()) {
			// t = new Items(rs.getString("item_id"),
			// rs.getString("item_title"), rs.getString("item_author"),
			// rs.getString("item_publisher"), rs.getInt("item_published_year"),
			// rs.getString("item_ISBN"),
			// rs.getString("item_status"), rs.getDate("item_date_of_purchase"),
			// rs.getString("item_category"),
			// rs.getString("item_description"));
			// plist.add(t);
			// System.out.println(t);
			// }

			while (rs.next()) {
				// System.out.println("i=" + i++);
				System.out.println("i=" + i++);
				trans = new Transaction(rs.getInt("trans_id"), rs.getString("user_id"), rs.getString("item_id"),
						rs.getString("trans_details"), rs.getDate("item_issue_date"), rs.getDate("item_due_date"),
						rs.getDate("item_return_date"), rs.getInt("trans_fine_amount"));

				result.add(trans);
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return null;
	}

}
