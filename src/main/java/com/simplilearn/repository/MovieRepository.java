package com.simplilearn.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.entity.Movie;

@Repository

public interface MovieRepository extends CrudRepository<Movie, Integer> {
	
	
	Movie findMovieByName(String name);
	
}