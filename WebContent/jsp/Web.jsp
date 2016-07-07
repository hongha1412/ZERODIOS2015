<%@page import="com.zerodios2015.VO.BaseOutVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>ZeroDios - ${outVO.title}</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="x-ua-compatible" content="ie=7">
    <link rel="SHORTCUT ICON" href="/images/jz426.ico">
    <script type="text/javascript" src="/js/public.js"></script>
    <link rel="stylesheet" type="text/css" href="/css/css_120514.css">
    <script type="text/javascript" src="/js/index_120514.js"></script>
    <style type="text/css">
        body {
            background-color: #221715;
        }
        .full_top {
            background: url(/images/full_top.jpg) center top no-repeat
        }
        .full_btm {
            background: url(/images/full_btm.jpg) center 383px no-repeat
        }
        .cont_b {
            background: url(images/con_b.jpg) center bottom no-repeat;
            padding: 5px 0 80px 25px
        }
        .box_b .tab_box .cmsTable td a {
            width: 225px;
            text-overflow: ellipsis;
            white-space: nowrap;
            overflow: hidden;
            display: inline-block;
        }
        .host_search {
            width: 630px;
            height: 271px;
        }
        .logo {
            position: absolute;
            left: 25px;
            top: 95px;
        }
        .logo img {
            width: 160px;
        }
        
        
        .full_top {
            background: url(images/full_top.jpg) center top no-repeat
        }
        .full_btm {
            background: url(images/full_btmg.jpg) center 383px no-repeat
        }
        .header1 {
            /*background: url(images/header_01g.jpg) no-repeat*/
        }
        .header2 {
            background: url(images/header_02.jpg) no-repeat
        }
        .header3 {
            background: url(images/header_03.jpg) no-repeat
        }
        .cont {
            background: url(images/cont_ms.jpg) no-repeat;
        }
        .cont_t {
            background: url(images/cont_t.jpg) no-repeat 1px 0;
            height: 440px
        }
        .cont_b {
            background: url(images/con_b.jpg) center bottom no-repeat;
            padding: 5px 0 80px 25px
        }
        .footer {
            background: url(images/footerg.jpg) center bottom no-repeat;
        }
    </style>
</head>

<body>
    <!--full_bg-->
    <div class="full_top">
        <div class="full_btm">
            <div class="wapper relative">
                <div class="header1 relative">
                    <h1 class="logo"><script type="text/javascript">logoimg();</script></h1>
                    <ul class="nav top-menu">
                        <!-- Menu Top -->
                        <jsp:include page="/jsp/Include/TopMenu.jsp"></jsp:include>
                    </ul>
                </div>
                <div class="header2"></div>
                <div class="header3"></div>
                <%--
                <div class="wapper cont_t relative large_ads">
                    <!-- Bottom Banner -->
                    <jsp:include page="/jsp/Include/BottomBanner.jsp"></jsp:include>
                </div>
                  --%>
                <div class="wapper content">
                    <!-- Web Content -->
                    <jsp:include page="${outVO.webContent}"></jsp:include>
                </div>

                <div class="radio" id="radio" style="display:none">
                    <a href="javascript:void(0);" onclick="document.getElementById('vedio').innerHTML = '';document.getElementById('radio').style.display='none';">X</a>
                    <div id="vedio">
                        <embed width="295" height="183" mwode="transparent" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer" wmode="transparent" quality="high" menu="false" allowscriptaccess="always" src="http://wj.down.99.com/files/etc/91vcastr.swf?vcastr_file=http://zy.down.99.com/gw/jz/jz_0515_1.flv&amp;IsAutoPlay=1&amp;IsContinue=0"> </div>
                </div>
                <div class="footer">
                    <!-- Footer -->
                    <jsp:include page="/jsp/Include/Footer.jsp"></jsp:include>
                </div>
            </div>
        </div>
    </div>
    <!--full_bgEnd-->
    <!--yy float-->
    <div id="YYbar" style="position: absolute; right: 20px; top: 15%; margin-top: 0px;">
        <a href="#" target="_blank"><img src="/images/yy.png">
        </a>
    </div>
    <script type="text/javascript" src="/js/jquery-1.8.3.min.js"></script>
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