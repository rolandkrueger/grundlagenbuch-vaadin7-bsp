package org.vaadin.grundlagenbuch.elasticsearch.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.vaadin.grundlagenbuch.model.Music;

import java.util.List;

public interface MusicElasticsearchRepository extends ElasticsearchRepository<Music, Long> {

	List<Music> findByTitleOrArtist(String title, String artist);

}
