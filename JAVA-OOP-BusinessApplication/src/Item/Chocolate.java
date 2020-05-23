package Item;

public class Chocolate implements ICountable{
	
	private double litre; // litre of chocolate
	
	// ingredients of chocolate
	private Milk milk;
	private Cacao cacao;
	private Cream cream;
	
	public Chocolate(double litre) 
	{	
		// chocolate's ingredients litre adjustment 
		milk = new Milk(0);
		milk.setLitre((litre/8)*5);
		cacao = new Cacao(0);
		cacao.setLitre((litre/8)*2);
		cream = new Cream(0);
		cream.setLitre((litre/8)*3);
		this.litre = litre;
	}
	
	@Override
	public double getLitre() 
	{
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

	public Cacao getCacao() {
		return cacao;
	}

	public void setCacao(Cacao cacao) {
		this.cacao = cacao;
	}

	public Cream getCream() {
		return cream;
	}

	public void setCream(Cream cream) {
		this.cream = cream;
	}

}
