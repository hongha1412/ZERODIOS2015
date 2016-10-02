<!DOCTYPE html>
<%@ page import="com.zerodios2015.Utils.MessageProperties"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.common-controls.com/cc/tags-template" prefix="template" %>
<%@ taglib uri="http://zerodios2015.com/Utils/ZDTags" prefix="ZDTags" %>
<html xmlns="http://www.w3.org/1999/xhtml"
    xmlns:h="http://java.sun.com/jsf/html"
    xmlns:com="http://xmlns.jcp.org/jsf/component" class="bg-dark">
<head>
    <jsp:include page="/jsp/management/inc/header.jsp" />

    <title>ZeroDios Management - Log In</title>
    <script src="/jsp/management/pagejs/index.js" ></script>
</head>
<body class="">
  <section id="content" class="m-t-lg wrapper-md animated fadeInUp">    
    <div class="container aside-xxl">
      <a class="navbar-brand block" href="#">ZeroDios Management Portal</a>
      <section id="message-area" class='<c:if test="${fn:length(messages) le 0}">hidden</c:if>'>
            <div class="alert alert-danger">
                <button type="button" class="close" data-dismiss="alert">&times;</button>
                <c:forEach items="${messages}" var="msg">
                    <c:set var="dataBind" value="click: function(data, event) { forceError(\'${msg.controlName}\', \'${msg.message}\') }" />
                    <div class="message-content" style="padding: 3px 0px 3px 0px" data-bind="<c:out escapeXml="false" value="${msg.controlName != '' ? dataBind : ''}" />">
                    <i class="fa fa-ban"></i>
                    <c:if test="${msg.controlName != '' }">
                        <c:out escapeXml="false" value="<a href='#' class='alert-link'>" />
                    </c:if> 
                    <strong><c:out value="${msg.message}" /></strong>
                    <c:if test="${msg.controlName != '' }">
                        <c:out escapeXml="false" value="</a>" />
                    </c:if>
                    </div>
                </c:forEach>
            </div>
      </section>
      <section class="panel panel-default bg-white m-t-lg">
        <header class="panel-heading text-center">
          <strong>Sign in</strong>
        </header>
        <form data-validate="parsley" id="login-form" class="panel-body wrapper-lg">
          <div class="form-group">
            <label class="control-label">Email</label>
            <input type="email" id="email" name="email" placeholder="test@example.com" data-required="true" data-type="email"
                data-bind="value: email" class="form-control input-lg">
          </div>
          <div class="form-group">
            <label class="control-label">Password</label>
            <input type="password" id="password" name="password" placeholder="Password" data-required="true"
                data-bind="value: password" data-minlength="6" data-maxlength="15" class="form-control input-lg">
          </div>
          <div class="checkbox">
            <label>
              <input type="checkbox" name="remember"> Keep me logged in
            </label>
          </div>
          <a href="#" class="pull-right m-t-xs"><small>Forgot password?</small></a>
          <button type="submit" data-bind="click: submit" class="btn btn-primary">Sign in</button>
        </form>
      </section>
    </div>
  </section>
  <!-- footer -->
  <footer id="footer">
    <div class="text-center padder">
      <p>
        <small>Web app framework base on Bootstrap<br>&copy; 2013</small>
      </p>
    </div>
  </footer>
  <!-- / footer -->
</body>
</html>