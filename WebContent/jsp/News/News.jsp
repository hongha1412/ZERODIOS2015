<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.zerodios2015.Utils.MessageProperties"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.common-controls.com/cc/tags-template" prefix="template" %>
<%@ taglib uri="http://zerodios2015.com/Utils/ZDTags" prefix="ZDTags" %>

<template:insert template="/jsp/template/base.jsp">
    <template:put name="header">
        <script src="/plugin/datatables/datatables.js"></script>
        <link rel="stylesheet" type="text/css" href="/plugin/datatables/datatables.css" />
        <script src="/js/News.js"></script>
        <link rel="stylesheet" type="text/css" href="/css/News.css" />
    </template:put>
    <template:put name="content">
        <div class="function-area">
            <!-- TODO button new post with check permission -->
            <button class="btn"><%=MessageProperties.getMessage("news.NewTopic") %></button>
        </div>
        <div class="content-area">
            <div class="blank"></div>
            <div class="news-table">
                <table id="news-table" class="row-border" cellspacing="0" width="100%">
                    <ZDTags:listHeader tableName="News" align="center" />
                    <tbody>
                        <c:if test="${not empty outVO.lsNews}">
                            <c:forEach items="#{outVO.lsNews}" var="news">
                                <tr>
                                    <td class="hidden"><c:out value="${news.id}" /></td>
                                    <td class="hidden"><c:out value="${news.category}" /></td>
                                    <td class=""><c:out value="${news.remark}" /></td>
                                    <td class="link" width="50%">
                                        <a href="#">
                                            <c:out escapeXml="false" value="<div>${news.title}</div>" />
                                        </a>
                                    </td>
                                    <td class=""><c:out value="${news.author}" /></td>
                                    <td class=""><fmt:formatDate pattern="dd/MM/yyyy HH:mm:ss" value="${news.date}" /></td>
                                </tr>
                            </c:forEach>
                        </c:if>
                    </tbody>
                </table>
            </div>
        </div>
    </template:put>
</template:insert>