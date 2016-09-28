package dao;

public class hMYSQLConst extends MYSQLConst {
	
	public static final String URL = "jdbc:mysql://localhost/alas";
	public static final String USER = "root";
	public static final String PASSWORD = "password";
	public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	
	// ITEM DETAILS
	public static final String ITEM_TABLE_NAME = "alas.items";
	public static final String ITEM_ID = "item_id";
	public static final String ITEM_TITLE = "item_title";
	public static final String ITEM_AUTHOR = "item_author";
	public static final String ITEM_PUBLISHER = "item_publisher";
	public static final String ITEM_PUBYEAR = "item_published_year";
	public static final String ITEM_ISBN = "item_ISBN";
	public static final String ITEM_STATUS = "item_status";
	public static final String ITEM_PURCHASE = "item_date_of_purchase";
	public static final String ITEM_CATEGORY = "item_category";
	public static final String ITEM_DESC = "item_description";

	// TRANSCATION DETAILS
	public static final String TRANS_TABLE_NAME = "alas.transaction";
	public static final String TRANS_ID = "trans_id";
	public static final String TRANS_USERID = "user_id";
	public static final String TRANS_ITEM_ID = "item_id";
	public static final String TRANS_DETAILS = "trans_details";
	public static final String TRANS_ISSUE_DATE = "item_issue_date";
	public static final String TRANS_DUE_DATE = "item_due_date";
	public static final String TRANS_RETURN_DATE = "item_return_date";
	public static final String TRANS_FINE_AMT = "trans_fine_amount";

}
