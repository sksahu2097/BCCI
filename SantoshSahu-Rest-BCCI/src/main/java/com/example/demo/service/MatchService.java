package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MatchDaoImpl;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Match;
import com.example.demo.model.Series;
import com.example.demo.repository.MatchRepository;
import com.example.demo.repository.SeriesRepository;

@Service("MatchService")
public class MatchService {
	
	@Autowired
	private SeriesRepository seriesrepository;
	
	@Autowired
	private MatchRepository matchrepository;
	
	private MatchDaoImpl matchDaoImpl = new MatchDaoImpl();
	private static final Logger logger = LoggerFactory.getLogger(SeriesService.class);
	
	public List<Match> createMatch(long series_id, Match match) throws ResourceNotFoundException {
		logger.info("create Match method in Match Service");
		Series series = seriesrepository.findById(series_id)
				.orElseThrow(() -> new ResourceNotFoundException("Series Not found : "+series_id));
		List<Match> list = new ArrayList<>();
		Match match2 = new Match();
		match2.setCity(match.getCity());
		match2.setDate(match.getDate());
		match2.setTeam1(match.getTeam1());
		match2.setTeam2(match.getTeam2());
		match2.setSeries(series);
		list.add(match2);	
		logger.info("match succesfully created in match Service");
		return matchrepository.saveAll(list);
	}
	
	public ResponseEntity<String> updateMatchById(long match_id, Match matchdetails) throws Exception {
		logger.info("update match method in match service");
		int status = matchDaoImpl.updateMatch(match_id, matchdetails);
		if (status == 1) {
			logger.info("update match by id successfully in match service");
			return ResponseEntity.ok().body("Successsfull");
		}
		logger.error("some error occured so can't update");
		return ResponseEntity.status(404).body("Can't update as match are their"); 
	}
	
	public ResponseEntity<String> deleteMatchById(long match_id) throws Exception {
		logger.info("delete match by id method in match service");
		int status = matchDaoImpl.deleteMatch(match_id);
		if (status == 1) {
			logger.info("Succesfully deleted match");
			return ResponseEntity.ok().body("Successsfull");
		}
		logger.error("some error occurred so can't delete");
		return ResponseEntity.status(404).body("Can't delete as match_id is not valid");
	}
}
