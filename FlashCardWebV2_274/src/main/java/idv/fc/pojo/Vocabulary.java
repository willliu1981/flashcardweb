package idv.fc.pojo;

import java.sql.Date;
import java.util.List;

public class Vocabulary {
	private String id;// {pk,not null,unique}
	private String vocabulary;// not null, unique
	private String translation;// not null
	private Date createDate;// not null
	private String tag;

	private List<Card> cards;

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getId() {
		return id;
	}

	public void setId(String vid) {
		this.id = vid;
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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date create_date) {
		this.createDate = create_date;
	}

	@Override
	public String toString() {
		return "Vocabulary [id=" + id + ", vocabulary=" + vocabulary
				+ ", translation=" + translation + ", createDate=" + createDate
				+ ", tag=" + tag + ", cards=" + cards + "]";
	}

}
