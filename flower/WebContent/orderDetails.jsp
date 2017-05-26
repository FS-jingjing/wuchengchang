<%@ page language="java"  pageEncoding="utf-8"%>
<%@ include file="check.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>订单详情</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

    <link href="CSS/style.css" rel="stylesheet" type="text/css">
    <style type="text/css">
<!--
.STYLE2 {
	color: #FFFFFF;
	font-size: 9px;
}
-->
    </style>
</head>
  
  <body>
  <table width="908" height="868" border="0" align="center" cellpadding="0" cellspacing="0" class="table">
    <tr>
      <td width="272" height="66" rowspan="2"><img src="image/flower_logo.jpg" width="210" height="66"></td>
      <td width="637" height="31" align="right" valign="middle" class="font">
      <!-- <marquee direction="left" scrolldelay="150" onMouseOver="this.stop()" onMouseOut="this.start()"> -->
      <c:if test="${login==null}">
        购买商品请先登录，您尚未【<a href="login.jsp"><font color="#3300FF">登录</font></a>】 || 【<a href="register.jsp"><font color="#3300FF">注册</font></a>】 
      </c:if>
      <c:if test="${login!=null}">
      中国鲜花礼品网欢迎您：【<font color="blue">${login.userName }</font>】 || 【<a href="AdminExitServlet"><font color="blue">退出登录</font></a>】
      </c:if>
      <!-- </marquee> -->
      </td>
    </tr>
    <tr>
      <td height="13" align="right" valign="bottom"><table width="407" height="23" border="0" cellpadding="0" cellspacing="0" style="margin:auto 10px 10px auto">
        <tr>
          <td width="53" height="23"><img src="image/flower_title_05.gif" width="53" height="23"></td>
          <td width="85" align="center" background="image/flower_title_bg.gif" class="font"><a href="login.jsp">我的帐户</a></td>
          <td width="85" align="center" background="image/flower_title_bg.gif" class="font"><a href="MyOrderServlet">订单查询</a></td>
          <td width="85" align="center" background="image/flower_title_bg.gif" class="font"><a href="#">帮助中心</a></td>
          <td width="85" align="center" background="image/flower_title_bg.gif" class="font"><a href="ShopCartServlet?type=0">购物车</a></td>
          <td width="14"><img src="image/flower_title_06.gif" width="11" height="23"></td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td height="44" colspan="2" align="center" background="image/flower_menu_bg.jpg" class="font"><a href="#"><strong><font color="#FFFFFF">首页</font></strong></a>&nbsp;&nbsp; | &nbsp;&nbsp;<a href="FlowerListServlet?type=0"><strong><font color="#FFFFFF">鲜花</font></strong></a> &nbsp;&nbsp;|&nbsp; &nbsp;<a href="FlowerListServlet?type=1"><strong><font color="#FFFFFF">蛋糕</font></strong></a>&nbsp; &nbsp;|&nbsp;&nbsp; <a href="FlowerListServlet?type=2"><strong><font color="#FFFFFF">礼篮</font></strong></a>&nbsp;&nbsp; | &nbsp;&nbsp;<a href="FlowerListServlet?type=3"><strong><font color="#FFFFFF">绿植花卉</font></strong></a> &nbsp;&nbsp;| &nbsp;&nbsp;<a href="FlowerListServlet?type=4"><strong><font color="#FFFFFF">商务鲜花</font></strong></a> &nbsp;&nbsp;| &nbsp;&nbsp;<a href="#"><strong><font color="#FFFFFF">自选鲜花</font></strong></a> &nbsp;&nbsp;| &nbsp;&nbsp;<a href="#"><strong><font color="#FFFFFF">在线留言</font></strong></a> &nbsp;&nbsp;|&nbsp; <a href="AdminLoginServlet">&nbsp;<strong><font color="#FFFFFF">后台管理</font></strong></a></td>
    </tr>
    <tr>
      <td colspan="2" align="center" bgcolor="#FFFFFF"><span class="STYLE2">.</span></td>
    </tr>
    <tr>
      <td colspan="2" align="center"><img src="image/banner_member.gif" width="908" height="150"></td>
    </tr>
    <tr>
      <td height="31" colspan="2" background="image/banner_bg1.gif"><table width="912" height="31" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td width="189" height="31" background="image/banner_bg.gif">&nbsp; &nbsp; &nbsp;<span class="font">中国鲜花礼品网</span></td>
          <td width="721" background="image/banner_bg1.gif"><strong><font color="#FF9900">&gt;&gt;</font></strong><span class="font">订单信息</span></td>
        </tr>
      </table></td>
    </tr>
    
    <tr>
      <td height="31" colspan="2" >&nbsp;<a href="CheckOrderServlet?type=update"><img width="11" height="5" src="image/lxq_060208.gif" border="0"></a><span class="font"><a href="CheckOrderServlet?type=update">返回</a></span></td>
    </tr>
    <tr>
      <td height="373" colspan="2"  align="center"><table width="798" height="362" border="0" cellpadding="3" cellspacing="1" bgcolor="#C2C2C2">
        <tr>
          <td height="147" bgcolor="#FFFFFF" class="font">&nbsp;<font color="#F97C00"><strong>购买人资料<br>
            <br>
          &nbsp;</strong></font>·购买人姓名：${orders.userName}<br>
            <br>
          <font color="#F97C00"><strong>&nbsp;</strong></font>·购买人电话：${orders.mobilPhone}<br>
          <font color="#F97C00"><strong><br>
          &nbsp;</strong></font>·购买人电子邮件：${orders.email}<br>
          <font color="#F97C00"><strong> <br>
          &nbsp;</strong></font>·购买人所在省/市/区：${orders.province}${orders.city}<br>
          <font color="#F97C00"><strong><br>
          &nbsp;</strong></font>·购买人地址：${orders.address}</td>
        </tr>
        <tr>
          <td height="131" align="center" bgcolor="#FFFFFF"><table width="779" height="114" border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td width="728" height="85"><table width="782" height="84"  border="0" cellpadding="2" cellspacing="1" bgcolor="#8BC53D">
                <tr>
                  <td height="27" colspan="5" align="center" class="font"><strong>订单详细信息</strong></td>
                  </tr>
                <tr>
                  <td width="160" align="center" bgcolor="#EAEAEA" class="font">商品名称</td>
                  <td width="148" align="center" bgcolor="#EAEAEA" class="font">市场价</td>
                  <td width="150" align="center" bgcolor="#EAEAEA" class="font">会员价</td>
                  <td width="150" align="center" bgcolor="#EAEAEA" class="font">发货数量</td>
                  <td width="147" align="center" bgcolor="#EAEAEA" class="font">小计</td>
                </tr>
                <c:forEach items="${cart}" var="flower">
                <c:set var="tMoney" value="${totalMoney}"></c:set>
                <tr>
                  <td align="center" bgcolor="#FFFFFF" class="font">${flower.value.flowerName}</td>
                  <td align="center" bgcolor="#FFFFFF" class="font">￥${flower.value.price }元</td>
                  <td align="center" bgcolor="#FFFFFF" class="font">￥${flower.value.currentPrice }元</td>
                  <td align="center" bgcolor="#FFFFFF" class="font">${flower.value.count }</td>
                  <td align="center" bgcolor="#FFFFFF" class="font">￥${flower.value.currentPrice*flower.value.count }元</td>
                </tr>
                <c:set var="totalMoney" value="${tMoney+flower.value.currentPrice*flower.value.count}"></c:set>
                </c:forEach>
              </table></td>
            </tr>
            <tr>
              <td align="right" class="font">商品金额总计：￥${totalMoney}元</td>
            </tr>
            <c:set var="money" value="${totalMoney}" scope="session"></c:set>
            <c:remove var="totalMoney"/>
          </table>          </td>
        </tr>
        <tr>
          <td height="41" align="center" bgcolor="#FFFFFF"><a href="OrderDetailsServlet"><img src="image/04shop_checkout.gif" width="200" height="29" border="0"></a></td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td height="16" colspan="2" background="image/a.jpg">&nbsp;</td>
    </tr>
    <tr>
      <td height="155" colspan="2"><br>
        <table width="883" border="0" align="center" cellpadding="0" cellspacing="0" class="font">
          <tr>
            <td height="29" colspan="2" align="center" valign="middle"><hr width="100%" size="2" color="#666666"/>
              全国订购热线:<strong>400-889-8188</strong>(只收市话费) </td>
          </tr>
          <tr>
            <td height="12" colspan="2" align="center" valign="middle">总部:0755-88855678 北京:010-51292292 上海:021-51691892 广州:020-61137892 </td>
          </tr>
          <tr>
            <td width="533" height="14" align="right" valign="middle">客服时间：8:30-20:30&nbsp;<img src="image/email_home.gif" width="169" height="9">&nbsp;</td>
            <td width="350" align="left" valign="middle"><img src="image/kf2on.gif" width="70" height="17"></td>
          </tr>
          <tr>
            <td height="15" colspan="2" align="center" valign="middle">百易-Buy Easy,让您购物更容易！国内专业鲜花速递服务商--网上花店、鲜花店连锁第一品牌！ </td>
          </tr>
          <tr>
            <td height="15" colspan="2" align="center" valign="middle">·<A href="http://www.flowercn.com/profile/ChinaFlowerAssociation.htm" target="_blank">中国花卉协会会员</A> ·<A href="http://www.flowercn.com/profile/chinaECA.htm" target="_blank">中国电子商务协会会员</A> ·<A href="http://www.flowercn.com/profile/ICP.htm" target="_blank">ICP经营许可证：粤B2-20050744</A></td>
          </tr>
          <tr>
            <td height="15" colspan="2" align="center" valign="middle"><img src="image/visa_ver.jpg" width="75" height="41">&nbsp;&nbsp;&nbsp;&nbsp;<img src="image/gongshang_biaoshi.gif" width="35" height="43">&nbsp;&nbsp;&nbsp;&nbsp;<img src="image/TOP100.gif" width="135" height="41"></td>
          </tr>
          <tr>
            <td height="15" colspan="2" align="center" valign="middle">Copyright &copy;2005-2009 <A href="#/">中国鲜花礼品网-www.FlowerCN.com</A>, All Rights   Reserved </td>
          </tr>
      </table></td>
    </tr>
  </table>
  <br>
  </body>
</html>
