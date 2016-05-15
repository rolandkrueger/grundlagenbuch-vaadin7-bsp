package org.vaadin.grundlagenbuch.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "MEDIA")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class MediumEntity {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String title;

    private BigDecimal price;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    private Genre genre;

    private LocalDate dateOfPurchase;

    protected MediumEntity() {
    }

    public MediumEntity(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public LocalDate getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(LocalDate dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    @Override
    public String toString() {
        return "MediumEntity{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", price=" + price +
            ", genre=" + genre +
            ", dateOfPurchase=" + dateOfPurchase +
            '}';
    }
}
