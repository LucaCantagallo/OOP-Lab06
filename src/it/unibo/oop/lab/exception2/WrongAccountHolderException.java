package it.unibo.oop.lab.exception2;

public class WrongAccountHolderException extends RuntimeException {

	private static final long serialVersionUID = 7190620326792084901L;
    private final Integer userID;
    
    
	public WrongAccountHolderException(Integer userID) {
		super();
		this.userID = userID;
	}

	public String toString() {
		return "WrongAccountHolderException [userID = " + this.userID + "]";
	}

	public String getMessage() {
		return this.toString();
	}
    
    

}
