package com.ilan.model.user;

import java.sql.Date;

public class Userdata {
	private String ud_id;
	private String user_id;
	private String name;
	private String email;
	private String cardboxdata;
	private String scenedata;
	private Date create_date;
	private Date update_date;
	private String note;
	private String tag;
	
	
	public String getUd_id() {
		return ud_id;
	}
	public void setUd_id(String ud_id) {
		this.ud_id = ud_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCardboxdata() {
		return cardboxdata;
	}
	public void setCardboxdata(String cardboxdata) {
		this.cardboxdata = cardboxdata;
	}
	public String getScenedata() {
		return scenedata;
	}
	public void setScenedata(String scenedata) {
		this.scenedata = scenedata;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public Date getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	
}
