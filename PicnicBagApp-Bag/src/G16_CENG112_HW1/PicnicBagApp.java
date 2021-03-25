package G16_CENG112_HW1;

import java.util.Scanner;

public class PicnicBagApp {

	public void operation() {

		// I create necessary things.
		FileIO fileIO = new FileIO();
		IBag<Item> inventoryBag = fileIO.readInventory();

		// I take an input from the user which is the size of bag.
		System.out.println("Select the size of your bag (Small, Medium, Big) ");

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String boyut = scanner.next();
		int boyutsayi = 0;

		switch (boyut) {
		case "Small": {
			boyutsayi = 5;
			break;
		}
		case "Medium": {
			boyutsayi = 10;
			break;
		}
		case "Big": {
			boyutsayi = 15;
			break;
		}

		default:
			System.out.println("Unexpected value: " + boyut);
			System.exit(0);
		}

		// I create my bags according to the given size.
		IBag<Item> picnic_bag = new PicnicBag<Item>(boyutsayi);
		IBag<Item> organictrashbag = new OrganicTrashBag<Item>(boyutsayi);
		IBag<Item> plastictrashbag = new PlasticTrashBag<Item>(boyutsayi);
		IBag<Item> papertrashbag = new PaperTrashBag<Item>(boyutsayi);

		boolean cont = true;
		while (cont) {
			System.out.println("\nWhich bag ? InventoryBag : 1, PicnicBag and trashbags : 2, To quit : 3");
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			int choice = scan.nextInt();

			switch (choice) {
			case 1: {
				inventoryBagOperations(inventoryBag, picnic_bag);
				break;
			}

			case 2: {
				picnicBagOperation(picnic_bag, plastictrashbag, organictrashbag, papertrashbag);
				break;
			}

			case 3: {
				cont = false;
				break;
			}
			default:
				System.out.println("Unexpected value: " + choice);
			}

		}

	}

	public void inventoryBagOperations(IBag<Item> inventoryBag, IBag<Item> picnic_bag) {
		// If user select the İnventoryBag to do some processes, I run codes below.
		System.out.println(
				"\nTo select an item : 1, To display the inventorybag : 2, To remove an item with index number : 3, To remove an item : 4 ");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();

		switch (choice) {
		case 1: {
			displayInventoryBag(inventoryBag, picnic_bag);
			break;
		}
		case 2: {
			// If user select the displaying bag, I display.
			inventoryBag.displayItems();
			break;
		}
		case 3: {
			// If user select removing item according to index number,I display the
			// removable items with their index number.
			// After that I remove the selected item.
			inventoryBag.displayItems();
			System.out.println("\nSelect an item according to index\n");
			scan = new Scanner(System.in);
			int index = scan.nextInt();
			inventoryBag.removeByIndex(index);
			break;
		}
		case 4: {
			// If user select removing, I remove an item with remove method.
			inventoryBag.remove();
			break;
		}
		default:
			System.out.println("Unexpected value: " + choice);
		}

	}

	public void displayInventoryBag(IBag<Item> inventoryBag, IBag<Item> picnic_bag) {
		// If user want to select an item, I display the items wtih index which user can
		// select.
		// I split selected item according to the name and type. I save the type of item
		// through boolean to use some processes after.
		String[] display_bag_inventory = inventoryBag.selectItem();
		System.out.println("\nSelect an item according to index\n");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int index = scan.nextInt();
		String[] split_item = null;
		Item selecteditem = new Item(null, null);
		boolean organic = false;
		boolean plastic = false;
		boolean paper = false;

		try {
			if (plastic != true && paper != true) {
				split_item = display_bag_inventory[index - 1].split(" organic");
				if (split_item[0].length() < display_bag_inventory[index - 1].length()) {
					organic = true;
				}
			}
			if (organic != true && plastic != true) {
				split_item = display_bag_inventory[index - 1].split(" paper");
				if (split_item[0].length() < display_bag_inventory[index - 1].length()) {
					paper = true;
				}
			}
			if (organic != true && paper != true) {
				split_item = display_bag_inventory[index - 1].split(" plastic");
				if (split_item[0].length() < display_bag_inventory[index - 1].length()) {
					plastic = true;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		} finally {
			// ... cleanup that will execute whether or not an error occurred ...
		}

		// I take the saved type from the code which is above and according to that I
		// create an item to use.
		if (organic) {
			selecteditem = new Item(split_item[0], "organic");
		} else if (paper) {
			selecteditem = new Item(split_item[0], "paper");
		}
		if (plastic) {
			selecteditem = new Item(split_item[0], "plastic");
		}

		if (inventoryBag.contains(selecteditem)) {
			System.out.println("\nSelected item is : " + selecteditem + "\n");

			System.out.println("\nTo add an item to picnicbag : 1, to remove from inventoryBag: 2");
			scan = new Scanner(System.in);
			int choice = scan.nextInt();
			switch (choice) {
			case 1: {
				// If user select the adding an item to picnicbag I control the contains method.
				// If method returns true, I add the item to picnic bag through transferTo
				// method and I print items count.

				System.out.println("\nItem is found in the inventoryBag.");
				inventoryBag.transferTo(picnic_bag, selecteditem);
				System.out.println("\nItem count updated.");

				break;
			}
			case 2: {
				// If user select the removing an item, I remove an item and print item count.
				inventoryBag.remove(selecteditem);
				System.out.println("\nItem count updated.");
				inventoryBag.getItemCount();
				break;
			}
			default:
				System.out.println("Unexpected value: " + choice);
			}
		}
		else
		{
			System.out.println("Invalid index");
		}

	}

	public void picnicBagOperation(IBag<Item> picnic_bag, IBag<Item> plastictrashbag, IBag<Item> organictrashbag,
			IBag<Item> papertrashbag) {
		// If user select picnic bag, I run codes below.
		System.out.println(
				"\nTo select an item to consume : 1, To display the picnicbag : 2, To display the trashbags : 3, To remove an item with index number : 4, To remove an item : 5");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();

		switch (choice) {
		case 1: {
			picnicBagConsumeItem(picnic_bag, plastictrashbag, organictrashbag, papertrashbag);
			break;
		}
		case 2: {
			// If user select the displaying picnic bag, I display.
			picnic_bag.displayItems();
			break;
		}
		case 3: {
			System.out.println("Consumed items are displayed according to their types in trashbags.");
			// If the user select the displaying trashbags, I display.
			System.out.println("\nPlasticTrashBag : ");
			plastictrashbag.displayItems();

			System.out.println("\nPaperTrashBag : ");
			papertrashbag.displayItems();

			System.out.println("\nOrganicTrashBag");
			organictrashbag.displayItems();
			break;
		}
		case 4: {
			// If user select removing item according to index number,I control picnic bag
			// is empty or not. If not I display the removable items with their index
			// number.
			// After that I remove the selected item.
			if (!picnic_bag.isEmpty()) {
				picnic_bag.displayItems();
				System.out.println("\nSelect an item according to index\n");
				scan = new Scanner(System.in);
				int index = scan.nextInt();
				picnic_bag.removeByIndex(index);

			}

			else {
				System.out.println("PicnicBag is empty.");
			}
			break;
		}

		case 5: {
			// If user select removing and bag is not empty I remove an item with remove
			// method.
			if (!picnic_bag.isEmpty()) {
				picnic_bag.remove();
			} else {
				System.out.println("PicnicBag is empty");
			}
			break;
		}

		default:
			throw new IllegalArgumentException("Unexpected value: " + choice);
		}

	}

	public void picnicBagConsumeItem(IBag<Item> picnic_bag, IBag<Item> plastictrashbag, IBag<Item> organictrashbag,
			IBag<Item> papertrashbag) {
		// If user want to to select an item, and picnic bag is not empty, I display the
		// items with index which user can select.
		// I split selected item according to the name and type. I save the type of item
		// through boolean to use some processes after.
		if (picnic_bag.isEmpty() == false) {
			String[] display_bag_picnic = picnic_bag.selectItem();
			System.out.println("\nSelect an index number. \n");
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			int index = scan.nextInt();
			String[] split_item = null;
			Item selecteditem = new Item(null, null);
			boolean organic = false;
			boolean plastic = false;
			boolean paper = false;

			try {
				if (plastic != true && paper != true) {
					split_item = display_bag_picnic[index - 1].split(" organic");
					if (split_item[0].length() < display_bag_picnic[index - 1].length()) {
						organic = true;
					}
				}
				if (organic != true && plastic != true) {
					split_item = display_bag_picnic[index - 1].split(" paper");
					if (split_item[0].length() < display_bag_picnic[index - 1].length()) {
						paper = true;
					}
				}
				if (organic != true && paper != true) {
					split_item = display_bag_picnic[index - 1].split(" plastic");
					if (split_item[0].length() < display_bag_picnic[index - 1].length()) {
						plastic = true;
					}
				}
			} finally {
				// ... cleanup that will execute whether or not an error occurred ...
			}

			// I take the saved type from the code which is above and according to that I
			// create an item to use.

			if (organic) {
				selecteditem = new Item(split_item[0], "organic");
			} else if (paper) {
				selecteditem = new Item(split_item[0], "paper");
			}
			if (plastic) {
				selecteditem = new Item(split_item[0], "plastic");
			}

			System.out.println("\nSelected item is : " + selecteditem);

			System.out.println("\nTo consume the item : 1. To back : Any number");
			scan = new Scanner(System.in);
			int choice = scan.nextInt();
			if (choice == 1) {
				// If user select the consuming an item I control the contains method.
				// If method returns true, I transfer item to the targeted trash bag.
				// I automatically save the type of item above,so it automatically transfers
				// item to the targeted trash bag.

				if (picnic_bag.contains(selecteditem)) {
					System.out.println("\nItem is found in the PicnicBag");

					if (organic == true) {

						picnic_bag.consume(selecteditem, organictrashbag);

					} else if (plastic == true) {

						picnic_bag.consume(selecteditem, plastictrashbag);

					} else if (paper == true) {

						picnic_bag.consume(selecteditem, papertrashbag);

					}

				} else {
					System.out.println("hata");
				}
			}
		}

		else {
			System.out.println("PicnicBag is empty.");
		}
	}
}
