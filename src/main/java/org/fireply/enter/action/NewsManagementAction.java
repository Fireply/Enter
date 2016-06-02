package org.fireply.enter.action;

import java.util.List;

import org.fireply.enter.model.News;
import org.fireply.enter.service.NewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller
public class NewsManagementAction extends ActionSupport {

    @Autowired
    @Qualifier("newsServiceImpl")
    private NewsService newsService;
    
    private List<News> newsList;    // 请求新闻列表时将数据库查询结果存放在 newsList
    
    private static final Logger logger = LoggerFactory.getLogger(NewsManagementAction.class);
    
    @Override
    public String execute() throws Exception {
        newsList = newsService.getAllNews();
        
        if (newsList == null || newsList.size() <= 0) {
            logger.warn("从数据库查询不到任意一条新闻");
            return ERROR;
        } else {
            logger.debug("从数据库查询新闻列表成功");
            return "news";
        }
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }

}
