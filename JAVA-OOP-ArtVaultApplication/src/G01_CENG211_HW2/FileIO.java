package G01_CENG211_HW2;

import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileIO {

	// We read the csv file and add the string lines to list.

	public ArrayList<Object> readFile() {

		// We create our variables
		FileReader dosyaOkuyucu;
		BufferedReader okuyucu;
		ArrayList<Object> list = new ArrayList<Object>();

		try {
			dosyaOkuyucu = new FileReader("CENG211_HW2_ArtVaultData.csv");
			okuyucu = new BufferedReader(dosyaOkuyucu);

			String satir = okuyucu.readLine();

			while (satir != null) {
				list.add(satir);

				satir = okuyucu.readLine();
			}

			okuyucu.close();

		}

		catch (FileNotFoundException ex) {
			System.out.println("File is not found.");
		} catch (IOException ex) {
			System.out.println("Error exception.");
		}
		return list;

	}

}
