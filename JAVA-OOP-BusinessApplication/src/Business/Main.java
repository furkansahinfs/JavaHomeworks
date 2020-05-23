package Business;




import java.util.Scanner;

import Exceptions.ItemNotUncountableException;
import Item.*;
public class Main {

	public static void main(String[] args)
	{	
		Business bus = new Business(10000);
		boolean flag = true;
		boolean flag2 = true;
		boolean flag3 = true;
		boolean flag4=true;
		boolean flag5=true;
		boolean flag6=true;
		boolean flag7=true;
		boolean flag8=true;
		boolean flag9=true;
		boolean flag10=true;
		boolean flag11 =true;

		System.out.println("Welcome");
		while(flag) 
		{
			int choice = 100;
			Scanner scanner = new Scanner(System.in);
			System.out.println("\n");
			System.out.println("1)Buying ingredients");
			System.out.println("2)Transfer to factory");
			System.out.println("3)Produce");
			System.out.println("4)Transfer to distrubution center");
			System.out.println("5)Sell");
			System.out.println("6)Display");
			System.out.println("0)Exit");
			
			try 
			{
				choice = scanner.nextInt();
			} 
			catch (Exception e) 
			{
				System.out.println("Please press valid number! \n");
				continue;
			}
			
			switch (choice) 
			{
			
			
			case 1:
				while(flag2) 
				{
					int choice2=100;
					System.out.println("Which ingredients do you want to buy?");
					System.out.println("1)Milk");
					System.out.println("2)Cacao");
					System.out.println("3)Yeast");
					System.out.println("4)Cream");
					System.out.println("0)Return to menu");
					
					try 
					{
						choice2 =scanner.nextInt();

					} 
					catch (Exception e) 
					{
						System.out.println("Please press valid number! \n");
						break;
					}
					
					switch (choice2) 
					{
					
					case 1:
						while(flag3) 
						{
							int choice3=100;
							System.out.println("Enter the litre");
							
							try 
							{
								choice3 =scanner.nextInt();

							} 
							catch (Exception e) 
							{
								System.out.println("Please enter valid litre!");
								break;
							}
							
						IUncountable milk = new Milk(choice3);
						
						try 
						{
							bus.buy(milk);
						} 
						
						catch (ItemNotUncountableException e) 
						{
							e.printStackTrace();
						}
						
						flag3=false;
						}
						
						flag3=true;
						break;
						
					case 2:
						while(flag3) 
						{
							int choice3=100;
							System.out.println("Enter the litre");
							
							try 
							{
								choice3 =scanner.nextInt();

							} 
							catch (Exception e) 
							{
								System.out.println("Please enter valid litre!");
								break;
							}
							
							IUncountable cacao = new Cacao(choice3);
							try 
							{
								bus.buy(cacao);
							} 
							catch (ItemNotUncountableException e) 
							{
								e.printStackTrace();
							}
							
							flag3=false;
						}
						
						flag3=true;
						break;
						
					case 3:
						while(flag3) 
						{
							int choice3=100;
							System.out.println("Enter the litre");
							
							try 
							{
								choice3 =scanner.nextInt();
							} 
							catch (Exception e) 
							{
								System.out.println("Please enter valid litre!");
								break;
							}
							
							IUncountable yeast = new Yeast(choice3);
							try 
							{
								bus.buy(yeast);
							} 
							catch (ItemNotUncountableException e) 
							{
								e.printStackTrace();
							}
							
							flag3=false;
						}
						flag3=true;
						break;
						
					case 4:
						while(flag3)
						{
							int choice3=100;
							System.out.println("Enter the litre");
							
							try 
							{
								choice3 =scanner.nextInt();

							} 
							catch (Exception e)
							{
								System.out.println("Please enter valid litre!");
								break;
							}
							
							IUncountable cream = new Cream(choice3);
							try 
							{
								bus.buy(cream);
							} catch (ItemNotUncountableException e)
							{
								e.printStackTrace();
							}
							flag3=false;
						}
						flag3=true;
						break;
						
					case 0:
						flag2 = false;
						break;
					default:
						System.out.println("Please enter valid number! \n ");
						break;
					}
				}
				flag2=true;
				break;
				
				
				
		
			case 2:
				while (flag4) 
				{
					int choice4=100;
							System.out.println("Which ingredient do you want to transfer to factory?");

							System.out.println("1)Milk");
							System.out.println("2)Cacao");
							System.out.println("3)Yeast");
							System.out.println("4)Cream");
							System.out.println("0)Return to menu");
							
							try 
							{
								choice4= scanner.nextInt();
							} 
							catch (Exception e) 
							{
								System.out.println("Please enter valid number!");
								break;
							}
							
							switch (choice4) 
							{
							case 1:
								while(flag5) 
								{
									IUncountable milk = new  Milk(0);
									try 
									{
										bus.transfer(milk);
									} 
									catch (Exception e) 
									{
										e.printStackTrace();
									}
									flag5=false;
								}
								flag5=true;
								break;
								
							case 2:
								while(flag5) 
								{
									IUncountable cacao = new  Cacao(0);
									try 
									{
										bus.transfer(cacao);
									} 
									catch (Exception e)
									{
										e.printStackTrace();
									}
									flag5=false;
								}
								flag5=true;
								break;
								
							case 3:
								while(flag5)
								{
									IUncountable yeast = new  Yeast(0);
									try 
									{
										bus.transfer(yeast);
									} 
									catch (Exception e) 
									{
										e.printStackTrace();
									}
									
									flag5=false;
								}
								flag5=true;
								break;
								
							case 4:
								while(flag5) 
								{
									IUncountable cream = new  Cream(0);
									try 
									{
										bus.transfer(cream);
									}
									catch (Exception e)
									{
										e.printStackTrace();
									}
									
									flag5=false;
								}
								flag5=true;
								break;
								
							case 0:
								flag4=false;
								break;
							
							default:
								System.out.println("Please enter valid number!");
								break;
							}
				}
				flag4=true;
				break;
				
				
				
				
				
			case 3:
				int  choice5=100;
				
				while(flag6) 
				{
					System.out.println("Producing page :");
					System.out.println("1)BoxedMilk");
					System.out.println("2)Chocolate");
					System.out.println("3)Yogurt");
					System.out.println("0)Return to menu");
					
					try 
					{
						choice5 = scanner.nextInt();
					} 
					catch (Exception e)
					{
						System.out.println("Please enter valid number!");
						break;
					}
					
					switch (choice5) 
					{
					
					case 1:
						int choice6=-1;
						while(flag7) 
						{
							System.out.println("Enter the count of item");
							try 
							{
								choice6 = scanner.nextInt();
							} 
							catch (Exception e)
							{
								System.out.println("Please enter valid number!");
								break;
							}
							
							if (choice6<=0)
							{
								System.out.println("Please enter valid number!");
								break;
							}
							
							ICountable boxedMilk = new BoxedMilk(choice6);
							bus.üret(boxedMilk);
							flag7=false;
						}
						flag7=true;
						break;
						
					case 2:
						int choice7=-1;
						while(flag7) 
						{
							System.out.println("Enter the count of item");
							try 
							{
								choice7 = scanner.nextInt();
							} 
							catch (Exception e)
							{
								System.out.println("Please enter valid number!");
								break;
							}
							
							if (choice7<=0)
							{
								System.out.println("Please enter valid number!");
								break;
							}
							ICountable chocolate = new Chocolate(choice7*(0.5));
							bus.üret(chocolate);
							flag7=false;
						}
						
						flag7=true;
						break;
						
						
					case 3:
						int choice8=-1;
						while(flag7) 
						{
							System.out.println("Enter the count of item");
							try 
							{
								choice8 = scanner.nextInt();
							} 
							catch (Exception e)
							{
								System.out.println("Please enter valid number!");
								break;
							}
							
							if (choice8<=0)
							{
								System.out.println("Please enter valid number!");
								break;
							}
							ICountable yogurt = new Yogurt(choice8*2);
							bus.üret(yogurt);
							flag7=false;
						}
						flag7=true;
						break;
						
						
					case 0:
						flag6=false;
						break;
						
					default:
						System.out.println("Please enter valid number!\n");
						break;
					}	
					
				}
				
				flag6=true;
				break;
				
				
				
			case 4:
				while (flag8) 
				{
					int choice9=-1;
							System.out.println("Transferring from factory to distribution page:");
							System.out.println("1)Transfer BoxedMilk");
							System.out.println("2)Transfer Chocolate");
							System.out.println("3)Transfer Yogurt");
							System.out.println("0)Return up menu");
							
							try 
							{
								choice9= scanner.nextInt();
							} 
							catch (Exception e) 
							{
								System.out.println("Please press valid number! \n");
								break;
							}
							
							switch (choice9) 
							{
							
							case 1:
								while(flag9) 
								{
									
									ICountable boxedMilk = new BoxedMilk(0);
									try 
									{
										bus.transfer(boxedMilk);
									} 
									catch (Exception e) 
									{
										e.printStackTrace();
									}
									flag9=false;
								}
								
								flag9=true;
								break;
								
							case 2:
								while(flag9) 
								{
									ICountable chocolate = new Chocolate(0);
									try 
									{
										bus.transfer(chocolate);
									} 
									catch (Exception e) 
									{
										e.printStackTrace();
									}
								
									flag9=false;
								}
								flag9=true;

								break;
							case 3:
								while(flag9) 
								{
									ICountable yogurt = new Yogurt(0);
									try 
									{
										bus.transfer(yogurt);
									} 
									catch (Exception e) 
									{
										e.printStackTrace();
									}
									
									flag9=false;
								}
								flag9=true;
								break;
							
							case 0:
								flag8=false;
								break;
							
							default:
								System.out.println("Please press valid number! \n");
								break;
							}

				}
				flag8=true;
				break;
				
				
				
			case 5:
				int choice10 =-1;
				while(flag10) 
				{
					System.out.println("Selling page:");
					System.out.println("1)Sell BoxedMilk");
					System.out.println("2)Sell Chocolate");
					System.out.println("3)Sell Yogurt");
					System.out.println("0)Return to menu");
					
					try 
					{
						choice10 = scanner.nextInt();
					} 
					catch (Exception e) 
					{
						System.out.println("Please press valid number! \n");
						break;
					}
					
					switch (choice10) 
					{
					
					case 1:
						while(flag11) 
						{
							int choice11=-1;
							System.out.println("Enter the count of item");
							try
							{
								choice11=scanner.nextInt();

							} 
							catch (Exception e) 
							{
								System.out.println("Please press valid number! \n");
								break;
							}
							
							if (choice11<=0) 
							{
								System.out.println("Please press valid number! \n");
								continue;
							}
							ICountable boxedMilk = new BoxedMilk(choice11);
							bus.sell(boxedMilk);
							flag11=false;
						}
						flag11=true;
						break;
						
					case 2:
						while(flag11) 
						{
							int choice11=-1;
							System.out.println("Enter the count of item");
							try
							{
								choice11=scanner.nextInt();

							} 
							catch (Exception e) 
							{
								System.out.println("Please press valid number! \n");
								break;
							}
							
							if (choice11<=0) 
							{
								System.out.println("Please press valid number! \n");
								continue;
							}
							
							ICountable chocolate = new Chocolate(choice11*(0.5));
							bus.sell(chocolate);
							flag11=false;
						}
						flag11=true;
						break;
						
						
					case 3:
						while(flag11)
						{
							int choice11=-1;
							System.out.println("Enter the count of item");
							try
							{
								choice11=scanner.nextInt();

							} 
							catch (Exception e) 
							{
								System.out.println("Please press valid number! \n");
								break;
							}
							
							if (choice11<=0) 
							{
								System.out.println("Please press valid number! \n");
								continue;
							}
							ICountable yogurt = new Yogurt(choice11*2);
							bus.sell(yogurt);
							flag11=false;
						}
						flag11=true;
						break;
						
					case 0:
						break;
						

					default:
						System.out.println("Please enter valid number! \n");
						continue;
					}

					flag10=false;
				}
				flag10=true;
				break;
				
				
			case 6:
				bus.display();
				break;
				
			case 0:
				flag= false;
				break;
				
			default:
				continue;
			}
			
			
		}

		
	}
}
