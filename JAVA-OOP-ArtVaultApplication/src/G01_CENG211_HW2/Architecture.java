package G01_CENG211_HW2;

import java.util.ArrayList;

public class Architecture extends Artwork {
	

	private ArrayList<String> arhitects;
	private double dimension1,dimension2,dimension3;
	
	// We create object with its variables taken from file.
	public Architecture(String name, String style,double dimension1,double dimension2,double dimension3,ArrayList<String> arhitects ) {
		super(name, style);
		// TODO Auto-generated constructor stub
		this.arhitects=arhitects;
		this.dimension1=dimension1;
		this.dimension2=dimension2;
		this.dimension3=dimension3;
	}
	public double getDimension2() {
		return dimension2;
	}
	public void setDimension2(double dimension2) {
		this.dimension2 = dimension2;
	}
	public double getDimension3() {
		return dimension3;
	}
	public void setDimension3(double dimension3) {
		this.dimension3 = dimension3;
	}
	public ArrayList<String> getArhitects() {
		return arhitects;
	}
	public void setArhitects(ArrayList<String> arhitects) {
		this.arhitects = arhitects;
	}
	public double getDimension1() {
		return dimension1;
	}
	public void setDimension1(double dimension1) {
		this.dimension1 = dimension1;
	}
	
	// We create a string which contains the object's definition.
	public String toString() {
		String kimlik = ("Architechture :\n"+ "Name : " + this.getName() +"\n" + "Style : " + this.getStyle() + "\n" + "Dimensions : " + this.getDimension1() + "," + this.getDimension2() + "," + this.getDimension3() + "\n" + "Architects : " + this.getArhitects().toString()+"\n");
		return kimlik;		
	}
	
	
	// We invoke the compare method of base class. str1 and str2 is taken from compareTo method according to choice.
	public int stringCompare(String str1, String str2) {
		return super.stringCompare(str1, str2);
	}
	
	@Override
	// According to sort choice taken from user, we invoke the stringCompare method to compare two object.
	public int compareTo(Object other, int choice) {
		Architecture otherCast = (Architecture) other;
		
		switch (choice) {
		case 1:
			return this.stringCompare(this.getName(), otherCast.getName());
		case 2:
			return this.stringCompare(this.getStyle(), otherCast.getStyle());
	
	
		default:
			throw new IllegalArgumentException("Unexpected value: " + choice);

		}
	}
	
	@Override
	// According to rules, we calculate the cost of artwork.
	public double calculateCost() {
		double price;
		// TODO Auto-generated method stub
		if(this.getStyle().equals("Gothic")) {
			price=this.dimension1*this.dimension2*this.dimension3;
		} else if(this.getStyle().equals("Baroque")) {
			price=this.dimension1*this.dimension2*this.dimension3*(0.8);
		}else {
			price=this.dimension1*this.dimension2*this.dimension3*(0.6);

		}
		return price;
	}
	@Override
	// According to rules, we determine that the artwork is tradeable or not.
	public boolean isTradeable() {
		// TODO Auto-generated method stub
		if(!this.getStyle().equals("Renaissance")) {
			return true;
		}
		return false;
	}
	@Override
	// We invoke the tradeToBuyer method of base class.
	public void tradeToBuyer(Seller seller,Buyer buyer, double cost) {
		super.tradeToBuyer(seller, buyer, cost);
		
	}
	
	


}
