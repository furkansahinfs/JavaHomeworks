package Collections;
import java.util.Stack;

import Exceptions.*;
import Facilities.Facilities;
import Item.*;

public class DryStorageContainer implements IContainer
{
	private double chocolateDSCLitre; // if the given item is chocolate, this variable holds the litre of chocolates.
	private double boxedMilkDSCLitre; // if the given item is boxedMilk, this variable holds the litre of boxedMilk.
	private double yogurtDSCLitre; // if the given item is yogurt, this variable holds the litre of yogurt.
	private double litre; // the litre of items in the container
	private double capacity; // the capacity of container
	private Stack<ICountable> dryStorageContainer;
	
	private int pozisyon =2; // Pozisyon 1: warehouse, 2: factory, 3: distribution center. It holds the position of container
	
	public DryStorageContainer()
	{
		chocolateDSCLitre=0;
		boxedMilkDSCLitre=0;
		yogurtDSCLitre=0;
		dryStorageContainer = new Stack<ICountable>();
		this.capacity=1000;
		this.litre=0;
	}
	
	/**
	 * If the given item is not countable, throws ItemNotCountableException
	 * If it is countable control that there exists enough space in the container
	 * then if container is not empty and given item is same with item in the container, invoke the addControl method to add.
	 * if container is empty, invoke the addControl method to add.
	 */
	public <T> boolean add(T obje) throws ItemNotCountableException
	{
		if (!(obje instanceof ICountable)) 
		{
			throw new  ItemNotCountableException("item is not countable item: "+obje.getClass().getSimpleName());
		}
		
		boolean result = false;
		
		if(litre+((ICountable) obje).getLitre()>capacity) 
		{
			System.out.println("No enough space in Dry Storage Container");
			return false;
		}
		
		if(!dryStorageContainer.isEmpty()) 
		{
			if(dryStorageContainer.get(0).getClass().getSimpleName().equals(obje.getClass().getSimpleName())) 
			{
				result = addControl(obje);
			}
			else 
			{
				System.out.println("Item is not equal to item which is in the dry storage container");
				result = false;
			}
		}
		
		if(dryStorageContainer.isEmpty()) 
		{
			result = addControl(obje);
		}
		return result;
		
	}
	
	/**
	 * Firstly we analyse the type of the item (BoxedMilk or chocolate or yogurt)
	 * According to type we add the item to the container and set the litre of container. 
	 */
	
	public <T> boolean addControl(T obje) 
	{
		boolean result = false;
		switch ((((ICountable)obje).getClass().getSimpleName())) 
		{
	
			case "Chocolate":
				Chocolate chocolate = new Chocolate(((Chocolate)obje).getLitre());
				dryStorageContainer.push(chocolate);
				litre= litre + chocolate.getLitre();
				chocolateDSCLitre=chocolateDSCLitre+chocolate.getLitre();
				result=true;
				break;
				
			case "BoxedMilk":
				BoxedMilk boxedMilk = new BoxedMilk(((BoxedMilk) obje).getLitre());
				dryStorageContainer.push(boxedMilk);
				litre= litre + boxedMilk.getLitre();
				boxedMilkDSCLitre=boxedMilkDSCLitre+boxedMilk.getLitre();			
				result=true;
				break;
			
			case "Yogurt":
				Yogurt yogurt = new Yogurt(((Yogurt) obje).getLitre());
				dryStorageContainer.push(yogurt);
				litre= litre + yogurt.getLitre();
				yogurtDSCLitre=yogurtDSCLitre+yogurt.getLitre();	
				result=true;
				break;
			default:
				throw new IllegalArgumentException("Unexpected item is tried to be given to the dry storage container: " + obje.getClass().getSimpleName() );
				
		}
		return result;
		
	}
	
	
	/**
	 * Firstly we analyze the type of the item (BoxedMilk, chocolate, yogurt)
	 * According to type we remove the item to the container and set the litre of container. 
	 * If given item is unexpected type, we throw an IllegalArgumentException
	 */
	public boolean remove(Object obje) 
	{
		boolean result = false;
		switch (obje.getClass().getSimpleName()) 
		{	
			case "BoxedMilk":
				litre=litre-boxedMilkDSCLitre;
				boxedMilkDSCLitre=0;
				dryStorageContainer.clear();
				result = true;		
				break;
				
			case "Yogurt":
				litre=litre-yogurtDSCLitre;
				yogurtDSCLitre =0;
				dryStorageContainer.clear();
				result = true;
				break;
				
			case "Chocolate":
				litre=litre-chocolateDSCLitre;
				chocolateDSCLitre =0;
				dryStorageContainer.clear();
				result = true;
				break;	
			default :
				throw new IllegalArgumentException("Unexpected item is tried to be given to the dry storage container: " + obje.getClass().getSimpleName() );
				
		}
		
		return result;
	}
	
	
	/**
	 * Firstly we analyze the type of the item (BoxedMilk, chocolate, yogurt)
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
			case "BoxedMilk":
				BoxedMilk boxedMilk = (BoxedMilk) obje;
				boxedMilk.setLitre(boxedMilkDSCLitre);
				if(faci.add((T) boxedMilk))
				{
					remove(obje);
					result = true;
				}
				break;
				
			case "Yogurt":
				Yogurt yogurt = (Yogurt) obje;
				yogurt.setLitre(yogurtDSCLitre);
				if(faci.add((T) yogurt)) 
				{
					remove(obje);
					 result = true;
				}
				break;
			case "Chocolate":
				Chocolate chocolate = (Chocolate) obje;
				chocolate.setLitre(chocolateDSCLitre);
				if(faci.add((T) chocolate)) 
				{
					remove(obje);
					 result = true;
				}
				break;
				
			default:
				
				throw new IllegalArgumentException("Unexpected item is tried to be given to the dry storage container: " + obje.getClass().getSimpleName() );
				
		}
		return result;
	}
	public int getPozisyon() {
		return pozisyon;
	}

	public void setPozisyon(int pozisyon) {
		this.pozisyon = pozisyon;
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
	public double getChocolateDSCLitre() {
		return chocolateDSCLitre;
	}

	public void setChocolateDSCLitre(double chocolateDSCLitre) {
		this.chocolateDSCLitre = chocolateDSCLitre;
	}

	public double getBoxedMilkDSCLitre() {
		return boxedMilkDSCLitre;
	}

	public void setBoxedMilkDSCLitre(double boxedMilkDSCLitre) {
		this.boxedMilkDSCLitre = boxedMilkDSCLitre;
	}

	public double getYogurtDSCLitre() {
		return yogurtDSCLitre;
	}

	public void setYogurtDSCLitre(double yogurtDSCLitre) {
		this.yogurtDSCLitre = yogurtDSCLitre;
	}

	public Stack<ICountable> getDryStorageContainer() {
		return dryStorageContainer;
	}

	public void setDryStorageContainer(Stack<ICountable> dryStorageContainer) {
		this.dryStorageContainer = dryStorageContainer;
	}

	
}
