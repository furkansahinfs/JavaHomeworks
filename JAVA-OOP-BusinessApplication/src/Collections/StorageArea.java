package Collections;

import java.util.LinkedList;
import java.util.Queue;
import Item.*;

public class StorageArea
{
	private double capacity; // capacity of area
	private Queue<ICountable> area;
	private double litre; //the litre of item in the area

	
	public StorageArea() 
	{
		this.litre=0;
		area = new LinkedList<ICountable>();
		this.setCapacity(10000);
	}


	/**
	 * We control that there exists enough space in the area
	 * if space is okey, then we add the item to the area and set the litre of area.
	 */
	public boolean add (ICountable eleman) 
	{
		boolean result=false;
		
		if (capacity>=eleman.getLitre()+litre)
		{
			area.add(eleman); 
			litre = litre+eleman.getLitre();
			result = true;
		}
		else
		{
			System.out.println("Storage area is full. Control the capacity from the display screen");
			result = false;
		}
	
		return result;
	}
	
	/**
	 * If there exists enough litre of item in the area, we remove the item.
	 * If litre of first item in area > given item's litre :
	 * set the litre of first item = litre of first item - given item's litre
	 * 
	 * If litre of first item in area < given item's litre :
	 * remove the first item in area
	 * set the  given item's litre = given item's litre - litre of first item 
	 * and until given item's litre is zero, remove the items in the area in order.
	 */
	public boolean remove(ICountable eleman) 
	{
		boolean result = false;
		double sayi = eleman.getLitre();
		if (sayi<=litre) 
		{
			while(sayi>0) {
				
				if(area.peek().getLitre()<=sayi) 
				{
					litre = litre-area.peek().getLitre();
					sayi=sayi-area.peek().getLitre();
					area.remove();
				
				}
				else 
				{
					area.peek().setLitre(area.peek().getLitre()-sayi);
					litre = litre-sayi;
					sayi=0;
				}
			}
			result = true;
		}
		
		else 
		{
			System.out.println("Storage areada verilen türde bu kadar eleman yok. Tür : "+ eleman.getClass().getSimpleName());
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
	public Queue<ICountable> getArea() {
		return area;
	}


	public void setArea(Queue<ICountable> area) {
		this.area = area;
	}
	
}
