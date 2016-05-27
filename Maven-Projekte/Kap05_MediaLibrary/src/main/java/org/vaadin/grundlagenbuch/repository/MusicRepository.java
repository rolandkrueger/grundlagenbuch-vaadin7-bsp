package org.vaadin.grundlagenbuch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vaadin.grundlagenbuch.model.Music;

public interface MusicRepository extends JpaRepository<Music, Long> {
}
