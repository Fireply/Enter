package org.fireply.enter.dao;

import java.util.List;

import org.fireply.enter.model.News;

public interface NewsDao {

    void persistNews(News news);
    
    News getNewsById(String id);
    
    List<News> getAllNews();
}
