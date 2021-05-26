package com.project.urlshortner.web;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.urlshortner.domain.URLPath;
import com.project.urlshortner.service.URLPathService;

@RestController
@Validated

@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class URLPathController {

	@Autowired
	private URLPathService urlPathService;

	@PostMapping("/urlshortner/")
	public ResponseEntity<?> createOrRetriveTinyUrl(@RequestBody URLPath urlPath) {
		String fullUrl = urlPath.getFullUrl();
		Map<String, Object> body = new LinkedHashMap<>();
		String shortUrl = urlPathService.createNewEtityOrRetrive(fullUrl);
		body.put("shortUrl", shortUrl);
		body.put("status", HttpStatus.OK.value());
		return new ResponseEntity<Object>(body, HttpStatus.OK);
	}

	@GetMapping("/urlshortner/")
	ResponseEntity<?> getFullUrlByShortUrl(@RequestParam(name = "requstparam") String shortUrl) {
		String fullUrl = urlPathService.getFullUrlByShortUrl(shortUrl);
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("fullUrl", fullUrl);
		body.put("status", HttpStatus.OK.value());
		return new ResponseEntity<Object>(body, HttpStatus.OK);
	}

}
	


