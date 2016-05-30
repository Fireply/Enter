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

public class NewsServiceTest extends BaseSpringJunit4Test {

    @Autowired
    @Qualifier("newsServiceImpl")
    private NewsService newsService;
    
    private static final Logger logger = LoggerFactory.getLogger(NewsServiceTest.class);
    
    @Test
    public void newsServiceTest() {
        String id = "en:mr-device-world";
        String title = "MR（混合现实）智能头戴显示设备全球巡展启动";
        String content = "今天上午，北京微视&国人恒宇科技在珠海德瀚国际会议中心酒店的海天一色厅举办的一场《中国首家MR(混合现实)智能头戴显示设备全球巡展启动仪式》，给众多的投资界和广大的消费行业以及各个领域的专家带来了一场别开生面的汇报及发布会，这家专门从事VR(虚拟现实)、AR(增强现实)、MR(混合现实)(以下简称3R) 等专业的人机数字交互领域的科技公司，从航天、教育、军事、体育、工业、旅游、娱乐等六大领域向我们展示了这些高科技技术对于未来的无限可能。微视图像董事长欧阳骏致开幕辞，他毕业于北京大学，在中科院自动化所做研发工作，1994年创建微视图像公司，即微视新纪元公司的前身，有20多年的技术积累，现任中国图像图形学会理事。微视图像副总经理欧阳哲作了题为“回顾历史，见证辉煌”的演讲，他是985重点大学 成都电子科技大学学霸 双学士，在视觉行业积累十年。周岩，国人恒宇CEO ，毕业于日本东京数字好莱坞大学，博士，留日8年，曾任索尼公司木原研究室从事lRC研发工作，他演讲的课题是Project Chaos卡厄斯计划。吴柳燃，中国十大策划人，整合营销传播专家，品牌战略管理专家，资深广告人，于1988年起正式踏入营销领域，数十年来经其手的营销项目尚无败笔。崇尚“四两拨千斤“的运营管理思路，已帮助多家中小企业发展、上市，取得了前所未有的佳绩。珠海这个环境美丽的城市是他们的出发站是他们此次巡展的启动仪式所在地，下一站他们将在美国的硅谷率先发布这款MR(混合现实)智能眼镜的演示内容、在此之后他们会在北京、新西兰、德国、日本先后举办盛大的巡演party与其他 3R 友商相比他们的团队实力还是相当强大的，首席科学家Mark Billinghurst教授，曾是新西兰Hitlab研究室的研究室主任，师从AR、VR领域的发起人也是MagicLeap技术的原始创立者Tom Furness教授。 发布会上他们除了开启这个启动仪式外，还展现了他们之前在国内建立的一些线下体验馆以及他们为很多行业提供的技术服务与支持的展示，并且在发布会现场有意向投资的人和机构、公司所表达的投资额总额达3亿多美金(20亿人民币)远远超过计划融资3亿人民币的额度，会后在和意向投资人进行筛选沟通。可能这也是迄今为止这个行业的最大融资比例。本稿件所含文字、图片和音视频资料，版权均属齐鲁晚报所有，任何媒体、网站或个人未经授权不得转载，违者将依法追究责任。";
        String enTitle = "MR (Mixed Reality) device world";
        String enContent = "This morning, the Beijing Microview & people Hengyu Technology at Zhuhai International Conference Center Hotel de Han sky and sea organized by the Office of a 'China's first MR (Mixed Reality) wearing a smart display device launch world tour', to many the investment community and the majority of experts in various fields of consumer industries and bring a report on the conference and a spectacular, this specialized in VR (virtual reality), AR (Augmented reality), MR (mixed reality) (hereinafter referred to as 3R) professionals such as human-computer interaction in the field of digital technology companies from the aerospace, education, military, sports, industry, tourism, entertainment and other six areas to show us these high technology for a future of unlimited possibilities. Ouyang Chun, chairman of the micro-view image opening remarks, he graduated from Beijing University, Chinese Academy of Sciences R & D work done by automation, created in 1994, as the micro-image company, Microview the predecessor company, has accumulated 20 years of technology, the current Chinese image and graphics Society. As micro-chul, deputy general manager Ouyang image made a presentation entitled 'Looking back at history, to witness the brilliant' speech, he was 985 key universities of Chengdu University of Electronic Science and Technology Studies Pa double degree in visual industry has accumulated decades. Zhou Yan, people Hengyu CEO, Japan and graduated from Tokyo Digital Hollywood University, Ph.D., in Japan for eight years, served as Sony Kihara Research Center in lRC research and development work is the subject of his speech Project Chaos Ka Esi plan. Wu Liu burning, China's top ten planning, integrated marketing communications experts, strategic brand management experts, senior advertising, in 1988 formally entered the field of marketing, decades after their hands marketing program no flaw. Advocating 'skillfully deflected the question,' the operation and management ideas, has helped a number of SMEs, market, achieved unprecedented success. Beautiful city Zhuhai this environment is their starting station of the tour is to launch their location, their next stop will be the first release of this MR (Mixed Reality) smart glasses presentations Silicon Valley in the United States, after which they will in Beijing, New Zealand, Germany, Japan has held a grand tour party compared to other vendors' 3R their team strength is still quite strong, chief scientist Professor Mark Billinghurst, who is research director of New Zealand Hitlab lab, under the tutelage of AR promoters VR field is the original founder MagicLeap art professor Tom Furness. In addition to the conference, they open this launch, but also show some lines in the country before they established their museum experience and to provide technical service and support in many sectors of the show, and at the conference site and are interested in investing institutions, the total amount of investment company expressed over more than 300 million dollars (2 billion yuan) plans to raise far more than the amount of 300 million yuan, and after the screening of people interested in investing in communication. Perhaps this is by far the largest proportion of financing the industry. The manuscript contains text, images, video and audio material, the Qilu Evening News copyright are all, any media, websites or individuals shall not be reproduced without authorization, and offenders will be prosecuted according to law.";
        Date createTime = new Date();
        
        News news = new News(id, enTitle, enContent, createTime);
        
        newsService.persist(news);
        
        List<News> newsList = newsService.getAllNews();
        
        logger.debug(newsList.toString());
        
        assertNotNull(newsList);
    }
}
