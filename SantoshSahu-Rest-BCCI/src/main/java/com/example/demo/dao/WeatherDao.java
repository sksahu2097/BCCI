package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Weather;

public interface WeatherDao {
	public List<Weather> getSeriesMatchData(long series_id) throws Exception;
}
