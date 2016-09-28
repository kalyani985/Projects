package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//import model.Items;
import model.onloanitems;
//import model.user;

public class OnLoanItemsDataAccess implements onloanitemsDAO {

	// SELECT i.item_id
	// , i.item_category
	// , i.item_title
	// , i.item_status
	// , t.item_due_date
	// , t.trans_id
	// , t.trans_details
	// FROM ALAS.transaction AS t
	// , ALAS.items AS i
	// WHERE t.item_id=i.item_id
	// AND t.user_id='S1'
	// AND t.item_return_date is null;

	String getonloanitems = "SELECT i." + hMYSQLConst.ITEM_ID + ", i." + hMYSQLConst.ITEM_CATEGORY + ", i."
			+ hMYSQLConst.ITEM_TITLE + ", i." + hMYSQLConst.ITEM_STATUS + ", t." + hMYSQLConst.TRANS_DUE_DATE 
			+ ", t." + hMYSQLConst.TRANS_ID + ", t." + hMYSQLConst.TRANS_DETAILS
			+ " FROM " + hMYSQLConst.TRANS_TABLE_NAME + " AS t" + ", " + hMYSQLConst.ITEM_TABLE_NAME + " AS i " 
			+ "WHERE t." + hMYSQLConst.TRANS_ITEM_ID + " = i." + hMYSQLConst.ITEM_ID + " AND t." + hMYSQLConst.TRANS_USERID + " = ?"
			+ " AND t." + hMYSQLConst.TRANS_RETURN_DATE + " is null;";

	private static Connection connection;
	private static PreparedStatement ps;
	private ResultSet rs;
	onloanitems t = new onloanitems();

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

	@Override
	public ArrayList<onloanitems> getOnLoanItems(String aUserID) throws SQLException {
		// TODO Auto-generated method stub
		openConnection();

		try {
			ArrayList<onloanitems> list = new ArrayList<onloanitems>();
			ps = connection.prepareStatement(getonloanitems);
			ps.setString(1, aUserID);
			System.out.println(ps);
			rs = ps.executeQuery();
			System.out.println(rs.toString());

			while (rs.next()) {
				t = new onloanitems(rs.getString("item_id")
						, rs.getString("item_category")
						, rs.getString("item_title")
						, rs.getString("item_status")
						, rs.getDate("item_due_date")
						, rs.getInt("trans_id")
						, rs.getString("trans_details"));
				
				System.out.println(t.toString());

				list.add(t);
			}
			
			System.out.println(list.toString());

			return list;			

		} catch (SQLException e) {
			System.out.println(e.toString());
			e.printStackTrace();
		} finally {
			closeConnection();
		}

		return null;
	}

}
