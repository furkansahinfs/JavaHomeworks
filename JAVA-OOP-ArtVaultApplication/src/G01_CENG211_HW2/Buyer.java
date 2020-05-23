package G01_CENG211_HW2;

import java.util.ArrayList;

public class Buyer {
	private ArrayList<Artwork> list = new ArrayList<Artwork>(); // This list holds the buyer's bought.
	private double wallet;
	private String name = null;
	
	public Buyer(String name) {
		this.setName(name);
		this.setWallet(5000000.00);
	}
	public double getWallet() {
		return wallet;
	}
	public void setWallet(double wallet) {
		this.wallet = wallet;
	}
	public ArrayList<Artwork> getList() {
		return list;
	}
	public void setList(ArrayList<Artwork> list) {
		this.list = list;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
