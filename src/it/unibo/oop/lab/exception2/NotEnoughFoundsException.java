package it.unibo.oop.lab.exception2;

public class NotEnoughFoundsException extends RuntimeException {

	private static final long serialVersionUID = 4568486094869701359L;
	private double balance;
	private double amount;
	
	public NotEnoughFoundsException(double balance, double amount) {
		super();
		this.balance = balance;
		this.amount = amount;
	}

	public String toString() {
		return "NotEnoughFoundsException [balance =" + this.balance + ", amount=" + this.amount + "]";
	}
	
	public String getMessage() {
		return this.toString();
	}
	
	

	
}
