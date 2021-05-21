package com.example.demo.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.json.ParseException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dao.WeatherDaoImpl;
import com.example.demo.model.Weather;

@Service("WeatherService")
public class WeatherService {

	@Autowired
	private RestTemplate restTemplate;
	
	private static final Logger logger = LoggerFactory.getLogger(SeriesService.class);
	private WeatherDaoImpl weatherDaoImpl = new WeatherDaoImpl();
	
	public List<Weather> predictWeather(long series_id) throws Exception {
		List<Weather> list = weatherDaoImpl.getSeriesMatchData(series_id);
		Iterator<Weather> iterator = list.iterator();
	      while (iterator.hasNext()) {
	    	  Weather weather = iterator.next();
	    	  weather.setPredictionData(getWeatherData(weather.getCity(),weather.getMatch_date()));
	      }
	      return list;
	}
	
	public Map<String, Map<String, Float>> getWeatherData(String CityName,Date match_date) throws Exception {
		String apikey = "90e62cf6e9e34eb8f282588c04c1c7aa";
		String url = "http://api.openweathermap.org/data/2.5/forecast?units=metric&appid="
		+apikey+"&q="+CityName.toLowerCase();
		System.out.println(url);
		String weatherData = restTemplate.getForObject(url, String.class);
		JSONObject jsonObj = new JSONObject(weatherData.toString());
		JSONArray jsonArray = (JSONArray) jsonObj.get("list");
		//get the no of data
		int cnt = (int)(jsonObj.getInt("cnt"));
		System.out.println(cnt);
		java.util.Date currentDate = new java.util.Date();
		@SuppressWarnings("deprecation")
		int hour = currentDate.getHours();
		System.out.println("Hours  = "+hour);
		int start_hour = hour/3;
		System.out.println(start_hour);
		if (start_hour == 0) {
			start_hour = 8;
		}
		start_hour = 8 - start_hour;
		System.out.println(start_hour);
		start_hour +=1;
		System.out.println(start_hour);
		if (((hour+1) % 3 == 0)) {
			start_hour -= 1;
			System.out.println("hey");
		}
		int end_date = 8 - start_hour;
		System.out.println("start_hours  = "+start_hour);
		System.out.println("end_hours  = "+end_date);
		//data setting code for prediction
		String weatherDataCategory [] = new String[5];
		float weatherDatapred [] = new float[5];
		String weathericon[] = new String[5];
		String iconno = "";
		String category ="" ;
		float pred = 0;
		int j=0,z=1;
		if(start_hour == 0) {
			z=0;
		}
		for (int i=0;i<start_hour;i++) {
			JSONObject data = (JSONObject) jsonArray.get(i);
			JSONArray jsonweather = (JSONArray) data.get("weather");
			String datetime[] = data.getString("dt_txt").split(" ");
			Date date = Date.valueOf(datetime[0]);
			JSONObject weatherCat = (JSONObject) jsonweather.get(0);
			iconno = weatherCat.getString("icon");
			String weatherCategory = weatherCat.getString("main");if(data.has(weatherCategory.toLowerCase())) {
				JSONObject per = (JSONObject) data.get(weatherCategory.toLowerCase());
				String [] keys = JSONObject.getNames(per);
				float percentage = per.getFloat(keys[0]);
				if(percentage < 1) {
					percentage *=100;
				}
				pred +=percentage;
				category=weatherCategory;
			}
		}
		pred = (pred / start_hour);
		weatherDataCategory[0] = category;
		weatherDatapred[0] = pred;
		weathericon[0] = iconno;
		System.out.println(weatherDataCategory[0] +" percentage = "+pred);
		pred=0;
		for (int i=start_hour;i<cnt-end_date;i++,j++) {
			JSONObject data = (JSONObject) jsonArray.get(i);
			String datetime[] = data.getString("dt_txt").split(" ");
			Date date = Date.valueOf(datetime[0]);
			JSONArray jsonweather = (JSONArray) data.get("weather");
			JSONObject weatherCat = (JSONObject) jsonweather.get(0);
			String weatherCategory = weatherCat.getString("main");
			iconno = weatherCat.getString("icon");
			logger.info("icon no = "+iconno);
			if(data.has(weatherCategory.toLowerCase())) {
				JSONObject per = (JSONObject) data.get(weatherCategory.toLowerCase());
				String [] keys = JSONObject.getNames(per);
				float percentage = per.getFloat(keys[0]);
				if (percentage < 1) {
					percentage *=100;
				}
				pred +=percentage;
				category=weatherCategory;
				if (j == 7) {
					pred = (pred / 8 );
					System.out.println(weatherCategory +" percentage = "+pred+" "+" date = "+date );
					weatherDataCategory[z] = category;
					weatherDatapred[z] = pred;
					weathericon[z] = iconno;
					z++;
					j = 0;	
				}	
			}	
			if(j > 7) {
				j = (j-7);
			}
		}
		pred=0;
		for(int i=cnt-end_date;i<cnt;i++) {
			JSONObject data = (JSONObject) jsonArray.get(i);
			//String[] jsoncat = JSONObject.getNames(data);
			//System.out.println("my new aRRay  "+jsoncat[3]);
			JSONArray jsonweather = (JSONArray) data.get("weather");
			String datetime[] = data.getString("dt_txt").split(" ");
			Date date = Date.valueOf(datetime[0]);
			JSONObject weatherCat = (JSONObject) jsonweather.get(0);
			String weatherCategory = weatherCat.getString("main");
			iconno = weatherCat.getString("icon");
			if(data.has(weatherCategory.toLowerCase())) {
				JSONObject per = (JSONObject) data.get(weatherCategory.toLowerCase());
				String [] keys = JSONObject.getNames(per);
				float percentage = per.getFloat(keys[0]);
			
				if(percentage < 1) {
					percentage *=100;
				}
			//System.out.println(weatherCategory +" percentage = "+percentage+" "+" date = "+date );
				pred +=percentage;
				category=weatherCategory;
			}
		}
		pred = (pred / end_date );
		weatherDataCategory[4] = category;
		weatherDatapred[4] = pred;
		weathericon[4] = iconno;
		System.out.println(weatherDataCategory[4] +" percentage = "+pred );
		
		for(int i=0;i<5;i++) {
			System.out.println("weather category : "+i+"  "+weatherDataCategory[i]+" weather prediction : "+weatherDatapred[i]+" weather icon : "+weathericon[i]);
		}
		//System.out.println(weatherDataCategory);
		//System.out.println(weatherDatapred);
		return processData(weatherDataCategory, weatherDatapred, match_date, weathericon);
		
	}
	
	public Map<String, Map<String, Float>> processData(String weatherDataCategory[], float weatherDatapred[], Date match_date, String weathericon[] ) throws ParseException {
		Map<String,Float> predictionData = new HashMap<String, Float>();
		Map<String,Map<String,Float>> final_data = new HashMap<String, Map<String,Float>>();
		int flag = 0;//for checking if date matches or not
		LocalDate curr = LocalDate.now();
		java.util.Date currDate = java.sql.Date.valueOf(curr);
		//if(month == match_month) {
			
			for(int i=0;i<5;i++) {
				if(currDate.toString().equals(match_date.toString())) {
					flag++;
					predictionData.put(weatherDataCategory[i], weatherDatapred[i]);
					final_data.put(weathericon[i], predictionData);
					System.out.println("Date matched : "+currDate);
				}
				curr = curr.plusDays(1);
				currDate = java.sql.Date.valueOf(curr);
			}
		/*}else {
			predictionData.put("Bhagwan Bharosa", (float) 100);
			final_data.put("01d", predictionData);
		}*/
		if (flag == 0) {
			predictionData.put("Bhagwan Bharosa", (float) 100);
			final_data.put("01d", predictionData);
		}
		System.out.println(final_data);
		
		return final_data;
		//return predictionData;
	}
	
}
