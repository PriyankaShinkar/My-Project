package data;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

	//ARGS = URL, Page Title
	@DataProvider (name = "pages")
	public static Object [][] pages() {
	return new Object [][] {
	{"https://www.google.com", "Google"},
	{"https://www.yahoo.com", "Yahoo"},
	{"https://www.facebook.com", "Facebook - Log In or Sign Up"}
	};
}
}
