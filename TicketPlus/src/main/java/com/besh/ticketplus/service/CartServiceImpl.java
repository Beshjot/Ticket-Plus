package com.besh.ticketplus.service;

import com.besh.ticketplus.dao.CartDao;
import com.besh.ticketplus.domain.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CartServiceImpl implements CartService
{
    @Autowired
    private CartDao dao;
    @Override
    public boolean add(Cart cart) {
        System.out.println("* CartService.add");
        return dao.add(cart);
    }

    @Override
    public Cart findById(long id) {
        System.out.println("* CartService.findByIdt: " + id);
        return dao.findById(id);
    }

    @Override
    public List<Cart> findAll() {
        System.out.println("* CartService.findAll:");
        return dao.findAll();
    }

    @Override
    public boolean delete(long id) {
        System.out.println("CartService.delete");
        return dao.delete(id);
    }

    @Override
    public boolean update(Cart updatedCart) {
        System.out.println("CartService.update");
        return dao.update(updatedCart);
    }
}
