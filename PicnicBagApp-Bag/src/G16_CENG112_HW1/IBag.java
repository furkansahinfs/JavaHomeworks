
package G16_CENG112_HW1;

public interface IBag<T> {
	
	 // add method adds the selected item to the bag if bag is not full and returns the situation is true or false.
	 public boolean add(T newItem);
	 // isEmpty method controls that the bag is empty or not and returns the situation is true or false.
	 public boolean isEmpty();
	 // isFull method controls that the bag is full or not and returns the situation is true or false.
	 public boolean isFull();
	 // removeByIndex method deletes the item which its index is given and it returns that item.
	 public T removeByIndex(int index);
	 // remove method deletes the item which is at the end of the bag and it returns that item.
	 public T remove();
	 // remove(newItem) method deletes the item which is given and it returns that item.
	 public T remove(T newItem);
	 // getItemCount method is returning the count of items in a bag.
	 public int getItemCount();
	 // getIndexOf method is returning the index of item which is defined.
	 public int getIndexOf(T newItem);
	 // contains method controls that item is in the bag or not and returns the situation is true or false.
	 public boolean contains(T newItem);
	 // displayItem displays all the items in the bag.
	 public void displayItems();
	 // removes all the items from the bag 
	 public void dump(); 
	 // trasnferTo transfers the item to the targetBag and returns the situation is true or false.
	 public boolean transferTo(IBag<T> targetBag, T newItem);
	 // I create a method to display the items in a bag. (It is not according to the quantity of item. It is according to the variety of item.)
	 public String[] selectItem();
	 // consume method transfers the consumed item to the trashbag according to its type and returns the situation is true or false.
	 public boolean consume(T item, IBag<T> trashBags);
}
