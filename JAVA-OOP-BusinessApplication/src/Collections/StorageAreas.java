package Collections;

import Item.*;

public class StorageAreas{
	
	private StorageArea sa_BoxedMilk; // Storage are of boxedMilk
	private StorageArea sa_Chocolate; // Storage are of chocolate
	private StorageArea sa_Yogurt; // Storage are of yogurt
	
	
	public StorageAreas() 
	{
		sa_BoxedMilk = new StorageArea();
		sa_Chocolate = new StorageArea();
		sa_Yogurt  = new StorageArea(); 
	}

	
	/**
	 * We add the countable item to the given area.
	 */
	public boolean add (StorageArea storageArea,ICountable eleman) 
	{
		return storageArea.add(eleman);	
	}
	
	/**
	 * We remove the countable item from the given area.
	 */
	public  boolean remove(StorageArea storageArea, ICountable eleman)
	{
		return storageArea.remove(eleman);
	}
	
	
	/**
	 * Firstly we analyse the type of countable item and according to type we invoke the add method using parameter of area for item and item
	 * and return the situations
	 */
	public boolean addStorageAreas( ICountable eleman)  
	{

			switch (eleman.getClass().getSimpleName())
			{
			case "BoxedMilk":
				return add(sa_BoxedMilk, eleman);
			case "Yogurt":
				return add(sa_Yogurt, eleman);
				
			case "Chocolate":
				return add(sa_Chocolate, eleman);	
				
		}
			return false;
	}
	
	/**
	 * Firstly we analyse the type of countable item and according to type we invoke the remove method using parameter of area for item and item
	 * and return the situations
	 */
	public boolean removeStorageAreas( ICountable eleman){
		

		switch (eleman.getClass().getSimpleName())
		{
			case "BoxedMilk":
				return remove(sa_BoxedMilk, eleman);
			case "Yogurt":
				return remove(sa_Yogurt, eleman);
				
			case "Chocolate":
				return remove(sa_Chocolate, eleman);
			}
		return false;
	}
	
	

	public StorageArea getSa_BoxedMilk() {
		return sa_BoxedMilk;
	}


	public void setSa_BoxedMilk(StorageArea sa_BoxedMilk) {
		this.sa_BoxedMilk = sa_BoxedMilk;
	}


	public StorageArea getSa_Chocolate() {
		return sa_Chocolate;
	}


	public void setSa_Chocolate(StorageArea sa_Chocolate) {
		this.sa_Chocolate = sa_Chocolate;
	}


	public StorageArea getSa_Yogurt() {
		return sa_Yogurt;
	}


	public void setSa_Yogurt(StorageArea sa_Yogurt) {
		this.sa_Yogurt = sa_Yogurt;
	}


	
	
}
