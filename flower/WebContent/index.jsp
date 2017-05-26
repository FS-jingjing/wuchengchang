<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>鲜花礼品网首页</title>
    
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
		.STYLE1 {color: #FFFFFF}
    </style>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script>
    $(function(){
 		alert(1);   	
    });
    
    </script>
</head>
  <body>
  <br>
  
  <table width="908" height="1409" border="0" align="center" cellpadding="0" cellspacing="0" class="table">
<!--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
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
     <!--  </marquee> -->
      </td>
    </tr>
<!--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
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
<!--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
    <tr>
      <td height="42" colspan="2" align="center" background="image/flower_menu_bg.jpg" class="font"><a href="#"><strong><font color="#FFFFFF">首页</font></strong></a>&nbsp;&nbsp; | &nbsp;&nbsp;<a href="FlowerListServlet?type=0"><strong><font color="#FFFFFF">鲜花</font></strong></a> &nbsp;&nbsp;|&nbsp; &nbsp;<a href="FlowerListServlet?type=1"><strong><font color="#FFFFFF">蛋糕</font></strong></a>&nbsp; &nbsp;|&nbsp;&nbsp; <a href="FlowerListServlet?type=2"><strong><font color="#FFFFFF">礼篮</font></strong></a>&nbsp;&nbsp; | &nbsp;&nbsp;<a href="FlowerListServlet?type=3"><strong><font color="#FFFFFF">绿植花卉</font></strong></a> &nbsp;&nbsp;| &nbsp;&nbsp;<a href="FlowerListServlet?type=4"><strong><font color="#FFFFFF">商务鲜花</font></strong></a> &nbsp;&nbsp;| &nbsp;&nbsp;<a href="#"><strong><font color="#FFFFFF">自选鲜花</font></strong></a> &nbsp;&nbsp;| &nbsp;&nbsp;<a href="#"><strong><font color="#FFFFFF">在线留言</font></strong></a> &nbsp;&nbsp;|&nbsp; <a href="AdminLoginServlet">&nbsp;<strong><font color="#FFFFFF">后台管理</font></strong></a></td>
    </tr>
<!--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
    <tr>
      <td height="152" colspan="2" align="center"><table width="820" height="152" border="0" cellpadding="0" cellspacing="0" style="margin:5px auto auto auto">
        <tr>
          <td height="152"><img src="image/20099146528.jpg" width="908" height="152"></td>
        </tr>
      </table></td>
    </tr>
<!--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->    
    <tr>
      <td height="942" colspan="2" valign="top"><table width="909" height="875" border="0" cellpadding="0" cellspacing="0" style="margin:4px auto auto auto">
        <tr>
          <td width="241" height="875" align="center" valign="top" class="border" >
          <table width="233" height="911" border="0" cellpadding="0" cellspacing="0" bgcolor="#FFF7F7" style="margin:10px auto auto auto">
              <tr>
                <td colspan="3">&nbsp;</td>
              </tr>
              <tr>
                <td width="22" height="9" align="right"><img src="image/dh1.gif" width="9" height="38"></td>
                <td width="192" align="center" bgcolor="#FFC8C8"><strong class="font"><font color="#FF6600">近期特色推荐</font></strong></td>
                <td width="19" align="left"><img src="image/dh2.gif" width="9" height="38"></td>
              </tr>
              <tr>
                <td height="87" align="right">&nbsp;</td>
                <td width="192" align="center" class="font"><a href="#"><br>
                  友情礼物</a> <a href="#">爱情礼物</a><br>
                  <br>
                  <a href="#">亲情礼物</a> <a href="#">节日礼物</a><br>
                  <br>
                  <a href="FlowerListServlet?type=1">生日礼物</a> ........<br>
                  <br>
                  <a href="#"><font color="#FF0000">中秋礼品</font></a> <span class="STYLE1">........</span></td>
                <td width="19" align="left">&nbsp;</td>
              </tr>
              <tr>
                <td height="28" colspan="3">&nbsp;</td>
              </tr>
              <tr>
                <td height="54" colspan="3" align="center"><img src="image/1.jpg" width="223" height="40"></td>
              </tr>
              <tr>
                <td height="52" colspan="3" align="center"><img src="image/2.jpg" width="223" height="40"></td>
              </tr>
              <tr>
                <td height="46" colspan="3" align="center"><img src="image/4.jpg" width="223" height="40"></td>
              </tr>
              <tr>
                <td height="57" colspan="3" align="center"><img src="image/3.jpg" width="223" height="40"></td>
              </tr>
              <tr>
                <td colspan="3" align="center"><img src="image/5.jpg" width="223" height="40"></td>
              </tr>
              <tr>
                <td height="88" colspan="3" align="center"><img src="image/400.gif" width="177" height="47"></td>
              </tr>
              <tr>
                <td height="8" colspan="3" align="center">&nbsp;</td>
              </tr>
              <tr>
                <td height="38" align="right"><img src="image/dh1.gif" width="9" height="38"></td>
                <td align="center" bgcolor="#FFC8C8"><strong class="font"><font color="#FF6600">支付渠道</font></strong></td>
                <td align="left"><img src="image/dh2.gif" width="9" height="38"></td>
              </tr>
              <tr>
                <td colspan="3" align="center" valign="top"><p><br>
                        <img src="image/bank1.jpg" width="111" height="33"><br>
                        <br>
                        <img src="image/bank3.jpg" width="130" height="33"><br>
                        <br>
                        <img src="image/bank5.jpg" width="130" height="33"><br>
                        <br>
                        <img src="image/bank2.gif" width="111" height="33"><br>
                        <br>
                        <img src="image/bank6.jpg" width="130" height="33"><br>
                        <br>
                        <img src="image/bank7.jpg" width="123" height="40"></p></td>
              </tr>
          </table>
          </td>
          
          <td width="667" valign="top"><table width="667" border="0" align="right" cellpadding="0" cellspacing="0" style="margin:10px 2px auto auto">
              <tr>
                <td width="676" height="467" align="right" valign="top"><table width="664" height="459" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="10" rowspan="3"><img src="image/xian_left.jpg" width="10" height="456"></td>
                      <td width="231" height="35"><img src="image/xian_top1.jpg" width="231" height="35"></td>
                      <td width="339" background="image/xian_top2.jpg">&nbsp;</td>
                      <td width="64"><a href="FlowerListServlet?type=0"><img src="image/xian_top3.jpg" width="64" height="34" border="0"></a></td>
                      <td width="20" rowspan="3" valign="top"><img src="image/xian_right.jpg" width="19" height="453"></td>
                    </tr>
                    <tr>
                      <td height="397" colspan="3" align="center" valign="middle">
                      	<table width="200" border="0" cellpadding="0" cellspacing="0">
                      	 <c:forEach items="${reFlower}" var="fl" varStatus="count">
                            <c:if test="${count.index%4==0}">
                              <tr>                          
                              </c:if>        
                            	<td>
                            	<table width="153" height="181" border="0" cellpadding="0" cellspacing="0">
	                              	<tr>
		                                <td width="146" align="center">
		                                	<a href="FlowerDetailsServlet?flowerId=${fl.flowerId}"><img src="image/${fl.flowerImage}" width="136" height="146" border="0"></a><br>
		                                  	<span class="font"><a href="FlowerDetailsServlet?flowerId=${fl.flowerId}">${fl.flowerName}<br>
		                                  	<font color="#FF0000">热卖价：￥${fl.currentPrice}</font></a></span>
		                                </td>
	                              	</tr>
                           		</table>
                            </td>
                             <c:if test="${count.index%4==3}">
                              </tr>
                            </c:if>
                          </c:forEach>
                      </table></td>
                    </tr>
                    <tr>
                      <td height="27" colspan="3"><img src="image/xian_bottom.jpg" width="632" height="23"></td>
                    </tr>
                </table></td>
              </tr>
              <tr>
                <td height="222" align="right" valign="top"><table width="661" height="190" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="53" rowspan="3"><a href="FlowerListServlet?type=1"><img src="image/dan_left.jpg" width="53" height="205" border="0"></a></td>
                      <td height="21" background="image/dan_top.jpg">&nbsp;</td>
                      <td width="24" rowspan="3" valign="top"><img src="image/dan_right.jpg" width="22" height="205"></td>
                    </tr>
                    <tr>
                      <td height="142"><table  border="0" cellpadding="0" cellspacing="0">
                          <c:forEach items="${xinCake}" var="fl" varStatus="count">
                            <c:if test="${count.index%4==0}">
                              <tr>                                   </c:if>
                            <td><table width="142" height="147" border="0" cellpadding="0" cellspacing="0">
                              <tr>
                                <td width="153" height="138" align="center"><a href="FlowerDetailsServlet?flowerId=${fl.flowerId}"><img src="image/${fl.flowerImage}" width="133" height="110" border="0"></a><br>
                                  <span class="font"><a href="FlowerDetailsServlet?flowerId=${fl.flowerId}">${fl.flowerName}<br>
                                  <font color="#FF0000">现价：￥${fl.currentPrice}</font></a></span></td>
                              </tr>
                            </table></td>
                              <c:if test="${count.index%4==3}">
                              </tr>
                            </c:if>
                          </c:forEach>
                      </table></td>
                    </tr>
                    <tr>
                      <td height="27" background="image/dan_bottom1.jpg"><a href="#"></a></td>
                    </tr>
                </table></td>
              </tr>
              <tr>
                <td height="216" align="right" valign="top"><table width="661" height="211" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="28" rowspan="3"><img src="image/shi_left.jpg" width="28" height="211"></td>
                      <td width="202" height="34"><img src="image/shi_top.jpg" width="202" height="33"></td>
                      <td width="334" background="image/shi_top1.jpg">&nbsp;</td>
                      <td width="80"><a href="FlowerListServlet?type=2"><img src="image/shi_top3.jpg" width="80" height="34" border="0"></a></td>
                      <td width="17" rowspan="3" valign="top"><img src="image/shi_right1.jpg" width="17" height="207"></td>
                    </tr>
                    <tr>
                      <td height="149" colspan="3" align="center"><table  border="0" cellpadding="0" cellspacing="0">
                          <c:forEach items="${xinLiLan}" var="fl" varStatus="count">
                            <c:if test="${count.index%4==0}">
                              <tr>                                   </c:if>
                            <td><table width="153" height="146" border="0" cellpadding="0" cellspacing="0">
                              <tr>
                                <td width="153" height="146" align="center"><a href="FlowerDetailsServlet?flowerId=${fl.flowerId}"><img src="image/${fl.flowerImage}" width="133" height="110" border="0"></a><br>
                                  <span class="font"><a href="FlowerDetailsServlet?flowerId=${fl.flowerId}">${fl.flowerName}<br>
                                  <font color="#FF0000">现价：￥${fl.currentPrice}</font></a></span></td>
                              </tr>
                            </table></td>
                              <c:if test="${count.index%4==3}">
                              </tr>
                            </c:if>
                           </c:forEach>
                      </table></td>
                    </tr>
                    <tr>
                      <td height="13" colspan="3"><img src="image/shi_bottom.jpg" width="616" height="27"></td>
                    </tr>
                </table></td>
              </tr>
          </table></td>
        </tr>
      </table></td>
    </tr>
<!--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->    
    <tr>
      <td height="14" colspan="2" background="image/a.jpg">&nbsp;</td>
    </tr>
<!--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->    
    <tr>
      <td height="187" colspan="2"><table width="864" border="0" align="center" cellpadding="0" cellspacing="0" class="font">
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
<!--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->    
  </table>
  </body>
</html>
