<!DOCTYPE html>
<html lang="en" class="bg-dark">
<head>
    <jsp:include page="inc/header.jsp" />

    <title>ZeroDios Management - Log In</title>
</head>
<body class="">
  <section id="content" class="m-t-lg wrapper-md animated fadeInUp">    
    <div class="container aside-xxl">
      <a class="navbar-brand block" href="index.jsp">ZeroDios Management Portal</a>
      <section class="panel panel-default bg-white m-t-lg">
        <header class="panel-heading text-center">
          <strong>Sign in</strong>
        </header>
        <form action="dashboard.jsp" class="panel-body wrapper-lg">
          <div class="form-group">
            <label class="control-label">Email</label>
            <input type="email" placeholder="test@example.com" class="form-control input-lg">
          </div>
          <div class="form-group">
            <label class="control-label">Password</label>
            <input type="password" id="inputPassword" placeholder="Password" class="form-control input-lg">
          </div>
          <div class="checkbox">
            <label>
              <input type="checkbox"> Keep me logged in
            </label>
          </div>
          <a href="#" class="pull-right m-t-xs"><small>Forgot password?</small></a>
          <button type="submit" class="btn btn-primary">Sign in</button>
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