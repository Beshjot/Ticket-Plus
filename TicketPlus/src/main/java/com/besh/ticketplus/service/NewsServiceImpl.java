package com.besh.ticketplus.service;

import com.besh.ticketplus.dao.NewsDao;
import com.besh.ticketplus.domain.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsDao dao;
    @Override
    public boolean add(News news) {
        System.out.println("* NewsService.add");
        return dao.add(news);
    }

    @Override
    public News findById(long id) {
        System.out.println("* NewsService.findById: " + id);
        return dao.findById(id);
    }

    @Override
    public List<News> findAll() {
        System.out.println("* NewsService.findAll:");
        return dao.findAll();
    }

    @Override
    public boolean delete(long id) {
        System.out.println("NewsService.delete");
        return dao.delete(id);
    }

    @Override
    public boolean update(News updatedNews) {
        System.out.println("NewsService.update");
        return dao.update(updatedNews);
    }
}
