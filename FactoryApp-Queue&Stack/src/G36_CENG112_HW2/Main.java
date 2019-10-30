package G36_CENG112_HW2;

import java.util.Scanner;
import java.util.Random;



public class Main {

	public static void main(String[] args) {
		//Creating object 
		Item RAM = new Item("RAM");
		Item CPU = new Item("CPU");
		Item MBOARD = new Item("MOTHERBOARD");
		Item GCARD = new Item("GRAPHIC CARD");
		Item CACHE= new Item("CACHE");
		
		//Creating Warehouse 
		Stack<Item> ramStack = new Stack<>();
		Stack<Item> cpuStack = new Stack<>();
		Stack<Item> mboardStack = new Stack<>();
		Stack<Item> gcardStack = new Stack<>();
		Stack<Item> cacheStack = new Stack<>();
		
		//Creating Factory Line
		Queue<Item> line = new Queue<>();
		System.out.println("How many times does it run?");
		Scanner scan =  new Scanner(System.in);
		int count = scan.nextInt();
		Random rand = new Random();
		int request1;
		scan.close();
		
	for(int i = 0;i<count;i++)
	{
		
		request1 = rand.nextInt(3)+1;
		//System.out.println(request1);
		
		if (request1 ==1 ) //Marketing Analyst
		{
			
			//Request 2 represents item type
			int request2 = rand.nextInt(5)+1;
			
			if(request2 == 1) 
			{
				line.enqueue(RAM);
				if(line.isManufactured(RAM))
				{
				System.out.println("Marketing Analyst requesting RAM, SUCCESS, RAM manufactured.");
				line.ramisManifacture++;
				}
			}
			else if(request2 == 2)
			{
				line.enqueue(CPU);
				if(line.isManufactured(CPU))
				{
					System.out.println("Marketing Analyst requesting CPU, SUCCESS, CPU manufactured.");
					line.cpuisManifacture++;
				}
			}
			else if(request2 == 3)
			{
				line.enqueue(MBOARD);
				if(line.isManufactured(MBOARD))
				{
					System.out.println("Marketing Analyst requesting MOTHERBOARD, SUCCESS, MOTHERBOARD manufactured.");
					line.mboardisManifacture++;
				}
			}
		
			else if(request2 == 4)
			{
				line.enqueue(GCARD);
				if(line.isManufactured(GCARD))
				{
					System.out.println("Marketing Analyst requesting GRAPHIC CARD, SUCCESS, GRAPHIC CARD manufactured.");
					line.gcardisManifacture++;
				}
			}
			else if(request2 == 5)
			{
				line.enqueue(CACHE);
				if(line.isManufactured(CACHE))
				{
					System.out.println("Marketing Analyst requesting CACHE, SUCCESS, CACHE manufactured.");
					line.cacheisManifacture++;
				}
			}
			
				
		}
		
		else if(request1 == 2) //Storage Cheif
		{
			if(!line.isEmpty())
			{
				Item item = line.dequeue();
			
				if(item.type == "RAM")
				{
					ramStack.push(item);	
					if(ramStack.isStored(item))
					{
						System.out.println("Storage Chief storing RAM, SUCCESS, RAM stored in RAM warehouse.");
						ramStack.Stored++;
					}
				}
				else if(item.type == "CPU")
				{
					cpuStack.push(item);
					if(cpuStack.isStored(item))
					{
						System.out.println("Storage Chief storing CPU, SUCCESS, CPU stored in CPU warehouse.");
						cpuStack.Stored++;
					}
				}
				else if(item.type == "CACHE")
				{
					cacheStack.push(item);
					if(cacheStack.isStored(item))
					{
						System.out.println("Storage Chief storing CACHE, SUCCESS, CACHE stored in CACHE warehouse.");
						cacheStack.Stored++;
					}
				}
				else if(item.type == "MOTHERBOARD")
				{
					mboardStack.push(item);
					if(mboardStack.isStored(item))
					{
						System.out.println("Storage Chief storing MOTHERBOARD, SUCCESS, MBOARD stored in MOTHERBOARD warehouse.");
						mboardStack.Stored++;
					}
				}
				else if(item.type == "GRAPHIC CARD")
				{
					gcardStack.push(item);
					if(gcardStack.isStored(item))
					{
						System.out.println("Storage Chief storing GRAPHIC CARD, SUCCESS, GRAPHIC CARD stored in GRAPHIC CARD warehouse.");
						gcardStack.Stored++;
					}
				}
			}
			else
			{
				System.out.println("Storage Cheif storing, FAIL, Line is empty.");
			}
		
			
		}
		else if (request1 ==3) //Customer
		{
			
		
		
			int request3 = rand.nextInt(5)+1;
			
			if(request3 == 1)
			{
				ramStack.pop();
				if(ramStack.isSold(RAM))
				{
					System.out.println("Customer buying RAM, SUCCESS, Customer bought RAM.");
					ramStack.Sold++;
				}
				else
				{
					System.out.println("Customer buying RAM, FAIL, RAM warehouse empty.");
				}
			}
				
			
			else if(request3 == 2)
			{
				cpuStack.pop();
				if(cpuStack.isSold(CPU))
				{
					System.out.println("Customer buying CPU, SUCCESS, Customer bought CPU.");
					cpuStack.Sold++;
				}
				else
				{
					System.out.println("Customer buying CPU, FAIL, CPU warehouse empty.");
				}
			}
			else if(request3 == 3)
			{
				mboardStack.pop();
				if(mboardStack.isSold(MBOARD))
				{
					System.out.println("Customer buying MOTHERBOARD, SUCCESS, Customer bought MOTHERBOARD.");
					mboardStack.Sold++;
				}
				else
				{
					System.out.println("Customer buying MOTHERBOARD, FAIL, MOTHERBOARD warehouse empty.");
				}
			}
		
			else if(request3 == 4)
			{
				gcardStack.pop();
				if(gcardStack.isSold(GCARD))
				{
					System.out.println("Customer buying GRAPHIC CARD, SUCCESS, Customer bought GRAPHIC CARD.");
					gcardStack.Sold++;
				}
				else
				{
					System.out.println("Customer buying GRAPHIC CARD, FAIL, GRAPHIC CARD warehouse empty.");
				}
			}
			else if(request3 == 5)
			{
				cacheStack.pop();
				if(cacheStack.isSold(CACHE))
				{
					System.out.println("Customer buying CACHE, SUCCESS, Customer bought	CACHE.");
					cacheStack.Sold++;
				}
				else
				{
					System.out.println("Customer buying CACHE, FAIL, CACHE warehouse empty.");
				}
			}
			
				
		}
		
	}
	//Report Part
	System.out.println("Amount of RAM in Factory Line: "+line.ramisManifacture+ "\n" +
			"Amount of CPU in Factory Line: "+line.cacheisManifacture+"\n" +
			"Amount of Graphics Card in Factory Line: "+line.gcardisManifacture+"\n" +
			"Amount of Motherboard in Factory Line: "+line.cpuisManifacture+"\n" + 
			"Amount of Cache in Factory Line: "+line.mboardisManifacture+"\n");
	
	System.out.println("Amount of RAM in Warehouse: "+ramStack.Stored+"\n"+
			"Amount of CPU in Warehouse: "+cpuStack.Stored + "\n" +
			"Amount of Graphic Card in Warehouse: "+gcardStack.Stored + "\n" +
			"Amount of Motherboard in Warehouse: "+mboardStack.Stored+"\n"+
			"Amount of Cache in Warehouse: "+cacheStack.Stored+"\n");
	
	System.out.println("Amount of RAM Sold: "+ramStack.Sold + "\n" +
			"Amount of Cache Sold: "+cacheStack.Sold + "\n" +
			"Amount of Graphic Card Sold: "+gcardStack.Sold + "\n" +
			"Amount of CPU Sold: "+cpuStack.Sold + "\n" +
			"Amount of Motherboard Sold: "+mboardStack.Sold+"\n");
	
	}
}
