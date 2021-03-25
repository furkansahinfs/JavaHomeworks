
package G16_CENG112_HW1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileIO {
	
	
	public IBag<Item> readInventory(){
		// I create a bag to add the items from Inventory.txt to bag.
		InventoryBag<Item> filebag = new InventoryBag<Item>();
		
		// I define my variables.
		FileReader dosyaOkuyucu;
		BufferedReader okuyucu;				
		
		try {
			
			// I read the Inventory.txt by line by. I split the line according to name, type, quantity.
			//I create an Item and I label the name and type which is taken from the split line.
			// I add the Item to bag according to its quantity.
			
			 dosyaOkuyucu = new FileReader("Inventory.txt");
			 okuyucu = new BufferedReader(dosyaOkuyucu);			 
			 String satir = okuyucu.readLine();			
			 
			 while(satir!=null) {		 
				String[] strs = satir.split(","); 
				String number = strs[2];
				int result = Integer.parseInt(number);		
				for (int i=0; i<result;i++) {
					Item item = new Item(strs[0], strs[1]);
					filebag.add(item);
				}
				satir = okuyucu.readLine();								 	
			 }		
			
			
		}
			 
			 
			 catch(FileNotFoundException ex){
				 System.out.println("File is not found.");
			 }
			 catch(IOException ex) {
				 System.out.println("Error is not found.");
			 }
		
		
		return (filebag);
		
	}

	
}
