package G01_CENG211_HW1;


import java.util.Date;

public class CityWeather 
{
	// We create our variables,constructor and set and get methods.
	
	private City city;
	private Weather weather;
	private Date date;
	
	public CityWeather(City city,Weather weather, Date date)
	{
		this.city = city;
		this.weather = weather;
		this.date = date;
	}

	public City getCity() 
	{
		return city;
	}

	public void setCity(City city)
	{
		this.city = city;
	}

	public Weather getWeather() 
	{
		return weather;
	}
	
	public String toString() 
	{
		return city.getName();
	}
	public void setWeather(Weather weather) 
	{
		this.weather = weather;
	}

	public Date getDate() 
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}
	
	

}
