<!DOCTYPE html>
<%@ page import="com.zerodios2015.Utils.MessageProperties"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
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
      <section>
            <div class="alert alert-danger">
                <button type="button" class="close" data-dismiss="alert">&times;</button>
                <i class="fa fa-ban-circle"></i><strong>Oh snap!</strong> <a href="#" class="alert-link">Change a few things up</a> and try submitting again.
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