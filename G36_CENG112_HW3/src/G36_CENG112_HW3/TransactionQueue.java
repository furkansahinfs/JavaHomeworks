package G36_CENG112_HW3;

public class TransactionQueue<T> {

	private Transaction head; 
	private Transaction last;
	private int queueLength;
	private int totalWaitingTime;
	private String date;
	private TransactionQueue next;

     // I create my constructor.
     public TransactionQueue(Transaction T)
     {
    	 head = T;
    	 last = T;
    	 queueLength =0;
    	 totalWaitingTime = 0;
    	
    	
     }   
     

     // I insert T to queue and increase queueLength.
	 public void insert(Transaction T) 
	 {	    
		 if(isEmpty())
		 {
			 head = T;
			 last = T;
		 }
		 else
		 {
			last.setNextTransaction(T);
			last = T;
		 }
		
		queueLength++; 
	 }
	 
	 // I calculate and set waiting time of transactions
	public void Time()
	{
		int waitedTime; // Waited time of Transaction
		int occupatedTime; // Occupated time of Transaction
		
		Transaction position = head; // I create a transaction and equal it head firstly.
		Transaction positionNext = position.getNextTransaction();  // I create a transaction and equal it position's next.
		Customer positionData =(Customer) position.getData(); // I create a customer which contains position transaction's data.
		Customer positionNextData = (Customer) positionNext.getData(); // I create a customer which contains position's next transaction's data.
		
		for(int i=0;i<queueLength-1;i++) {
			 	positionData = (Customer) position.getData(); // I update position's data
			 	positionNextData = (Customer) positionNext.getData(); // I update position next's data.
				positionNext.setWaiting(positionData.getOccupation() + position.getWaiting()); // I set position next's waiting time with adding position's occupation time to position's waiting time	
				position = position.getNextTransaction(); // I push forward position to next transaction.
				positionNext = positionNext.getNextTransaction(); // I push forward positionnext to position's next transaction's next transaction.
			}
			
		}
	

	
	
	public void Sort()
	 {   
		// I sort transactionQueue according to priority of transactions with bubble sort.
		 for(int i=0;i<queueLength-1;i++)
		 {

			 Transaction position = head; // I create a transaction and equal it head firstly.
		     Transaction positionNext = head.getNextTransaction(); // I create a transaction and equal it position's next.
		     Customer positionData = (Customer) position.getData(); // I create a customer which contains position transaction's data.
		     Customer positionNextData = (Customer) positionNext.getData(); // I create a customer which contains position's next transaction's data.
		    
			 for(int j=0;j<(queueLength-i-1);j++)
			 {
				 positionData = (Customer) position.getData(); // I update position's data
				 positionNextData = (Customer) positionNext.getData(); // I update position next's data.
				if(positionData.getPriority() > positionNextData.getPriority()) // I compare priority of position and position's next through GetPriorty().
				{
					// If position priority number (1,2,3) > positionNext priority, switch the data.   
					Customer temp = (Customer) position.getData();

					position.setData(positionNext.getData());
					positionNext.setData(temp);
					
				}
				
				position = position.getNextTransaction();  // I push forward position to next transaction.
				
				positionNext = positionNext.getNextTransaction();// I push forward positionnext to position's next transaction's next transaction.
			
				
			 }
		 }
		 // After sort I invoke Time function to set waiting times of transactions.
		 Time();
	 }
	 
	 public int TotalWaitingTime()
	 {
		 // It sums all waiting time of transactions of transactionQueues.
		Transaction position = head;
			
		for(int i=0;i<queueLength-1;i++) {
			position = position.getNextTransaction();
			totalWaitingTime += position.getWaiting();
		}
		return totalWaitingTime;
	 }
	 
	 public int TWTSpecific(String type)
	 {
		 // It sums waiting times of a specific transactionQueue.
		 int twtspecifictype=0;

		Transaction position = head;
		Customer positionData =(Customer) position.getData();
		
		for(int i=0;i<queueLength-1;i++) {
			positionData = (Customer) position.getData();
			if(positionData.getType().equals(type))
			{
				twtspecifictype+= position.getWaiting();
			}
			position = position.getNextTransaction();
		}
		return twtspecifictype;
	 }
	 
	 public float AWTSpecific(String type)
	 {
		 // It returns average waiting time of specific transactionqueue.
		return (float)TWTSpecific(type)/SpecificTransaction(type);
	 }
	 public float AverageWaitingTime()
	 {
		// It returns average waiting time.
		return (float) (totalWaitingTime / queueLength);
	 }
	 
	 public int SpecificTransaction(String type)
	 {
		 
		int specifictype_count = 0; // it is the variable of count of specific type transactions like CORPORATE.
		Transaction position = head; // I create a transaction and equal it head firstly.
		Customer positionData =(Customer) position.getData(); // I create a customer which contains position transaction's data.
		
		for(int i=0;i<queueLength-1;i++) {
			positionData = (Customer) position.getData(); // update positionData
			if(positionData.getType().equals(type)) // If given type equals position transaction's type increase count.
			{
				specifictype_count++;
			}
			position = position.getNextTransaction(); // I push forward position to next transaction.
}
		return specifictype_count;
		 
	 }
	 public Transaction remove() 
	 {
		 // It removes first transaction and return it.
		Transaction temp = head;
		if(!isEmpty())
		{
			head = head.getNextTransaction();
		}
		return temp;
	}
	 


	public boolean isEmpty() 
	{
		return head==null;
	}
	
	
	public boolean clear() 
	{
		head = null;
		return head==null;
	}

	public int getLength()
	{
		return queueLength;
	}
	
	public void display()
	{
		// To display the TransactionQueue, code move on one by one on transactions and print their infos.
		Sort();
	
		Transaction temp = head;
		
		for(int i=0;i<queueLength;i++)
		{
			Customer tempData = (Customer) temp.getData();
			System.out.println(tempData.info);
			temp = temp.getNextTransaction();
		}
		Time();
	}
	
	public String getDate() {
		// To get date of transactionQueue, I take date of transactionQueue through head's data.
 		Customer headCustomerData =  (Customer) head.getData(); 
 		date = headCustomerData.getDate();
 		return date;
	}

	public void setTransaction(Transaction head)
	{
		 this.head = head;
	}
	
	public String toString()
	{
		// It returns the transactions info according to determined form.
		// for example 01.05.2019 COUNTER <- 101|CORPORATE|5|0<-102|INDIVIDUAL|4|5<-100|NON-REGISTERED|3|9<-103|NON-REGISTERED|2|12
		String TQ = "";
		Transaction temp = head;
		Customer tempData = (Customer) temp.getData();
		TQ = TQ + tempData.date;
		TQ = TQ+ " COUNTER <- ";
		for(int i=0;i<queueLength;i++)
		{
			tempData = (Customer) temp.getData();
			TQ = (TQ + tempData.getId() + "|" + tempData.getType() + "|" + tempData.getOccupation() + "|" + temp.getWaiting() + "<-");
			temp = temp.getNextTransaction();
		}
		return TQ;
		
	}
	
	// It returns head.
	public Transaction getTransaction()
	{
		 return head;
	}
	
	// It sets next transactionQueue to given TQ
	public void setNextTransactionQueue(TransactionQueue nextTQ)
	{
		next = nextTQ;
	}
	
	// It returns next TransactionQueue.
	public TransactionQueue getNextTransactionQueue()
	{
		return next;
	}
	

	
		
}

