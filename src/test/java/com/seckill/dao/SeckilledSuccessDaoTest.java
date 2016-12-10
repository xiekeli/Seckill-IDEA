package com.seckill.dao;

import com.seckill.entity.SeckilledSuccess;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;



/**
 * 配置spring和junit整合，使junit启动时加载springIOC容器
 */
@RunWith(SpringJUnit4ClassRunner.class)
/*为junit提供spring配置文件*/
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckilledSuccessDaoTest {
    /*注入Dao实现类依赖*/
    @Resource
    private SeckilledSuccessDao seckilledSuccessDao;

    @Test
    public void insertSeckilledSuccess() throws Exception {

        long id = 1000L;
        long phone = 13582821515L;
        System.out.println(id + " " + phone);
        int insert = seckilledSuccessDao.insertSeckilledSuccess(id, phone);
        System.out.println(insert);
    }

    @Test
    public void queryByIdWithSeckill() throws Exception {
        long id = 1000L;
        long phone = 13582821515L;
        SeckilledSuccess seckilledSuccess = seckilledSuccessDao.queryByIdWithSeckill(id, phone);
        System.out.println(seckilledSuccess);
        System.out.println(seckilledSuccess.getSeckill());
    }

}