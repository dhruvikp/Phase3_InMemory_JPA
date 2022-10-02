package com.simplilearn.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.entity.Director;
import com.simplilearn.entity.Movie;
import com.simplilearn.repository.DerectorRepository;
import com.simplilearn.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	MovieRepository movieRepository;

	@Autowired
	DerectorRepository directorRepository;

	public void saveMove(Movie movie) {

		Optional<Director> optDirector = directorRepository.findByDirectorName(movie.getDirector().getDirectorName());
		
		if(optDirector.isPresent()) {
			movie.setDirector(optDirector.get());
		}
		
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

	public List<Movie> getMovieByDirectorName(String directorName) {
		return movieRepository.findMovieByDirectorName(directorName);
	}
}
