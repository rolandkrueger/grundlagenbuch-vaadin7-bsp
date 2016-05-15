package org.vaadin.grundlagenbuch.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class Genre {

  @Id
  @GeneratedValue
  private Long id;

  @NotBlank
  @Column(nullable = false)
  private String name;

  @NotNull
  @Column(nullable = false)
  private MediaType mediaType;

  private Genre() {
  }

  public Genre(String name, MediaType mediaType) {
    this.name = name;
    this.mediaType = mediaType;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public MediaType getMediaType() {
    return mediaType;
  }

  public void setMediaType(MediaType mediaType) {
    this.mediaType = mediaType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Genre genre = (Genre) o;
    return Objects.equals(name, genre.name) &&
      mediaType == genre.mediaType;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, mediaType);
  }

  @Override
  public String toString() {
    return "Genre{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", mediaType=" + mediaType +
      '}';
  }
}
