package org.vaadin.grundlagenbuch.elasticsearch.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.vaadin.grundlagenbuch.model.Movie;

import java.util.List;

public interface MovieElasticsearchRepository extends ElasticsearchRepository<Movie, Long> {

	List<Movie> findByTitleOrDirector(String title, String director);

}
