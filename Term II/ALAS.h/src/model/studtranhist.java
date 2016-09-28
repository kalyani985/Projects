package model;

import java.io.Serializable;
import java.util.Date;

public class studtranhist implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1293668226784571494L;
	
	private String item_id;
	private String item_category;
	private String item_title;
	private Date item_issue_date;
	private Date item_return_date;
	private String item_status;
	private Double trans_fine_amount;
	
	public studtranhist() {
		super();
		// TODO Auto-generated constructor stub
	}

	public studtranhist(String item_id, String item_category, String item_title, Date item_issue_date
			, Date item_return_date, String item_status, Double trans_fine_amount) {
		super();
		this.item_id = item_id;
		this.item_category = item_category;
		this.item_title = item_title;
		this.item_issue_date = item_issue_date;
		this.setItem_return_date(item_return_date);
		this.item_status = item_status;
		this.setTrans_fine_amount(trans_fine_amount);
	}

	public String getItem_id() {
		return item_id;
	}

	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}
	
	public String getItem_category() {
		return item_category;
	}

	public void setItem_category(String item_category) {
		this.item_category = item_category;
	}

	public String getItem_title() {
		return item_title;
	}

	public void setItem_title(String item_title) {
		this.item_title = item_title;
	}

	public Date getItem_issue_date() {
		return item_issue_date;
	}

	public void setItem_issue_date(Date item_issue_date) {
		this.item_issue_date = item_issue_date;
	}

	public Date getItem_return_date() {
		return item_return_date;
	}

	public void setItem_return_date(Date item_return_date) {
		this.item_return_date = item_return_date;
	}

	public String getItem_status() {
		return item_status;
	}

	public void setItem_status(String item_status) {
		this.item_status = item_status;
	}

	public Double getTrans_fine_amount() {
		return trans_fine_amount;
	}

	public void setTrans_fine_amount(Double trans_fine_amount) {
		this.trans_fine_amount = trans_fine_amount;
	}
	
}
