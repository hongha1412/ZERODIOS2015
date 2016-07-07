<%@page import="com.zerodios2015.DTO.MenuDTO"%>
<%@page import="org.springframework.web.context.request.RequestScope"%>
<%@page import="com.zerodios2015.Utils.MessageProperties"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.common-controls.com/cc/tags-template"
    prefix="template"%>

<fmt:setBundle basename="resource.MessageResources"/>
<c:set var="menuJs" value="onmouseover='dhmenuchg(this,1);' onmouseout='dhmenuchg(this,0);'"/>
<c:set var="level2" value="1" />
<c:set var="level3" value="1" />

<!-- Level 1 -->
<c:forEach items="${outVO.lsMenu}" var="menu">
    <c:choose>
        <c:when test="${fn:length(menu.lsChild) gt 0}">
            <c:out value="<li ${menuJs}>" escapeXml="false" />
        </c:when>
        <c:otherwise>
            <c:out value="<li>" escapeXml="false" />
        </c:otherwise>
    </c:choose>

    <a title="${menu.name}" href="${menu.link}" class="hidden">
        <fmt:message key="menu.${menu.name}" />
    </a>

    <c:if test="${fn:length(menu.lsChild) gt 0}">
        <!-- Level 2 -->
        <ul class='sed_nav sed_nav${level2}'>
        <c:set var="level2" value="${level2 + 1}" />
        <c:forEach items="${menu.lsChild}" var="menu2" varStatus="loop">
            <c:if test="${fn:length(menu2.lsChild) gt 0}">
                <c:out value="<span ${menuJs}>" escapeXml="false" />
            </c:if>

            <c:out value="<a title='${menu2.name}' href='${menu2.link}'>" escapeXml="false" />
                <fmt:message key="menu.${menu2.name}" />

            <c:out value="</a>" escapeXml="false" />
            <c:if test="${!loop.last}">
                <c:out value=" | " />
            </c:if>

            <c:if test="${fn:length(menu2.lsChild) gt 0}">
                <!-- Level 3 -->
                <ul class="third_nav third_nav${level3}">
                <c:out value="<span class='sharp'></span><div>" escapeXml="false" />
                <c:set var="level3" value="${level3 + 1}" />
                <c:forEach items="${menu2.lsChild}" var="menu3">
                    <c:out value="<a title='${menu3.name}' href='${menu3.link}'>" escapeXml="false" />
                        <fmt:message key="menu.${menu3.name}" />
                    <c:out value="</a> " escapeXml="false" />
                </c:forEach>
                <c:out value="</div>" escapeXml="false" />
                </ul>
                <c:out value="</span>" escapeXml="false" />
            </c:if>
        </c:forEach>
        </ul>
    </c:if>

    <c:out value="</li>" escapeXml="false" />
</c:forEach>