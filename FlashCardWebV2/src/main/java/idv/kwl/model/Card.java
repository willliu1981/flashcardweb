package idv.kwl.model;

import java.sql.Date;

public class Card {
private String cid;
private String name;
private String vid;
private  Date create_date;
public String getCid() {
	return cid;
}
public void setCid(String cid) {
	this.cid = cid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getVid() {
	return vid;
}
public void setVid(String vid) {
	this.vid = vid;
}
public Date getCreate_date() {
	return create_date;
}
public void setCreate_date(Date create_date) {
	this.create_date = create_date;
}


}
