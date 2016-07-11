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
        <script src="/js/News.js"></script>
        <script src="/css/News.css"></script>
        <script src="/js/datatables/datatables.js"></script>
        <link rel="stylesheet" type="text/css" href="/js/datatables/datatables.css" />
    </template:put>
    <template:put name="content">
        <div class="function-area">
            <!-- TODO button new post with check permission -->
        </div>
        <div class="content-area">
            <div class="news-table">
                <table id="news-table">
                    <ZDTags:listHeader tableName="News" />
                    <tbody>
                        <c:if test="${not empty outVO.lsNews}">
                            <c:forEach items="#{outVO.lsNews}" var="news">
                                <tr>
                                    <td class="hidden"><c:out value="${news.id}" /></td>
                                    <td class="hidden"><c:out value="${news.category}" /></td>
                                    <td class=""><c:out value="${news.remark}" /></td>
                                    <td class="">
                                        <a href="#"><c:out value="${news.title}" /></a>
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