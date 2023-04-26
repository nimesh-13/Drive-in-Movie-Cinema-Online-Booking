package com.prajwal.microservice.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prajwal.microservice.entity.MovieSlot;

@Repository
public interface MovieSlotAvailableRepo extends JpaRepository<MovieSlot, Integer>
{

	MovieSlot findBookedParkingSlotByMovieName(String movieName);

	ArrayList<MovieSlot> findByMovieNameAndMovieDateAndMovieSchedule(String movieName, String movieDate, String movieSchedule);
	
}
