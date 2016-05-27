package org.vaadin.grundlagenbuch.elasticsearch.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.vaadin.grundlagenbuch.model.Game;

import java.util.List;

public interface GameElasticsearchRepository extends ElasticsearchRepository<Game, Long> {

	List<Game> findByTitleOrPublisher(String title, String publisher);

}
