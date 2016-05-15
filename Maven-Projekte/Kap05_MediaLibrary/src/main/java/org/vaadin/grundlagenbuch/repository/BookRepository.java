package org.vaadin.grundlagenbuch.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.vaadin.grundlagenbuch.model.Book;

@Repository
public interface BookRepository extends PagingAndSortingRepository<Book, Long> {
}
