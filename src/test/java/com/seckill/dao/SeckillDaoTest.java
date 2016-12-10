package com.seckill.dao;

import com.seckill.entity.Seckill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 配置spring和junit整合，使junit启动时加载springIOC容器
 */
@RunWith(SpringJUnit4ClassRunner.class)
/*为junit提供spring配置文件*/
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {
    /*注入Dao实现类依赖*/
    @Resource
    private SeckillDao seckillDao;

    @Test
    public void reduceNumber() throws Exception {
        Date killTime = new Date();
        int killNumber = seckillDao.reduceNumber(1001L, killTime);
        System.out.println(killNumber);
    }

    @Test
    public void queryById() throws Exception {
        long id = 1000;
        Seckill seckill = seckillDao.queryById(id);
        System.out.println(seckill.getSeckillName());
        System.out.println(seckill);
    }

    @Test
    public void queryAll() throws Exception {
        List<Seckill> seckillList = seckillDao.queryAll(0, 4);
        for (Seckill seckill : seckillList) {
            System.out.println(seckill);
        }
    }

}