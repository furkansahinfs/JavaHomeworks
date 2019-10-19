package G36_CENG112_HW4;

public class Book implements IMedia{
	// I create my variables
	private String info; // Info is a row of the file.
	private String mediaType;
	private String mediaName;
	private int mediaPrice;
	private int mediaYear;
	private String authorName;
	
	

	public Book(String info)
    {
		this.info = info; // this is a row of the file.
		String[] strs = info.split(","); /* I split the row and according to order I assign the values to the variables */
		mediaType = strs[0];
		mediaName = strs[1];
		mediaPrice = Integer.parseInt(strs[2]);
		mediaYear = Integer.parseInt(strs[3]);
		authorName= strs[4];

    }   
	
	public String mediaName() {
		return mediaName;
	}
	public String mediaType() {
		return mediaType;
	}
	public int mediaPrice() {
		return mediaPrice;
	}
	public int mediaYear() {
		return mediaYear;
	}
	
		public String toString() {
		return info;
	 }

	@Override
	public String mediaOwner() {
		return authorName;
	}

}
