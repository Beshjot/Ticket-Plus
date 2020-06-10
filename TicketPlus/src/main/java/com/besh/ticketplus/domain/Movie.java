package com.besh.ticketplus.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Movie
{
    @Id
    private long movieId;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private String image;
    @Column
    private String trailer;
    @Column
    private float price;

    Movie()
    {

    }

    public Movie(long movieId, String title, String description, String image, String trailer, float price) {
        this.movieId = movieId;
        this.title = title;
        this.description = description;
        this.image = image;
        this.trailer = trailer;
        this.price = price;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", trailer='" + trailer + '\'' +
                ", price=" + price +
                '}';
    }
}
