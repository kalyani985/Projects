package biz;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAOFactory;
import dao.itemsDAO;
import model.Items;
//import model.Transaction;

public class itemManager {

	public Items getItem(String item_id) throws SQLException {
		System.out.println("ID Manager");
		itemsDAO dao = DAOFactory.getitemsDAO();
		System.out.println("1 ID Manager");
		return dao.getItem(item_id);
	}

	public ArrayList<Items> SearchByCategory(String item_category) {
		itemsDAO dao = DAOFactory.getitemsDAO();
		System.out.println("category");
		return dao.SearchByCategory(item_category);
	}

	public int createItems(Items item) throws SQLException {
		itemsDAO dao = DAOFactory.getitemsDAO();
		return dao.createItems(item);
	}

	public ArrayList<Items> SearchByItemTitle(String item_title) {
		itemsDAO dao = DAOFactory.getitemsDAO();
		return dao.SearchByItemTitle(item_title);
	}

	public ArrayList<Items> SearchByAuthor(String item_author) {
		itemsDAO dao = DAOFactory.getitemsDAO();
		return dao.SearchByAuthor(item_author);
	}

	public void updateBStatus(String item_id) throws SQLException {
		itemsDAO dao = DAOFactory.getitemsDAO();
		dao.updateBStatus(item_id);
	}

	public void updateItemStatus(String item_id) throws SQLException {
		itemsDAO dao = DAOFactory.getitemsDAO();
		dao.updateItemStatus(item_id);
	}

	public int updateItems(Items item) throws SQLException {
		itemsDAO dao = DAOFactory.getitemsDAO();
		return dao.updateItems1(item);
	}

	public ArrayList<Items> findAllItems1() throws SQLException {
		itemsDAO dao = DAOFactory.getitemsDAO();
		return dao.findAllItems1();
	}

	public int deactivateItem(Items item) throws SQLException {
		itemsDAO dao = DAOFactory.getitemsDAO();
		return dao.deactivateItem(item);
	}

	public int createItem1(Items item) throws SQLException {
		itemsDAO dao = DAOFactory.getitemsDAO();
		return dao.createItems(item);
	}

	public String generatedNewId() throws SQLException {
		itemsDAO dao = DAOFactory.getitemsDAO();
		return dao.nextItemId();
	}
}
