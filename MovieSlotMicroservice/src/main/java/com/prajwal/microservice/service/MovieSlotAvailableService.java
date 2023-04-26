package com.prajwal.microservice.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prajwal.microservice.entity.MovieSlot;
import com.prajwal.microservice.repository.MovieSlotAvailableRepo;

@Service
public class MovieSlotAvailableService 
{
	@Autowired
	private MovieSlotAvailableRepo movieSlotAvailableRepo;

	public boolean insertData(MovieSlot movieSlot) 
	{
		boolean flag =  false;
		if(movieSlotAvailableRepo.save(movieSlot) != null)
		{
			flag = true;
		}
		return flag;
	}

	public ArrayList<Integer> findByMovieNameAndMovieDateAndMovieSchedule(String movieName, String movieDate, String movieSchedule) 
	{
		ArrayList<MovieSlot> movieArrayList =  movieSlotAvailableRepo.findByMovieNameAndMovieDateAndMovieSchedule(movieName,movieDate,movieSchedule);
		
		ArrayList<Integer> arrayBookedSlot = new ArrayList<>();
		
		//getting booked seat from database
		for(MovieSlot BookedParkingSlot: movieArrayList)
		{
			
			arrayBookedSlot.add(BookedParkingSlot.getBookedParkingSlot());
			
		}
		
		// total seats
		ArrayList<Integer> vacantParkingSlot = new ArrayList<>();
		for(int i=1;i<61;i++ )
		{
			vacantParkingSlot.add(i);
		}
		
		//finding vacant seats
		for(Integer x: arrayBookedSlot)
		{
			if(vacantParkingSlot.contains(x))
			{
				vacantParkingSlot.remove(x);
			}
		}
		return vacantParkingSlot;
	}


}
