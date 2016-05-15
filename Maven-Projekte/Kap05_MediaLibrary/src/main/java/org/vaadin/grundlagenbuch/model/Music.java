package org.vaadin.grundlagenbuch.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Music extends MediumEntity {

    @NotBlank
    private String artist;

    private Music() {
    }

    public Music(String title, String artist) {
        super(title);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
