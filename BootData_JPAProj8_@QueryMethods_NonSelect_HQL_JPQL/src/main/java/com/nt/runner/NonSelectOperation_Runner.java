package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.Repository.IMovieRepo;
@Component
public class NonSelectOperation_Runner implements CommandLineRunner {

	
	@Autowired
	private IMovieRepo repo;
	@Override
	public void run(String... args) throws Exception {
System.out.println("Updating "+ repo.modifyRatingBYMovieName(7.8f, "RRR")+" for movies");


System.out.println("delete year"+repo.deleteMovieByYearRange("2020", "2022"));




	}//run

}//class
