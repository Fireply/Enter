package org.fireply.enter.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.fireply.enter.dao.NewsDao;
import org.fireply.enter.model.News;
import org.fireply.enter.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly=true)
public class NewsServiceImpl implements NewsService{

    @Autowired
    @Qualifier("newsDaoImpl")
    private NewsDao newsDao;
    
    @Override
    @Transactional
    public void persistNews(News news) {
        newsDao.persistNews(news);
    }

    @Override
    public News getNewsById(String id) {
        return newsDao.getNewsById(id);
    }
    
    @Override
    public List<News> getAllNews() {
        return newsDao.getAllNews();
    }
    
}
