package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.entity.Movie;

public interface IMovieMgmtService {
	public String registerMovie(Movie movie);

	long fetchMoviesCount();

	public boolean checkMovieById(Integer mid);

	public Iterable<Movie> fetchAllMovies();

	public Iterable<Movie> fetchAllMoviesByIds(List<Integer> mids);

	public Movie fetchAllMoviesByID(Integer mids);
	
	public Movie fetchMovieByID(Integer mid);

	public Optional <?>getherMovieByID(Integer mid);
	
	public String groupMovieRegistration(List<Movie>movieslist); 
	
	public String updateMovieDetails(Integer mid, String NewYear,Float NewRating);
	
	public String updateMovie(Movie movie);
	
	public String removeMovieById(Integer mid); //delete by id

	public String removeMovie(Movie movie);
	
	public String removeAllMovie();

	public String removeAllMoviesById(List<Integer>ids);
}
