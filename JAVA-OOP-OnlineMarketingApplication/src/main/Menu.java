package main;

import java.util.Scanner;

public class Menu
{
	Operations operations;
	public<T> Menu() throws Exception 
	{
		operations = new Operations<T>();
	}
	
	public void menuStart() 
	{
		try 
		{
			operations.startOperations();
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		menuOperations();
	}
	
	public void menuOperations()
	{
		Scanner scan = new Scanner(System.in);
		while(true) 
		{
			System.out.println("Which operation do you want to choose ?"
					+ " \n 1- SignIn"
					+ " \n 2- SignOut"
					+ " \n 3- SignUp"
					+ " \n 4- Exit");
			try 
			{
				int choice = scan.nextInt();
				switch (choice) {
				case 1:
					if(operations.signIn()) {
						operationChoices();
					}
					else 
					{
						throw new Exception("Invalid login, try again.");
					}
					
					break;
				case 2:
					operations.signOut();
					break;
				case 3:
					operations.signIn();
					break;
				case 4:
					System.exit(0);
					break;
				default:
					throw new IllegalArgumentException("Unexpected value: " + choice);
				}
				
			}
			catch (Exception e) 
			{
				System.out.println(e);
				menuOperations();
			}
		}
	}
	
	public void operationChoices() 
	{
		Scanner scan = new Scanner(System.in);
		while(true) 
		{
			System.out.println("Which operation do you want to choose ?"
					+ " \n 1- Approve an supplier"
					+ " \n 2- Show Lists of Admin"
					+ " \n 3- Show Lists of Supplier"
					+ " \n 4- Show Lists of Customer"
					+ " \n 5- Show Products"
					+ " \n 6- Select Product and Add to Basket"
					+ " \n 7- Remove Product From Basket"
					+ " \n 8- Buy"
					+ " \n 9- Show Wallet"
					+ " \n 10- Add Address to Customer"
					+ " \n 11- return product"
					+ " \n 12- Sign Out"
					+ " \n 13- Exit");
			try 
			{
				int choice = scan.nextInt();
				switch (choice) {
				case 1:
					operations.adminApprove();
					break;
				case 2:
					operations.adminShowList();
					break;
				case 3:
					operations.supplierShowList();
					break;
				case 4:
					operations.customerShowList();
					break;
				case 5:
					try 
					{
						operations.showProducts();
					}
					catch (Exception e) 
					{
						System.out.println(e);
					}
					
					break;
				case 6:
					operations.selectProduct();
					break;
				case 7:
					operations.customerRemoveFromBasket();
					break;
				case 8:
					operations.customerBuy();
					break;
				case 9:
					operations.showWallet();
					break;
				case 10:
					operations.customerAddAdress();
					break;
				case 11:
					operations.customerReturnedFromBought();
					break;
				case 12:
					operations.signOut();
					menuOperations();
					break;
				case 13:
					System.exit(0);
					break;
					
				default:
					throw new IllegalArgumentException("Unexpected value: " + choice);
				}
				
			}
			catch (Exception e) 
			{
				System.out.println(e);
				operationChoices();
			}
		}
	}

}
