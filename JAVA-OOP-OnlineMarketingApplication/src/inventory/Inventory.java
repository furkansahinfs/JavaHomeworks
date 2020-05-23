package inventory;

import java.util.HashMap;
import java.util.Map;



public abstract class Inventory<T> implements IInventory<T>{
	
	private Map<T, Integer> inventory;
	
	public Inventory(){
		
		inventory = new HashMap<T,Integer>();
		
	}
	
	
	/*
	 * it is adding product to inventory
	 * 
	 */
	public void addProduct(T product, int quantity) {
		
		if(inventory.containsKey(product)) 
		{
			
			inventory.replace((T) product, Integer.valueOf(inventory.get((T) product)), Integer.valueOf(quantity+inventory.get((T) product)));
		}
		else 
		{
			inventory.put(product, Integer.valueOf(quantity));
		}
		
	}

	/*
	 * it is removing from inventory
	 * 
	 */
	public boolean removeProduct(T product, int quantity) {
		if(inventory.containsKey(product)) {
			return inventory.replace( product, inventory.get(product), inventory.get(product)-quantity);
		}
		return false;
	}


	public Map<T, Integer> getInventory() {
		return inventory;
	}

	public void setInventory(Map<T, Integer> inventory) {
		this.inventory = inventory;
	}

	

}
