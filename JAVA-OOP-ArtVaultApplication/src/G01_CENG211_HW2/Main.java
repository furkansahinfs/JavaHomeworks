package G01_CENG211_HW2;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;


public class Main {
	
	
	public static void main(String[] args) throws IOException{
		// Created necessary objects.
		FileIO fl = new FileIO(); 
		Vault vault = new Vault(fl.readFile());
		vault.split(); // Splits the string lines, creates the objects and add them to necessary lists.
		
	
		
		int sortChoice;
		// Created necessary objects.
		ArrayList<Object> list; // it is the sorted list taken from ArrayListSorter.
		ArrayListSorter ALS = new ArrayListSorter(vault); // to sort the list, we create an arraylistsorter objects. To reach list, it takes a parameter : vault.
		Buyer buyer1 = new Buyer("Buyer1");
		Buyer buyer2 = new Buyer("Buyer2");
		Buyer buyer3 = new Buyer("Buyer3");
		Buyer buyer4 = new Buyer("Buyer4");
		Seller seller = new Seller();
		seller.setList(vault.getArtworkList()); // We set the seller's tradeable item list.  
	
        try {
		while(true) {
			
			System.out.println("Please enter the number of the operation you want the perfom:");
			System.out.println("1)Print the lists\n2)Search the vault\n3)Trade\n0)Exit");
			BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));
	        String menuOpeChoice1 = reader.readLine();
	        int ope1=Integer.parseInt(menuOpeChoice1);
	        // According to operation choice we execute necessary cases.
	        
	        switch (ope1) {
	        
				case 1:
					System.out.println("Please choose the list:");
					System.out.println("1)Print the list of painting\n2)Print the list of sculptures\n3)Print the list of architectures\n4)Print the list of artist\n5)Print the list of architects\n0)Exit");
			        int listChoice=Integer.parseInt(reader.readLine());
			        // According to list choice we show the sort choices.
					switch (listChoice) {
			        
						case 1: // painting list - sort choices
							System.out.println("Please choose the sorting method");
							System.out.println("1)Sort by Name");
							System.out.println("2)Sort by Style");
							System.out.println("3)Sort by Artist");
							System.out.println("0)Exit");
							String str = reader.readLine();
					        sortChoice =Integer.parseInt(str);
					        if(sortChoice == 0) {
					        	System.exit(0);
					        }
					        list = ALS.sort(listChoice, sortChoice); // according to sorted choice, it returns the sorted list.
					        for(int i=0;i<list.size();i++) {
					        	System.out.println(list.get(i).toString()); // prints the sorted list.
					        }
							break;
							
						case 2: // sculpture list - sort choices
							System.out.println("Please choose the sorting method");
							System.out.println("1)Sort by Name");
							System.out.println("2)Sort by Style");
							System.out.println("3)Sort by Artist");
							System.out.println("4)Sort by Material");
							System.out.println("0)Exit");
					        sortChoice =Integer.parseInt( reader.readLine());
					        if(sortChoice == 0) {
					        	System.exit(0);
					        }
					        list = ALS.sort(listChoice, sortChoice); // according to sorted choice, it returns the sorted list.
					        for(int i=0;i<list.size();i++) {
					        	System.out.println(list.get(i).toString()); // prints the sorted list.
					        }
					        break;
					        
		
						case 3: // architecture list - sort choices
							System.out.println("Please choose the sorting method");
							System.out.println("1)Sort by Name");
							System.out.println("2)Sort by Style");
							System.out.println("0)Exit");
					        sortChoice =Integer.parseInt( reader.readLine());	
					        if(sortChoice == 0) {
					        	System.exit(0);
					        }
					        list = ALS.sort(listChoice, sortChoice); // according to sorted choice, it returns the sorted list.
					        for(int i=0;i<list.size();i++) {
					        	System.out.println(list.get(i).toString()); // prints the sorted list.
					        }
					        break;
					        
						case 4: // artist list - sort choices
							System.out.println("Please choose the sorting method");
							System.out.println("1)Sort by Name");
							System.out.println("2)Sort by Birthday");
							System.out.println("3)Sort by Nationality");
							System.out.println("0)Exit");
					        sortChoice =Integer.parseInt( reader.readLine());	
					        if(sortChoice == 0) {
					        	System.exit(0);
					        }
					        list = ALS.sort(listChoice, sortChoice); // according to sorted choice, it returns the sorted list.
					        for(int i=0;i<list.size();i++) {
					        	System.out.println(list.get(i).toString()); // prints the sorted list.
					        }
					        break;
					        
						case 5: // architect list - sort choices
							System.out.println("Please choose the sorting method");
							System.out.println("1)Sort by Name");
							System.out.println("2)Sort by Birthday");
							System.out.println("3)Sort by Nationality");
							System.out.println("0)Exit");
					        sortChoice =Integer.parseInt( reader.readLine());	
					        if(sortChoice == 0) {
					        	System.exit(0);
					        }
					        list = ALS.sort(listChoice, sortChoice); // according to sorted choice, it returns the sorted list.
					        for(int i=0;i<list.size();i++) {
					        	System.out.println(list.get(i).toString()); // prints the sorted list.
					        }
							break;
			
						case 0:
							System.exit(0);
						}
					
					break;
					
					
				//------------------------
					
					
				case 2:
					System.out.println("Enter the keyword:");			
					ArrayListSearcher search = new ArrayListSearcher(vault);
					search.search(); // in search method, we take an input from user and execute the method
					break;
					
					
				//------------------------
					
					
				case 3:
					Random rand = new Random(); 
					Artwork art;
					Artwork art1 = null;
					Artwork art2 = null;
					Artwork art3 = null;
					Artwork art4 = null;
					
					int rand_int;
					buyer1.getList().clear();
					buyer2.getList().clear();
					buyer3.getList().clear();
					buyer4.getList().clear();
					
					System.out.println("\nSeller's Money: "+ seller.getWallet() + "\n" + "Buyer1's Money: "+ buyer1.getWallet()+ "\n" + "Buyer2's Money: "+ buyer2.getWallet()+ "\n" + "Buyer3's Money: "+ buyer3.getWallet()+ "\n" + "Buyer4's Money: "+ buyer4.getWallet()+"\n\n");
					
					// Take an random artwork from seller's list which holds tradeable artworks and try to sell them to buyer.
					rand_int = rand.nextInt(seller.getList().size());
					art =seller.getList().get(rand_int);
					art1=art;
					art.tradeToBuyer(seller, buyer1, art.calculateCost());
					
					// Take an random artwork from seller's list which holds tradeable artworks and try to sell them to buyer.	
					rand_int = rand.nextInt(seller.getList().size());
					art =seller.getList().get(rand_int);
					art2=art;
					art.tradeToBuyer(seller, buyer2, art.calculateCost());
					
					// Take an random artwork from seller's list which holds tradeable artworks and try to sell them to buyer.	
					rand_int = rand.nextInt(seller.getList().size());
					art =seller.getList().get(rand_int);
					art3=art;
					art.tradeToBuyer(seller, buyer3, art.calculateCost());
					
					// Take an random artwork from seller's list which holds tradeable artworks and try to sell them to buyer.	
					rand_int = rand.nextInt(seller.getList().size());
					art =seller.getList().get(rand_int);
					art4=art;
					art.tradeToBuyer(seller, buyer4, art.calculateCost());
					
					
					// Adding the removed artworks to seller's list. 
					seller.getList().add(art1);
					seller.getList().add(art2);
					seller.getList().add(art3);
					seller.getList().add(art4);
					
					
					
					System.out.println("BUYER 1 bought: \n" + buyer1.getList().get(0).toString() + "Cost: " + buyer1.getList().get(0).calculateCost() + " TL"+ "\n\n");
					System.out.println("BUYER 2 bought: \n" + buyer2.getList().get(0).toString() + "Cost: " + buyer2.getList().get(0).calculateCost() + " TL"+ "\n\n");
					System.out.println("BUYER 3 bought: \n" + buyer3.getList().get(0).toString() + "Cost: " + buyer3.getList().get(0).calculateCost() + " TL"+ "\n\n");
					System.out.println("BUYER 4 bought: \n" + buyer4.getList().get(0).toString() + "Cost: " + buyer4.getList().get(0).calculateCost() + " TL"+ "\n\n");
					
					System.out.println("Trade is completed.");
					System.out.println("Seller's Money: "+ seller.getWallet() + "\n" + "Buyer1's Money: "+ buyer1.getWallet()+ "\n" + "Buyer2's Money: "+ buyer2.getWallet()+ "\n" + "Buyer3's Money: "+ buyer3.getWallet()+ "\n" + "Buyer4's Money: "+ buyer4.getWallet()+"\n\n");
					System.out.println("Trade is completed.");
					seller.setWallet(0);
					buyer1.setWallet(5000000);
					buyer2.setWallet(5000000);
					buyer3.setWallet(5000000);
					buyer4.setWallet(5000000);
					break;
					
					
				//------------------------
					
					
				case 0:
					
					System.exit(0);
				}
	        
				
			}
			
			
		}
	
	catch(Exception e){
		System.out.println("Hata");
		main(null);
	}

}
}
