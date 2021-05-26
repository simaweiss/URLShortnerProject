package com.project.urlshortner.exception;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@ControllerAdvice
public class URLPathExceptionController {

	@ExceptionHandler(value = URLPathNotFoundException.class)
	public ResponseEntity<Object> handleURLPathNotFoundException(URLPathNotFoundException ex) {

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("status", HttpStatus.NOT_FOUND.value());
		body.put("message", ex.getMessage());

		return new ResponseEntity<Object>(body, HttpStatus.NOT_FOUND);
	}

}
