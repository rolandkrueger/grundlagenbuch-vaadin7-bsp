package org.vaadin.grundlagenbuch.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.vaadin.grundlagenbuch.model.Genre;
import org.vaadin.grundlagenbuch.model.MediaType;

import java.util.List;

@Repository
public interface GenreRepository extends PagingAndSortingRepository<Genre, Long> {
  List<Genre> findByMediaType(MediaType mediaType);
}
