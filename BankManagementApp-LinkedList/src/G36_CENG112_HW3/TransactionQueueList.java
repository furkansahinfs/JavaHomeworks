package G36_CENG112_HW3;

public class TransactionQueueList<T> {

	private TransactionQueue head;
	private TransactionQueue last;
	private int listLength;

	// I create my constructor.
	public TransactionQueueList() {
		head = null;
		listLength = 0;
	}

	// I insert TQ to list and increase queueLength.
	public void insertTo(TransactionQueue TQ) {
		if (isEmpty()) {
			head = TQ;
			last = TQ;
		} else {
			last.setNextTransactionQueue(TQ);
			last = TQ;

		}
		listLength++;
	}

	public boolean isEmpty() {
		return (head == null);
	}

	public boolean clear() {
		if (head == null & last == null) {
			return false;
		} else {
			head = null;
			last = null;
			return true;
		}

	}

	public TransactionQueue getTQ(String date) {
		// To return specific TransactionQueue , code moves on one by one until given
		// date equals to pos's date.
		TransactionQueue pos = head;
		String TQdate = pos.getDate();

		for (int i = 0; i < listLength; i++) {
			if (TQdate.equals(date)) {
				break;
			} else {
				pos = pos.getNextTransactionQueue();
				TQdate = pos.getDate();
			}

		}
		return pos;
	}

	public void toStringTQ(String date) {
		// To print the specific transaction queue

		TransactionQueue pos = getTQ(date);
		System.out.println(pos);
	}

	public boolean updateTQ(String date, TransactionQueue TQ) {
		// code moves on one by one until given date equals to TQ's date, after that I
		// set the new TQ.
		TransactionQueue tempTQ = head;
		Customer tempTQData = (Customer) tempTQ.getTransaction().getData();
		while (!tempTQData.date.equals(date)) {
			tempTQ.getNextTransactionQueue();
		}
		tempTQ.setTransaction(TQ.getTransaction());

		return true;
	}

	public String maxWorkload() {
		// To find maxWorkLoad, I create TQ max which keeps TQ contains max waiting
		// time. Code moves on TQ one by one and compare the waiting times.
		TransactionQueue pos = head;
		TransactionQueue max = pos;
		TransactionQueue maxtemp = pos;
		for (int i = 0; i < listLength - 1; i++) {

			maxtemp = pos.getNextTransactionQueue();
			if (maxtemp.TotalWaitingTime() > max.TotalWaitingTime()) {
				max = maxtemp;
			}

		}
		return max.getDate();
	}

	public TransactionQueue removeTQ(String date) {
		return null;

	}

	public void display() {
		// To display the TransactionQueuesList, code move on one by one on
		// transactionQueue and print them.
		TransactionQueue temp = head;

		for (int i = 0; i < listLength; i++) {

			temp.display();
			temp = temp.getNextTransactionQueue();
		}

	}

}
