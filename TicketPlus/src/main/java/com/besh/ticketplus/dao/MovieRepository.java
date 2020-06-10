package com.besh.ticketplus.dao;

import com.besh.ticketplus.domain.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long>
{
    Optional<Movie> findBytitle(String movie);
}
