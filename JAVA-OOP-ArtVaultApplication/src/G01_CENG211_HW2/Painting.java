package G01_CENG211_HW2;
;
public class Painting extends Artwork {
	
	private String artist;
	private double dimension1,dimension2;
	
	// We create object with its variables taken from file.
	public Painting(String name, String style,String artist,double dimension1,double dimension2) {
		super(name, style);
		// TODO Auto-generated constructor stub
		this.artist=artist;
		this.dimension1=dimension1;
		this.dimension2=dimension2;
	}
	public double getDimension2() {
		
		return dimension2;
	}
	public void setDimension2(double dimension2) {
		this.dimension2 = dimension2;
	}
	public double getDimension1() {
		return dimension1;
	}
	public void setDimension1(double dimension1) {
		this.dimension1 = dimension1;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}

	// We create a string which contains the object's definition.
	public String toString() {
		String kimlik = ("Painting :\n"+ "Name : " + this.getName() +"\n" + "Style : " + this.getStyle() + "\n" + "Artist : " + this.getArtist() + "\n" + "Dimensions : " + this.getDimension1() + "," + this.getDimension2()+"\n");
		return kimlik;		
	}
	
	// We invoke the compare method of base class. str1 and str2 is taken from compareTo method according to choice.
	public int stringCompare(String str1, String str2) {
		return super.stringCompare(str1, str2);
	}
	
	@Override
	// According to sort choice taken from user, we invoke the stringCompare method to compare two object.
	public int compareTo(Object other, int choice) {
		Painting otherCast = (Painting) other;
		switch (choice) {
		case 1:
			return this.stringCompare(this.getName(), otherCast.getName());
		case 2:
			return this.stringCompare(this.getStyle(), otherCast.getStyle());
		case 3:
			return this.stringCompare(this.getArtist(), otherCast.getArtist());
	
		default:
			throw new IllegalArgumentException("Unexpected value: " + choice);

		}
	}
	@Override
	// According to rules, we calculate the cost of artwork.
	public double calculateCost() {
		// TODO Auto-generated method stub
		double price;
		// TODO Auto-generated method stub
		if(this.getStyle().equals("Baroque")) {
			price=this.dimension1*this.dimension2*(5.5);
		} else if(this.getStyle().equals("Renaissance")) {
			price=this.dimension1*this.dimension2*(7);
		}else {
			price=this.dimension1*this.dimension2*(4.5);

		}
		return price;
		
	}
	@Override
	// According to rules, we determine that the artwork is tradeable or not.
	public boolean isTradeable() {
		// TODO Auto-generated method stub
		if(!this.getStyle().equals("Gothic")) {
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
