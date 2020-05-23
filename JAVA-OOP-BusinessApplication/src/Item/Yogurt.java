package Item;

public class Yogurt implements ICountable
{
	// ingredients of yogurt
	private Milk milk;
	private Yeast yeast;
	
	private double litre;// litre of yogurt
	
	public Yogurt(double litre) 
	{
		// yogurt's ingredients litre adjustment 
		milk = new Milk(0);
		yeast = new Yeast(0);
		milk.setLitre((litre/14)*15);
		yeast.setLitre((litre/14)*1);
		this.litre = litre;
	}
	
	

	@Override
	public double getLitre() {
		// TODO Auto-generated method stub
		return litre;
	}

	@Override
	public void setLitre(double litre) {
		this.litre = litre;
		
	}



	public Milk getMilk() {
		return milk;
	}



	public void setMilk(Milk milk) {
		this.milk = milk;
	}



	public Yeast getYeast() {
		return yeast;
	}



	public void setYeast(Yeast yeast) {
		this.yeast = yeast;
	}

}
