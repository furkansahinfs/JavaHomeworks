package G01_CENG211_HW1;

public class Weather {
	// We create our variables,constructor and set and get methods.
	
	private int wind;
	private double temperature;
	private double fltemperature;
	private int humidity;
	private int precipitation;
	private String visibility;
	
	public Weather(int wind,double temperature,double fltemperature,int humidity,int precipitation,String visibility)
	{
		this.wind = wind;
		this.fltemperature = fltemperature;
		this.temperature = temperature;
		this.humidity = humidity;
		this.precipitation = precipitation;
		this.visibility = visibility;
	}

	public int getWind()
	{
		return wind;
	}

	public void setWind(int wind) 
	{
		this.wind = wind;
	}

	public double getTemperature() 
	{
		return temperature;
	}

	public void setTemperature(double temperature) 
	{
		this.temperature = temperature;
	}

	public double getFltemperature() 
	{
		return fltemperature;
	}

	public void setFltemperature(double fltemperature) 
	{
		this.fltemperature = fltemperature;
	}

	public int getHumidity() 
	{
		return humidity;
	}

	public void setHumidity(int humidity) 
	{
		this.humidity = humidity;
	}

	public int getPrecipitation()
	{
		return precipitation;
	}

	public void setPrecipitation(int precipitation) 
	{
		this.precipitation = precipitation;
	}

	public String getVisibility() 
	{
		return visibility;
	}

	public void setVisibility(String visibility)
	{
		this.visibility = visibility;
	}
	
}
