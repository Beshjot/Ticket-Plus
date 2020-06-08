package com.besh.ticketplus.service;

import com.besh.ticketplus.domain.Movie;

import java.util.List;

public interface MovieService
{
    boolean add(Movie movie);
    Movie findById(long id);
    List<Movie> findAll();
    boolean delete (long id);
    boolean update (Movie updatedMovie);
}
