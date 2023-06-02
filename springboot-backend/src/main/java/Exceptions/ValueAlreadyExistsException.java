package Exceptions;

public class ValueAlreadyExistsException extends Exception{
	
	public ValueAlreadyExistsException() {}
	
	public ValueAlreadyExistsException(String msg) {
		super(msg);
	}
	
}
