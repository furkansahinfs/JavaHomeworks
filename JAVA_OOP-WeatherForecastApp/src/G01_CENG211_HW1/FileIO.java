package G01_CENG211_HW1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.Date; 
public class FileIO {
	
	public static ArrayX readFile() throws ParseException {
		
		//We create our variables
		FileReader dosyaOkuyucu1;
		FileReader dosyaOkuyucu2;
		FileReader dosyaOkuyucu3;
		BufferedReader okuyucu1;
		BufferedReader okuyucu2;
		BufferedReader okuyucu3;
		WeeklyForecast cityWeatherListClass = null;
		ArrayX returnedFileIO = new ArrayX(1);
		
		
		try 
		{
			dosyaOkuyucu1 = new FileReader("C:\\Users\\Furkan\\Desktop\\CENG211_HW1_Cities.csv");
			okuyucu1 = new BufferedReader(dosyaOkuyucu1);
			
			ArrayX regionList = new ArrayX(2); // regionList holds the regions.
			int current = 0;
			Region region = null; 
			String satir1 = okuyucu1.readLine();
			
			

			while(satir1!=null) 
			{
				// We take the column from the City File and split it. According to the region of cities we create region objects and add them to the regionList. 
				// Also we create a city list which holds the cities of a region, and we use city list in the constructor of the region object.
				// We control that if regionID equals to the current+1, we create a region object. If regionID is not equal we understand that that region object already exits.
				String[] strs1 = satir1.split(",");
				if (Integer.parseInt(strs1[2])==current+1) 
				{
					current = current+1;
					ArrayX cityList = new ArrayX(2);
					region = new Region(Integer.parseInt(strs1[2]),strs1[3],cityList);
					regionList.add(region);
				}
				satir1=okuyucu1.readLine();
			}
			
			
			okuyucu1.close();
			
			dosyaOkuyucu2 = new FileReader("C:\\Users\\Furkan\\Desktop\\CENG211_HW1_Cities.csv");
			okuyucu2 = new BufferedReader(dosyaOkuyucu2);
			
			String satir2 = okuyucu2.readLine();
			
			// We take the column from the City File again and split it. 
			// If the region of the city is equal to a regionList member of regionList, we create the city object according to the given info using constructor 
			// and we add the city to its region's list.
			while(satir2 != null)
			{
				String[] strs2 = satir2.split(",");
				for(int i=0;i<regionList.urunSayisi;i++) // regionList holds the objects of regions and regions hold their citylists.
				{
					if(Integer.parseInt(strs2[2]) == ((Region) regionList.getList()[i]).getId())
					{
						City city = new City(Integer.parseInt(strs2[0]),strs2[1],((Region) regionList.getList()[i]),Integer.parseInt(strs2[4]));
						((Region) regionList.getList()[i]).setCitytoCityList(city); // We add the city to the citylist of region of the city.
					}
				}
				satir2 = okuyucu2.readLine();
			}
			
			
			dosyaOkuyucu3 = new FileReader("C:\\Users\\Furkan\\Desktop\\CENG211_HW1_WeeklyForecast.csv");
			okuyucu3 = new BufferedReader(dosyaOkuyucu3);
			
			WeeklyForecast cityWeatherList = new WeeklyForecast(20,7); // We create a weeklyforecast object to hold all the cityWeather objects.
			String satir3 = okuyucu3.readLine();
			
			// We take the column from the Forecast Fileand split it. 
			// We create a weather object according to given info from the file
			// and we wander the cityLists of regions to find the city which its plateNo equals to plateNo in the column
			// we create a cityWeather object and add the city,weather,date objects to its constructor and add the object to the cityWeatherList(weeklyForecast's list).
			while(satir3!=null) 
			{
				String[] strs3 = satir3.split(",");
				Weather weather = new Weather(Integer.parseInt(strs3[2]),Integer.parseInt(strs3[3]),Integer.parseInt(strs3[4]),Integer.parseInt(strs3[5]),Integer.parseInt(strs3[6]),strs3[7]);
				String sDate1=strs3[1];
			    Date date1=new SimpleDateFormat("dd.MM.yyyy").parse(sDate1); 
			    
			    for(int i=0;i<regionList.urunSayisi;i++) 
			    {
			    	for(int j=0;j<((Region)regionList.getList()[i]).getCityList().urunSayisi;j++) 
			    	{
			    		if(Integer.parseInt(strs3[0]) == ((City) ((Region)regionList.getList()[i]).getCityList().getList()[j]).getPlateNo()) 
			    		{
			    			CityWeather cityWeather = new CityWeather(((City) ((Region)regionList.getList()[i]).getCityList().getList()[j]),weather,date1);
			    			cityWeatherList.add(cityWeather);
			    		}
			    	}		
			    }
				satir3=okuyucu3.readLine();
			}
			
			//We add the regionList and cityWeatherList(weeklyForecast's list) to another list and return that list to access the methods in the forecast app.
			returnedFileIO.add(cityWeatherList);
			returnedFileIO.add(regionList);
			
		}
		
		catch(FileNotFoundException ex)
		{
			 System.out.println("File is not found.");
		}
		catch(IOException ex)
		{
			 System.out.println("Error exception.");
		}
		
		return returnedFileIO;	
	}
	
}
	
	

