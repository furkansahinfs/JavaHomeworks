package Item;

public class Yeast implements IUncountable{
	
	private double litre; //litre of yeast
	
	public Yeast(double litre) {
		this.setLitre(litre);
	}

	public double getLitre() {
		return litre;
	}

	public void setLitre(double litre) {
		this.litre = litre;
	}
	
	

}
