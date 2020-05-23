package product;

public class Product {
	
	private String category,name;
	private double price,weight;
	private int quantity;
	
	public Product(String category, String name, double price, double weight, int quantity) 
	{
		this.category = category;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.weight = weight;
		
	}
	
	public double cargoPrice() {
		return weight*(2.0);
	}
	
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String toString() {
		return name;
		
	}

}
