package org.vaadin.grundlagenbuch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vaadin.grundlagenbuch.model.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
}
