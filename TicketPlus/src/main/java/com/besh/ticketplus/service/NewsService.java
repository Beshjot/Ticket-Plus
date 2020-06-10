package com.besh.ticketplus.service;


import com.besh.ticketplus.domain.News;

import java.util.List;

public interface NewsService
{
    boolean add(News news);
    News findById(long id);
    List<News> findAll();
    boolean delete (long id);
    boolean update (News updatedNews);
}
