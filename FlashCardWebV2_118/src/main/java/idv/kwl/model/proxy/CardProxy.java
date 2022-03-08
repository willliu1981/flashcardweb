package idv.kwl.model.proxy;

import java.sql.Date;
import java.sql.Timestamp;

import idv.fc.model.Card;

public class CardProxy implements ICard {
	private Card card;
	private boolean isLast = false;
	private String vocabulary;
	private String translation;

	public CardProxy(Card card) {
		this.card = card;
	}

	public String getVocabulary() {
		return vocabulary;
	}

	public void setVocabulary(String vocabulary) {
		this.vocabulary = vocabulary;
	}

	public String getTranslation() {
		return translation;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}

	public boolean getIsLast() {
		return isLast;
	}

	public void setIsLast() {
		this.isLast = true;
	}

	@Override
	public String getUid() {
		// TODO Auto-generated method stub
		return this.card.getUid();
	}

	@Override
	public void setUid(String uid) {
		// TODO Auto-generated method stub
		this.card.setUid(uid);
	}

	@Override
	public Integer getStep() {
		// TODO Auto-generated method stub
		return this.card.getStep();
	}

	@Override
	public void setStep(Integer step) {
		// TODO Auto-generated method stub
		this.card.setStep(step);
	}

	@Override
	public Timestamp getStep_time() {
		// TODO Auto-generated method stub
		return this.card.getStep_time();
	}

	@Override
	public void setStep_time(Timestamp step_time) {
		// TODO Auto-generated method stub
		this.card.setStep_time(step_time);
	}

	@Override
	public String getTag() {
		// TODO Auto-generated method stub
		return this.card.getTag();
	}

	@Override
	public void setTag(String tag) {
		// TODO Auto-generated method stub
		this.card.setTag(tag);
	}

	@Override
	public Integer getExam_count() {
		// TODO Auto-generated method stub
		return this.card.getExam_count();
	}

	@Override
	public void setExam_count(Integer exam_count) {
		// TODO Auto-generated method stub
		this.card.setExam_count(exam_count);
	}

	@Override
	public Integer getPass_count() {
		// TODO Auto-generated method stub
		return this.card.getPass_count();
	}

	@Override
	public void setPass_count(Integer pass_count) {
		// TODO Auto-generated method stub
		this.card.setPass_count(pass_count);
	}

	@Override
	public Integer getCid() {
		// TODO Auto-generated method stub
		return this.card.getId();
	}

	@Override
	public void setCid(Integer cid) {
		// TODO Auto-generated method stub
		this.card.setId(cid);
	}

	@Override
	public void addUsageCount() {
		// TODO Auto-generated method stub
		this.card.addUsageCount();
	}

	@Override
	public Integer getUsage_count() {
		// TODO Auto-generated method stub
		return this.card.getUsage_count();
	}

	@Override
	public void setUsage_count(Integer usageCount) {
		// TODO Auto-generated method stub

	}

	@Override
	public Timestamp getLast_time() {
		// TODO Auto-generated method stub
		return this.card.getLast_time();
	}

	@Override
	public void setLast_time(Timestamp useTime) {
		// TODO Auto-generated method stub
		this.card.setLast_time(useTime);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.card.getName();
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.card.setName(name);
	}

	@Override
	public String getVid() {
		// TODO Auto-generated method stub
		return this.card.getVid();
	}

	@Override
	public void setVid(String vid) {
		// TODO Auto-generated method stub
		this.card.setVid(vid);
	}

	@Override
	public Date getCreate_date() {
		// TODO Auto-generated method stub
		return this.card.getCreate_date();
	}

	@Override
	public void setCreate_date(Date create_date) {
		// TODO Auto-generated method stub
		this.card.setCreate_date(create_date);
	}

	@Override
	public String toString() {
		return "CardProxy [card=" + card + "]";
	}

}
