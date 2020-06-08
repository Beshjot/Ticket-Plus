package com.besh.ticketplus.dao;

import com.besh.ticketplus.domain.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long>
{
}
