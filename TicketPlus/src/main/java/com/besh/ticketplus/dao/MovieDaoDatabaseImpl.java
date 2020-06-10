package com.besh.ticketplus.dao;

import com.besh.ticketplus.domain.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MovieDaoDatabaseImpl implements MovieDao
{
    @Autowired
    private MovieRepository repository;
    @Override
    public boolean add(Movie movie) {
        System.out.println("MovieDaoDatabaseImpl.add()");
        Optional<Movie> result = repository.findById(movie.getMovieId());
        repository.save(movie);
        if(!result.isPresent())
        {
            return true;
        }
        return false;
    }

    @Override
    public Movie findById(long id) {
        System.out.println("MovieDaoDatabaseImpl.findByID: " + id);
        Optional<Movie> result = repository.findById(id);
        if(result.isPresent())
        {
            return result.get();
        }
        return null;
    }

    @Override
    public List<Movie> findAll() {
        System.out.println("MovieDaoDatabaseImpl.findAll");
        Iterable<Movie> result = repository.findAll();
        List<Movie> movies = new ArrayList<>();
        for (Movie movie : result){
            movies.add(movie);
        }
        return movies;
    }

    @Override
    public boolean delete(long id) {
        System.out.println("MovieDaoDatabaseImpl.delete()");
        Optional<Movie> result = repository.findById(id);
        if (result.isPresent()) {
            Movie movie = result.get();
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Movie updatedMovie) {
        System.out.println("MovieDaoDatabaseImpl.update()");
        Optional<Movie> result = repository.findById(updatedMovie.getMovieId());
        if(result.isPresent()){
            repository.save(updatedMovie);
            return true;
        }
        return  false;
    }

    @Override
    public Movie findBytitle(String movie) {
        System.out.println("MovieDaoDatabaseImpl.findByMovie: " + movie);
        Optional<Movie> result = repository.findBytitle(movie);
        if(result.isPresent())
        {
            return result.get();
        }
        return null;
    }
}
