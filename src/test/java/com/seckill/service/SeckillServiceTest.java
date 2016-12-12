package com.seckill.service;

import com.seckill.dto.SeckillExcution;
import com.seckill.dto.SeckillExposer;
import com.seckill.entity.Seckill;
import com.seckill.exception.SeckillCloseException;
import com.seckill.exception.SeckillRepeatException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class SeckillServiceTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SeckillService seckillService;

    @Test
    public void getSeckillList() throws Exception {
        List<Seckill> seckillList = seckillService.getSeckillList();
        logger.info("list={}", seckillList);
    }

    @Test
    public void getSeckillById() throws Exception {
        long id = 1000;
        Seckill seckill = seckillService.getSeckillById(id);
        logger.info("seckill={}", seckill);
    }

    @Test
    public void exportSeckillUrl() throws Exception {
        long id = 1000;
        SeckillExposer seckillExposer = seckillService.exportSeckillUrl(id);
        logger.info("seckillExposer={}", seckillExposer);
        /*exposer=true, md5='03ecb8a5252ddd438365c62aaadb3b46', seckillId=1000*/
    }

    @Test
    public void executeSeckill() throws Exception {
        long id = 1000;
        long phone = 15600008887L;
        String md5 = "03ecb8a5252ddd438365c62aaadb3b46";
        try {
            SeckillExcution seckillExcution = seckillService.executeSeckill(id, phone, md5);
            logger.info("seckillExcution={}", seckillExcution);
        } catch (SeckillCloseException e) {
            logger.error(e.getMessage());
        } catch (SeckillRepeatException e) {
            logger.error(e.getMessage());
        }
    }

    /*可重复执行的集成测试完整逻辑*/
    @Test
    public void testSeckill() throws Exception {
        long id = 1000;
        SeckillExposer seckillExposer = seckillService.exportSeckillUrl(id);
        if (seckillExposer.isExposer()) {
            logger.info("seckillExposer={}", seckillExposer);
            long phone = 15600008887L;
            String md5 = seckillExposer.getMd5();
            try {
                SeckillExcution seckillExcution = seckillService.executeSeckill(id, phone, md5);
                logger.info("seckillExcution={}", seckillExcution);
            } catch (SeckillCloseException e) {
                logger.error(e.getMessage());
            } catch (SeckillRepeatException e) {
                logger.error(e.getMessage());
            }
        } else {
            /*秒杀未开启*/
            logger.warn("seckillExposer={}", seckillExposer);
        }

        /*exposer=true, md5='03ecb8a5252ddd438365c62aaadb3b46', seckillId=1000*/
    }
}