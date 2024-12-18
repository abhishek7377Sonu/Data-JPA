package com.nt.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nt.model.Movie;

import com.nt.view.View;

import jakarta.transaction.Transactional;

@Transactional
public interface IMovieRepo extends JpaRepository<Movie, Integer> {

	
	
}