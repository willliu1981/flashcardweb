package idv.kwl.model.proxy;

import java.sql.Date;

import idv.kwl.dao.IDao;
import idv.kwl.model.Vocabulary;

public class VocabularyProxy implements IVocabulary {
	private Vocabulary voca;

	public VocabularyProxy(Vocabulary voca) {
		this.voca = voca;
	}

	@Override
	public String getTag() {
		// TODO Auto-generated method stub
		return voca.getTag();
	}

	@Override
	public void setTag(String tag) {
		// TODO Auto-generated method stub
		this.voca.setTag(tag);
	}

	public VocabularyProxy tag(String tag) {
		this.setTag(tag);
		return this;
	}

	@Override
	public String getVid() {
		// TODO Auto-generated method stub
		return this.voca.getVid();
	}

	@Override
	public void setVid(String vid) {
		// TODO Auto-generated method stub
		this.voca.setVid(vid);
	}

	public VocabularyProxy vid(String vid) {
		this.setVid(vid);
		return this;
	}

	@Override
	public String getVocabulary() {
		// TODO Auto-generated method stub
		return this.voca.getVocabulary();
	}

	@Override
	public void setVocabulary(String vocabulary) {
		// TODO Auto-generated method stub
		this.voca.setVocabulary(vocabulary);
	}

	public VocabularyProxy vocabulary(String vocabulary) {
		this.setVocabulary(vocabulary);
		return this;
	}

	@Override
	public String getTranslation() {
		// TODO Auto-generated method stub
		return this.voca.getTranslation();
	}

	@Override
	public void setTranslation(String translation) {
		// TODO Auto-generated method stub
		this.voca.setTranslation(translation);
	}

	public VocabularyProxy translation(String translation) {
		this.setTranslation(translation);
		return this;
	}

	@Override
	public Date getCreate_date() {
		// TODO Auto-generated method stub
		return this.voca.getCreate_date();
	}

	@Override
	public void setCreate_date(Date create_date) {
		// TODO Auto-generated method stub
		this.voca.setCreate_date(create_date);
	}

	public VocabularyProxy create_date(Date create_date) {
		this.setCreate_date(create_date);
		return this;
	}

	public void create(IDao dao) {
		dao.create(this.voca);
	}

	public void update(IDao dao, Object id) {
		System.out.println(this.getClass() + ": " + this.voca);
		System.out.println(this.getClass() + ": " + dao);
		dao.update(this.voca, id);
	}
}
