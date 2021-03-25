package G36_CENG112_HW3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileIO {

	public TransactionQueueList<TransactionQueue> readFile() {
		// I create my TQueueList and TQueues.
		TransactionQueueList<TransactionQueue> linkedqueueslist = new TransactionQueueList();

		TransactionQueue<Transaction> linkedqueue1 = new TransactionQueue(null);
		TransactionQueue<Transaction> linkedqueue2 = new TransactionQueue(null);
		TransactionQueue<Transaction> linkedqueue3 = new TransactionQueue(null);
		TransactionQueue<Transaction> linkedqueue4 = new TransactionQueue(null);
		TransactionQueue<Transaction> linkedqueue5 = new TransactionQueue(null);

		FileReader dosyaOkuyucu;
		BufferedReader okuyucu;

		// I try to read the file and its rows one by one.
		try {

			dosyaOkuyucu = new FileReader("CENG112_HW3_Transactions.txt");
			okuyucu = new BufferedReader(dosyaOkuyucu);

			String satir = okuyucu.readLine();

			while (satir != null) {

				String[] strs = satir.split(",");
				// According to date of row, I create customer which takes rows as customer's
				// info.
				// I create a transaction which its data is customer.
				// I add transaction to transactionqueue according to its date.
				if (strs[0].equals("01.05.2019")) {
					Customer newCustomer = new Customer(satir);
					Transaction newTransaction = new Transaction(newCustomer);
					linkedqueue1.insert(newTransaction);
				}

				else if (strs[0].equals("02.05.2019")) {
					Customer newCustomer = new Customer(satir);
					Transaction newTransaction = new Transaction(newCustomer);
					linkedqueue2.insert(newTransaction);
				}

				else if (strs[0].equals("03.05.2019")) {
					Customer newCustomer = new Customer(satir);
					Transaction newTransaction = new Transaction(newCustomer);
					linkedqueue3.insert(newTransaction);
				}

				else if (strs[0].equals("04.05.2019")) {
					Customer newCustomer = new Customer(satir);
					Transaction newTransaction = new Transaction(newCustomer);
					linkedqueue4.insert(newTransaction);
				}

				else if (strs[0].equals("05.05.2019")) {
					Customer newCustomer = new Customer(satir);
					Transaction newTransaction = new Transaction(newCustomer);
					linkedqueue5.insert(newTransaction);
				}

				satir = okuyucu.readLine();
			}

			// I sort transactionqueue's transactions according to priority with bubble
			// sort.
			linkedqueue1.Sort();
			linkedqueue2.Sort();
			linkedqueue3.Sort();
			linkedqueue4.Sort();
			linkedqueue5.Sort();

			// I add transactionqueues after sorting to transactionqueueslist.
			linkedqueueslist.insertTo(linkedqueue1);
			linkedqueueslist.insertTo(linkedqueue2);
			linkedqueueslist.insertTo(linkedqueue3);
			linkedqueueslist.insertTo(linkedqueue4);
			linkedqueueslist.insertTo(linkedqueue5);

		}

		catch (FileNotFoundException ex) {
			System.out.println("File is not found.");
		} catch (IOException ex) {
			System.out.println("Error is not found.");
		}

		return (linkedqueueslist);

	}

}