package com.prajwal.microservice.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prajwal.microservice.entity.MovieSlot;
import com.prajwal.microservice.service.MovieSlotAvailableService;

@RestController
public class MovieSlotAvailableController 
{
	@Autowired
	private MovieSlotAvailableService movieSlotAvailableService;
	
	@GetMapping("/get/{movieName}/{movieDate}/{movieSchedule}")
	public ArrayList<Integer> findBookedParkingSlotByMovieName(@PathVariable String movieName ,@PathVariable String movieDate, @PathVariable String movieSchedule)
	{
		return movieSlotAvailableService.findByMovieNameAndMovieDateAndMovieSchedule(movieName,movieDate,movieSchedule);
	}
	

	@PostMapping("/bookMovieSlot")
	public boolean insertData(@RequestBody MovieSlot movieSlot)
	{
		return movieSlotAvailableService.insertData(movieSlot);
	}
	


}
