package com.nt.runner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.nt.entity.Movie;
import com.nt.service.IMovieMgmtService;

import lombok.Data;

@Component
public class CrudRepoTestRunner implements CommandLineRunner {
	@Autowired
	private IMovieMgmtService service;

	@Override
	public void run(String... args) throws Exception {
/*
		System.out.println("::::::::::deleteAllByIdInBatch:::::::::::::::::::::::::::");
		try {
			System.out.println(service.removeMoviesByIds(List.of(458,475)));
		}
		catch (Exception e) {
		e.printStackTrace();
		}
		*/
	//////////////////////////////////////
		/*
		System.out.println("::::::::::FindAll(example,sort):::::::::::::::::::::::::::");
		try {
			Movie movie=new Movie();
			//movie.setMid(100); movie.setMname("Magadhera");
			movie.setYear("2020");
			movie.setRating(6.9f);
			List<Movie>list=service.searchMoviesByMovie(movie, true, "mname");
	list.forEach(System.out::println);
		
		}
		catch (Exception e) {
		e.printStackTrace();
		}
	*/	
		
		System.out.println("::::::::::FindAll(example,sort):::::::::::::::::::::::::::");
		try {
			System.out.println("416  movie details are :"+ service.searchMovieById(416));
		
		}
		catch (Exception e) {
		e.printStackTrace();
		System.out.println(e.getMessage());
		}
	
	}// main
} // class
