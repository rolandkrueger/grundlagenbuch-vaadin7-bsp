package org.vaadin.grundlagenbuch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vaadin.grundlagenbuch.model.Genre;
import org.vaadin.grundlagenbuch.model.MediaType;

import java.util.List;

public interface GenreRepository extends JpaRepository<Genre, Long> {
  List<Genre> findByMediaTypeOrderByNameAsc(MediaType mediaType);
}
