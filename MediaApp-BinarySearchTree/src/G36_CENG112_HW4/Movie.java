package G36_CENG112_HW4;

import java.util.List;

public class Movie implements IMedia{
	// I create my variables
	private String info; // Info is one row of the file.
	private String mediaType;
	private String mediaName;
	private int mediaPrice;
	private int mediaYear;
	private String actor="";
	private String directorName;
	

	
	public Movie(String info)
    {
		this.info = info; // this is a row of the file.
		String[] strs = info.split(","); /* I split the row and according to order I assign the values to the variables */
		mediaType = strs[0];
		mediaName = strs[1];
		mediaPrice = Integer.parseInt(strs[2]);
		mediaYear = Integer.parseInt(strs[3]);
		directorName = strs[4];
		
		/* I add the actor names which after the director name in the row to actor string.*/ 
		for(int j=5;j<strs.length;j++)
		{
			actor += strs[j]+",";

		}
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
		return directorName;
	}
}
