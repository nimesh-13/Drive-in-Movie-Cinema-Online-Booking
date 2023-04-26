package com.microservices.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.model.MovieSchedual;
import com.microservices.services.MovieSchedualImpl;

@RestController
public class MovieSchedualController {
	
	@Autowired
	private MovieSchedualImpl service;
	
	@PostMapping("/post")
	public MovieSchedual addForDate(@RequestBody MovieSchedual movieSchedual) {
		return service.addForDate(movieSchedual);
	}
	
	@GetMapping("/get/{date}")
	public List<MovieSchedual> getByDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
		return service.getByDate(date);
	}
	
	@GetMapping("/get")
	public List<MovieSchedual> getAl(){
		return service.getAllMovieDate();
	}
	
	@DeleteMapping("/delete/{date}/{movieName}")
	public void removeByDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,@PathVariable String movieName) {
		service.removeMovieSchedule(date,movieName);
	}
	
	
	
}
