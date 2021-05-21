package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Match;


public interface SeriesRepositoryCustom {
	
	List<Match> getMatchesBySeriesId(long seriesId);

}
