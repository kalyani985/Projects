package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.mysql.jdbc.Statement;

import model.Items;

public class ItemDataAccess implements itemsDAO {
	
	String selectAllSQL = "SELECT * FROM " + MYSQLConst.ITEM_TABLE_NAME + " " + "WHERE" + MYSQLConst.ITEM_STATUS + "=" + "\"AVAILABLE\";";
	
	String insertSQL="INSERT INTO "+MYSQLConst.ITEM_TABLE_NAME+"("+
			MYSQLConst.ITEM_ID+","+MYSQLConst.ITEM_TITLE+","+MYSQLConst.ITEM_AUTHOR+","
			+MYSQLConst.ITEM_PUBLISHER+","+MYSQLConst.ITEM_PUBYEAR+","
			+MYSQLConst.ITEM_ISBN+","+MYSQLConst.ITEM_STATUS+","+MYSQLConst.ITEM_PURCHASE+","
			+MYSQLConst.ITEM_CATEGORY+","+MYSQLConst.ITEM_DESC+") VALUES(?,?,?,?,?,?,?,?,?,?)";
	
	String updateSQL="UPDATE "+MYSQLConst.ITEM_TABLE_NAME+" SET "+MYSQLConst.ITEM_TITLE+"=?,"+MYSQLConst.ITEM_AUTHOR
			+"=?,"+MYSQLConst.ITEM_PUBLISHER+"=?,"+MYSQLConst.ITEM_PUBYEAR+"=?,"
			+MYSQLConst.ITEM_ISBN+"=?,"+MYSQLConst.ITEM_STATUS+"=?,"+MYSQLConst.ITEM_PURCHASE+"=?,"
			+MYSQLConst.ITEM_CATEGORY+"=?,"+MYSQLConst.ITEM_DESC+"=?"+" WHERE "+MYSQLConst.ITEM_ID+"=?";
			
	String deleteSQL="DELETE FROM "+MYSQLConst.ITEM_TABLE_NAME+" WHERE "+MYSQLConst.ITEM_ID +"=?";
	
	String updateBStatus=" UPDATE "+MYSQLConst.ITEM_TABLE_NAME+ " SET" +MYSQLConst.ITEM_STATUS+"='OnLoan'"+" WHERE "+MYSQLConst.ITEM_ID +"=?";
	
	
	String selectOneSQL = "SELECT *FROM " + MYSQLConst.ITEM_TABLE_NAME + " WHERE " + MYSQLConst.ITEM_STATUS + "=" + "\"AVAILABLE\"" + " " + "AND " + MYSQLConst.ITEM_ID + "=?" ;

	String searchbyTitle = "SELECT * FROM " + MYSQLConst.ITEM_TABLE_NAME + " WHERE " + MYSQLConst.ITEM_STATUS + "=" + "\"AVAILABLE\"" + " " + "AND " + MYSQLConst.ITEM_TITLE + "=?";

	String searchbyAuthor = "SELECT * FROM " + MYSQLConst.ITEM_TABLE_NAME + " WHERE " + MYSQLConst.ITEM_STATUS + "=" + "\"AVAILABLE\"" + " " + "AND " + MYSQLConst.ITEM_AUTHOR + "=?";

	String searchbyCategory = "SELECT * FROM " + MYSQLConst.ITEM_TABLE_NAME + " WHERE "  + MYSQLConst.ITEM_STATUS + "=" + "\"AVAILABLE\"" + " " + "AND " + MYSQLConst.ITEM_CATEGORY + "=?" ;

	String updateAfterReturn=" UPDATE "+MYSQLConst.ITEM_TABLE_NAME+ " SET "+MYSQLConst.ITEM_STATUS+"='AVAILABLE'"+" WHERE "+MYSQLConst.ITEM_ID +"=?";
	
	String totalRecords = "SELECT COUNT(item_id) FROM " + MYSQLConst.ITEM_TABLE_NAME;
	
	private static Connection connection;
	private static PreparedStatement ps;
	private static Statement stmt;
	private ResultSet rs;
	Items t = new Items();
	


	private static void openConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/alas", "root", "password");
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

	
	
//CREATE ITEM
	
	public int createItems(Items item) throws SQLException {
		openConnection();
		
        ps = connection.prepareStatement(insertSQL);
		ps.setString(1, item.getItem_id());
		ps.setString(2, item.getItem_title());
		ps.setString(3,item.getItem_author());
		ps.setString(4,item.getItem_publisher());
		ps.setInt(5,item.getItem_published_year() );
		ps.setString(6,item.getItem_ISBN());
		ps.setString(7,item.getItem_status());		
		ps.setDate(8,(java.sql.Date) item.getItem_date_of_purchase());
		ps.setString(9,item.getItem_category());
		ps.setString(10,item.getItem_description());
		int result = ps.executeUpdate(); 
		closeConnection();
		return result;

	}

//Get ONE Item or SEARCH BY ID
	public Items getItem(String item_id) throws SQLException {
		
				openConnection();
				ps = connection.prepareStatement(selectOneSQL);
				ps.setString(1,item_id);
				rs = ps.executeQuery();  // Error Here
		while (rs.next()) {
			 t = new Items(rs.getString("item_id"), rs.getString("item_title"),
						rs.getString("item_author"), rs.getString("item_publisher"),
						rs.getInt("item_published_year"),rs.getString("item_ISBN"),
						rs.getString("item_status"),rs.getDate("item_date_of_purchase"),					
						rs.getString("item_category"),rs.getString("item_description"));
		}
		closeConnection();
		//System.out.println(t);
		return t;

	}
	
	
//	FIND ALL ITEMS
	
	
	public ArrayList<Items> findAllItems1() throws SQLException {
		openConnection();
		ArrayList<Items> result = new ArrayList<Items>();
		System.out.println("hi");
		ps = connection.prepareStatement(selectAllSQL);
		rs = ps.executeQuery();
		while (rs.next()) {
			t = new Items(rs.getString("item_id"), rs.getString("item_title"),
					rs.getString("item_author"), rs.getString("item_publisher"),
					rs.getInt("item_published_year"),rs.getString("item_status"),
					rs.getString("item_ISBN"),rs.getDate("item_date_of_purchase"),					
					rs.getString("item_category"),rs.getString("item_description"));		
			result.add(t);
		}
		closeConnection();
		return result;
	}

//UPDATE ITEMS	
	
	public int updateItems(Items item) throws SQLException 
	{
		openConnection();	
		System.out.println("UPDATE");
		ps = connection.prepareStatement(updateSQL);
		System.out.println(updateSQL);
		ps.setString(10,item.getItem_id());
		//System.out.println(item.getItem_id());
		ps.setString(1, item.getItem_title());
		ps.setString(2,item.getItem_author());
		ps.setString(3,item.getItem_publisher());
		ps.setInt(4,item.getItem_published_year() );
		ps.setString(5,item.getItem_ISBN());
		ps.setString(6,item.getItem_status());		
		ps.setDate(7,(java.sql.Date) item.getItem_date_of_purchase());
		ps.setString(8,item.getItem_category());
		ps.setString(9,item.getItem_description());
		
		
		int result = ps.executeUpdate();
		closeConnection();
		return result;
	}

//DELETE ITEMS

	public int deleteItems(String item_id) throws SQLException {
		openConnection();
		ps = connection.prepareStatement(deleteSQL);
		ps.setString(1, item_id); //item_id 
		int result = ps.executeUpdate();
		closeConnection();
		return result;

	}
	//update status
	public void updateBStatus(String item_id) throws SQLException 
	{
		openConnection();
		System.out.println("Item id" + item_id);
		ps = connection.prepareStatement(updateBStatus);
		System.out.println(updateBStatus);
		ps.setString(1, item_id); //item_id 
		int result = ps.executeUpdate();
		System.out.println("result =" + result);
		closeConnection();
//		return result;
	}
	@Override
	public ArrayList<Items> SearchByItemTitle(String item_title) {
		openConnection();
		try {
			ArrayList<Items> list = new ArrayList<Items>(); 
			ps = connection.prepareStatement(searchbyTitle);
			ps.setString(1,item_title);
			rs = ps.executeQuery();  // Error Here
	while (rs.next()) {
		 t = new Items(rs.getString("item_id"), rs.getString("item_title"),
				rs.getString("item_author"), rs.getString("item_publisher"),
				rs.getInt("item_published_year"),rs.getString("item_ISBN"),
				rs.getString("item_status"),rs.getDate("item_date_of_purchase"),					
				rs.getString("item_category"),rs.getString("item_description"));
		 
			list.add(t);
	}

	closeConnection();
		return list;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public ArrayList<Items> SearchByCategory(String item_category) 
	{
	       openConnection();
		try
		{
			ArrayList<Items> plist = new ArrayList<Items>(); 						
			System.out.println(searchbyCategory);
			System.out.println(item_category);
			ps = connection.prepareStatement(searchbyCategory);
			ps.setString(1,item_category); 
			rs = ps.executeQuery();  // Error Here
	while (rs.next()) {
		 t = new Items(rs.getString("item_id"), rs.getString("item_title"),
					rs.getString("item_author"), rs.getString("item_publisher"),
					rs.getInt("item_published_year"),rs.getString("item_ISBN"),
					rs.getString("item_status"),rs.getDate("item_date_of_purchase"),					
					rs.getString("item_category"),rs.getString("item_description"));
			plist.add(t);	
			System.out.println(t);
	      }
	closeConnection();
	return plist;
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
		return null;
	
}
	public int updateItems1(Items i) throws SQLException {
		openConnection();
		stmt = (Statement) connection.createStatement();
		String update = "UPDATE alas.items SET " + "item_author = \"" + i.getItem_author() + "\"" + ",item_category=\""
				+ i.getItem_category() + "\"" + ",item_publisher=\"" + i.getItem_publisher() + "\"" + ",item_ISBN=\""
				+ i.getItem_ISBN() + "\"" + ", item_description=\"" + i.getItem_description() + "\"" + ", item_title=\""
				+ i.getItem_title() + "\"" + "  WHERE item_id =\"" + i.getItem_id() + "\";";
		System.out.println(update);
		int result = stmt.executeUpdate(update);
		closeConnection();
		return result;

	}
	
	

	public int deactivateItem(Items i) throws SQLException {
	//	openConnection();
	//	stmt = (Statement) connection.createStatement();
	//	String delete = "DELETE FROM alas.items WHERE item_id =\"" + i.getItem_id() + "\";";
	//	boolean result = stmt.execute(delete);
	//	closeConnection();
	//	return result;
		
		openConnection();
		stmt = (Statement) connection.createStatement();
		String delete = "UPDATE alas.items SET " + "item_status = \"" + "Archived" + "\""  + "  WHERE item_id =\"" + i.getItem_id() + "\";";
		System.out.println(delete);
		int result = stmt.executeUpdate(delete);
		closeConnection();
		return result;
	}
	public int createItem1 (Items i) throws SQLException {
		openConnection ();
		System.out.println ("I am in create database");
		String ins = "INSERT INTO alas.items(item_id, item_title, item_author, item_publisher, item_published_year, item_ISBN, item_status, item_date_of_purchase, item_category, item_description)VALUES "
				+ "(" +  i.getItem_id() + ",\""
					  + i.getItem_title() + ",\""
					  + i.getItem_author() + ",\""
					  + i.getItem_publisher() + ",\""
					  + i.getItem_published_year() + ",\""
					  + i.getItem_ISBN() + ",\""
					  + i.getItem_status() + ",\""
					  + i.getItem_date_of_purchase() + ",\""
					  + i.getItem_category() + ",\""
					  + i.getItem_description() +"\");";
		System.out.println (ins);
		int result = stmt.executeUpdate(ins);
		closeConnection ();
		return result;
	}

	@Override
	public ArrayList<Items> SearchByAuthor(String item_author) {
		openConnection();
		try {
			ArrayList<Items> alist = new ArrayList<Items>(); 
			ps = connection.prepareStatement(searchbyAuthor);
			
			ps.setString(1,item_author);
			rs = ps.executeQuery();  // Error Here
	while (rs.next()) {
		 t = new Items(rs.getString("item_id"), rs.getString("item_title"),
					rs.getString("item_author"), rs.getString("item_publisher"),
					rs.getInt("item_published_year"),rs.getString("item_ISBN"),
					rs.getString("item_status"),rs.getDate("item_date_of_purchase"),					
					rs.getString("item_category"),rs.getString("item_description"));
			alist.add(t);
	}
	closeConnection();
	//System.out.println(alist);
	return alist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void updateItemStatus(String itemid) throws SQLException 
	{
		openConnection();
		System.out.println("Item id in data" + itemid);
		ps = connection.prepareStatement(updateAfterReturn);
		System.out.println(updateAfterReturn);
		ps.setString(1, itemid); //item_id 
		int result = ps.executeUpdate();
		System.out.println("result =" + result);
		closeConnection();
//		return result;
	}
	public String nextItemId() throws SQLException {
		openConnection ();
		System.out.println("in item_id database");
		String nextItemIdGen = null;
		System.out.println(nextItemIdGen);
		ps = connection.prepareStatement (totalRecords);
		rs = ps.executeQuery();
		System.out.println(("query executed"));
		while (rs.next()) {
			int nextItemId = rs.getInt(1) + 1 ;
		nextItemIdGen = "IT" + nextItemId;
		System.out.println (nextItemIdGen);
		}
		return nextItemIdGen;
		}	


}	
	
	
 
	

	
