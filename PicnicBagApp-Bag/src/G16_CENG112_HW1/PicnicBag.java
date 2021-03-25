
package G16_CENG112_HW1;

public class PicnicBag<T> implements IBag<T>
{
	// I create my variables.
	private int DEFAULT_CAPACITY=0;
	@SuppressWarnings("unchecked")
	private T[] picnicbag = (T[]) new Object[DEFAULT_CAPACITY];
	public String[] display_bag = new String[500];
	private int numberOfEntries;
	
	// I create a constructor and firstly I adjust the numberOfEntires as zero.
	public PicnicBag() 
	{
		numberOfEntries =0;
	}
	@SuppressWarnings("unchecked")
	// I create a constructor which is taken a parameter and according to the parameter I create a picnicbag and displayBag list.
	public PicnicBag(int boyut) 
	{
		picnicbag = (T[]) new Object[boyut];
		display_bag = new String[boyut];
	}

	@Override
	public boolean add(T newItem) 
	{
		// If bag is not full I add the item to the bag and I increase numberOfEntries and it returns the situation is true or false.
		boolean result = false;
		if (!isFull())
		{
	    	picnicbag[numberOfEntries] = newItem;
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
	public boolean isEmpty()
	{
		// If numberOfEntries is equal to zero it returns true, is not it returns false.
		return numberOfEntries == 0;
	}

	@Override
	public boolean isFull() 
	{
		// If numberOfEntires is equal or greater than length of bag I display a warning and it returns the situation is true or false.
		if( numberOfEntries >= picnicbag.length)
		{
			System.out.println("PicnicBag is full! You can not add any object until you remove object from picnic bag.");
			 return true;
		}
		else
		{
			return false;
		}
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
			result= picnicbag[index-1];			
			picnicbag[index-1] = picnicbag[numberOfEntries-1];
			picnicbag[numberOfEntries-1] = null;
			numberOfEntries --;
			System.out.println("Item is removed from PicnicBag");
		}
		
		return result;
	}

	@Override
	public T remove() 
	{
		//If bag is not empty I delete the item which is at the end of the list and it returns that Item.
		//Else it returns null.
		T result2 = removeByIndex(numberOfEntries - 1);
		return result2;
	}

	@Override
	public T remove(T item)
	{
		// If selected item is in the bag I delete the item and it returns that Item.
		// I transfer the item which is at the end of the bag to the index of deleted item. Item which is on last index is equaled to null and numberOfEntries is decreased. 
		// Else it returns null.
		for(int i=0;i<numberOfEntries;i++)
		{
			
			if(item.equals(picnicbag[i])) 
			{
				System.out.println("Item is removed from picnicBag");
				picnicbag[i]=picnicbag[numberOfEntries-1];
				picnicbag[numberOfEntries-1] = null;
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
			if(item.equals(picnicbag[i])) 
			{
				where=i;
				break;
			}
		}
		return where;
	}

	@Override
	public boolean contains(T item) 
	{
		// If the selected item is in the bag I return true. Else it returns false.
		boolean containis = false;
		for(int i=0;i<numberOfEntries;i++) 
		{
			if(item.equals(picnicbag[i]))
			{
				containis = true;
				break;
			}
		}
		return containis;
	}

	@Override
	public void displayItems() {
		// I print all the items in the bag.
		if(!isEmpty())
		{
			for (int i=0;i<numberOfEntries;i++) 
			{
				System.out.println("Index number :" + (i+1) + " -- "+ picnicbag[i].toString());
			}
		}
		else
		{
			System.out.println("PicnicBag is empty.");
		}
	}

	@Override
	public void dump()
	{
		// I delete all the items in the bag.
		for(int i=0;i<numberOfEntries;i++) 
		{
			picnicbag[i]=null;
		}
		
	}

	@Override
	public boolean transferTo(IBag<T> targetBag, T item) {
		// If selected item is in the bag and if the add method returns true and I remove the item, I add the item to the targetBag and I remove it from the InventoryBag. It returns true.
		// Else It returns false.
		if(contains(item))
		{
			if(targetBag.add(item))
			{
				if(remove(item).equals(item))
				{
					System.out.println("Item is added to targeted bag.");
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
			System.out.println("PicnicBag does not include that object.");
			return false;
		}
		
	}
	@Override
	public String[] selectItem() {
		// I create a method to display the items in a bag. (It is not according to the quantity of item. It is according to the variety of item.)
		// Example:
		// Index number of item : 1 banana organic
		// Index number of item : 2 potato organic
		// Index number of item : 3 slice of cheese organic...
		// And it returns that list.
		if(!isEmpty())
		{
			int i = 0;
			int j = 0;
			display_bag[0] = picnicbag[0].toString();
			System.out.println("To select : Index number of item :" + (i+1) + " " + display_bag[i]);
					
			while(i<display_bag.length)
			{			
				while(j<numberOfEntries)
				{
					if(display_bag[i].equalsIgnoreCase(picnicbag[j].toString()))
					{				
						if(display_bag[i] !=null)
						{
							j++;
							continue;						
						}							
					}
							
					else
					{	
						if(display_bag[i] != null)
						{
							i++;
							display_bag[i] = picnicbag[j].toString();
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
		else
		{
			return null;
		}
	}
	
	 public boolean consume(T item, IBag<T> trashBags)
	 {
		// If numberOfEntires is equal or greater than length of bag I display a warning and it returns the situation is true or false.
		 if(contains(item))
			{
			 transferTo(trashBags,item);
			 return true;
			}
		 else
		 {
			 return false;
		 }
		 
	 }

}
