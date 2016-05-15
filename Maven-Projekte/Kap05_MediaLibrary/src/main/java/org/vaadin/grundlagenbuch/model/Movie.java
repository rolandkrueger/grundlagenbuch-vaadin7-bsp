package org.vaadin.grundlagenbuch.model;

import javax.persistence.Entity;

@Entity
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
