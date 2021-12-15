package com.app.AdminPanel.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="AdminData")
public class Admin {
	
	
	public Admin() {
	}
	@Id
	private int adminid;
	private String adminname;
	private String emailid;
	private long mobilenumber;
	public Admin(int adminid, String adminname, String emailid, long mobilenumber) {
		super();
		this.adminid = adminid;
		this.adminname = adminname;
		this.emailid = emailid;
		this.mobilenumber = mobilenumber;
	}
	public int getAdminid() {
		return adminid;
	}
	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public long getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	@Override
	public String toString() {
		return "Admin [adminid=" + adminid + ", adminname=" + adminname + ", emailid=" + emailid + ", mobilenumber="
				+ mobilenumber + "]";
	}
	
}
	