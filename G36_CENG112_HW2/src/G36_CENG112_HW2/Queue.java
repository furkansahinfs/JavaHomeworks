package G36_CENG112_HW2;

import java.util.Arrays;

public class Queue<T> implements IProduct<T>{

	private T[] queue;
	private int frontIndex;
	private int backIndex;
	public int ramisManifacture = 0;
	public int cacheisManifacture = 0;
	public int gcardisManifacture = 0;
	public int mboardisManifacture = 0;
	public int cpuisManifacture = 0;
	
	
	@SuppressWarnings("unchecked")
	public Queue()
	{
		frontIndex = 0;
		backIndex = 0;
		queue = (T[]) new Object[2];
	}
	public void enqueue(T newItem)
	{
		
		if(!isFull())
		{
			for(int i=0;i<queue.length;i++)
			{
				if(queue[i]== null)
				{
					queue[i]= newItem;
					backIndex++;
					break;
				}
			}
		}
		
		else
		{
			
			ensureCapacity();
			for(int i=backIndex;i<queue.length;i++)
			{
				if(queue[i]== null)
				{
					queue[i]= newItem;
					backIndex++;
					break;
				}
			}
		}
		
		}
	
	
	public T dequeue()
	{
	
		if(!isEmpty())
		{
			T tempItem = queue[frontIndex];
			queue[frontIndex] = null;
			for(int i=1;i<=backIndex-1;i++)
			{
				queue[i-1]=queue[i];
			}
			queue[backIndex-1]=null;
			backIndex--;
			return tempItem;
		}
		else
		{
			System.out.println("Line is empty.");
			return null;
		}
	}
	
	public boolean isFull()
	{
		int count = 0;
		for(int i=0;i<queue.length;i++)
		{
			if(queue[i]!= null)
			{
				count++;
			}
		}
		if(count == queue.length)
		{
			return true;
		}
		return false;
	}
	public boolean isEmpty()
	{
		if(frontIndex == backIndex)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void ensureCapacity() {
		
		if(backIndex == queue.length)
		{
			int newLength = 2*queue.length;
			queue=Arrays.copyOf(queue, newLength);
		}
	}
	

	@Override
	public boolean isManufactured(T newItem) {
		if(newItem == queue[backIndex-1])
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isStored(T newItem) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSold(T newItem) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void display()
	{
		System.out.println("QUEUE:");
		for(int i=frontIndex;i<backIndex;i++)
		{
			System.out.println(queue[i]);
		}
	}
}
