package it.unibo.oop.lab.exception2;

public class TransactionsOverQuotaException extends RuntimeException {
	
	private static final long serialVersionUID = -9138729040237008462L;
	private int totalTransactionCount;
    private final int maximumAllowedATMTransactions;
    
	public TransactionsOverQuotaException(int totalTransactionCount, int maximumAllowedATMTransactions) {
		super();
		this.totalTransactionCount = totalTransactionCount;
		this.maximumAllowedATMTransactions = maximumAllowedATMTransactions;
	}

	public String toString() {
		return "TransactionsOverQuotaException [totalTransactionCount=" + this.totalTransactionCount
				+ ", maximumAllowedATMTransactions=" + this.maximumAllowedATMTransactions + "]";
	}
	
	public String getMessage() {
		return this.toString();
	}
	
	
    
    

}
