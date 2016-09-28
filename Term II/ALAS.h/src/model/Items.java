package model;
import java.io.Serializable;
//import java.sql.SQLException;
//import java.time.Year;
import java.util.Date;
public class Items implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String item_id;
	  
	@Override
	public String toString() {
		return "Items [item_id=" + item_id + ", item_title=" + item_title + ", item_author=" + item_author
				+ ", item_publisher=" + item_publisher + ", item_published_year=" + item_published_year + ", item_ISBN=" + item_ISBN + ", item_status="
				+ item_status + ",item_date_of_purchase=" + item_date_of_purchase
				+ ", item_category=" + item_category + ", item_description=" + item_description + "]";
	}

	private String item_title,item_author,item_publisher;
    private Date item_date_of_purchase;
    private int item_published_year;
    private String item_ISBN,item_status,item_category,item_description;
	
   	public String getItem_id() {
		return item_id;
	}

	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}
	public String getItem_title() {
		return item_title;
	}
	public void setItem_title(String item_title) {
		this.item_title = item_title;
	}
	public String getItem_author() {
		return item_author;
	}
	public void setItem_author(String item_author) {
		this.item_author = item_author;
	}
	public String getItem_publisher() {
		return item_publisher;
	}
	public void setItem_publisher(String item_publisher) {
		this.item_publisher = item_publisher;
	}
	public int getItem_published_year() {
		return item_published_year;
	}
	public void setItem_published_year(int item_published_year) {
		this.item_published_year =  item_published_year;
	}
	public Date getItem_date_of_purchase() {
		return item_date_of_purchase;
	}
	public void setItem_date_of_purchase(Date item_date_of_purchase) {
		this.item_date_of_purchase = item_date_of_purchase;
	}
	public String getItem_ISBN() {
		return item_ISBN;
	}
	public void setItem_ISBN(String item_ISBN) {
		this.item_ISBN = item_ISBN;
	}
	public String getItem_status() {
		return item_status;
	}
	public void setItem_status(String item_status) {
		this.item_status = item_status;
	}
	public String getItem_category() {
		return item_category;
	}
	public void setItem_category(String item_category) {
		this.item_category = item_category;
	}
	public String getItem_description() {
		return item_description;
	}
	public void setItem_description(String item_description) {
		this.item_description = item_description;
	}

	public Items(String item_id, String item_title, String item_author, String item_publisher,
			 int year, String item_ISBN, String item_status,Date item_date_of_purchase,
			String item_category, String item_description)  {
	
		super();
		this.item_id = item_id;
		this.item_title = item_title;
		this.item_author = item_author;
		this.item_publisher = item_publisher;
		this.item_date_of_purchase = item_date_of_purchase;
		this.item_published_year = year;
		this.item_ISBN = item_ISBN;
		this.item_status = item_status;
		this.item_category = item_category;
		this.item_description = item_description;
	}

	public Items() {
		
	}

	public Items(String string, String string2, String string3, String string4, String string5) {
		// TODO Auto-generated constructor stub
	}

	

		

}

	
	