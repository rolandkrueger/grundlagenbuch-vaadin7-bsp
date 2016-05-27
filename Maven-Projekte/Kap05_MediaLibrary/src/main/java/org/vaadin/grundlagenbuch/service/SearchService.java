package org.vaadin.grundlagenbuch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vaadin.grundlagenbuch.elasticsearch.repository.BookElasticsearchRepository;
import org.vaadin.grundlagenbuch.elasticsearch.repository.GameElasticsearchRepository;
import org.vaadin.grundlagenbuch.elasticsearch.repository.MovieElasticsearchRepository;
import org.vaadin.grundlagenbuch.elasticsearch.repository.MusicElasticsearchRepository;
import org.vaadin.grundlagenbuch.model.MediaType;
import org.vaadin.grundlagenbuch.model.MediumEntity;

import java.util.LinkedList;
import java.util.List;

@Service
public class SearchService {

  private final BookElasticsearchRepository bookESRepository;
  private final GameElasticsearchRepository gameESRepository;
  private final MovieElasticsearchRepository movieESRepository;
  private final MusicElasticsearchRepository musicESRepository;

  @Autowired
  public SearchService(BookElasticsearchRepository bookESRepository, GameElasticsearchRepository gameESRepository,
                       MovieElasticsearchRepository movieESRepository, MusicElasticsearchRepository musicESRepository) {

    this.bookESRepository = bookESRepository;
    this.gameESRepository = gameESRepository;
    this.movieESRepository = movieESRepository;
    this.musicESRepository = musicESRepository;
  }

  public List<MediumEntity> findAllMediaEntities(String searchTerm) {
    List<MediumEntity> resultList = new LinkedList<>();
    resultList.addAll(bookESRepository.findByTitleOrAuthorOrPublisher(searchTerm, searchTerm, searchTerm));
    resultList.addAll(gameESRepository.findByTitleOrPublisher(searchTerm, searchTerm));
    resultList.addAll(movieESRepository.findByTitleOrDirector(searchTerm, searchTerm));
    resultList.addAll(musicESRepository.findByTitleOrArtist(searchTerm, searchTerm));
    return resultList;
  }

  public List<? extends MediumEntity> findMediaEntitiesByMediaType(String searchTerm, MediaType mediaType) {
    if (mediaType == null) {
      throw new NullPointerException("media type is null");
    }

    switch (mediaType) {
      case BOOK:
        return bookESRepository.findByTitleOrAuthorOrPublisher(searchTerm, searchTerm, searchTerm);
      case GAME:
        return gameESRepository.findByTitleOrPublisher(searchTerm, searchTerm);
      case MOVIE:
        return movieESRepository.findByTitleOrDirector(searchTerm, searchTerm);
      case MUSIC:
        return musicESRepository.findByTitleOrArtist(searchTerm, searchTerm);
      default:
        throw new IllegalArgumentException("media type argument not valid");
    }
  }
}
