package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.nt.entity.Movie;

public interface IMovieMgmtService {
//one method can have one arg param that to last param of the method
	//var args are internally Arrays
	public Iterable<Movie>displayMoviesByOrder(boolean asc,String...properties);
		
	public Page<Movie> generateReport(int pageNo, int pageSize,boolean asc,String...props);
	
	public void generateMoviesReport(int pageSize);
}
