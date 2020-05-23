package Collections;
import java.util.Stack;

import Exceptions.DifferentUncountableItemsException;
import Exceptions.ItemNotUncountableException;
import Facilities.*;
import Item.*;
public class TankContainer implements IContainer {
	
	private double litre; // the litre of items in the container
	private double capacity; // the capacity of container
	private double milkTCLitre; // if the given item is milk, this variable holds the litre of milk.
	private double creamTCLitre; // if the given item is cream, this variable holds the litre of cream.
	private int pozisyon =2; // Pozisyon 1: warehouse, 2: factory, 3: distribution center. It holds the position of container

	private Stack<IUncountable> tankContainer;

	
	
	public TankContainer() 
	{	tankContainer = new Stack<IUncountable>();
		milkTCLitre = 0;
		creamTCLitre=0;
		this.capacity=1000;
		this.litre=0;
	}
	

	/**
	 * If the given item is not uncountable, throws ItemNotUncountableException
	 * If it is uncountable control that there exists enough space in the container
	 * then if container is not empty and given item is same with item in the container, invoke the addControl method to add.
	 * if container is empty, invoke the addControl method to add.
	 */
	
	public<T> boolean add(T obje) throws ItemNotUncountableException, DifferentUncountableItemsException
	{
		if (!(obje instanceof IUncountable)) 
		{
			throw new  ItemNotUncountableException("item is not countable item: "+obje.getClass().getSimpleName());
		}
		
		boolean result = false;
		if(litre+((IUncountable) obje).getLitre()>capacity) 
		{
			System.out.println("No enough space in Tank Container");
			return false;
		}
		
		if(!tankContainer.isEmpty()) 
		{
			if(tankContainer.get(0).getClass().getSimpleName().equals(obje.getClass().getSimpleName())) 
			{
				result = addControl(obje);
			}
			else 
			{
				throw new DifferentUncountableItemsException("different uncountable item");
			}
		}
		
		if(tankContainer.isEmpty()) 
		{
			result = addControl(obje);
		}
		return result;
		
	}
	
	
	/**
	 * Firstly we analyse the type of the item (milk or cream)
	 * According to type we add the item to the container and set the litre of container. 
	 */
	public <T> boolean addControl(T obje) 
	{
		boolean result = false;
		switch (((IUncountable) obje).getClass().getSimpleName()) 
		{
		case "Milk":
			Milk milk = (Milk) obje;
			tankContainer.push(milk);
			litre= litre + milk.getLitre();
			milkTCLitre=milkTCLitre+milk.getLitre();
			result = true;
			break;
			
		case "Cream":
			Cream cream = (Cream) obje;
			tankContainer.push(cream);
			litre= litre + cream.getLitre();
			creamTCLitre=creamTCLitre+cream.getLitre();		
			result = true;
			break;
			
		}
		return result;
	}
	
	
	/**
	 * Firstly we analyse the type of the item (milk or cream)
	 * According to type we remove the item to the container and set the litre of container. 
	 * If given item is unexpected type, we throw an IllegalArgumentException
	 */
	public<T> boolean remove(T obje) 
	{
		boolean result = false;
		switch (obje.getClass().getSimpleName()) 
		{	
		case "Milk":
			litre=litre-milkTCLitre;
			milkTCLitre=0;
			tankContainer.clear();
			result = true;		
			break;
			
		case "Cream":
			litre=litre-creamTCLitre;
			creamTCLitre =0;
			tankContainer.clear();
			result = true;
			break;
			
		default :
			throw new IllegalArgumentException("Unexpected item is tried to be given to the tank container: " + obje.getClass().getSimpleName() );
		}
		
		return result;
	}
		
		
	/**
	 * Firstly we analyze the type of the item (milk or cream)
	 * and create a new item which its litre is equal to litre of item in the container.
	 * After that we try to transfer (add to facitily) the item. If transfer is succesfull we invoke the remove method of container.
	 *  If given item is unexpected type, we throw an IllegalArgumentException
	 */

	@SuppressWarnings("unchecked")
	public <T> boolean transferTo(T obje,Facilities faci) 
	{
		boolean result = false;
		switch (obje.getClass().getSimpleName()) 
		{
		case "Milk":
			Milk milk = (Milk) obje;
			milk.setLitre(milkTCLitre);
			if(faci.add((T) milk))
			{
				remove(obje);
				result = true;
			}
			break;
			
		case "Cream":
			Cream cream = (Cream) obje;
			cream.setLitre(creamTCLitre);
			if(faci.add((T) cream))
			{			
				remove(obje);
				 result = true;
			}
			break;
		default :
			throw new IllegalArgumentException("Unexpected item is tried to be given to the tank container: " + obje.getClass().getSimpleName() );
		
			}
		return result;
	}
	
	
	public Stack<IUncountable> getTankContainer() {
		return tankContainer;
	}

	public void setTankContainer(Stack<IUncountable> tankContainer) {
		this.tankContainer = tankContainer;
	}
	
	public double getMilkTCLitre() {
		return milkTCLitre;
	}
	public void setMilkTCLitre(double milkTCLitre) {
		this.milkTCLitre = milkTCLitre;
	}
	public double getCreamTCLitre() {
		return creamTCLitre;
	}
	public void setCreamTCLitre(double creamTCLitre) {
		this.creamTCLitre = creamTCLitre;
	}
	
	public double getLitre() {
		return litre;
	}

	public void setLitre(double litre) {
		this.litre = litre;
	}

	public double getCapacity() {
		return capacity;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	public int getPozisyon() {
		return pozisyon;
	}

	public void setPozisyon(int pozisyon) {
		this.pozisyon = pozisyon;
	}

}
