package Exceptions;

@SuppressWarnings("serial")
public class ItemNotCountableException extends Exception{
	public ItemNotCountableException(String errorMessage) {
		super(errorMessage);
	}

}
