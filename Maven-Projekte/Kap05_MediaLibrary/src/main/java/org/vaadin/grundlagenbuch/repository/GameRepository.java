package org.vaadin.grundlagenbuch.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.vaadin.grundlagenbuch.model.Game;

@Repository
public interface GameRepository extends PagingAndSortingRepository<Game, Long> {
}
