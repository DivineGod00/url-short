package com.example.urlshortnering.controller;

import java.net.URI;

import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.urlshortnering.dto.FullUrlDto;
import com.example.urlshortnering.service.CacheInspectionService;
import com.example.urlshortnering.service.UrlService;
import com.example.urlshortnering.wrapper.ClientResponse;
import com.example.urlshortnering.wrapper.Constants;
import com.example.urlshortnering.wrapper.StatusCode;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/url-shortner")
public class UrlController {
	
	@Autowired
	private UrlService urlService;
	
	@Autowired
	private CacheInspectionService cacheInspectionService;
	
	@PostMapping
	public ClientResponse getUrlShortner(@RequestBody FullUrlDto fullUrl , HttpServletRequest request) throws Exception
	{
		UrlValidator validator = new UrlValidator(new String[] {"http", "https"});
		String url = fullUrl.getFullUrl();
		if(!validator.isValid(url))
		{
			return ClientResponse.builder().data(null).status("Failure").statusCode(StatusCode.BAD_REQUEST).message(Constants.INVALID_URL_FORMAT).build();
		}
		return urlService.getUrlShort(fullUrl,request);
	}

	@GetMapping
	public ResponseEntity<Void> getUrlShortner(@RequestParam(name = "shortUrl") String shortUrl , HttpServletRequest request) throws Exception
	{
		
		String longUrl = urlService.getLongUrl(shortUrl,request);
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(longUrl))
                .build();
				
	}
	
	@GetMapping("/cacheData")
    public void getCacheDate() {
        cacheInspectionService.printCacheContents("url-shortner");
    }
}
