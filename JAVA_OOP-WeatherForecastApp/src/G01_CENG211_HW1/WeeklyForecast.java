package G01_CENG211_HW1;

import java.sql.Date;
import java.util.Arrays;

public class WeeklyForecast {
	// We create our variables
	private Object[][] cityWeatherList; 
	int numberOfCityWeather; // Variable holds the number of cities actually.
	int numberOfDate; // Variable holds the number of the cities' date.
	int sinir; // It is the capacity of first dimension.
	int sinir2; //It is the capacity of second dimension.
	boolean dateFirst = false;  // I use it to know what the first date of week is. ( like 14 - 15 etc )
	int dateX; // I use it to know what the first date of week is. ( like 14 - 15 etc )
	
	
	public WeeklyForecast(int elemanKapasitesi, int elemanKapasitesi2) 
	{
		cityWeatherList = new Object[elemanKapasitesi][elemanKapasitesi2];
		numberOfCityWeather = 0;       
		numberOfDate =0;
		sinir = elemanKapasitesi;
		sinir2 = elemanKapasitesi2;
	}
	
	// Our get,set methods.
	public Object[][] getCityWeatherList() 
	{
		return cityWeatherList;
	}


	public void setCityWeatherList(Object[][] cityWeatherList) 
	{
		this.cityWeatherList = cityWeatherList;
	}
	
	
	@SuppressWarnings("deprecation")
	
	//If the number of cityWeather is smaller than the capacity of first dimension, we control that if the number of dates is smaller than capacity of second dimension.
	// If # of dates is smaller we assign the cityWeather to the index. If not we increase the number of cityWeather, make #ofdate zero and assign the cityWeather to the index
	public void add(CityWeather cityWeather) 
	{
		// I want to know what the first date of week is. ( like 3 - 14 - 15 etc ). So I execute an if block which runs just once until program ends.
		if(dateFirst == false) {
			dateX = cityWeather.getDate().getDate();
			dateFirst = true;
		}
		if(numberOfCityWeather<sinir) 
		{
			if(numberOfDate<sinir2)
			{
				ensureCapacity();
				cityWeatherList[cityWeather.getCity().getPlateNo()-1][cityWeather.getDate().getDate()-dateX] = cityWeather;
				numberOfDate++;
			}
			else
			{
				numberOfCityWeather++;
				numberOfDate =0;
				ensureCapacity();
				cityWeatherList[cityWeather.getCity().getPlateNo()-1][cityWeather.getDate().getDate()-dateX] = cityWeather;
				numberOfDate++;
			}
		}

		else
		{
			ensureCapacity();
			add(cityWeather);
		}
	}
	
	public void ensureCapacity() 
	{
		int capacity = this.cityWeatherList.length-1;
		if(numberOfCityWeather>=capacity)
		{
			int newCapacity = 2*capacity;
			this.sinir = newCapacity+1;
			Object[][] cityWeatherListNew = new Object[newCapacity][7];
			for(int i=0;i<=numberOfCityWeather;i++)
			{
				for(int j=0;j<7;j++)
				{
					cityWeatherListNew[i][j] = cityWeatherList[i][j];
				}
			}
			cityWeatherList = cityWeatherListNew;
		}
		
			
	}
	
	// We print all the weathers.
	public void yaz() 
	{
		for(int i=0;i<=numberOfCityWeather;i++)
		{
			for(int j=0;j<7;j++)
			{
			System.out.println( cityWeatherList[i][j].toString());
			}
		}

	}
	
	
}