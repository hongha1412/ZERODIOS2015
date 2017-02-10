<%@page import="com.zerodios2015.Utils.MessageProperties"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.common-controls.com/cc/tags-template" prefix="template" %>
<template:insert template="/jsp/management/dashboard.jsp">
    <template:put name="header">
        <link href="/js/igniteui/css/themes/infragistics/infragistics.theme.css" rel="stylesheet" />
        <link href="/js/igniteui/css/structure/infragistics.css" rel="stylesheet" />
        <link href="/jsp/management/pagecss/newslist.css" rel="stylesheet" />
        <link rel="stylesheet" href="/jsp/management/js/select2/select2.css" type="text/css" />
        <link rel="stylesheet" href="/jsp/management/js/select2/theme.css" type="text/css" />
        <link rel="stylesheet" href="/jsp/management/js/fuelux/fuelux.css" type="text/css" />
        <link rel="stylesheet" href="/jsp/management/js/datepicker/datepicker.css" type="text/css" />
        <link rel="stylesheet" href="/jsp/management/js/slider/slider.css" type="text/css" />

        <!-- fuelux -->
        <script src="/jsp/management/js/fuelux/fuelux.js"></script>
        <!-- datepicker -->
        <script src="/jsp/management/js/datepicker/bootstrap-datepicker.js"></script>
        <!-- slider -->
        <script src="/jsp/management/js/slider/bootstrap-slider.js"></script>
        <!-- file input -->  
        <script src="/jsp/management/js/file-input/bootstrap-filestyle.min.js"></script>
        <!-- combodate -->
        <script src="/jsp/management/js/libs/moment.min.js"></script>
        <script src="/jsp/management/js/combodate/combodate.js"></script>
        <!-- select2 -->
        <script src="/jsp/management/js/select2/select2.min.js"></script>
        <!-- wysiwyg -->
        <script src="/jsp/management/js/wysiwyg/jquery.hotkeys.js"></script>
        <script src="/jsp/management/js/wysiwyg/bootstrap-wysiwyg.js"></script>
        <script src="/jsp/management/js/wysiwyg/demo.js"></script>
        <!-- markdown -->
        <script src="/jsp/management/js/markdown/epiceditor.min.js"></script>

        <script src="/jsp/management/pagejs/playerlist.js"></script>
        <script src="/js/igniteui/js/modernizr-2.8.3.js"></script>
        <script src="/js/igniteui/js/jquery-ui.min.js"></script>
        <script src="/js/igniteui/js/infragistics.core.js"></script>
        <script src="/js/igniteui/js/infragistics.dv.js"></script>
        <script src="/js/igniteui/js/infragistics.lob.js"></script>
    </template:put>
    <template:put name="content">
        <section class="vbox">
            <section class="scrollable padder">
              <section class="table panel panel-default">
                <header class="panel-heading">
                    <strong><%=MessageProperties.getMessage("players.PageName") %></strong>
                </header>
                <table id="news-table"></table>
              </section>
            </section>
        </section>
        <a href="#" class="hide nav-off-screen-block" data-toggle="class:nav-off-screen, open" data-target="#nav,html"></a>
    </template:put>
</template:insert>