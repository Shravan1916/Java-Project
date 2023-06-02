package Exceptions;

public class InvalidEmailException extends Exception{
	
	public InvalidEmailException() {}
	
	public InvalidEmailException(String msg) {
		super(msg);
	}

}
