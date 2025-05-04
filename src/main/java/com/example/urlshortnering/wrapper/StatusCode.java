package com.example.urlshortnering.wrapper;

public interface StatusCode {
	
	//https:// Code 200
	int OK = 200;
	int CREATED = 201; 						
	     						
	//https:// Code 300
	int FOUND = 302;
	

	//https:// Code 400
	int UNAUTHORIZED = 401;
	int BAD_REQUEST = 400;
	int FORBIDDEN =403;
	int NOT_FOUND = 404;
	int GONE = 410;
	
	//https:// Code 500
	int INTERNAL_SERVER_ERROR = 500;
	
}
