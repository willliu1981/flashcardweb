package com.flashcard.application.config;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class FactoryConfig {
	private String xmlRootReferer;
	private Set<String> beansXmlRefererSet = new HashSet<>();
	private String[] beansXmlReferers;

	public void setXmlRootReferer(String xmlRootReferer) {
		this.xmlRootReferer = xmlRootReferer;
	}

	public String getXmlRootReferer() {
		return String.format("%s/", xmlRootReferer);
	}

	public void setAddBeansXmlReferer(Set<String> beansXmlRefererSet) {
		this.beansXmlRefererSet = beansXmlRefererSet;
	}

	private String[] processBeansXmlReferers() {
		String[] referers = new String[beansXmlRefererSet.size()];
		this.beansXmlRefererSet.toArray(referers);

		Iterator<String> it = beansXmlRefererSet.iterator();
		int p = 0;
		while (it.hasNext()) {
			String str = it.next();
			if (str.startsWith("/")) {
				referers[p] = str.substring(1, str.length() - 1);
			} else {
				referers[p] = xmlRootReferer + "/" + str;
			}
			p++;
		}
		return referers;
	}

	public String[] getBeansXmlReferers() {
		return beansXmlReferers;
	}

	public void init() {
		if (this.beansXmlReferers == null) {
			this.beansXmlReferers = this.processBeansXmlReferers();
		}
	}
}
