package com.vegan.admin.dto;

public class AdminDTO {
	
	private String user_id;
	private String user_name;
	private String user_phone;
	private String user_email;
	private boolean user_admin_chk;
	private boolean user_secc_chk;
	
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
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public boolean isUser_admin_chk() {
		return user_admin_chk;
	}
	public void setUser_admin_chk(boolean user_admin_chk) {
		this.user_admin_chk = user_admin_chk;
	}
	public boolean isUser_secc_chk() {
		return user_secc_chk;
	}
	public void setUser_secc_chk(boolean user_secc_chk) {
		this.user_secc_chk = user_secc_chk;
	}

}
