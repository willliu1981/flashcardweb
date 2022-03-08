package idv.fc.model.proxy;

import java.sql.Date;
import java.sql.Timestamp;

public interface ICard {

	String getUid();

	void setUid(String uid);

	Integer getStep();

	void setStep(Integer step);

	Timestamp getStep_time();

	void setStep_time(Timestamp step_time);

	String getTag();

	void setTag(String tag);

	Integer getExam_count();

	void setExam_count(Integer exam_count);

	Integer getPass_count();

	void setPass_count(Integer pass_count);

	Integer getCid();

	void setCid(Integer cid);

	void addUsageCount();

	Integer getUsage_count();

	void setUsage_count(Integer usageCount);

	Timestamp getLast_time();

	void setLast_time(Timestamp useTime);

	String getName();

	void setName(String name);

	String getVid();

	void setVid(String vid);

	Date getCreate_date();

	void setCreate_date(Date create_date);

}