package com.project.urlshortner.exception;

public class URLPathNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public URLPathNotFoundException(String urlPath) {

		super(String.format("Url does not exist"));
	}
}
