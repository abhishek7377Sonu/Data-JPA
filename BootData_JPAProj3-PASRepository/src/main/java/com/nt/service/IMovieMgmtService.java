package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.nt.entity.Movie;

public interface IMovieMgmtService {
	
	public String removeMoviesByIds(List<Integer>ids);
	
	public List<Movie>searchMoviesByMovie(Movie movie,boolean asc,String...props);
	
	public Movie searchMovieById(Integer id);
}