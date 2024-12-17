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
		System.out.println("::::::::::FindAll:::SORT(-) method::::::::::::::::::::::::");
		try {
		Iterable<Movie>it=service.displayMoviesByOrder(false,"year","mname");
		it.forEach(System.out::println);
		}
		catch (Exception e) {
		e.printStackTrace();
		}
		*/
		//////////////////////////////////////////////////////////////////
		
		/*
		System.out.println("::::::::::FindAll:::Pageable(-) method::::::::::::::::::::::::");
		try {
			Page<Movie> page = service.generateReport(2, 3, true, "mname");
			System.out.println("page number :" + page.getNumber());
			System.out.println("page count :" + page.getTotalPages());
			System.out.println("is it !st page :" + page.isFirst());
			System.out.println("is it last page :" + page.isLast());
			System.out.println("page size :" + page.getSize());
			System.out.println("page elements count :" + page.getNumberOfElements());
			if (!page.isEmpty()) {
				List<Movie> list = page.getContent();
				list.forEach(System.out::println);
			} else
				System.out.println("no page found");
		} // try

		catch (Exception e) {
			e.printStackTrace();
		} // catch

		*/
		System.out.println("::::::::::FindAll:::Pageable pageable(-) method::::::::::::::::::::::::");
		try {
			service.generateMoviesReport(3);
		}
		catch (Exception e) {
		e.printStackTrace();
		}
		
		
	}// main
} // class
