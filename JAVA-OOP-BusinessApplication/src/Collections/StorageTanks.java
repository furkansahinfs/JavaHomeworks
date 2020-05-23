package Collections;

import Item.*;

public class StorageTanks{

	private StorageTank yeastTank; // Storage tank of yeast
	private StorageTank milkTank; // Storage tank of milk
	private StorageTank cacaoTank; // Storage tank of cacao
	private StorageTank creamTank; // Storage tank of cream
	
	
	public StorageTanks() 
	{
		yeastTank = new StorageTank();
		milkTank = new StorageTank();
		cacaoTank = new StorageTank();
		creamTank = new StorageTank();

	}
	
	/**
	 * We add the uncountable item to the given tank.
	 */
	public boolean add (StorageTank storageTank,IUncountable eleman) 
	{
		return storageTank.add(eleman);
	}
	
	/**
	 * We remove the uncountable item from the given area.
	 */
	public  boolean remove(StorageTank storageTank, IUncountable eleman)
	{
		return storageTank.remove(eleman);
	}
	
	/**
	 * Firstly we analyse the type of uncountable item and according to type we invoke the add method using parameter of area for item and item
	 * and return the situations
	 */
	public boolean addStorageTanks( IUncountable eleman) 
	{
		boolean result = false;
		
			switch (eleman.getClass().getSimpleName()) {
			case "Milk":
				return add(milkTank, eleman);
			case "Cacao":
				return add(cacaoTank, eleman);
				
			case "Cream":
				return add(creamTank, eleman);
			case "Yeast":
				return add(yeastTank, eleman);		
			
		}
		return result;
	}
	
	
	/**
	 * Firstly we analyse the type of uncountable item and according to type we invoke the remove method using parameter of area for item and item
	 * and return the situations
	 */
	public boolean removeStorageTanks( IUncountable eleman) {
		boolean result = false;
		
			switch (eleman.getClass().getSimpleName()) {
			case "Milk":
				return remove(milkTank, eleman);
			case "Cacao":
				return remove(cacaoTank, eleman);
				
			case "Cream":
				return remove(creamTank, eleman);
			case "Yeast":
				return remove(yeastTank, eleman);
			
			
		}
		return result;
	}
	
	public StorageTank getYeastTank() {
		return yeastTank;
	}
	public void setYeastTank(StorageTank yeastTank) {
		this.yeastTank = yeastTank;
	}
	public StorageTank getMilkTank() {
		return milkTank;
	}
	public void setMilkTank(StorageTank milkTank) {
		this.milkTank = milkTank;
	}
	public StorageTank getCacaoTank() {
		return cacaoTank;
	}
	public void setCacaoTank(StorageTank cacaoTank) {
		this.cacaoTank = cacaoTank;
	}
	public StorageTank getCreamTank() {
		return creamTank;
	}
	public void setCreamTank(StorageTank creamTank) {
		this.creamTank = creamTank;
	}
	
}
