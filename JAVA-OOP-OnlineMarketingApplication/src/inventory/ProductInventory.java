package inventory;

import product.Product;

public class ProductInventory<T extends Product> extends Inventory<T>{
	
	
	
	public ProductInventory(){
		super();
	}
	

	/*
	 * it is adding product to inventory
	 * 
	 */
	public void addProduct(T product,int quantity) 
	{
		 super.addProduct(product, quantity);
	}
	
	/*
	 * it is removing from inventory
	 * 
	 */
	public boolean removeProduct(T product, int quantity)
	{
		return super.removeProduct(product, quantity);
	}
	

	
}
