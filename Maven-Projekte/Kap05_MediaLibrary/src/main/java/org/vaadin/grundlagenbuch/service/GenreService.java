package org.vaadin.grundlagenbuch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vaadin.grundlagenbuch.model.Genre;
import org.vaadin.grundlagenbuch.model.MediaType;
import org.vaadin.grundlagenbuch.repository.GenreRepository;

import java.util.List;

@Service
public class GenreService {

    private GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public Genre save(Genre genre) {
        return genreRepository.save(genre);
    }

    public Iterable<Genre> findAll() {
        return genreRepository.findAll();
    }

    public List<Genre> findByMediaType(MediaType mediaType) {
        return genreRepository.findByMediaType(mediaType);
    }
}
