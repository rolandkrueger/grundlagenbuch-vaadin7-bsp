package org.vaadin.grundlagenbuch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vaadin.grundlagenbuch.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
