package org.fireply.enter.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.fireply.enter.model.News;
import org.fireply.enter.service.NewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller
public class NewsAction extends ActionSupport implements RequestAware, SessionAware {

    @Autowired
    @Qualifier("newsServiceImpl")
    private NewsService newsService;
    
    private Map<String, Object> request;
    private Map<String, Object> session;
    
    private List<News> newsList;    // 请求新闻列表时将数据库查询结果存放在 newsList
    private String newsId;          // 请求新闻详情时传递过来的 id
    private News news;              // 请求新闻详情时将数据库查询结果存放在 news
    
    private static final Logger logger = LoggerFactory.getLogger(NewsAction.class);
    
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
    
    public String detail() throws Exception {
        news = newsService.getNews(newsId);
        if (news == null) {
            logger.warn("从数据库查询 id={} 的新闻失败", newsId);
            return ERROR;
        } else {
            logger.debug("从数据库查询到了 id={} 的新闻", newsId);
            return "news-detail";
        }
    }

    @Override
    public void setRequest(Map<String, Object> request) {
        this.request = request;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

}
