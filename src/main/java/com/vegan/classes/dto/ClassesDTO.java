package com.vegan.classes.dto;

import java.sql.Date;

public class ClassesDTO {
	
	private int cl_id;
	private String user_id;
	private String cl_subject;
	private String cl_period;
	private String cl_deadlinePeriod;
	private int cl_deadline;
	private String cl_teacher;
	private String cl_date;
	private int cl_ing_chk;


	private int cl_status;
	private String postcode;
	private String address;
	private String detailAddress;
	private String extraAddress;
	private String cl_content;
	private boolean cl_del_chk;
	private String user_adress;
	private String user_name;
	private String user_phone;
	private String user_email;
	private String cl_part_id;
	private String photo_name;
	private int idx;
	private int join_count;

//	댓글관련
	  private int review_id;
	   private Date date;
	   private String content;
	   
	
	

	public int getReview_id() {
		return review_id;
	}
	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getJoin_count() {
		return join_count;
	}
	public void setJoin_count(int join_count) {
		this.join_count = join_count;
	}

	

	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getPhoto_name() {
		return photo_name;
	}
	public void setPhoto_name(String photo_name) {
		this.photo_name = photo_name;

	}
	public int getCl_id() {
		return cl_id;
	}
	public void setCl_id(int cl_id) {
		this.cl_id = cl_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getCl_subject() {
		return cl_subject;
	}
	public void setCl_subject(String cl_subject) {
		this.cl_subject = cl_subject;
	}
	public String getCl_period() {
		return cl_period;
	}
	public void setCl_period(String cl_period) {
		this.cl_period = cl_period;
	}
	
	public String getCl_deadlinePeriod() {
		return cl_deadlinePeriod;
	}
	public void setCl_deadlinePeriod(String cl_deadlinePeriod) {
		this.cl_deadlinePeriod = cl_deadlinePeriod;
	}
	public int getCl_deadline() {
		return cl_deadline;
	}
	public void setCl_deadline(int cl_deadline) {
		this.cl_deadline = cl_deadline;
	}
	public String getCl_teacher() {
		return cl_teacher;
	}
	public void setCl_teacher(String cl_teacher) {
		this.cl_teacher = cl_teacher;
	}
	public String getCl_date() {
		return cl_date;
	}
	public void setCl_date(String cl_date) {
		this.cl_date = cl_date;
	}


	public int getCl_ing_chk() {
		return cl_ing_chk;
	}
	public void setCl_ing_chk(int cl_ing_chk) {
		this.cl_ing_chk = cl_ing_chk;
	}

	public int getCl_status() {
		return cl_status;
	}
	public void setCl_status(int cl_status) {
		this.cl_status = cl_status;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDetailAddress() {
		return detailAddress;
	}
	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
	public String getExtraAddress() {
		return extraAddress;
	}
	public void setExtraAddress(String extraAddress) {
		this.extraAddress = extraAddress;
	}
	public String getCl_content() {
		return cl_content;
	}
	public void setCl_content(String cl_content) {
		this.cl_content = cl_content;
	}
	public boolean isCl_del_chk() {
		return cl_del_chk;
	}
	public void setCl_del_chk(boolean cl_del_chk) {
		this.cl_del_chk = cl_del_chk;
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
	public String getUser_adress() {
		return user_adress;
	}
	public void setUser_adress(String user_adress) {
		this.user_adress = user_adress;
	}
	public String getCl_part_id() {
		return cl_part_id;
	}
	public void setCl_part_id(String cl_part_id) {
		this.cl_part_id = cl_part_id;
	}



}