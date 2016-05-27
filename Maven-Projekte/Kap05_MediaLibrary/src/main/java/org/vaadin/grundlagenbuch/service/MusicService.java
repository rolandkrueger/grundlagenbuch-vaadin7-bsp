package org.vaadin.grundlagenbuch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vaadin.grundlagenbuch.elasticsearch.repository.MusicElasticsearchRepository;
import org.vaadin.grundlagenbuch.model.Music;
import org.vaadin.grundlagenbuch.repository.MusicRepository;

@Service
public class MusicService {

  private final MusicRepository musicRepository;
  private final MusicElasticsearchRepository musicESRepository;

  @Autowired
  public MusicService(MusicRepository musicRepository, MusicElasticsearchRepository musicESRepository) {
    this.musicRepository = musicRepository;
    this.musicESRepository = musicESRepository;
  }

  public Music save(Music music) {
    final Music savedMusic = musicRepository.save(music);
    musicESRepository.save(savedMusic);
    return savedMusic;
  }

  public Music findById(Long id) {
    return musicRepository.findOne(id);
  }

  public void deleteMusic(Music music) {
    musicRepository.delete(music);
    musicESRepository.delete(music);
  }

  public Iterable<Music> getAllMusic() {
    return musicRepository.findAll();
  }

  public void deleteAllMusic() {
    musicRepository.deleteAllInBatch();
    musicESRepository.deleteAll();
  }
}
