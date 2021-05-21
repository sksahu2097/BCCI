package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Series;

@Repository
public interface SeriesRepository extends JpaRepository<Series, Long>, SeriesRepositoryCustom{

}
