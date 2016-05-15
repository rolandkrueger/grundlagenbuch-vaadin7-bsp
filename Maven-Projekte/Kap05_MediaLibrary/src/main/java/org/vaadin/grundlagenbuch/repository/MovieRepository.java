package org.vaadin.grundlagenbuch.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.vaadin.grundlagenbuch.model.Movie;

@Repository
public interface MovieRepository extends PagingAndSortingRepository<Movie, Long> {
}
