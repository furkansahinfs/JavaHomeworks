package Collections;

import Item.*;

public class StorageTank
{
	private double capacity; // capacity of tank
	private double litre;//the litre of item in the area
	
	
	public StorageTank() 
	{
		this.capacity = 10000;
		this.litre = 0;
	}
	
	
	/**
	 * We control that there exists enough space in the tank
	 * if space is okey, then we add the item to the tank and set the litre of area.
	 */
	public boolean add (IUncountable eleman) 
	{
		boolean result=false;
		if (capacity>=eleman.getLitre()+litre)
		{	
			litre =(litre+eleman.getLitre());
			result = true;
		}
		else
		{
			System.out.println("Tank capacity is full. Control the capacity from the display screen.");
			result = false;
		}
	
	return result;
	}
	
	/**
	 * If there exists enough litre of item to remove in the tank, we remove the item and set the litre of tank.
	 */
	public boolean remove(IUncountable eleman) 
	{
		boolean result = false;
		if (litre>=eleman.getLitre())
		{
			this.litre = litre-eleman.getLitre();
			result = true;
		}
		else 
		{
			System.out.println("Bu boyutta silinecek eleman yok tankta");
			result = false;
		}
		
		return result;
	}
	
	
	
	
	public double getCapacity() {
		return capacity;
	}
	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}
	public double getLitre() {
		return litre;
	}
	
	public void setLitre(double litre) {
		this.litre = litre;
	}
	
}
