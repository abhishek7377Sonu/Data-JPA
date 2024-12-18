package com.nt.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nt.model.Movie;

import com.nt.view.View;

public interface IMovieRepo extends JpaRepository<Movie, Integer> {
	
	//==================================Entity Queries(All col values)===================
	//==================================================================================
//@Query("from Movie where mid>=?1 and mid<=?2")
//@Query("from Movie as m where m.mid>=?1 and m.mid<=?2") // Alias name
	//public List<Movie> searchMoviesByIdRange(int start,int end);
	
	/*
	@Query("from Movie where mid>=:min and mid<=:max")
	public List<Movie> searchMoviesByIdRange(@Param("min")int start ,@Param("max")int end);
	*/
	
	//=====================Best Approach======================
	@Query("from Movie where mid>=:min and mid<=:max")
	public List<Movie> searchMoviesByIdRange(int min,int max);
	
	//===========================================================
	
	/*
	@Query("from Movie where mname In(:name1,:name2,:name3)order By mname asc")
	public List<Movie>searchMoviesByMname(String name1,String name2,String name3);
	*/
	
	
	//     HQL/JPQL Entity Query Exampole  (Selecting all column values of db table)
	//==========================================================================
	@Query("from Movie where mname In(?1,?2,?3)order By mname asc")
	public List<Movie>searchMoviesByMname(String name1,String name2,String name3);
	 //taking array / var args /collection params / multiple named params or positional pareams are not allowed....
	
	/*
	//============================================================================
	  //========================Scalar Queries(Specific multiple col values==================
	
	@Query("select mid,mname,year from Movie Where rating>=:rat and year In(:y1,:y2,:y3)")
	public List<Object[]> fetchMovieDetailsByRatingsAndYear(float rat,String y1,String y2,String y3);
	
	*/
	
	//============================================================================
	  //========================Scalar Queries(Specific Single col values==================
	/*
	@Query("select mname from Movie Where year>=:start and year<=:end order by mname desc")
	public List<Object> fetchMoviesByYearRange(String start,String end);
	
	//===============================================================================
//===========================Single Entity Query==================================
	
	@Query("from Movie where mname=:name")//assuming movie name are unique name
	public Movie fetchMovieDataByMname(String name);
	//===============================================================================
	//===========================Single Row scalar Query giving specific multiple col values==================================
		
	@Query(" select mid ,mname, year from Movie where mname=:name")
	public Object fetchMoviePartialDataByMname(String name);
	
	//===============================================================================
		//=================== ========Single Row scalar Query giving specific  col values==================================
*/
	@Query("select year from Movie where mname=:name")
	public String fetchMovieSingleDataByMname(String name);
	/*
	//==============================================================
	//Executing single aggregate function
	@Query("select max(rating) from Movie ")
	public float fetchMaxRatingMovie();
	
*/
	@Query("select max(RATING),min(RATING),avg(RATING),count(*),avg(YEAR) from Movie")
	public Object fetchAggregateDataOnMovie();

}
//@Query("SELECT MAX(m.rating), MIN(m.rating), AVG(m.rating), COUNT(*), AVG(m.year) FROM Movie m")
