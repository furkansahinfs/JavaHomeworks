package G01_CENG211_HW1;

public class Region {
	
	// We create our variables,constructor and set and get methods.
	
	private int id;
	private String name;
	public ArrayX cities; // This list is a list which contains cities of a region.

	
	
	public Region(int id,String name, ArrayX cityList) 
	{
		this.id = id;
		this.name = name;
		this.cities = cityList;

	}
	
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public ArrayX getCityList() 
	{
		return cities;
	}
	
	// In set method we take a city and add the city to the cities list.
	public void setCitytoCityList(City city)
	{
		cities.add(city);
	}
	

}
