package com.besh.ticketplus.dao;


import com.besh.ticketplus.domain.News;

import java.util.List;

public interface NewsDao
{
    boolean add(News news);
    News findById(long id);
    List<News> findAll();
    boolean delete (long id);
    boolean update (News updatedNews);
}
