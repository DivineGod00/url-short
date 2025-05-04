package com.example.urlshortnering.wrapper;

public interface Constants {
	
	
//	String FAILURE = "FAILURE";
//	
//	
//	String SOME_ERROR_OCCURED = "SOME_ERROR_OCCURED";
	
	public static final String SUCCESS = "Success";
	public static final String SUCCESS_REDIRECT = "Successfully redirecting to the original URL";
	public static final String SHORTCODE_NOT_FOUND = "Short code does not exist";
	public static final String URL_EXPIRED = "URL was valid but has expired (optional feature)";
	public static final String SERVER_ERROR_REDIRECT = "Failure in looking up short code";

	public static final String SUCCESS_DELETE = "Successfully deleted";
	public static final String DELETE_NOT_FOUND = "Short URL not found";
	public static final String DELETE_UNAUTHORIZED = "Not logged in or token missing";
	public static final String SERVER_ERROR_DELETE = "Deletion failed";

	public static final String STATS_SUCCESS = "Stats or analytics returned successfully";
	public static final String STATS_UNAUTHORIZED = "Requires login/token";
	public static final String STATS_FORBIDDEN = "Invalid or insufficient permissions";
	public static final String SERVER_ERROR_STATS = "Unexpected failure";
	public static final String INVALID_URL_FORMAT = "Invalid URL format";
	
}
