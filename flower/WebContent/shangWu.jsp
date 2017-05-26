<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>商务鲜花</title>
    
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
.STYLE1 {
	color: #FFFFFF;
	font-size: 9px;
}
-->
    </style>
</head>
  
  <body>
  <table width="912" height="693" border="0" align="center" cellpadding="0" cellspacing="0" class="table">
    <tr>
      <td width="272" height="66" rowspan="2"><img src="image/flower_logo.jpg" width="210" height="66"></td>
      <td width="637" height="31" align="right" valign="middle" class="font">
     <!--  <marquee direction="left" scrolldelay="150" onMouseOver="this.stop()" onMouseOut="this.start()"> -->
      <c:if test="${login==null}">
        购买商品请先登录，您尚未【<a href="login.jsp"><font color="#3300FF">登录</font></a>】 || 【<a href="register.jsp"><font color="#3300FF">注册</font></a>】 
      </c:if>
      <c:if test="${login!=null}">
      中国鲜花礼品网欢迎您：【<font color="blue">${login.userName }</font>】 || 【<a href="AdminExitServlet"><font color="blue">退出登录</font></a>】
      </c:if>
     <!--  </marquee> -->
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
      <td colspan="2" align="center"><span class="STYLE1">.</span></td>
    </tr>
    <tr>
      <td colspan="2" align="center"><img src="image/shangWu.jpg" width="908" height="152"></td>
    </tr>
    <tr>
      <td height="31" colspan="2"><table width="912" height="31" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td width="189" height="31" background="image/banner_bg.gif">&nbsp; &nbsp; &nbsp;<span class="font">中国鲜花礼品网</span></td>
            <td width="721" background="image/banner_bg1.gif"><strong><font color="#FF9900">&gt;&gt;</font></strong><span class="font">商务鲜花</span></td>
          </tr>
      </table></td>
    </tr>
    <tr>
      <td height="240" colspan="2"><table height="82" border="0" cellpadding="0" cellspacing="0" style="margin:5px 5px 5px 5px">
          <c:forEach items="${flowerList}" var="shangwu" varStatus="count">
            <c:if test="${count.index%5==0}">
            <tr>            </c:if>
            <td width="180" align="center"><table width="180" height="207" border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td width="180" height="141" align="center"><a href="FlowerDetailsServlet?flowerId=${shangwu.flowerId}"><img src="image/${shangwu.flowerImage}" width="117" height="130" border="0"></a></td>
              </tr>
              <tr>
                <td align="center" class="font"><a href="">${shangwu.flowerName}</a></td>
              </tr>
              <tr>
                <td align="center" class="font">市场价：￥${shangwu.price}</td>
              </tr>
              <tr>
                <td align="center" class="font">现价：<font color="red">￥${shangwu.currentPrice}</font></td>
              </tr>
              <tr>
                <td align="center" ><table width="150" height="11" border="0" cellpadding="0" cellspacing="0" background="image/product_under_bg.gif">
                  <tr>
                    <td  width="120" align="center"></td>
                  </tr>
                </table></td>
              </tr>
              <tr>
                <td align="center"><a href="ShopCartServlet?flowerId=${shangwu.flowerId}"><img src="image/shop.gif" width="40" height="17" border="0"></a>&nbsp; <a href="FlowerDetailsServlet?flowerId=${shangwu.flowerId}"><img src="image/details.gif" width="40" height="17" border="0"></a></td>
              </tr>
            </table></td>
              <c:if test="${count.index%5==4}">
              </tr>
            </c:if>
          </c:forEach>
      </table></td>
    </tr>
    <tr>
      <td colspan="3" align="right" class="font"><c:if test="${page==1}"> 上一页 </c:if>
          <c:if test="${page>1}"> <a href="FlowerListServlet?types=shang&type=4">上一页</a> </c:if>
        |
        <c:if test="${page==pageSum}"> 下一页 </c:if>
        <c:if test="${page<pageSum}"> <a href="FlowerListServlet?types=xia&type=4">下一页 </a> </c:if>
        当前第<font color="red">${page}</font>页 共${pageSum}页&nbsp;&nbsp;&nbsp; </td>
    </tr>
    <tr>
      <td colspan="2" background="image/a.jpg">&nbsp;</td>
    </tr>
    <tr>
      <td colspan="2"><table width="864" border="0" align="center" cellpadding="0" cellspacing="0" class="font">
          <tr>
            <td height="29" colspan="2" align="center" valign="middle"><hr width="100%" size="2" color="#666666"/>
              全国订购热线:<strong>400-889-8188</strong>(只收市话费) </td>
          </tr>
          <tr>
            <td height="12" colspan="2" align="center" valign="middle">总部:0755-88855678 北京:010-51292292 上海:021-51691892 广州:020-61137892 </td>
          </tr>
          <tr>
            <td width="590" height="14" align="right" valign="middle">客服时间：8:30-20:30&nbsp;<img src="image/email_home.gif" width="169" height="9">&nbsp;</td>
            <td width="370" align="left" valign="middle"><img src="image/kf2on.gif" width="70" height="17"></td>
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
