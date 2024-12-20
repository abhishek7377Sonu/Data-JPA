package com.nt.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.model.Movie;
import com.nt.view.ResultView;

public interface IMovieRepo extends JpaRepository<Movie, Integer> {

	public Iterable<ResultView>findByMidGreaterThanEqualAndMidLessThanEqual(int startMid,int endMid);
	
	
}
