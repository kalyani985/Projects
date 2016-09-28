package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//import model.Items;
//import model.onloanitems;
import model.studtranhist;
//import model.user;

public class StudTranHistDataAccess implements studtranhistDAO {

	// SELECT i.item_id
	// , i.item_category
	// , i.item_title
	// , i.item_status
	// , t.item_due_date
	// FROM ALAS.transaction AS t
	// , ALAS.items AS i
	// WHERE t.item_id=i.item_id
	// AND t.user_id='S1'
	// AND t.item_return_date is null;

//	<td>${tran.item_id}</td>
//	<td>${tran.item_category}</td>
//	<td>${tran.item_title}</td>
//	<td>${tran.item_issue_date}</td>
//	<td>${tran.item_return_date}</td>
//	<td>${tran.item_status}</td>
//	<td>${tran.trans_fine_amount}</td>
//	<td>Yes/No/Blank</td> <!-- h: Yes-if fine paid, No-if fine not paid, Blank-no fine incurred -->	
	
	String getonloanitems = "SELECT i." + hMYSQLConst.ITEM_ID 
			+ ", i." + hMYSQLConst.ITEM_CATEGORY 
			+ ", i." + hMYSQLConst.ITEM_TITLE 
			+ ", t." + hMYSQLConst.TRANS_ISSUE_DATE 
			+ ", t." + hMYSQLConst.TRANS_RETURN_DATE 
			+ ", i." + hMYSQLConst.ITEM_STATUS 
			+ ", t." + hMYSQLConst.TRANS_FINE_AMT 
			+ " FROM " + hMYSQLConst.TRANS_TABLE_NAME + " AS t" 
			+ ", " + hMYSQLConst.ITEM_TABLE_NAME + " AS i" 
			+ " WHERE t." + hMYSQLConst.TRANS_ITEM_ID + " = i." + hMYSQLConst.ITEM_ID 
			+ " AND t." + hMYSQLConst.TRANS_USERID + " = ?;";

	private static Connection connection;
	private static PreparedStatement ps;
	private ResultSet rs;
	studtranhist t = new studtranhist();

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
	public ArrayList<studtranhist> getStudTranHist(String aUserID) throws SQLException {
		// TODO Auto-generated method stub
		openConnection();

		try {
			ArrayList<studtranhist> list = new ArrayList<studtranhist>();
			ps = connection.prepareStatement(getonloanitems);
			ps.setString(1, aUserID);
			System.out.println(ps);
			rs = ps.executeQuery();
			System.out.println(rs.toString());

			while (rs.next()) {
				t = new studtranhist(rs.getString("item_id")
						, rs.getString("item_category")
						, rs.getString("item_title")
						, rs.getDate("item_issue_date")
						, rs.getDate("item_return_date")
						, rs.getString("item_status")
						, rs.getDouble("trans_fine_amount"));
				
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
