package idv.fc.pojo;

import java.sql.Date;
import java.sql.Timestamp;

public class Card {
	private Integer id;// {pk,not null,unique,unsigned,ai}
	private String name;// {not null}
	private String vid;// voicabulary id
	private String uid;// {not null}, user id
	private Date createDate;// {not null}
	private Timestamp lastTime;// 上次使用時間
	private Integer usageCount;// 使用次數
	private Integer examCount;// 測驗次數(亦增加 使用次數)
	private Integer passCount;// 通過測驗 次數
	private String tag;
	private Integer step;// 階段
	private Timestamp stepTime;// 當前階段的時間
	private Vocabulary vocabulary;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Vocabulary getVocabulary() {
		return vocabulary;
	}

	public void setVocabulary(Vocabulary vocabulary) {
		this.vocabulary = vocabulary;
	}

	public Integer getStep() {
		return step;
	}

	public void setStep(Integer step) {
		this.step = step;
	}

	public Timestamp getStepTime() {
		return stepTime;
	}

	public void setStepTime(Timestamp step_time) {
		this.stepTime = step_time;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Integer getExamCount() {
		return examCount;
	}

	public void setExamCount(Integer exam_count) {
		this.examCount = exam_count;
	}

	public Integer getPassCount() {
		return passCount;
	}

	public void setPassCount(Integer pass_count) {
		this.passCount = pass_count;
	}

	public void addPass_count() {
		this.setPassCount(this.getPassCount() + 1);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer cid) {
		this.id = cid;
	}

	public void addUsageCount() {
		this.setUsageCount(this.getUsageCount() + 1);
	}

	public Integer getUsageCount() {
		return usageCount;
	}

	public void setUsageCount(Integer usageCount) {
		this.usageCount = usageCount;
	}

	public Timestamp getLastTime() {
		return lastTime;
	}

	public void setLastTime(Timestamp useTime) {
		this.lastTime = useTime;
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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date create_date) {
		this.createDate = create_date;
	}

	public int hashCode() {
		int prime = 31;
		int res = 7;
		res = res * prime + (this.id == null ? 0 : this.id);
		return res;
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null) {
			return false;
		}

		if (this.getClass() != obj.getClass()) {
			return false;
		}

		Card other = (Card) obj;
		return other.getId().equals(this.getId());

	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", name=" + name + ", vid=" + vid + ", uid="
				+ uid + ", create_date=" + createDate + ", last_time="
				+ lastTime + ", usage_count=" + usageCount + ", exam_count="
				+ examCount + ", pass_count=" + passCount + ", tag=" + tag
				+ ", step=" + step + ", step_time=" + stepTime + ", vocabulary="
				+ vocabulary + "]";
	}

}
