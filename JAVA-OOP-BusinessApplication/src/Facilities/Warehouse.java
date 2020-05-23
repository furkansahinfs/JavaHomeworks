package Facilities;
import Collections.*;
import Item.*;

public class Warehouse extends Facilities 
{
	// storageTanks hold storageTank of milkTank, storageTank of creamTank,  storageTank of cacaoTank, storageTank of yeastTank
	// Binevi tankları tutan bir obje.
	private StorageTanks storageTanks;
	
	public Warehouse()
	{
		storageTanks = new StorageTanks();		
	}
	
	
	/**
	 * We invoke the addStorageTanks method of StorageTanks class
	 * then StorageTanks class analyze that what is the given item's storageTank(milkTank or creamTank or cacaoTank or yeastTank)
	 * and try to add the item to the correct tank.
	 */
	
	public boolean addToWarehouse(IUncountable eleman) 
	{
		return storageTanks.addStorageTanks(eleman);
		
	}
	
	
	/**
	 * We invoke the removeStorageTanks method of StorageTanks class
	 * then StorageTanks class analyze that what is the given item's storageTank(milkTank or creamTank or cacaoTank or yeastTank)
	 * and try to remove the item from the correct tank.
	 */
	public void remove(IUncountable obje) 
	{
		storageTanks.removeStorageTanks(obje);
	}
	
	
	/**
	 * If storage tank capacity of warehouse is enough for the given object, business buy ingredients.
	 */
	public boolean buy(IUncountable obje) 
	{
		return addToWarehouse(obje);
	}
	
	
	/**
	 * If the given item is one of the milk,cacao,cream,yeast
	 * then we control that if the litre of warehouse storage tank of given item (milkTank or creamTank or cacaoTank or yeastTank) >= container capacity
	 * if it is yes :
	 * then we control that the litre of factory storage tank of given item (milkTank or creamTank or cacaoTank or yeastTank) is enough to transfer
	 * we transfer the fixed litre of item that container can take ( container ne kadar alabiliyorsa o kadar gönderiyoruz ).
	 * 
	 * if it is no :
	 * then we control that if the litre of warehouse storage tank of given item (milkTank or creamTank or cacaoTank or yeastTank) < container capacity
	 * then we control that the litre of factory storage tank of given item (milkTank or creamTank or cacaoTank or yeastTank) is enough to transfer
	 * we transfer the fixed litre of item that storage tank of given item(milkTank or creamTank or cacaoTank or yeastTank) includes.
	 * ( warehouse storage tanktaki (milkTank or creamTank or cacaoTank or yeastTank) litre kadar gönderiyoruz ).
	 * 
	 */
	
	@Override
	public <T> boolean transferTo(T eleman, Facilities faci,IContainer container) throws Exception 
	{
		boolean result = true;
		switch (eleman.getClass().getSimpleName()) 
		{		
			case "Milk":
				if(storageTanks.getMilkTank().getLitre()>0) 
				{
					if(storageTanks.getMilkTank().getLitre()>=((TankContainer) container).getCapacity()) 
					{
						IUncountable temp = new Milk(((TankContainer) container).getCapacity()); 
						if((((Factory) faci).getStorageTanks().getMilkTank().getLitre()) + temp.getLitre() <=   ((Factory) faci).getStorageTanks().getMilkTank().getCapacity())
						{
							result = transferControl(temp, faci, container);
						}
					}
						
					else if(storageTanks.getMilkTank().getLitre()<((TankContainer) container).getCapacity()) 
					{
						IUncountable temp = new Milk(storageTanks.getMilkTank().getLitre()); 
						if((((Factory) faci).getStorageTanks().getMilkTank().getLitre()) + temp.getLitre() <=   ((Factory) faci).getStorageTanks().getMilkTank().getCapacity())
						{
							result = transferControl(temp, faci, container);
						}
					}
				
					
				}
				else
				{
					result = false;
					System.out.println("There is no milk in warehouse to transfer");	
				}
				break;
				
			case "Cacao":
				if(storageTanks.getCacaoTank().getLitre()>0) 
				{
					if(storageTanks.getCacaoTank().getLitre()>=((OpenTopContainer) container).getCapacity()) 
					{
						IUncountable temp = new Cacao(((OpenTopContainer) container).getCapacity()); 
						if((((Factory) faci).getStorageTanks().getCacaoTank().getLitre()) + temp.getLitre() <= ((Factory) faci).getStorageTanks().getCacaoTank().getCapacity())
						{
							result = transferControl(temp, faci, container);
						}
					}
					
					else if(storageTanks.getCacaoTank().getLitre()<((OpenTopContainer) container).getCapacity())
					{
						IUncountable temp = new Cacao(storageTanks.getCacaoTank().getLitre()); 
						if((((Factory) faci).getStorageTanks().getCacaoTank().getLitre()) + temp.getLitre() <= ((Factory) faci).getStorageTanks().getCacaoTank().getCapacity())
						{
							result = transferControl(temp, faci, container);
						}
					}
				}
				else
				{
					result = false;
					System.out.println("There is no cacao in warehouse to transfer");	
				}
				break;
				
				
			case "Cream":
				if(storageTanks.getCreamTank().getLitre()>0) 
				{
					if(storageTanks.getCreamTank().getLitre()>=((TankContainer) container).getCapacity()) 
					{
						IUncountable temp = new Cream(((TankContainer) container).getCapacity()); 
						if((((Factory) faci).getStorageTanks().getCreamTank().getLitre()) + temp.getLitre() <= ((Factory) faci).getStorageTanks().getCreamTank().getCapacity())
						{
							result = transferControl(temp, faci, container);
						}
					}
					
					else if(storageTanks.getCreamTank().getLitre()<((TankContainer) container).getCapacity()) 
					{
						IUncountable temp = new Cream(storageTanks.getCreamTank().getLitre()); 
						if((((Factory) faci).getStorageTanks().getCreamTank().getLitre()) + temp.getLitre() <= ((Factory) faci).getStorageTanks().getCreamTank().getCapacity())
						{
							result = transferControl(temp, faci, container);
						}
					}
				}
				else
				{
					result = false;
					System.out.println("There is no cream in warehouse to transfer");	
				}
				break;
				
			case "Yeast":
				if(storageTanks.getYeastTank().getLitre()>0) 
				{
					if(storageTanks.getYeastTank().getLitre()>=((OpenTopContainer) container).getCapacity()) 
					{
						IUncountable temp = new Yeast(((OpenTopContainer) container).getCapacity()); 
						if((((Factory) faci).getStorageTanks().getYeastTank().getLitre()) + temp.getLitre() <= ((Factory) faci).getStorageTanks().getYeastTank().getCapacity())
						{
							result = transferControl(temp, faci, container);
						}
					}
					
					else if(storageTanks.getYeastTank().getLitre()<((OpenTopContainer) container).getCapacity()) 
					{
						IUncountable temp = new Yeast(storageTanks.getYeastTank().getLitre()); 
						if((((Factory) faci).getStorageTanks().getYeastTank().getLitre()) + temp.getLitre() <= ((Factory) faci).getStorageTanks().getYeastTank().getCapacity())
						{
							result = transferControl(temp, faci, container);
						}
					}
				}
				else
				{
					result = false;
					System.out.println("There is no yeast in warehouse to transfer");	
				}
				break;

		}
		return result;
		
	}
	
	
	/* 
	 * Firstly, if  container can take the given item from the storage tank(milkTank or creamTank or cacaoTank or yeastTank)
	 * then we control that storage tank can remove the given item ( it is always true actually ) from storage tank(milkTank or creamTank or cacaoTank or yeastTank).
	 * If these are true then we apply the transfer.
	*/
	public boolean transferControl(IUncountable temp, Facilities faci,IContainer container) throws Exception 
	{
		boolean result = false;
		if(container.add((IUncountable) temp))
		{
				if(storageTanks.removeStorageTanks((IUncountable) temp))
				{
					container.transferTo((IUncountable) temp, faci);
					result = true;
				}
				else 
				{
					System.out.println("Tank/OpenTop Container transfer error");
					result = false;
				}
		}
		
		else 
		{
			System.out.println("Warehouse storageTank remove error.");
			result = false;
		}
		
		return result; 
	}
	
	public StorageTanks getStorageTank() 
	{
		return storageTanks;
	}
	public void setStorageTank(StorageTanks storageTanks) 
	{
		this.storageTanks = storageTanks;
	}
	
	
	
}
