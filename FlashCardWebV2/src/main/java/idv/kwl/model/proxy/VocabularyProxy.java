package idv.kwl.model.proxy;

import java.sql.Date;

import idv.kwl.model.Vocabulary;

public class VocabularyProxy {
	private Vocabulary voca;

	public VocabularyProxy(Vocabulary voca) {
		this.voca = voca;
	}

	public VocabularyProxy setVid(String vid) {
		voca.setVid(vid);
		return this;
	}

	public VocabularyProxy setVocabulary(String voca) {
		this.voca.setVocabulary(voca);
		return this;
	}

	public VocabularyProxy setTranslation(String trans) {
		voca.setTranslation(trans);
		return this;
	}

	public VocabularyProxy setCreate_date(Date date) {
		voca.setCreate_date(date);
		return this;
	}
	
	

}
