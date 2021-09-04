package com.ilan.control.connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.ilan.model.user.User;

public class MyDataSource extends DriverManagerDataSource {
	@Autowired
	MyDataSource dataSource;

	@Autowired
	private Book book;

	@Autowired
	private User user;

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = (MyDataSource) dataSource;
	}

	public String getMsg() {
		return "ds bname:" + dataSource.getBook().getName() + " ,book name:" + book.getName() + " ,user:"
				+ this.user.getDisplayName() + " ,author:" + book.getUser().getDisplayName();
	}

}
