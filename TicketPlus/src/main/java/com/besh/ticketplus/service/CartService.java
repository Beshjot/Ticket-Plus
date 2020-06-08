package com.besh.ticketplus.service;

import com.besh.ticketplus.domain.Cart;
import com.besh.ticketplus.domain.Movie;

import java.util.List;

public interface CartService
{
    boolean add(Cart cart);
    Cart findById(long id);
    List<Cart> findAll();
    boolean delete (long id);
    boolean update (Cart updatedCart);
}
