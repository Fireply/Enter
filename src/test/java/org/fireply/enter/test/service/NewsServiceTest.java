package org.fireply.enter.test.service;

import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.fireply.enter.model.News;
import org.fireply.enter.service.NewsService;
import org.fireply.enter.test.BaseSpringJunit4Test;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

public class NewsServiceTest extends BaseSpringJunit4Test {

    @Autowired
    @Qualifier("newsServiceImpl")
    private NewsService newsService;
    
    private static final Logger logger = LoggerFactory.getLogger(NewsServiceTest.class);
    
    @Test
    public void newsServiceTest() {
        String id = "amd-radeon-rx480";
        String title = "Radeon RX480 门槛降到 US$199";
        String content = "就当下来说，VR 的入门门槛是非常高的 -- 除了 VR 设备本身的花费之外，还需要一张 US$300 以上等级的显卡和相搭配的电脑主机才行。NVIDIA 新发布的 GTX1080 和 GTX1070 系列显卡虽然跑起 VR 来是轻松愉快，但它们定价分别在 US$600 和 US$380 的价格带，对于降低入门门槛并没有什么帮助。AMD 正是看准了这个机会，先一步推出足够推动 VR 的中价位显卡 RX480，抢占 PC VR 市场的先机。RX480 以 AMD 全新的 Polaris 架构为基础，并将推出 4GB 和 8GB RAM 的版本。除了支持 AMD 的 Freesync 和 HDR 游戏之外，它也支持 DisplayPort 1.3 / 1.4 输出。现场示范 Ashes of Sigularity 游戏时，GTX1080 跑出了 58.7fps，而 SLI 的 RX480 则是达到了 62.5 fps -- 但两张的 RX480 依然比单张的 GTX1080 还要便宜一些呢。不过，无论是定价还是单卡性能，感觉能和 RX480 对应的 NVIDIA 产品应该是还没消息的 GTX1060 才对。到时候 NVIDIA 应该会把场子找回来才是吧？";
        String enId = "xbox-re-2017";
        String enTitle = "Xbox VR coming in 2017";
        String enContent = "Boy, it's been a busy week in the world of wearable tech. We kicked things off with Fitbit's heart rate data accuracy coming under scrutiny once again. Then more images of the Samsung Gear Fit2 surfaced and then there was Pebble with not one, but three new wearables. Oh, and Jawbone might be killing its UP tracker as well.While those stories were the ones to grab the headlines, we've picked out the other wearable news blips and murmurs of the past seven days that you might have missed.This could be our most concrete evidence yet of Microsoft's virtual reality ambitions. A developer has confirmed to Arstechnica that it is working on a VR title that'll launch in 2017.The Xbox VR game is set to be shown off at this year's E3 gaming expo, which is only a couple of weeks away and adds to the speculation that Microsoft is working on a new console that's set to be more VR friendly.Sony's PlayStation VR headset is launching later this year in October, so it looks like an Xbox rival could be joining the party in the not too distant future.";
        Date createTime = new Date();
        
        News news = new News(id, title, content, createTime);
        
        newsService.persistNews(news);
        
        List<News> newsList = newsService.getAllNews();
//        logger.debug(newsList.toString());
        
        News xboxNews = newsService.getNewsById(enId);
//        logger.debug(xboxNews.toString());
        
        assertNotNull(newsList);
        assertNotNull(xboxNews);
    }
}
