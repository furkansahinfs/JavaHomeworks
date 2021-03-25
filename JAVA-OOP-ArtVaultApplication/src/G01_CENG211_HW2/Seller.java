package G01_CENG211_HW2;

import java.util.ArrayList;

public class Seller {
	private double wallet;
	private ArrayList<Artwork> list = new ArrayList<Artwork>(); // list holds the seller's items which are tradeable.

	public Seller() {
		this.wallet = 0;
	}

	public double getWallet() {
		return this.wallet;
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

}
