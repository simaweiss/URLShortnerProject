package com.project.urlshortner.service;

import java.util.zip.CRC32;

import org.springframework.stereotype.Component;

@Component
public class TinyURLGenerator {
    
	public String generateUniqPathParam(String fullUrl) {
		CRC32 crc = new CRC32();

		crc.update(fullUrl.getBytes());

		return Long.toHexString(crc.getValue());

	}

}
