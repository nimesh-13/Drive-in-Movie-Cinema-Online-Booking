package com.prajwal.microservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="movie_slot_available")
public class MovieSlot 
{
	@Id
	@Column(name="movie_slot_id")
	private int movieSlotId;
	
	@Column(name="movie_name")
	private String movieName;
	
	@Column(name="movie_date")
	private String movieDate;
	
	@Column(name="movie_schedule")
	private String movieSchedule;
	
	@Column(name="booked_parking_slot")
	private int bookedParkingSlot;

	public int getMovieSlotId() {
		return movieSlotId;
	}

	public void setMovieSlotId(int movieSlotId) {
		this.movieSlotId = movieSlotId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieDate() {
		return movieDate;
	}

	public void setMovieDate(String movieDate) {
		this.movieDate = movieDate;
	}

	public String getMovieSchedule() {
		return movieSchedule;
	}

	public void setMovieSchedule(String movieSchedule) {
		this.movieSchedule = movieSchedule;
	}

	public int getBookedParkingSlot() {
		return bookedParkingSlot;
	}

	public void setBookedParkingSlot(int bookedParkingSlot) {
		this.bookedParkingSlot = bookedParkingSlot;
	}

	public MovieSlot(int movieSlotId, String movieName, String movieDate, String movieSchedule, int bookedParkingSlot) {
		super();
		this.movieSlotId = movieSlotId;
		this.movieName = movieName;
		this.movieDate = movieDate;
		this.movieSchedule = movieSchedule;
		this.bookedParkingSlot = bookedParkingSlot;
	}

	public MovieSlot() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "MovieSlot [movieSlotId=" + movieSlotId + ", movieName=" + movieName + ", movieDate=" + movieDate
				+ ", movieSchedule=" + movieSchedule + ", bookedParkingSlot=" + bookedParkingSlot + "]";
	}

		
	

	
}
