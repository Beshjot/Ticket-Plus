package com.besh.ticketplus.dao;

import com.besh.ticketplus.domain.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class NewsDaoDatabaseImpl implements NewsDao
{
    @Autowired
    private NewsRepository repository;
    @Override
    public boolean add(News news) {
        System.out.println("NewsDaoDatabaseImpl.add()");
        Optional<News> result = repository.findById(news.getNewsId());
        repository.save(news);
        if(!result.isPresent())
        {
            return true;
        }
        return false;
    }

    @Override
    public News findById(long id) {
        System.out.println("NewsDaoDatabaseImpl.findByID: " + id);
        Optional<News> result = repository.findById(id);
        if(result.isPresent())
        {
            return result.get();
        }
        return null;
    }

    @Override
    public List<News> findAll() {
        System.out.println("NewsDaoDatabaseImpl.findAll");
        Iterable<News> result = repository.findAll();
        List<News> news = new ArrayList<>();
        for (News newsi : result){
            news.add(newsi);
        }
        return news;
    }

    @Override
    public boolean delete(long id) {
        System.out.println("NewsDaoDatabaseImpl.delete()");
        Optional<News> result = repository.findById(id);
        if (result.isPresent()) {
            News news = result.get();
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(News updatedNews) {
        System.out.println("NewsDaoDatabaseImpl.update()");
        Optional<News> result = repository.findById(updatedNews.getNewsId());
        if(result.isPresent()){
            repository.save(updatedNews);
            return true;
        }
        return  false;
    }
}
