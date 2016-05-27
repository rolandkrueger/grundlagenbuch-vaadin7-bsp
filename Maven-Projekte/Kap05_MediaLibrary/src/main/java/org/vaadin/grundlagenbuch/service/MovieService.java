package org.vaadin.grundlagenbuch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vaadin.grundlagenbuch.elasticsearch.repository.MovieElasticsearchRepository;
import org.vaadin.grundlagenbuch.model.Movie;
import org.vaadin.grundlagenbuch.repository.MovieRepository;

@Service
public class MovieService {

  private final MovieRepository movieRepository;
  private final MovieElasticsearchRepository movieESRepository;

  @Autowired
  public MovieService(MovieRepository movieRepository, MovieElasticsearchRepository movieESRepository) {
    this.movieRepository = movieRepository;
    this.movieESRepository = movieESRepository;
  }

  public Movie save(Movie movie) {
    final Movie savedMovie = movieRepository.save(movie);
    movieESRepository.save(savedMovie);
    return savedMovie;
  }

  public Movie findById(Long id) {
    return movieRepository.findOne(id);
  }

  public void deleteMovie(Movie movie) {
    movieRepository.delete(movie);
    movieESRepository.delete(movie);
  }

  public Iterable<Movie> getAllMovies() {
    return movieRepository.findAll();
  }

  public void deleteAllMovies() {
    movieRepository.deleteAllInBatch();
    movieESRepository.deleteAll();
  }
}
