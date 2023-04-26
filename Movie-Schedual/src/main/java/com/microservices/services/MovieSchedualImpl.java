package com.microservices.services;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.model.MovieSchedual;
import com.microservices.repository.MovieSchedualRepo;

@Service
public class MovieSchedualImpl implements MovieSchedualService {
	
	@Autowired
	private MovieSchedualRepo repo;

	@Override
	public MovieSchedual addForDate(MovieSchedual movieSchedual) {
		return repo.save(movieSchedual);

	}

	@Override
	public List<MovieSchedual> getAllMovieDate() {
		return repo.findAll();
	}



	@Override
	public List<MovieSchedual> getByDate(Date date) {
	    java.sql.Date startDate = new java.sql.Date(date.getTime());
	    
	    Calendar cal = Calendar.getInstance(); 
	    cal.setTime(date);            
	    cal.add(Calendar.HOUR_OF_DAY, 24);  
	    Date date2 = cal.getTime(); 
	    java.sql.Date endDate = new java.sql.Date(date2.getTime());
	    
		return repo.getByDate(startDate,endDate);
	}



	@Override
	public void removeMovieSchedule(Date date, String movieName) {
		java.sql.Date startDate = new java.sql.Date(date.getTime());
	    
	    Calendar cal = Calendar.getInstance(); 
	    cal.setTime(date);            
	    cal.add(Calendar.HOUR_OF_DAY, 24);  
	    Date date2 = cal.getTime(); 
	    java.sql.Date endDate = new java.sql.Date(date2.getTime());
	    
		List<MovieSchedual> moviename = repo.getByDate(startDate, endDate);
		
		for(MovieSchedual m: moviename) {
			if(m.getMovieName().equalsIgnoreCase(movieName)) {
				MovieSchedual getMovie =  repo.deleteByMovieName(movieName);
				int id = getMovie.getSchedualId();
				repo.deleteById(id);
			}
		}
	}

}



	

