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
public class QueryMethodsTestRunnerSingle_row implements CommandLineRunner {
	@Autowired
	private IMovieRepo repo;// InMemory proxy class obj of our proj will be injected

	@Override
	public void run(String... args) throws Exception {
	/*
		Movie movie=repo.fetchMovieDataByMname("Ramayan1");
		System.out.println("abhishek");
		if(movie!=null)
		System.out.println(" Movie details are :: "+movie);
		else
			System.out.println("Movie not found");
		
		
		*/
		
		
		
		/*
		
		
		
		
		 * 
	//	When we have ready made findById(-) methodwhy should we use @Query methods for single row operations ???
		==================================================================================================
		Ans-->
		         The findById(-) method can take only id values as the criteria value ...where as Query method having query for single row operation can take other unique columns/properties
		         as the criteria value....thats why.....
		         
		*/
		/*
		System.out.println("==============================");
		Object data=repo.fetchMoviePartialDataByMname("Tillu");
		Object result[]=(Object[])data;
      for(Object val:result) {
    	  System.out.print( val+" ");
      }
      System.out.println( " " );
      
*/
      
		//===============================================================================
				//=================== ========Single Row scalar Query giving specific  col values==================================
  String year=repo.fetchMovieSingleDataByMname("Tillu");
  System.out.println("Tillu movie release year ::"+year);
      
      System.out.println();
  	//== ==================Executing single aggregate function=========================================
	
//	System.out.println("highest rating for movie : "+repo.fetchMaxRatingMovie());

      Object result[]=(Object[])repo.fetchAggregateDataOnMovie();
      System.out.println("max rating "+result[0]);
      System.out.println("min rating "+result[1]);
      System.out.println("avg rating "+result[2]);
      System.out.println("count of Movies  "+result[3]);
      System.out.println("avg year "+result[4]);
     

	}  
}
