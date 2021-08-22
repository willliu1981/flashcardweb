package com.ilan.model.words;

import java.sql.Date;

public class Card {
private String c_id;
private String word_id;
private String name;
private Integer referred;
private Date create_date;
private Date update_date;
private String creator;
private String note;
private String tag;
public String getC_id() {
	return c_id;
}
public void setC_id(String c_id) {
	this.c_id = c_id;
}
public String getWord_id() {
	return word_id;
}
public void setWord_id(String word_id) {
	this.word_id = word_id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Integer getReferred() {
	return referred;
}
public void setReferred(Integer referred) {
	this.referred = referred;
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
public String getCreator() {
	return creator;
}
public void setCreator(String creator) {
	this.creator = creator;
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
