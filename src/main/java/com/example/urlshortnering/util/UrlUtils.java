package com.example.urlshortnering.util;

import java.security.SecureRandom;

import org.springframework.stereotype.Service;

@Service
public class UrlUtils {

	 	public static final String SECRET_KEY = "Dm1Ld0jAn2MavkBo3NbwlCp4OcxJEq5PeyKGs7RgTXFr6QfzWp4OcxJHt8ShUYIu9iVZ";
	    public static final int BASE = SECRET_KEY.length();
	    private static final SecureRandom random = new SecureRandom();
	    private static final int SEGMENT_LENGTH = 4; // Length of each segment
	    private static final int NUMBER_OF_SEGMENTS = 4; // Number of segments in the short URL

	  
	    public static String generateShortUrl(int length) {
	    	System.out.println("Inside getUrlShort method");

	        StringBuilder sb = new StringBuilder(length);
	        for (int i = 0; i < length; i++) {
	            sb.append(SECRET_KEY.charAt(random.nextInt(BASE)));
	        }
	       
	        return sb.toString();
	    }

	    // Generate a short URL consisting of multiple segments
//	    public static String generateShortUrl() {
//	        StringBuilder shortUrl = new StringBuilder();
//	        for (int i = 0; i < NUMBER_OF_SEGMENTS; i++) {
//	            if (i > 0) {
//	                shortUrl.append("-"); // Use a hyphen as a separator
//	            }
//	            shortUrl.append(generateRandomString(SEGMENT_LENGTH));
//	        }
//	        System.out.println(shortUrl.toString());
//	        return shortUrl.toString();
//	    }

}
