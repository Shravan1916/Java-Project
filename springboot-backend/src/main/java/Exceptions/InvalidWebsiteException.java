package Exceptions;

public class InvalidWebsiteException extends Exception{
	
	public InvalidWebsiteException() {}
	
	public InvalidWebsiteException(String msg) {
		super(msg);
	}

}
