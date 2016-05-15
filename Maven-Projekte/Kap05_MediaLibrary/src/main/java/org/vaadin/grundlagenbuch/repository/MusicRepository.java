package org.vaadin.grundlagenbuch.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.vaadin.grundlagenbuch.model.Music;

@Repository
public interface MusicRepository extends PagingAndSortingRepository<Music, Long> {
}
