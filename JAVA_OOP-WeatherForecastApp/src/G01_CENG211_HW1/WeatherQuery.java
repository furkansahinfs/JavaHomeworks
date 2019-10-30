package G01_CENG211_HW1;

public class WeatherQuery {
	// We create our variables,constructor
	public Object[][] cityWeatherList;
	public int numberOfCityWeather = 0;

	public WeatherQuery(Object[][] returnedWL, int numberOfCityWeather) 
	{
		this.cityWeatherList = returnedWL; // We assign WeeklyForecast's list to the cityWeatherList.
		this.numberOfCityWeather = numberOfCityWeather+1;
	}
	
	//We take a cityName and control the visibility and wind of this city when we wander in the cityWeatherList (weeklyForecast's list) and add the name to a string.
	public String DroneFlying(String CityName)
	{
		String names ="";
		double x = -100;
		double curent;
		CityWeather cityWeather;
		for(int i=0;i<numberOfCityWeather;i++)
		{
			for(int j=0;j<7;j++)
			{
				cityWeather =(CityWeather) cityWeatherList[i][j];
				if (CityName.equalsIgnoreCase(cityWeather.getCity().getName()))
				{
					if ((cityWeather.getWeather().getVisibility().equals("medium") || cityWeather.getWeather().getVisibility().equals("high") ) && cityWeather.getWeather().getWind()<40) 
					{
						names=names+(cityWeather.getDate().toString())+"/ ";
					}
				}
				
			}
			
		}
		return names;
	}
	
	
		
	public String getHighestAvgHumudity(ArrayX regionlist) 
	{
		// We take a regionList from the code.

		int regionNumber = regionlist.urunSayisi;
		double max=0;
		String maxName="";
		double regionOrtalama = 0.0;
		
		// We wander in the cityWeatherList (weeklyForecast's list). 
		// We control the regionName of the cityWeathers which are in the cityWeatherList and regionList's members name. If names are equal we add the humidity.
		// After we find the sum of all humidities in a region, we divide sum by number of city list's members of the region.  
		for (int k=0;k<regionNumber;k++)
		{
			for(int i=0;i<numberOfCityWeather;i++)
			{
				for(int j=0;j<7;j++)
				{
					CityWeather cityWheater =  (CityWeather) cityWeatherList[i][j];
					double hum= cityWheater.getWeather().getHumidity();
					String regionName=cityWheater.getCity().getRegion().getName();
					if (regionName== ((Region)regionlist.getList()[k]).getName()) 
					{
						regionOrtalama = regionOrtalama + hum;
					}		
				}
			}
			regionOrtalama = regionOrtalama/((Region)regionlist.getList()[k]).cities.urunSayisi;
			
			// If regionOrtalama is greater than max, we keep the region's name and make max equal to regionOrtalama.
			if(max<regionOrtalama)
			{
				maxName = ((Region)regionlist.getList()[k]).getName();
				max = regionOrtalama;		
			}
		}
		return maxName;
	}
	
	
	// We control the regionName of the cityWeathers which are in the cityWeatherList and regionList's members name. If names are equal we add the humidity.
	// After we find the sum of all humidities in a region, we divide sum by number of city list's members of the region. 
	public void GetFindestName() 
	{
		double avg=0;
		double top=0;
		double top1=0;
		double sonuç=0;
		double sonuç2=0;
		double minStandart=1090;
		double maxStandart=0;
		ArrayX maxArray= new ArrayX(1);
		ArrayX minArray= new ArrayX(1);

		// We wander in the cityWeatherList (weeklyForecast's list) and find the average temperature of cities.
		// After that we wander in the cityWeatherList and calculate the standart deviation of cities
		// and add the result to the minArray list. Also add the City object to the maxArray.
		// So we have two lists which behave as parallel lists, one of them holds standart deviations of cities, other holds cities.
		for(int i=0;i<numberOfCityWeather;i++)
		{
			for(int j=0;j<7;j++)
			{
				CityWeather cityWheater =  (CityWeather) cityWeatherList[i][j];
				top=top+cityWheater.getWeather().getTemperature();
			}
			
			avg=top/7;
			for(int k=0;k<7;k++)
			{
				CityWeather cityWeather =  (CityWeather) cityWeatherList[i][k];
				top1=top1+Math.pow((cityWeather.getWeather().getTemperature()-avg), 2);
			} 
			sonuç=Math.pow(top1/6,0.5);
			
			CityWeather cityWeather =  (CityWeather) cityWeatherList[i][0];
			minArray.add(sonuç);
			maxArray.add(cityWeather.getCity());
			avg=0;
			top=0;
			sonuç=0;
			top1=0;
				
		
		}

		// We want to be sure that there can exist same standart deviations of some cities. So we try to find that how many cities have same standart deviations.
		bubbleSort(minArray, maxArray);
		int count = 0;
		int count3=0;
		double minDeger = (double) minArray.getList()[2];
		int count2 = 0;
		int count4=0;
		int urunMax = minArray.urunSayisi;
		double maxDeger = (double) minArray.getList()[urunMax-3];
		
		for(int i=0;i<minArray.urunSayisi;i++) 
		{	
			if (count3<4){
				if(minArray.getList()[i]!=minArray.getList()[i+1]){
					count3=count3+1;
					count=i;
				}
				if (count3==4){
					break;
				}
			}
			
		}
		
		for(int i = minArray.urunSayisi-1;i>=0;i--) 
		{
			if (count4<4){
				if(minArray.getList()[i]!=minArray.getList()[i-1]){
					count4=count4+1;
					count2=i;
				}
				if (count4==4){
					break;
				}
			}
		}
		
		
		for(int i=count2;i<maxArray.urunSayisi;i++)
		{
			System.out.println(((City)maxArray.getList()[i]).getName());
		}
		
	}
	
	
	
	// We make minArray (holds standart deviations) sorted using bubbleSort, at the same time we make maxArray (holds cities) sorted according simultaneously to minArray.
	// So we don't lose the sort of city and its standart deviation. 
	public  void bubbleSort(ArrayX a, ArrayX b) 
    { 
        int n = a.urunSayisi; 
        for (int i = 0; i < n-1; i++) 
        {
            for (int j = 0; j < n-i-1; j++)
            { 
                if (((double) a.getList()[j]) >((double) a.getList()[j+1])) 
                { 
                    double temp = (double) a.getList()[j]; 
                    City temp2 = (City) b.getList()[j]; 
                    
                    a.getList()[j] = a.getList()[j+1]; 
                    a.getList()[j+1] = temp;

                    b.getList()[j] = b.getList()[j+1]; 
                    b.getList()[j+1] = temp2;
                } 
            }
        }
                
    }
	
	
	// We control the weather of whole days of a city to find rainy days which are tomorrow and next of tomorrow.
	public String Rainy()
	{
		String name ="";
		double prep;
		double prep2;
		
		for(int i=0;i<numberOfCityWeather;i++)
		{
			for(int j=0;j<1;j++)
			{
				CityWeather nowcityWeather =  (CityWeather) cityWeatherList[i][j];
				CityWeather tomorrowcityWeather =  (CityWeather) cityWeatherList[i][j+1];
				CityWeather tomorrowNextcityWeather =  (CityWeather) cityWeatherList[i][j+2];

				prep=tomorrowcityWeather.getWeather().getPrecipitation();
				prep2=tomorrowNextcityWeather.getWeather().getPrecipitation();
				if (prep>=80 && prep2>=80) 
				{
					name=name +nowcityWeather.getCity().getName() + "  ";
				}
			}
		}
		return name;
	}
	
	
	// We wander in the cityWeatherList (weeklyForecast's list) and find the lowest feel like temp.
	// So we decribe a "x" to compare weathers.
	// If feel like temp of a weather is smaller than "x", we make x equals to weather's feel like temp.
	// There can be more cities which have same feel like temp. So when we find smaller temp, we clear the list and we add the city to the list. 
	// If there exists cities which have same feel like temps, we add the cities to the list without clear method. 
	public ArrayX GetFlLowestName()
	{
		ArrayX cityArray = new ArrayX(1);
		double x = 100;
		double curent;
		
		for(int i=0;i<numberOfCityWeather;i++)
		{
			for(int j=0;j<7;j++)
			{
				CityWeather cityWheater =  (CityWeather) cityWeatherList[i][j];
				curent=cityWheater.getWeather().getFltemperature();
				
				if (curent < x)
				{
					cityArray.clear();
					x = curent;
					cityArray.add(cityWheater.getCity());
							
				}
				else if(x==curent)
				{
					cityArray.add(cityWheater.getCity());
				}
			}
		}
		return cityArray;
	}
	
	
	// We wander in the cityWeatherList (weeklyForecast's list) and find the lowest altitude and highest altitude cities.
	// and we add the weathers of the cities to list. Not cities, we add weathers of those cities !
	public void MeanTemp() 
	{
		double minAlt=10000;
		double maxAlt=-1000;
		ArrayX maxAltArray = new ArrayX(1);
		ArrayX minAltArray = new ArrayX(1);
		
		for(int i=0;i<numberOfCityWeather;i++)
		{
			for(int j=0;j<7;j++)
			{
				CityWeather cityWheater =  (CityWeather) cityWeatherList[i][j];
				
				if(cityWheater.getCity().getAltitude()<minAlt) 
				{
					minAltArray.clear();
					minAltArray.add(cityWheater);
					minAlt = cityWheater.getCity().getAltitude();
				}
				else if(cityWheater.getCity().getAltitude()==minAlt)
				{
					minAltArray.add(cityWheater);
				}
				
				if(cityWheater.getCity().getAltitude()>maxAlt) 
				{
					maxAltArray.clear();
					maxAltArray.add(cityWheater);
					maxAlt = cityWheater.getCity().getAltitude();
				}
				else if (cityWheater.getCity().getAltitude()==maxAlt) 
				{
					maxAltArray.add(cityWheater);
				}
			}
		}	
	
		// After finding lowest and highest altitude of cities, we wander in the minAltitudeList and maxAltitudeList and sum the temperature of weathers.
		// Afther that we calculate the mean temperatures and print them.
		double countMinAltArray=0;
		double countMaxAltArray=0;
		
		for(int i=0;i<minAltArray.urunSayisi;i++) 
		{
			countMinAltArray=countMinAltArray+((CityWeather)minAltArray.getList()[i]).getWeather().getTemperature();
		}
		for(int i=0;i<maxAltArray.urunSayisi;i++)
		{
			countMaxAltArray=countMaxAltArray+((CityWeather)maxAltArray.getList()[i]).getWeather().getTemperature();
		}
		System.out.println("4) "+countMaxAltArray/maxAltArray.urunSayisi + " , " + countMinAltArray/minAltArray.urunSayisi);
		
		
	}
	
	
	// We wander in the cityWeatherList (weeklyForecast's list) and find the lowest temp.
	// So we decribe a "x" to compare weathers.
	// If temp of a weather is smaller than "x", we make x equals to weather's temp.
	// There can be more cities which have same feel like temp. So when we find smaller temp, we clear the list and we add the city to the list. 
	// If there exists cities which have same temps, we add the cities to the list without clear method. 
	public ArrayX GetLowestName() 
	{
		ArrayX cityArray = new ArrayX(1);
		double x = 100;
		double curent;
		
		for(int i=0;i<numberOfCityWeather;i++)
		{
			for(int j=0;j<7;j++)
			{
				CityWeather cityWheater =  (CityWeather) cityWeatherList[i][j];
				curent=cityWheater.getWeather().getTemperature();
				
				if (curent < x) 
				{
					cityArray.clear();
					x = curent;
					cityArray.add(cityWheater.getCity());		
				}
				else if(x==curent)
				{
					cityArray.add(cityWheater.getCity());
				}	
			}
		}
		return cityArray;
	}

}
