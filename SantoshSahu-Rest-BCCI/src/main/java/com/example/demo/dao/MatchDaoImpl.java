package com.example.demo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.demo.controller.BCCIController;
import com.example.demo.model.Match;

@Component
public class MatchDaoImpl implements MatchDao {
	private static final Logger logger = LoggerFactory.getLogger(BCCIController.class);
	@Override
	public int getMatchCount(long series_id) throws Exception {
		logger.info("Match count method in macth dao");
		String sql = "select count(match_id) from match where series_id ="+series_id;
		PreparedStatement preparedStatement = Connectivity.connection(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		resultSet.next();
		logger.info("Match count returned succesfully from match dao");
		return resultSet.getInt("count");
	}

	@Override
	public int save(Match match, long series_id) throws Exception {
		logger.info("Save Match method in matchh Dao");
		String sql = "insert into match (team1, team2, city,match_date, series_id ) values (?,?,?,?)";
		PreparedStatement preparedStatement = Connectivity.connection(sql);
		preparedStatement.setString(1, match.getTeam1());
		preparedStatement.setString(2, match.getTeam2());
		preparedStatement.setString(3, match.getCity());
		preparedStatement.setDate(4, match.getDate());
		preparedStatement.setInt(5, (int)series_id);
		
		logger.info("Match saved succesfully in Match Dao");
		return 0;
	}

	@Override
	public int updateMatch(long match_id, Match match) throws Exception {
		int status=0;
		logger.info("update Match method in Match Dao");
		String sql = "update match set team1 = ?, team2 = ?, match_date = ?, city= ?  where match_id = ?";
		PreparedStatement preparedStatement = Connectivity.connection(sql);
		preparedStatement.setString(1, match.getTeam1());
		preparedStatement.setString(2, match.getTeam2());
		preparedStatement.setDate(3, match.getDate());
		preparedStatement.setString(4, match.getCity());
		preparedStatement.setInt(5,(int) match_id);
		status = preparedStatement.executeUpdate();
		logger.info("update match status in Match Dao : "+status);
		return status; //if status = 0 then their is a problem.
	}
	
	@Override
	public int deleteMatch(long match_id) throws Exception {
		int status = 0;
		logger.info("delete match method");
		String sql = "delete from match where match_id=?";
		PreparedStatement preparedStatement = Connectivity.connection(sql);
		preparedStatement.setInt(1, (int) match_id);
		status = preparedStatement.executeUpdate();
		logger.info("delete status returned from match dao");
		return status;
	}

	@Override
	public List<Match> getMatchDataBySeriesId(long series_id) throws Exception {
		logger.info("in Match Dao getMatch Data By Series Id");
		String sql = "select * from match where series_id = ?";
		PreparedStatement preparedStatement = Connectivity.connection(sql);
		preparedStatement.setInt(1,	(int) series_id);
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			Match match = new Match();
			match.setMatch_id((long)resultSet.getInt("match_id"));
		}
		return null;
	}
	
}
