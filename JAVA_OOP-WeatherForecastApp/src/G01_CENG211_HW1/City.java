package G01_CENG211_HW1;

public class City {
	
	// We create our variables,constructor and set and get methods.
	
	private int plateNo;
	private String name;
	private Region region;
	private int altitude;
	
	public City(int plateNo,String name,Region region,int altitude) 
	{
		this.plateNo = plateNo;
		this.name = name;
		this.region = region;
		this.altitude = altitude;
	}

	public int getPlateNo() {
		return plateNo;
	}

	public void setPlateNo(int plateNo) {
		this.plateNo = plateNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public int getAltitude() {
		return altitude;
	}
	
	public String toString() {
		return name;
	}

	public void setAltitude(int altitude) {
		this.altitude = altitude;
	}

	

}
