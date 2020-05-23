package inventory;

import java.util.HashMap;
import java.util.Map;

public class Shop<T> {
	
	private Map<T, Integer> shopInventory;
	

	public Shop()
	{
		shopInventory = new HashMap<T, Integer>();	
	}
	
	/*
	 * it adds product to shop inventory
	 * 
	 */
	public Integer addProduct(T product,int quantity) 
	{
		if(shopInventory.containsKey(product))
		{
			return shopInventory.replace(product, shopInventory.get(product)+quantity);
		}
		
		return shopInventory.put(product, quantity);
	}
	
	/*
	 * it removes product from shop inventory
	 * 
	 */
	public Integer removeProduct(T product, int quantity)
	{
		if(!shopInventory.isEmpty() &&  shopInventory.get(product)-quantity>=0) 
		{
			return shopInventory.replace(product,  shopInventory.get(product)-quantity);
		}
		return -1;
	}
	
	
	/*
	 * it is clearing the shop inventory
	 * 
	 */
	public void clearShop()
	{
		shopInventory.clear();
	}

	public Map<T, Integer> getShopInventory() {
		return shopInventory;
	}

	public void setShopInventory(Map<T, Integer> shopInventory) {
		this.shopInventory = shopInventory;
	}
	

	
	

}
