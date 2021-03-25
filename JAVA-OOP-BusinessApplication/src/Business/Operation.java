package Business;

import java.util.Scanner;

import Exceptions.ItemNotUncountableException;
import Item.*;

public class Operation {

	public void operation() {
		Business bus = new Business(10000);
		boolean flag = true;

		System.out.println("Welcome");
		while (flag) {
			int choice = 100;
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			System.out.println("\n");
			System.out.println("1)Buying ingredients");
			System.out.println("2)Transfer to factory");
			System.out.println("3)Produce");
			System.out.println("4)Transfer to distrubution center");
			System.out.println("5)Sell");
			System.out.println("6)Display");
			System.out.println("0)Exit");

			try {
				choice = scanner.nextInt();
			} catch (Exception e) {
				System.out.println("Please press valid menu choice! \n");
				continue;
			}

			boolean isCont = true;
			switch (choice) {

			case 1:
				while (isCont) {
					int menuChoice = 0;
					System.out.println("Which ingredients do you want to buy?");
					System.out.println("1)Milk");
					System.out.println("2)Cacao");
					System.out.println("3)Yeast");
					System.out.println("4)Cream");
					System.out.println("0)Return to menu");

					try {
						menuChoice = scanner.nextInt();
						if (menuChoice == 0) {
							isCont = false;
						} else {
							int litre = 0;

							while (true) {
								System.out.println("Enter the litre");

								try {
									litre = scanner.nextInt();
									if (litre > 0) {
										break;
									} else {
										System.out.println("Invalid litre");
									}
								} catch (Exception e) {
									System.out.println("Please enter valid litre!");
									continue;
								}
							}
							buyIngredient(menuChoice, bus,litre);
						}

					} catch (Exception e) {
						System.out.println("Please press valid menu choice! \n");
						break;
					}

				}
				break;

			case 2:
				while (isCont) {
					int menuChoice = 0;
					System.out.println("Which ingredient do you want to transfer to factory?");

					System.out.println("1)Milk");
					System.out.println("2)Cacao");
					System.out.println("3)Yeast");
					System.out.println("4)Cream");
					System.out.println("0)Return to menu");

					try {
						menuChoice = scanner.nextInt();
						if (menuChoice == 0) {
							isCont = false;
						} else {
							transferToFactory(menuChoice, bus);
						}
					} catch (Exception e) {
						System.out.println("Please enter valid menu choice!");
						break;
					}

				}
				break;

			case 3:

				while (isCont) {
					int menuChoice = 0;
					System.out.println("Producing page :");
					System.out.println("1)BoxedMilk");
					System.out.println("2)Chocolate");
					System.out.println("3)Yogurt");
					System.out.println("0)Return to menu");

					try {
						menuChoice = scanner.nextInt();
						if (menuChoice == 0) {
							isCont = false;
						} else {
							int count = -1;

							while (true) {
								System.out.println("Enter the count of item");
								try {
									count = scanner.nextInt();
									if (count > 0) {
										break;
									} else {
										System.out.println("Invalid count");
									}
								} catch (Exception e) {
									System.out.println("Please enter valid count number!");
									continue;
								}
							}
							producingPage(menuChoice, bus, count);
						}
					} catch (Exception e) {
						System.out.println("Please enter valid menu choice!");
						break;
					}

				}
				break;

			case 4:
				while (isCont) {
					int menuChoice = -1;
					System.out.println("Transferring from factory to distribution page:");
					System.out.println("1)Transfer BoxedMilk");
					System.out.println("2)Transfer Chocolate");
					System.out.println("3)Transfer Yogurt");
					System.out.println("0)Return up menu");

					try {
						menuChoice = scanner.nextInt();
						if (menuChoice == 0) {
							isCont = false;
						} else {
							transferringFromFactoryToDistribution(menuChoice, bus);
						}
					} catch (Exception e) {
						System.out.println("Please press valid number! \n");
						break;
					}

				}

				break;

			case 5:
				int menuChoice = -1;
				while (isCont) {
					System.out.println("Selling page:");
					System.out.println("1)Sell BoxedMilk");
					System.out.println("2)Sell Chocolate");
					System.out.println("3)Sell Yogurt");
					System.out.println("0)Return to menu");

					try {
						menuChoice = scanner.nextInt();
						if (menuChoice == 0) {
							isCont = false;
						} else {
							int count = -1;

							while (true) {
								System.out.println("Enter the count of item");
								try {
									count = scanner.nextInt();

									if (count > 0) {
										break;
									} else {
										System.out.println("Invalid count");
									}

								} catch (Exception e) {
									System.out.println("Please press valid count number! \n");
									continue;
								}

							}
							sell(menuChoice, bus, count);
						}
					} catch (Exception e) {
						System.out.println("Please press valid menu choice! \n");
						break;
					}
				}
				break;

			case 6:
				bus.display();
				break;

			case 0:
				flag=false;
				break;

			default:
				continue;
			}

		}

	}

	public void buyIngredient(int choice, Business bus, int litre) {

		

		switch (choice) {

		case 1:
			IUncountable milk = new Milk(litre);
			try {
				bus.buy(milk);
			} catch (ItemNotUncountableException e) {
				e.printStackTrace();
			}

			break;

		case 2:
			IUncountable cacao = new Cacao(litre);
			try {
				bus.buy(cacao);
			} catch (ItemNotUncountableException e) {
				e.printStackTrace();
			}
			break;

		case 3:
			IUncountable yeast = new Yeast(litre);
			try {
				bus.buy(yeast);
			} catch (ItemNotUncountableException e) {
				e.printStackTrace();
			}
			break;

		case 4:
			IUncountable cream = new Cream(litre);
			try {
				bus.buy(cream);
			} catch (ItemNotUncountableException e) {
				e.printStackTrace();
			}
			break;

		default:
			System.out.println("Please enter valid menu choice! \n ");
			break;
		}
	}

	public void transferToFactory(int choice, Business bus) {

		switch (choice) {
		case 1:
			IUncountable milk = new Milk(0);
			try {
				bus.transfer(milk);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		case 2:
			IUncountable cacao = new Cacao(0);
			try {
				bus.transfer(cacao);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		case 3:
			IUncountable yeast = new Yeast(0);
			try {
				bus.transfer(yeast);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		case 4:
			IUncountable cream = new Cream(0);
			try {
				bus.transfer(cream);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		default:
			System.out.println("Please enter valid menu choice!");
			break;
		}
	}

	public void producingPage(int choice, Business bus, int count) {

		switch (choice) {

		case 1:
			ICountable boxedMilk = new BoxedMilk(count);
			bus.üret(boxedMilk);
			break;

		case 2:

			ICountable chocolate = new Chocolate(count * (0.5));
			bus.üret(chocolate);

			break;

		case 3:
			ICountable yogurt = new Yogurt(count * 2);
			bus.üret(yogurt);
			break;

		default:
			System.out.println("Please enter valid menu choice!\n");
			break;
		}
	}

	public void transferringFromFactoryToDistribution(int choice, Business bus) {

		switch (choice) {

		case 1:
			ICountable boxedMilk = new BoxedMilk(0);
			try {
				bus.transfer(boxedMilk);
			} catch (Exception e) {
				e.printStackTrace();
			}

			break;

		case 2:
			ICountable chocolate = new Chocolate(0);
			try {
				bus.transfer(chocolate);
			} catch (Exception e) {
				e.printStackTrace();
			}

			break;
		case 3:
			ICountable yogurt = new Yogurt(0);
			try {
				bus.transfer(yogurt);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		default:
			System.out.println("Please press valid menu choice! \n");
			break;
		}
	}

	public void sell(int choice, Business bus, int count) {

		switch (choice) {

		case 1:
			ICountable boxedMilk = new BoxedMilk(count);
			bus.sell(boxedMilk);
			break;

		case 2:
			ICountable chocolate = new Chocolate(count * (0.5));
			bus.sell(chocolate);
			break;

		case 3:
			ICountable yogurt = new Yogurt(count * 2);
			bus.sell(yogurt);
			break;

		default:
			System.out.println("Please enter valid menu choice! \n");
		}
	}
}
