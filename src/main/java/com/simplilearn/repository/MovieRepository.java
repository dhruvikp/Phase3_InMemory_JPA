package com.simplilearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.simplilearn.entity.Movie;

@Repository

public interface MovieRepository extends CrudRepository<Movie, Integer> {

	@Query("select movie from Movie movie left join Director director on movie.director.id = director.id where director.directorName = :directorName")
	public List<Movie> findMovieByDirectorName(@Param("directorName") String directorName);

}

/*
 * HQL - SQL - Instead of table name , we will use Entity name - Instead of
 * column name , we will use property name
 * 
 * select m from movie m
 * 
 * left join
 * 
 * Director director on director.id = movie.director.id
 * 
 * where director.directorName = "Manish";
 * 
 */