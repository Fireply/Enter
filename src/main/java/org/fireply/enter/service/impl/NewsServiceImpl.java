package org.fireply.enter.service.impl;

import java.io.Serializable;
import java.util.List;

import org.fireply.enter.model.News;
import org.fireply.enter.service.NewsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly=true)
public class NewsServiceImpl extends BaseServiceImpl implements NewsService{

    @Override
    public List<News> getAllNews() {
        return (List<News>) getAll(News.class);
    }

    @Override
    public News getNews(Serializable id) {
        return (News) get(News.class, id);
    }

}
