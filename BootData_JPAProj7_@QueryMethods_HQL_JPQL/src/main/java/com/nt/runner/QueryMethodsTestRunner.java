package com.nt.runner;

import java.util.List;

import org.hibernate.property.access.spi.GetterMethodImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.Repository.IMovieRepo;
import com.nt.model.Movie;
//import com.nt.view.ResultView;
import com.nt.view.ResultView1;
import com.nt.view.ResultView2;
import com.nt.view.ResultView3;
import com.nt.view.View;

@Component
public class QueryMethodsTestRunner implements CommandLineRunner {
	@Autowired
	private IMovieRepo repo;// InMemory proxy class obj of our proj will be injected

	@Override
	public void run(String... args) throws Exception {
		/*
	System.out.println("Query method executes");
		List<Movie> list=repo.searchMoviesByIdRange(300, 4000);
	list.forEach(System.out::println);
	*/
		
		//     HQL/JPQL Entity Query Exampole  (Selecting all column values of db table)
	//	repo.searchMoviesByMname("RRR","BAHUBALI","PUSHPA").forEach(System.out::println);
		
		//===============================================================
		  //========================Scalar Queries(Specific multiple col values==================
		/*System.out.println();
		repo.fetchMovieDetailsByRatingsAndYear(8.7f, "2022", "2023", "2024").forEach(row->{
			for(Object val:row)
				          System.out.println(val+" ");
			System.out.println();
			*
		});
		*/

		//============================================================================
		  //========================Scalar Queries(Specific Single col values==================
	/*
	System.out.println("===================================");
	repo.fetchMoviesByYearRange("2020", "2022").forEach(System.out::println);
	*/
	}  
}
