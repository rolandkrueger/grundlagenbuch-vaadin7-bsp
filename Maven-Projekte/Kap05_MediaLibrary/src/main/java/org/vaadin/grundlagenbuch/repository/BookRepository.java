package org.vaadin.grundlagenbuch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vaadin.grundlagenbuch.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
