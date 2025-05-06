package com.example.pid_2025.entities;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.pid_2025.utils.Slugify;
import jakarta.persistence.*;
import lombok.Getter;


@Getter
@Entity
@Table(name="shows")
public class Show {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(unique=true)
    private String slug;

    private String title;
    private String description;

    @Column(name="poster_url")
    private String posterUrl;

    @ManyToOne
    @JoinColumn(name="location_id", nullable=true)
    private Location location;

    private boolean bookable;
    private double price;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(targetEntity=Representation.class, mappedBy="show")
    private List<Representation> representations = new ArrayList<>();

    // Ajout de la relation ManyToMany
    @ManyToMany
    @JoinTable(
            name = "artist_type_show",
            joinColumns = @JoinColumn(name = "show_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_type_id"))
    private List<ArtisteType> artistTypes = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "show_tag",
            joinColumns = @JoinColumn(name = "show_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags = new ArrayList<>();
    public Show() { }
    public Show(String title, String description, String posterUrl, Location location, boolean bookable,
                double price) {
        Slugify slg = new Slugify();

        this.slug = slg.slugify(title);
        this.title = title;
        this.description = description;
        this.posterUrl = posterUrl;
        this.location = location;
        this.bookable = bookable;
        this.price = price;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = null;
    }
    public void setTitle(String title) {
        this.title = title;
        Slugify slg = new Slugify();
        this.slug = slg.slugify(title);
    }

    public void setLocation(Location location) {
        if (this.location != null) {
            this.location.removeShow(this);
        }
        this.location = location;
        this.location.addShow(this);
    }

    public boolean isBookable() { return bookable; }

    public void setBookable(boolean bookable) { this.bookable = bookable; }

    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }

    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public List<Representation> getRepresentations() { return representations; }


    public Show addRepresentation(Representation representation) {
        if (!this.representations.contains(representation)) {
            this.representations.add(representation);
            representation.setShow(this);
        }
        return this;
    }

    public Show removeRepresentation(Representation representation) {
        if (this.representations.contains(representation)) {
            this.representations.remove(representation);
            if (representation.getShow().equals(this)) {
                representation.setShow(null);
            }
        }
        return this;
    }

    // Gestion de la relation ManyToMany avec ArtistType
    public List<ArtisteType> getArtistTypes() { return artistTypes; }

    public Show addArtistType(ArtisteType artistType) {
        if (!this.artistTypes.contains(artistType)) {
            this.artistTypes.add(artistType);
            artistType.addShow(this);
        }
        return this;
    }

    public Show removeArtistType(ArtisteType artistType) {
        if (this.artistTypes.contains(artistType)) {
            this.artistTypes.remove(artistType);
            artistType.getShows().remove(this);
        }
        return this;
    }
    @Override
    public String toString() {
        return "Show [id=" + id + ", slug=" + slug + ", title=" + title
                + ", description=" + description + ", posterUrl=" + posterUrl + ", location="
                + location + ", bookable=" + bookable + ", price=" + price
                + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
                + ", artistTypes=" + artistTypes.size() + "]";
    }
}