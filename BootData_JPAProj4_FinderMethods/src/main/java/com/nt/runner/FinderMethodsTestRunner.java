package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.Repository.IMovieRepo;
import com.nt.model.Movie;
@Component
public class FinderMethodsTestRunner implements CommandLineRunner {
@Autowired
	private IMovieRepo repo;//InMemory proxy class obj of our proj will be injected
	@Override
	public void run(String... args) throws Exception {
	//Finder methods
		repo.findByMnameEquals("KGF").forEach(System.out::println);
	
		
		/*	
		System.out.println("=========================");
		repo.findByMnameIs("Ramayan").forEach(System.out::println);
		
		System.out.println("=========================");
		repo.findByMname("Ramayan").forEach(System.out::println);

		System.out.println("==========Starts with R===============");
		repo.findByMnameStartingWith("R").forEach(System.out::println);
		
		System.out.println("==========Lasts with A===============");
		repo.findByMnameEndingWith("A").forEach(System.out::println);
		
		System.out.println("==========Ignorecase with HUB=====Complete record==========");
		repo.findByMnameEqualsIgnoreCase("RamayaN").forEach(System.out::println);
		
		System.out.println("==========ContainingIgnorecase with HUB=====Complete record==========");
		repo.findByMnameContainingIgnoreCase("may").forEach(System.out::println);

		System.out.println("==========findByMnameLike==========");
		repo.findByMnameLike("___").forEach(System.out::println);
		
		*/
///////////////////////////////////////////////////////////////////////////
		
// Finder methods with more conditions
		
		//select mid,mname,year,ratings from Movie where mid >? and ratings <?
		System.out.println("==========finder methods with multiple properties based conditions==========");
		repo.findByMidGreaterThanAndRatingLessThan(400,8.7f).forEach(System.out::println);;
		
		System.out.println("==============================");
		repo.findByMnameStartingWithOrRatingBetween("R", 4.6f, 7.8f).forEach(System.out::println);
		
		System.out.println("===================================================");
		repo.findByYearInOrMnameContainingIgnoreCaseAndRatingBetween(List.of("2018","2022"), 
				                                                               "h", 
				                                                               4.6f, 8.7f).forEach(System.out::println);
		
		System.out.println("===================================================");
		repo.findByMnameNotLikeOrYearInOrderByMnameAsc("R%", List.of("2018","2022")).forEach(System.out::println);
		
		
	}
}
