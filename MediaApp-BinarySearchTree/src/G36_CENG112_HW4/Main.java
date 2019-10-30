package G36_CENG112_HW4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		FileIO fileIO = new FileIO();
		BinarySearchTree<BinaryNode> bstree = FileIO.readFile();
		int choice = -1;
		System.out.println("1. Print the minimum priced book whose author name is taken from console.\r\n" + 
				"2. Print the maximum priced book whose author name is taken from console.\r\n" + 
				"3. Print the minimum priced movie whose director name is taken from console.\r\n" + 
				"4. Print the maximum priced movie whose director name is taken from console.\r\n" + 
				"5. Print all media whose prices are less or equal than the amount taken from console.\r\n" + 
				"6. Print all media whose prices are greater than the amount taken from console.\r\n" + 
				"7. Print all media in descending order in terms of the price.\r\n" + 
				"8. Print all media in ascending order in terms of the price.\r\n" + 
				"9. Print all books in descending order in terms of the price.\r\n" + 
				"10. Print all books in ascending order in terms of the price.\r\n" + 
				"11. Print all movies in descending order in terms of the price.\r\n" + 
				"12. Print all movies in ascending order in terms of the price. \r\n" + 
				"");
		
		while(choice != 0) {		
	
		BinaryNode newNode = new BinaryNode((IMedia) null,null,null);
		Scanner scan = new Scanner(System.in);
		System.out.println("\nText the choice ( For example : 11) || To exit text 0");
		try {
		choice = scan.nextInt();
		}
		catch(Exception e)
		{
			System.out.println("Text a valid value");
		}
		if(choice==1 || choice ==3)
		{
			scan = new Scanner(System.in);
			System.out.println("Text the owner's name");
			String name = scan.nextLine();
			System.out.println(bstree.inorderTraverseName(bstree.getRootNode(),1,newNode,name,10000000));
		}
		else if(choice==2 || choice ==4)
		{
			scan = new Scanner(System.in);
			System.out.println("Text the owner's name");
			String name = scan.nextLine();
			System.out.println(bstree.inorderTraverseName(bstree.getRootNode(),2,newNode,name,0));
		}
		
		else if(choice==5)
		{
			scan = new Scanner(System.in);
			System.out.println("Text the price");
			try {
				int price = scan.nextInt();
				bstree.inorderTraversePrice(bstree.getRootNode(),5,price);
			}
			catch(Exception e) {
				System.out.println("It is not a price.");
			}

		}
		else if(choice==6)
		{
			scan = new Scanner(System.in);
			System.out.println("Text the price");
			try {
				int price = scan.nextInt();
				bstree.inorderTraversePrice(bstree.getRootNode(),6,price);
			}
			catch(Exception e) {
				System.out.println("It is not a price.");
			}
		}
		else if(choice==7)
		{
			bstree.inorderTraverse(bstree.getRootNode(),7);
		}
		else if(choice==8)
		{
			bstree.inorderTraverse(bstree.getRootNode(),8);
		}
		else if(choice==9)
		{
			bstree.inorderTraverse(bstree.getRootNode(),9);
		}
		else if(choice==10)
		{
			bstree.inorderTraverse(bstree.getRootNode(),10);
		}
		else if(choice==11)
		{
			bstree.inorderTraverse(bstree.getRootNode(),11);
		}
		else if(choice==12)
		{
			bstree.inorderTraverse(bstree.getRootNode(),12);
		}
		


		
		
		
		}

	}


}
