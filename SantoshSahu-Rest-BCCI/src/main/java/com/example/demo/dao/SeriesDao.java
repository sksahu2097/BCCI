package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Series;
import com.example.demo.model.SeriesRequest;

public interface SeriesDao {
	public String saveSeriesMatch(SeriesRequest series);
	@SuppressWarnings("rawtypes")
	public List findAll() throws Exception; 
	public List<Series> getSeriesData(long series_id) throws Exception;
	public int updateSeries(long series_id,Series seriesdetails) throws Exception;
	public int deleteSeries(long series_id) throws Exception;
	public String save(Series series) throws Exception;
}
