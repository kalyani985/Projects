package model;

import java.io.Serializable;

public class user implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3973688966275159341L;
	
	private String user_id;
	private String user_name;
	private String user_password;
	private String user_gender;
	private String user_address;
	private int user_contact;
	private String user_status;
	private String user_type;
	
	
	public user() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public user(String user_id, String user_name, String user_password, String user_gender, String user_address,
			int user_contact, String user_status, String user_type) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_password = user_password;
		this.user_gender = user_gender;
		this.user_address = user_address;
		this.user_contact = user_contact;
		this.user_status = user_status;
		this.user_type = user_type;
		
	
	}
	


	public user(String user_id, String user_name, String user_gender, String user_address, int user_contact,
			String user_status) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_gender = user_gender;
		this.user_address = user_address;
		this.user_contact = user_contact;
		this.user_status = user_status;
	}


	

	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public String getUser_password() {
		return user_password;
	}


	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}


	public String getUser_gender() {
		return user_gender;
	}


	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}


	public String getUser_address() {
		return user_address;
	}


	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}


	public int getUser_contact() {
		return user_contact;
	}


	public void setUser_contact(int user_contact) {
		this.user_contact = user_contact;
	}


	public String getUser_status() {
		return user_status;
	}


	public void setUser_status(String user_status) {
		this.user_status = user_status;
	}


	public String getUser_type() {
		return user_type;
	}


	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}


	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user_address == null) ? 0 : user_address.hashCode());
		result = prime * result + user_contact;
		result = prime * result + ((user_gender == null) ? 0 : user_gender.hashCode());
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
		result = prime * result + ((user_name == null) ? 0 : user_name.hashCode());
		result = prime * result + ((user_password == null) ? 0 : user_password.hashCode());
		result = prime * result + ((user_status == null) ? 0 : user_status.hashCode());
		result = prime * result + ((user_type == null) ? 0 : user_type.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		user other = (user) obj;
		if (user_address == null) {
			if (other.user_address != null)
				return false;
		} else if (!user_address.equals(other.user_address))
			return false;
		if (user_contact != other.user_contact)
			return false;
		if (user_gender == null) {
			if (other.user_gender != null)
				return false;
		} else if (!user_gender.equals(other.user_gender))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		if (user_name == null) {
			if (other.user_name != null)
				return false;
		} else if (!user_name.equals(other.user_name))
			return false;
		if (user_password == null) {
			if (other.user_password != null)
				return false;
		} else if (!user_password.equals(other.user_password))
			return false;
		if (user_status == null) {
			if (other.user_status != null)
				return false;
		} else if (!user_status.equals(other.user_status))
			return false;
		if (user_type == null) {
			if (other.user_type != null)
				return false;
		} else if (!user_type.equals(other.user_type))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "user [user_id=" + user_id + ", user_name=" + user_name + ", user_password=" + user_password
				+ ", user_gender=" + user_gender + ", user_address=" + user_address + ", user_contact=" + user_contact
				+ ", user_status=" + user_status + ", user_type=" + user_type + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}
