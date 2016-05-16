package org.fireply.enter.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Spring 与 Junit 测试基类，指定 Spring 配置文件路径及 Junit4 测试运行器
 * @author Fireply
 * @version 1.00
 * @date 2016年5月13日 下午7:23:16
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext.xml")
public abstract class BaseSpringJunit4Test {

}
