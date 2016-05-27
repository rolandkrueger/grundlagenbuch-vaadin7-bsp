package org.vaadin.grundlagenbuch.model;

import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Entity;

@Entity
@Document(indexName = "media", type = "movie")
public class Movie extends MediumEntity {

  private String director;

  private Movie() {
  }

  public Movie(String title) {
    super(title);
  }

  public String getDirector() {
    return director;
  }

  public void setDirector(String director) {
    this.director = director;
  }
}
