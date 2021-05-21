package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Match;

public interface MatchDao {
	public int getMatchCount(long series_id) throws Exception;
	public int save(Match match, long series_id) throws Exception;
	public int updateMatch(long match_id,Match match) throws Exception;
	public int deleteMatch(long match_id) throws Exception;
	public List<Match> getMatchDataBySeriesId(long series_id) throws Exception;
}
