package com.microservices.services;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;



import com.microservices.model.MovieSchedual;


public interface MovieSchedualService {
	
	//add
	public MovieSchedual addForDate(MovieSchedual movieSchedual);
	
	
	//Update
	
//	public MovieSchedual updateForDate(Date date,String start_time);
	
	
	//get
	public List<MovieSchedual> getAllMovieDate();
	
	
	//getbyId     
	public List<MovieSchedual> getByDate(Date date);
	
	
	//delete
    public void removeMovieSchedule(Date date,String movieName);
	

	



	

}
