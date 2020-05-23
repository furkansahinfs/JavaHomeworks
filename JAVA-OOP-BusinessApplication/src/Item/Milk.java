package Item;

public class Milk implements IUncountable{
	
	private double litre; //litre of milk
	
	public Milk(double litre) {
		this.litre = litre;
	}

	public double getLitre() {
		return litre;
	}

	public void setLitre(double litre) {
		this.litre = litre;
	}
	
	

}
