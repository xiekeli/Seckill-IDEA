package com.seckill.web;

import com.seckill.dto.SeckillExcution;
import com.seckill.dto.SeckillExposer;
import com.seckill.dto.SeckillResult;
import com.seckill.entity.Seckill;
import com.seckill.enums.SeckillStateEnum;
import com.seckill.exception.SeckillCloseException;
import com.seckill.exception.SeckillRepeatException;
import com.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/*url:/模块/资源/{id}/细分*/
@Controller
@RequestMapping("/seckill")
public class SeckillController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SeckillService seckillService;

    /*获取列表*/
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        List<Seckill> seckillList = seckillService.getSeckillList();
        model.addAttribute("seckillList", seckillList);
        return "list";
    }

    /*获取详情*/
    @RequestMapping(value = "/{seckillId}/detail", method = RequestMethod.GET)
    public String detail(@PathVariable("seckillId") Long seckillId, Model model) {
        if (seckillId == null) {
            return "redirect:/seckill/list";
        }
        Seckill seckill = seckillService.getSeckillById(seckillId);
        if (seckill == null) {
            return "forward:/seckill/list";
        }
        model.addAttribute("secill", seckill);
        return "detail";
    }

    /*Ajax Json*/
    @RequestMapping(value = "/{seckillId}/exposer", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SeckillResult<SeckillExposer> exposer(Long seckillId) {
        SeckillResult<SeckillExposer> result = null;
        try {
            SeckillExposer exposer = seckillService.exportSeckillUrl(seckillId);
            result = new SeckillResult<SeckillExposer>(true, exposer);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result = new SeckillResult<SeckillExposer>(false, e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "/{seckillId}/{md5}/excution", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SeckillResult<SeckillExcution> excution(@PathVariable("seckillId") Long seckillId, @CookieValue(value = "killPhone", required = false) Long seckillUserPhone, @PathVariable("md5") String md5) {
        if (seckillUserPhone == null) {
            return new SeckillResult<SeckillExcution>(false, "未注册！");
        }
        try {
            SeckillExcution excution = seckillService.executeSeckill(seckillId, seckillUserPhone, md5);
            return new SeckillResult<SeckillExcution>(true, excution);
        } catch (SeckillCloseException e) {
            SeckillExcution excution = new SeckillExcution(seckillId, SeckillStateEnum.END);
            return new SeckillResult<SeckillExcution>(false, excution);
        } catch (SeckillRepeatException e) {
            SeckillExcution excution = new SeckillExcution(seckillId, SeckillStateEnum.REPEAT_KILL);
            return new SeckillResult<SeckillExcution>(false, excution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            SeckillExcution excution = new SeckillExcution(seckillId, SeckillStateEnum.INNER_ERROR);
            return new SeckillResult<SeckillExcution>(false, excution);
        }
    }

    @RequestMapping(value = "/time/now", method = RequestMethod.GET)
    public SeckillResult<Long> time() {
        Date now = new Date();
        return new SeckillResult(true, now.getTime());
    }
}
