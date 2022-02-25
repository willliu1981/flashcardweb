package idv.kwl.model;

import java.sql.Date;

import idv.kwl.model.proxy.IVocabulary;

public class Vocabulary implements IVocabulary {
	private String vid;
	private String vocabulary;//not null, unique
	private String translation;//not null
	private Date create_date;//not null
	private String tag;

	@Override
	public String getTag() {
		return tag;
	}

	@Override
	public void setTag(String tag) {
		this.tag = tag;
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
	public String getVocabulary() {
		return vocabulary;
	}

	@Override
	public void setVocabulary(String vocabulary) {
		this.vocabulary = vocabulary;
	}

	@Override
	public String getTranslation() {
		return translation;
	}

	@Override
	public void setTranslation(String translation) {
		this.translation = translation;
	}

	@Override
	public Date getCreate_date() {
		return create_date;
	}

	@Override
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

}
