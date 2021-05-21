package com.example.demo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Weather;

public class WeatherDaoImpl implements WeatherDao{

	@Override
	public List<Weather> getSeriesMatchData(long series_id) throws Exception {
		String sql = "select series_name,match.* from match"
				+ " inner join series on match.series_id = series.series_id "
				+ "and series.series_id=?";
		PreparedStatement preparedStatement = Connectivity.connection(sql);
		preparedStatement.setInt(1,(int) series_id);
		ResultSet resultSet  = preparedStatement.executeQuery();
		List<Weather> list = new ArrayList<>();
		while(resultSet.next()) {
			Weather weather = new Weather();
			weather.setMatch_id(resultSet.getInt("match_id"));
			weather.setCity(resultSet.getString("city"));
			weather.setMatch_date(resultSet.getDate("match_date"));
			weather.setSeries_name(resultSet.getString("series_name"));
			weather.setTeam1(resultSet.getString("team1"));
			weather.setTeam2(resultSet.getString("team2"));
			weather.setSeries_id(resultSet.getInt("series_id"));
			list.add(weather);
		}
		return list;
	}

}
