package com.example.urlshortnering.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.urlshortnering.dao.NoSqlUrlRepo;
import com.example.urlshortnering.dao.UrlSqlRepo;
import com.example.urlshortnering.dto.FullUrlDto;
import com.example.urlshortnering.dto.ShortUrlDto;
import com.example.urlshortnering.model.UrlNoSQL;
import com.example.urlshortnering.model.UrlSql;
import com.example.urlshortnering.util.ShortUrlUtil;
import com.example.urlshortnering.util.UrlUtils;
import com.example.urlshortnering.wrapper.ClientResponse;
import com.example.urlshortnering.wrapper.Constants;
import com.example.urlshortnering.wrapper.StatusCode;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class UrlService {

	@Autowired
	private UrlSqlRepo urlSqlRepo;
	
	@Autowired
	private UrlUtils urlUtil; 
	
	@Autowired
	private ShortUrlUtil baseUrl;
	
	@Autowired
	private NoSqlUrlRepo noSqlRepo;
	
	private static final int SHORT_LENGTH = 6; 
	
	
	
	public ClientResponse getUrlShort(FullUrlDto request,HttpServletRequest httpRequest)throws Exception
	{
		
		String shortUrl ; 
		Map<String,String> data = new HashMap<>();
		
		Optional<UrlSql> existingUrl = urlSqlRepo.findByLongUrl(request.getFullUrl());
		if(existingUrl.isPresent())
		{
			shortUrl = httpRequest.getRequestURL().toString()+"?shortUrl="+existingUrl.get().getShortUrl();
			data.put("shortUrl",shortUrl);
			return ClientResponse.builder().data(data).status("Success").statusCode(StatusCode.FOUND).message(Constants.SUCCESS_REDIRECT).build();	
		}
		UrlSql urlSql = new UrlSql();
		urlSql.setLongUrl(request.getFullUrl());
		urlSqlRepo.save(urlSql);
	
		String encodedUrl = urlUtil.generateShortUrl(SHORT_LENGTH);
		shortUrl = httpRequest.getRequestURL().toString()+"?shortUrl="+encodedUrl;
		data.put("shortUrl",shortUrl);
		ShortUrlDto shortUrlDto = new ShortUrlDto();
		shortUrlDto.setShortUrl(encodedUrl);
		urlSql.setShortUrl(shortUrlDto.getShortUrl());
		saveDataInMongo(urlSql);
		urlSqlRepo.save(urlSql);
		
		
		
		return ClientResponse.builder().data(data).status("Success").statusCode(StatusCode.CREATED).message(Constants.SUCCESS).build();
	}
	
	@Cacheable(value="url-shortner", key="#request")
	public String getLongUrl(String request,HttpServletRequest httpRequest)throws Exception
	{
		String data =  urlSqlRepo.findByShortUrl(request)
                .map(UrlSql::getLongUrl)
                .orElseThrow(() -> new RuntimeException("URL not found"));
		
		return data;

		
	}
	
	public void saveDataInMongo(UrlSql mongoData)
	{
		UrlNoSQL data = new UrlNoSQL();
		data.setId(mongoData.getId());
		data.setLongUrl(mongoData.getLongUrl());
		data.setShortUrl(mongoData.getShortUrl());
		
		noSqlRepo.save(data);
		
	}
}
