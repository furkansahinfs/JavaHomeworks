package Item;

public class BoxedMilk implements ICountable{
	
	private double litre; // litre of boxedMilk 
	private Milk milk; // ingredient of boxedMilk
	
	public BoxedMilk(double litre) 
	{
		milk = new Milk(0);
		milk.setLitre(litre);
		this.litre = litre;

	}
	public Milk getMilk() 
	{
		return milk;
	}
	public void setMilk(Milk milk) 
	{
		this.milk = milk;
	}
	public double getLitre() 
	{
		return litre;
	}

	public void setLitre(double litre) 
	{
		this.litre = litre;
	}


}
