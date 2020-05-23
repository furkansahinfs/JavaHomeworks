package Interfaces;

import G01_CENG211_HW2.Buyer;
import G01_CENG211_HW2.Seller;

public interface ITradeable {
	public boolean  isTradeable(); // controls that the object is tradeable or not. 
	public void tradeToBuyer(Seller seller,Buyer buyer,double cost); // make a trade between seller and buyer
		
	
}
