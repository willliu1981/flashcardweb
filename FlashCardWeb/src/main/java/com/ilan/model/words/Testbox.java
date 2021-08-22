package com.ilan.model.words;

import java.sql.Date;

public class Testbox {
	private String t_id;
	private String name;
	private Integer testtimes;
	private String testdate;
	private Integer state=0;
	private Date create_date;
	private Date update_date;
	private String creator;
	private String note;
	private String tag;
	private String cards;

	public String getT_id() {
		return t_id;
	}

	public void setT_id(String t_id) {
		this.t_id = t_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getTesttimes() {
		return testtimes;
	}

	public void setTesttimes(Integer testtimes) {
		this.testtimes = testtimes;
	}

	public String getTestdate() {
		return testdate;
	}

	public void setTestdate(String testdate) {
		this.testdate = testdate;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
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

	public String getCards() {
		return cards;
	}

	public void setCards(String cards) {
		this.cards = cards;
	}

}
