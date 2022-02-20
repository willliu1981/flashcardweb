package idv.kwl.model;

import java.sql.Date;
import java.sql.Timestamp;

public class Card {
	private String cid;
	private String name;//not null
	private String vid;
	private Date create_date;//not null
	private Timestamp last_time;// 上次複習時間
	private Integer usage_count;// 複習次數
	private String tag;

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public void addUsageCount() {
		this.setUsage_count(this.getUsage_count() + 1);
	}

	public Integer getUsage_count() {
		return usage_count;
	}

	public void setUsage_count(Integer usageCount) {
		this.usage_count = usageCount;
	}

	public Timestamp getLast_time() {
		return last_time;
	}

	public void setLast_time(Timestamp useTime) {
		this.last_time = useTime;
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
