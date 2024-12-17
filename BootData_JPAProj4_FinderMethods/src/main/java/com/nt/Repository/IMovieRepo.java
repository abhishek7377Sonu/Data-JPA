package com.nt.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.model.Movie;

public interface IMovieRepo extends JpaRepository<Movie, Integer> {

	// select mid ,mname,ratings,year from movie where mname=?
	public List<Movie> findByMnameEquals(String name);

	// select mid ,mname,ratings,year from movie where mname=?
	public List<Movie> findByMnameIs(String name);

	// select mid ,mname,ratings,year from movie where mname=?
	public List<Movie> findByMname(String name);
	
	//select mid,mname,year,ratings from Movie where maname like 'R%'
	public List<Movie> findByMnameStartingWith(String initChars);
	
	//select mid,mname,year,ratings from Movie where maname like '%A'
	public List<Movie> findByMnameEndingWith(String lastChars);
	
	//select mid,mname,year,ratings from Movie where maname like '%HUB%'
		public List<Movie> findByMnameContaining(String chars);
		
		//select mid,mname,year,ratings from Movie where maname like '%HUB%'
				public List<Movie> findByMnameEqualsIgnoreCase(String name);
				
				//select mid,mname,year,ratings from Movie where maname like 'yan'
				public List<Movie> findByMnameContainingIgnoreCase(String chars);
				
				//select mid,mname,year,ratings from Movie where mname like '___' //3 letters movie
				//select mid,mname,year,ratings from Movie where mname like 'R%' //movies starts with R
				//select mid,mname,year,ratings from Movie where mname like '%P%' //containing letter P
				//select mid,mname,year,ratings from Movie where mname like '%R' // ending letter R
				
				public Iterable<Movie> findByMnameLike(String chars); //pass wildCard characters when invoke the method
				
					
				///////////////////////////////////////////////////////////////////////////
				
				// Finder methods with more conditions
				
				//select mid,mname,year,ratings from Movie where mid >? and ratings <?
				public Iterable<Movie>findByMidGreaterThanAndRatingLessThan(int startMid,float endRating);
				
				public Iterable<Movie>findByMnameStartingWithOrRatingBetween(String mnameChars,float startRating,float endRating);	
				
				public Iterable<Movie>findByYearInOrMnameContainingIgnoreCaseAndRatingBetween(List<String> year,String chars,float startRating,float endRating);
			//	List<Movie> findByYearInOrNameContainingIgnoreCaseAndRatingBetween(List<Integer> years, String mnameSubstring, float ratingStart, float ratingEnd);

				public Iterable<Movie>findByMnameNotLikeOrYearInOrderByMnameAsc(String chars,List<String>years);
}
