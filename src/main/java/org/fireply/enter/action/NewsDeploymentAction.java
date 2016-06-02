package org.fireply.enter.action;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.fireply.enter.model.News;
import org.fireply.enter.service.NewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import com.opensymphony.xwork2.ActionSupport;

@Controller
public class NewsDeploymentAction extends ActionSupport implements ServletRequestAware {

    @Autowired
    @Qualifier("newsServiceImpl")
    private NewsService newsService;
    
    private HttpServletRequest request;
    
    private String newsTitle;
    private String newsContent;
    private String adminId;
    
    private MultipartFile file;
    private InputStream filePath;
    
    private static final Logger logger = LoggerFactory.getLogger(NewsDeploymentAction.class);
    
    @Override
    public String input() throws Exception {
        logger.debug("I am in input()");
        String path = request.getSession().getServletContext().getRealPath("/images");
        String filename = file.getOriginalFilename();
        Map<String, Object> map = new HashMap<>();
        map.put("filename", filename);
        
        File targetFile = new File(path, filename);
        
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        
        String pathStr = null;
        try {
            file.transferTo(targetFile);
            pathStr = path + filename;
            filePath = new ByteArrayInputStream(pathStr.getBytes("UTF-8"));
        } catch (Exception e) {
            logger.error("保存文件失败");
            e.printStackTrace();
            pathStr = "error";
            filePath = new ByteArrayInputStream(pathStr.getBytes("UTF-8"));
        }
        
        return "ajax";
    }

    @Override
    public String execute() throws Exception {
        logger.debug("I am in execute()");
        String path = request.getSession().getServletContext().getRealPath("/images");
        String filename = file.getOriginalFilename();
        Map<String, Object> map = new HashMap<>();
        map.put("filename", filename);
        
        File targetFile = new File(path, filename);
        
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        
        String pathStr = null;
        try {
            file.transferTo(targetFile);
            pathStr = path + filename;
            filePath = new ByteArrayInputStream(pathStr.getBytes("UTF-8"));
        } catch (Exception e) {
            logger.error("保存文件失败");
            e.printStackTrace();
            pathStr = "error";
            filePath = new ByteArrayInputStream(pathStr.getBytes("UTF-8"));
        }
        
        return "ajax";
    }
    
    public String saveFile() throws Exception {
        logger.debug("I am in saveFile()");
        String path = request.getSession().getServletContext().getRealPath("/images");
        String filename = file.getOriginalFilename();
        Map<String, Object> map = new HashMap<>();
        map.put("filename", filename);
        
        File targetFile = new File(path, filename);
        
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        
        String pathStr = null;
        try {
            file.transferTo(targetFile);
            pathStr = path + filename;
            filePath = new ByteArrayInputStream(pathStr.getBytes("UTF-8"));
        } catch (Exception e) {
            logger.error("保存文件失败");
            e.printStackTrace();
            pathStr = "error";
            filePath = new ByteArrayInputStream(pathStr.getBytes("UTF-8"));
        }
        
        return "ajax";
    }

    public String deploy() throws Exception {
        logger.debug("I am in deploy()");
        if (newsTitle == null || newsTitle.length() < 0
                || newsContent == null || newsContent.length() < 0) {
            return ERROR;
        }
        
        News news = new News(generatNewsId(), newsTitle, newsContent, new Date());
        newsService.persistNews(news);
        
        logger.debug("正在将 {} 存入数据库", news);
        
        return SUCCESS;
    }

    private String generatNewsId() {
        String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 20; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public InputStream getFilePath() {
        return filePath;
    }

    public void setFilePath(InputStream filePath) {
        this.filePath = filePath;
    }
    
}
