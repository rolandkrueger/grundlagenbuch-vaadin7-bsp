package org.vaadin.grundlagenbuch.model;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Entity;

@Entity
@Document(indexName = "media", type = "book")
public class Book extends MediumEntity {

	@NotBlank
	private String author;

	private String publisher;

	private Boolean read;

	private Book() {
	}

	public Book(String title, String author) {
		super(title);
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Boolean isRead() {
		return read;
	}

	public void setRead(Boolean read) {
		this.read = read;
	}

	@Override
	public String toString() {
		return "Book{" +
				"author='" + author + '\'' +
				", publisher='" + publisher + '\'' +
				"} " + super.toString();
	}
}
