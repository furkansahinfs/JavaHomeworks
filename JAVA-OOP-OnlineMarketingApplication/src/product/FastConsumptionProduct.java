package product;

public class FastConsumptionProduct extends Product {
	
	public FastConsumptionProduct(String category, String name, double price, double weight, int quantity) {
		super(category, name, price, weight, quantity);
	}
	@Override
	public double cargoPrice() {
		// TODO Auto-generated method stub
		return getWeight()*(2.0)*(3.5);
	}


}
