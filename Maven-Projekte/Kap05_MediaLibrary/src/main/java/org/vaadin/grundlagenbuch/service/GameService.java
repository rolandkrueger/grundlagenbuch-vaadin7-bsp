package org.vaadin.grundlagenbuch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vaadin.grundlagenbuch.elasticsearch.repository.GameElasticsearchRepository;
import org.vaadin.grundlagenbuch.model.Game;
import org.vaadin.grundlagenbuch.repository.GameRepository;

@Service
public class GameService {

  private final GameRepository gameRepository;
  private final GameElasticsearchRepository gameESRepository;

  @Autowired
  public GameService(GameRepository gameRepository, GameElasticsearchRepository gameESRepository) {
    this.gameRepository = gameRepository;
    this.gameESRepository = gameESRepository;
  }

  public Game save(Game game) {
    final Game savedGame = gameRepository.save(game);
    gameESRepository.save(savedGame);
    return savedGame;
  }

  public Game findById(Long id) {
    return gameRepository.findOne(id);
  }

  public void deleteGame(Game game) {
    gameRepository.delete(game);
    gameESRepository.delete(game);
  }

  public Iterable<Game> getAllGames() {
    return gameRepository.findAll();
  }

  public void deleteAllGames() {
    gameRepository.deleteAllInBatch();
    gameESRepository.deleteAll();
  }
}
