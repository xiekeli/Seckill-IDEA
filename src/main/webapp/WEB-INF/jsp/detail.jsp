<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入jstl--%>
<%@include file="common/tag.jsp"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <title>秒杀详情页</title>
    <%--引入bootstrap--%>
    <%@include file="common/head.jsp"%>
</head>
<body>
<div class="container">
    <div class="panel panel-default text-center">
        <div class="panel-heading">
            <h1>${seckill.seckillName}</h1>
        </div>
    </div>
</div>
<%--jquery插件--%>
<script src="http://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
<%--bootstrap插件--%>
<script src="http://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<%--jquery cookie插件--%>
<script src="http://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<%--jquery 倒计时插件--%>
<script src="http://cdn.bootcss.com/jquery-countdown/2.0.2/jquery.countdown.min.js"></script>
<script src="/resouces/script/seckill.js" type="text/javascript"></script>
<script type="text/javascript">
    $(function () {
        /*使用EL表达式传入参数*/
        seckill.detail.init({
            seckillId:${seckill.seckillId},
            /*转化毫秒*/
            seckillStartTime:${seckill.seckillStartTime.time},
            seckillEndTime:${seckill.seckillEndTime.time}
        });
    });
</script>
</body>
</html>
