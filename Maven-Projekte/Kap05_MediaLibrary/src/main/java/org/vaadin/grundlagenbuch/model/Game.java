package org.vaadin.grundlagenbuch.model;

import javax.persistence.Entity;

@Entity
public class Game extends MediumEntity {

    private String publisher;
    private String installationMedium;

    private Game() {
    }

    public Game(String title) {
        super(title);
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getInstallationMedium() {
        return installationMedium;
    }

    public void setInstallationMedium(String installationMedium) {
        this.installationMedium = installationMedium;
    }
}
