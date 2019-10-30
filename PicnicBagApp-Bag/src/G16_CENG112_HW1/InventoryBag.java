// G-16 FURKAN ŞAHİN. HOCAM GRUP ARKADAŞIM ÖDEVİ YAPMAYACAĞINI BELİRTTİ. ÖDEVİ KENDİM YAPTIM VE KENDİM (FURKAN ŞAHİN) ADINA ÖDEVİ TESLİM ETMEK İSTİYORUM. ARKADAŞ İLE BU DURUMU KONUŞTUM. PUANLARKEN SADECE FURKAN ŞAHİN ADINA PUANLARSANIZ SEVİNİRİM.



package G16_CENG112_HW1;

public class InventoryBag<T> implements IBag<T> {

	
	// I create my variables.
	private T[] bag = (T[]) new Object[500];
	public String[] display_bag = new String[500];
	private int numberOfEntries;
	
	// I create a constructor and firstly I adjust the numberOfEntires as zero.
	public InventoryBag()
	  {		
		numberOfEntries =0;	
	  }
	
	@Override
	public boolean add(T newItem) 
	{
		// If bag is not full I add the item to the bag and I increase numberOfEntries and it returns the situation is true or false.
		boolean result = false;
		if (!isFull())
		{
			bag[numberOfEntries] = newItem;
	    	numberOfEntries++;
	    	result = true;
	    }
	   	   
	    else
	    {   
	    	result = false;
	    }    
		return result;
	}

	
	@Override
	public boolean isFull() 
	{
		// If numberOfEntires is equal or greater than length of bag I display a warning and it returns the situation is true or false.
		if( numberOfEntries >= bag.length) 
		{
			System.out.println("InventoryBag is full! You can not add any object until you remove object from InventoryBag.");
			return true;
		}
		
		else 
		{
			return false;
		}
		
	}
	
		
	@Override
	public boolean isEmpty()
	{
		// If numberOfEntries is equal to zero it returns true, is not it returns false.
		return numberOfEntries == 0;
	}
	

	@Override
	public T removeByIndex(int index)
	{
		//If bag is not empty and given index is equal or greater than zero I delete the item which its index is given and it returns that Item.
		// I transfer the item which is at the end of the bag to the index of deleted item. Item which is on last index is equaled to null and numberOfEntries is decreased. 
		// Else it returns null.
		
		T result = null;
		if(!isEmpty() && index >0) 
		{
			result = bag[index-1];
			bag[index-1] = bag[numberOfEntries-1];
			bag[numberOfEntries-1] = null;
			numberOfEntries --;	
			System.out.println("Item is removed from inventoryBag");
		}
		return result;		
	}

	
	@Override
	public T remove()
	{
		//If bag is not empty I delete the item which is at the end of the list and it returns that Item.
		//Else it returns null.
		T result = removeByIndex(numberOfEntries - 1);
		return result;
	}

	
	@Override
	public T remove(T item) 
	{		
		// If selected item is in the bag I delete the item and it returns that Item.
		// I transfer the item which is at the end of the bag to the index of deleted item. Item which is on last index is equaled to null and numberOfEntries is decreased. 
		// Else it returns null.
		for(int i=0;i<numberOfEntries;i++)
		{
			
			if(item.equals(bag[i])) 
			{
				System.out.println("Item is removed from inventoryBag");
				bag[i]=	bag[numberOfEntries-1];
				bag[numberOfEntries-1] = null;
				numberOfEntries--;
				break;
			}
		}
		
		
		return item;		
	}

	
	@Override
	public int getItemCount() 
	{
		// I print the numerOfEntries and it returns it.
		System.out.println("Item count is : " + numberOfEntries);
		 return numberOfEntries;
	}

	
	@Override
	public int getIndexOf(T item) 
	{
		// If the selected item is in the bag, I find its index and it returns the index. Else it returns -1.
		int where = -1;
		for(int i=0;i<numberOfEntries;i++) 
		{
			if(item.equals(bag[i])) 
			{
				System.out.println("bagi " + bag[i]);
				System.out.println("index = "+i);
				where=i;
				break;
			}
		}
		
		return where;
	}

	
	@Override
	public boolean contains(T item) {
		// If the selected item is in the bag I return true. Else it returns false.
		boolean containis = false;
		for(int i=0;i<numberOfEntries;i++) 
		{
			if(item.equals(bag[i])) 
			{
				containis = true;
				break;
			}
		}
		
		return containis;
	}
	
	
	public void displayItems() 
	{		
		// I print all the items in the bag.
		for(int i=0;i<numberOfEntries;i++)
		{
			
			System.out.println("Index number :" + (i+1) + " -- "+ bag[i].toString());
		}

	}
	

	@Override
	public void dump() 
	{
		// I delete all the items in the bag.
		for(int i=0;i<numberOfEntries;i++)
		{
			bag[i]=null;
		}
	}

	
	@Override
	public boolean transferTo(IBag<T> targetBag, T item)
	{	
		// If selected item is in the bag and if the add method returns true and I remove the item, I add the item to the targetBag and I remove it from the InventoryBag. It returns true.
		// Else It returns false.
		if(contains(item))
		{
			if(targetBag.add(item))
			{
				
				if(remove(item).equals(item))
				{
					System.out.println("Item is added to picnic bag.");
					return true;
				}
				else
				{
					return false;
				}
			}
			else
			{
			return false;
			}
		}
		else
		{
			System.out.println("InventoryBag does not include that object.");
			return false;
		}
	}
	
	public String[] selectItem()
	{
		// I create a method to display the items in a bag. (It is not according to the quantity of item. It is according to the variety of item.)
		// Example:
		// Index number of item : 1 banana organic
		// Index number of item : 2 potato organic
		// Index number of item : 3 slice of cheese organic...
		// And it returns that list.
		
		int i = 0;
		int j = 0;
		display_bag[0] = bag[0].toString();
		System.out.println("To select : Index number of item :" + (i+1) + " " + display_bag[i]);
		
		while(i<display_bag.length)
		{			
			while(j<numberOfEntries)
			{
				if(display_bag[i].equalsIgnoreCase(bag[j].toString()))
				{				
					if(display_bag[i] !=null)
					{
						j++;
						continue;						
					}							
				}
				
				else
				{	
					if(display_bag[i] != null )
					{
						i++;
						display_bag[i] = bag[j].toString();
						System.out.println("To select : Index number of item :" + (i+1) + " " + display_bag[i]);
						continue;
					}
					
					else
					{
	
						i++;
					}
				}
								
			}
			break;
			
	}
		return display_bag;
	

}

	@Override
	public boolean consume(T item, IBag<T> trashBags) {
		// TODO Auto-generated method stub
		return false;
	}
}
