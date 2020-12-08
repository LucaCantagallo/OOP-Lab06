package it.unibo.oop.lab.exception1;

public class NotEnoughBatteryException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final double batteryLevel;
	private final double batteryLevelNeeded;
	
	public NotEnoughBatteryException(final double bL, final double bLN) {
		this.batteryLevel = bL;
		this.batteryLevelNeeded = bLN;
	}
	
	public String toString(){
		return "The Battery level: " + this.batteryLevel + " is below that the battery level needed for this action: " 
				+ this.batteryLevelNeeded;
	}
	
	public String getMessage() {
		return this.toString();
	}

}
