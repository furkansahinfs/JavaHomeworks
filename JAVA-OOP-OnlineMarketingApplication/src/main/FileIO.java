package main;

import java.io.*;

import java.util.ArrayList;
import product.*;
import user.*;


public class FileIO<T> 
{
	

	ArrayList<T> userList = new ArrayList<T>();

	
		@SuppressWarnings({ "resource", "unchecked" })
		

		/*
		 * it reads all user from text and return an arraylist 
		 * 
		 */	
	public ArrayList<T> readUser() throws FileNotFoundException
	{

		FileReader dosyaOkuyucu;
		BufferedReader okuyucu;
			
			//We create our variables
		try 
		{
				
			dosyaOkuyucu = new FileReader("src\\users.csv");
			okuyucu = new BufferedReader(dosyaOkuyucu);
				
			String satir = okuyucu.readLine();
			satir = okuyucu.readLine();
				

			while(satir!=null) 
			{
				String[] list = satir.split(",");
				Wallet wallet;
				switch (list[0]) 
				{
					
					case "1":
						wallet = new Wallet(Double.parseDouble((list[3])));
						AdminUser admin = new AdminUser(Integer.parseInt(list[0]),list[1],list[2],wallet) ;
						userList.add((T) admin);
						break;
							
							
					case "2":
						wallet = new Wallet(Double.parseDouble((list[3])));
						ContactInfo contactInfoCustomer = new ContactInfo(list[4], list[5],addressList(list));
						RegularUser regCustomer = new Customer (Integer.parseInt(list[0]),list[1],list[2],wallet,contactInfoCustomer) ;
						userList.add((T) regCustomer);
						break;
							
					case "3":
						wallet = new Wallet(Double.parseDouble((list[3])));
						ContactInfo contactInfo = new ContactInfo((list[4]), list[5],addressList(list));
						RegularUser regSupplier = new Supplier (Integer.parseInt(list[0]),list[1],list[2],wallet,contactInfo,list[6],list[7],list[8]) ;
						userList.add((T) regSupplier);
						break ;
							
					default:
						throw new IllegalArgumentException("Unexpected value: " + list[0]);
				}
				satir=okuyucu.readLine();		
			}		
			okuyucu.close();
		}
			
		catch(FileNotFoundException ex)
		{
			 System.out.println("File is not found.");
		}
		catch(IOException ex)
		{
			 System.out.println("Error exception.");
		}
		return userList;
	}
		

		/*
		 * it returns arraylist which have only addresses
		 * 
		 */
	public ArrayList<Address> addressList(String[] list)
	{
		int size = list.length;
		ArrayList<Address> addressList = new ArrayList<Address>();
		
		while (true)
		{
			if (size>16) 
			{
				Address address = new Address(list[size-6],list[size-5], list[size-4], list[size-3], list[size-2],list[size-1]);
				addressList.add(address);
				size=size-6;
				continue;
			}
			
			else 
			{
				Address address = new Address(list[size-6],list[size-5], list[size-4], list[size-3], list[size-2],list[size-1]);
				addressList.add(address);
				break;
			}
		}
		return addressList;
	}
		

	/*
	 * it reads product from text
	 * 
	 */
	@SuppressWarnings("unchecked")
	public void readProduct() throws FileNotFoundException
	{

		FileReader dosyaOkuyucu;
		BufferedReader okuyucu;
			
		//We create our variables
		try 
		{
				
			dosyaOkuyucu = new FileReader("src\\products.csv");
			okuyucu = new BufferedReader(dosyaOkuyucu);
			String satir = okuyucu.readLine();
			satir = okuyucu.readLine();
			
			while(satir!=null) 
			{
				String[] list = satir.split(",");
					
				switch (list[0]) {
					
				case "houseware":
					Product houseware = new Product(list[0],list[1],Double.parseDouble(list[2]),Double.parseDouble(list[3]),Integer.parseInt(list[4])) ;
					for( T element : userList) 
					{
						if(((User) element).getType()==3)
						{
							if(((Supplier)element).getShopCategory().equals("houseware"))
							{
								((Supplier)element).getShop().addProduct(houseware, houseware.getQuantity());
							}
						}
					}
					break;
							
							
				case "accessories":
					Product accessories = new FragileProduct(list[0],list[1],Double.parseDouble(list[2]),Double.parseDouble(list[3]),Integer.parseInt((list[4]))) ;
					for( T element : userList) 
					{
						if(((User) element).getType()==3)
						{
							if(((Supplier)element).getShopCategory().equals("accessories"))
							{
								((Supplier)element).getShop().addProduct(accessories, accessories.getQuantity());
							}
						}
					}
					break;
							
				case "electronic":

					Product electronic = new Product(list[0],list[1],Double.parseDouble(list[2]),Double.parseDouble(list[3]),Integer.parseInt(list[4])) ;
					for( T element : userList) 
					{
						if(((User) element).getType()==3)
						{
							if(((Supplier)element).getShopCategory().equals("electronic"))
							{
								((Supplier)element).getShop().addProduct(electronic, electronic.getQuantity());
							}
						}
					}
					break ;
							
					case "cosmetic":

						Product cosmetic = new FastConsumptionProduct(list[0],list[1],Double.parseDouble(list[2]),Double.parseDouble(list[3]),Integer.parseInt(list[4])) ;
						for( T element : userList) {
							if(((User) element).getType()==3)
							{
								if(((Supplier)element).getShopCategory().equals("cosmetic"))
								{
									((Supplier)element).getShop().addProduct(cosmetic, cosmetic.getQuantity());
								}
							}
						}
						break ;
							
					default:
						throw new IllegalArgumentException("Unexpected value: " + list[0]);
					}
						satir=okuyucu.readLine();
				}	
			
				okuyucu.close();
	
			}
			
			catch(FileNotFoundException ex)
			{
				 System.out.println("File is not found.");
			}
			catch(IOException ex)
			{
				 System.out.println("Error exception.");
			}
		
		}

}
