package com.example.demo.model;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "series")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Series implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "series_id")
	long series_id;
	
	@Column(name = "series_name")
	String series_name;
	
	@Column(name = "start_date")
	java.sql.Date start_date;
	
	@Column(name = "end_date")
	java.sql.Date end_date;
	

	public Series() {
		super();
	}	

	
	
	public Series(long series_id, String series_name, Date start_date, Date end_date) {
		super();
		this.series_id = series_id;
		this.series_name = series_name;
		this.start_date = start_date;
		this.end_date = end_date;
	}



	public long getSeries_id() {
		return series_id;
	}



	public void setSeries_id(long series_id) {
		this.series_id = series_id;
	}



	public String getSeries_name() {
		return series_name;
	}

	public void setSeries_name(String series_name) {
		this.series_name = series_name;
	}

	public java.sql.Date getStart_date() {
		return start_date;
	}

	public void setStart_date(java.sql.Date start_date) {
		this.start_date = start_date;
	}

	public java.sql.Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(java.sql.Date end_date) {
		this.end_date = end_date;
	}




	@Override
	public String toString() {
		return "Series [series_id=" + series_id + ", series_name=" + series_name + ", start_date=" + start_date
				+ ", end_date=" + end_date + ",  ]";
	}

	
	
	
}
