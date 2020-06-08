package com.besh.ticketplus.dao;

import com.besh.ticketplus.domain.Cart;

import java.util.List;

public interface CartDao
{
    boolean add(Cart cart);
    Cart findById(long id);
    List<Cart> findAll();
    boolean delete (long id);
    boolean update (Cart updatedCart);
}
