package idv.kwl.model;

import java.sql.Date;
import java.sql.Timestamp;

public class Card {
	private Integer cid;
	private String name;// not null
	private String vid;
	private Date create_date;// not null
	private Timestamp last_time;// 上次使用時間
	private Integer usage_count;// 使用次數
	private Integer exam_count;// 測驗次數
	private Integer pass_count;// 通過測驗 次數
	private String tag;
	private Integer step;// 階段
	private Timestamp step_time;// 當前階段時間

	public Integer getStep() {
		return step;
	}

	public void setStep(Integer step) {
		this.step = step;
	}

	public Timestamp getStep_time() {
		return step_time;
	}

	public void setStep_time(Timestamp step_time) {
		this.step_time = step_time;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Integer getExam_count() {
		return exam_count;
	}

	public void setExam_count(Integer exam_count) {
		this.exam_count = exam_count;
	}

	public Integer getPass_count() {
		return pass_count;
	}

	public void setPass_count(Integer pass_count) {
		this.pass_count = pass_count;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
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
