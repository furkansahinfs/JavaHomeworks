package inventory;

import java.util.HashMap;
import java.util.Map;

public class Basket<T> {
	
	private Map<T, Integer> basketInventory;
	

	public Basket() 
	{
		basketInventory = new HashMap<T, Integer>();
	}
	
	/*
	 * it is addin product to basket  
	 * 
	 */
	public Integer addProduct(T product,int quantity)
	{
		if(basketInventory.containsKey(product))
		{
			return basketInventory.replace(product, basketInventory.get(product)+quantity);
		}
		else
		{
		return basketInventory.put(product, quantity);
		}
	}
	
	/*
	 * it is removing from basket
	 * 
	 */
	public Integer removeProduct(T product, int quantity)
	{
		if(!basketInventory.isEmpty() &&  basketInventory.get(product)-quantity>0) 
		{
			return basketInventory.replace(product,  basketInventory.get(product)-quantity);
		}
		else if(!basketInventory.isEmpty() &&  basketInventory.get(product)-quantity == 0)
		{
			return basketInventory.remove(product);
		}
		
		return -1;
	}
	
	
	/*
	 * it is clearing to basket
	 * 
	 */
	public void clearBasket()
	{
		basketInventory.clear();
	}

	public Map<T, Integer> getBasketInventory() {
		return basketInventory;
	}

	public void setBasketInventory(Map<T, Integer> basketInventory) {
		this.basketInventory = basketInventory;
	}
	

	
	

}
