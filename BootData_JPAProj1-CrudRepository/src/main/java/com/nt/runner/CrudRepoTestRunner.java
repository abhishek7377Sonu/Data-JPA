package com.nt.runner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Movie;
import com.nt.service.IMovieMgmtService;

import lombok.Data;

@Component
@Data
public class CrudRepoTestRunner implements CommandLineRunner {
	@Autowired
	private IMovieMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		/*
			//invoke service method
			Movie movie=new Movie();
			movie.setMname("Pushpa");
			movie.setRating(5.2f);
			movie.setYear("2022");
			try {
				System.out.println(service.registerMovie(movie));
			}
			catch (Exception e) {
			e.printStackTrace();
			}
			
		
		System.out.println("-------------------------------");
		try {
			System.out.println("records count" + service.fetchMoviesCount());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("-------------------------------");
		try {
			System.out.println("is 1st MID Movie ? " + service.checkMovieById(1));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("for ---------findAll-------Methods---------------");
		try {
			Iterable<Movie> list = service.fetchAllMovies();
			for (Movie movie : list) {     //enhanced for loop
				System.out.println(movie);
			}
			System.out.println("..........................................................");
			list.forEach(movie -> {      
				System.out.println(movie);
			});
			list.forEach(movie -> System.out.println(movie)); //forEach method
			System.out.println("..........................................................");
			list.forEach(System.out::println);//forEach method+static method reference
			System.out.println("..........................................................");
			Arrays.asList(list).stream().forEach(System.out::println); //forEach method + streaming api + static method reference
			System.out.println("..........................................................");
		
		
		} catch (Exception e) {
			e.printStackTrace();
		
		}
			*/
		/*
		System.out.println("..........findAllById(-)..method..........................");
		try {
		List<Integer>IdList=new ArrayList();
		IdList.add(189);IdList.add(1);
		System.out.println("movies are :: "+service.fetchAllMoviesByIds(IdList));
		System.out.println("..............................................");
		System.out.println("movies are :: "+service.fetchAllMoviesByIds(Arrays.asList(189,1)));
		System.out.println("..............................................");
		System.out.println("movies are :: "+service.fetchAllMoviesByIds(List.of(189,1)));
		System.out.println("..............................................");
		System.out.println("movies are :: "+service.fetchAllMoviesByIds(List.of(189,1))); 
		}
		catch (Exception e) {
		e.printStackTrace();
		}
	
		System.out.println("--------for  findAllById(-)--method---------------");
		Movie movie = new Movie();
		movie.setMname("Bahubali");
		movie.setRating(6.5f);
		movie.setYear("2018");
		service.registerMovie(movie);
		try {
			List<Integer> IdsList = new ArrayList();
			IdsList.add(52);
			IdsList.add(1);
			service.fetchAllMoviesByIds(IdsList);
			System.out.println("movices are ::" + service.fetchAllMoviesByIds(IdsList));
			System.out.println("--------------------------------------");
			System.out.println("movies are ::" + service.fetchAllMoviesByIds(List.of(2, 1, 52))); // java 9
			System.out.println("---------------------------------");
			System.out.println("movies are ::" + service.fetchAllMoviesByIds(Arrays.asList(52, 1, 2)));
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("..........findById(-)..method..........................");
		try {
			System.out.println("52 movie is :" + service.fetchAllMoviesByID(52));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
			*/

		/*
		System.out.println("..........findById(-)..method..........................");
		try {
			System.out.println("102 movie is :" + service.fetchMovieByID(102 ));
			
			System.out.println("====================================");
			System.out.println( );
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
	}
	*/
		
		/*
		System.out.println("..........findById(-)..method..........................");
		try {
 Optional<?>opt=service.getherMovieByID(102);
 if(!opt.isEmpty())
	 System.out.println("101 movie : "+opt.get());
 else
	 
	 System.out.println("101 movie not found");
			System.out.println();
			System.out.println("====================================");
			System.out.println( );
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
	}
	*/
		

		System.out.println("..........saveAll(-)..method..........................");
		try {
String result=service.groupMovieRegistration(List.of(new Movie("Bahubali","2018", 6.5f),
	                                                                                              	new Movie("Pushpa","2022", 5.2f),
	                                                                                              	new Movie("Yodha","2024", 7.2f)
		                                                                                     
		                                                                             ));
		
		System.out.println(result);
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
	}

		
		/*
		System.out.println(".......for ...save-method.for object operation method.........................");
		try {
String result=service.updateMovieDetails(102, "2013",8.9f);
		
		System.out.println(result);
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
	}
	*/
		
		
		/*
		System.out.println(".......for ...save-method.for object operation method.........................");
		try {
			Movie movie=new Movie("Yodha","2021",5.21f);
			movie.setMid(112);
String result=service.updateMovie(movie);
		
		System.out.println(result);
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
	}
	*/
		
		/*
		//  delete by ID
		System.out.println(".......for ...save-method.for object operation method.........................");
		try {
		System.out.println(service.removeMovieById(102));
		
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
	}
	
	*/
		
		/*
		//  delete by Object
		System.out.println(".......for ...delete (-)  -method.for delete Object  method.........................");
		try {
			Movie movie =new Movie();
			movie.setMid(953 );
		System.out.println(service.removeMovie(movie));
		
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
	}
	*/
		/*
		System.out.println(".......for ...deleteAll (-)  -method.for delete all Objects  .........................");
		try {
			
	System.out.println(service.removeAllMovie( ));
		
		} BootData_JPAProj1-CrudRepositoryBootData_JPAProj1-CrudRepository
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
	}
	*/
		
		System.out.println(".......for ...deleteAllById(-)  -method.for delete all Objects  .........................");
		try {
			
	System.out.println(service.removeAllMoviesById(List.of(2252, 2253, 2254)));
		
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
	}
	}
	} 

