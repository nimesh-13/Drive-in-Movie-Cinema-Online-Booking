package com.microservices.repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.microservices.model.MovieSchedual;



@Repository
public interface MovieSchedualRepo extends JpaRepository<MovieSchedual, Integer>{
	
 
	
	//Update
//    @Query(value = "UPDATE MovieSchedual SET start_time = :start_time WHERE date = :date")
//	public MovieSchedual updateForDate(Date date,String start_time);
	
	
	
	
	//getbyId     
	@Query(value = "select a from MovieSchedual a where date BETWEEN :startDate AND :endDate")
	public List<MovieSchedual> getByDate(Date startDate,Date endDate);
	
	
//	public void removeMovieSchedule(Date date , String movieName);
	@Query(value = "select a from MovieSchedual a where a.movieName =:movieName")
	public MovieSchedual deleteByMovieName(String movieName);
	



	
}
