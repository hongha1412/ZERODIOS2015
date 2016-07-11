<!DOCTYPE html>
<%@page import="com.zerodios2015.VO.BaseOutVO"%>
<%@page import="com.zerodios2015.Utils.MessageProperties"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.common-controls.com/cc/tags-template" prefix="template" %>
<html xmlns="http://www.w3.org/1999/xhtml">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title><%=MessageProperties.getMessage(((BaseOutVO)request.getAttribute("outVO")).getTitle()) %></title>

        <meta http-equiv="pragma" content="no-cache" />
        <meta name="keywords" content="Zero, Zero Online, Đại Chiến Robot, Scifi, Robot, Game, Game Online" />
        <meta name="description" content="Game Online Zero - Đại chiến robot với đồ họa 2.5D được phát triển lại bởi ZeroDios team" />
        <meta http-equiv="x-ua-compatible" content="ie=7" />
        <link rel="SHORTCUT ICON" href="/images/jz426.ico" />
        <script type="text/javascript" src="/js/public.js"></script>
        <link rel="stylesheet" type="text/css" href="/css/css_120514.css" />
        <script type="text/javascript" src="/js/jquery-3.0.0.js"></script>
        <script type="text/javascript" src="/js/index_120514.js"></script>
        <link rel="stylesheet" type="text/css" href="/css/Home.css" />

        <template:get name="header" />
    </head>

    <body>
        <!--full_bg-->
        <div class="full_top" style="visibility: hidden">
            <div class="full_btm">
                <div class="wapper relative">

                    <div class="header1 relative">
                        <h1 class="logo"><script type="text/javascript">logoimg();</script></h1>
                        <nav class="nav top-menu">
                            <jsp:include page="/jsp/Include/TopMenu.jsp" />
                        </nav>
                    </div>
                        <div class="header2"></div>
                        <div class="header3"></div>

                        <div class="wapper cont">
                            <template:get name="content" />
                        </div>

                        <div class="footer">
                            <jsp:include page="/jsp/Include/Footer.jsp" />
                        </div>
                    </div>
                </div>
            </div>
            <!--full_bgEnd-->
            <!--yy float-->
            <div id="YYbar" style="position: absolute; right: 20px; top: 15%; margin-top: 0px;">
                <a href="#" target="_blank"><img src="/images/yy.png" />
                </a>
            </div>
            <script type="text/javascript">
                var scrollBar2 = function() {
                    if ($(window).width() > 1002) {
                        if ($(window).width() < 1182) {
                            $("#YYbar").css("right", 0);
                        } else {
                            $("#YYbar").css("right", 20);
                        }
                        $("#YYbar").show().stop(true).animate({
                            marginTop: $(window).scrollTop()
                        }, 600);
                    } else {
                        $("#YYbar").hide()
                    }
                }
                $(window).bind("scroll resize", scrollBar2);
            </script>
            <!--/yyfloat-->
            <script type="text/javascript">
                /*function ico(n) {
                    n = parseInt(n);
                    switch (n) {
                        case 1:
                            window.open('http://news.99.com/content/2012-12-07/20121207025758371.shtml');
                            break;
                        case 2:
                            window.open('http://yygxz.jz.99.com/');
                            break;
                        case 3:
                            window.open('http://xtphb.jz.99.com/index.aspx');
                            break;
                        case 4:
                            window.open('http://zz.shop.99.com/Pay/');
                            break;
                        case 5:
                            window.open('http://jz.99.com/guide/intro/intro.shtml');
                            break;
                        case 6:
                            window.open('http://jz.99.com/guide/intro/info.shtml');
                            break;
                        case 7:
                            window.open('http://jz.99.com/function/serv.shtml');
                            break;
                            //case 8:window.open('http://best.17173.com/2012/11/guinness1129/index.php');break;
                        case 9:
                            window.open('http://jz.top.99.com/');
                            break;
                        case 10:
                            window.open('http://tg.99.com/activity/jz/');
                            break;
                        case 11:
                            window.open('https://vipshop.99.com/Pay/Buy.aspx?GameClassID=111&mer=2');
                            break;
                        case 12:
                            window.open('http://jz.99.com/activity/aql/index.shtml');
                            break;
                        case 13:
                            window.open('http://www.yy.com/go.html#8154');
                            break;
                        case 14:
                            window.open('http://e.weibo.com/91jz?ref=http%3A%2F%2Fs.weibo.com%2Fweibo%2F%2525E6%25259C%2525BA%2525E6%252588%252598%26Refer%3DSTopic_box');
                            break;
                        case 15:
                            window.open('http://t.qq.com/ndzero');
                            break;
                        default:
                            break;
                    }
                } */
            </script>
            <script type="text/javascript">
                function switchTab(navID, onName, ctnID, order, obj) {
                    var rankArray = document.getElementById(navID).getElementsByTagName("li");
                    for (var i = 0; i < rankArray.length; i++) {
                        rankArray[i].className = "";
                        document.getElementById(ctnID + i).style.display = "none";
                    }
                    obj.className = onName;
                    document.getElementById(ctnID + order).style.display = "block";
                }
            </script>
    </body>
    </html>