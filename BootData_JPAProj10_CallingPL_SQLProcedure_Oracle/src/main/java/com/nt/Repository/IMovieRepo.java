package com.nt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.model.Movie;

import jakarta.transaction.Transactional;

@Transactional
public interface IMovieRepo extends JpaRepository<Movie, Integer> {

}