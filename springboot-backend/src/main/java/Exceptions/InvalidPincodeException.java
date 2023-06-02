package Exceptions;

public class InvalidPincodeException extends Exception{
	
	public InvalidPincodeException() {}
	
	public InvalidPincodeException(String msg) {
		super(msg);
	}

}
