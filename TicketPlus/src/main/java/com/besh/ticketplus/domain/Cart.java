package com.besh.ticketplus.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

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
    private Long quantity;
    @Column
    private float price;

    public Cart() {
    }

    public Cart(long movieId, String title, String image, Long quantity) {
        this.movieId = movieId;
        this.title = title;
        this.image = image;
        this.quantity = quantity;
        this.price = 20* this.getQuantity();
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "movieId=" + movieId +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cart)) return false;
        Cart cart = (Cart) o;
        return movieId == cart.movieId &&
                Float.compare(cart.price, price) == 0 &&
                Objects.equals(title, cart.title) &&
                Objects.equals(image, cart.image) &&
                Objects.equals(quantity, cart.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId, title, image, quantity, price);
    }
}
