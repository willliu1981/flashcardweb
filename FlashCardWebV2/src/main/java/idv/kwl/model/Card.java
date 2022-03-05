package idv.kwl.model;

import java.sql.Date;
import java.sql.Timestamp;

import idv.kwl.model.proxy.ICard;

public class Card implements ICard {
	private Integer cid;
	private String name;// not null
	private String vid;// voicabulary id
	private String uid;// user id
	private Date create_date;// not null
	private Timestamp last_time;// 上次使用時間
	private Integer usage_count;// 使用次數
	private Integer exam_count;// 測驗次數
	private Integer pass_count;// 通過測驗 次數
	private String tag;
	private Integer step;// 階段
	private Timestamp step_time;// 當前階段時間

	@Override
	public String getUid() {
		return uid;
	}

	@Override
	public void setUid(String uid) {
		this.uid = uid;
	}

	@Override
	public Integer getStep() {
		return step;
	}

	@Override
	public void setStep(Integer step) {
		this.step = step;
	}

	@Override
	public Timestamp getStep_time() {
		return step_time;
	}

	@Override
	public void setStep_time(Timestamp step_time) {
		this.step_time = step_time;
	}

	@Override
	public String getTag() {
		return tag;
	}

	@Override
	public void setTag(String tag) {
		this.tag = tag;
	}

	@Override
	public Integer getExam_count() {
		return exam_count;
	}

	@Override
	public void setExam_count(Integer exam_count) {
		this.exam_count = exam_count;
	}

	@Override
	public Integer getPass_count() {
		return pass_count;
	}

	@Override
	public void setPass_count(Integer pass_count) {
		this.pass_count = pass_count;
	}

	@Override
	public Integer getCid() {
		return cid;
	}

	@Override
	public void setCid(Integer cid) {
		this.cid = cid;
	}

	@Override
	public void addUsageCount() {
		this.setUsage_count(this.getUsage_count() + 1);
	}

	@Override
	public Integer getUsage_count() {
		return usage_count;
	}

	@Override
	public void setUsage_count(Integer usageCount) {
		this.usage_count = usageCount;
	}

	@Override
	public Timestamp getLast_time() {
		return last_time;
	}

	@Override
	public void setLast_time(Timestamp useTime) {
		this.last_time = useTime;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getVid() {
		return vid;
	}

	@Override
	public void setVid(String vid) {
		this.vid = vid;
	}

	@Override
	public Date getCreate_date() {
		return create_date;
	}

	@Override
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	@Override
	public String toString() {
		return "Card [cid=" + cid + ", name=" + name + ", vid=" + vid + ", uid=" + uid
				+ ", create_date=" + create_date + ", last_time=" + last_time
				+ ", usage_count=" + usage_count + ", exam_count=" + exam_count
				+ ", pass_count=" + pass_count + ", tag=" + tag + ", step=" + step
				+ ", step_time=" + step_time + "]";
	}

}
