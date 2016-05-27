package org.vaadin.grundlagenbuch.elasticsearch.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.vaadin.grundlagenbuch.model.Book;

import java.util.List;

public interface BookElasticsearchRepository extends ElasticsearchRepository<Book, Long> {

	List<Book> findByTitleOrAuthorOrPublisher(String title, String author, String publisher);
}
