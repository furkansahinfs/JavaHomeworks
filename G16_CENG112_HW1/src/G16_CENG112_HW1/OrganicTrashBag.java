// G-16 FURKAN ŞAHİN. HOCAM GRUP ARKADAŞIM ÖDEVİ YAPMAYACAĞINI BELİRTTİ. ÖDEVİ KENDİM YAPTIM VE KENDİM (FURKAN ŞAHİN) ADINA ÖDEVİ TESLİM ETMEK İSTİYORUM. ARKADAŞ İLE BU DURUMU KONUŞTUM. PUANLARKEN SADECE FURKAN ŞAHİN ADINA PUANLARSANIZ SEVİNİRİM.


package G16_CENG112_HW1;

public class OrganicTrashBag<T> implements IBag<T>  {
	
	// I create my variables.
	private int DEFAULT_CAPACITY=0;
	private T[] organictrashbag = (T[]) new Object[DEFAULT_CAPACITY];
	private int numberOfEntries;
	
	// I create a constructor and firstly I adjust the numberOfEntires as zero.
	public OrganicTrashBag() 
	{
		numberOfEntries =0;
	}
	
	@SuppressWarnings("unchecked")
	// I create a constructor which is taken a parameter and according to the parameter I create a organictrashbag.
	public OrganicTrashBag(int boyut) 
	{
		organictrashbag = (T[]) new Object[boyut];
	}


	public boolean add(T newItem) 
	{
		// If bag is not full I add the item to the bag and I increase numberOfEntries and it returns the situation is true or false.
		boolean result = false;
		if (!isFull())
		{
	    	organictrashbag[numberOfEntries] = newItem;
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
		if( numberOfEntries >= organictrashbag.length)
		{
			System.out.println("OrganicTrashBag is full! You can not add any object until you remove object from organicbag.");
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
			result= organictrashbag[index-1];			
			organictrashbag[index-1] = organictrashbag[numberOfEntries-1];
			organictrashbag[numberOfEntries-1] = null;
			numberOfEntries --;
			System.out.println("Item is removed from OrganicTrashBag");
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
			
			if(item.equals(organictrashbag[i])) 
			{
				System.out.println("Item is removed from OrganicTrashBag");
				organictrashbag[i]=organictrashbag[numberOfEntries-1];
				organictrashbag[numberOfEntries-1] = null;
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
			if(item.equals(organictrashbag[i])) 
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
			if(item.equals(organictrashbag[i]))
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
				System.out.println(organictrashbag[i].toString());
			}
		}
		else
		{
			System.out.println("OrganicTrashBag is empty");
		}
	}

	@Override
	public void dump()
	{
		// I delete all the items in the bag.
		for(int i=0;i<numberOfEntries;i++) 
		{
			organictrashbag[i]=null;
		}
		
	}

	@Override
	public boolean transferTo(IBag<T> targetBag, T item) {
		
		return true;
		
	}
	@Override
	public String[] selectItem() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean consume(T item, IBag<T> trashBags) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
