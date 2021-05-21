package com.example.demo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.demo.model.Series;
import com.example.demo.model.SeriesRequest;
import com.example.demo.service.SeriesService;

@Component
public class SeriesDaoImpl implements SeriesDao {	
	
	MatchDaoImpl matchDaoImpl = new MatchDaoImpl();
	private static final Logger logger = LoggerFactory.getLogger(SeriesService.class);
	@Override
	public String saveSeriesMatch(SeriesRequest series) {
		return null;
	}

	@Override
	public List<Series> findAll() throws Exception {
		logger.info("find all in series Dao IMpl");
		String sql = "select * from series order by  series_id asc";
		PreparedStatement preparedStatement = Connectivity.connection(sql);
		ResultSet resultSet  = preparedStatement.executeQuery();
		List<Series> list = new ArrayList<Series>();
		while(resultSet.next()) {
			Series series = new Series();
			series.setSeries_id(resultSet.getInt("series_id"));
			series.setSeries_name(resultSet.getString("series_name"));
			series.setStart_date(resultSet.getDate("start_date"));
			series.setEnd_date(resultSet.getDate("end_date"));
			list.add(series);
		}
		logger.info("Data is returnend from series daoimpl");
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<Series> getSeriesData(long series_id) throws Exception {
		logger.info("series Data by id in series Dao impl ");
		String sql = "select * from series where series_id ="+series_id;
		PreparedStatement preparedStatement = Connectivity.connection(sql);
		ResultSet resultSet  = preparedStatement.executeQuery();
		@SuppressWarnings("rawtypes")
		List list = new ArrayList<>();
		Series series = new Series();
		while(resultSet.next()) {
			series.setSeries_id(resultSet.getInt("series_id"));
			series.setSeries_name(resultSet.getString("series_name"));
			series.setStart_date(resultSet.getDate("start_date"));
			series.setEnd_date(resultSet.getDate("end_date"));
			list.add(series);
		}
		logger.info("series data found by series Data in Dao:  "+list);
		return list;
	}
	
	@Override
	public int updateSeries(long series_id, Series series) throws Exception {
		logger.info("update series method called in series dao");
		int cnt=0;
		cnt = matchDaoImpl.getMatchCount(series_id);
		logger.info("mathes attached with series id = "+cnt);
		if (cnt == 0) {
			String sql = "update series set series_name = ?, start_date = ?, end_date = ? where series_id = ?";
			PreparedStatement preparedStatement = Connectivity.connection(sql);
			preparedStatement.setString(1, series.getSeries_name());
			preparedStatement.setDate(2, series.getStart_date());
			preparedStatement.setDate(3, series.getEnd_date());
			preparedStatement.setInt(4, (int) series_id);
			cnt = preparedStatement.executeUpdate();
			logger.info("successfully updated series : in dao");
			return cnt;
		}
		logger.error("not updated since matches attached"+cnt);
		return cnt;
	}

	@Override
	public String save(Series series) throws Exception {
		logger.info("create a series ");
		String sql = "insert into series (series_name, start_date, end_date) values (?,?,?)) ";
		PreparedStatement preparedStatement = Connectivity.connection(sql);
		preparedStatement.setString(1, series.getSeries_name());
		preparedStatement.setDate(2, series.getStart_date());
		preparedStatement.setDate(3, series.getEnd_date());
		int row = preparedStatement.executeUpdate();
		if(row == 1) {
			logger.info("Successfully created series in Dao");
			return "Succesfull";
		}
		logger.error("not created series as error occurred in Dao ");
		return "Unsuccesfull";
	}

	@Override
	public int deleteSeries(long series_id) throws Exception {
		logger.info("delete series method called in series dao");
		int cnt=0;
		cnt = matchDaoImpl.getMatchCount(series_id);
		logger.info("mathes attached with series id = "+cnt);
		if (cnt == 0) {
			String sql = "delete from series where series_id = ?";
			PreparedStatement preparedStatement = Connectivity.connection(sql);
			preparedStatement.setInt(1, (int) series_id);
			cnt = preparedStatement.executeUpdate();
			logger.info("successfully series  deleted : in dao");
			return cnt;
		}
		logger.error("not deleted since matches attached");
		return cnt;
	}	
}