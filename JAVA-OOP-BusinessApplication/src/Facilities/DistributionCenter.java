package Facilities;

import Collections.*;
import Item.*;

public class DistributionCenter extends Facilities
{
	// storageAreas hold storageArea of boxedMilk (sa_BoxedMilk ), storageArea of chocolate (sa_chocolate), storageArea of yogurt (sa_yogurt) 
	// Binevi areaları tutan bir obje.
	private StorageAreas storageArea;
	
	public DistributionCenter()
	{
		storageArea = new StorageAreas();
	}
	
	
	/**
	 * If the given item is an countable item we invoke the addStorageAreas method of StorageAreas class
	 * then StorageAreas class analyze that what is the given item's storageArea(sa_BoxedMilk or sa_Chocolate or sa_Yogurt)
	 * and try to add the item to the correct area.
	 */
	public <T> boolean add(T eleman) 
	{
		if( eleman instanceof ICountable) 
		{
			return storageArea.addStorageAreas((ICountable) eleman);	
		}
		
		else 
		{
			return false;
		}
		
	}
	
	
	/**
	 * If the given item is an countable item we invoke the removeStorageAreas method of StorageAreas class
	 * then StorageAreas class analyze that what is the given item's storageArea(sa_BoxedMilk or sa_Chocolate or sa_Yogurt)
	 * and try to remove the item from the correct area.
	 */
	@Override
	public <T> boolean remove(T eleman)  
	{
		if( eleman instanceof ICountable)
		{
			return storageArea.removeStorageAreas((ICountable) eleman);
		}
		else 
		{
			return false;
		}
		
	}
	
	
	
	/**
	 * Firstly we analyze that analyze the type of given item
	 * If there exists enough item in the distribution center storage area(sa_BoxedMilk or sa_Chocolate or sa_Yogurt)
	 * then we apply the selling ( remove item from the area )
	 */
	public boolean sell(ICountable eleman)  
	{
		switch (eleman.getClass().getSimpleName())
		{
		
		case "Chocolate":
			if(eleman.getLitre()<=storageArea.getSa_Chocolate().getLitre()) 
			{
				return storageArea.removeStorageAreas(eleman);
			}
			else 
			{
				System.out.println("Doesn't exist enough item in the distribution center storage area of chocolate to sell");
			}
			break ;
			
		case "BoxedMilk":
			if(eleman.getLitre()<=storageArea.getSa_BoxedMilk().getLitre()) 
			{
				return storageArea.removeStorageAreas(eleman);
			}
			else 
			{
				System.out.println("Doesn't exist enough item in the distribution center storage area of boxed milk to sell");
			}
			break ;
			
		case "Yogurt":
			if(eleman.getLitre()<=storageArea.getSa_Yogurt().getLitre()) 
			{
				return storageArea.removeStorageAreas(eleman);
			}
			else 
			{
				System.out.println("Doesn't exist enough item in the distribution center storage area of yogurt to sell");
			}
			break ;
		}
		
		return false;
	}
	
	public StorageAreas getStorageArea() {
		return storageArea;
	}
	public void setStorageArea(StorageAreas storageArea) {
		this.storageArea = storageArea;
	}
	

	
}
