package G01_CENG211_HW2;

import java.util.Scanner;

import Interfaces.ISearchable;

public class ArrayListSearcher implements ISearchable {

	Vault vault;

	// We take vault object from main class to reach the lists of artworks and
	// persons.
	public ArrayListSearcher(Vault vault) {
		this.vault = vault;
	}

	public void search() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		System.out.println("\n\n");
		ArrayListSorter ALS = new ArrayListSorter(vault); // We create a ArrayListSorter object which takes a parameter
															// of vault.
		// We want to reach name sorted lists using ALS.

		// In for loop we travel to name sorted architect list to reach architect
		// objects
		// if given string is in an architect object's string, we print the object's
		// definition.
		for (int i = 0; i < ALS.sort(5, 1).size(); i++) {
			String objectString = ALS.sort(5, 1).get(i).toString();
			if (objectString.contains(str)) {
				System.out.println(ALS.sort(5, 1).get(i).toString() + "\n");
			}
		}

		// In for loop we travel to name sorted architecture list to reach architecture
		// objects
		// if given string is in an architecture object's string, we print the object's
		// definition.
		for (int i = 0; i < ALS.sort(3, 1).size(); i++) {
			String objectString = ALS.sort(3, 1).get(i).toString();
			if (objectString.contains(str)) {
				System.out.println(ALS.sort(3, 1).get(i).toString() + "\n");
			}
		}

		// In for loop we travel to name sorted artist list to reach artist objects
		// if given string is in a artist object's string, we print the object's
		// definition.
		for (int i = 0; i < ALS.sort(4, 1).size(); i++) {
			String objectString = ALS.sort(4, 1).get(i).toString();
			if (objectString.contains(str)) {
				System.out.println(ALS.sort(4, 1).get(i).toString() + "\n");
			}
		}

		// In for loop we travel to name sorted painting list to reach painting objects
		// if given string is in a painting object's string, we print the object's
		// definition.
		for (int i = 0; i < ALS.sort(1, 1).size(); i++) {
			String objectString = ALS.sort(1, 1).get(i).toString();
			if (objectString.contains(str)) {
				System.out.println(ALS.sort(1, 1).get(i).toString() + "\n");
			}
		}

		// In for loop we travel to name sorted sculpture list to reach sculpture
		// objects
		// if given string is in a sculpture object's string, we print the object's
		// definition.
		for (int i = 0; i < ALS.sort(2, 1).size(); i++) {
			String objectString = ALS.sort(2, 1).get(i).toString();
			if (objectString.contains(str)) {
				System.out.println(ALS.sort(2, 1).get(i).toString() + "\n");
			}
		}

	}

}
