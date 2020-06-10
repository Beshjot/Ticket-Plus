package com.besh.ticketplus.dao;

import com.besh.ticketplus.domain.News;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends CrudRepository<News, Long>
{
}
