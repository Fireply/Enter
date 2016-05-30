package org.fireply.enter.service;

import java.io.Serializable;
import java.util.List;

import org.fireply.enter.model.News;

public interface NewsService extends BaseService {

    List<News> getAllNews();
    
    News getNews(Serializable id);
    
}
