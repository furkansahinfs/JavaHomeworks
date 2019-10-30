package G01_CENG211_HW1;

import java.util.Arrays;

//We create our Array Class
public class ArrayX {

	public Object[] liste;
	public int urunSayisi; // number of the objects in the array.
	public int sinir; // capacity of the array
	
	// We create the constructor
	public ArrayX(int elemanKapasitesi) 
	{
		liste = new Object[elemanKapasitesi];
		urunSayisi = 0;
		sinir = elemanKapasitesi; // make list capacity equal to given capacity.
	}
	
	
	// If list is not full, we add the given object to the list. If not, we double the capacity and add the object.
	public void add(Object urun )
	{
		if(urunSayisi<sinir)
		{
			liste[urunSayisi] =urun;
			urunSayisi++;
		}
		else
		{
			ensureCapacity();
			add(urun);
		}
	}
	
	// If list is not full, we add the given object to the given index of list. If not, we double the capacity and add the object.
	public void addEkle(Object urun,int index ) 
	{
		if(index>=0 && index <= urunSayisi && urunSayisi<sinir) 
		{
			for(int i = urunSayisi-1;i>=index;i--) 
			{
				liste[i+1]=liste[i];
			}
			liste[index]=urun;
			urunSayisi++;
		}
		
		else
		{
			ensureCapacity();
			addEkle(urun,index);
		}
	}
	
	// Our get and set methods:
	public Object[] getList()
	{
		return liste;
	}

	
	public void setList(City[] liste) 
	{
		this.liste = liste;
	}
	
	// It is the remove method which deletes the object from the end of the list.
	public Object removeEnd() 
	{
		if(urunSayisi!=0) 
		{
			Object temp = liste[urunSayisi];
			liste[urunSayisi]=null;
			urunSayisi--;
			return temp;
		}
		
		else 
		{
			System.out.println("Silme hatası - end");
			return null;
		}
	}
	
	// It is the remove method which deletes the object according to given index and arrange the list to fill the deleted index.   
	public void remove(int index) 
	{
		if(index>=0 && index<urunSayisi) 
		{
			for(int i = index;i<urunSayisi-1;i++) 
			{
				liste[i]=liste[i+1];
			}
			urunSayisi--;
		}
		
		else
		{
			System.out.println("Silme hatası - index");
		}
	}
	
	// It is the remove method which deletes the object from the front of the list and arrange the list to fill the first index.
	public Object removeFront() 
	{
		if(urunSayisi!=0) 
		{
			Object temp = liste[0];			
			for(int i=0;i<urunSayisi-1;i++) 
			{
				liste[i]=liste[i+1];
			}
			urunSayisi--;
			return temp;
		}
		else 
		{
			System.out.println("Silme hatası - front");
			return null;
		}
	}
	
	// We make all the index null. It is better to make only number of objects zero but we cannot be sure that it can occur some problem in other methods.
	public void clear() 
	{
		for(int i=0;i<urunSayisi;i++) 
		{
			if(urunSayisi!=0) 
			{
				liste[i]=null;
			}
		} 
		urunSayisi=0;
	}
	
	// If capacity is full, we double the list.
	public void ensureCapacity() {
		int capacity = this.liste.length-1;
		if(urunSayisi>=capacity)
		{
			int newCapacity = 2*capacity;
			this.sinir = newCapacity+1;
			this.liste = Arrays.copyOf(this.liste, sinir+1);
		}
	}
	
	// We print the all objects of list.
	public void yaz() 
	{
		for(int i=0;i<urunSayisi;i++)
		{	
			System.out.println(liste[i].toString()+" ");
		}
	}

}
