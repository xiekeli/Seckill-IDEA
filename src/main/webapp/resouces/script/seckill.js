/*存放主要交互逻辑*/
var seckill={
    /*封装秒杀相关Ajax的地址*/
    URL:{

    },
    /*验证手机号*/
    validataPhone:function (phone) {
        if(phone&&phone.length==11&&!isNaN(phone)){
return true;
        }else {
            return false;
        }
    },
    /*详情页秒杀逻辑*/
    detail:{
        /*详情页初始化*/
        init:function (params) {
            /*手机验证/计时*/
            /*在cookie中查找手机号*/
            var killPhone=$.cookie('killPhone');
            var seckillId=params['seckillId'];
            var seckillStartTime=params['seckillStartTime'];
            var seckillEndTime=params['seckillEndTime'];
            if(!seckill.validataPhone(killPhone)){
                /*绑定phone*/

            }
        }
    }
}