package Item;

public class Cream implements IUncountable{
	
	private double litre; //litre of cream
	
	public Cream(double litre) {
		this.setLitre(litre);
	}

	public double getLitre() {
		return litre;
	}

	public void setLitre(double litre) {
		this.litre = litre;
	}
	
	

}
