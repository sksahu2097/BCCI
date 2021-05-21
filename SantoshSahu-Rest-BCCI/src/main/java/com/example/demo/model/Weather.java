package com.example.demo.model;

import java.sql.Date;
import java.util.Map;

public class Weather {
	
	private String series_name;
	private String city;
	private long match_id;
	private String team1;
	private String team2;
	private Date match_date;
	private long series_id;
	private  Map<String, Map<String, Float>> predictionData;
	
	public Weather() {
		super();
	}
	
	public Weather(String series_name, String city, long match_id, String team1, String team2, Date match_date,
			long series_id, Map<String, Map<String, Float>> predictionData) {
		super();
		this.series_name = series_name;
		this.city = city;
		this.match_id = match_id;
		this.team1 = team1;
		this.team2 = team2;
		this.match_date = match_date;
		this.series_id = series_id;
		this.predictionData = predictionData;
	}
	public String getSeries_name() {
		return series_name;
	}
	public void setSeries_name(String series_name) {
		this.series_name = series_name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long getMatch_id() {
		return match_id;
	}
	public void setMatch_id(long match_id) {
		this.match_id = match_id;
	}
	public String getTeam1() {
		return team1;
	}
	public void setTeam1(String team1) {
		this.team1 = team1;
	}
	public String getTeam2() {
		return team2;
	}
	public void setTeam2(String team2) {
		this.team2 = team2;
	}
	public Date getMatch_date() {
		return match_date;
	}
	public void setMatch_date(Date match_date) {
		this.match_date = match_date;
	}
	public long getSeries_id() {
		return series_id;
	}
	public void setSeries_id(long series_id) {
		this.series_id = series_id;
	}
	public Map<String, Map<String, Float>> getPredictionData() {
		return predictionData;
	}
	public void setPredictionData(Map<String, Map<String, Float>> map) {
		this.predictionData = map;
	}


	@Override
	public String toString() {
		return "Weather [series_name=" + series_name + ", city=" + city + ", match_id=" + match_id + ", team1=" + team1
				+ ", team2=" + team2 + ", match_date=" + match_date + ", series_id=" + series_id + ", predictionData="
				+ predictionData + "]";
	}
	
	
	
	
	
	
}
