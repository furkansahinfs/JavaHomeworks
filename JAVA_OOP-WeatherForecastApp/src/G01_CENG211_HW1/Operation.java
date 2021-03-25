package G01_CENG211_HW1;

import java.text.ParseException;
import java.util.Scanner;

public class Operation {

	public void operation() {
		FileIO fileIO = new FileIO();
		ArrayX returnedArray = null;
		try {
			returnedArray = fileIO.readFile();
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}

		WeeklyForecast returnedWL = (WeeklyForecast) returnedArray.getList()[0];
		ArrayX returnedRL = (ArrayX) returnedArray.getList()[1];

		WeatherQuery weatherQuery = new WeatherQuery(returnedWL.getCityWeatherList(), returnedWL.numberOfCityWeather);

		System.out.println("-------------------");
		System.out.println("1)");
		weatherQuery.GetFlLowestName().yaz();
		System.out.println("------------");
		System.out.println("2)");
		weatherQuery.GetFindestName();
		System.out.println("------------");
		System.out.println("3) " + weatherQuery.getHighestAvgHumudity(returnedRL));
		System.out.println("------------");
		weatherQuery.MeanTemp();
		System.out.println("------------");
		System.out.println("5) " + weatherQuery.Rainy());
		System.out.println("------------");

		try {
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			System.out.println(
					"6) Enter a city name to view flightworthy days (You can see nothing if input is invalid or there isn't any day) :");
			String city = scan.nextLine();
			System.out.println(weatherQuery.DroneFlying(city));
		} finally {
		}
		System.out.println("------------");
	}
}
