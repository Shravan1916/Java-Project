package Exceptions;

public class InvalidPhoneNumberException extends Exception{
	
	public InvalidPhoneNumberException() {}
	
	public InvalidPhoneNumberException(String msg) {
		super(msg);
	}

}
