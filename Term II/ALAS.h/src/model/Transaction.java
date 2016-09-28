package model;

import java.util.Date;

public class Transaction {
	private int  trans_id ;
	public Transaction(int trans_id, String user_id, String item_id, String trans_details, Date item_issue_date,
			Date item_due_date, Date item_return_date, double trans_fine_amount) {
		super();
		this.trans_id = trans_id;
		this.user_id = user_id;
		this.item_id = item_id;
		this.trans_details = trans_details;
		this.item_issue_date = item_issue_date;
		this.item_due_date = item_due_date;
		this.item_return_date = item_return_date;
		this.trans_fine_amount = trans_fine_amount;
		
	}

	private String user_id;
	private String item_id;
	private String trans_details;
	
	@Override
	public String toString() {
		return "Transaction [trans_id=" + trans_id + ", user_id=" + user_id + ", item_id=" + item_id
				+ ", trans_details=" + trans_details + ", item_issue_date=" + item_issue_date + ", item_due_date="
				+ item_due_date + ", item_return_date=" + item_return_date + ", trans_fine_amount=" + trans_fine_amount
				+ "]";
	}

	private Date item_issue_date;
	private Date item_due_date;
	private Date item_return_date;
	private double trans_fine_amount;

	public int getTrans_id() {
		return trans_id;
	}

	public void setTrans_id(int trans_id) {
		this.trans_id = trans_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getItem_id() {
		return item_id;
	}

	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}

	public String getTrans_details() {
		return trans_details;
	}

	public void setTrans_details(String trans_details) {
		this.trans_details = trans_details;
	}

	public Date getItem_issue_date() {
		return item_issue_date;
	}

	public void setItem_issue_date(Date item_issue_date) {
		this.item_issue_date = item_issue_date;
	}

	public Date getItem_due_date() {
		return item_due_date;
	}

	public void setItem_due_date(Date item_due_date) {
		this.item_due_date = item_due_date;
	}

	public Date getItem_return_date() {
		return item_return_date;
	}

	public void setItem_return_date(Date item_return_date) {
		this.item_return_date = item_return_date;
	}

	public double getTrans_fine_amount() {
		return trans_fine_amount;
	}

	public void setTrans_fine_amount(double trans_fine_amount) {
		this.trans_fine_amount = trans_fine_amount;
	}

	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	

}
