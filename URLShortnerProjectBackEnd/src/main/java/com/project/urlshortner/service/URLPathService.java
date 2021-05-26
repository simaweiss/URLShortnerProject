package com.project.urlshortner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.urlshortner.domain.URLPath;
import com.project.urlshortner.exception.URLPathNotFoundException;
import com.project.urlshortner.repository.URLPathRepository;

@Service
public class URLPathService {

	private String urlShortnerHost = "www.MyURLShortner.com/";

	@Autowired
	private URLPathRepository urlPathRepository;

	@Autowired
	private TinyURLGenerator urlGenerator;

	public String createNewEtityOrRetrive(String urlPath) {
		String shortUrl;

		if (!urlPathRepository.existsURLPathByfullUrl(urlPath)) {
			URLPath entityUrlPath = new URLPath();
			entityUrlPath.setFullUrl(urlPath);
			String uniqPathParam = urlGenerator.generateUniqPathParam(urlPath);
			shortUrl = urlShortnerHost + uniqPathParam;
			entityUrlPath.setShortUrl(shortUrl);
			urlPathRepository.save(entityUrlPath);
		} else {
			shortUrl = urlPathRepository.findShortUrlByFullUrlParam(urlPath);
		}

		return shortUrl;
	}

	public String getFullUrlByShortUrl(String shortUrl) {
		if (!urlPathRepository.existsById(shortUrl)) {
			throw new URLPathNotFoundException(shortUrl);
		}

		String fullUrl = urlPathRepository.findfullUrlByShortlUrlParam(shortUrl);

		return fullUrl;

	}

	public boolean fullUrlExist(String shortUrl) {
		return urlPathRepository.existsById(shortUrl);
	}

}

