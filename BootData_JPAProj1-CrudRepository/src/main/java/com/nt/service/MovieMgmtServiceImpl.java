package com.nt.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.Repository.IMovieRepo;
import com.nt.entity.Movie;

import jakarta.persistence.criteria.CriteriaBuilder.In;

@Service("movieService")
public class MovieMgmtServiceImpl implements IMovieMgmtService {
	@Autowired // injects the dynamically generated proxy class object
	private IMovieRepo movieRepo; // HAS-A property

	@Override
	public String registerMovie(Movie movie) {
		System.out.println("InMemory proxy class name :: " + movieRepo.getClass() + "......."
				+ Arrays.toString(movieRepo.getClass().getInterfaces()));
		// use repo
		System.out.println("before saving : " + movie);
		Movie movie1 = movieRepo.save(movie);
		System.out.println("After saving : " + movie);
		return "movie is register with the ID value " + movie1.getMid();
	}

	@Override
	public long fetchMoviesCount() {
		System.out.println("InMemory proxy class name :: " + movieRepo.getClass() + "......."
				+ Arrays.toString(movieRepo.getClass().getInterfaces()));
		System.out.println("----------------------");
		System.out.println("methods :: " + Arrays.toString(movieRepo.getClass().getDeclaredMethods()));
		return movieRepo.count();
	}

	@Override
	public boolean checkMovieById(Integer mid) {

		return movieRepo.existsById(mid);
	}

	@Override
	public Iterable<Movie> fetchAllMovies() {

		return movieRepo.findAll();
	}

	@Override
	public List<Movie> fetchAllMoviesByIds(List<Integer> mids) {
		List<Movie> allById = (List<Movie>) movieRepo.findAllById(mids);
		return allById;
	}
/*
	@Override
	public Movie fetchAllMoviesByID(Integer mid) {
		Optional<Movie> opt = movieRepo.findById(mid);
		if (opt.isPresent())
			return opt.get();
		else
			throw new IllegalArgumentException("record not found");
			}
*/
	/*
	@Override
	public Movie fetchMovieByID(Integer mid) {
	
		return movieRepo.findById(mid).orElseThrow(()-> new IllegalArgumentException("record not found"));
	
	}
	*/
	@Override
	public Movie fetchMovieByID(Integer mid) {
	
		return movieRepo.findById(mid).orElse(new Movie()); //if record is available returns Entity obj with Data
		                                                                                                       //otherwise empty entity object
	}

	@Override
	public Optional<?> getherMovieByID(Integer mid) {
		Optional<Movie> opt = movieRepo.findById(mid);
		if (opt.isEmpty())

			return Optional.empty();
		else
			return opt;
	}
	
	@Override
	public String groupMovieRegistration(List<Movie> movieslist) {
	Iterable<Movie>savedMovies=movieRepo.saveAll(movieslist);
	 List<Integer>listid=new ArrayList<>();
	 if(savedMovies!=null &&((List<Movie>)savedMovies).size()>0){
		 savedMovies.forEach(m->{
			 listid.add(m.getMid());
			 } );
	 }
	 return  listid.toString()+"movies are saved";
	}
	
	@Override
	public String updateMovieDetails(Integer mid, String NewYear, Float NewRating) {
	Optional<Movie>opt=movieRepo.findById(mid);
	if(opt.isPresent()) {
		Movie movie=opt.get();
		movie.setYear(NewYear);
		movie.setRating(NewRating);
		movieRepo.save(movie); // always call merge(-) update operation
	
	  return mid +"movie Id is updated";
	}
	else {
		return "Movie ID is not available"; 
	}
			
	}
	
	
	@Override
	public String updateMovie(Movie movie) {
	Optional<Movie>opt=movieRepo.findById(movie.getMid());
	if(opt.isPresent()) {
	movieRepo.save(movie);
		return "movie updated";
	}
		else
			return "movie is not updated";
	}
	
	
	/*
	//single line   on the above code logic 
	//bad 
	@Override
	public String updateMovie(Movie movie) {
	movieRepo.save(movie);
	return "movie updated";
	}
	
	
	*/
	
	
	//DELETE BY ID
	@Override
	public String removeMovieById(Integer mid) {
	Movie movie=movieRepo.findById(mid).orElseThrow(()->new IllegalArgumentException("movie not found"));
	movieRepo.delete(movie);

		return "record deleted" ;
	}
	
	/*
	@Override
	public String removeMovie(Movie movie) {
		movieRepo.delete(movie);
		return "record deleted";
	}
	*/
	@Override
	public String removeMovie(Movie movie) {
		
		Optional<Movie>opt=movieRepo.findById(movie.getMid());
		
		if(opt.isPresent()) {
			movieRepo.delete(movie);
			return "record deleted";
		}
		else {
			return "movie not found";
		}
	
	}
	@Override
	public String removeAllMovie() {
	long count=movieRepo.count();
	if(count!=0)
		movieRepo.deleteAll();
		return count+"no of records are deleted";
	}
	
	@Override
	public String removeAllMoviesById(List<Integer> ids) {
		for(Integer id:ids) {
			if(id==null)
				return "Given id(s) must not be null";
		}//for
		Iterable<Movie>it=movieRepo.findAllById(ids);
		long count=((List<Movie>)it).size();
		if(ids.size()!=0 && ids.size()==count) {
		movieRepo.deleteAllById(ids);
		return ((List<Movie>) it).size() +" no. of records are deleted";
	}
		else {
			return "No Ids are given to delete or either all or some ids are not available  to delete";
		}
	}
	@Override
	public Movie fetchAllMoviesByID(Integer mids) {
		return null;
	
}
}
