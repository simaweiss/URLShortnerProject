package com.project.urlshortner.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class URLPath {

	@Id
	private String shortUrl;

	private String fullUrl;

	public URLPath() {

	}

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	public String getFullUrl() {
		return fullUrl;
	}

	public void setFullUrl(String fullUrl) {
		this.fullUrl = fullUrl;
	}

}
