<%@ page language="java"  pageEncoding="utf-8"%>
<%@ include file="check.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    <title>填写订单</title>
    
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
	color: #E17100;
	font-weight: bold;
}
.STYLE2 {
	color: #FFFFFF;
	font-size: 9px;
}
-->
    </style>
</head>
  <script type="text/javascript" src="JS/validateOrder.js">
  </script>
  <body>
  <table width="908" border="0" align="center" cellpadding="0" cellspacing="0" class="table">
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
      <td colspan="2" align="center"><span class="STYLE2">.</span></td>
    </tr>
    <tr>
      <td colspan="2" align="center"><img src="image/banner_member.gif" width="908" height="150"></td>
    </tr>
    <tr>
      <td height="31" colspan="2" background="image/banner_bg1.gif"><table width="912" height="31" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td width="189" height="31" background="image/banner_bg.gif">&nbsp; &nbsp; &nbsp;<span class="font">中国鲜花礼品网</span></td>
          <td width="721" background="image/banner_bg1.gif"><strong><font color="#FF9900">&gt;&gt;</font></strong><span class="font">订单</span></td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td height="29" colspan="2"  align="left">&nbsp;<a href="shopCart.jsp"><img width="11" height="5" src="image/lxq_060208.gif" border="0"></a><span class="font"><a href="shopCart.jsp">返回</a></span></td>
    </tr>
    <tr>
      <td height="237" colspan="2"  align="center" valign="top">
      <c:if test="${orders!=null}">
      	<form name="form1" method="post" action="OrderServlet">
        <table width="700" height="231" border="0" cellpadding="5" cellspacing="1" bgcolor="#8BC53D">
          <tr>
            <td height="28" colspan="2" align="center" class="font"><span class="STYLE1">请填写购买人资料</span></td>
          </tr>
          <tr>
            <td width="120" align="right" bgcolor="#FFFFFF" class="font">您的姓名：</td>
            <td width="555" bgcolor="#FFFFFF"><input type="text" name="name" value="${login.userName}" readonly>&nbsp;</td>
          </tr>
          <tr>
            <td align="right" bgcolor="#FFFFFF" class="font">您的邮箱：</td>
            <td bgcolor="#FFFFFF"><input type="text" name="email" value="${login.email}" readonly>&nbsp;</td>
          </tr>
          <tr>
            <td align="right" bgcolor="#FFFFFF" class="font">您的手机：</td>
            <td bgcolor="#FFFFFF"><input type="text" name="phone" value="<%-- ${orders.mobilPhone} --%>" maxlength="11"> <font color="#FF0000">*</font></td>
          </tr>
          <tr>
            <td align="right" bgcolor="#FFFFFF" class="font">您所在省份：</td>
            <td bgcolor="#FFFFFF">
			
			<select name="p"  onFocus="jilian()"onChange="jilian()">
              <option value="${orders.province } ">${orders.province }</option>
            </select>
            <font color="#FF0000">*</font></td>
          </tr>
          <tr>
            <td align="right" bgcolor="#FFFFFF" class="font">您所在城市：</td>
            <td bgcolor="#FFFFFF"><select name="city" id="city">
              <option value="${orders.city }"> ${orders.city } </option>
            </select>
            <font color="#FF0000">*</font></td>
          </tr>
          <tr>
            <td align="right" bgcolor="#FFFFFF" class="font">详细地址：</td>
            <td bgcolor="#FFFFFF"><input name="address" type="text" size="50" value="${orders.address}">
            <font color="#FF0000">*</font></td>
          </tr>
          <tr>
            <td height="31" align="right" bgcolor="#FFFFFF">&nbsp;</td>
            <td bgcolor="#FFFFFF"><a href="javascript:check()"><img src="image/04shop_next.gif" width="90" height="23" border="0"></a></td>
          </tr>
        </table>
            </form>
      </c:if>
      <c:if test="${orders==null}">
      	<form name="form1" method="post" action="OrderServlet">
        <table width="700" height="231" border="0" cellpadding="5" cellspacing="1" bgcolor="#8BC53D">
          <tr>
            <td height="28" colspan="2" align="center" class="font"><span class="STYLE1">请填写购买人资料</span></td>
          </tr>
          <tr>
            <td width="120" align="right" bgcolor="#FFFFFF" class="font">您的姓名：</td>
            <td width="555" bgcolor="#FFFFFF"><input type="text" name="name" value="${login.userName}" readonly>&nbsp;</td>
          </tr>
          <tr>
            <td align="right" bgcolor="#FFFFFF" class="font">您的邮箱：</td>
            <td bgcolor="#FFFFFF"><input type="text" name="email" value="${login.email}" readonly>&nbsp;</td>
          </tr>
          <tr>
            <td align="right" bgcolor="#FFFFFF" class="font">您的手机：</td>
            <td bgcolor="#FFFFFF">
            <input type="text" name="phone"><font color="#ff0000"> *</font></td>
          </tr>
          <tr>
            <td align="right" bgcolor="#FFFFFF" class="font">您所在省份：</td>
            <td bgcolor="#FFFFFF"><select name="p" id="p" onChange="jilian()">
              <option>选择省份</option>
              <option value="北京">北京</option>
              <option value="陕西省">陕西省</option>
              <option value="四川省">四川省</option>
              <option value="山东省">山东省</option>
              <option value="湖北省">湖北省</option>
                                                </select>
              <font color="#FF0000">*</font></td>
          </tr>
          <tr>
            <td align="right" bgcolor="#FFFFFF" class="font">您所在城市：</td>
            <td bgcolor="#FFFFFF"><select name="city" id="city">
              <option>选择城市</option>
            </select>
            <font color="#FF0000">*</font></td>
          </tr>
          <tr>
            <td align="right" bgcolor="#FFFFFF" class="font">详细地址：</td>
            <td bgcolor="#FFFFFF"><input name="address" type="text" size="50">
            <font color="#FF0000">*</font></td>
          </tr>
          <tr>
            <td height="31" align="right" bgcolor="#FFFFFF">&nbsp;</td>
            <td bgcolor="#FFFFFF"><a href="javascript:check()"><img src="image/04shop_next.gif" width="90" height="23" border="0"></a></td>
          </tr>
        </table>
       </form>
      </c:if>      </td>
    </tr>
    <tr>
      <td height="17" colspan="2" background="image/a.jpg">&nbsp;</td>
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
            <td width="343" align="left" valign="middle"><img src="image/kf2on.gif" width="70" height="17"></td>
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
