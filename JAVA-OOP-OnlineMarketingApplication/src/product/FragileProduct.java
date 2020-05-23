package product;

public class FragileProduct extends Product{

	public FragileProduct(String category, String name, double price, double weight, int quantity) {
		super(category, name, price, weight, quantity);
	}

	@Override
	public double cargoPrice() {
		// TODO Auto-generated method stub
		return getWeight()*(2.0)*(4.5);
	}


}
