package org.fireply.enter.dao.impl;

import java.util.List;

import org.fireply.enter.dao.AbstractDao;
import org.fireply.enter.dao.NewsDao;
import org.fireply.enter.model.News;
import org.springframework.stereotype.Repository;

@Repository
public class NewsDaoImpl extends AbstractDao<String, News> implements NewsDao {

    @Override
    public void persistNews(News news) {
        persist(news);
    }

    @Override
    public News getNewsById(String id) {
        return getById(id);
    }

    @Override
    public List<News> getAllNews() {
        return getAll();
    }

}
