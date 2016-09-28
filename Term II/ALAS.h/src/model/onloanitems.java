package model;

import java.io.Serializable;
import java.util.Date;

public class onloanitems implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 551940780037365765L;
	
	private String item_id;
	private String item_title;
	private String item_category;
	private String item_status;
	private Date item_due_date;
	
	private int trans_id;
	private String trans_details;
	
	public onloanitems() {
		super();
		// TODO Auto-generated constructor stub
	}

	public onloanitems(String item_id, String item_title, String item_category, String item_status,
			Date item_due_date, int trans_id, String trans_details) {
		super();
		this.item_id = item_id;
		this.item_title = item_title;
		this.item_category = item_category;
		this.item_status = item_status;
		this.item_due_date = item_due_date;
		this.trans_id = trans_id;
		this.trans_details = trans_details;
	}

	public String getItem_id() {
		return item_id;
	}

	public String getItem_title() {
		return item_title;
	}

	public void setItem_title(String item_title) {
		this.item_title = item_title;
	}

	public String getItem_category() {
		return item_category;
	}

	public void setItem_category(String item_category) {
		this.item_category = item_category;
	}

	public String getItem_status() {
		return item_status;
	}

	public void setItem_status(String item_status) {
		this.item_status = item_status;
	}

	public Date getItem_due_date() {
		return item_due_date;
	}

	public void setItem_due_date(Date item_due_date) {
		this.item_due_date = item_due_date;
	}

	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}
	
	public int getTrans_id() {
		return trans_id;
	}

	public void setTrans_id(int trans_id) {
		this.trans_id = trans_id;
	}

	public String getTrans_details() {
		return trans_details;
	}

	public void setTrans_details(String trans_details) {
		this.trans_details = trans_details;
	}
	
}
