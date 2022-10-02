package com.simplilearn.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.entity.Movie;
import com.simplilearn.service.MovieService;

@RestController
public class MovieController {

	@Autowired
	MovieService movieService;

	@GetMapping("/movies")
	public List<Movie> getAllMovies() {
		
		return movieService.getAllMovies();
		
		
	}

	@DeleteMapping("/movies/{id}")
	public void deleteMovie(@PathVariable("id") int id) {
		movieService.delete(id);
	}

	@PostMapping("/movies")
	public int saveMove(@RequestBody Movie movie) {
		movieService.saveMove(movie);
		return movie.getId();
	}

	@GetMapping("/director/{name}")
	public List<String> getMoviesByDirectorName(@PathVariable("name") String directorName) {

		List<String> movieNames = new ArrayList<>();
		List<Movie> movies = movieService.getMovieByDirectorName(directorName);

		if (movies != null && !movies.isEmpty()) {
			for (Movie movie : movies) {
				movieNames.add(movie.getName());
			}
		}

		return movieNames;
	}

}
