// G-16 FURKAN ŞAHİN. HOCAM GRUP ARKADAŞIM ÖDEVİ YAPMAYACAĞINI BELİRTTİ. ÖDEVİ KENDİM YAPTIM VE KENDİM (FURKAN ŞAHİN) ADINA ÖDEVİ TESLİM ETMEK İSTİYORUM. ARKADAŞ İLE BU DURUMU KONUŞTUM. PUANLARKEN SADECE FURKAN ŞAHİN ADINA PUANLARSANIZ SEVİNİRİM.


package G16_CENG112_HW1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class PicnicBagApp {
	

	public static void main(String[] args)  {
		
		// I create necessary things.
		FileIO fileIO = new FileIO();
		IBag<Item> inventoryBag = fileIO.readInventory();
		boolean devam = true;
	
		
			// I take an input from the user which is the size of bag.
			System.out.println("Select the size of your bag (Small, Medium, Big) ");

			Scanner scanner = new Scanner(System.in);
			String boyut = scanner.next();
			int boyutsayi = 0;
			
			if(boyut.equalsIgnoreCase("Small"))
			{
				boyutsayi = 5;
			}
			else if(boyut.equalsIgnoreCase("Medium"))
			{
				boyutsayi = 10;
			}
			else if(boyut.equals("Big"))
			{
				boyutsayi = 15;
			}
			else if(!boyut.equalsIgnoreCase("Small") || !boyut.equalsIgnoreCase("Medium") || !boyut.equalsIgnoreCase("Big"))
			{
				System.out.println("Yanlış boyut girildi.");
			}
			

			
			// I create my bags according to the given size.
			IBag<Item> picnic_bag = new PicnicBag(boyutsayi);
			IBag<Item> organictrashbag = new OrganicTrashBag(boyutsayi);
			IBag<Item> plastictrashbag = new PlasticTrashBag(boyutsayi);
			IBag<Item> papertrashbag = new PaperTrashBag(boyutsayi);
			
	

		while(true)
		{
			System.out.println("\nWhich bag ? InvenotryBag : 1, PicnicBag and trashbags : 2, To quit : 3");
			Scanner tara = new Scanner(System.in);
			int secim = tara.nextInt();
			
			
			
			if (secim == 1)
			{
				
				
				// If user select the İnventoryBag to do some processes, I run codes below.
				System.out.println("\nTo select an item : 1, To display the inventorybag : 2, To remove an item with index number : 3, To remove an item : 4 ");
				Scanner tara2 = new Scanner(System.in);
				int secim2 = tara2.nextInt();
				
				
				if(secim2 == 1)
				{ 
					// If user want to select an item, I display the items wtih index which user can select.
					// I split selected item according to the name and type. I save the type of item through boolean to use some processes after.
					String[] display_bag_inventory = inventoryBag.selectItem();
					System.out.println("\nSelect an item according to index\n");	
					Scanner scan = new Scanner(System.in);
					int index = scan.nextInt();
					String[] split_item = null;
					Item selecteditem = new Item(null,null);
					boolean organic = false;
					boolean plastic = false;
					boolean paper = false;
					try
					{
						if(plastic != true && paper != true)
						{
							split_item = display_bag_inventory[index-1].split(" organic");
							if(split_item[0].length() < display_bag_inventory[index-1].length())
							{
							organic = true;
							}
						}
						if(organic != true && plastic != true)
						{
							split_item = display_bag_inventory[index-1].split(" paper");
							if(split_item[0].length() < display_bag_inventory[index-1].length())
							{
							paper = true;
							}
						}
						if(organic != true && paper != true)
						{
							split_item = display_bag_inventory[index-1].split(" plastic");
							if(split_item[0].length() < display_bag_inventory[index-1].length())
							{
							plastic = true;
							}
						}
					}
					finally {
					    // ... cleanup that will execute whether or not an error occurred ...
					}
					
					// I take the saved type from the code which is above and according to that I create an item to use.
					if(organic)
					{
						selecteditem = new Item(split_item[0],"organic");
					}
					else if(paper)
					{
						selecteditem = new Item(split_item[0],"paper");
					}
					if(plastic)
					{
						selecteditem = new Item(split_item[0],"plastic");
					}
					
					System.out.println("\nSelected item is : " + selecteditem+"\n");
				
					System.out.println("\nTo add an item to picnicbag : 1, to remove from inventoryBag: 2");
					Scanner tara3 = new Scanner(System.in);
					int secim3 = tara3.nextInt();
					
					
					if(secim3 == 1)
					{		
						// If user select the adding an item to picnicbag I control the contains method.
						// If method returns true, I add the item to picnic bag through transferTo method and I print items count.
						if(inventoryBag.contains(selecteditem)) {
							System.out.println("\nItem is found in the inventoryBag.");
								inventoryBag.transferTo(picnic_bag, selecteditem);
								System.out.println("\nItem count updated.");
								inventoryBag.getItemCount();
					}
					}
					
					
					
					if(secim3==2)
					{
						// If user select the removing an item, I remove an item and print item count.
						inventoryBag.remove(selecteditem);
						System.out.println("\nItem count updated.");
						inventoryBag.getItemCount();
					}
					
					
					
					
				}
				
				
				
			
				if(secim2==2)
				{
					// If user select the displaying bag, I display.
					inventoryBag.displayItems();
				}
				
				
				
				if(secim2==3)
				{
					// If user select removing item according to index number,I display the removable items with their index number.
					// After that I remove the selected item.
					inventoryBag.displayItems();
					System.out.println("\nSelect an item according to index\n");	
					Scanner scan = new Scanner(System.in);
					int index = scan.nextInt();
					inventoryBag.removeByIndex(index);
					
				}
				
				
				
				if(secim2==4)
				{
					// If user select removing, I remove an item with remove method.
					inventoryBag.remove();
				}
				
			
				
			}
				if(secim==2)
				{
					// If user select picnic bag, I run codes below.
					System.out.println("\nTo select an item to consume : 1, To display the picnicbag : 2, To display the trashbags : 3, To remove an item with index number : 4, To remove an item : 5");
					Scanner tarap2 = new Scanner(System.in);
					int secimp2 = tarap2.nextInt();
					if(secimp2 == 1)
					{
						// If user want to to select an item, and picnic bag is not empty, I display the items wtih index which user can select.
						// I split selected item according to the name and type. I save the type of item through boolean to use some processes after.
						if(picnic_bag.isEmpty() == false)
						{
							String[] display_bag_picnic = picnic_bag.selectItem();
							System.out.println("\nSelect an index number. \n");		
							Scanner scan = new Scanner(System.in);
							int index = scan.nextInt();
							String[] split_item = null;
							Item selecteditem = new Item(null,null);
							boolean organic = false;
							boolean plastic = false;
							boolean paper = false;
							try
							{
								if(plastic != true && paper != true)
								{
									split_item = display_bag_picnic[index-1].split(" organic");
									if(split_item[0].length() < display_bag_picnic[index-1].length())
									{
									organic = true;
									}
								}
								if(organic != true && plastic != true)
								{
									split_item = display_bag_picnic[index-1].split(" paper");
									if(split_item[0].length() < display_bag_picnic[index-1].length())
									{
									paper = true;
									}
								}
								if(organic != true && paper != true)
								{
									split_item = display_bag_picnic[index-1].split(" plastic");
									if(split_item[0].length() < display_bag_picnic[index-1].length())
									{
									plastic = true;
									}
								}
							}
							finally {
							    // ... cleanup that will execute whether or not an error occurred ...
							}
							
							// I take the saved type from the code which is above and according to that I create an item to use.
							
							if(organic)
							{
								selecteditem = new Item(split_item[0],"organic");
							}
							else if(paper)
							{
								selecteditem = new Item(split_item[0],"paper");
							}
							if(plastic)
							{
								selecteditem = new Item(split_item[0],"plastic");
							}
							
							System.out.println("\nSelected item is : " + selecteditem );
						
							System.out.println("\nTo consume the item : 1. To back : Any number");
							Scanner tarap3 = new Scanner(System.in);
							int secimp3 = tarap3.nextInt();
							if(secimp3 == 1)
							{		
								// If user select the consuming an item I control the contains method.
								// If method returns true, I transfer item to the targeted trash bag.
								// I automatically save the type of item above,so it automatically transfers item to the targeted trash bag.
								
								if(picnic_bag.contains(selecteditem)) {
									System.out.println("\nItem is found in the PicnicBag");
										
										if(organic== true)
										{
											
											picnic_bag.consume(selecteditem,organictrashbag);
											
										}
										else if(plastic == true)
										{
											
											picnic_bag.consume(selecteditem,plastictrashbag);
											
										}
										else if(paper == true)
										{
											
											picnic_bag.consume(selecteditem,papertrashbag);
											
										}
										
										
										
									}
								else {
									System.out.println("hata");
								}
							}
						}
						else
						{
							System.out.println("PicnicBag is empty.");
						}
						}
					
					
					
					
					
						if(secimp2==2)
						{
							// If user select the displaying picnic bag, I display.
							picnic_bag.displayItems();
						}
						
						if(secimp2 == 3)
						{
							
							System.out.println("Consumed items are displayed according to their types in trashbags.");
							// If the user select the displaying trashbags, I display.
							System.out.println("\nPlasticTrashBag : ");
							plastictrashbag.displayItems();
							
							System.out.println("\nPaperTrashBag : ");
							papertrashbag.displayItems();
							
							System.out.println("\nOrganicTrashBag");
							organictrashbag.displayItems();
						}
						if(secimp2==4)
						{
							// If user select removing item according to index number,I control picnic bag is empty or not. If not I display the removable items with their index number.
							// After that I remove the selected item.
							if(!picnic_bag.isEmpty())
							{
								picnic_bag.displayItems();
								System.out.println("\nSelect an item according to index\n");	
								Scanner scan = new Scanner(System.in);
								int index = scan.nextInt();
								picnic_bag.removeByIndex(index);
							
							}
							
							else
							{
								System.out.println("PicnicBag is empty.");
							}
						}
						
						
						
						
						if(secimp2==5)
						{
							// If user select removing and bag is not empty I remove an item with remove method.
							if(!picnic_bag.isEmpty())
							{
								picnic_bag.remove();
							}
							else
							{
								System.out.println("PicnicBag is empty");
							}
						}
							
						
						
						}
						
				
		
		
				if(secim==3)
				{
					// If user select quitting, program will be ending.
					devam = false;
				}
				if(devam==false)
				{
					break;
				}
		}
		
}
}
