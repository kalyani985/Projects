package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import model.Items;

public interface itemsDAO {

	public abstract int createItems(Items item) throws SQLException;

	public abstract Items getItem(String item_id) throws SQLException;

	public abstract ArrayList<Items> SearchByItemTitle(String item_title);

	public abstract ArrayList<Items> SearchByCategory(String item_category);

	public abstract ArrayList<Items> SearchByAuthor(String item_author);

	public abstract int updateItems(Items item) throws SQLException;

	public abstract int deleteItems(String item) throws SQLException;

	public abstract ArrayList<Items> findAllItems1() throws SQLException;
	
	public abstract void updateBStatus(String item_id) throws SQLException;
	
	public abstract void updateItemStatus(String item_id) throws SQLException;
	
    public abstract int deactivateItem (Items item) throws SQLException;
	
	public abstract int updateItems1(Items item) throws SQLException;
	
	public abstract int createItem1(Items item) throws SQLException;
	
	public abstract String nextItemId() throws SQLException;
}
