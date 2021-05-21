package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Match;
import com.example.demo.model.Series;
import com.example.demo.model.SeriesRequest;
import com.example.demo.model.Weather;
import com.example.demo.repository.MatchRepository;
import com.example.demo.service.MatchService;
import com.example.demo.service.SeriesService;
import com.example.demo.service.WeatherService;

@RestController
@CrossOrigin(allowCredentials = "true")
@RequestMapping("/winsoft/BCCI")
public class BCCIController {
	@Autowired
	private MatchRepository matchrepository;
	@Autowired
	SeriesService seriesService;
	
	@Autowired
	MatchService matchService;
	
	@Autowired
	WeatherService weatherService;
	private static final Logger logger = LoggerFactory.getLogger(BCCIController.class);
	//getting all series
	@GetMapping("/series")
	public ResponseEntity<List<Series>> getAllSeries() throws Exception {
		logger.info("getAllSeries called");
		return seriesService.findAllSeries();
	}
	
	//getting all the match
	@GetMapping("/match")
	public List<Match> getAllMatch() {
		logger.info("get all match called");
		return matchrepository.findAll();
	}
	
	//specific series
	@GetMapping("/series/{series_id}")
	public ResponseEntity<List<Series>> getSeriesById(@PathVariable(value = "series_id") long series_id) throws Exception {
		//Series series = seriesrepository.findById(series_id)
				//.orElseThrow(() -> new ResourceNotFoundException("Series Not found : "+series_id));;
		//return ResponseEntity.ok().body(series);
		logger.info("get series by id is called");
		return seriesService.getSeriesDataById(series_id);
	}
	
	//Get all matches from specific series id
	@GetMapping("/matches/series/{seriesId}")
	public ResponseEntity<List<Match>> getMatchesBySeriesId(@PathVariable(value = "seriesId") long series_id) throws Exception {
		logger.info("get mathes by series id called");
		List<Match> list = seriesService.getMatchesBySeriesId(series_id);
		if (list.size() == 0) {
			logger.error("Not found series : "+series_id);
			return ResponseEntity.status(404).body(list);
		}
		return ResponseEntity.status(200).body(list);		
	}
	
	//Get specific match by ID
	@GetMapping("/match/{match_id}")
	public ResponseEntity<List<Match>> getMatchById(@PathVariable(value = "match_id") long match_id) throws Exception {
		Match match = matchrepository.findById(match_id)
				.orElseThrow(() -> new ResourceNotFoundException("Match Not found : "+match_id));
		List<Match> list = new ArrayList<>();
		list.add(match);
		return ResponseEntity.ok().body(list);
	}
	
	
	//creating a series
	@PostMapping("/series")
	public ResponseEntity<List<Match>> createSeries(@Valid @RequestBody SeriesRequest series) throws Exception {
		logger.info("create series is called");
		List<Match> list = seriesService.createSeriesMatch(series);
		return ResponseEntity.status(200).body(list);
	}
	
	//create match
	@PostMapping("/match/{series_id}")
	public ResponseEntity<List<Match>> createMatch(@PathVariable(value = "series_id") long series_id, @RequestBody Match match) throws ResourceNotFoundException {
		logger.info("create Match is called");
		List<Match> list = matchService.createMatch(series_id, match);
		return ResponseEntity.ok().body(list);
	}
	
	//series update
	@PutMapping("/series/{series_id}")
	public ResponseEntity<String> updateSeries(@PathVariable(value = "series_id") long series_id, @RequestBody Series seriesdetails) throws Exception {
		logger.info("update series by id called");
		return seriesService.updateSeriesById(series_id, seriesdetails);	
	}
	
	//match update
	@PutMapping("/match/{match_id}")
	public ResponseEntity<String> updateMatch(@PathVariable(value = "match_id") long match_id, @RequestBody Match match) throws Exception {
		logger.info("update match by id is called");
		return matchService.updateMatchById(match_id, match);	
	}
	
	//delete a series
	@DeleteMapping("/series/{series_id}")
	public ResponseEntity<String> deleteSeries(@PathVariable(value = "series_id") long series_id) throws Exception {
		logger.info("delete series by id called");
		return seriesService.deleteSeriesById(series_id);
	}
	
	//delete a match
	@DeleteMapping("/match/{match_id}")
	public ResponseEntity<String> deleteMatch(@PathVariable(value = "match_id") long match_id) throws Exception {
		logger.info("delete match by match id called");
		return matchService.deleteMatchById(match_id);
	}
	
	@GetMapping("/weather/{series_id}")
	public ResponseEntity<List<Weather>> getWeatherData(@PathVariable(value="series_id") long series_id) throws Exception{
		//weatherService.predictWeather(series_id);
		return ResponseEntity.ok().body(weatherService.predictWeather(series_id));
	}
}
