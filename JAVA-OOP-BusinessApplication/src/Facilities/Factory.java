package Facilities;


import Collections.*;
import Item.*;

public class Factory extends Facilities
{
	
	// storageTanks hold storageTank of milkTank, storageTank of creamTank,  storageTank of cacaoTank, storageTank of yeastTank
	// Binevi tankları tutan bir obje.
	private StorageTanks storageTanks; 
	
	// storageAreas hold storageArea of boxedMilk (sa_BoxedMilk ), storageArea of chocolate (sa_chocolate), storageArea of yogurt (sa_yogurt) 
	// Binevi areaları tutan bir obje.
	private StorageAreas storageAreas; 
	
	public Factory()
	{
		storageTanks = new StorageTanks();		
		storageAreas = new StorageAreas();
	}

	
	/**
	 * If the given item is an uncountable item we invoke the addStorageTanks method of StorageTanks class
	 * then StorageTanks class analyze that what is the given item's storageTank(milkTank or creamTank or cacaoTank or yeastTank)
	 * and try to add the item to the correct tank.
	 * 
	 * If the given item is an countable item we invoke the addStorageAreas method of StorageAreas class
	 * then StorageAreas class analyze that what is the given item's storageArea(sa_BoxedMilk or sa_Chocolate or sa_Yogurt)
	 * and try to add the item to the correct area.
	 */
	
	@Override
	public <T> boolean add(T eleman)  
	{
		boolean result = false;
		if( eleman instanceof IUncountable) 
		{
			return storageTanks.addStorageTanks((IUncountable) eleman);
		}
		

		else if( eleman instanceof ICountable) 
		{
			return storageAreas.addStorageAreas((ICountable) eleman);		
		}
		else 
		{
			result = false;
		}
		return result;
		
	}
	
	
	/**
	 * If the given item is an uncountable item we invoke the removeStorageTanks method of StorageTanks class
	 * then StorageTanks class analyze that what is the given item's storageTank(milkTank or creamTank or cacaoTank or yeastTank)
	 * and try to remove the item from the correct tank.
	 * 
	 * If the given item is an countable item we invoke the removeStorageAreas method of StorageAreas class
	 * then StorageAreas class analyze that what is the given item's storageArea(sa_BoxedMilk or sa_Chocolate or sa_Yogurt)
	 * and try to remove the item from the correct area.
	 */
	
	@Override
	public <T> boolean remove(T eleman)  
	{
		if( eleman instanceof IUncountable) 
		{
			return storageTanks.removeStorageTanks((IUncountable) eleman);
		}
		else if( eleman instanceof ICountable) 
		{
			return storageAreas.removeStorageAreas((ICountable) eleman);
		}
		else 
		{
			return false;
		}
		
	}
	
	
	/** 
	 * If the given item is an countable item we analyze the type of item and 
	 * control that there exists enough ingredients in the factory storageTanks to produce the item.
	 * If it is yes, we produce the item
	 */
	public <T> boolean produce(T eleman) 
	{
		boolean result = false;
		if (eleman instanceof ICountable) 
		{
			switch (eleman.getClass().getSimpleName()) 
			{
		
			case "Chocolate":
				Chocolate chocolate = (Chocolate) eleman;
				if(chocolate.getMilk().getLitre()<=storageTanks.getMilkTank().getLitre()&& chocolate.getCacao().getLitre()<=storageTanks.getCacaoTank().getLitre() && chocolate.getCream().getLitre()<=storageTanks.getCreamTank().getLitre()) 
				{
					if( storageAreas.addStorageAreas(chocolate)) 
					{
						if(storageTanks.removeStorageTanks(chocolate.getMilk()) && storageTanks.removeStorageTanks(chocolate.getCacao()) && storageTanks.removeStorageTanks(chocolate.getCream()))
						{
							result = true;	
						}
						else
						{
							result = false;
						}
					}
					else 
					{
						System.out.println("Factory chocolate storage area add error - chocolate storage area capacity can be full");
						result = false;
					}
				}
				else 
				{
					System.out.println("There is no enough ingredients in the factory tanks to produce chocolate");
					result = false;
				}
				break;
				
				
			case "BoxedMilk":
				BoxedMilk boxedMilk = (BoxedMilk) eleman;
				
				if(boxedMilk.getMilk().getLitre()<=storageTanks.getMilkTank().getLitre())
				{
					if( storageAreas.addStorageAreas(boxedMilk)) 
					{
						if(storageTanks.removeStorageTanks(boxedMilk.getMilk()))
						{
							result = true;	
						}
						else
						{
							result = false;
						}
					}
					else 
					{
						System.out.println("Factory boxedMilk storage area add error - boxedMilk storage area capacity can be full");
						result = false;
					}
				}
				else 
				{
					System.out.println("There is no enough ingredients in the factory tanks to produce boxedMilk");
					result = false;
				}
				break;
		
				

			case "Yogurt":
				Yogurt yogurt = (Yogurt) eleman;
				if(yogurt.getMilk().getLitre()<=storageTanks.getMilkTank().getLitre()&& yogurt.getYeast().getLitre()<=storageTanks.getYeastTank().getLitre()) 
				{
					if( storageAreas.addStorageAreas(yogurt)) 
					{
						if(storageTanks.removeStorageTanks(yogurt.getMilk()) && storageTanks.removeStorageTanks(yogurt.getYeast()))
						{
							result = true;	
						}
						else
						{
							result = false;
						}
					}
					else 
					{
						System.out.println("Factory yogurt storage area add error - yogurt storage area capacity can be full");
						result = false;
					}
				}
				else 
				{
					System.out.println("There is no enough ingredients in the factory tanks to produce yogurt");
					result = false;
				}
				break;
			}
			
			return result;
		}
		return false;
		
	}
	
	
	/**
	 * If the given item is one of the Chocolate,BoxedMilk,Yogurt 
	 * then we control that if the litre of factory storage area of given item(sa_boxedmilk or sa_chocolate or sa_yogurt) >= container capacity
	 * If it is yes :
	 * then we control that the litre of distribution center storage area of given item(sa_boxedmilk or sa_chocolate or sa_yogurt) is enough to transfer
	 * we transfer the fixed litre of item that container can take ( container ne kadar alabiliyorsa o kadar gönderiyoruz ).
	 * 
	 * If it is no:
	 * then we control that if the litre of factory storage area of given item(sa_boxedmilk or sa_chocolate or sa_yogurt) < container capacity
	 * then we control that the litre of distribution center storage area of given item(sa_boxedmilk or sa_chocolate or sa_yogurt) is enough to transfer
	 * we transfer the fixed litre of item that storage area of given item(sa_boxedmilkor sa_chocolateor sa_yogurt) includes.
	 * ( factory storage areadaki (sa_boxedmilk or sa_chocolate or sa_yogurt) litre kadar gönderiyoruz ).
	 */
	
	@Override
	public <T> boolean transferTo(T eleman, Facilities faci,IContainer container) throws Exception 
	{
		boolean result = false;
		switch (eleman.getClass().getSimpleName()) 
		{

		case "Chocolate":
			if(storageAreas.getSa_Chocolate().getLitre()>0)
			{
				if(storageAreas.getSa_Chocolate().getLitre()>=((DryStorageContainer) container).getCapacity()) 
				{
					ICountable temp = new Chocolate(((DryStorageContainer) container).getCapacity()); 
					if((((DistributionCenter) faci).getStorageArea().getSa_Chocolate().getLitre()) + temp.getLitre() <=   ((DistributionCenter) faci).getStorageArea().getSa_Chocolate().getCapacity())
					{
						result = transferControl(temp, faci, container);
					}
				}
						
				
				else if(storageAreas.getSa_Chocolate().getLitre()<((DryStorageContainer) container).getCapacity())
				{
					ICountable temp = new Chocolate((storageAreas.getSa_Chocolate().getLitre())); 
					if((((DistributionCenter) faci).getStorageArea().getSa_Chocolate().getLitre()) + temp.getLitre() <=   ((DistributionCenter) faci).getStorageArea().getSa_Chocolate().getCapacity())
					{
						result = transferControl(temp, faci, container);
					}
				}
			}
			else
			{
				result = false;
				System.out.println("There is no chocolate in factory to transfer");	
			}
			break;


		case "BoxedMilk":
			if(storageAreas.getSa_BoxedMilk().getLitre()>0)
			{
				if(storageAreas.getSa_BoxedMilk().getLitre()>=((DryStorageContainer) container).getCapacity()) 
				{
					ICountable temp = new BoxedMilk(((DryStorageContainer) container).getCapacity()); 
					if((((DistributionCenter) faci).getStorageArea().getSa_BoxedMilk().getLitre()) + temp.getLitre() <=   ((DistributionCenter) faci).getStorageArea().getSa_BoxedMilk().getCapacity())
					{
						result = transferControl(temp, faci, container);
					}
				}
				
				else if(storageAreas.getSa_BoxedMilk().getLitre()<((DryStorageContainer) container).getCapacity()) {
					ICountable temp = new BoxedMilk((storageAreas.getSa_BoxedMilk().getLitre())); 
					if((((DistributionCenter) faci).getStorageArea().getSa_BoxedMilk().getLitre()) + temp.getLitre() <=   ((DistributionCenter) faci).getStorageArea().getSa_BoxedMilk().getCapacity())
					{
						result = transferControl(temp, faci, container);
					}
				}
			}
			else
			{
				result = false;
				System.out.println("There is no boxed milk in factory to transfer");	
			}
			break;
			
			
		case "Yogurt":
			if(storageAreas.getSa_Yogurt().getLitre()>0)
			{
				if(storageAreas.getSa_Yogurt().getLitre()>=((DryStorageContainer) container).getCapacity()) {
					ICountable temp = new Yogurt(((DryStorageContainer) container).getCapacity()); 
					if((((DistributionCenter) faci).getStorageArea().getSa_Yogurt().getLitre()) + temp.getLitre() <=   ((DistributionCenter) faci).getStorageArea().getSa_Yogurt().getCapacity())
					{
						result = transferControl(temp, faci, container);
					}
				}
				
				else if(storageAreas.getSa_Yogurt().getLitre()<((DryStorageContainer) container).getCapacity()) {
					ICountable temp = new Yogurt((storageAreas.getSa_Yogurt().getLitre())); 
					if((((DistributionCenter) faci).getStorageArea().getSa_Yogurt().getLitre()) + temp.getLitre() <=   ((DistributionCenter) faci).getStorageArea().getSa_Yogurt().getCapacity())
					{
						result = transferControl(temp, faci, container);
					}
				}
			}
			else
			{
				result = false;
				System.out.println("There is no yogurt in factory to transfer");	
			}
			break;

	}
		return result;
	}
	
	
	/* 
	 * Firstly, if  container can take the given item from the storage area (sa_boxedmilk or sa_chocolate or sa_yogurt)
	 * then we control that storage area can remove the given item ( it is always true actually ) from storage area (sa_boxedmilk or sa_chocolate or sa_yogurt).
	 * If these are true then we apply the transfer.
	*/
	public boolean transferControl(ICountable temp, Facilities faci,IContainer container) throws Exception 
	{
		boolean result = false;
		if(container.add((ICountable) temp))
		{
			
				if(storageAreas.removeStorageAreas((ICountable) temp))
				{
					container.transferTo((ICountable) temp, faci);
					result = true;
				}
				else 
				{
					System.out.println("DryStorageContainer transfer error");
					result = false;
				}
					
		
		}
		else 
		{
			System.out.println("Factory storageAreas remove error.");
			result = false;
		}
			
		return result;
		}
	

	
	public StorageAreas getStorageArea() {
		return storageAreas;
	}
	public void setStorageArea(StorageAreas storageAreas) {
		this.storageAreas = storageAreas;
	}
	public StorageTanks getStorageTanks() {
		return storageTanks;
	}
	public void setStorageTanks(StorageTanks storageTanks) {
		this.storageTanks = storageTanks;
	}
	

}
