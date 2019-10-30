package G36_CENG112_HW2;

import java.util.Arrays;

public class Stack<T> implements IProduct<T>{

	private T[] stack;
	private int topIndex;
	public int Sold = 0;
	public int Stored = 0;

	
	@SuppressWarnings("unchecked")
	public Stack()
	{
		stack = (T[]) new Object[3];
	}
	public void push(T newItem)
	{
		
		if(stack[stack.length-1]!=null && newItem !=null)
		{
			stack[topIndex] = newItem;
			topIndex++;
		}
		else
		{
			ensureCapacity();
			if(stack[topIndex]== null && newItem !=null)
				{
					stack[topIndex]= newItem;
					topIndex++;
				
				}
			}
		}
	
	
	public T pop()
	{
		if(!isEmpty()) {
			T tempItem = stack[topIndex-1];	
			stack[topIndex-1] = null;
			topIndex--;
			return tempItem;
		}
		else
		{
			//System.out.println("Warehouse is empty.");
			return null;

		}
		
	
	}
	
	
	public boolean isEmpty()
	{
		for(int i=0;i<topIndex;i++)
		{
			if(stack[i]!=null)
			{
				return false;
			}
			
		}
		return true;
		
	}
	
	public void ensureCapacity() {
		if(topIndex == stack.length-1)
		{
			int newLength = 2*stack.length;
			stack=Arrays.copyOf(stack, newLength);
		}
	}
	
	
	@Override
	public boolean isManufactured(T newItem) {
		
		return false;
	}

	@Override
	public boolean isStored(T newItem) {
		if(!isEmpty())
		{
			if(newItem == stack[topIndex-1])
			{
				return true;
			}
		}
		return false;
				
	}
	

	@Override
	public boolean isSold(T newItem) {
		if(!isEmpty())
		{
			if(newItem == pop())
			{
				return true;
			}
		}
				
		return false;
		
	}
	
	
	public void display()
	{
		System.out.println("STACK:");
		for(int i=0;i<topIndex;i++)
		{
			System.out.println(stack[i]);
		}
	}
}
