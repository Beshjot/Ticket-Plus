package com.besh.ticketplus.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cart
{
    @Id
    private long movieId;
    @Column
    private String title;
    @Column
    private  String image;
    @Column
    private long quantity;

    public Cart() {
    }

    public Cart(long movieId, String title, String image, long quantity) {
        this.movieId = movieId;
        this.title = title;
        this.image = image;
        this.quantity = quantity;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "movieId=" + movieId +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
