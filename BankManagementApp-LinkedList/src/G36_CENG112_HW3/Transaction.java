package G36_CENG112_HW3;

public class Transaction<T> {

	private int id; 
	private ICustomer customer; // That is data of Transaction
	private int occupation; // needed time for transaction
	private int waiting; // needed time for previous transactions
	private Transaction next; // That is next transaction
	
	// I create my constructor
	public Transaction(T dataPortion)
	{	
		
			customer = (ICustomer) dataPortion; // I set data of transaction.
			
			//I set other variables.
			next =null;
			waiting = 0;
			id = customer.getId();
			occupation = customer.getOccupation();
	}
	
	// I create my constructor
	public Transaction(T dataPortion, Transaction nextTransaction)
	{
		customer = (ICustomer) dataPortion;
		next =nextTransaction;
	}
	
	
	public void setWaiting(int wait) 
	{
		waiting = wait;
	}
	public int getWaiting() 
	{
		
		return waiting;
	}
	
	// It returns data of transaction.
	public T getData()
	{
		return (T) customer;
	}
	
	// It returns next transaction.
	public Transaction getNextTransaction()
	{
		return next;
	}
	
	// It sets data of transaction.
	public void setData(T newData)
	{
		customer = (ICustomer) newData;
	}
	
	// It sets next transaction.
	public void setNextTransaction(Transaction nextTransaction)
	{
		next=nextTransaction;
	}
	




}
