package main;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import product.*;
import user.*;

public class Operations<T> {
	private AdminUser admin; // We keep our admin until program ends.
	private FileIO<T> fi;
	private ArrayList<T> userList; // it is the list returned from fileIO
	private User signedInUser; // we keep which user is signed in to control its operations 
	//( for example when customer choose a operation which belongs to admin, we throw an exception )
	
	public Operations() throws Exception 
	{
		admin = null;
		signedInUser = null;
		fi =  new FileIO();
	}
	
	/*
	 * startOperations do the reading files, return list of reading user list, and invoke findAdmin method to find our admin through userlist.
	 */
	public void startOperations() throws Exception 
	{
		userList =fi.readUser();
		fi.readProduct();
		findAdmin();
	}
	
	/*
	 * we go through the elements of the userlist and if element is equal to admin and set our admin.
	 */
	public User findAdmin() 
	{
		 for (T elements : userList)  
	        { 
	            if (((User) elements).getType() == 1) 
	            { 
	              admin = (AdminUser)  elements;
	              admin.getAllSuppliers(userList);
	              admin.getApprovedSuppliers();
	              admin.getNotApprovedSuppliers();
	            } 
	        }
		return admin; 
	}
	
	/*
	 * We take inputs frpm user and we go through the elements of the userlist. If given inputs are in the userlist, we take the that user object from userlist
	 * and set it as signed in user.
	 */
	public boolean signIn() 
	{
		System.out.println("To sign in text your username : ");
		Scanner scan = new Scanner(System.in);
		String username = scan.next();
		System.out.println("To sign in text your password : ");
		String password = scan.next();	
		
		for(T user : userList)
		{
			if(((User) user).getUsername().equals(username) && ((User) user).getPassword().equals(password))
			{
				signedInUser = ((User) user);
				return true;
			}
		}
	
		return false;
	}
	

	
	
	/*
	 * If signed in user is admin, he/she can make the process. If not it should be sign in as admin.
	 *We go through the elements of admin's not approved supplier list and show them to make user choose a supplier. 
	 *Set the supplier approve according to user choice.
	 */
	public boolean adminApprove() 
	{
		if(signedInUser != null && signedInUser.getType()==1) 
		{
			System.out.println("Which supplier do you want to aprrove ");
			admin.showNotApprovedSuppliers();
			Scanner scan = new Scanner(System.in);
			
			try 
			{
				int choice = scan.nextInt();
				if(choice>0 && choice<=admin.getNotApprovedSupplierList().size()) 
				{
					return admin.approved(choice-1); // invoke admin's approved method which set the given supplier's approve boolean as true
				}
				else 
				{
					throw new Exception("Invalid choice");
				}
			}
			
			catch (Exception e)
			{
				System.out.println(e);
			}
		
			return false;	
		}
		
		else 
		{
			try 
			{
				throw new Exception("You can't do this process. Please sign in as admin.");
			}
			catch (Exception e) {
				System.out.println(e);
				return false;
			}
				
		}
	}

	/*
	 * If signed in user is admin, he/she can make the process. If not it should be sign in as admin.
	 *According to user's choice we show the list in the admin class ( like approved suppliers list, not approved suppliers list, all suppliers list)
	 */
	public void adminShowList() 
	{
		if(adminIsSigned()) 
		{
			System.out.println("Which list do you want to see ?"
					+ "1 - Approved Suppliers"
					+ "2 - NotApproved Suppliers"
					+ "3 - All Suppliers");
			
			Scanner scan = new Scanner(System.in);
			try 
			{
				int choice = scan.nextInt();
				switch (choice) {
				// According to choice invoke the admin's show method.
				case 1:
					admin.showApprovedSuppliers();
					break;
				case 2:
					admin.showNotApprovedSuppliers();
					break;
				case 3:
					admin.showSuppliers();
					break;
	
				default:
					throw new IllegalArgumentException("Unexpected value");
				}
			}
			
			catch (Exception e)
			{
				System.out.println(e);
			}
			
		}
	}
	
	/*
	 * If signed in user is supplier, he/she can make the process. If not it should be sign in as supplier.
	 *According to user's choice we show the list in the supplier class ( like inventory, sold items)
	 */
	public void supplierShowList() 
	{
		if(supplierIsSigned()) 
		{
			System.out.println("Which list do you want to see ?"
					+ " 1 - Inventory"
					+ " / 2 - Sold Items"
					);
			
			Scanner scan = new Scanner(System.in);
			try 
			{
				
				int choice = scan.nextInt();
				switch (choice) {
				// According to choice we print a inventory
				case 1:
					System.out.println(((Supplier) signedInUser).getShop().getShopInventory().toString());
					break;
				case 2:
					System.out.println(((Supplier) signedInUser).getSoldProduct().getShopInventory().toString());
					break;
	
				default:
					throw new IllegalArgumentException("Unexpected value");
				}
			}
			
			catch (Exception e)
			{
				System.out.println(e);
			}
		}
	}
	
	/*
	 * If signed in user is customer, he/she can make the process. If not it should be sign in as customer.
	 *According to user's choice we show the list in the customer class ( like basket, bought items)
	 */
	public void customerShowList() 
	{
		if(customerIsSigned()) 
		{
			System.out.println("Which list do you want to see ?"
					+ " 1 - Basket"
					+ " / 2 - Bought Items"
					);
			
			Scanner scan = new Scanner(System.in);
			try 
			{
				
				int choice = scan.nextInt();
				switch (choice) {
				// According to choice we print a inventory
				case 1:
					System.out.println(((Customer) signedInUser).getBasket().getBasketInventory().toString());
					break;
				case 2:
					System.out.println(((Customer) signedInUser).getBoughtInventory().getInventory().toString());
					break;
	
				default:
					throw new IllegalArgumentException("Unexpected value");
				}
			}
			
			catch (Exception e)
			{
				System.out.println(e);
			}
		}
	}
	
	/*
	 * This method returns a map which contains all approved suppliers items.
	 */
	public Map productList() 
	{
		Map products = new HashMap<T, Integer>();
		for(Supplier supplier : admin.getApprovedSupplierList())
		{
			products.putAll(supplier.getShop().getShopInventory());
		}
		return products;
	}
	
	/*
	 * This method print all the products in the shops using index
	 */
	public void showProducts() throws Exception 
	{
	
		if(!productList().isEmpty()) 
		{
		Object[] list = productList().keySet().toArray(); // list is a list of keyset of returned map of productList method.
			for(int i=0;i<list.length;i++) 
			{
				System.out.println((i+1) + "-" + list[i]);
			}
		}
		else 
		{
			throw new Exception("There doesn't exist any product");
		}
	}
	
	/*
	 * If signed in user is customer, he/she can make the process. If not it should be sign in as customer.
	 * Firstly we show all the products in the shops and according to index we want user to choose a product. After that he/she choose quantity.
	 */
	public void selectProduct() throws Exception 
	{
		if(customerIsSigned())
		{
			Map productList = productList();
			Object[] list = productList.keySet().toArray(); // it is the list of keyset of returned map of productList method
			
			//If productList is not empty, show all products in the shops and after that make user choose product and quantity
			if(!productList.isEmpty()) {
				showProducts();
				Scanner scan = new Scanner(System.in);
				try 
				{
					System.out.println("Select a product");
					int choice = scan.nextInt();
					// If choice is not valid throw an exception.
					if(choice>list.length || choice<1) 
					{
						throw new Exception("Invalid choice");
					}
					
					else 
					{
						System.out.println("Text quantity:");
						int quantity = scan.nextInt();
						// If quantity  is greater than zero and smaller than the quantity in the shop, add item to the basket
						
						if(quantity>0 && quantity<=(Integer) productList.get((Product)list[choice-1])) 
						{
							((Customer)signedInUser).addToBasket((Product)list[choice-1], quantity);
						}
						
						else
						{
							throw new Exception("There is no enough product in the shop");
						}
					}
				}
				
				catch (Exception e)
				{
					System.out.println(e);
				}
			}
			else{
				throw new Exception("No product to choice in shops");
			}
	}
	}
	
	/*
	 * If signed in user is customer, he/she can make the process. If not it should be sign in as customer.
	 *  If bought inventory is not empty show the bought inventory to make user choose a product and quantity to return.
	 */
	public void customerReturnedFromBought() throws Exception 
	{

		if(customerIsSigned())
		{
			if( !((Customer)signedInUser).getBoughtInventory().getInventory().isEmpty()) 
			{
				System.out.println("Which product do you want to return? (write the name of product) ");
				System.out.println(((Customer) signedInUser).getBoughtInventory().getInventory().toString());
				
				Scanner scan = new Scanner(System.in);
				String productName = scan.next(); // selected product name
				Iterator<Product> iterator =  ((Customer) signedInUser).getBoughtInventory().getInventory().keySet().iterator();
				
				// We go thorugh keyset using iterator. If key's name is equal to given name from user,
				// Take quantity and do the process.
				
				while (iterator.hasNext())
				{
					Product product = iterator.next();
					if(product.getName().equals(productName)) 
					{
						System.out.println("Text quantity: ");
						int quantity = scan.nextInt();
						
						// Contol the given quantity is valid
						if (quantity >0 && quantity <= ((Integer)((Customer) signedInUser).getBoughtInventory().getInventory().get(product))) 
						{
							// Update customer money and bought inventory
							((Customer) signedInUser).getWallet().setActive_balance(((Customer) signedInUser).getWallet().getActive_balance()+(product.getPrice()*quantity));
							((Customer) signedInUser).getBoughtInventory().getInventory().replace(product,((Integer)((Customer) signedInUser).getBoughtInventory().getInventory().get(product))-quantity );
							
							// Go through approved suppliers list and if a supplier has the returned product, update supplier's money, sold list and inventory.
							for(int i =0;i<admin.getApprovedSupplierList().size();i++) 
							{
								for(Object element : admin.getApprovedSupplierList().get(i).getSoldProduct().getShopInventory().keySet().toArray())
								{
									if(((Product) element).getName().equals(product.getName()))
									{
										 admin.getApprovedSupplierList().get(i).getSoldProduct().getShopInventory().replace(product, (Integer) admin.getApprovedSupplierList().get(i).getSoldProduct().getShopInventory().get(product)-quantity);
										 if((Integer) admin.getApprovedSupplierList().get(i).getSoldProduct().getShopInventory().get(product) == 0) 
										 {
											 admin.getApprovedSupplierList().get(i).getSoldProduct().getShopInventory().remove(product);
						 
										 }
										 admin.getApprovedSupplierList().get(i).getWallet().setActive_balance(admin.getApprovedSupplierList().get(i).getWallet().getActive_balance()-product.getPrice()*quantity);
										 admin.getApprovedSupplierList().get(i).getShop().addProduct(product, quantity);
									
									}
								}
							}
							
							
							// If item quantity in the customer's bought, remove the item from bought inventory.
							if (((Integer)((Customer) signedInUser).getBoughtInventory().getInventory().get(product)==0))
							{
								((Customer) signedInUser).getBoughtInventory().getInventory().remove(product);
							}
						}
						else 
						{
							throw new Exception("invalid quantity choice");
						}
					}
					
				}
			}
			else 
			{
				throw new Exception("No item to return");
			}
		}
		
	}
	
	/*
	 * If signed in user is customer, he/she can make the process. If not it should be sign in as customer.
	 * Method is a process of removing item from basket.
	 *  If basket is not empty, show the basket items.
	 *  Make user choose an item and its quantity
	 */
	public void customerRemoveFromBasket() throws Exception 
	{
		if(customerIsSigned())
		{
			if( !((Customer)signedInUser).getBasket().getBasketInventory().isEmpty()) 
			{
				System.out.println("Your basket : ");
				System.out.println(((Customer)signedInUser).getBasket().getBasketInventory());
				
				try 
				{
					Object[] list = ((Customer)signedInUser).getBasket().getBasketInventory().keySet().toArray();
					
					for(int i=0;i<list.length;i++)
					{
						System.out.println((i+1) + "-" + list[i] + " / quantity :" + ((Customer)signedInUser).getBasket().getBasketInventory().get(list[i]));
					}
					
					Scanner scan = new Scanner(System.in);
					System.out.println("Select a product to remove");
					int choice = scan.nextInt();
					
					// If choice is not valid throw an exception
					if(choice>list.length || choice<1) 
					{
						throw new Exception("Invalid choice");
					}
					
					// If choice is valid take an quantity and remove item from basket according to quantity.
					else 
					{
						System.out.println("Text quantity :");
						int quantity = scan.nextInt();
						
						if(quantity<= (Integer) ((Customer)signedInUser).getBasket().getBasketInventory().get(list[choice-1])) 
						{
							((Customer)signedInUser).removeFromBasket((Product)list[choice-1], quantity);
						
						}
						else {
							throw new Exception("given quantity is bigger than the product's quantity in the basket");
						}
					}
			}
				
			catch (Exception e)
			{
				System.out.println(e);
			}
		}
		else
		{
			throw new Exception("No product in the basket");
		}
	}
}
	
	/*
	 * If signed in user is customer, he/she can make the process. If not it should be sign in as customer.
	 * Method is a process of buying items in the basket.
	 * We update the supplier's money and inventories with sending the buying list to supplier.
	 * WE update admin's money.
	 */
	public boolean customerBuy() 
	{
		if(customerIsSigned())
		{
			try 
			{
				HashMap<Product,Integer> returnedProducts = ((Customer)signedInUser).buy();
				if(returnedProducts.isEmpty()) 
				{
					throw new Exception("Basket is empty");
				}
				else 
				{
					for(int i=0;i<admin.getApprovedSupplierList().size();i++)
					{
						((Supplier) admin.getApprovedSupplierList().get(i)).sold(returnedProducts);
						admin.getWallet().setActive_balance(admin.getWallet().getActive_balance() + ((Supplier) admin.getApprovedSupplierList().get(i)).getProcessPrice());
					}
					customerChooseAddress();
					System.out.println("Buying process is finished. Check your bought inventory.");
										
					
				}
			} 
			catch (Exception e)
			{
				// TODO Auto-generated catch block
				System.out.println(	e);
			}
		}
		return false;
	}
	
	/*
	 * If signed in user is customer, he/she can make the process. If not it should be sign in as customer.
	 * Method is a process of adding new address
	 * According to given inputs add address to the customer's info.
	 */
	public void customerAddAdress() {
		if(customerIsSigned())
		{
			Address address = new Address(null, null, null, null, null, null);
		
			Scanner scan = new Scanner(System.in);
			System.out.println("addres_title : ");
			address.setAddres_title(scan.next());
			System.out.println("country : ");
			address.setCountry(scan.next());
			System.out.println("city : ");
			address.setCity(scan.next());
			System.out.println("district : ");
			address.setDistrict(scan.next());
			System.out.println("street : ");
			address.setStreet(scan.next());
			System.out.println("door number : ");
			address.setDoor_number(scan.next());
			
			((Customer)signedInUser).addAddressToContactınfo(address);
		}
	}
	
	/*
	 * If signed in user is customer, he/she can make the process. If not it should be sign in as customer.
	 * Method is a process of choosing address when buying something
	 * Show all the address of customer's and make user choose an address.
	 */
	public void customerChooseAddress() {
		if(customerIsSigned())
		{
			System.out.println("Which address do you want to choose?");
			for(int i=0;i<((Customer)signedInUser).getContactInfo().getAddressList().size();i++) 
			{
				System.out.println((i+1) + "-" +((Customer)signedInUser).getContactInfo().getAddressList().get(i) );
			}
			Scanner scan = new Scanner(System.in);
			try 
			{
				int choice = scan.nextInt();
				if(choice>((Customer)signedInUser).getContactInfo().getAddressList().size() || choice<1) 
				{
					throw new Exception("Invalid choice");
				}
				else 
				{
				((Customer)signedInUser).getContactInfo().getAddressList().get(choice-1);
				}
			}
			
			catch (Exception e)
			{
				System.out.println(e);
			}
			
		}
		
	}
		
	/*
	 * Show the signed user's wallet balance.
	 */
	public void showWallet() {
		System.out.println(signedInUser.getWallet().getActive_balance());
	}
	
	
	/*
	 * These methods below returns true or false according to signed in user type
	 */
	
	
	public boolean customerIsSigned() {
		if(signedInUser != null && signedInUser.getType()==2)
		{
			return true;
		}
		else 
		{
			try 
			{
				throw new Exception("You can't do this process. Please sign in as customer.");
			}
			catch (Exception e) {
				System.out.println(e);
			}		
		}
		return false;	
	}
	
	public boolean adminIsSigned() {
		if(signedInUser != null && signedInUser.getType()==1)
		{
			return true;
		}
		else 
		{
			try 
			{
				throw new Exception("You can't do this process. Please sign in as admin.");
			}
			catch (Exception e) {
				System.out.println(e);
			}		
		}
		return false;
	}
	
	public boolean supplierIsSigned() {
		if(signedInUser != null && signedInUser.getType()==3)
		{
			return true;
		}
		else 
		{
			try 
			{
				throw new Exception("You can't do this process. Please sign in as supplier.");
			}
			catch (Exception e) {
				System.out.println(e);
			}	
		}
		return false;
	}
	
	public void signOut() 
	{
		signedInUser = null;
	}

	public User getSignedInUser() 
	{
		return signedInUser;
	}

	public void setSignedInUser(User signedInUser) {
		this.signedInUser = signedInUser;
	}
	
	
	
	

}
