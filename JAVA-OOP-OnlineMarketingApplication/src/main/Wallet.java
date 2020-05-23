package main;

public class Wallet {
	private double active_balance;
	public Wallet(double active_balance) {
		this.setActive_balance(active_balance);
	}
	public double getActive_balance() {
		return active_balance;
	}
	public void setActive_balance(double active_balance) {
		this.active_balance = active_balance;
	}
}
