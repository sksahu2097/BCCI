package com.example.demo.repository;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Match;

@Repository
@Transactional
public class SeriesRepositoryImpl implements SeriesRepositoryCustom{
	
	@Autowired
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Match> getMatchesBySeriesId(long seriesId) {
		Query query = entityManager.createQuery("Select match from Match match join fetch match.series series where series.series_id = "+seriesId);
		return (ArrayList<Match>) query.getResultList();
	}

}
