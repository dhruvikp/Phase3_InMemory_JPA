package com.simplilearn.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.entity.Movie;
import com.simplilearn.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	MovieRepository movieRepository;

	public void saveMove(Movie movie) {
		movieRepository.save(movie);
	}

	public void delete(int id) {
		movieRepository.deleteById(id);
	}

	public List<Movie> getAllMovies() {
		List<Movie> movies = new ArrayList<>();
		movieRepository.findAll().forEach(m -> movies.add(m));
		return movies;
	}
	
	

}
