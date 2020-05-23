package Item;

public class Cacao implements IUncountable{
	
	private double litre; //litre of cacao
	
	public Cacao(double litre) {
		this.setLitre(litre);
	}

	public double getLitre() {
		return litre;
	}

	public void setLitre(double litre) {
		this.litre = litre;
	}
	
	

}
