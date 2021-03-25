package G01_CENG211_HW2;

public class Sculpture extends Artwork {

	private String artist;
	private String material;
	private double weight;

	// We create object with its variables taken from file.
	public Sculpture(String name, String style, String artist, String Material, double Weight) {
		super(name, style);
		// TODO Auto-generated constructor stub
		this.artist = artist;
		this.material = Material;
		this.weight = Weight;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	// We create a string which contains the object's definition.
	public String toString() {
		String kimlik = ("Sculpture :\n" + "Name : " + this.getName() + "\n" + "Style : " + this.getStyle() + "\n"
				+ "Artist : " + this.getArtist() + "\n" + "Material : " + this.getMaterial() + "\n" + "Weight : "
				+ this.getWeight() + "\n");
		return kimlik;
	}

	// We invoke the compare method of base class. str1 and str2 is taken from
	// compareTo method according to choice.
	public int stringCompare(String str1, String str2) {
		return super.stringCompare(str1, str2);
	}

	@Override
	// According to sort choice taken from user, we invoke the stringCompare method
	// to compare two object.
	public int compareTo(Object other, int choice) {
		Sculpture otherCast = (Sculpture) other;

		switch (choice) {
		case 1:
			return this.stringCompare(this.getName(), otherCast.getName());
		case 2:
			return this.stringCompare(this.getStyle(), otherCast.getStyle());
		case 3:
			return this.stringCompare(this.getArtist(), otherCast.getArtist());
		case 4:
			return this.stringCompare(this.getMaterial(), otherCast.getMaterial());

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
		if (this.getMaterial().equals("Marble")) {
			price = this.weight * (15);
		} else {
			price = this.weight * (180);

		}
		return price;
	}

	@Override
	// According to rules, we determine that the artwork is tradeable or not.
	public boolean isTradeable() {
		// TODO Auto-generated method stub
		if (!this.getStyle().equals("Baroque")) {
			return true;
		}
		return false;
	}

	@Override
	// We invoke the tradeToBuyer method of base class.
	public void tradeToBuyer(Seller seller, Buyer buyer, double cost) {
		super.tradeToBuyer(seller, buyer, cost);

	}

}
