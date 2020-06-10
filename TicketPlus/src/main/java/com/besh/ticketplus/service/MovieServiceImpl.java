package com.besh.ticketplus.service;

import com.besh.ticketplus.dao.MovieDao;
import com.besh.ticketplus.domain.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieServiceImpl implements MovieService
{
    @Autowired
    private MovieDao dao;
    @Override
    public boolean add(Movie movie) {
        System.out.println("* MovieService.add");
        return dao.add(movie);
    }

    @Override
    public Movie findById(long id) {
        System.out.println("* MovieService.findById: " + id);
        return dao.findById(id);
    }

    @Override
    public Movie findBytitle(String movie) {
        System.out.println("* MovieService.findByMovie: " + movie);
        return dao.findBytitle(movie);
    }

    @Override
    public List<Movie> findAll() {
        System.out.println("* MovieService.findAll:");
        return dao.findAll();
    }

    @Override
    public boolean delete(long id) {
        System.out.println("MovieService.delete");
        return dao.delete(id);
    }

    @Override
    public boolean update(Movie updatedMovie) {
        System.out.println("MovieService.update");
        return dao.update(updatedMovie);
    }
}
