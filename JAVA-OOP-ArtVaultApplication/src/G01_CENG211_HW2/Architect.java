package G01_CENG211_HW2;


public class Architect extends Person {

	// We create object with its variables taken from file.
	public Architect(String name, String born, String died,String nationality ) {
		super(name, born, died, nationality);
		// TODO Auto-generated constructor stub
	}
	
	// We create a string which contains the object's definition.
	public String toString() {
		String kimlik = ("Architecht :\n"+ "Name : " + this.getName() +"\n" + "Born : " + this.getBorn() + "\n" + "Died : " + this.getDied() + "\n" + "Nationality : " + this.getNationality()+"\n");
		return kimlik;		
	}

	// We invoke the compare method of base class. str1 and str2 is taken from compareTo method according to choice.
	public int stringCompare(String str1, String str2) {
		return super.stringCompare(str1, str2);
	}
	
	@Override
	// According to sort choice taken from user, we invoke the stringCompare method to compare two object.
	public int compareTo(Object other, int choice) {
		Architect otherCast = (Architect) other;
		
		switch (choice) {
		case 1:
			return this.stringCompare(this.getName(), otherCast.getName());
		case 2:
			return this.stringCompare(this.getBorn(), otherCast.getBorn());
		case 3:
			return this.stringCompare(this.getNationality(), otherCast.getNationality());
	
		default:
			throw new IllegalArgumentException("Unexpected value: " + choice);

		}
	}

}
