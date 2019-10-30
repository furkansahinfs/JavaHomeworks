package G36_CENG112_HW3;

public class Customer implements ICustomer {

	private int id; // unique id in [1,1000]
	public String info; // informatios which take from txt
	public String type; // priorirty type
	public String date; // customer's transaction date
	private int occupation; // needed time for transaction
	
	// I create my constructor.
	public Customer()
	{
		id = 0;
		info=null;
		type=null;
		date=null;
		occupation=0;
	}
	
	// I create my constructor according to information and I assign the values.
	public Customer(String info)
    {
		this.info = info; // dosyadan alınan satır = info
		String[] strs = info.split(",");
		id = Integer.parseInt(strs[1]);
		occupation = Integer.parseInt(strs[3]);
		type = strs[2];
		date = strs[0];
    }   
				

	// It returns the information of transaction.
	public String getInfo()
	{
		return info;
	}

	// It returns date of transaction.
	public String getDate()
	{
		return date;
		
	}
	
	// It returns ID of customer.
	public int getId()
	{
		return id;
		
	}
	
	// It returns occupation of customer's transaction.
	public int getOccupation()
	{
		return occupation;
		
	}
	
	// It returns customer's priority type.
	public String getType() 
	{
		return type;
	}
	

	
	// It returns customer's priority.
	@Override
	public int getPriority() {
		int priority=-1;
		if(getType().equals("CORPORATE"))
		{
			priority = 1;
		}
		else if(getType().equals("INDIVIDUAL"))
		{
			priority = 2;
		}
		else if(getType().equals("NON-REGISTERED"))
		{
			priority = 3;
		}

		return priority;
	}
	}
