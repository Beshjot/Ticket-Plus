package com.besh.ticketplus.dao;

import com.besh.ticketplus.domain.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CartDaoDatabaseImpl implements CartDao
{
    @Autowired
    private CartRepository repository;
    @Override
    public boolean add(Cart cart) {
        System.out.println("CartDaoDatabaseImpl.add()");
        Optional<Cart> result = repository.findById(cart.getMovieId());
        repository.save(cart);
        if(!result.isPresent())
        {
            return true;
        }
        return false;
    }

    @Override
    public Cart findById(long id) {
        System.out.println("CartDaoDatabaseImpl.findByID: " + id);
        Optional<Cart> result = repository.findById(id);
        if(result.isPresent())
        {
            return result.get();
        }
        return null;
    }

    @Override
    public List<Cart> findAll() {
        System.out.println("CartDaoDatabaseImpl.findAll");
        Iterable<Cart> result = repository.findAll();
        List<Cart> carts = new ArrayList<>();
        for (Cart cart : result){
            carts.add(cart);
        }
        return carts;
    }

    @Override
    public boolean delete(long id) {
        System.out.println("CartDaoDatabaseImpl.delete()");
        Optional<Cart> result = repository.findById(id);
        if (result.isPresent()) {
            Cart cart = result.get();
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Cart updatedCart) {
        System.out.println("CartDaoDatabaseImpl.update()");
        Optional<Cart> result = repository.findById(updatedCart.getMovieId());
        if(result.isPresent()){
            repository.save(updatedCart);
            return true;
        }
        return  false;
    }
}
