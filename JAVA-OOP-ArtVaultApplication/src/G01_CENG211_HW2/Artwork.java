package G01_CENG211_HW2;

import Interfaces.IComparable;
import Interfaces.ITradeable;

public abstract class Artwork implements IComparable, ITradeable {

	private String name, style;

	// We create object with its variables taken from file.
	public Artwork(String name, String style) {
		this.name = name;
		this.style = style;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public abstract double calculateCost();

	// We compare two string str1 and str2 which is taken from compareTo method of
	// object according to sort choice.
	public int stringCompare(String str1, String str2) {
		int i1 = str1.length();
		int i2 = str2.length();
		int lmin = Math.min(i1, i2);

		for (int i = 0; i < lmin; i++) {
			int str1_ch = (int) str1.charAt(i);
			int str2_ch = (int) str2.charAt(i);

			if (str1_ch != str2_ch) {
				return str1_ch - str2_ch;
			}
		}
		if (i1 != i2) {
			return i1 - i2;
		} else {
			return 0;
		}
	}

	// If object is tradeable and buyer has enough money, we add the item to buyer's
	// list and remove from seller's list. And money is changed.
	public void tradeToBuyer(Seller seller, Buyer buyer, double cost) {
		// TODO Auto-generated method stub
		if (this.isTradeable()) {
			if (buyer.getWallet() >= cost) {
				buyer.setWallet(buyer.getWallet() - cost);
				buyer.getList().add(this);
				seller.setWallet(seller.getWallet() + cost);
				seller.getList().remove(this); // not to sell one item to different buyer's, we remove the item
												// temporarily.

			} else {
				// If there exists a situation which buyer cannot buy an artwork, we print a
				// message.
				System.out.println("No money, no artwork for " + buyer.getName());
			}
		} else {
			// Although there is no situation which buyer can buy a nontradeable item, we
			// print a message for this situation.
			System.out.println("This Artwork Is Not Tradeable");
		}

	}

}
