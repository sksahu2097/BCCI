package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.SeriesDao;
import com.example.demo.dao.SeriesDaoImpl;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Match;
import com.example.demo.model.Series;
import com.example.demo.model.SeriesRequest;
import com.example.demo.repository.MatchRepository;
import com.example.demo.repository.SeriesRepository;

@Service("SeriesService")
public class SeriesService {
	
	@Autowired
	private SeriesRepository seriesrepository;
	
	@Autowired
	private MatchRepository matchrepository;
	
	/*@Autowired
	@Qualifier("SeriesDaoImpl")
	private SeriesDao seriesDao;*/
	
	private SeriesDao seriesDao = new SeriesDaoImpl();
	private static final Logger logger = LoggerFactory.getLogger(SeriesService.class);
	
	public List<Match> createSeriesMatch(SeriesRequest series) {
		logger.info("createSeries method started");
		Series series2 = new Series();
		series2.setEnd_date(series.getEnd_date());
		series2.setStart_date(series.getStart_date());
		series2.setSeries_name(series.getSeries_name());
		seriesrepository.save(series2);
		logger.info("Series created with this data : "+series2.toString());
		List<Match> list = new ArrayList<>();
		for(Match match : series.getMatches()) {
			Match match2 = new Match();
			match2.setCity(match.getCity());
			match2.setDate(match.getDate());
			match2.setTeam1(match.getTeam1());
			match2.setTeam2(match.getTeam2());
			match2.setSeries(series2);
			list.add(match2);			
		}
		logger.info("match created with this data : "+list);
		return matchrepository.saveAll(list);	
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<List<Series>> findAllSeries() throws Exception {
		//System.out.println("series Data = "+seriesrepository.findAll());
		//return ResponseEntity.ok().body(seriesrepository.findAll());
		logger.info("find all series in Series Service");
		return ResponseEntity.ok().body(seriesDao.findAll());	
	}
	
	public ArrayList<Match> getMatchesBySeriesId(long seriesId) {
		logger.info("get Match by series id");
		return (ArrayList<Match>) seriesrepository.getMatchesBySeriesId(seriesId);
	}
	
	@SuppressWarnings("unused")
	public ResponseEntity<String> deleteSeriesById(long series_id) throws Exception {
		Series series = seriesrepository.findById(series_id)
				.orElseThrow(() -> new ResourceNotFoundException("Series Not Found : "+series_id));
		logger.info("deleted series by id");
		int status = seriesDao.deleteSeries(series_id);
		if(status == 0) {
			logger.info("Success in deletion of series service");
			return ResponseEntity.ok().body("Successsfull");
		}
		logger.error("can't delete as matches are their");
		return ResponseEntity.ok().body("Can't delete as match are their"); 
	}
	
	public ResponseEntity<String> updateSeriesById(long series_id, Series seriesdetails) throws Exception {
		//Series series = seriesrepository.findById(series_id)
				//.orElseThrow(() -> new ResourceNotFoundException("Series Not found : "+series_id));
		//series.setSeries_name(seriesdetails.getSeries_name());
		//series.setStart_date(seriesdetails.getStart_date());
		//series.setEnd_date(seriesdetails.getEnd_date());
		//seriesrepository.save(series);
		logger.info("update series by id in series Service");
		int status = seriesDao.updateSeries(series_id, seriesdetails);
		if(status == 1) {
			logger.info("Success in update in series service");
			return ResponseEntity.ok().body("Successsfull");
		}
		logger.error("cant update as matches are their");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Can't update as match are their"); 
	}
	
	public ResponseEntity<List<Series>> getSeriesDataById(long series_id) throws Exception {
		
		logger.info("get Series by data method in series service");
		List<Series> list = seriesDao.getSeriesData(series_id);
		if(list.size() == 0) {
			logger.error("Series not found in series service");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(list);
		}
		logger.info("Series successfully found Series Service");
		return ResponseEntity.ok().body(list);
	}	
}
